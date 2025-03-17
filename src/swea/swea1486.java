package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1486 {

    static int[] sum;
    static int n, b, tot;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sum = new int[n];
            visit = new boolean[n];
            tot = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sum[j] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
            sb.append("#").append(i).append(" ").append(tot).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == n){
            int ss = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) {
                   ss += sum[i];
                }
            }
            if (ss >= b) {
                int min = ss - b;
                tot = Math.min(min, tot);
            }
            return;
        }
        dfs(depth + 1); // 현재 숫자를 선택하지 않고 넘어가기

        visit[depth] = true; // 요기는 현재 숫자를 선택하고
        dfs(depth + 1); // 사용했으니 depth 올려주고
        visit[depth] = false; // 다시 깊이 탐색을 해야하니 사용한다
    }
}
