import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathResultPrinterTest {

    private PathResultPrinter printer;

    @Before
    public void setup() throws Exception {
        printer = new PathResultPrinter();
    }

    @Test
    public void itPrintsTheCorrectResultForFullPath() {
        PathResult pathResult = new PathResult(12, true, new int[]{1, 2, 3, 4});
        assertEquals("Yes\n12\n1 2 3 4", printer.getPrintString(pathResult));
    }


    @Test
    public void itPrintsTheCorrectResultForNotFullPath() {
        PathResult pathResult = new PathResult(49, false, new int[]{1, 2, 3, 4, 8});
        assertEquals("No\n49\n1 2 3 4 8", printer.getPrintString(pathResult));
    }
}