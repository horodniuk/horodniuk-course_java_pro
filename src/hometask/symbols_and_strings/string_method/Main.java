package hometask.symbols_and_strings.string_method;

public class Main {
    public static void main(String[] args) {
        Word word = new Word();

        System.out.println(word.findSymbolOccurance("Apollo", 'o'));
        System.out.println(word.findSymbolOccurance("Apollo", 'l'));

        System.out.println(word.findWordPosition("Apollo", "pollo"));
        System.out.println(word.findWordPosition("Apple", "Plant"));

        System.out.println(word.stringReverse("Hello"));
        System.out.println(word.stringReverse("Java word"));

        System.out.println(word.isPalindrome("ERE"));
        System.out.println(word.isPalindrome("Allo"));

    }
}
