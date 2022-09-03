package done;

public class constructRectangle {
    public int[] f1(int area) {
        int[] res = new int[2];
        int y = (int) Math.sqrt(area); // 长的初选值
        while (y <= area / 2) {
            if (area % y == 0) {
                res[0] = y > (area / y) ? y : area / y;
                res[1] = y > (area / y) ? area / y : y;
                break;
            }
            y++;
        }
        if (res[0] == 0) {
            res[0] = area;
            res[1] = 1;
        }
        return res;
    }

    public int[] f2(int area) {
        int y = (int) Math.sqrt(area); // 宽的初选值
        while (area % y != 0) {
            y--;
        }
        return new int[] { area / y, y };

    }

    public static void main(String[] args) {
        constructRectangle c = new constructRectangle();
        int[] res = c.f2(30);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
