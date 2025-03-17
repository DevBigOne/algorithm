package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1 {

    static int winCount,loseCount;
    static int[] a, b;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            a = new int[9];
            b = new int[9];
            visit = new boolean[9];
            winCount = 0;
            loseCount = 0;

            boolean[] check = new boolean[19];

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 규영이
            for (int i = 0; i < 9; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                check[a[i]] = true;
            }
            int index = 0;
            for (int i = 1; i <= 18; i++) {
                if (!check[i]) {
                    b[index] = i;
                    index++;
                }
            }

            dfs(0, 0, 0);

            sb.append("#").append(T).append(" ").append(winCount).append(" ").append(loseCount).append("\n");
        }
        System.out.println(sb);
    }

    // 깊이 우선 탐색
    static void dfs(int depth, int winPoint, int losePoint) {
        // 9판 했는지 확인
        if (depth == 9) {
            // 만약 규영이 점수가 높으면 winCount++
            if (winPoint > losePoint) {
                winCount++;
            }
            // 인영이가 이기면 loseCount++
            else {
                loseCount++;
            }
            // return이 필요한 이유?
            // return을 걸지 않으면 아래 for문이 다시 실행됨
            // 현재는 visit로 확인을 해서 상관은 없지만 이런 형태가 아닐 경우 문제가 생김
            return;
        }

        // 규영이 카드는 고정되어있고 인영이 카드는 순서가 바뀔 수 있어서
        for (int i = 0; i < 9; i++) {
            // 인영이가 안 낸 카드 중에 선택
            if (!visit[i]) {
                visit[i] = true;
                if (a[depth] > b[i]) {
                    dfs(depth + 1, winPoint + a[depth] + b[i], losePoint);
                } else {
                    dfs(depth + 1, winPoint, losePoint + a[depth] + b[i]);
                }
                visit[i] = false;
            }
        }
    }
}