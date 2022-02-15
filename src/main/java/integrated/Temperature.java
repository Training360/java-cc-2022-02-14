package integrated;

public class Temperature implements DataItem {

    private int day;

    private int min;

    private int max;

    public Temperature(int day, int min, int max) {
        this.day = day;
        this.min = min;
        this.max = max;
    }

    @Override
    public int getOrderBy() {
        return Math.abs(min - max);
    }

    @Override
    public String getDescription() {
        return Integer.toString(day);
    }
}
