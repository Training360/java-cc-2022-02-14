package datamunging;

public class FootballTeamGoals {
    private String name;

    private int forGoals;

    private int againstGoals;

    public int diffBetweenGoals() {
        return Math.abs(forGoals - againstGoals);
    }

    public static FootballTeamGoals parseLine(String line) {
        var goals = new FootballTeamGoals();
        goals.name = line.substring(7, 22).trim();
        goals.forGoals = Integer.parseInt(line.substring(43, 45).trim());
        goals.againstGoals = Integer.parseInt(line.substring(50, 52).trim());
        return goals;
    }

    public String getName() {
        return name;
    }
}
