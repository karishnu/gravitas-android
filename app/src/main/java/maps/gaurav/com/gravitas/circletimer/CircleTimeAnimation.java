package maps.gaurav.com.gravitas.circletimer;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class CircleTimeAnimation extends Animation {
    private Circle circle;

    private float oldAngle;
    private float newAngle;

    public CircleTimeAnimation(Circle circle, long newAngle) {

        this.oldAngle = circle.getAngle();
        this.newAngle = newAngle;
        this.circle = circle;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle;

        angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);
        circle.setAngle(angle);
        circle.requestLayout();
    }

}

