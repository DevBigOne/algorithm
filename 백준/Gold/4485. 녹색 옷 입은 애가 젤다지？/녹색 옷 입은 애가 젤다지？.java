import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] dx = { -1 , 1, 0, 0 };
    static int[] dy = {  0 , 0,-1, 1 };
    static int n;

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1;

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            n = Integer.parseInt(line.trim());
            if (n == 0) break; 

            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem ").append(tc++).append(": ").append(bfs()).append('\n');
        }
        System.out.print(sb.toString());
    }
    
    private static int bfs() {
        int[][] dist = new int[n][n];
        boolean[][] inQ = new boolean[n][n];
        for (int i = 0; i < n; i++) 
            Arrays.fill(dist[i], INF);

        Queue<int[]> q = new ArrayDeque<>();
        dist[0][0] = arr[0][0];
        q.add(new int[]{0, 0});
        inQ[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            inQ[x][y] = false;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) 
                    continue;

                int next = dist[x][y] + arr[nx][ny];
                if (next < dist[nx][ny]) {
                    dist[nx][ny] = next;
                    if (!inQ[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        inQ[nx][ny] = true;
                    }
                }
            }
        }
        return dist[n-1][n-1];
    }
}
