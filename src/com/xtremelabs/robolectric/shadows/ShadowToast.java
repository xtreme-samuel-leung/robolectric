package com.xtremelabs.robolectric.shadows;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.xtremelabs.robolectric.util.Implementation;
import com.xtremelabs.robolectric.util.Implements;
import com.xtremelabs.robolectric.util.RealObject;

import java.util.ArrayList;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;

/**
 * Shadow of {@code Toast} that tracks {@code Toast} requests. Hear hear! (*clink*)
 */
@SuppressWarnings({"UnusedDeclaration"})
@Implements(Toast.class)
public class ShadowToast {
    private static ArrayList<Toast> shownToasts = new ArrayList<Toast>();

    private String text;
    private int gravity;
    private View view;

    @RealObject Toast toast;

    @Implementation
    public static Toast makeText(Context context, int resId, int duration) {
        return makeText(context, context.getResources().getString(resId), duration);
    }

    @Implementation
    public static Toast makeText(Context context, CharSequence text, int duration) {
        Toast toast = new Toast(null);
        shadowOf(toast).text = text.toString();
        return toast;
    }

    @Implementation
    public void show() {
        shownToasts.add(toast);
    }

    @Implementation
    public void setView(View view) {
        this.view = view;
    }

    @Implementation
    public View getView() {
        return view;
    }

    @Implementation
    public void setGravity(int gravity, int xOffset, int yOffset) {
        this.gravity = gravity;
    }

    @Implementation
    public int getGravity() {
        return gravity;
    }

    /**
     * Non-Android accessor that discards the recorded {@code Toast}s
     */
    public static void reset() {
        shownToasts.clear();
    }

    /**
     * Non-Android accessor that returns the number of {@code Toast} requests that have been made during this test run
     * or since {@link #reset()} has been called.
     *
     * @return the number of {@code Toast} requests that have been made during this test run
     * or since {@link #reset()} has been called.
     */
    public static int shownToastCount() {
        return shownToasts.size();
    }

    /**
     * Non-Android query method that returns whether or not a particular custom {@code Toast} has been shown.
     *
     * @param message the message to search for
     * @param layoutResourceIdToCheckForMessage the id of the resource that contains the toast messages
     * @return whether the {@code Toast} was requested
     */
    public static boolean showedCustomToast(CharSequence message, int layoutResourceIdToCheckForMessage) {
        for (Toast toast : shownToasts) {
            String text = ((TextView) toast.getView().findViewById(layoutResourceIdToCheckForMessage)).getText().toString();
            if (text.equals(message.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * query method that returns whether or not a particular {@code Toast} has been shown.
     *
     * @param message the message to search for
     * @return whether the {@code Toast} was requested
     */
    public static boolean showedToast(CharSequence message) {
        for (Toast toast : shownToasts) {
            String text = shadowOf(toast).text;
            if (text != null && text.equals(message.toString())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Non-Android accessor that returns the text of the most recently shown {@code Toast}
     *
     * @return the text of the most recently shown {@code Toast}
     */
    public static String getTextOfLatestToast() {
        return shadowOf(shownToasts.get(0)).text;
    }

    /**
     * Non-Android accessor that returns the most recently shown {@code Toast}
     *
     * @return the most recently shown {@code Toast}
     */
    public static Toast getLatestToast() {
        return shownToasts.get(shownToasts.size() - 1);
    }
}
