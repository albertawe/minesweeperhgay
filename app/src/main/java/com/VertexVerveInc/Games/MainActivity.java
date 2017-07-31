package com.VertexVerveInc.Games;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    ToggleButton myToggle;
    MediaPlayer audioBackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView btn1 =(TextView) findViewById(R.id.play);



        myToggle = (ToggleButton) findViewById(R.id.toggleSound);
        //Memanggil file my_sound pada folder raw

        audioBackground = MediaPlayer.create(this, R.raw.bg);
        //Set looping ke true untuk mengulang audio jika telah selesai
        audioBackground.setLooping(true);
        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent pindah = new Intent(MainActivity.this,difficulty.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent

            }
        });

    }
    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();

        if (on) {
			/*Mematikan suara audio*/
            audioBackground.setVolume(0, 0);
        } else {
			/*Menghidupkan kembali audio background*/
            audioBackground.setVolume(1, 1);
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        audioBackground.stop();
        MainActivity.this.finish();
    }
}
