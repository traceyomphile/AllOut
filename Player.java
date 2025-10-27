public class Player {
    private String name;
    private boolean isSubstitute;
    private int score;

    public Player(String name, boolean isSubstitute) {
        this.name = name;
        this.isSubstitute = isSubstitute;
        this.score = 0;
    }

    public String getName() {return this.name;}

    public boolean isSubstitute() {return this.isSubstitute;}

    public void incrementScore(int scr) {
        this.score += scr;
    }

    public int getScore() {return this.score;}

}