import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());


        int[][] dp = new int[n + 1][4];
        int[][] dp2 = new int[n + 1][4];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp2[1][1] = dp[1][1];
        dp2[1][2] = dp[1][2];
        dp2[1][3] = dp[1][3];


        for (int i = 2; i <= n; i++) {
            dp2[i][1] = dp[i][1] + Math.min(dp2[i - 1][2], dp2[i - 1][3]);
            dp2[i][2] = dp[i][2] + Math.min(dp2[i - 1][1], dp2[i - 1][3]);
            dp2[i][3] = dp[i][3] + Math.min(dp2[i - 1][1], dp2[i - 1][2]);
        }

        int min = Math.min(Math.min(dp2[n][1], dp2[n][2]), dp2[n][3]);
        System.out.println(min);
    }
}
