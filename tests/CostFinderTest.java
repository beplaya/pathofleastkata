import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CostFinderTest {

    private CostFinder costFinder;

    @Before
    public void setup() {
        costFinder = new CostFinder();
    }

    @Test
    public void itFindsAPath() {
        verifyMatrix(new PathResult(16, true, new int[]{1, 2, 3, 4, 4, 5}), TestMatrices.getTestMatrixYes16_123445());
        verifyMatrix(new PathResult(11, true, new int[]{1, 2, 1, 5, 4, 5}), TestMatrices.getTestMatrixYes11_121545());
    }

    @Test
    public void itDoesntFindAPath() {
        verifyMatrix(new PathResult(50, false, new int[]{1, 3, 1}), TestMatrices.getTestMatrixNo50_131());
    }

    private void verifyMatrix(PathResult expectedPathResult, Matrix matrix) {
        Path path = costFinder.getLeastCostPath(matrix);
        assertNotNull(path);
        PathResult actualPathResult = new PathResult(path, matrix);
        assertEquals(expectedPathResult.isFullPath, actualPathResult.isFullPath);
        assertEquals(expectedPathResult.cost, actualPathResult.cost);
        assertArray(expectedPathResult.getOneBasedRows(), actualPathResult.getOneBasedRows());
    }

    private void assertArray(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }


}