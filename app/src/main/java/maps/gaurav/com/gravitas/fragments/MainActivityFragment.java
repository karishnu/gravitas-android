package maps.gaurav.com.gravitas.fragments;

import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import maps.gaurav.com.gravitas.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    TextView seconds, minutes, hours, days;

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

        new CountDownTimer(6000*60*60*24,1000*60*60*24){
            @Override
            public void onTick(long millisUntilFinished) {
                millisUntilFinished/=(1000*60*60*24);
                days.setText("Days: "+millisUntilFinished);
                new CountDownTimer(60000*60*60,1000*60*60){
                    @Override
                    public void onTick(long millisUntilFinished) {
                        millisUntilFinished/=(1000*60*60);
                        hours.setText("Hours: "+millisUntilFinished);

                        new CountDownTimer(60000*60,1000*60){
                            @Override
                            public void onTick(long millisUntilFinished) {
                                millisUntilFinished/=(1000*60);
                                minutes.setText("Minutes: "+millisUntilFinished);
                                new CountDownTimer(60000,1000){
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        millisUntilFinished/=1000;
                                        seconds.setText("Seconds: "+millisUntilFinished);
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
