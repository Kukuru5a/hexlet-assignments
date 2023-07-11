package exercise;

import java.util.stream.IntStream;

// BEGIN
public class ReversedSequence implements CharSequence {

    private String txt;

    public ReversedSequence(String txt) {
        this.txt = txt;
        char[] chs = new char[txt.toCharArray().length];

        for (int i = txt.length()-1; i >= 0; i--) {
            chs[i] = txt.charAt(i);
        }
    }

    @Override
    public int length() {
        return txt.length();
    }

    @Override
    public char charAt(int index) {
        return txt.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        char[] chs = new char[txt.toCharArray().length];

        for (int i = end; i >= start; i--) {
             chs[i] = txt.charAt(i);
        }
        return chs.toString();
    }


    @Override
    public String toString() {
        return txt.subSequence(0, txt.length()).toString();
    }
}
// END
