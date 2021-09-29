package a3;

import java.util.Arrays;

/* NetIds: wz282, nnnn.
 * What I thought about this assignment:
 * Not being able to use loops really forced me to think know methods and learn how to use them.
 * Most of the methods and functions weren't too complex to implement though.
 *
 *
 *  */

/** A collection of static functions manipulating strings. <br>
 * All methods assume that String parameters are non-null.
 *
 * If a method is called with arguments that do not satisfy the Preconditions,<br>
 * the behavior is undefined (the method can do anything).<br>
 * You do not have to use assert statements to test preconditions. <br>
 * We will not test with test cases that do not satisfy Preconditions. */
public class A3 {
    /* Each function you write has a "//TODO comment". Look on the right;
     * click a blue rectangle to get to the corresponding "//TODO comment".
     * DO NOT DELETE THESE COMMENTS.
     * Put your code AFTER the comments.
     *
     * Wherever possible, prefer library functions to writing your own loops.
     *
     * See the JavaHyperText entries for if-statement, while-loop, and for-loop.
     * Use of the break-statement and continue-statement is discouraged but not
     * forbidden. They make loops and programs harder to understand. Usually,
     * they can be eliminated by restructuring/reorganizing code --perhaps
     * writing extra methods.
     *
     * For some functions, you may be writing a loop to append character after
     * character to an initially empty string. See the JavaHyperText entry for
     * class StringBuilder and a discussion of why it is better to use
     * StringBuilder for this purpose.
     *
     * We give complete test cases.
     *  */

    /** Replace "-1" by the time you spent on A2 in hours.<br>
     * Example: for 3 hours 15 minutes, use 3.25<br>
     * Example: for 4 hours 30 minutes, use 4.50<br>
     * Example: for 5 hours, use 5 or 5.0 */
    public static double timeSpent= 1.5;

    /** Return true iff (i.e. if and only if) the middle characters of s are different. <br>
     * Note: If s has an odd number of chars, there is ONE middle char, so return false.<br>
     * If s has an even number (> 0) of chars, there are two middle chars, so return <br>
     * true iff they are different.<br>
     * Here are examples: <br>
     * For s = "" return false <br>
     * For s = "$" return false <br>
     * For s = "23" return true <br>
     * For s = "44" return false <br>
     * For s = "22AB" return true <br>
     * For s = "2AAB" return false <br>
     * For s = "abcdefaabcdefg" return false <br>
     * For s = "abcdef$abcdefg" return true <br>
     * For s = "aaaaaaaaaaaaaaaa" return false <br>
     * For s = "aaaaaaa$aaaaaaaa" return true<br>
     * For s = "aaaaaaa$aaaaaaaaa" return false */
    public static boolean areMidsDiff(String s) {
        // TODO 1. Do not use a loop.
        // This can be done cleanly in 3-4 statements (but you can use more).
        // Hint: Follow these Principles:
        // Principle: Avoid unnecessary case analysis
        // Principle: Avoid the same expression in several places.
        // Principle: Keep the structure of the method as simple as possible.

        int len= s.length();

        if (len == 0 || len == 1 || len % 2 != 0) { return false; }
        if (s.charAt(len / 2 - 1) == s.charAt(len / 2)) { return false; }

        return true;
    }

    /** Protect the letters in 'a'..'z' by preceding each with the <br>
     * corresponding capital. <br>
     * That is: Return a copy of s changed as indicated above. <br>
     * Examples: <br>
     * For s = "", return "". <br>
     * For s = "b", return "Bb". <br>
     * For s = "B", return "B". <br>
     * For s = "å", return "å" <br>
     * For s = "$", return "$" <br>
     * For s = "1ABCDEFx", return "1ABCDEFXx".<br>
     * For s = "1zZ$Bby", return "1ZzZ$BBbYy"<br>
     * For s = "abcdefghijk", <br>
     * ......... return "AaBbCcDdEeFfGgHhIiJjKk" <br>
     * For s = "lmnopqrst", <br>
     * ......... return "LlMmNnOoPpQqRrSsTt"<br>
     * For s = "uvwxyz", <br>
     * ......... return "UuVvWwXxYyZz" */
    public static String protectLittles(String s) {
        /* TODO 2.
         * 1. The spec does NOT say to handle all lower-case letters
         * differently from the rest, but only letters in 'a'..'z'.
         * There are other lower-case letters!
         *
         * 2. In the fourth example, s = "å", 'å' is lower-case letter but
         * it is NOT a character in a..z, so it is NOT preceded by a capital.
         *
         * If this isn't working for you, you may be using Eclipse on a
         * Windows 10 computer, and the wrong Text File coding is being used.
         * Check that you are using the right one by using menu
         * item Preferences -> General -> Workspace and selecting UTF-8.
         *
         *You can read about text-file encodings in JavaHyperText here:
         *   https://www.cs.cornell.edu/courses/JavaAndDS/eclipse/Ecl01eclipse.html
         *
         * You will lose all points on this question if your code handles
         * all lower-case letters and not just those in a..z.
         *
         * 3. Do NOT use "magic numbers" ---look that term up in JavaHyperText.
         * For example, the internal representation of 'a' is 97, but do NOT
         * use magic number 97 in the method body; instead, use 'a'.
         */

        String result= s;
        for (char ch : result.toCharArray()) {
            if (ch >= 'a' && ch <= 'z' && Character.isLowerCase(ch)) {
                int index= result.indexOf(ch);

                result= result.substring(0, index) +
                    Character.toUpperCase(ch) +
                    result.substring(index, result.length());

            }
        }

        return result;
    }

    /** Return s but with all letters in 'A'..'Z' moved to the back, <br>
     * and in the same order.<br>
     * Examples: <br>
     * putCapsLast("") = "" <br>
     * putCapsLast("$") = "$" <br>
     * putCapsLast("Ac") = "cA" <br>
     * putCapsLast("Åc") = "Åc" <br>
     * Note: 'Å' is not in 'A'..'Z'. <br>
     * putCapsLast("aAbBcCdDxXy$zZ") = "abcdxy$zABCDXZ" <br>
     * putCapsLast("mnopqrst") = "mnopqrst" <br>
     * putCapsLast("1z$aàēĤƀ") = "1z$aàēĤƀ"<br>
     * putCapsLast("ABCDE.FGHIJKLMNO$PQ%RSTUV!WXYZ") = ".$%!ABCDEFGHIJKLMNOPQRSTUVWXYZ" */
    public static String putCapsLast(String s) {
        // TODO 3. The same things about the UTF-8 encoding and magic numbers
        // discussed in the previous method apply here also.
        //
        // In this method, you must use StringBuilder twice, once to contain
        // the front of the string as it is being built and once to contain
        // the capitals, to be placed at the back when done.
        StringBuilder capitals= new StringBuilder();
        StringBuilder front= new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z' && Character.isUpperCase(ch)) {
                capitals.append(ch);

            } else {
                front.append(ch);

            }

        }

        return front.toString() + capitals.toString();
    }

    /** Precondition: s and s1 are not null. <br>
     * Return true iff s contains more than one occurrence of s1. <br>
     * Examples: moreThan1("", "") is false <br>
     * moreThan1("a", "") is true: <br>
     * .... The empty string occurs before and after each character! <br>
     *
     * moreThan1("abc", "") is true <br>
     * moreThan1("", "a") is false. <br>
     * moreThan1("abcb", "c") is false. <br>
     * moreThan1("acbc", "c") is true. <br>
     * exactly1("abbc", "ab") is false. <br>
     * exactly1("aaa", "aa") is true. <br>
     * exactly1("abbbabc", "ab") is true. */
    public static boolean moreThan1(String s, String s1) {
        // TODO 4 Do not use a loop or recursion. Instead, look through the
        // methods of class String and see how you can tell that the first
        // and last occurrences of s1 in s are the same occurrence. Be sure
        // you handle correctly the case that s1 does not occur in s.
        //
        // Hint: Follow this Principle:
        // Principle: Be aware of efficiency considerations.
        // Don't repeat expensive work that has already been done.
        // Note that a call like s.indexOf(s1) may take time proportional to the
        // length of string s. If s contains 1,000 characters and s1 contains 5 chars,
        // then about 9996 tests may have to be made in the worst case. So don't
        // have the same method call executed several times.

        // System.out.println(s.contains(s1));
        boolean result= false;

        if (s == "") { return result; }

        if (s.contains(s1)) {
            String restOfS= s.substring(s.indexOf(s1) + 1, s.length());
            result= restOfS.contains(s1);

        }

        return result;
    }

    /** s consists of a nonblank character followed by a digit k (say) in 0..9. <br>
     * There may be blanks before the character and after the digit.<br>
     * Return a String that contains k copies of the character. */
    /* Examples: <br>
    * expand("        b0 ") is "" <br>
    * expand(" c1        ") is "c" <br>
    * expand("$8         ") is "$$$$$$$$" <br>
    * expand("35")          is "33333". */
    public static String expand(String s) {
        // TODO 5. Do NOT use a loop or recursion. Do not use magic numbers.
        // Rely only on methods of class String.
        // Don't use unnecessary case analysis --a solution needs no if-statements
        // or conditional expressions.

        String noTrailing= s.stripTrailing();
        String noWhites= noTrailing.stripLeading();
        String nonBlank= noWhites.substring(0, 1);
        int k= Character.getNumericValue(noWhites.charAt(1));
//        int k= Integer.parseInt(noWhites.substring(1, noWhites.length()));
        return nonBlank.repeat(k);

    }

    /** Return true iff s and t are anagrams.<br>
     * Note: 2 strings are anagrams of each other if swapping the characters<br>
     * around in one changes it into the other.<br>
     * Note: 'a' and 'A' are different chars, and the space ' ' is a character.
     *
     * Examples: For s = "noon", t = "noon", return true. <br>
     * For s = "mary", t = "army", return true. <br>
     * For s = "tom marvolo riddle", t = "i am lordvoldemort", return true. <br>
     * For s = "tommarvoloriddle", t = "i am lordvoldemort", return false. <br>
     * For s = "hello", t = "world", return false. */

    public static boolean areAnagrams(String s, String t) {
        // TODO 6
        /* Do not use a loop or recursion! This can be done in
         * 5 lines using methods of classes String and Arrays --look them up.
         * Hint: how can a sequence of characters be uniquely ordered? You might
         * need to first convert the string into an array of characters and then
         * use methods in class Arrays. */

        char[] sArray= s.toCharArray();
        char[] tArray= t.toCharArray();

        int[] arr= { 1, 2 };
        int intArr[];
        intArr= new int[0];

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i= 0; i <= intArr.length; i++ ) {
            System.out.println("printed");
        }

        return Arrays.equals(sArray, tArray);
    }

    // TODO 7
    /* This ToDo is worth 3/100 points of this assignment.
     * In the comment on lines 5..10, fill in your netid(s) and tell us
     * what you thought about this assignment. Then, on line 45, put in
     * how much time you spent on this assignment */

}
