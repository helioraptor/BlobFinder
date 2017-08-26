import model.Dot;
import model.Field;
import model.Result;

/**
 * Created by azorin on 26/08/2017.
 */
public class BlobFinder {
    public Result find(Field field) throws Exception {
        Result result = new Result();

        result.Top = field.depth();

        System.out.print("top:" + result.Top + "\n");
        field.print();

        field = field.rotate();
        result.Left = field.depth();
        System.out.print("right:" + result.Left + "\n");
        field.print();

        field = field.rotate();
        result.Bottom = 9 - field.depth();
        System.out.print("bottom:" + result.Bottom + "\n");
        field.print();

        field = field.rotate();
        result.Right = 9 - field.depth();
        System.out.print("left:" + result.Right + "\n");
        field.print();

        System.out.print("totalReadCount:" + field.totalReadCount + "\n");
        result.CellReads = field.totalReadCount;

        return result;
    }
}




