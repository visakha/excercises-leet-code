package example;

import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    public static List<Integer> toListInt(int[] arryint) {
        List<Integer> list = new ArrayList<>(arryint.length);

        for (int i : arryint) {
            list.add(Integer.valueOf(i));
        }
        return list;
    }
}
