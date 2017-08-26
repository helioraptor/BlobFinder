import model.Field;
import model.Result;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by azorin on 26/08/2017.
 */
public class BlobFinderTest {
    @org.junit.jupiter.api.Test
    public void find() throws Exception{
        int[][] data = {{0,0,0,0,0,0,0,0,0,0}
                       ,{0,0,1,1,1,0,0,0,0,0}
                       ,{0,0,1,1,1,1,1,0,0,0}
                       ,{0,0,1,0,0,0,1,0,0,0}
                       ,{0,0,1,1,1,1,1,0,0,0}
                       ,{0,0,0,0,1,0,1,0,0,0}
                       ,{0,0,0,0,1,0,1,0,0,0}
                       ,{0,0,0,0,1,1,1,0,0,0}
                       ,{0,0,0,0,0,0,0,0,0,0}
                       ,{0,0,0,0,0,0,0,0,0,0}};


            Result result = new BlobFinder().find(new Field(data));

            assertAll("result correct",
                    () -> assertEquals(1, result.Top),
                    () -> assertEquals(2, result.Left),
                    () -> assertEquals(7, result.Bottom),
                    () -> assertEquals(6, result.Right)
            );

            assertTrue(result.CellReads <= 44);
    }

    @org.junit.jupiter.api.Test
    public void findAnother() throws Exception{
        int[][] data = { {0,0,1,0,0,0,0,0,0,0}
                        ,{0,0,1,1,1,0,0,0,0,0}
                        ,{0,0,1,1,1,1,1,0,0,0}
                        ,{0,0,1,0,0,0,1,0,0,0}
                        ,{1,1,1,1,1,1,1,0,0,0}
                        ,{0,0,0,0,1,0,1,0,0,0}
                        ,{0,0,0,0,1,0,1,1,1,1}
                        ,{0,0,0,0,1,1,1,0,0,0}
                        ,{0,0,0,0,1,0,0,0,0,0}
                        ,{0,0,0,0,1,0,0,0,0,0}};


        Result result = new BlobFinder().find(new Field(data));

        assertAll("result correct",
                () -> assertEquals(0, result.Top),
                () -> assertEquals(0, result.Left),
                () -> assertEquals(9, result.Bottom),
                () -> assertEquals(9, result.Right)
        );

        assertTrue(result.CellReads <= 44);
    }
}