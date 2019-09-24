package football.entities;

public class Match {
    private String team1;
    private String team2;
    private String result;
    private int resultTeam1;
    private int resultTeam2;
    private int points = 0;

    public Match(String team1, String team2, int resultTeam1, int resultTeam2) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.resultTeam1 = resultTeam1;
        this.resultTeam2 = resultTeam2;
    }

    public Match() {
        super();
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getResultTeam1() {
        return resultTeam1;
    }

    public void setResultTeam1(int result) {
        this.resultTeam1 = result;
    }

    public int getResultTeam2() {
        return resultTeam2;
    }

    public void setResultTeam2(int result) {
        this.resultTeam2 = result;
    }

    public int addPointsToTeam1(int result1, int result2){

        if(result1 == result2){
            points += 1;
        }
        if(result1 > result2){
            points += 3;
        }
        if(result1 < result2){
            points += 0;
        }
        return points;
    }

    public int addPointsToTeam2(int result1, int result2){
        if(result1 == result2){
            points += 1;
        }
        if(result2 > result1){
            points += 3;
        }
        if(result2 < result1){
            points += 0;
        }
        return points;
    }
}
