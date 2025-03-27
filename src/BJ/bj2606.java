package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2606 {
    static int[][] arr;
    static boolean[] visit;
    static int cnt = 0, n, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());

        arr = new int[n+1][n+1];
        visit = new boolean[n+1];

        for (int i = 0; i < t; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            arr[j][k] = arr[k][j] = 1;

            }

        dfs(1);
        System.out.println(cnt-1);
    }

    static void dfs(int depth) {
        visit[depth] = true;
        cnt++;

        for (int i = 1; i <= n; i++) {
            if (arr[depth][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
