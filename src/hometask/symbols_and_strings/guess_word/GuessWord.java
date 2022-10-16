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
        // System.out.println("Guess word ---> " + hiddenWord);
        StringBuilder hintWord = new StringBuilder("###############");

        while (true) {
            System.out.println("Please, enter word:");
            String answerUser = new Scanner(System.in).nextLine();
            if (answerUser.equals(hiddenWord) || answerUser.startsWith(hiddenWord)) {
                System.out.println("Congratulations, you guessed word - " + hiddenWord);
                break;
            } else {
                printHint(answerUser, hiddenWord, hintWord);
            }
        }
    }

    private void printHint(String answerUser, String guessWord, StringBuilder hintWord) {
        int countSymbolsSmallerWord = Math.min(guessWord.length(), answerUser.length());
        for (int i = 0; i < countSymbolsSmallerWord; i++) {
            if (answerUser.charAt(i) == guessWord.charAt(i)) {
                hintWord.setCharAt(i, answerUser.charAt(i));
            }
        }
        System.out.println("Hint shown - " + hintWord + ". Try again:");
    }
}
