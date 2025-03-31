package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1667 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int[][] map;
    static boolean[][] visit;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    static void bfs(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {startX, startY});
        visit[startX][startY] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                // 범위 내에 들고
                if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                    // 방문을 안했고, 1번일 때
                    if (!visit[cx][cy] && map[cx][cy] == 1) {
                        visit[cx][cy] = true;
                        q.add(new int[] {cx, cy});
                        count++;
                    }
                }
            }
        }


        list.add(count);
    }
}
