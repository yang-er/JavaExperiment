package tlylz.acm;

public class Plane implements ITimeCalculateStrategy {
    @Override
    public int calcTime(int A, int B, int C) {
        return A + B + C;
    }
}
