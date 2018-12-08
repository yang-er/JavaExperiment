package tlylz.acm;

public class Window implements Runnable {
    static int pid = 0;
    int id;

    public Window() {
        id = ++pid;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((int) (Math.random() * 2000));
                int ans = Stock.instance.request(id);
                if (ans != -1) System.out.println("Window " + id + " got " + ans);
                else break;
            }
        } catch (InterruptedException ex) { }
    }
}
