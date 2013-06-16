package org.kavaproject.kavatouch.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Provides;
import org.kavaproject.kavatouch.DeviceHandle;
import org.kavaproject.kavatouch.coreanimation.AnimationLayerFactory;
import org.kavaproject.kavatouch.foundation.BundleFactory;
import org.kavaproject.kavatouch.foundation.FoundationStringFactory;
import org.kavaproject.kavatouch.foundation.NotificationCenter;
import org.kavaproject.kavatouch.internal.ScreenRedrawObserver;
import org.kavaproject.kavatouch.internal.SystemEventSource;
import org.kavaproject.kavatouch.runtime.MethodPerformer;
import org.kavaproject.kavatouch.runtime.MethodResolver;
import org.kavaproject.kavatouch.uikit.*;

import javax.inject.Singleton;

public class UIKitGuiceModule extends UIKitModule implements Module {
    @Override
    public void configure(Binder binder) {
    }

    @Override
    @Provides
    @Singleton
    public UIApplication provideSharedApplication(UIDevice currentUIDevice, MethodResolver methodResolver, MethodPerformer methodPerformer, UIApplicationWindows uiApplicationWindows) {
        return super.provideSharedApplication(currentUIDevice, methodResolver, methodPerformer, uiApplicationWindows);
    }

    @Override
    @Provides
    @Singleton
    public Session provideSession(NotificationCenter defaultNotificationCenter, SystemEventSource systemEventSource, ScreenRedrawObserver screenRedrawObserver, UIApplication sharedUIApplication, DeviceHandle deviceHandle) {
        return super.provideSession(defaultNotificationCenter, systemEventSource, screenRedrawObserver,
                sharedUIApplication, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public UIBezierPathFactory provideUIBezierPathFactory(UIGraphics uiGraphics) {
        return super.provideUIBezierPathFactory(uiGraphics);
    }

    @Override
    @Provides
    @Singleton
    public UIColorFactory provideUIColorFactory(UIImageFactory uiImageFactory, UIGraphics uiGraphics,
                                                DeviceHandle deviceHandle) {
        return super.provideUIColorFactory(uiImageFactory, uiGraphics, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public UIDevice provideCurrentUIDevice(UIDeviceFactory uiDeviceFactory) {
        return super.provideCurrentUIDevice(uiDeviceFactory);
    }

    @Override
    @Provides
    @Singleton
    public UIEventFactory provideUIEventFactory() {
        return super.provideUIEventFactory();
    }

    @Override
    @Provides
    @Singleton
    public UIFontFactory provideUIFontFactory() {
        return super.provideUIFontFactory();
    }

    @Override
    @Provides
    @Singleton
    public UIGraphics provideUIGraphics() {
        return super.provideUIGraphics();
    }

    @Override
    @Provides
    @Singleton
    public UIImageFactory provideUIImageFactory(BundleFactory bundleFactory, UIGraphics uiGraphics,
                                                FoundationStringFactory foundationStringFactory, DeviceHandle
            deviceHandle) {
        return super.provideUIImageFactory(bundleFactory, uiGraphics, foundationStringFactory, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public UIImageGraphics provideUIImageGraphics(UIGraphics uiGraphics, UIScreen mainScreen, UIImageFactory uiImageFactory) {
        return super.provideUIImageGraphics(uiGraphics, mainScreen, uiImageFactory);
    }

    @Override
    @Provides
    @Singleton
    public UIImageViewFactory provideUIImageViewFactory(AnimationLayerFactory animationLayerFactory,
                                                        UIGraphics uiGraphics, UIImageGraphics uiImageGraphics, UIColorFactory uiColorFactory, UIScreen mainScreen, MethodResolver methodResolver) {
        return super.provideUIImageViewFactory(animationLayerFactory, uiGraphics, uiImageGraphics, uiColorFactory,
                mainScreen, methodResolver);
    }

    @Override
    @Provides
    @Singleton
    public UILabelFactory provideUILabelFactory(UIFontFactory uiFontFactory,
                                                AnimationLayerFactory animationLayerFactory, UIGraphics uiGraphics,
                                                UIColorFactory uiColorFactory, UIScreen mainScreen, MethodResolver
            methodResolver, DeviceHandle deviceHandle) {
        return super.provideUILabelFactory(uiFontFactory, animationLayerFactory, uiGraphics, uiColorFactory,
                mainScreen, methodResolver, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public UINibFactory provideUINibFactory() {
        return super.provideUINibFactory();
    }

    @Override
    @Provides
    @Singleton
    public UIResponderFactory provideUIResponderFactory(MethodResolver methodResolver) {
        return super.provideUIResponderFactory(methodResolver);
    }

    @Override
    @Provides
    @Singleton
    public UIScreenFactory provideUIScreenFactory(UIApplication sharedUIApplication, NotificationCenter
            notificationCenter, UIScreenModeFactory uiScreenModeFactory, DeviceHandle deviceHandle) {
        return super.provideUIScreenFactory(sharedUIApplication, notificationCenter, uiScreenModeFactory, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public UIScreenModeFactory provideUIScreenModeFactory() {
        return super.provideUIScreenModeFactory();
    }

    @Override
    @Provides
    @Singleton
    public UITouchFactory provideUITouchFactory() {
        return super.provideUITouchFactory();
    }

    @Override
    @Provides
    @Singleton
    public UIViewControllerFactory provideUIViewControllerFactory(UIViewFactory uiViewFactory, MethodResolver methodResolver) {
        return super.provideUIViewControllerFactory(uiViewFactory, methodResolver);
    }

    @Override
    @Provides
    @Singleton
    public UIViewFactory provideUIViewFactory(AnimationLayerFactory animationLayerFactory, UIGraphics uiGraphics,
                                              UIColorFactory uiColorFactory, UIScreen mainScreen, MethodResolver
            methodResolver) {
        return super.provideUIViewFactory(animationLayerFactory, uiGraphics, uiColorFactory, mainScreen,
                methodResolver);
    }

    @Override
    @Provides
    @Singleton
    public UIWindowFactory provideUIWindowFactory(UIApplication sharedUIApplication, NotificationCenter
            defaultNotificationCenter, AnimationLayerFactory animationLayerFactory, UIGraphics uiGraphics,
                                                  UIColorFactory uiColorFactory, UIScreen mainScreen, MethodResolver methodResolver, UIApplicationWindows uiApplicationWindows, DeviceHandle deviceHandle) {
        return super.provideUIWindowFactory(sharedUIApplication, defaultNotificationCenter, animationLayerFactory, uiGraphics, uiColorFactory, mainScreen, methodResolver, uiApplicationWindows, deviceHandle);
    }

    @Override
    @Provides
    @Singleton
    public UIApplicationWindows provideUIApplicationWindows() {
        return super.provideUIApplicationWindows();
    }

    @Override
    @Provides
    @Singleton
    public UIScreen provideMainScreen(UIScreenFactory uiScreenFactory) {
        return super.provideMainScreen(uiScreenFactory);
    }

    @Override
    @Provides
    @Singleton
    public UIDeviceFactory provideUIDeviceFactory() {
        return super.provideUIDeviceFactory();
    }
}
