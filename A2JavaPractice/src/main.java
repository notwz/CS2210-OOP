public class main {

    private int count;

    static class Father {

        private int a= 1;

        void print() {
            System.out.println("Father");

        }

        void print(String x) {
            System.out.println(x);
        }

    }

    static class Child extends Father {

        @Override
        void print() {
            super.print();
            System.out.println("Child");

        }

    }

    static class Counter {
        int v;

        void set(long i) {
            System.out.println("was long");
        }

        void set(int i) {
            System.out.println("was long");
        }

        void set(float i) {
            System.out.println("was float");
        }

        void set(double i) {
            System.out.println("was dobule");
        }
    }

    public void bar() {
        count= count + 1;
        int count= 2;
        count= count + 2;

    }

    public static void r(int n) {
        try {
            int x= 5 / (n / 10);
            System.out.println("print nothing");
        } catch (ArithmeticException e) {
            System.out.println("NOO");
            char c= "bbb".charAt(n);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        r(3);

    }

}
