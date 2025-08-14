import java.io.*;
import java.util.*;

public class Solution {
    static int D, W, K;
    static int[][] film;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    film[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            ans = Integer.MAX_VALUE;
            dfs(0, 0); // 0번 행부터, 약품 사용 0번으로 시작

            System.out.println("#" + tc + " " + ans);
        }
    }

    // x: 현재 행, cnt: 약품 사용 횟수
    private static void dfs(int x, int cnt) {
        if (cnt >= ans) return; // 이미 최소값 초과하면 가지치기
        if (x == D) { // 모든 행 결정
            if (check()) { // 검사 통과하면 최소값 갱신
                ans = Math.min(ans, cnt);
            }
            return;
        }

        int[] backup = film[x].clone(); // 원본 백업

        // 1) 약품 안 넣음
        dfs(x + 1, cnt);

        // 2) 약품 A 투입 (모두 0)
        Arrays.fill(film[x], 0);
        dfs(x + 1, cnt + 1);

        // 3) 약품 B 투입 (모두 1)
        Arrays.fill(film[x], 1);
        dfs(x + 1, cnt + 1);

        film[x] = backup; // 원래 상태로 복구
    }

    // 성능 검사
    private static boolean check() {
        for (int col = 0; col < W; col++) {
            int maxCnt = 1;
            int curCnt = 1;
            for (int row = 1; row < D; row++) {
                if (film[row][col] == film[row - 1][col]) {
                    curCnt++;
                } else {
                    curCnt = 1;
                }
                maxCnt = Math.max(maxCnt, curCnt);
            }
            if (maxCnt < K) return false; // 하나라도 기준 미달이면 실패
        }
        return true;
    }
}
