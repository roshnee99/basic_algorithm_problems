package leetcode.misc;

public class RectangleIntersection {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int bottomLeftXCoor = Math.max(rec1[0], rec2[0]);
        int bottomLeftYCoor = Math.max(rec1[1], rec2[1]);
        int topRightXCoor = Math.min(rec1[2], rec2[2]);
        int topRightYCoor = Math.min(rec1[3], rec2[3]);
        return bottomLeftXCoor < topRightXCoor && bottomLeftYCoor < topRightYCoor;
    }

    public static void main(String[] args) {
        RectangleIntersection caller = new RectangleIntersection();
        // bottom left: (0, 0), top right: (1, 1)
        int[] rect1 = new int[]{0, 0, 1, 1};
        int[] rect2 = new int[]{2, 2, 3, 3};
        System.out.println(caller.isRectangleOverlap(rect1, rect2));
    }

}
