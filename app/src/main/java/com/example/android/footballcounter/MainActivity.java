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
    int scoreHome = 0;
    int scoreAway = 0;
    int foulHome = 0;
    int foulAway = 0;
    int bookingHome = 0;
    int bookingAway = 0;
    int shotHome = 0;
    int shotAway = 0;
    int ontargetHome = 0;
    int ontargetAway = 0;
    String g1;
    TextView teamname_w,teamname_a,Team_score_A,Team_score_B;
    ImageView team_a,team_b;
    Button submit,show;
    DatabaseHelper mydb;
   String Team_name_first,Team_name_second;
   int Team_logo_1,Team_logo_2;
    private Window mWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWindow = getWindow();
        mWindow.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        Team_score_A=(TextView)findViewById(R.id.team_a_score);
        Team_score_B=(TextView)findViewById(R.id.team_b_score);
        show=(Button)findViewById(R.id.Score_card);
        mydb=new DatabaseHelper(this);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            Team_name_first = bundle.getString("team_a");
            Team_name_second=bundle.getString("team_b");
            Team_logo_1=bundle.getInt("team_logo_a");
            Team_logo_2=bundle.getInt("team_logo_b");

        }


        teamname_w=(TextView)findViewById(R.id.Team_name_1);
        teamname_a=(TextView)findViewById(R.id.Team_name_A);
        team_a=(ImageView)findViewById(R.id.Team_A);
        team_b=(ImageView)findViewById(R.id.Team_B);
        submit=(Button)findViewById(R.id.Submit);
        teamname_w.setText(Team_name_first);
        teamname_a.setText(Team_name_second);
        team_a.setImageResource(Team_logo_1);
        team_b.setImageResource(Team_logo_2);
        Adddata();
        ShowData();

    }

    public void goalHome(View view) {
        scoreHome += 1;
        displayGoalHome(scoreHome);
    }

    public void foulByHome(View view) {
        foulHome += 1;
        displayFoulHome(foulHome);
    }

    public void bookingByHome(View view) {
        bookingHome += 1;
        displayBookingHome(bookingHome);

    }

    public void shotsByHome(View view) {
        shotHome += 1;
        displayShotHome(shotHome);

    }

    public void ontargetByHome(View view) {
        ontargetHome += 1;
        displayontargetHome(ontargetHome);

    }



    public void displayGoalHome(int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_a_score);
        goalView.setText(String.valueOf(goal));
    }

    public void displayFoulHome(int foul) {
        TextView foulView = (TextView) findViewById(R.id.home_fouls);
        foulView.setText(String.valueOf(foul));
    }

    public void displayBookingHome(int booking) {
        TextView foulView = (TextView) findViewById(R.id.home_bookings);
        foulView.setText(String.valueOf(booking));
    }

    public void displayShotHome(int shot) {
        TextView shotView = (TextView) findViewById(R.id.home_shots);
        shotView.setText(String.valueOf(shot));
    }

    public void displayontargetHome(int ontarget) {
        TextView ontargetView = (TextView) findViewById(R.id.home_ontarg);
        ontargetView.setText(String.valueOf(ontarget));
    }

    public void goalAway(View view) {
        scoreAway += 1;
        displayGoalAway(scoreAway);
    }

    public void foulByAway(View view) {
        foulAway += 1;
        displayFoulAway(foulAway);
    }

    public void bookingByAway(View view) {
        bookingAway += 1;
        displayBookingAway(bookingAway);


    }

    public void shotsByAway(View view) {
        shotAway += 1;
        displayShotAway(shotAway);

    }

    public void ontargetByAway(View view) {
        ontargetAway += 1;
        displayontargetAway(ontargetAway);

    }

    public void displayGoalAway(int goal) {
        TextView goalView = (TextView) findViewById(R.id.team_b_score);
        goalView.setText(String.valueOf(goal));
    }



    public void displayFoulAway(int foul) {
        TextView foulView = (TextView) findViewById(R.id.away_fouls);
        foulView.setText(String.valueOf(foul));
    }

    public void displayBookingAway(int booking) {
        TextView foulView = (TextView) findViewById(R.id.away_bookings);
        foulView.setText(String.valueOf(booking));
    }

    public void displayShotAway(int shot) {
        TextView shotView = (TextView) findViewById(R.id.away_shots);
        shotView.setText(String.valueOf(shot));
    }

    public void displayontargetAway(int ontarget) {
        TextView ontargetView = (TextView) findViewById(R.id.away_ontarg);
        ontargetView.setText(String.valueOf(ontarget));
    }

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
    public void Adddata()
    {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(scoreHome>scoreAway)
                {
                    g1=Team_name_first+" is The Winner";
                }
                else if(scoreHome==scoreAway)
                {
                    g1="Match Tie";
                }
                else
                {
                    g1=Team_name_second+" is The Winner";
                }
                boolean isInsert= mydb.insertdata(Team_name_first,scoreHome,Team_name_second,scoreAway,g1);
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
    public void showMessage(String title,String Message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}
