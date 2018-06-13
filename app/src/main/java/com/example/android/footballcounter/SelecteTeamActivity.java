package com.example.android.footballcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SelecteTeamActivity extends AppCompatActivity {
    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;
    TextView letsplay;
    private Window mWindow;

    String clickedCountryName1,clickedCountryName2;
    int clickedCountrylogo1,clickedCountrylogo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecte_team);
        mWindow = getWindow();
        mWindow.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        letsplay=(TextView)findViewById(R.id.letsplay);
        initList();

        Spinner spinnerCountries1 = findViewById(R.id.spinner_countries);
        Spinner spinnerCountries2 = findViewById(R.id.spinner_countries2);

        mAdapter = new CountryAdapter(this, mCountryList);
        spinnerCountries1.setAdapter(mAdapter);
        spinnerCountries2.setAdapter(mAdapter);

        spinnerCountries1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                clickedCountryName1 = clickedItem.getCountryName();
                clickedCountrylogo1=clickedItem.getFlagImage();

                //Toast.makeText(SelecteTeamActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerCountries2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) parent.getItemAtPosition(position);
                clickedCountryName2 = clickedItem.getCountryName();
                clickedCountrylogo2=clickedItem.getFlagImage();
                //Toast.makeText(SelecteTeamActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        letsplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clickedCountryName1.equals(clickedCountryName2))
                {
                    Toast.makeText(getApplicationContext(),"Are you kidding ,Please Select Different Team",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent i=new Intent(SelecteTeamActivity.this,MainActivity.class);
                    i.putExtra("team_a",clickedCountryName1);
                    i.putExtra("team_b",clickedCountryName2);
                    i.putExtra("team_logo_a",clickedCountrylogo1);
                    i.putExtra("team_logo_b",clickedCountrylogo2);
                    startActivity(i);
                }


            }
        });
    }

    private void initList() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new CountryItem(getString(R.string.team_4_1), R.drawable.team_4_1));
        mCountryList.add(new CountryItem(getString(R.string.team_3_2), R.drawable.team_3_2));
        mCountryList.add(new CountryItem(getString(R.string.team_7_1), R.drawable.team_7_1));
        mCountryList.add(new CountryItem(getString(R.string.team_5_1), R.drawable.team_5_1));
        mCountryList.add(new CountryItem(getString(R.string.team_8_3), R.drawable.team_8_3));
        mCountryList.add(new CountryItem(getString(R.string.team_4_3), R.drawable.team_4_3));
        mCountryList.add(new CountryItem(getString(R.string.team_5_3), R.drawable.team_5_3));
        mCountryList.add(new CountryItem(getString(R.string.team_3_4), R.drawable.team_3_4));
        mCountryList.add(new CountryItem(getString(R.string.team_7_4), R.drawable.team_7_4));
        mCountryList.add(new CountryItem(getString(R.string.team_3_1), R.drawable.team_3_1));
        mCountryList.add(new CountryItem(getString(R.string.team_1_3), R.drawable.team_1_3));
        mCountryList.add(new CountryItem(getString(R.string.team_6_1), R.drawable.team_6_1));
        mCountryList.add(new CountryItem(getString(R.string.team_2_4), R.drawable.team_2_4));
        mCountryList.add(new CountryItem(getString(R.string.team_4_2), R.drawable.team_4_2));
        mCountryList.add(new CountryItem(getString(R.string.team_8_4), R.drawable.team_8_4));
        mCountryList.add(new CountryItem(getString(R.string.team_6_2), R.drawable.team_6_2));
        mCountryList.add(new CountryItem(getString(R.string.team_2_3), R.drawable.team_2_3));
        mCountryList.add(new CountryItem(getString(R.string.team_4_4), R.drawable.team_4_4));
        mCountryList.add(new CountryItem(getString(R.string.team_7_2), R.drawable.team_7_2));
        mCountryList.add(new CountryItem(getString(R.string.team_3_3), R.drawable.team_3_3));
        mCountryList.add(new CountryItem(getString(R.string.team_8_1), R.drawable.team_8_1));
        mCountryList.add(new CountryItem(getString(R.string.team_2_1), R.drawable.team_2_1));
        mCountryList.add(new CountryItem(getString(R.string.team_1_1), R.drawable.team_1_1));
        mCountryList.add(new CountryItem(getString(R.string.team_1_2), R.drawable.team_1_2));
        mCountryList.add(new CountryItem(getString(R.string.team_8_2), R.drawable.team_8_2));
        mCountryList.add(new CountryItem(getString(R.string.team_5_4), R.drawable.team_5_4));
        mCountryList.add(new CountryItem(getString(R.string.team_6_4), R.drawable.team_6_4));
        mCountryList.add(new CountryItem(getString(R.string.team_2_2), R.drawable.team_2_2));
        mCountryList.add(new CountryItem(getString(R.string.team_6_3), R.drawable.team_6_3));
        mCountryList.add(new CountryItem(getString(R.string.team_5_2), R.drawable.team_5_2));
        mCountryList.add(new CountryItem(getString(R.string.team_7_3), R.drawable.team_7_3));
        mCountryList.add(new CountryItem(getString(R.string.team_1_4), R.drawable.team_1_4));
    }




    }

