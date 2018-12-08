package tlylz.acm;

public class Main {

    static boolean check(int n) {
        int s = n, p = 0;
        int t = n % 10; p += t * t * t;
        n /= 10;
        t = n % 10; p += t * t * t;
        n /= 10;
        t = n % 10; p += t * t * t;
        return s == p;
    }

    public static void main(String[] args) {
	    for (int i = 100; i < 1000; i++) {
	        if (check(i)) System.out.println(i);
        }
    }
}
