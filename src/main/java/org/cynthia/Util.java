package org.cynthia;

public class Util {
    /**
     * Converts each word in a string to title case.
     * @param str the input string
     * @return the title-cased version of the string
     */
    public static String toTitleCase(String str) {
        if (str == null) {
            return null;
        }

        str = str.trim();

        if (str.isEmpty()) {
            return str;
        }

        String[] words = str.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (!word.isEmpty()) {
                String titleWord = Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
                result += titleWord;

                if (i < words.length - 1) {
                    result += " ";
                }
            }
        }
        return result;
    }
}
