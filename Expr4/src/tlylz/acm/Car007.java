package tlylz.acm;

public class Car007 implements ITimeCalculateStrategy {
    @Override
    public int calcTime(int A, int B, int C) {
        return A * B / C;
    }
}
