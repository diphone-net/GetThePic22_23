package cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.Models;


import static android.content.ContentValues.TAG;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.Models.Player.Player;
import cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.Models.Player.HumanPlayer;
import cat.udl.getthepic.gtidic.udl.getthepic.android.jjd2223.helpers.GlobalInfo;

@Entity
public class GTimeTrial {
    @PrimaryKey(autoGenerate = true)
    public long id;

    public int totalCardsReversed = 0;
    public int POINTS_PER_MATCH = 10;
    public int Levels = 1;
    public int levelsTotal= 0;
    public int maxPoints = -1;
    @Ignore
    private String actual = "";
    @Ignore
    private Player player1;

    @Ignore
    Player currentPlayer;
    @Ignore
    Player winner;
    @Ignore
    public Board board;
    @Ignore
    public boolean win = false;
    @Ignore
    public boolean equivocat = false;
    @Ignore
    private FirebaseAuth mAuth1;
    @Ignore
    private FirebaseUser user;








    public void init() {
        int boardSize = 8;
        UpdateUser();
        player1 = new HumanPlayer(user.getEmail());
        currentPlayer = player1;


        board = new Board(boardSize);

        board.load(levels.GetRandomLevel());









    }










    public void cardClicked(int row){
        equivocat = false;
        actual += Character.toString(board.getPiece(row).getValue());
        totalCardsReversed++;

        checkifwin();
        if(totalCardsReversed == levels.GetRandomLevelStr().length())
        {

            actual = "";
            totalCardsReversed = 0;
            equivocat = true;


        }
        board.getPiece(row).setGirada(true);
    }

    public int getTotalCardsReversed()
    {
        return totalCardsReversed;
    }
    public int getPOINTS_PER_MATCH()
    {
        return POINTS_PER_MATCH;
    }
    public int getMaxPoints()
    {
        return maxPoints;
    }
    public int getLevelsTotal()
    {
        return levelsTotal;
    }





    public void checkifwin() {
        win = false;


        if (actual.equals(levels.GetRandomLevelStr())) {


            levels.onLevelPassed();
            levelsTotal+= Levels;
            board.load(levels.GetRandomLevel());
            actual = "";
            totalCardsReversed = 0;

            win = true;

            player1.addPoints(POINTS_PER_MATCH);
        }
    }




    private void UpdateUser()
    {
        mAuth1 = FirebaseAuth.getInstance();
        user = mAuth1.getCurrentUser();
    }



}















