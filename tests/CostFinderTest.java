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
    public void itFindsAPathCost() {

        verifyMatrix(new PathResult(16, true, new int[]{1, 2, 3, 4, 4, 5}), getTestMatrixYes16_123445());
        verifyMatrix(new PathResult(11, true, new int[]{1, 2, 1, 5, 4, 5}), getTestMatrixYes11_121545());
    }

    private void verifyMatrix(PathResult expectedPathResult, Matrix matrix) {
        Path path = costFinder.getLeastCostPath(matrix);
        PathResult actualPathResult = new PathResult(path, matrix);
        path.print();
        assertNotNull(path);
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

    private Matrix getTestMatrixYes16_123445() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 8, 6, 4));

        return matrix;
    }


    private Matrix getTestMatrixYes11_121545() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 1, 2, 3));
        return matrix;
    }
/*

After you complete the code, please check it for the below inputs. we need correct output for all the cases. You can include them as part of your test cases.

Sample 1: (6X5 matrix normal flow)

Input:

3 4 1 2 8 6

6 1 8 2 7 4

5 9 3 9 9 5

8 4 1 3 2 6

3 7 2 8 6 4



Output:

Yes

16

[1 2 3 4 4 5]



Sample 2: (6X5 matrix normal flow)

Input:

3 4 1 2 8 6

6 1 8 2 7 4

5 9 3 9 9 5

8 4 1 3 2 6

3 7 2 1 2 3



Output:

Yes

11

[1 2 1 5 4 5]



Sample 3: (5X3 matrix with no path <50)

Input:

19 10 19 10 19

21 23 20 19 12

20 12 20 11 10



Output:

No

48

[1 1 1]



Sample 4: (1X5 matrix)

Input:

5 8 5 3 5



Output:

Yes

26

[1 1 1 1 1]



Sample 5: (5X1 matrix)

Input:

5

8

5

3

5



Output:

Yes

3

[4]



Sample 6: (Non numeric input, Optional)

Input:

5 4 H

8 M 7

5 7 5



Output:

Invalid matrix



Sample 7: (No input - Optional)

Input:



Output:

Invalid matrix



Sample 8: (Starting with >50)

Input:

69 10 19 10 19

51 23 20 19 12

60 12 20 11 10



Output:

No

0

[]



Sample 9: (One value >50)

Input:

60 3 3 6

6 3 7 9

5 6 8 3



Output:

Yes

14

[3,2 1 3]



Sample 10: (Negative values)

Input:

6,3,-5,9

-5,2,4,10

3,-2,6,10

6,-1,-2,10



Output:

Yes

0

[2,3 4 1]
 */
}