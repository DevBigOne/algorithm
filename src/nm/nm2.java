package nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nm2 {
    static int n,m;
    static int[] seq;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        seq = new int[m];
        used = new boolean[n + 1];

        backtrack(0, 1);
    }
    static void backtrack(int depth, int next) {
        if (depth == m) {
            for (int num : seq) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int num = next; num <= n; num++) {
            if (!used[num]) {
                used[num] = true;
                seq[depth] = num;
                backtrack(depth + 1, num + 1);
                used[num] = false;
            }
        }
    }
}
