package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] s = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] ss = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            ss[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (ss[i] == s[j]) {
                    ans[i]++;
                }
            }
        }

        for (int i : ans) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
