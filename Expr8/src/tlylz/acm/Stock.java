package tlylz.acm;

public class Stock {
    public static Stock instance;
    public int common = 100;

    public int request(int id) {
        synchronized (this) {
            if (common <= 0) { this.notify(); return -1; }
            return common--;
        }
    }
}
