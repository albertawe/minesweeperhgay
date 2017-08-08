package com.VertexVerveInc.Games;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Gigabyte on 2017/08/01.
 */

public class Score extends Activity {
    private String difficulty = null;
    private ArrayList<String> name, score;
    private TextView diff;
    private String[] id;
    private ArrayAdapter<String> adapter;
    private LinkedList<String> list;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent i = getIntent();
        difficulty = i.getStringExtra("EXTRA_DIFFICULTY");

        int temp;
//        id = new String[]{"txt_highscore_1", "txt_highscore_2", "txt_highscore_3", "txt_highscore_4",
//                            "txt_highscore_5", "txt_highscore_6", "txt_highscore_7", "txt_highscore_8",
//                            "txt_highscore_9", "txt_highscore_10"};

        SQLiteDatabase myDB = null;

        try {

            //Create a Database if doesnt exist otherwise Open It
//            this.deleteDatabase("leaderboard");
            myDB = this.openOrCreateDatabase("leaderboard", MODE_PRIVATE, null);

            //Create table in database if it doesnt exist allready

            myDB.execSQL("CREATE TABLE IF NOT EXISTS scores (name TEXT, score INT, difficulty TEXT);");

            //Select all rows from the table

            Cursor cursor = myDB.rawQuery("SELECT * FROM scores", null);

            //If there are no rows (data) then insert some in the table

            if (cursor != null) {
                if (cursor.getCount() == 0) {


                    myDB.execSQL("INSERT INTO scores (name, score, difficulty) VALUES ('Adolf', '120', 'Easy');");
                    myDB.execSQL("INSERT INTO scores (name, score, difficulty) VALUES ('Marie', '300', 'Medium');");
                    myDB.execSQL("INSERT INTO scores (name, score, difficulty) VALUES ('George', '600', 'Hard');");
                    myDB.execSQL("INSERT INTO scores (name, score, difficulty) VALUES ('Adam', '800', 'Hardcore');");
                    myDB.execSQL("INSERT INTO scores (name, score, difficulty) VALUES ('Steven', '999', 'Insane');");

                }
            }
        } catch (Exception e) {

        } finally {
            Cursor cursor = myDB.rawQuery("SELECT * FROM scores WHERE difficulty = '" + difficulty +
                    "' ORDER BY score ASC", null);
            cursor.moveToFirst();
            list = new LinkedList<>();
//            name = new ArrayList<String>();
//            score = new ArrayList<String>();
            int x = 0;
            while(!cursor.isAfterLast()) {
//                name.add(cursor.getString(cursor.getColumnIndex("name")));
//                score.add(cursor.getString(cursor.getColumnIndex("name")));
                x++;

                String name = cursor.getString(cursor.getColumnIndex("name"));
                String score = cursor.getString(cursor.getColumnIndex("score"));

                String combine = x + ". " + name + ", " + score + " seconds.";
                list.add(combine);

                cursor.moveToNext();
            }
            cursor.close();
            listview = (ListView) findViewById(R.id.lv);
            adapter = new ArrayAdapter<String>(Score.this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
            diff = (TextView) findViewById(R.id.text_diff);
            diff.setText("High Score : " + difficulty);
            listview.setAdapter(adapter);


//            for(int x = 0; x < id.length; x++){
//                temp = getResources().getIdentifier(id[x], "id", getPackageName());
//                tv_scores[x] = (TextView) findViewById(temp);
//                int rank = x+1;
//                tv_scores[x].setText(rank + ". " + name.get(x) + " : " + score.get(x) + " seconds.");
//            }
//            adapter = new ArrayAdapter<String>(Score.this, android.R.layout.simple_list_item_1, android.R.id.text1, list);
        }
    }

//    private String[] data(){
//        SQLiteDatabase myDB = null;
//        Cursor cursor = myDB.rawQuery("SELECT * FROM scores WHERE difficulty = '" + difficulty + "'", null);
//        cursor.moveToFirst();
//        name = new ArrayList<String>();
//        score = new ArrayList<String>();
//        while(!cursor.isAfterLast()) {
//            name.add(cursor.getString(cursor.getColumnIndex("name")));
//            score.add(cursor.getString(cursor.getColumnIndex("name")));
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return names.toArray(new String[names.size()]);
//    }
}
