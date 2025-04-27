import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;
    static boolean[][] visit;
    static int count, mcnt, t;
    static int[] dx = { 0, -1, 0, 1 };
    static int[] dy = { 1, 0, -1, 0 };
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        arr = new char[t][t];
        visit = new boolean[t][t];

        for (int i = 0; i < t; i++) {
            String s = br.readLine();

            for (int j = 0; j < t; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        count  = 0;
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        mcnt = count;
        count = 0;
        visit = new boolean[t][t];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                if(!visit[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        int ab_cnt= count;
        System.out.println(mcnt + " " + ab_cnt);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        char c = arr[x][y];
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < t && cy < t) {
                if (!visit[cx][cy] && arr[cx][cy] == c) {
                    dfs(cx, cy);
                }
            }
        }
    }

}
