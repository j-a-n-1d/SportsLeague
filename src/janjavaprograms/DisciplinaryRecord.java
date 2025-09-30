package janjavaprograms;
public class DisciplinaryRecord {
    private Player player;
    private String action;
    public DisciplinaryRecord(Player player, String action) {
        this.player = player;
        this.action = action;
    }
    @Override
    public String toString() {
        return player.getName() + " (" + player.getTeam().getName() + "): " + action;
    }
}
