package streams;

public class Match {
    private String teamA;
    private String teamB;
    private Integer goalsA;
    private Integer goalsB;

    public Match(String teamA, String teamB, Integer goalsA, Integer goalsB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public Integer getGoalsA() {
        return goalsA;
    }

    public void setGoalsA(Integer goalsA) {
        this.goalsA = goalsA;
    }

    public Integer getGoalsB() {
        return goalsB;
    }

    public void setGoalsB(Integer goalsB) {
        this.goalsB = goalsB;
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamA='" + teamA + '\'' +
                ", teamB='" + teamB + '\'' +
                ", goalsA=" + goalsA +
                ", goalsB=" + goalsB +
                '}';
    }
}
