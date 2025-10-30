package com.tracey.cricket.model;

public class Player {
    private final String name;
    private final boolean isSubstitute;
    private int score;

    public Player(String name, boolean isSubstitute) {
        this.name = name;
        this.isSubstitute = isSubstitute;
        this.score = 0;
    }

    public Player(Player player) {
        this.name = player.getName();
        this.isSubstitute = player.isSubstitute();
        this.score = player.getScore();
    }

    public String getName() {return this.name;}

    public boolean isSubstitute() {return this.isSubstitute;}

    public void incrementScore(int scr) {
        this.score += scr;
    }

    public int getScore() {return this.score;}

}