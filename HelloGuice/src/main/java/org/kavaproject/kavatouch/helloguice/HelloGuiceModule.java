package org.kavaproject.kavatouch.helloguice;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.kavaproject.kavatouch.DeviceHandle;
import org.kavaproject.kavatouch.uikit.*;

public class HelloGuiceModule implements Module {
    private final DeviceHandle mDeviceHandle;

    public HelloGuiceModule(DeviceHandle deviceHandle) {
        mDeviceHandle = deviceHandle;
    }

    @Override
    public void configure(Binder binder) {

    }

    @Provides
    public DeviceHandle provideDeviceHandle() {
        return mDeviceHandle;
    }

    @Inject
    @Provides
    public UIApplicationDelegate provideApplicationDelegate(UILabelFactory labelFactory,
                                                            UIWindowFactory windowFactory, UIScreen mainScreen,
                                                            UIColorFactory colorFactory) {
        return new HelloGuiceDelegate(labelFactory, windowFactory, mainScreen, colorFactory);
    }
}
