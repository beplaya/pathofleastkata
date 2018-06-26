public class Main {

    public static void main(String[] args){
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 8, 6, 4));
        CostFinder costFinder = new CostFinder();
        Path leastCostPath = costFinder.getLeastCostPath(matrix);
        PathResult pathResult = new PathResult(leastCostPath, matrix);
        PathResultPrinter pathResultPrinter = new PathResultPrinter();
        System.out.println(pathResultPrinter.getPrintString(pathResult));
    }
}
