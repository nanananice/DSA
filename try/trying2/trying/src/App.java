public class App {
    public static class A {
        static int val_a1 = 1;

        static void method_a1(int x) {
            System.out.print("From method_a1() " + val_a1);
            System.out.println(" local argument value is " + x);
        }
    }

    public static class B {
        int val_b1;

        B(int v) {
            val_b1 = v;
        }

        void method_b1() {
            System.out.print("From method_b1() " + val_b1);
            System.out.println(" There is not an argument received.");
        }
    }

    public static class C {
        int val_c1;
        static int val_c2 = 3;

        C(int v) {
            val_c1 = v;
        }

        void method_c1(int x) {
            System.out.print("From method_b1() " + val_c1);
            System.out.println(" local argument value is " + x);
            System.out.println("** non static method may access static attribute " + val_c2);
        }

        static void method_c2() {
        System.out.println("static method cannot access non-static attribute " + val_c1);
        System.out.println("non static method **may**access static attribute "+ val_c2);
        }
    }

    public static class D {
        int val_d1;
        static int val_d2 = 4;

        D(int v) {
            val_d1 = v;
        }

        static void method_d1() {
            System.out.println("this is my only assigned task");
        }

        static void method_d2() {
            method_d1();
           System.out.println("leaving method_d2()");
        }

        void method_d3() {
            method_d1();
            System.out.println("leaving method_d3()");
        }

        static void method_d4() {
            method_d3();
            System.out.println("leaving method_d4()");
        }
    }

    static void demo1() {
        System.out.println("-demo1---");
        A.method_a1(890);
    }

    static void demo2() {
        System.out.println("-demo2---");
        B b1 = new B(22);
        B b2 = new B(33);
        b1.method_b1();
        b2.method_b1();
    }

    static void demo3() {
        System.out.println("-demo3---");
        C c1 = new C(444);
        C c2 = new C(555);
        c1.method_c1(908);
        c1.method_c1(908);
        C.method_c2();
        }
        static void demo4() {
        System.out.println("-demo4---");
        D d1 = new D(6666);
        D d2 = new D(7777);
        D.method_d1();
        D.method_d2();
        d1.method_d3();
        d2.method_d3();
        D.method_d4();
        }
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
    }
}
