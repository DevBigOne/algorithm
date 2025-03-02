package nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nm3 {
    static int n, m;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new int[m];

        backtrack(0);
        System.out.println(sb.toString());
    }
    static void backtrack(int depth) {
        if (depth == m) {
            for(int num: seq) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int num = 1; num <= n; num++) {
            seq[depth] = num;
            backtrack(depth + 1);
        }
    }
}
