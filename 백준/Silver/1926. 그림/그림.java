import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*

 */
public class Main {
    static int[] dirrow = {-1, 0 ,1, 0 };
    static int[] dircol = {0, 1,0, -1};
    static int N;
    static int M;

    static int[][] arr;
    static boolean[][] visited;
    static int cnt;
    static int max;

    static int area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    cnt++;
                    area = 1;
                    dfs(i,j);
                    max = Math.max(max,area);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(max);

    }

    public static void dfs(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int nrow = row + dirrow[i];
            int ncol = col + dircol[i];

            if (nrow < 0 || nrow >= N || ncol < 0 || ncol >= M) {
                continue;
            }

            if(!visited[nrow][ncol] && arr[nrow][ncol] == 1) {
                visited[nrow][ncol] = true;
                area++;
                dfs(nrow, ncol);
            }
        }
    }
}
