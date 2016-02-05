package maps.gaurav.com.gravitas.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import maps.gaurav.com.gravitas.R;
import maps.gaurav.com.gravitas.circletimer.Circle;
import maps.gaurav.com.gravitas.circletimer.CircleTimeAnimation;

//>>added for transition/animation

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Circle circle;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        //for seconds timer
        circle = (Circle) view.findViewById(R.id.circle);
        secondsTimer(view);


        new CountDownTimer(6000 * 60 * 60 * 24, 1000 * 60 * 60 * 24) {
            @Override
            public void onTick(long millisUntilFinished) {
                millisUntilFinished /= (1000 * 60 * 60 * 24);
                //FORMATTED OUTPUT of 2 character length
                final String formatteddays = String.format("%02d", millisUntilFinished);
                int days = Integer.parseInt(formatteddays);
                int days1 = days/10;
                int days2 = days%10;
                flip(view, days1, 1);
                flip(view, days2, 2);
                new CountDownTimer(24000 * 60 * 60, 1000 * 60 * 60) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        millisUntilFinished /= (1000 * 60 * 60);
                        //FORMATTED OUTPUT of 2 character length
                        String formattedhours = String.format("%02d", millisUntilFinished);
                        int hrs = Integer.parseInt(formattedhours);
                        int hrs1 = hrs/10;
                        int hrs2 = hrs%10;
                        flip(view, hrs1, 3);
                        flip(view, hrs2, 4);
                        new CountDownTimer(60000 * 60, 1000 * 60) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                millisUntilFinished /= (1000 * 60);
                                //FORMATTED OUTPUT of 2 character length
                                String formattminutes = String.format("%02d", millisUntilFinished);
                                int mins = Integer.parseInt(formattminutes);
                                int mins1 = mins/10;
                                int mins2 = mins%10;
                                flip(view, mins1,5);
                                flip(view, mins2,6);
                                new CountDownTimer(60000, 1000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        millisUntilFinished /= 1000;
                                        //FORMATTED OUTPUT of 2 character length
                                        String formatsecs = String.format("%02d", millisUntilFinished);
                                        int secs = Integer.parseInt(formatsecs);
                                        int secs1 = secs/10;
                                        int secs2 = secs%10;
                                        flip(view, secs1,7);
                                        flip(view, secs2,8);
                                    }

                                    @Override
                                    public void onFinish() {
                                    }
                                }.start();
                            }

                            @Override
                            public void onFinish() {
                            }
                        }.start();

                    }

                    @Override
                    public void onFinish(){
                    }
                }.start();
            }

            @Override
            public void onFinish() {
            }
        }.start();
        return view;
    }

    private void secondsTimer(View view) {

        CircleTimeAnimation animation = new CircleTimeAnimation(circle, 360);
        animation.setDuration(60000);
        animation.setRepeatCount(Animation.INFINITE);
        circle.startAnimation(animation);
    }

    public void flip(final View v, int changeNumber, final int ithclock) {
        //int upperBackId = R.id.up_back;
        String compUpperBackID = "up_back" + ithclock;
        int upperBackId = getResources().getIdentifier(compUpperBackID,"id",getContext().getPackageName());
        final ImageView up_back = (ImageView) v.findViewById(upperBackId);
        Drawable img = up_back.getDrawable();

        String compUpperID = "up" + ithclock;
        int upperId = getResources().getIdentifier(compUpperID,"id",getContext().getPackageName());
        final ImageView up = (ImageView) v.findViewById(upperId);
        up.setImageDrawable(img);
        up.setVisibility(View.INVISIBLE);

        String compDownID = "down" + ithclock;
        int downId = getResources().getIdentifier(compDownID,"id",getContext().getPackageName());
        final ImageView down = (ImageView) v.findViewById(downId);
        // down.getLayoutParams().height = 0;
        down.setVisibility(View.INVISIBLE);

        int resId = getResources().getIdentifier("up_" + changeNumber,
                "drawable", getContext().getPackageName());
        Drawable image = getResources().getDrawable(resId);
        up_back.setImageDrawable(image);

        resId = getResources().getIdentifier("down_" + changeNumber,
                "drawable", getContext().getPackageName());
        image = getResources().getDrawable(resId);
        down.setImageDrawable(image);

        Animation anim = new ScaleAnimation(1f, 1f, // Start and end values for
                // the X axis scaling
                1f, 0f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, 0f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 1f); // Pivot point of Y scaling
        anim.setDuration(100);
        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animation anim = new ScaleAnimation(1f, 1f, 0f, 1f,
                        Animation.RELATIVE_TO_SELF, 0f,
                        Animation.RELATIVE_TO_SELF, 0f);

                anim.setDuration(200);
                anim.setAnimationListener(new Animation.AnimationListener() {

                    @Override
                    public void onAnimationStart(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // TODO Auto-generated method stub

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        String compDownBackID = "down_back" + ithclock;
                        int downbackId = getResources().getIdentifier(compDownBackID,"id",getContext().getPackageName());
                        final ImageView back_down = (ImageView) v.findViewById(downbackId);

                        //ImageView back_down = (ImageView) getView().findViewById(R.id.down_back);
                        back_down.setImageDrawable(down.getDrawable());
                    }
                });
                down.startAnimation(anim);

            }
        });
        up.startAnimation(anim);

    }// end flip

}