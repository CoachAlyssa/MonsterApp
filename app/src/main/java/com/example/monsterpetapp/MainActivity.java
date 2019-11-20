package com.example.monsterpetapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    ArrayList<Monster> monsters = new ArrayList<>();
    int currentMonster;
    Monster current;

    ProgressBar overallProgress;
    ProgressBar foodProgress;
    ProgressBar playProgress;
    ProgressBar hygieneProgress;
    ProgressBar loveProgress;

    TextView overallVal;
    TextView foodVal;
    TextView playVal;
    TextView hygieneVal;
    TextView loveVal;


    CountDownTimer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Monster monster = createMonster();
        monsters.add(monster);
        currentMonster=0;
        current = monsters.get(currentMonster);

        foodProgress = (ProgressBar) findViewById(R.id.foodStatus);
        playProgress = (ProgressBar) findViewById(R.id.playStatus);
        hygieneProgress = (ProgressBar) findViewById(R.id.hygieneStatus);
        loveProgress = (ProgressBar) findViewById(R.id.loveStatus);
        overallProgress = (ProgressBar) findViewById(R.id.overallStatus);

        foodVal = (TextView) findViewById(R.id.food);
        playVal = (TextView) findViewById(R.id.play);
        hygieneVal = (TextView) findViewById(R.id.hygiene);
        loveVal = (TextView) findViewById(R.id.love);
        overallVal = (TextView) findViewById(R.id.overall);

        timer = new CountDownTimer(3000000, 1000) {
            @Override
            public void onTick(long l) {
                decreaseValues();
                updateMonster();
                checkStatus();
            }

            @Override
            public void onFinish() {

            }
        }.start();

        updateMonster();
    }

    public Monster createMonster(){
        Monster pet = new Monster(getResources().getDrawable(R.drawable.monster1));
        return pet;
    }

    public void addValue(View v){
        Log.i("view",String.valueOf(v.getId()) );
        switch (v.getId()){
            case R.id.option1:
                current.setFood(current.getFood()+5);
                break;
            case R.id.option2:
                current.setPlay(current.getPlay()+5);
                break;
            case R.id.option3:
                current.setHygiene(current.getHygiene()+5);
                break;
            case R.id.option4:
                current.setLove(current.getLove()+5);
                break;
        }
        updateMonster();
    }

    //Checks if any of the health values are above 100%
    public void checkStatus(){
        Log.i("check", String.valueOf(current.getOverall() <=0));
        if(current.getOverall() <= 0){
            Toast.makeText(getApplicationContext(), "Your pet died..", Toast.LENGTH_SHORT).show();
            timer.cancel();
        }
    }


    public void updateMonster(){
//        Log.i("Stats", " "+ current.getFood() + ", " + current.getHygiene() + ", " + current.getPlay() + ", " + current.getLove());

        foodProgress.setProgress(current.getFood());
        playProgress.setProgress(current.getPlay());
        hygieneProgress.setProgress(current.getHygiene());
        loveProgress.setProgress(current.getLove());
//        if(current.getOverall() > 66){
//            overallProgress.getProgressDrawable().setColorFilter(
//                    Color.parseColor("#99ff99"), android.graphics.PorterDuff.Mode.SRC_IN);
//        }else if(current.getOverall() > 33){
//            overallProgress.getProgressDrawable().setColorFilter(
//                    Color.parseColor("#ffa500"), android.graphics.PorterDuff.Mode.SRC_IN);
//        }else{
//            overallProgress.getProgressDrawable().setColorFilter(
//                    Color.parseColor("#ff1010"), android.graphics.PorterDuff.Mode.SRC_IN);
//        }
        overallProgress.setProgress(current.getOverall());


        foodVal.setText(current.getFood() + "%");
        playVal.setText(current.getPlay() + "%");
        hygieneVal.setText(current.getHygiene() + "%");
        loveVal.setText(current.getLove() + "%");
        overallVal.setText(current.getOverall() + "%");
    }

    public void decreaseValues(){
        current.setFood(current.getFood()-((int) (Math.random()*5)));
        current.setPlay(current.getPlay()-((int) (Math.random()*5)));
        current.setHygiene(current.getHygiene()-((int) (Math.random()*5)));
        current.setLove(current.getLove()-((int) (Math.random()*5)));
    }


}
