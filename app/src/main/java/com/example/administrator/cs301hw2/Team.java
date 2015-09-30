package com.example.administrator.cs301hw2;

import java.io.Serializable;

/**
 * Created by wagnern17 on 9/28/2015.
 */

//@author: Nick Wagner
//@date: 9/29/15
//@build: 1.2
public class Team implements Serializable {

    String teamName;
    String teamWins;
    String teamLoss;
    String teamDraw;

    protected Team() {
        teamName = "FC Faker"; //number string values form 007 because James Bond
        teamWins = "0";
        teamLoss = "0";
        teamDraw = "7";
    }

}
