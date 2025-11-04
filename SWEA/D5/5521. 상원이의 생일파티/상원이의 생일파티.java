import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
    static int[][] arr;
    static boolean[] visit;
    static int n, m, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n + 1][n + 1];
            visit = new boolean[n + 1];
            cnt = 0;

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[a][b] = arr[b][a] = 1;
            }
            bfs(1);
            System.out.println("#" + t + " " + cnt);
        }
    }

    static void bfs(int s) {
        visit[s] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{s, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int e = now[0];
            int depth = now[1];
            
            if (depth == 2) {
                continue;
            }

            for (int i = 1; i <= n; i++) {
                if (arr[e][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    cnt++;
                    q.add(new int[]{i, depth + 1});
                }
            }
        }
    }
}
