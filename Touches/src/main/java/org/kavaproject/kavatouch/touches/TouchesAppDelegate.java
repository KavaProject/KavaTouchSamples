package org.kavaproject.kavatouch.touches;

import org.kavaproject.kavatouch.Injector;
import org.kavaproject.kavatouch.coregraphics.GraphicsRect;
import org.kavaproject.kavatouch.foundation.FoundationTextAlignment;
import org.kavaproject.kavatouch.uikit.*;
import org.kavaproject.kavatouch.uikit.staging.IBOutlet;

import java.util.EnumSet;

public class TouchesAppDelegate implements UIApplicationDelegate, UIApplicationDelegate.Storyboarding {
    UIImageViewFactory imageViewFactory = Injector.getInstance().injectUIImageViewFactory();
    UIImageFactory imageFactory = Injector.getInstance().injectUIImageFactory();
    UILabelFactory labelFactory = Injector.getInstance().injectUILabelFactory();
    UIColorFactory colorFactory = Injector.getInstance().injectUIColorFactory();
    UIFontFactory fontFactory = Injector.getInstance().injectUIFontFactory();
    UIWindowFactory windowFactory = Injector.getInstance().injectUIWindowFactory();
    UIScreen mainScreen = Injector.getInstance().injectMainScreen();
    @IBOutlet
    private UIWindow window;

    @Override
    public UIWindow getWindow() {
        return window;
    }

    @Override
    public void setWindow(UIWindow value) {
        window = value;
    }

    @Override
    public boolean onWillFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean onDidFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        UIImageView yellowView = imageViewFactory.create(new GraphicsRect(10, 90, 100, 100));
        yellowView.setOpaque(false);
        yellowView.setClearsContextBeforeDrawing(false);
        yellowView.setUserInteractionEnabled(false);
        yellowView.setAlpha(0.9f);
        yellowView.setContentMode(UIViewContentMode.SCALE_ASPECT_FILL);
        yellowView.setImage(imageFactory.create("YellowSquare"));
        yellowView.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN, UIViewAutoresizing.FLEXIBLE_TOP_MARGIN,
                UIViewAutoresizing.FLEXIBLE_BOTTOM_MARGIN, UIViewAutoresizing.FLEXIBLE_WIDTH,
                UIViewAutoresizing.FLEXIBLE_HEIGHT));

        UIImageView cyanView = imageViewFactory.create(new GraphicsRect(110, 190, 100, 100));
        cyanView.setOpaque(false);
        cyanView.setClearsContextBeforeDrawing(false);
        cyanView.setUserInteractionEnabled(false);
        cyanView.setAlpha(0.9f);
        cyanView.setContentMode(UIViewContentMode.SCALE_ASPECT_FILL);
        cyanView.setImage(imageFactory.create("CyanSquare"));
        cyanView.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN, UIViewAutoresizing.FLEXIBLE_TOP_MARGIN,
                UIViewAutoresizing.FLEXIBLE_BOTTOM_MARGIN, UIViewAutoresizing.FLEXIBLE_WIDTH,
                UIViewAutoresizing.FLEXIBLE_HEIGHT));

        UIImageView magentaView = imageViewFactory.create(new GraphicsRect(210, 290, 100, 100));
        magentaView.setOpaque(false);
        magentaView.setClearsContextBeforeDrawing(false);
        magentaView.setUserInteractionEnabled(false);
        magentaView.setAlpha(0.9f);
        magentaView.setContentMode(UIViewContentMode.SCALE_ASPECT_FILL);
        magentaView.setImage(imageFactory.create("MagentaSquare"));
        magentaView.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN, UIViewAutoresizing.FLEXIBLE_TOP_MARGIN,
                UIViewAutoresizing.FLEXIBLE_BOTTOM_MARGIN, UIViewAutoresizing.FLEXIBLE_WIDTH,
                UIViewAutoresizing.FLEXIBLE_HEIGHT));

        UILabel touchPhaseText = labelFactory.create(new GraphicsRect(10, 24, 300, 21));
        touchPhaseText.setOpaque(false);
        touchPhaseText.setClipsToBounds(true);
        touchPhaseText.setUserInteractionEnabled(false);
        touchPhaseText.setContentMode(UIViewContentMode.SCALE_TO_FILL);
        touchPhaseText.setText("Touches lets you observe touch");
        touchPhaseText.setTextAlignment(FoundationTextAlignment.CENTER);
        touchPhaseText.setLineBreakMode(LineBreakMode.WORD_WRAP);
        touchPhaseText.setMinimumFontSize(10);
        touchPhaseText.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN, UIViewAutoresizing.FLEXIBLE_BOTTOM_MARGIN));
        touchPhaseText.setBackgroundColor(colorFactory.clear());
        touchPhaseText.setFont(fontFactory.systemFontOfSize(17));
        touchPhaseText.setTextColor(colorFactory.white());
        touchPhaseText.setHighlightedTextColor(null);

        UILabel touchTrackingText = labelFactory.create(new GraphicsRect(10, 45, 300, 21));
        touchTrackingText.setOpaque(false);
        touchTrackingText.setClipsToBounds(true);
        touchTrackingText.setUserInteractionEnabled(false);
        touchTrackingText.setContentMode(UIViewContentMode.SCALE_TO_FILL);
        touchTrackingText.setText("phases and multiple taps.");
        touchTrackingText.setTextAlignment(FoundationTextAlignment.CENTER);
        touchTrackingText.setLineBreakMode(LineBreakMode.WORD_WRAP);
        touchTrackingText.setMinimumFontSize(10);
        touchTrackingText.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN, UIViewAutoresizing.FLEXIBLE_BOTTOM_MARGIN));
        touchTrackingText.setBackgroundColor(colorFactory.clear());
        touchTrackingText.setFont(fontFactory.systemFontOfSize(17));
        touchTrackingText.setTextColor(colorFactory.white());
        touchTrackingText.setHighlightedTextColor(null);

        UILabel touchInfoText = labelFactory.create(new GraphicsRect(10, 66, 300, 21));
        touchInfoText.setOpaque(false);
        touchInfoText.setClipsToBounds(true);
        touchInfoText.setUserInteractionEnabled(false);
        touchInfoText.setContentMode(UIViewContentMode.SCALE_TO_FILL);
        touchInfoText.setTextAlignment(FoundationTextAlignment.CENTER);
        touchInfoText.setLineBreakMode(LineBreakMode.WORD_WRAP);
        touchInfoText.setMinimumFontSize(10);
        touchInfoText.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN, UIViewAutoresizing.FLEXIBLE_BOTTOM_MARGIN));
        touchInfoText.setBackgroundColor(colorFactory.clear());
        touchInfoText.setFont(fontFactory.systemFontOfSize(17));
        touchInfoText.setTextColor(colorFactory.white());
        touchInfoText.setHighlightedTextColor(null);

        UILabel touchInstructionsText = labelFactory.create(new GraphicsRect(10, 435, 300, 21));
        touchInstructionsText.setOpaque(false);
        touchInstructionsText.setClipsToBounds(true);
        touchInstructionsText.setUserInteractionEnabled(false);
        touchInstructionsText.setContentMode(UIViewContentMode.SCALE_TO_FILL);
        touchInstructionsText.setTextAlignment(FoundationTextAlignment.CENTER);
        touchInstructionsText.setLineBreakMode(LineBreakMode.WORD_WRAP);
        touchInstructionsText.setNumberOfLines(2);
        touchInstructionsText.setMinimumFontSize(10);
        touchInstructionsText.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_LEFT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN, UIViewAutoresizing.FLEXIBLE_TOP_MARGIN));
        touchInstructionsText.setBackgroundColor(colorFactory.clear());
        touchInstructionsText.setFont(fontFactory.systemFontOfSize(12));
        touchInstructionsText.setTextColor(colorFactory.white());
        touchInstructionsText.setHighlightedTextColor(null);

        MyView myView = new MyView(new GraphicsRect(0, 0, 320, 460));
        myView.setTouchPhaseText(touchPhaseText);
        myView.setTouchTrackingText(touchTrackingText);
        myView.setTouchInfoText(touchInfoText);
        myView.setTouchInstructionsText(touchInstructionsText);
        myView.setFirstPieceView(yellowView);
        myView.setSecondPieceView(cyanView);
        myView.setThirdPieceView(magentaView);

        myView.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_WIDTH, UIViewAutoresizing.FLEXIBLE_HEIGHT));
        myView.setAutoresizesSubviews(true);
        myView.setOpaque(true);
        myView.setClearsContextBeforeDrawing(false);
        myView.setMultipleTouchEnabled(true);
        myView.addSubview(touchPhaseText);
        myView.addSubview(touchTrackingText);
        myView.addSubview(touchInfoText);
        myView.addSubview(touchInstructionsText);
        myView.addSubview(yellowView);
        myView.addSubview(cyanView);
        myView.addSubview(magentaView);

        window = windowFactory.create(new GraphicsRect(0, 0, 320, 460));
        window.setAutoresizingMask(EnumSet.of(UIViewAutoresizing.FLEXIBLE_RIGHT_MARGIN,
                UIViewAutoresizing.FLEXIBLE_TOP_MARGIN));
        window.setAutoresizesSubviews(true);
        window.setBackgroundColor(colorFactory.darkText());
        window.setOpaque(false);
        window.setClearsContextBeforeDrawing(false);
        window.addSubview(myView);

        GraphicsRect frame = mainScreen.getApplicationFrame();
        window.setFrame(frame);
        window.makeKeyAndVisible();
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
