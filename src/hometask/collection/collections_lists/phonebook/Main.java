package hometask.collection.collections_lists.phonebook;

public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add(new Recording("Arsen", "80991111111"));
        phonebook.add(new Recording("Arsen", "80501111111"));
        phonebook.add(new Recording("Olga", "80931111111"));

        phonebook.find("Olga");
        phonebook.findAll("Arsen");
    }
}
