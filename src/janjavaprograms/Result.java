package janjavaprograms;
public class Result {
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;
    public Result(Team home, Team away, int homeScore, int awayScore) {
        this.homeTeam = home;
        this.awayTeam = away;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }
    public Team getWinner() {
        return (homeScore > awayScore) ? homeTeam :
               (awayScore > homeScore) ? awayTeam : null;
    }
    public int getHomeScore() { return homeScore; }
    public int getAwayScore() { return awayScore; }
    @Override
    public String toString() {
        return String.format("%s %d - %d %s",
                homeTeam.getName(), homeScore, awayScore, awayTeam.getName());
    }
}