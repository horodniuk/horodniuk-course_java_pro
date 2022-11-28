package hometask.symbols_and_strings.guess_word;

import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    public void startGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        final String hiddenWord = words[new Random().nextInt(words.length - 1)];
        StringBuilder hintWord = new StringBuilder("###############");

        while (true) {
            System.out.println("Please, enter word:");
            String answerWord = new Scanner(System.in).nextLine();
            if (answerWord.equals(hiddenWord) || answerWord.startsWith(hiddenWord)) {
                System.out.println("Congratulations, you guessed word - " + hiddenWord);
                break;
            } else {
                printHint(answerWord, hiddenWord, hintWord);
            }
        }
    }

    private void printHint(String answerWord, String hiddenWord, StringBuilder hintWord) {
        int countSymbolsSmallerWord = Math.min(hiddenWord.length(), answerWord.length());
        for (int i = 0; i < countSymbolsSmallerWord; i++) {
            if (answerWord.charAt(i) == hiddenWord.charAt(i)) {
                hintWord.setCharAt(i, answerWord.charAt(i));
            }
        }
        System.out.println("Hint shown - " + hintWord + ". Try again:");
    }
}
