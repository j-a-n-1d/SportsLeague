package janjavaprograms;
import java.time.LocalDateTime;
public class Fixture {
    private int id;
    private Team homeTeam;
    private Team awayTeam;
    private LocalDateTime dateTime;
    public Fixture(int id, Team home, Team away, LocalDateTime dateTime) {
        this.id = id;
        this.homeTeam = home;
        this.awayTeam = away;
        this.dateTime = dateTime;
    }
    public int getId() { return id; }
    public Team getHomeTeam() { return homeTeam; }
    public Team getAwayTeam() { return awayTeam; }
    public LocalDateTime getDateTime() { return dateTime; }
    @Override
    public String toString() {
        return String.format("Fixture #%d: %s vs %s at %s",
                id, homeTeam.getName(), awayTeam.getName(), dateTime);
    }
}
