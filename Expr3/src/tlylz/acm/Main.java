package tlylz.acm;

class MyVar {
    public MyVar(String name) {
        System.out.println(name + " constructed");
    }
}

class MyClass {
    static MyVar var3 = new MyVar("var3");
    static MyVar var1 = new MyVar("var1");
    static MyVar var2 = new MyVar("var2");

    MyVar var4 = new MyVar("var4");
    MyVar var5 = new MyVar("var5");

    public MyClass() {
        MyVar var6 = new MyVar("var6");
    }

    MyVar var7 = new MyVar("var7");
    static MyVar var8 = new MyVar("var8");
}

public class Main {
    public static void main(String[] args) {
        MyVar var9 = new MyVar("var9");
        MyClass t = new MyClass();
    }
}
