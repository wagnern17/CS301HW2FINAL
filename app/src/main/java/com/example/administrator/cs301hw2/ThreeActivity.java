package com.example.administrator.cs301hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;

//@author: Nick Wagner
//@date: 9/29/15
//@build: 1.1


public class ThreeActivity extends ActionBarActivity implements View.OnClickListener {

    //buttons for team specification and also traversion
    private Button teamButton1;
    private Button teamButton2;
    private Button teamButton3;
    private Button teamButton4;
    private Button teamButton5;
    private Button teamButton6;
    private Button teamButton7;
    private Button teamButton8;
    private Button teamButton9;
    private Button teamButton10;
    private Button teamButton11;
    private Button teamButton12;
    private Button teamButton13;
    private Button teamButton14;
    private Button teamButton15;
    private Button teamButton16;
    private Button teamButton17;
    private Button teamButton18;
    private Button teamButton19;
    private Button backButton;
    private Button backToPlay;

    //arrayList for team and player names
    ArrayList<String> teamList23;
    ArrayList<String> playerList23;

    //hasmap for player and team attributes
    public HashMap<String, Team> teamHash23;
    public HashMap<String, Player> playerHash23;

    //intent for passed values
    Intent passedVals23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        //buttons init for base teams
        teamButton1 = (Button) findViewById(R.id.teamButton1);
        teamButton2 = (Button) findViewById(R.id.teamButton2);
        teamButton3 = (Button) findViewById(R.id.teamButton3);
        teamButton4 = (Button) findViewById(R.id.teamButton4);

        //intent logic
        passedVals23 = getIntent();
        playerHash23 = (HashMap<String,Player>) passedVals23.getSerializableExtra("playerHash");
        teamHash23 = (HashMap<String,Team>) passedVals23.getSerializableExtra("teamHash");

        teamList23 = passedVals23.getStringArrayListExtra("team");
        playerList23 = passedVals23.getStringArrayListExtra("player");

        //temp values to pass the intent values to and setTexted to buttons
        Team tTemp1 = new Team();
        tTemp1 = (Team) passedVals23.getSerializableExtra("jags");
        teamButton1.setText(tTemp1.teamName);

        Team tTemp2 = new Team();
        tTemp2 = (Team) passedVals23.getSerializableExtra("cougs");
        teamButton2.setText(tTemp2.teamName);

        Team tTemp3 = new Team();
        tTemp3 = (Team) passedVals23.getSerializableExtra("panth");
        teamButton3.setText(tTemp3.teamName);

        Team tTemp4 = new Team();
        tTemp4 = (Team) passedVals23.getSerializableExtra("cats");
        teamButton4.setText(tTemp4.teamName);

        //setups for implementation, mostly onClickListener
        setupBackButton();
        setupBackToPlay();
    }

    private void setupBackToPlay() {
        backToPlay = (Button) findViewById(R.id.backToPlayButton);
        backToPlay.setOnClickListener(this);
    }

    private void setupBackButton() {
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_three, menu);
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
        if (v == backButton) { //traverse back to MENU screen and send hashMap
            Intent three2main = new Intent(ThreeActivity.this, MainActivity.class);
            three2main.putStringArrayListExtra("team", teamList23);
            three2main.putExtra("teamHash", teamHash23);
            startActivity(three2main);
        }

        if(v==backToPlay) { //traverse back to PLAY screen and send hashMap
            Intent three2sec = new Intent(ThreeActivity.this, SecondaryActivity.class);
            three2sec.putStringArrayListExtra("team", teamList23);
            three2sec.putExtra("teamHash", teamHash23);
            three2sec.putStringArrayListExtra("player", playerList23);
            three2sec.putExtra("playerHash", playerHash23);
            startActivity(three2sec);
        }
    }
}
