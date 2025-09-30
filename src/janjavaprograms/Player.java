package janjavaprograms;
public class Player {
    private String name;
    private Team team;
    public Player(String name, Team team) {
        this.name = name;
        this.team = team;
    }
    public String getName() { return name; }
    public Team getTeam() { return team; }
    @Override
    public String toString() {
        return name + " - " + team.getName();
    }
}
