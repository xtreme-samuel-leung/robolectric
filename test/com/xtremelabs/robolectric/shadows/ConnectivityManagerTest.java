package com.xtremelabs.robolectric.shadows;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.WithTestDefaultsRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(WithTestDefaultsRunner.class)
public class ConnectivityManagerTest {
    private ConnectivityManager connectivityManager;
    private ShadowNetworkInfo networkInfo;

    @Before
    public void setUp() throws Exception {
        Robolectric.bindDefaultShadowClasses();
        Robolectric.application = new Application();
        connectivityManager = (ConnectivityManager) Robolectric.application.getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = Robolectric.shadowOf(connectivityManager.getActiveNetworkInfo());
    }

    @Test
    public void getConnectivityManagerShouldNotBeNull() {
    	assertNotNull(connectivityManager);
    	assertNotNull(connectivityManager.getActiveNetworkInfo());
    }

    @Test
    public void networkInfoShouldReturnTrueCorrectly() {
    	networkInfo.setConnectionStatus(true);

    	assertTrue(connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting());
    }

    @Test
    public void networkInfoShouldReturnFalseCorrectly() {
    	networkInfo.setConnectionStatus(false);

    	assertFalse(connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting());
    }
}
