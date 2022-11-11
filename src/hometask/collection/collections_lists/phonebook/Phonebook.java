package hometask.collection.collections_lists.phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Phonebook {
    private Map<String, List<Recording>> recordings;

    public Phonebook() {
        recordings = new HashMap<>();
    }

    void add(Recording value) {
        String key = value.getName();
        if (recordings.containsKey(key)) {
            recordings.get(key).add(value);
        } else {
            List<Recording> list = new ArrayList<>();
            list.add(value);
            recordings.put(key, list);
        }
    }

    public Recording find(String searchedEntryName) {
        return recordings.get(searchedEntryName).get(0);
    }

    public List<Recording> findAll(String searchedEntryName) {
        return recordings.get(searchedEntryName);
    }
}
