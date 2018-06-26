public class TestMatrices {

    public static Matrix getTestMatrixNo50_131() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(19, 10, 19, 10, 19));
        matrix.addRow(new Row(21, 23, 20, 19, 12));
        matrix.addRow(new Row(20, 12, 20, 11, 10));
        return matrix;
    }

    public static Matrix getTestMatrixYes16_123445() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 8, 6, 4));

        return matrix;
    }

    public static Matrix getTestMatrixYes11_121545() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 1, 2, 3));
        return matrix;
    }
}
