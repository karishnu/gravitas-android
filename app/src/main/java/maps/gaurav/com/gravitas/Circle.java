package maps.gaurav.com.gravitas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by Tushar Narula on 11/8/2015.
 */
public class Circle extends View {
    private static final int START_ANGLE_POINT = -90;

    private final Paint paint;
    private final RectF rect;

    private float angle;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);



        /*WindowManager wm = ((Activity)context).getWindowManager();
        Display d = wm.getDefaultDisplay();

        Point point = new Point();
        d.getSize(point);*/


        final int strokeWidth = 10;
        final int x = 72;

        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);

        //Circle color
        paint.setColor(Color.RED);

        //size 200x200 example
        //rect = new RectF(strokeWidth, strokeWidth,  + 300 + strokeWidth, 300 + strokeWidth);
        rect = new RectF(200, 500,  + 700 + 200, 700 + 500);
        //Initial Angle (optional, it can be zero)
        angle = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }


}
