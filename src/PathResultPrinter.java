public class PathResultPrinter {
    public String getPrintString(PathResult pathResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(pathResult.isFullPath ? "Yes" : "No");
        stringBuilder.append('\n');
        stringBuilder.append(pathResult.cost);
        stringBuilder.append('\n');
        int[] oneBasedRows = pathResult.getOneBasedRows();
        for (int i = 0; i < oneBasedRows.length; i++) {
            int r = oneBasedRows[i];
            stringBuilder.append(r);
            if (i < oneBasedRows.length - 1) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
