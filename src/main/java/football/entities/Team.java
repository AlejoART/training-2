package football.entities;

public class Team {
    private String name;
    private int score;
    private int playedGames;
    private int wonGames;

    public Team(String name, int score, int playedGames, int wonGames) {
        super();
        this.name = name;
        this.score = score;
        this.playedGames = playedGames;
        this.wonGames = wonGames;
    }

    public Team() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score += score;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }
}
