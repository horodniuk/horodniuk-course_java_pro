package hometask.collection.collections_lists.phonebook;

import java.util.ArrayList;
import java.util.List;


public class Phonebook {
    private ArrayList<Recording> recordings;

    public Phonebook() {
        recordings = new ArrayList<>();
    }

    void add(Recording recording) {
        recordings.add(recording);
    }

    public Recording find(String searchedEntryName) {
        for (Recording currentRecording : recordings) {
            if (currentRecording.getName().equals(searchedEntryName)) {
                return currentRecording;
            }
        }
        return null;
    }

    public List<Recording> findAll(String searchedEntryName) {
        List<Recording> listRecordings = new ArrayList<>();
        for (Recording currentRecording : recordings) {
            if (currentRecording.getName().equals(searchedEntryName)) {
                listRecordings.add(currentRecording);
            }
        }
        if (listRecordings.isEmpty()) return null;
        return listRecordings;
    }
}
