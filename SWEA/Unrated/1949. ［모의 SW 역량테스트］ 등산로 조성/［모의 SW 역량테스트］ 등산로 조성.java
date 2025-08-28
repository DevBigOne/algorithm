import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
* */
public class Solution {
    static boolean[][] visited;
    static int n;
    static int K;
    static int[][] arr;
    static int maxl;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int max = Integer.MIN_VALUE;
            maxl = 0;
            arr  = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int  j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, arr[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int  j = 0; j < n; j++) {
                    if (arr[i][j] == max) {
                        dfs(i,j, 1, false);
                    }
                }
            }
            System.out.println("#"+t+" "+maxl);
        }
    }

    private static void dfs(int x, int y, int cnt, boolean use) {
        maxl = Math.max(maxl, cnt);
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
            
            if (visited[nx][ny]) continue;

            if (arr[x][y] > arr[nx][ny]) {
                dfs(nx, ny, cnt + 1, use);
            }
            else if (arr[x][y] <= arr[nx][ny] && !use) {
                for (int k = 1; k <= K; k++) {
                    if (arr[nx][ny] - k  < arr[x][y]) {
                        arr[nx][ny] = arr[nx][ny] - k;
                        dfs(nx, ny, cnt + 1, true);
                        arr[nx][ny] = arr[nx][ny] + k;
                    }
                }
            }
        }
        visited[x][y] = false;
    }
}