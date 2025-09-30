package janjavaprograms;
public class Match {
    private Fixture fixture;
    private Result result;
    public Match(Fixture fixture) {
        this.fixture = fixture;
    }
    public Fixture getFixture() { return fixture; }
    public Result getResult() { return result; }
    public void setResult(Result r) {
        this.result = r;
    }
    @Override
    public String toString() {
        return fixture.toString() + (result != null ? " | " + result : " | Pending");
    }
}
