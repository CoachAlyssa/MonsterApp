package com.example.monsterpetapp;

import android.graphics.drawable.Drawable;
import android.util.Log;

public class Monster {

    private int overall;
    private int food;
    private int love;
    private int hygiene;
    private int play;
    private Drawable drawable;

    Monster (Drawable avatar){
        food = (int) (Math.random()*95) + 5;
        love = (int) (Math.random()*95) + 5;
        hygiene = (int) (Math.random()*95) + 5;
        play = (int) (Math.random()*95) + 5;
        overall = (int) ((food+love+hygiene+play)/4);
        drawable = avatar;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public int getOverall() {
        overall = (food+love+hygiene+play)/4;
//        Log.i("overall", String.valueOf(overall) + " " + String.valueOf(food) + " " + String.valueOf(play) + " " + String.valueOf(hygiene) + " " + String.valueOf(love));
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }
}
