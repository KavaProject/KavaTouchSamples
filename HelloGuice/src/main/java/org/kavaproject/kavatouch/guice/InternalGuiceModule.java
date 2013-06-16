package org.kavaproject.kavatouch.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.kavaproject.kavatouch.DeviceHandle;
import org.kavaproject.kavatouch.internal.InternalModule;
import org.kavaproject.kavatouch.internal.MotionEventHandler;
import org.kavaproject.kavatouch.internal.ScreenRedrawObserver;
import org.kavaproject.kavatouch.internal.SystemEventSource;
import org.kavaproject.kavatouch.uikit.UIApplication;
import org.kavaproject.kavatouch.uikit.UIEventFactory;
import org.kavaproject.kavatouch.uikit.UIScreen;
import org.kavaproject.kavatouch.uikit.UITouchFactory;

import javax.inject.Singleton;

public class InternalGuiceModule extends InternalModule implements Module {
    @Override
    public void configure(Binder binder) {
    }

    @Override
    @Provides
    @Singleton
    public SystemEventSource provideSystemEventSource(MotionEventHandler motionEventHandler, DeviceHandle
            deviceHandle) {
        return super.provideSystemEventSource(motionEventHandler, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public ScreenRedrawObserver provideScreenRedrawObserver(UIApplication sharedUIApplication, DeviceHandle
            deviceHandle) {
        return super.provideScreenRedrawObserver(sharedUIApplication, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public MotionEventHandler provideMotionEventHandler(UITouchFactory uiTouchFactory, UIEventFactory uiEventFactory, UIApplication sharedApplication, UIScreen mainScreen, DeviceHandle deviceHandle) {
        return super.provideMotionEventHandler(uiTouchFactory, uiEventFactory, sharedApplication, mainScreen, deviceHandle);
    }
}
