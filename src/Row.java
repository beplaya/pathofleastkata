public class Row {

    private final int[] values;

    public Row(int... values) {
        this.values = values;
    }

    public int size() {
        return values.length;
    }

    public int getColumnValue(int c) {
        return values[c];
    }
}
