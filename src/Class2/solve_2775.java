package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 층 수
            int n = Integer.parseInt(br.readLine()); // 호 수

            int[][] apt = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= n; j++) {
                    apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
                }
            }
            sb.append(apt[k][n]).append("\n");
        }
        System.out.print(sb);
    }
}
