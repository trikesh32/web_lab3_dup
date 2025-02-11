package trikesh.lab3_dup.utils;

public class AreaChecker {
    public static Boolean checkArea(Double x, Double y, Double r) {
        return checkCircle(x, y, r) || checkTriangle(x, y, r) || checkPolygon(x, y, r);
    }
    private static Boolean checkPolygon(Double x, Double y, Double r) {
        return (x<=0 && y>= 0) && (x>=-r && y<=r/2);
    }
    private static Boolean checkCircle(Double x, Double y, Double r) {
        return (x>=0 && y>= 0) && (x*x + y*y <= (r/2) * (r/2));
    }
    private static Boolean checkTriangle(Double x, Double y, Double r) {
        return (x<=0 && y <= 0) && (x>= -r/2 && y>= -x - r/2);
    }
}
