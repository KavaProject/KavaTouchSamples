package org.kavaproject.kavatouch.helloguice;

import android.app.Activity;
import android.os.Bundle;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.kavaproject.kavatouch.DeviceHandle;
import org.kavaproject.kavatouch.coreanimation.SurfaceViewAnimationEngine;
import org.kavaproject.kavatouch.guice.KavaTouchGuiceModules;
import org.kavaproject.kavatouch.uikit.Session;
import org.kavaproject.kavatouch.uikit.UIApplicationDelegate;

public class MainActivity extends Activity {
    private Injector injector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SurfaceViewAnimationEngine animationEngine = new SurfaceViewAnimationEngine(this) {
            @Override
            protected UIApplicationDelegate getDelegate() {
                return injector.getInstance(UIApplicationDelegate.class);
            }

            @Override
            public Session getSession(DeviceHandle deviceHandle) {
                injector = Guice.createInjector(KavaTouchGuiceModules.union(new HelloGuiceModule(deviceHandle)));
                return injector.getInstance(Session.class);
            }
        };
        setContentView(animationEngine);
    }
}
