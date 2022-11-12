package hometask.collection.dictionary_maps;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> files;

    public FileNavigator() {
        files = new HashMap<>();
    }

    public void add(String path, FileData file) {
        checkConsistentPath(path, file);
        String key = file.getPath();
        if (files.containsKey(key)) {
            files.get(key).add(file);
        } else {
            List<FileData> list = new ArrayList<>();
            list.add(file);
            files.put(key, list);
        }
    }

    private void checkConsistentPath(String path, FileData file) {
        if (!path.equals(file.getPath())) {
            throw new RuntimeException(String.format(
                    "Path not consistent\n Path: %s \n FileDate: {name: %s, size: %s, path:%s}",
                    path, file.getName(), file.getSize(), file.getPath()));
        }
    }

    public List<FileData> find(String path) {
        return files.get(path);
    }

    public List<FileData> filterBySize(int maxSize) {
        List<FileData> list = new ArrayList<>();
        for (List<FileData> value : files.values()) {
            for (FileData file : value) {
                if ((file.getSize() <= maxSize)) {
                    list.add(file);
                }
            }
        }
        return list;
    }

    public void remove(String path) {
        files.remove(path);
    }

    public List<FileData> sortBySize() {
        List<FileData> sortingList = convertMapValuesForList();
        Collections.sort(sortingList, new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                return o1.getSize() - o2.getSize();
            }
        });
        return sortingList;
    }

    private List<FileData> convertMapValuesForList() {
        List<FileData> list = new ArrayList<>();
        for (List<FileData> value : files.values()) {
            list.addAll(value);
        }
        return list;
    }
}
