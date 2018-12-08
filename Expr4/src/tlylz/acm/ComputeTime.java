package tlylz.acm;
import java.util.Scanner;

public class ComputeTime {
    public static void main(String[] args) {
        try {
            ITimeCalculateStrategy st = (ITimeCalculateStrategy)Class.forName("tlylz.acm." + args[0]).newInstance();
            int A = Integer.parseInt(args[1]);
            int B = Integer.parseInt(args[2]);
            int C = Integer.parseInt(args[3]);
            System.out.println(st.calcTime(A, B, C));
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found");
        } catch (InstantiationException ex) {
            System.out.println("InstantiationException");
        } catch (IllegalAccessException ex) {
            System.out.println("IllegalAccessException");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Arguments error");
        }
    }
}
