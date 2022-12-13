package hometask.generic.convector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertCollectionUtil {
    public static <T> List convertArrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
