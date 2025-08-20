import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = { 1, 0 , -1, 0};
    static int[] dy = { 0, -1, 0, 1};
    static int[][] tastemap;
    static int N;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

           tastemap = new  int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    tastemap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int x = 0; x <= 100; x++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tastemap[i][j] == x)
                            tastemap[i][j] = 0; // 0 은 회색표시
                    }
                }
                int cnt = 0;
                visited = new boolean[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(!visited[i][j] && tastemap[i][j] != 0){
                            bfs(i, j);
                            cnt++;
                        }
                    }
                }
                max = Math.max(max, cnt);
            }
            System.out.println("#"+t+" "+max);
        }
    }

    private static void bfs(int i, int j){
        visited[i][j] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int k = 0; k < 4; k++) {
                int sx = x + dx[k];
                int sy = y + dy[k];
                if (0 <= sx && sx < N && 0 <= sy && sy < N && !visited[sx][sy] && tastemap[sx][sy] != 0 ) {
                    q.add(new int[]{sx, sy});
                    visited[sx][sy] = true;
                }
            }
        }
    }
}
