package integrated;

public class FootballTeamGoals implements DataItem {

    private int forGoals;

    private int againstGoals;

    private String name;

    public FootballTeamGoals(String name, int forGoals, int againstGoals) {
        this.name = name;
        this.forGoals = forGoals;
        this.againstGoals = againstGoals;
    }

    @Override
    public int getOrderBy() {
        return Math.abs(forGoals - againstGoals);
    }

    @Override
    public String getDescription() {
        return name;
    }
}
