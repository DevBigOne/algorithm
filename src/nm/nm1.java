package nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class nm1 {
    static int n, m;
    static boolean[] used;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        used = new boolean[n + 1]; // 중복되는거 확인
        seq = new int[m]; // 무슨 숫자를 썻는지 저장할려고

        backtrack(0);
    }
    static void backtrack(int depth) {
        if (depth == m) {
            for (int num : seq) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int num = 1; num <= n; num++) {
            if (!used[num]) {
                used[num] = true; //
                seq[depth] = num;
                backtrack(depth + 1);
                used[num] = false;
            }
        }
    }
}
