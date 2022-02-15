package integrated;

public enum FileType {

    FOOTBALL {

        @Override
        public DataItem parse(String line) {
            var name = line.substring(7, 22).trim();
            var forGoals = Integer.parseInt(line.substring(43, 45).trim());
            var againstGoals = Integer.parseInt(line.substring(50, 52).trim());
            return new FootballTeamGoals(name, forGoals, againstGoals);
        }

        @Override
        public int getHeaderLines() {
            return 2;
        }

        @Override
        public boolean isValidLine(String line) {
            return !line.contains("---");
        }
    },
    TEMPERATURE {
        @Override
        public DataItem parse(String line) {
            var day = Integer.parseInt(line.substring(2, 4).trim());
            var max = Integer.parseInt(line.substring(6, 8).trim());
            var min = Integer.parseInt(line.substring(12, 14).trim());

            return new Temperature(day, min, max);
        }

        @Override
        public int getHeaderLines() {
            return 2;
        }

        @Override
        public boolean isValidLine(String line) {
            return !line.contains("mo");
        }
    };

    public abstract DataItem parse(String line);

    public abstract int getHeaderLines();

    public abstract boolean isValidLine(String line);
}
