public class PathResult {

    public final int cost;
    public final boolean isFullPath;
    private final int[] oneBasedRows;

    public PathResult(Path path, Matrix matrix) {
        this(path.getCost(), path.isFullPath(matrix), path.getOneBasedRows());
    }

    public PathResult(int cost, boolean isFullPath, int[] oneBasedRows) {
        this.cost = cost;
        this.isFullPath = isFullPath;
        this.oneBasedRows = oneBasedRows;
    }

    public int[] getOneBasedRows() {
        return oneBasedRows;
    }
}
