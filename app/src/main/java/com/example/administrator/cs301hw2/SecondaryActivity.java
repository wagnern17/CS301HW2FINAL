package com.example.administrator.cs301hw2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

//@author: Nick Wagner
//@date: 9/29/15
//@build: 1.1

public class SecondaryActivity extends ActionBarActivity implements View.OnClickListener {

    //buttons for user customization
    private Button addPlayerToTeam;
    private Button updateTeamStats;
    private Button updatePlayerStats;
    private Button backButton;
    private Button teamListButton;
    private Button playerListButton;

    //edit text for user inputs
    private EditText playerName;
    private EditText playerNum;
    private EditText playerGoals;
    private EditText playerAssists;
    private EditText playerPen;
    private EditText playerPos;
    private EditText teamName;
    private EditText teamWins;
    private EditText teamLoss;
    private EditText teamDraw;

    //textView for stat portrail
    private TextView teamSpinnerSet;
    private TextView numSet;
    private TextView goalSet;
    private TextView assistsSet;
    private TextView penSet;
    private TextView posSet;
    private TextView winSet;
    private TextView lossSet;
    private TextView drawSet;
    private TextView winStatSet;
    private TextView teamWinStat;
    private TextView lossStatSet;
    private TextView TeamLossStat;
    private TextView drawStatSet;
    private TextView TeamDrawStat;
    private TextView playerSet;
    private TextView numStatsSet;
    private TextView playerNumStats;
    private TextView goalsStatsSet;
    private TextView playerGoalsStats;
    private TextView assistsStatsSet;
    private TextView playerAssistsStats;
    private TextView penStatsSet;
    private TextView playerPenStats;
    private TextView posStatsSet;
    private TextView playerPosStats;
    private TextView teamStatsSet;
    private TextView playerTeamStats;

    //arrayList for team and player names
    ArrayList<String> teamList12;
    ArrayList<String> playerList12;

    //hashmap for team and player attributes
    public HashMap<String, Team> teamHash12;
    public HashMap<String, Player> playerHash12;

    //intent to be passed in
    Intent passedVals12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        //setup methods for clarity, mostly for onClickListener
        setupBackButton();
        setupTeamListButton();
        setupPlayerListButton();

        //intent values passed in
        passedVals12 = getIntent();
        playerHash12 = (HashMap<String,Player>) passedVals12.getSerializableExtra("playerHash");
        teamHash12 = (HashMap<String,Team>) passedVals12.getSerializableExtra("teamHash");

        teamList12 = passedVals12.getStringArrayListExtra("team");
        playerList12 = passedVals12.getStringArrayListExtra("player");

    }

    private void setupPlayerListButton() {
        playerListButton = (Button) findViewById(R.id.playerListButton);
        playerListButton.setOnClickListener(this);
    }

    private void setupTeamListButton() {
        teamListButton = (Button) findViewById(R.id.teamListButton);
        teamListButton.setOnClickListener(this);
    }

    private void setupBackButton() {
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
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
        if(v==backButton) { //traverse back to MENU screen
            startActivity(new Intent(SecondaryActivity.this, MainActivity.class));
        }

        if(v==teamListButton) { //travers to teamList, use the passed in intent to pass values to teamList

            Team tTemp1 = new Team();
            tTemp1 = (Team) passedVals12.getSerializableExtra("jags");

            Team tTemp2 = new Team();
            tTemp2 = (Team) passedVals12.getSerializableExtra("cougs");

            Team tTemp3 = new Team();
            tTemp3 = (Team) passedVals12.getSerializableExtra("panth");

            Team tTemp4 = new Team();
            tTemp4 = (Team) passedVals12.getSerializableExtra("cats");

            Intent sec2three = new Intent(SecondaryActivity.this, ThreeActivity.class);
            sec2three.putExtra("jags", tTemp1);
            sec2three.putExtra("cougs", tTemp2);
            sec2three.putExtra("panth", tTemp3);
            sec2three.putExtra("cats", tTemp4);
            sec2three.putStringArrayListExtra("team", teamList12);
            sec2three.putExtra("teamHash", teamHash12);
            sec2three.putStringArrayListExtra("player", playerList12);
            sec2three.putExtra("playerHash", playerHash12);
            startActivity(sec2three);
        }

        if(v==playerListButton) { //traverse to playerList, inits for base players and passing values to playerList
            Player p1 = new Player();
            p1.playerName = "Bob Saggit";
            p1.playerNum = "0";
            p1.playerGoals = "1";
            p1.playerAssists = "2";
            p1.playerPen = "14";
            p1.playerPos = "Striker";


            Player p2 = new Player();
            p2.playerName = "Bill Nye";
            p2.playerNum = "1";
            p2.playerGoals = "2";
            p2.playerAssists = "3";
            p2.playerPen = "13";
            p2.playerPos = "Wing";


            Player p3 = new Player();
            p1.playerName = "Bill Murray";
            p1.playerNum = "1";
            p1.playerGoals = "3";
            p1.playerAssists = "4";
            p1.playerPen = "12";
            p1.playerPos = "MidFielder";


            Player p4 = new Player();
            p1.playerName = "David Villa";
            p1.playerNum = "2";
            p1.playerGoals = "100";
            p1.playerAssists = "0";
            p1.playerPen = "42";
            p1.playerPos = "Ball Hog";


            Player p5 = new Player();
            p1.playerName = "Viktor Cruz";
            p1.playerNum = "3";
            p1.playerGoals = "4";
            p1.playerAssists = "5";
            p1.playerPen = "11";
            p1.playerPos = "Defensive MidFielder";


            Player p6 = new Player();
            p1.playerName = "Matt Morello";
            p1.playerNum = "5";
            p1.playerGoals = "0";
            p1.playerAssists = "0";
            p1.playerPen = "2";
            p1.playerPos = "GoalKeeper";


            Player p7 = new Player();
            p1.playerName = "Lily Collins";
            p1.playerNum = "10";
            p1.playerGoals = "10";
            p1.playerAssists = "10";
            p1.playerPen = "10";
            p1.playerPos = "Defender";
            Intent sec2four = new Intent(SecondaryActivity.this, FourActivity.class);
            sec2four.putExtra("p1", p1);
            sec2four.putExtra("p2", p2);
            sec2four.putExtra("p3", p3);
            sec2four.putExtra("p4", p4);
            sec2four.putExtra("p5", p5);
            sec2four.putExtra("p6", p6);
            sec2four.putExtra("p7", p7);
            startActivity(sec2four);
        }
    }
}
