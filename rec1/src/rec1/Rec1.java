package rec1;

public class Rec1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Vowel Checker: \n \n");
        System.out.println(containsVowel("Hello World"));
        System.out.println("\n");

        System.out.println("Date to String: \n \n");

        System.out.println(dateToString(1, 2, 2000));
        System.out.println("\n");

        System.out.println("E Checker: \n \n");

        System.out.println(stringE("Eello"));

        System.out.println("\n");
    }

    public static boolean containsVowel(String s) {

        return s.contains("a") || s.contains("e") || s.contains("i") || s.contains("o") ||
            s.contains("u");
    }

    public static String dateToString(int d, int m, int y) {

        String month[]= { "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December" };

        return d + " " + month[m - 1] + " " + y;
    }

    public static boolean stringE(String s) {

        int count= 0;

        for (int i= 0; i < s.length(); i++ ) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                count++ ;
            }
        }

        return count >= 2;

    }
}
