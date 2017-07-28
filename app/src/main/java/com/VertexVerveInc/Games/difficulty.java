package com.VertexVerveInc.Games;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class difficulty extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        TextView btn1 =(TextView) findViewById(R.id.easy);
        TextView btn2 =(TextView) findViewById(R.id.med);
        TextView btn3 =(TextView) findViewById(R.id.hard);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent pindah = new Intent(difficulty.this,MinesweeperGame.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent pindah = new Intent(difficulty.this,MinesweeperGame2.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent pindah = new Intent(difficulty.this,MinesweeperGame3.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent

            }
        });
    }
}
