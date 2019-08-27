package football.entities;

public class Team {
    private String name;
    private String score;
    private int playedGames;

    public Team(String name, String score, int playedGames) {
        super();
        this.name = name;
        this.score = score;
        this.playedGames = playedGames;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }
}
