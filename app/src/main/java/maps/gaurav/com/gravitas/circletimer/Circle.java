package maps.gaurav.com.gravitas.circletimer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import maps.gaurav.com.gravitas.R;

/**
 * Created by HP on 09-01-2016.
 */
public class Circle extends View {
    private static final int START_ANGLE_POINT = -90;

    private final Paint paintShadow;
    private Paint paintTimer = null;
    private final RectF rect;
    private int color;
    private int color2;
    private float angle;


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();

        display.getSize(size);
        int width = size.x;
        int height = size.y;

        final int strokeWidth = 20;
        final int x = (width/2)-10;

        paintShadow = new Paint();
        paintTimer = new Paint();
        paintShadow.setAntiAlias(true);
        paintShadow.setStyle(Paint.Style.STROKE);
        paintShadow.setStrokeWidth(strokeWidth);
        paintTimer.setAntiAlias(true);
        paintTimer.setStyle(Paint.Style.STROKE);
        paintTimer.setStrokeWidth(strokeWidth);

        Resources r = getResources();

        //Circle color
        color = r.getColor(R.color.timerBackground);
        color2 = r.getColor(R.color.timer);

        //rect = new RectF(left , top,  right, bottom);
        rect = new RectF(20, ((height*2)/3)-x-60, width-20 ,((height*2)/3)+x-60);

        //Initial Angle
        angle = 0;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paintShadow.setColor(color);
        paintTimer.setColor(color2);
        canvas.drawArc(rect,-90,360,false,paintShadow);
        canvas.drawArc(rect, START_ANGLE_POINT, angle, false, paintTimer);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }


}


