package maps.gaurav.com.gravitas.fragments;

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



import maps.gaurav.com.gravitas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    TextView seconds, minutes, hours, days;
    ImageView rruelem,mmuelem,lluelem,ssuelem;
    Boolean animcompdd,animcomphh,animcompmm,animcompss;

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
                    //ToDO thread to wait for 160 mseconds before bringing days to front.
                    days.bringToFront();
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
                            //ToDO thread to wait for 160 mseconds before bringing hours to front.
                            hours.bringToFront();
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
                                    //ToDO thread to wait for 160 mseconds before bringing minutes to front.
                                    minutes.bringToFront();
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
                                            ssuelem.bringToFront();
                                            uppanels.startAnimation(uppaneldowns);
                                            animcompss = true;
                                        }
                                        else animcompss = false;
                                        if(animcompss)
                                        {
                                            //ToDO thread to wait for 160 mseconds before bringing seconds to front.
                                            seconds.bringToFront();
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
}
