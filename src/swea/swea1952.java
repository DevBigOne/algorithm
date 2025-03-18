package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1952 {

    static int day, mon, mon3, year, ans = 0;
    static int[] plan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            mon = Integer.parseInt(st.nextToken());
            mon3 = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            plan = new int[12];
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            ans = year;

            dfs(0, 0);

            System.out.println("#" + T + " " + ans);
        }

    }

    static void dfs(int i, int sum){
        if (i >= 12) {
            ans = Math.min(sum, ans);
            return;
        }

        dfs(i + 1, sum + day * plan[i]);

        dfs(i + 1, sum + mon);

        dfs(i + 3 , sum + mon3);
    }
}
