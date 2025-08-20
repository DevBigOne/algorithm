import java.util.Scanner;

/*
물뿌리개 2개 필요 하나는 +1, 하나는 +2 그래서 + 3씩 오름
동시에 사용해야함.
추가 조건 사과 나무 높이가 다 동일해야함. 그래서 판별이 가능한 부분도 구현 필요
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();

        int[] arr = new int[n];
        int twohalf = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int top =  sc.nextInt();
            sum += top;
            twohalf += top / 2;
        }
        if (sum % 3 != 0) {
            System.out.println("NO");
            return;
        }

        int day = sum / 3;
        if (day <= twohalf) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
