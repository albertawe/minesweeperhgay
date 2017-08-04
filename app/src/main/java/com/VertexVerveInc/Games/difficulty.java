package com.VertexVerveInc.Games;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class difficulty extends Activity {

    private void start(final int row, final int column, final int bomb, final int dim){
        // TODO Auto-generated method stub
        Intent pindah = new Intent(this,MinesweeperGame.class);
//        Bundle extras = new Bundle();
        pindah.putExtra("EXTRA_ROW", row);
        pindah.putExtra("EXTRA_COLUMN", column);
        pindah.putExtra("EXTRA_BOMB", bomb);
        pindah.putExtra("EXTRA_DIMENSION", dim);
//        pindah.putExtras(extras);
        startActivity(pindah);
        //menghubungkan antar activity dengan intent
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_difficulty);
        TextView btn1 =(TextView) findViewById(R.id.easy);
        TextView btn2 =(TextView) findViewById(R.id.med);
        TextView btn3 =(TextView) findViewById(R.id.hard);
        TextView btn4 =(TextView) findViewById(R.id.hardcore);
        TextView btn5 =(TextView) findViewById(R.id.insane);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int row = 9;
                int column = 9;
                int bomb = 10;
                int dim = 60;
                start(row, column, bomb, dim);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int row = 10;
                int column = 10;
                int bomb = 30;
                int dim = 60;
                start(row, column, bomb, dim);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int row = 12;
                int column = 12;
                int bomb = 50;
                int dim = 50;
                start(row, column, bomb, dim);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int row = 14;
                int column = 14;
                int bomb = 70;
                int dim = 45;
                start(row, column, bomb, dim);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                int row = 15;
                int column = 15;
                int bomb = 80;
                int dim = 40;
                start(row, column, bomb, dim);

            }
        });
    }


}
