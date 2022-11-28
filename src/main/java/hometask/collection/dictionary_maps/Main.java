package hometask.collection.dictionary_maps;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("/folder1/", new FileData("file1.txt", 31, "/folder1/"));
        fileNavigator.add("/folder1/", new FileData("file2.txt", 41, "/folder1/"));
        fileNavigator.add("/folder2/", new FileData("file1.txt", 42, "/folder2/"));
        fileNavigator.add("/folder3/", new FileData("file1.txt", 43, "/folder3/"));

        fileNavigator.find("/folder1/");
        fileNavigator.filterBySize(41);
        List<FileData> sortinglist = fileNavigator.sortBySize();
        fileNavigator.remove("/folder3/");
    }
}
