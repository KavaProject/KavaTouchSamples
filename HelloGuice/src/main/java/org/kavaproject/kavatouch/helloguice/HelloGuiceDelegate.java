package org.kavaproject.kavatouch.helloguice;

import org.kavaproject.kavatouch.coregraphics.GraphicsRect;
import org.kavaproject.kavatouch.foundation.FoundationTextAlignment;
import org.kavaproject.kavatouch.uikit.*;

import org.kavaproject.kavatouch.util.inject.Inject;
import java.util.EnumSet;

public class HelloGuiceDelegate implements UIApplicationDelegate, UIApplicationDelegate.Storyboarding {
    protected final UILabelFactory labelFactory;
    protected final UIWindowFactory windowFactory;
    protected final UIScreen mainScreen;
    protected final UIColorFactory colorFactory;
    private UIWindow mWindow;

    @Inject
    HelloGuiceDelegate(UILabelFactory labelFactory, UIWindowFactory windowFactory, UIScreen mainScreen,
                       UIColorFactory colorFactory) {
        this.labelFactory = labelFactory;
        this.windowFactory = windowFactory;
        this.mainScreen = mainScreen;
        this.colorFactory = colorFactory;
    }

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
