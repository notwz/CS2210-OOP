package prereqs;

public class Baal {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        palidrome("");

    }

    public static void palidrome(String input) {

        int l= input.length() - 1;

        int i= 0;

        boolean palidrome= true;

        while (i < l) {

            if (input.charAt(i) != input.charAt(l)) {
                System.out.println("Not a palidrome");
                palidrome= false;
            }
            i++ ;
            l-- ;
        }

        System.out.println(palidrome);

    }

}
