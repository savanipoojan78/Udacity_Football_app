package com.example.android.footballcounter;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreHome;
    int scoreAway;
    int foulHome;
    int foulAway;
    int bookingHome;
    int bookingAway;
    int shotHome;
    int shotAway;
    int ontargetHome;
    int ontargetAway;
    String g1;
    TextView teamNameW;
    TextView teamNameA;
    TextView teamScoreA;
    TextView teamScoreB;
    ImageView teamA;
    ImageView teamB;
    Button submit;
    Button show;
    DatabaseHelper mydb;
   String teamNameFirst;
   String teamNameSecond;
   int teamLogo1;
   int teamLogo2;
    private Window mWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWindow = getWindow();
        mWindow.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        teamScoreA=(TextView)findViewById(R.id.team_a_score);
        teamScoreB=(TextView)findViewById(R.id.team_b_score);
        show=(Button)findViewById(R.id.Score_card);
        mydb=new DatabaseHelper(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            teamNameFirst = bundle.getString("team_a");
            teamNameSecond=bundle.getString("team_b");
            teamLogo1=bundle.getInt("team_logo_a");
            teamLogo2=bundle.getInt("team_logo_b");

        }


        teamNameW=(TextView)findViewById(R.id.Team_name_1);
        teamNameA=(TextView)findViewById(R.id.Team_name_A);
        teamA=(ImageView)findViewById(R.id.Team_A);
        teamB=(ImageView)findViewById(R.id.Team_B);
        submit=(Button)findViewById(R.id.Submit);
        teamNameW.setText(teamNameFirst);
        teamNameA.setText(teamNameSecond);
        teamA.setImageResource(teamLogo1);
        teamB.setImageResource(teamLogo2);
        Adddata();
        ShowData();

    }
    //To increase the Number of GoalHome When The Goal Button press

    public void goalHome(View view) {
        scoreHome += 1;
        displayGoalHome(scoreHome);
    }
    //To increase the Number of Foul made By Home Team When The Foul! Button press

    public void foulByHome(View view) {
        foulHome += 1;
        displayFoulHome(foulHome);
    }
    //To increase the Number of Yellow/Red Card When The Yellow Button press

    public void bookingByHome(View view) {
        bookingHome += 1;
        displayBookingHome(bookingHome);

    }
    //To increase the Number of Shots Made By Home Team When The Shots Button press

    public void shotsByHome(View view) {
        shotHome += 1;
        displayShotHome(shotHome);

    }
    //To increase the Number Of Ontarget made by home When The On Target Button press

    public void ontargetByHome(View view) {
        ontargetHome += 1;
        displayontargetHome(ontargetHome);

    }


    //Display the Goal Made By Home Team
    public void displayGoalHome(int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_a_score);
        goalView.setText(String.valueOf(goal));
    }
    //Display the Foul made by Home Team

    public void displayFoulHome(int foul) {
        TextView foulView = (TextView) findViewById(R.id.home_fouls);
        foulView.setText(String.valueOf(foul));
    }
    //Display the Yellow or Red Card of the Home Team

    public void displayBookingHome(int booking) {
        TextView foulView = (TextView) findViewById(R.id.home_bookings);
        foulView.setText(String.valueOf(booking));
    }
    //Display the Shots madde By Home Team
    public void displayShotHome(int shot) {
        TextView shotView = (TextView) findViewById(R.id.home_shots);
        shotView.setText(String.valueOf(shot));
    }

    public void displayontargetHome(int ontarget) {
        TextView ontargetView = (TextView) findViewById(R.id.home_ontarg);
        ontargetView.setText(String.valueOf(ontarget));
    }
    //Increase The Goal of the Away Team
    public void goalAway(View view) {
        scoreAway += 1;
        displayGoalAway(scoreAway);
    }
    //increase The Foul made by Away Team
    public void foulByAway(View view) {
        foulAway += 1;
        displayFoulAway(foulAway);
    }
    //Display The Yellow card By Away team

    public void bookingByAway(View view) {
        bookingAway += 1;
        displayBookingAway(bookingAway);


    }
    //Increase the Shots made By Away team
    public void shotsByAway(View view) {
        shotAway += 1;
        displayShotAway(shotAway);

    }
    //Increase the On Target made By Away team

    public void ontargetByAway(View view) {
        ontargetAway += 1;
        displayontargetAway(ontargetAway);

    }
    //Display the Goal Made By Away Team
    public void displayGoalAway(int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_b_score);
        goalView.setText(String.valueOf(goal));
    }


    //Display Foul made By Away Team
    public void displayFoulAway(int foul) {
        TextView foulView = (TextView) findViewById(R.id.away_fouls);
        foulView.setText(String.valueOf(foul));
    }
    //Display Yellow made By Away Team
    public void displayBookingAway(int booking) {
        TextView foulView = (TextView) findViewById(R.id.away_bookings);
        foulView.setText(String.valueOf(booking));
    }
    //Display Shots made By Away Team
    public void displayShotAway(int shot) {
        TextView shotView = (TextView) findViewById(R.id.away_shots);
        shotView.setText(String.valueOf(shot));
    }
    //Display On Target made By Away Team
    public void displayontargetAway(int ontarget) {
        TextView ontargetView = (TextView) findViewById(R.id.away_ontarg);
        ontargetView.setText(String.valueOf(ontarget));
    }
    //To Reset The Score
    public void resetScore  (View view) {
        scoreHome = 0;
        scoreAway = 0;
        foulHome = 0;
        foulAway = 0;
        bookingAway = 0;
        bookingHome = 0;
        shotHome = 0;
        shotAway = 0;
        ontargetHome = 0;
        ontargetAway = 0;
        displayGoalHome(scoreHome);
        displayFoulHome(foulHome);
        displayGoalAway(scoreAway);
        displayFoulAway(foulAway);
        displayBookingHome(bookingHome);
        displayBookingAway(bookingAway);
        displayShotHome(shotHome);
        displayShotAway(shotAway);
        displayontargetHome(ontargetHome);
        displayontargetAway(ontargetAway);
    }
    //When The Submit Button Clicked to Add the Current Data Into Database
    public void Adddata()
    {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scoreHome>scoreAway)
                {
                    g1=teamNameFirst+" is The Winner";
                }
                else if(scoreHome==scoreAway)
                {
                    g1="Match Tie";
                }
                else
                {
                    g1=teamNameSecond+" is The Winner";
                }
                boolean isInsert= mydb.insertdata(teamNameFirst,scoreHome,teamNameSecond,scoreAway,g1);
                if(isInsert)
                {
                    Toast.makeText(getApplicationContext(),"Data inserte Sucessfully",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data inserte UnSucessfully",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //To Show The Current Data Of the Database
    public void ShowData()
    {
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=mydb.getAllData();
                if(res.getCount()== 0)
                {
                    showMessage("Error","No Data Found");
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext())

                {
                    buffer.append("MATCH_NO : "+ res.getString(0)+"\n");
                    buffer.append("HOME_TEAM : "+ res.getString(1)+"\n");
                    buffer.append("HOME_TEAM_SCORE : "+ res.getString(2)+"\n");
                    buffer.append("AWAY_TEAM : "+ res.getString(3)+"\n");
                    buffer.append("AWAY_TEAM_SCORE : "+ res.getString(4)+"\n");
                    buffer.append("STATUS : "+ res.getString(5)+"\n\n");
                }
                showMessage("SCORE_CARD",buffer.toString());

            }
        });
    }
    //This Bunch of code is for Showing The Data in proper Format
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}
