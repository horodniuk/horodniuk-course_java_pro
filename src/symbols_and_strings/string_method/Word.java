package symbols_and_strings.string_method;

public class Word {
    public int findSymbolOccurance(String source, char symbol) {
        int result = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == symbol) {
                result++;
            }
        }
        return result;
    }

    public int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public String stringReverse(String source) {
        StringBuilder result = new StringBuilder();
        for (var i = source.length() - 1; i >= 0; i--) {
            result.append(source.charAt(i));
        }
        return result.toString();
    }

    public boolean isPalindrome(String source) {
        return source.equals(new StringBuilder(source).reverse().toString());
    }
}
