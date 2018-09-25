    package com.example.mchugh.navdrawercia3;

    import android.content.Context;
    import android.media.MediaPlayer;
    import android.net.Uri;
    import android.os.Bundle;
    import android.os.Handler;
    import android.support.annotation.Nullable;
    import android.support.v4.app.Fragment;
    import android.support.v7.app.AppCompatActivity;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.widget.ImageButton;
    import android.widget.SeekBar;
    import android.widget.TextView;
    import android.widget.Toast;

    import java.util.concurrent.TimeUnit;


    public class musicFragment extends Fragment  {

        private ImageButton play;
        private ImageButton forward;
        private  ImageButton backward;
        private  ImageButton pause;
        private ImageButton nextSong;
        private ImageButton prevSong;
        private SeekBar seekbar;
        private double startTime = 0;
        private double finalTime = 0;
        private MediaPlayer mediaPlayer;
        private Handler myHandler = new Handler();
        private int forwardTime = 5000;
        private int backwardTime = 5000;
        public static int oneTimeOnly = 0;
        private TextView start,end;
    
        public void onViewCreated(final View view, @Nullable Bundle savedInstanceState){
            play = getView().findViewById(R.id.play);
            forward = getView().findViewById(R.id.forward);
            backward = getView().findViewById(R.id.backward);
            pause = getView().findViewById(R.id.pause);

            nextSong= getView().findViewById(R.id.next);
            prevSong = getView().findViewById(R.id.prev);

            start = getView().findViewById(R.id.start);
            end = getView().findViewById(R.id.end);
            mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.song);
            seekbar = getView().findViewById(R.id.seekbar);
            seekbar.setClickable(false);
            pause.setEnabled(false);
            play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaPlayer.start();
                    pause.setVisibility(view.VISIBLE);
                    play.setVisibility(view.INVISIBLE);
                    finalTime = mediaPlayer.getDuration();
                    startTime = mediaPlayer.getCurrentPosition();

                    if (oneTimeOnly == 0) {
                        seekbar.setMax((int) finalTime);
                        oneTimeOnly = 1;
                    }

                    end.setText(String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                            finalTime)))
                    );

                    start.setText(String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                            startTime)))
                    );

                    seekbar.setProgress((int) startTime);
                    myHandler.postDelayed(UpdateSongTime,100);
                    pause.setEnabled(true);
                }
            });

            pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity().getApplicationContext(), "Pausing sound",Toast.LENGTH_SHORT).show();
                    mediaPlayer.pause();
                    pause.setEnabled(false);
                    play.setEnabled(true);
                    pause.setVisibility(view.INVISIBLE);
                    play.setVisibility(view.VISIBLE);
                }
            });

            forward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int temp = (int)startTime;

                    if((temp+forwardTime)<=finalTime){
                        startTime = startTime + forwardTime;
                        mediaPlayer.seekTo((int) startTime);
                        Toast.makeText(getActivity().getApplicationContext(),"You have Jumped forward 5 seconds",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity().getApplicationContext(),"Cannot jump forward 5 seconds",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            backward.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int temp = (int)startTime;

                    if((temp-backwardTime)>0){
                        startTime = startTime - backwardTime;
                        mediaPlayer.seekTo((int) startTime);
                        Toast.makeText(getActivity().getApplicationContext(),"You have Jumped backward 5 seconds",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity().getApplicationContext(),"Cannot jump backward 5 seconds",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            nextSong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaPlayer.stop();
                    mediaPlayer = MediaPlayer.create(getActivity().getApplicationContext(), R.raw.songtwo);
                    mediaPlayer.start();
                }
            });
        }
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);



        }

        private Runnable UpdateSongTime = new Runnable() {
            public void run() {
                startTime = mediaPlayer.getCurrentPosition();
                start.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                        toMinutes((long) startTime)))
                );
                seekbar.setProgress((int)startTime);
                myHandler.postDelayed(this, 100);
            }
        };

        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment

            return inflater.inflate(R.layout.fragment_music, container, false);
        }
    }

