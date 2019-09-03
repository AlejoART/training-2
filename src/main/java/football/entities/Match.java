package football.entities;

public class Match {
    String team1;
    String team2;
    String result;
    int resultTeam1;
    int resultTeam2;
    int points = 0;

    public Match(String team1, String team2, String result) {
        super();
        this.team1 = team1;
        this.team2 = team2;
        this.result = result;
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

    public void setResultTeam1(String result) {
        String [] bothResults = result.split("-");
        this.resultTeam1 = Integer.parseInt(bothResults[0].trim());
    }

    public int getResultTeam2() {
        return resultTeam2;
    }

    public void setResultTeam2(String result) {
        String [] bothResults = result.split("-");
        this.resultTeam2 = Integer.parseInt(bothResults[1].trim());
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
