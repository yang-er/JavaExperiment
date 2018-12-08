package tlylz.acm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner cin = new Scanner(System.in);
    static int global, sum = 0;

    static int nextInt() {
        int t = 0;

        try {
            t = cin.nextInt();
            if (t < 0) throw new IllegalArgumentException();
        } catch (InputMismatchException ex) {
            cin.next();
        } catch (IllegalArgumentException ex) {
            t = 0;
        }

        global = t;
        return t;
    }

    public static void main(String[] args) {
        while (nextInt() != 999) {
            sum += global;
        }
        System.out.println(sum);
    }
}
