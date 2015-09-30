package com.example.administrator.cs301hw2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

//@author: Nick Wagner
//@date: 9/29/15
//@build: 1.3

//Resources: https://www.youtube.com/watch?v=SaXYFHYGLj4
//           text_and_button_example by Dr. Schmidt
//           http://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html

public class MainActivity extends ActionBarActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    //buttons for user customization
    private Button addPlayer;
    private Button addTeam;
    private Button playButton;
    private Button teamListButton;

    //edit texts to read user input
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

    //textviews to post stats of teams
    private TextView teamWinStat;
    private TextView teamLossStat;
    private TextView teamDrawStat;

    //hashmaps to hold team and players attributes
    public HashMap<String, Team> teamHash;
    public HashMap<String, Player> playerHash;

    //arraylists to hold names of teams and players
    ArrayList<String> playerList;
    ArrayList<String> teamList;
    ArrayList<ImageView> playerImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //playerHash init
        playerHash=new HashMap<String,Player>();
        playerHash.put("", new Player());

        //teamHash init
        teamHash=new HashMap<String,Team>();
        teamHash.put("", new Team());

        //playerList init
        playerList = new ArrayList<String>();
        playerList.add("");

        //teamList init
        teamList = new ArrayList<String>();
        teamList.add("");

        //method list of setups for clarity, mostly implementing onClickListeners
        setupPlayButton();
        setupTeamListButton();
        setupAddPlayer();
        setupAddTeam();
        setupTeam();
        setupPlayer();
    }

    private void setupTeamListButton() {
        teamListButton = (Button) findViewById(R.id.teamListButton);
        teamListButton.setOnClickListener(this);
    }

    private void setupTeam() { //team attributes init
        teamName = (EditText) findViewById(R.id.teamName);
        teamWins = (EditText) findViewById(R.id.teamWins);
        teamLoss = (EditText) findViewById(R.id.teamLoss);
        teamDraw = (EditText) findViewById(R.id.teamDraw);

        teamWinStat = (TextView) findViewById(R.id.teamWinStat);
        teamLossStat = (TextView) findViewById(R.id.teamLossStat);
        teamDrawStat = (TextView) findViewById(R.id.teamDrawStat);
    }

    private void setupPlayer() { //player attributes init
        playerName = (EditText) findViewById(R.id.playerName);
        playerNum = (EditText) findViewById(R.id.playerNum);
        playerGoals = (EditText) findViewById(R.id.playerGoals);
        playerAssists = (EditText) findViewById(R.id.playerAssists);
        playerPen = (EditText) findViewById(R.id.playerPen);
        playerPos = (EditText) findViewById(R.id.playerPos);

        //base players inits
        Player p1 = new Player();
        p1.playerName = "Bob Saggit";
        p1.playerNum = "0";
        p1.playerGoals = "1";
        p1.playerAssists = "2";
        p1.playerPen = "14";
        p1.playerPos = "Striker";
        playerHash.put(p1.playerName, p1);

        Player p2 = new Player();
        p2.playerName = "Bill Nye";
        p2.playerNum = "1";
        p2.playerGoals = "2";
        p2.playerAssists = "3";
        p2.playerPen = "13";
        p2.playerPos = "Wing";
        playerHash.put(p2.playerName, p2);

        Player p3 = new Player();
        p1.playerName = "Bill Murray";
        p1.playerNum = "1";
        p1.playerGoals = "3";
        p1.playerAssists = "4";
        p1.playerPen = "12";
        p1.playerPos = "MidFielder";
        playerHash.put(p3.playerName, p3);

        Player p4 = new Player();
        p1.playerName = "David Villa";
        p1.playerNum = "2";
        p1.playerGoals = "100";
        p1.playerAssists = "0";
        p1.playerPen = "42";
        p1.playerPos = "Ball Hog";
        playerHash.put(p4.playerName, p4);

        Player p5 = new Player();
        p1.playerName = "Viktor Cruz";
        p1.playerNum = "3";
        p1.playerGoals = "4";
        p1.playerAssists = "5";
        p1.playerPen = "11";
        p1.playerPos = "Defensive MidFielder";
        playerHash.put(p5.playerName, p5);

        Player p6 = new Player();
        p1.playerName = "Matt Morello";
        p1.playerNum = "5";
        p1.playerGoals = "0";
        p1.playerAssists = "0";
        p1.playerPen = "2";
        p1.playerPos = "GoalKeeper";
        playerHash.put(p6.playerName, p6);

        Player p7 = new Player();
        p1.playerName = "Lily Collins";
        p1.playerNum = "10";
        p1.playerGoals = "10";
        p1.playerAssists = "10";
        p1.playerPen = "10";
        p1.playerPos = "Defender";
        playerHash.put(p7.playerName, p7);
    }

    private void setupAddTeam() {
        addTeam = (Button) findViewById(R.id.addTeam);
        addTeam.setOnClickListener(this);
    }

    private void setupAddPlayer() {
        addPlayer = (Button) findViewById(R.id.addPlayer);
        addPlayer.setOnClickListener(this);
    }

    private void setupPlayButton() {
        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (v == playButton) { //base teams init to be passed to PLAY screen
            Team jags = new Team();
            jags.teamName = "Jaguars";
            jags.teamWins = "1";
            jags.teamLoss = "1";
            jags.teamDraw = "2";
            teamHash.put(jags.teamName, jags);

            Team cougs = new Team();
            cougs.teamName = "Cougars";
            cougs.teamWins = "3";
            cougs.teamLoss = "5";
            cougs.teamDraw = "8";
            teamHash.put(cougs.teamName, cougs);

            Team panth = new Team();
            panth.teamName = "Panthers";
            panth.teamWins = "13";
            panth.teamLoss = "1";
            panth.teamDraw = "2";
            teamHash.put(panth.teamName, panth);

            Team cats = new Team();
            cats.teamName = "Wildcats";
            cats.teamWins = "3";
            cats.teamLoss = "5";
            cats.teamDraw = "7";
            teamHash.put(cats.teamName, cats);

            Intent main2sec = new Intent(MainActivity.this, SecondaryActivity.class);
            main2sec.putExtra("jags", jags);
            main2sec.putExtra("cougs", cougs);
            main2sec.putExtra("panth", panth);
            main2sec.putExtra("cats", cats);
            main2sec.putStringArrayListExtra("team", teamList);
            main2sec.putExtra("teamHash", teamHash);
            main2sec.putStringArrayListExtra("player", playerList);
            main2sec.putExtra("playerHash", playerHash);
            startActivity(main2sec);
        }

        if(v == teamListButton) { //base teams list inits to be passed strait to the teams list
            Team jags = new Team();
            jags.teamName = "Jaguars";
            jags.teamWins = "1";
            jags.teamLoss = "1";
            jags.teamDraw = "2";
            teamHash.put(jags.teamName, jags);

            Team cougs = new Team();
            cougs.teamName = "Cougars";
            cougs.teamWins = "3";
            cougs.teamLoss = "5";
            cougs.teamDraw = "8";
            teamHash.put(cougs.teamName, cougs);

            Team panth = new Team();
            panth.teamName = "Panthers";
            panth.teamWins = "13";
            panth.teamLoss = "1";
            panth.teamDraw = "2";
            teamHash.put(panth.teamName, panth);

            Team cats = new Team();
            cats.teamName = "Wildcats";
            cats.teamWins = "3";
            cats.teamLoss = "5";
            cats.teamDraw = "7";
            teamHash.put(cats.teamName, cats);

            Intent main2three = new Intent(MainActivity.this, ThreeActivity.class);
            main2three.putExtra("jags", jags);
            main2three.putExtra("cougs", cougs);
            main2three.putExtra("panth", panth);
            main2three.putExtra("cats", cats);
            startActivity(main2three);
        }

        if (v == addPlayer) { //adding of a player logic based on user inputs
            if (String.valueOf(playerNum.getText()) == "" ||
                    String.valueOf(playerName.getText()) == "" ||
                    String.valueOf(playerGoals.getText()) == "" ||
                    String.valueOf(playerAssists.getText()) == "" ||
                    String.valueOf(playerPen.getText()) == "" ||
                    String.valueOf(playerPos.getText()) == "") {
                return;
            }

            if (playerList.indexOf(String.valueOf(playerName.getText())) == -1) {
                Player pTemp = new Player();
                pTemp.playerName = String.valueOf(playerName.getText());
                pTemp.playerNum = String.valueOf(playerNum.getText());
                pTemp.playerGoals = String.valueOf(playerGoals.getText());
                pTemp.playerAssists = String.valueOf(playerAssists.getText());
                pTemp.playerPen = String.valueOf(playerPen.getText());
                pTemp.playerPos = String.valueOf(playerPos.getText());

                playerHash.put(String.valueOf(playerName.getText()), pTemp);

                playerList.add(String.valueOf(playerName.getText()));
            }
        }

        if (v == addTeam) { //adding of a team logic based on user inputs
            if(String.valueOf(teamName.getText()) == "" ||
                    String.valueOf(teamWins.getText()) == "" ||
                    String.valueOf(teamLoss.getText()) == "" ||
                    String.valueOf(teamDraw.getText()) == "") {
                return;
            }

            if(teamList.indexOf( String.valueOf(teamName.getText()) ) == -1 ) {
                Team tTemp = new Team();
                tTemp.teamName = String.valueOf(teamName.getText());
                tTemp.teamWins = String.valueOf(teamWins.getText());
                tTemp.teamLoss = String.valueOf(teamLoss.getText());
                tTemp.teamDraw = String.valueOf(teamDraw.getText());

                teamHash.put(String.valueOf(teamName.getText()), tTemp);

                teamList.add(String.valueOf(teamName.getText()));
            }
            else
            {
                teamHash.get(String.valueOf(teamName.getText())).teamName =String.valueOf(teamName.getText());
                if( String.valueOf(teamName.getText()) != null) {
                    teamName.setText(String.valueOf(teamName.getText()));
                }
                else {
                    teamName.setText("");
                }

                teamHash.get(String.valueOf(teamWins.getText())).teamWins =String.valueOf(teamWins.getText());
                if( String.valueOf(teamWins.getText()) != null) {
                    teamWins.setText(String.valueOf(teamWins.getText()));
                }
                else {
                    teamWins.setText("");
                }

                teamHash.get(String.valueOf(teamLoss.getText())).teamLoss =String.valueOf(teamLoss.getText());
                if( String.valueOf(teamLoss.getText()) != null) {
                    teamLoss.setText(String.valueOf(teamLoss.getText()));
                }
                else {
                    teamLoss.setText("");
                }

                teamHash.get(String.valueOf(teamDraw.getText())).teamDraw =String.valueOf(teamDraw.getText());
                if( String.valueOf(teamDraw.getText()) != null) {
                    teamDraw.setText(String.valueOf(teamDraw.getText()));
                }
                else {
                    teamDraw.setText("");
                }

            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
