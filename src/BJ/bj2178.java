package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2178 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m, answer;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(answer);
    }

    // 너비 우선 탐색
    // 최적의 경로를 찾을 때 사용
    // 메모리는 좋지 않음
    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        boolean[][] visit = new boolean[n][m];

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            int count = q.peek()[2];
            q.poll();

            if (x == n - 1 && y == m - 1) {
                answer = count;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cx < n && cy >= 0 && cy < m) {
                    if (!visit[cx][cy] && arr[cx][cy] == 1) {
                        q.add(new int[] {cx, cy, count + 1});
                        visit[cx][cy] = true;
                    }
                }
            }
        }
        answer = -1;
    }
}
