package amazon_prep.string;

public class ReverseWordsString {

    /**
     * Turns a string into reverse order
     * @param s i.like.this.program.very.much
     * @return much.very.program.this.like.i
     */
    public static String reverseWords(String s) {
        String[] words = s.split("\\.");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(".");
        }
        return reversed.subSequence(0, s.length()).toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseWordsString.reverseWords("i.like.this.program.very.much"));
    }
}
