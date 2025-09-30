package janjavaprograms;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class MainApp {
    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, Team> teams = new HashMap<>();
    private static Map<Integer, Fixture> fixtures = new HashMap<>();
    private static Map<String, Standing> standings = new HashMap<>();
    private static List<DisciplinaryRecord> logs = new ArrayList<>();
    private static int fixtureId = 1;
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            switch (sc.nextLine()) {
                case "1" -> addTeam();
                case "2" -> addPlayer();
                case "3" -> createFixture();
                case "4" -> recordMatch();
                case "5" -> viewStandings();
                case "6" -> viewLogs();
                case "7" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }
    private static void printMenu() {
        System.out.println("--- SPORTS LEAGUE ---");
        System.out.println("1. Add Team");
        System.out.println("2. Add Player");
        System.out.println("3. Create Fixture");
        System.out.println("4. Record Match Result");
        System.out.println("5. View Standings");
        System.out.println("6. View Disciplinary Log");
        System.out.println("7. Exit");
        System.out.print("Choose: ");
    }
    private static void addTeam() {
        System.out.print("Team name: ");
        String name = sc.nextLine();
        if (teams.containsKey(name)) { System.out.println("Already exists."); return; }
        Team t = new Team(name);
        teams.put(name, t);
        standings.put(name, new Standing(name));
        System.out.println("Team added.");
    }
    private static void addPlayer() {
        System.out.print("Player name: ");
        String pname = sc.nextLine();
        System.out.print("Team name: ");
        String tname = sc.nextLine();
        Team t = teams.get(tname);
        if (t == null) { System.out.println("No such team."); return; }
        Player p = new Player(pname, t);
        t.addPlayer(p);
        System.out.println("Player added to " + tname);
    }
    private static void createFixture() {
        System.out.print("Home team: ");
        Team home = teams.get(sc.nextLine());
        System.out.print("Away team: ");
        Team away = teams.get(sc.nextLine());
        if (home == null || away == null || home == away) {
            System.out.println("Invalid teams."); return;
        }
        System.out.print("Enter date (yyyy-MM-dd HH:mm): ");
        LocalDateTime dt = LocalDateTime.parse(sc.nextLine(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        Fixture f = new Fixture(fixtureId++, home, away, dt);
        fixtures.put(f.getId(), f);
        System.out.println("Fixture created: " + f);
    }
    private static void recordMatch() {
        System.out.print("Fixture ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Fixture f = fixtures.get(id);
        if (f == null) { System.out.println("No such fixture."); return; }
        System.out.print("Home score: ");
        int hs = Integer.parseInt(sc.nextLine());
        System.out.print("Away score: ");
        int as = Integer.parseInt(sc.nextLine());
        Result r = new Result(f.getHomeTeam(), f.getAwayTeam(), hs, as);
        standings.get(f.getHomeTeam().getName()).update(r);
        standings.get(f.getAwayTeam().getName()).update(r);
        System.out.println("Result recorded: " + r);
    }
    private static void viewStandings() {
        List<Standing> list = new ArrayList<>(standings.values());
        Collections.sort(list);
        System.out.println("--- League Table ---");
        for (Standing s : list) System.out.println(s);
    }
    private static void viewLogs() {
        System.out.println("--- Disciplinary Log ---");
        for (DisciplinaryRecord dr : logs) System.out.println(dr);
    }
}
