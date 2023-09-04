import java.util.Scanner;

public class ACMInputTemplate {

    // // 输入
    // 2
    // 1 5
    // 10 20
    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // int n = 0;
    // if (in.hasNextInt()) {
    // n = in.nextInt();
    // }
    // while (n-- > 0) {
    // while (in.hasNextInt()) {
    // int a = in.nextInt();
    // int b = in.nextInt();
    // System.out.println(a + b);
    // }
    // }
    // }

    // 输入
    // 1 5
    // 10 20
    // 0 0

    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // while (in.hasNextInt()) {
    // int a = in.nextInt();
    // int b = in.nextInt();
    // if (a == 0 && b == 0)
    // break;
    // System.out.println(a + b);
    // }
    // }

    // 输入
    // 2
    // 4 1 2 3 4
    // 5 1 2 3 4 5
    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // int n = in.nextInt();
    // in.nextLine(); // 换行，读入2后面的回车
    // while (n-- > 0) {
    // String[] list = in.nextLine().split(" ");
    // int sum = 0;
    // for (int i = 1; i < list.length; i++) {
    // sum += Integer.valueOf(list[i]);
    // }
    // System.out.println(sum);
    // }
    // }
}