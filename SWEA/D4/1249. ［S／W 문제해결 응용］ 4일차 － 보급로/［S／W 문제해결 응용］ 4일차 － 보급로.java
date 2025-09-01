import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution {
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] dist;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine(); // 한 줄 문자열 그대로 받음
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }

            bfs();

            System.out.println("#" + t + " " + dist[n - 1][n - 1]);
        }
    }

    private static int bfs() {
        dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new ArrayDeque<>();
        dist[0][0] = 0;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;

                int nextCost = dist[x][y] + arr[nx][ny];
                if (dist[nx][ny] == -1 || nextCost < dist[nx][ny]) {
                    dist[nx][ny] = nextCost;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return dist[n - 1][n - 1];
    }
}
