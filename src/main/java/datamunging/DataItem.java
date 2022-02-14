package datamunging;

public class DataItem {

    private int day;

    private int min;

    private int max;

    public static DataItem of(String line) {
        DataItem dataItem = new DataItem();

        dataItem.day = Integer.parseInt(line.substring(2, 4).trim());
        dataItem.max = Integer.parseInt(line.substring(6, 8).trim());
        dataItem.min = Integer.parseInt(line.substring(12, 14).trim());
        return dataItem;
    }

    public int diff() {
        return max - min;
    }

    public int getDay() {
        return day;
    }

}
