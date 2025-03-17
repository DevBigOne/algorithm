package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1861 {

    static int[] dx = {-1, 1, 0, 0}; // 왜 만듬?
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr;
    static int n, max, startRoom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            max = Integer.MIN_VALUE;
            startRoom = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(1, i, j, arr[i][j]);
                }
            }

            System.out.println("#" + T + " " + startRoom + " " + max);
        }
    }

    /**
     * @param count : 현재 이동한 방의 갯수
     * @param x     : 현재 방의 x 좌표
     * @param y     : 현재 방의 y 좌표
     * @param start : 시작한 방의 번호
     */
    static void dfs(int count, int x, int y, int start) {
        // 제일 많이 이동한 방의 갯수를 구해야함
        if (count > max) {
            max = count;
            startRoom = start;
        }
        // 만약 최댓값이 같다면 작은 방의 번호 출력
        else if (count == max) {
            startRoom = Math.min(startRoom, start);
        }

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                if (arr[x][y] + 1 == arr[cx][cy]) {
                    dfs(count + 1, cx, cy, start);
                }
            }
        }
    }
}
//        int t = Integer.parseInt(br.readLine());
//
//        int n = Integer.parseInt(br.readLine());
//
//        for (int i = 0; i < t ; i ++) {
//            int[][] a = new int[n][n];
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                a[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int[] tot = new int[n*n]; // 저장용
//        int start = n*n; // 시작?용으로 왜 필요
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                cnt = 0;
//            }
//        }
//    }



