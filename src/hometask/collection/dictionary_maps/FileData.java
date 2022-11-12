package hometask.collection.dictionary_maps;

public class FileData {
    private String name;
    private int size;
    private String path;

    public FileData(String name, int size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }
}
