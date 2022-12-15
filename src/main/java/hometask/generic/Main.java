package hometask.generic;

import hometask.generic.fruit.Apple;
import hometask.generic.fruit.Box;
import hometask.generic.fruit.Orange;

import java.util.List;

import static hometask.generic.convector.ConvertCollectionUtil.convertArrayToList;

public class Main {
    public static void main(String[] args) {
        String[] arrayString = {"1", "2", "3"};
        Integer[] arrayInteger = {1, 2, 3};
        List<String> listString = convertArrayToList(arrayString);
        List<Integer> listInteger = convertArrayToList(arrayInteger);

        Box<Apple> boxByApple = new Box<>();
        boxByApple.add(new Apple());
        boxByApple.add(new Apple());
        boxByApple.add(new Apple());
        Box<Apple> boxByAppleTemp = new Box<>();
        boxByAppleTemp.add(new Apple());

        List<Orange> orangeTempList = List.of(new Orange(), new Orange());
        Box<Orange> boxByOrange = new Box<>();
        boxByOrange.addAll(orangeTempList);
        boolean isWeightsBoxAreEqual = boxByApple.compare(boxByOrange);
        boxByApple.merge(boxByAppleTemp);
    }
}
