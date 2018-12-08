package tlylz.acm;

public class Main {
    public static Object some = new Object();

    public static void main(String[] args) throws InterruptedException {
        Stock.instance = new Stock();
        for (int i = 0; i < 5; i++)
            new Thread(new Window()).start();

        synchronized (Stock.instance) {
            if (Stock.instance.common > 0)
                Stock.instance.wait();
        }

        System.out.println("All tickets sold out!");
    }
}
