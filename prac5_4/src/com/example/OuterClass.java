package com.example;

public class OuterClass { //OuterClass.class

    public int x = 42;

    public void method1() {
        // local classes are inner classes but not members of the outer class
        class LocalClass { //OuterClass$1LocalClass.class

            public void localPrint() {
                System.out.println("In local class");
                System.out.println(x);
                //System.out.println(OuterClass.this.x);
            }
        }
        LocalClass lc = new LocalClass();
        lc.localPrint();
    }

    public void method2() {
        Runnable r = new Runnable() { //OuterClass$1.class

            @Override
            public void run() {
                System.out.println("In an anonymous local class method");
                System.out.println(x);
            }
        };
        r.run();
    }
    public Runnable r = new Runnable() { //OuterClass$2.class

        @Override
        public void run() {
            System.out.println("In an anonymous class method");
            System.out.println(x);
        }
    };
    Object o = new Object() { //OuterClass$3.class

        @Override
        public String toString() {
            return "In an anonymous class method";
        }
    };

    public class InnerClass { //OuterClass$InnerClass.class

        // hides OuterClass x
        public int x = 43;
        //static requires final
        public static final int y = 44;

        public void innerPrint() {
            System.out.println("In a inner class method");
            System.out.println(x);
            System.out.println(OuterClass.this.x);
            System.out.println(y);
        }
    }

    // not an inner class because it is static
    public static class StaticNestedClass { //OuterClass$StaticNestedClass.class

        public void staticNestedPrint() {
            System.out.println("In a static nested class method");
            //compile error
            //System.out.println(x);
        }
    }

    // nesting...
    public class A { //OuterClass$A.class

        public class B { //OuterClass$A$B.class

            public void method() { //OuterClass$A$B$1C.class
                class C {
                }
            }
        }
    }
}
