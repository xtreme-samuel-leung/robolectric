package com.xtremelabs.robolectric.shadows;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import com.xtremelabs.robolectric.R;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.WithTestDefaultsRunner;
import com.xtremelabs.robolectric.res.ResourceLoader;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(WithTestDefaultsRunner.class)
public class ResourcesTest {
    @Test(expected = Resources.NotFoundException.class)
    public void getStringArray_shouldThrowExceptionIfNotFound() throws Exception {
        Robolectric.bindDefaultShadowClasses();
        Robolectric.application = ShadowApplication.bind(new Application(), new ResourceLoader(R.class, new File("test/res")));

        new Activity().getResources().getStringArray(-1);
    }
}
