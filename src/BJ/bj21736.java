package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj21736 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static int[][] arr;
    static int n, m;
    static int answer = 0;

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visit = new boolean[n][m];
        arr = new int[n][m];

        Point start = null;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char ch = s.charAt(j);
                if (ch == 'I') {
                    start = new Point(i, j);
                } else if (ch == 'X') {
                    arr[i][j] = -1;
                } else if (ch == 'O') {
                    arr[i][j] = 0;
                } else if (ch == 'P') {
                    arr[i][j] = 1;
                }
            }
        }

        bfs(start);

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    static void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        visit[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visit[nx][ny] && arr[nx][ny] != -1) {
                    if (arr[nx][ny] == 1) {
                        answer++;
                    }
                    visit[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }
}
