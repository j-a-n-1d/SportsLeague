package janjavaprograms;
public class Standing implements Comparable<Standing> {
    private String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int points;
    public Standing(String teamName) {
        this.teamName = teamName;
    }
    public void update(Result r) {
        played++;
        if (r.getWinner() == null) { drawn++; points += 1; }
        else if (r.getWinner().getName().equals(teamName)) { won++; points += 3; }
        else { lost++; }
        if (r.toString().contains(teamName)) {
        }
    }
    public int getPoints() { return points; }
    public int getPlayed() { return played; }
    @Override
    public int compareTo(Standing o) {
        return Integer.compare(o.points, this.points);
    }
    @Override
    public String toString() {
        return String.format("%s | P:%d W:%d D:%d L:%d Pts:%d",
                teamName, played, won, drawn, lost, points);
    }
}
