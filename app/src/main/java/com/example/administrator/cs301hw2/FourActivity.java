package com.example.administrator.cs301hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//@author: Nick Wagner
//@date: 9/29/15
//@build: 1.1


public class FourActivity extends ActionBarActivity implements View.OnClickListener {

    //buttons for player specification
    private Button playerButton1;
    private Button playerButton2;
    private Button playerButton3;
    private Button playerButton4;
    private Button playerButton5;
    private Button playerButton6;
    private Button playerButton7;
    private Button playerButton8;
    private Button playerButton9;
    private Button playerButton10;
    private Button playerButton11;
    private Button playerButton12;
    private Button playerButton13;
    private Button playerButton14;
    private Button playerButton15;
    private Button playerButton16;
    private Button playerButton17;
    private Button playerButton18;
    private Button playerButton19;
    private Button backToPlay;

    //intent for passed values
    Intent passedVals24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        //buttons for default teams init
        playerButton1 = (Button) findViewById(R.id.playerButton1);
        playerButton2 = (Button) findViewById(R.id.playerButton2);
        playerButton3 = (Button) findViewById(R.id.playerButton3);
        playerButton4 = (Button) findViewById(R.id.playerButton4);
        playerButton5 = (Button) findViewById(R.id.playerButton5);
        playerButton6 = (Button) findViewById(R.id.playerButton6);
        playerButton7 = (Button) findViewById(R.id.playerButton7);

        //get intent passed from SecondaryActivity
        passedVals24 = getIntent();

        //create players to hold the values passed in the intent and post them in the playerList
        Player pTemp1 = new Player();
        pTemp1 = (Player) passedVals24.getSerializableExtra("p1");
        playerButton1.setText(pTemp1.playerName);

        Player pTemp2 = new Player();
        pTemp2 = (Player) passedVals24.getSerializableExtra("p2");
        playerButton2.setText(pTemp2.playerName);

        Player pTemp3 = new Player();
        pTemp3 = (Player) passedVals24.getSerializableExtra("p3");
        playerButton3.setText(pTemp3.playerName);

        Player pTemp4 = new Player();
        pTemp4 = (Player) passedVals24.getSerializableExtra("p4");
        playerButton4.setText(pTemp4.playerName);

        Player pTemp5 = new Player();
        pTemp5 = (Player) passedVals24.getSerializableExtra("p5");
        playerButton5.setText(pTemp5.playerName);

        Player pTemp6 = new Player();
        pTemp6 = (Player) passedVals24.getSerializableExtra("p6");
        playerButton6.setText(pTemp6.playerName);

        Player pTemp7 = new Player();
        pTemp7 = (Player) passedVals24.getSerializableExtra("p7");
        playerButton7.setText(pTemp7.playerName);

        setupBackToPlay();
    }

    private void setupBackToPlay() { //traversing back to PLAY screen init
        backToPlay = (Button) findViewById(R.id.backButton);
        backToPlay.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_four, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v==backToPlay) { //traverse back to PLAY screen
            startActivity(new Intent(FourActivity.this, SecondaryActivity.class));
        }
    }
}
