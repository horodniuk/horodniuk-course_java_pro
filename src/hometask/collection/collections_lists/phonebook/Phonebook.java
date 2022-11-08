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


    public static void main(String[] args) {
        Phonebook telefonnayaKniga = new Phonebook();
        telefonnayaKniga.add(new Recording("Oleg", "111"));
        telefonnayaKniga.add(new Recording("Oleg", "111"));
        telefonnayaKniga.add(new Recording("Anton", "122"));
        telefonnayaKniga.add(new Recording("Andrei", "133"));
        telefonnayaKniga.add(new Recording("Anton", "144"));

        List<Recording> testZapisFindAll = telefonnayaKniga.findAll("Anton");
        System.out.println(testZapisFindAll);

    }


}
