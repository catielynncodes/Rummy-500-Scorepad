package com.catielynn.android.rummy500scorepadapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Game3Players extends AppCompatActivity {
    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int scorePlayerC = 0;

    public TextView playerAName;
    public TextView playerBName;
    public TextView playerCName;

    // Stored scores in integers for both teams.
    static final String PLAYERASCORE = "player_a_score";
    static final String PLAYERBSCORE = "player_b_score";
    static final String PLAYERCSCORE = "player_c_score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_players);

        // Get incoming intent
        Intent intent = getIntent();
        if(intent != null){
            // Get string extra using same key as before
            String passedString1 = intent.getStringExtra("I want Player A Name");
            String passedString2 = intent.getStringExtra("I want Player B Name");
            String passedString3 = intent.getStringExtra("I want Player C Name");

            // Apply names from intent to name strings in this activity
            playerAName.setText(passedString1);
            playerBName.setText(passedString2);
            playerCName.setText(passedString3);
        }

    }
    /**
     * Displays the given scores for Players A, B, and C.
     */
    public void displayForPlayerA(int score) {
        TextView scoreView = findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
        determineWinner();
    }
    public void displayForPlayerB(int score) {
        TextView scoreView = findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
        determineWinner();
    }
    public void displayForPlayerC(int score) {
        TextView scoreView = findViewById(R.id.player_c_score);
        scoreView.setText(String.valueOf(score));
        determineWinner();
    }

    /**
     * Changing score for Players A, B, and C.
     */
    public void subtractFiveFromPlayerA(View v) {
        scorePlayerA = scorePlayerA - 5;
        displayForPlayerA(scorePlayerA);
    }
    public void addFiveForPlayerA(View v) {
        scorePlayerA = scorePlayerA + 5;
        displayForPlayerA(scorePlayerA);
    }
    public void addTenForPlayerA(View v) {
        scorePlayerA = scorePlayerA + 10;
        displayForPlayerA(scorePlayerA);
    }
    public void addFifteenForPlayerA(View v) {
        scorePlayerA = scorePlayerA + 15;
        displayForPlayerA(scorePlayerA);
    }
    public void subtractFiveFromPlayerB(View v) {
        scorePlayerB = scorePlayerB - 5;
        displayForPlayerB(scorePlayerB);
    }
    public void addFiveForPlayerB(View v) {
        scorePlayerB = scorePlayerB + 5;
        displayForPlayerB(scorePlayerB);
    }
    public void addTenForPlayerB(View v) {
        scorePlayerB = scorePlayerB + 10;
        displayForPlayerB(scorePlayerB);
    }
    public void addFifteenForPlayerB(View v) {
        scorePlayerB = scorePlayerB + 15;
        displayForPlayerB(scorePlayerB);
    }
    public void subtractFiveFromPlayerC(View v) {
        scorePlayerC = scorePlayerC - 5;
        displayForPlayerC(scorePlayerC);
    }
    public void addFiveForPlayerC(View v) {
        scorePlayerC = scorePlayerC + 5;
        displayForPlayerC(scorePlayerC);
    }
    public void addTenForPlayerC(View v) {
        scorePlayerC = scorePlayerC + 10;
        displayForPlayerC(scorePlayerC);
    }
    public void addFifteenForPlayerC(View v) {
        scorePlayerC = scorePlayerC + 15;
        displayForPlayerC(scorePlayerC);
    }
    public void reset(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        scorePlayerC = 0;
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
        displayForPlayerC(scorePlayerC);
    }

    /**
     * @param savedInstanceState stores scores for both players before application stops.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(PLAYERASCORE, scorePlayerA);
        savedInstanceState.putInt(PLAYERBSCORE, scorePlayerB);
        savedInstanceState.putInt(PLAYERCSCORE, scorePlayerC);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Restore and display scores from savedInstanceState after application stops,
     * or when changing rotation between portrait and landscape mode.
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scorePlayerA = savedInstanceState.getInt(PLAYERASCORE);
        scorePlayerB = savedInstanceState.getInt(PLAYERBSCORE);
        scorePlayerC = savedInstanceState.getInt(PLAYERCSCORE);
        displayForPlayerA(scorePlayerA);
        displayForPlayerB(scorePlayerB);
        displayForPlayerC(scorePlayerC);
    }

    // Use this function to check which, if any, players have over 500 and more points than the others.
    public void determineWinner(){
        if((scorePlayerA >= 500) && (scorePlayerA > scorePlayerB) && (scorePlayerA > scorePlayerC)){
            Toast.makeText(this, playerAName.getText().toString() + " wins!", Toast.LENGTH_SHORT).show();
        } else if((scorePlayerB >= 500) && (scorePlayerB > scorePlayerA) && (scorePlayerB > scorePlayerC)){
            Toast.makeText(this, playerBName.getText().toString() + " wins!", Toast.LENGTH_SHORT).show();
        } else if((scorePlayerC >= 500) && (scorePlayerC > scorePlayerA) && (scorePlayerC > scorePlayerB)){
            Toast.makeText(this, playerCName.getText().toString() + " wins!", Toast.LENGTH_SHORT).show();
        }
    }
}

