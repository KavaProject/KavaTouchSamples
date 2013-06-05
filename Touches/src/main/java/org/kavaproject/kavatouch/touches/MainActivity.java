package org.kavaproject.kavatouch.touches;

import android.app.Activity;
import android.os.Bundle;
import org.kavaproject.kavatouch.DeviceHandle;
import org.kavaproject.kavatouch.Injector;
import org.kavaproject.kavatouch.coreanimation.SurfaceViewAnimationEngine;
import org.kavaproject.kavatouch.uikit.Session;
import org.kavaproject.kavatouch.uikit.UIApplicationDelegate;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SurfaceViewAnimationEngine animationEngine = new SurfaceViewAnimationEngine(this) {
            @Override
            public Session getSession(DeviceHandle deviceHandle) {
                Injector.setInstance(new Injector(deviceHandle));
                return Injector.getInstance().injectSession();
            }

            @Override
            protected UIApplicationDelegate getDelegate() {
                return new TouchesAppDelegate();
            }
        };
        setContentView(animationEngine);
    }
}
