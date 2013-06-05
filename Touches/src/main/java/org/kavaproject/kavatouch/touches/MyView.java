package org.kavaproject.kavatouch.touches;

import org.kavaproject.kavatouch.Injector;
import org.kavaproject.kavatouch.coregraphics.GraphicsAffineTransform;
import org.kavaproject.kavatouch.coregraphics.GraphicsPoint;
import org.kavaproject.kavatouch.coregraphics.GraphicsRect;
import org.kavaproject.kavatouch.uikit.*;

import java.util.Set;

public class MyView extends DefaultUIView {
    // Determines how fast a piece size grows when it is moved.
    private static final float GROW_ANIMATION_DURATION_SECONDS = 0.15F;
    // Determines how fast a piece size shrinks when a piece stops moving.
    private static final float SHRINK_ANIMATION_DURATION_SECONDS = 0.15F;
    // Views the user can move
    private UIImageView firstPieceView;
    private UIImageView secondPieceView;
    private UIImageView thirdPieceView;
    private UILabel touchPhaseText; // Displays the touch phase
    private UILabel touchInfoText; // Displays touch information for  multiple taps
    private UILabel touchTrackingText; // Displays touch tracking information
    // Displays instructions for how to split apart pieces that are on top of each other
    private UILabel touchInstructionsText;
    private boolean piecesOnTop; // Keeps track of whether or not two or more pieces are on top of each other
    private GraphicsPoint startTouchPosition;

    public MyView(GraphicsRect frame) {
        super(frame, Injector.getInstance().injectUIViewFactory(), Injector.getInstance().injectUIGraphics(),
                Injector.getInstance().injectUIColorFactory(), Injector.getInstance().injectMainScreen(),
                Injector.getInstance().injectMethodResolver());
    }

    public UIImageView getFirstPieceView() {
        return firstPieceView;
    }

    public void setFirstPieceView(UIImageView value) {
        firstPieceView = value;
    }

    public UIImageView getSecondPieceView() {
        return secondPieceView;
    }

    public void setSecondPieceView(UIImageView value) {
        secondPieceView = value;
    }

    public UIImageView getThirdPieceView() {
        return thirdPieceView;
    }

    public void setThirdPieceView(UIImageView value) {
        thirdPieceView = value;
    }

    public UILabel getTouchPhaseText() {
        return touchPhaseText;
    }

    public void setTouchPhaseText(UILabel value) {
        touchPhaseText = value;
    }

    public UILabel getTouchInfoText() {
        return touchInfoText;
    }

    public void setTouchInfoText(UILabel value) {
        touchInfoText = value;
    }

    public UILabel getTouchTrackingText() {
        return touchTrackingText;
    }

    public void setTouchTrackingText(UILabel value) {
        touchTrackingText = value;
    }

    public UILabel getTouchInstructionsText() {
        return touchInstructionsText;
    }

    public void setTouchInstructionsText(UILabel value) {
        touchInstructionsText = value;
    }

    // Handles the start of a touch
    @Override
    public void onTouchesBegan(Set<UITouch> touches, UIEvent event) {
        int numTaps = touches.iterator().next().getTapCount();
        touchPhaseText.setText("Phase: Touches began");
        touchInfoText.setText("");
        if (numTaps >= 2) {
            touchInfoText.setText(numTaps + " taps");
            if ((numTaps == 2) && piecesOnTop) {
                // A double tap positions the three pieces in a diagonal.
                // The user will want to double tap when two or more pieces are on top of each other
                if (firstPieceView.getCenter().x == secondPieceView.getCenter().x)
                    secondPieceView.setCenter(new GraphicsPoint(firstPieceView.getCenter().x - 50,
                            firstPieceView.getCenter().y - 50));
                if (firstPieceView.getCenter().x == thirdPieceView.getCenter().x)
                    thirdPieceView.setCenter(new GraphicsPoint(firstPieceView.getCenter().x + 50,
                            firstPieceView.getCenter().y + 50));
                if (secondPieceView.getCenter().x == thirdPieceView.getCenter().x)
                    thirdPieceView.setCenter(new GraphicsPoint(secondPieceView.getCenter().x + 50,
                            secondPieceView.getCenter().y + 50));
                touchInstructionsText.setText("");
            }
        } else {
            touchTrackingText.setText("");
        }
        // Enumerate through all the touch objects.
        int touchCount = 0;
        for (UITouch touch : touches) {
            // Send to the dispatch method, which will make sure the appropriate subview is acted upon
            dispatchFirstTouchAtPointForEvent(touch.locationInView(this), null);
            touchCount++;
        }
    }

    ///Touch handling///

    // Handles the continuation of a touch.
    @Override
    public void onTouchesMoved(Set<UITouch> touches, UIEvent event) {
        int touchCount = 0;
        touchPhaseText.setText("Phase: Touches moved");
        // Enumerates through all touch objects
        for (UITouch touch : touches) {
            // Send to the dispatch method, which will make sure the appropriate subview is acted upon
            dispatchTouchEventToPosition(touch.getView(), touch.locationInView(this));
            touchCount++;
        }
        // When multiple touches, report the number of touches.
        if (touchCount > 1) {
            touchTrackingText.setText("Tracking " + touchCount + " touches");
        } else {
            touchTrackingText.setText("Tracking 1 touch");
        }
    }

    // Handles the end of a touch event.
    @Override
    public void onTouchesEnded(Set<UITouch> touches, UIEvent event) {
        touchPhaseText.setText("Phase: Touches ended");
        // Enumerates through all touch object
        for (UITouch touch : touches) {
            // Sends to the dispatch method, which will make sure the appropriate subview is acted upon
            dispatchTouchEndEventToPosition(touch.getView(), touch.locationInView(this));
        }
    }

    @Override
    public void onTouchesCancelled(Set<UITouch> touches, UIEvent event) {
        touchPhaseText.setText("Phase: Touches cancelled");
        // Enumerates through all touch object
        for (UITouch touch : touches) {
            // Sends to the dispatch method, which will make sure the appropriate subview is acted upon
            dispatchTouchEndEventToPosition(touch.getView(), touch.locationInView(this));
        }
    }

    // Checks to see which view, or views,  the point is in and then calls a method to perform the closing animation,
    // which is to return the piece to its original size, as if it is being put down by the user.
    private void dispatchTouchEndEventToPosition(UIView theView, GraphicsPoint position) {
        // Check to see which view, or views,  the point is in and then animate to that position.
        if (firstPieceView.getFrame().contains(position)) {
            animateViewToPosition(firstPieceView, position);
        }
        if (secondPieceView.getFrame().contains(position)) {
            animateViewToPosition(secondPieceView, position);
        }
        if (thirdPieceView.getFrame().contains(position)) {
            animateViewToPosition(thirdPieceView, position);
        }
        // If one piece obscures another, display a message so the user can move the pieces apart
        if (firstPieceView.getCenter().equals(secondPieceView.getCenter()) ||
                firstPieceView.getCenter().equals(thirdPieceView.getCenter()) ||
                secondPieceView.getCenter().equals(thirdPieceView.getCenter())) {
            touchInstructionsText.setText("Double tap the background to move the pieces apart.");
            piecesOnTop = true;
        } else {
            piecesOnTop = false;
        }
    }

    // Scales down the view and moves it to the new position.
    private void animateViewToPosition(UIView theView, GraphicsPoint thePosition) {
        getFactory().beginAnimations(null, null);
        getFactory().setAnimationDuration(SHRINK_ANIMATION_DURATION_SECONDS);
        // Set the center to the final postion
        theView.setCenter(thePosition);
        // Set the transform back to the identity, thus undoing the previous scaling effect.
        theView.setTransform(GraphicsAffineTransform.IDENTITY());
        getFactory().commitAnimations();
    }

    // Checks to see which view, or views, the point is in and then sets the center of each moved view to the new
    // postion.
    // If views are directly on top of each other, they move together.
    private void dispatchTouchEventToPosition(UIView theView, GraphicsPoint position) {
        // Check to see which view, or views,  the point is in and then move to that position.
        if (firstPieceView.getFrame().contains(position)) {
            firstPieceView.setCenter(position);
        }
        if (secondPieceView.getFrame().contains(position)) {
            secondPieceView.setCenter(position);
        }
        if (thirdPieceView.getFrame().contains(position)) {
            thirdPieceView.setCenter(position);
        }
    }

    // Checks to see which view, or views, the point is in and then calls a method to perform the opening animation,
    // which  makes the piece slightly larger, as if it is being picked up by the user.
    private void dispatchFirstTouchAtPointForEvent(GraphicsPoint touchPoint, UIEvent event) {
        if (firstPieceView.getFrame().contains(touchPoint)) {
            animateFirstTouchAtPointForView(touchPoint, firstPieceView);
        }
        if (secondPieceView.getFrame().contains(touchPoint)) {
            animateFirstTouchAtPointForView(touchPoint, secondPieceView);
        }
        if (thirdPieceView.getFrame().contains(touchPoint)) {
            animateFirstTouchAtPointForView(touchPoint, thirdPieceView);
        }
    }

    // Scales up a view slightly which makes the piece slightly larger, as if it is being picked up by the user.
    private void animateFirstTouchAtPointForView(GraphicsPoint touchPoint, UIImageView theView) {
        // Pulse the view by scaling up, then move the view to under the finger.
        getFactory().beginAnimations(null, null);
        getFactory().setAnimationDuration(GROW_ANIMATION_DURATION_SECONDS);
        theView.setTransform(GraphicsAffineTransform.makeScale(1.2f, 1.2f));
        getFactory().commitAnimations();
    }
}
