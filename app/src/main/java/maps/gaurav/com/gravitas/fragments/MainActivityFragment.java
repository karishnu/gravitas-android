package maps.gaurav.com.gravitas.fragments;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

//>>added for transition/animation
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import java.util.logging.Handler;

import maps.gaurav.com.gravitas.Circle;
import maps.gaurav.com.gravitas.CircleAngleAnimation;
import maps.gaurav.com.gravitas.R;
import maps.gaurav.com.gravitas.activities.MainActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    TextView seconds, minutes, hours, days, t;
    ImageView rruelem,mmuelem,lluelem,ssuelem;
    Boolean animcompdd,animcomphh,animcompmm,animcompss;
    Activity mact = new Activity();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        seconds = (TextView)view.findViewById(R.id.tvSeconds);
        minutes = (TextView)view.findViewById(R.id.tvMinutes);
        hours=(TextView)view.findViewById(R.id.tvHours);
        days=(TextView)view.findViewById(R.id.tvDays);
        //REFERRALS TO THE IMAGEVIEWS::UPPER ELEMENTS(to implement bringtofront method)
        rruelem = (ImageView)view.findViewById(R.id.imgrruid);
        mmuelem = (ImageView)view.findViewById(R.id.imgmmuid);
        lluelem = (ImageView)view.findViewById(R.id.imglluid);
        ssuelem = (ImageView)view.findViewById(R.id.imgssuid);
        //^^
        //>>ADDED FOR TRANSITION/ANIMATION
        final ImageView uppanelr = (ImageView) view.findViewById(R.id.imgrruid);
        final Animation uppaneldownr = AnimationUtils.loadAnimation(view.getContext(),R.anim.clock_transition);
        final ImageView uppanelm = (ImageView) view.findViewById(R.id.imgmmuid);
        final Animation uppaneldownm = AnimationUtils.loadAnimation(view.getContext(),R.anim.clock_transition);
        final ImageView uppanell = (ImageView) view.findViewById(R.id.imglluid);
        final Animation uppaneldownl = AnimationUtils.loadAnimation(view.getContext(),R.anim.clock_transition);
        final ImageView uppanels = (ImageView) view.findViewById(R.id.imgssuid);
        final Animation uppaneldowns = AnimationUtils.loadAnimation(view.getContext(),R.anim.clock_transition);
        //^^

        Circle circle = (Circle) view.findViewById(R.id.circle);

        int t = 0;

        while(t!=60000){
            int f = (1+t*4/60000)*90;
            CircleAngleAnimation animation = new CircleAngleAnimation(circle,f);
            animation.setDuration(60000);
            circle.startAnimation(animation);
            t = t+15000;
        }

        //CircleAngleAnimation animation = new CircleAngleAnimation(circle,f);
        //animation.setDuration(60000);


        //Naming::note.referring day with left, hours with middle, minutes with right, and seconds with SECONDS.

        new CountDownTimer(6000*60*60*24,1000*60*60*24){
            @Override
            public void onTick(long millisUntilFinished) {
                millisUntilFinished/=(1000*60*60*24);
                //FORMATTED OUTPUT of 2 character length
                String formatteddays = String.format("%02d", millisUntilFinished);
                days.setText(""+formatteddays);
                //^^
                //>>ADDED FOR TRANSITION/ANIMATION
                if(days.getText()!=""+formatteddays)
                {
                    lluelem.bringToFront();
                    uppanell.startAnimation(uppaneldownl);
                    animcompdd = true;
                }
                else animcompdd=false;
                if(animcompdd)
                {
                    startanimdd();
                }
                //^^
                new CountDownTimer(24000*60*60,1000*60*60){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        millisUntilFinished/=(1000*60*60);
                        //FORMATTED OUTPUT of 2 character length
                        String formattedhours = String.format("%02d", millisUntilFinished);
                        hours.setText(""+formattedhours);
                        //^^
                        //>>ADDED FOR TRANSITION/ANIMATION
                        if(hours.getText()!=""+formattedhours)
                        {
                            mmuelem.bringToFront();
                            uppanelm.startAnimation(uppaneldownm);
                            animcomphh = true;
                        }
                        else animcomphh = false;
                        if(animcomphh)
                        {
                            startanimhh();
                        }
                        //^^
                        new CountDownTimer(60000*60,1000*60){
                            @Override
                            public void onTick(long millisUntilFinished) {
                                millisUntilFinished/=(1000*60);
                                //FORMATTED OUTPUT of 2 character length
                                String formattminutes = String.format("%02d", millisUntilFinished);
                                minutes.setText(""+formattminutes);
                                //>>ADDED FOR TRANSITION/ANIMATION
                                if(minutes.getText()!=""+millisUntilFinished)
                                {
                                    rruelem.bringToFront();
                                    uppanelr.startAnimation(uppaneldownr);
                                    animcompmm = true;
                                }
                                else animcompmm = false;
                                if(animcompmm)
                                {
                                    startanimmm();
                                }
                                //^^
                                new CountDownTimer(60000,1000){
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        millisUntilFinished/=1000;
                                        //FORMATTED OUTPUT of 2 character length
                                        String formatsecs = String.format("%02d", millisUntilFinished);
                                        seconds.setText(""+formatsecs);
                                        //>>ADDED FOR TRANSITION/ANIMATION
                                        if(seconds.getText()!=""+formatsecs)
                                        {

                                            /*uppanels.startAnimation(uppaneldowns);
                                            try{
                                                Thread.sleep(40);
                                                getActivity().runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        ssuelem.bringToFront();
                                                    }
                                                });
                                            }catch (InterruptedException e){e.printStackTrace();}


                                            animcompss = true;*/
                                            ssuelem.bringToFront();
                                            uppanels.startAnimation(uppaneldowns);
                                            animcompss = true;
                                        }
                                        else animcompss = false;
                                        if(animcompss)
                                        {
                                            startanimss();
                                        }
                                        //^^
                                    }

                                    @Override
                                    public void onFinish() {
                                        seconds.setText("00");
                                    }
                                }.start();
                            }
                            @Override
                            public void onFinish() {
                                minutes.setText("00");
                            }
                        }.start();

                    }

                    @Override
                    public void onFinish() {
                        hours.setText("00");
                    }
                }.start();
            }
            @Override
            public void onFinish() {
                days.setText("00");
            }
        }.start();
        return view;
    }


    //ToDO create a new value with 160 to maintain consistency between the animation(inside clock_transition.xml) and 160ms used below
    //ToDO create a generic method that receives the parameter of what to change(look below)
    /*public void startanim()
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(160);
                    //remember: runOnUiThread can be accessed through Activity only.
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            t.bringToFront();
                        }
                    });
                    //Need to change the Interface element seconds, hence the following method(runOnUiThread)
                }catch (InterruptedException e){e.printStackTrace();}
            }
        };Thread waitthenbringfront = new Thread(r);
        waitthenbringfront.start();
    }*/
    public void startanimss()
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(150);
                    //remember: runOnUiThread can be accessed through Activity only.
                    mact.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            seconds.bringToFront();
                        }
                    });
                    //Need to change the Interface element seconds, hence the following method(runOnUiThread)
                }catch (InterruptedException e){e.printStackTrace();}
            }
        };Thread waitthenbringfront = new Thread(r);
        waitthenbringfront.start();
    }
    public void startanimmm()
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(150);
                    //remember: runOnUiThread can be accessed through Activity only.
                    mact.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            minutes.bringToFront();
                        }
                    });
                    //Need to change the Interface element seconds, hence the following method(runOnUiThread)
                }catch (InterruptedException e){e.printStackTrace();}
            }
        };Thread waitthenbringfront = new Thread(r);
        waitthenbringfront.start();
    }
    public void startanimhh()
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(150);
                    //remember: runOnUiThread can be accessed through Activity only.
                    mact.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            hours.bringToFront();
                        }
                    });
                    //Need to change the Interface element seconds, hence the following method(runOnUiThread)
                }catch (InterruptedException e){e.printStackTrace();}
            }
        };Thread waitthenbringfront = new Thread(r);
        waitthenbringfront.start();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mact = activity;

    }

    public void startanimdd()
    {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(150);
                    //remember: runOnUiThread can be accessed through Activity only.
                    mact.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            days.bringToFront();
                        }
                    });
                    //Need to change the Interface element seconds, hence the following method(runOnUiThread)
                }catch (InterruptedException e){e.printStackTrace();}
            }
        };Thread waitthenbringfront = new Thread(r);
        waitthenbringfront.start();
    }
}
