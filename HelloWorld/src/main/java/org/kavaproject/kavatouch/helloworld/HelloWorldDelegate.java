package org.kavaproject.kavatouch.helloworld;

import org.kavaproject.kavatouch.Injector;
import org.kavaproject.kavatouch.coregraphics.GraphicsRect;
import org.kavaproject.kavatouch.foundation.FoundationTextAlignment;
import org.kavaproject.kavatouch.uikit.*;

import java.util.EnumSet;

public class HelloWorldDelegate implements UIApplicationDelegate, UIApplicationDelegate.Storyboarding {
    UILabelFactory labelFactory = Injector.getInstance().injectUILabelFactory();
    UIWindowFactory windowFactory = Injector.getInstance().injectUIWindowFactory();
    UIScreen mainScreen = Injector.getInstance().injectMainScreen();
    UIColorFactory colorFactory = Injector.getInstance().injectUIColorFactory();
    private UIWindow mWindow;

    @Override
    public UIWindow getWindow() {
        return mWindow;
    }

    @Override
    public void setWindow(UIWindow value) {
        mWindow = value;
    }

    @Override
    public boolean onWillFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean onDidFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        UILabel label = labelFactory.create(new GraphicsRect(100, 20, 120, 21));
        label.setText("Hello, World!");
        label.setTextAlignment(FoundationTextAlignment.CENTER);
        label.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN));
        mWindow = windowFactory.create(new GraphicsRect(0, 0, 320, 480));
        mWindow.addSubview(label);
        GraphicsRect frame = mainScreen.getApplicationFrame();
        mWindow.setFrame(frame);
        mWindow.setBackgroundColor(colorFactory.lightGray());
        mWindow.makeKeyAndVisible();
        return true;
    }

    @Override
    public void onDidBecomeActive(UIApplication application) {
    }

    @Override
    public void onWillResignActive(UIApplication application) {
    }

    @Override
    public void onDidEnterBackground(UIApplication application) {
    }

    @Override
    public void onWillEnterForeground(UIApplication application) {
    }

    @Override
    public void onWillTerminate(UIApplication application) {
    }
}
