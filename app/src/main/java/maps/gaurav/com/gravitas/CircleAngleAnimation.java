package maps.gaurav.com.gravitas;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Tushar Narula on 11/8/2015.
 */
public class CircleAngleAnimation extends Animation {
    private Circle circle;

    private float oldAngle;
    private float newAngle;

    public CircleAngleAnimation(Circle circle, int newAngle) {
        this.oldAngle = circle.getAngle();
        this.newAngle = newAngle;
        this.circle = circle;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation transformation) {
        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);
        circle.setAngle(angle);
        circle.requestLayout();
    }

}
