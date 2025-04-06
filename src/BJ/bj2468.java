package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2468 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int[][] arr;
    static int n, result;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int max = 0;
        for (int i = 0; i < n; i++) { // 값 넣고 최대 높이 확인하고
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for (int i = 0; i <= max; i++) {
            int cnt = 0; // 영역 개수
            visit = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(!visit[k][j] && arr[k][j] > i) {
                        bfs(k, j, i);
                        cnt++;
                    }
                }
                result = Math.max(cnt, result);
            }
        }
        System.out.println(result);
    }

    
    static void bfs(int i, int j, int h) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visit[i][j] = true;

        while (!q.isEmpty()) {
            int[] s = q.poll();
            int px = s[0];
            int py = s[1];

            for (int k = 0; k < 4; k++) {
                int x = px + dx[k];
                int y = py + dy[k];

                if (x < n && y < n && x >= 0 && y >= 0) {
                    if (arr[x][y] > h && !visit[x][y]) {
                        visit[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
