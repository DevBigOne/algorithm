package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea12712 {
    static int[] dx = {-1, 1, 0, 0}; // + 방향
    static int[] dy = {0, 0, -1, 1};

    static int[] ax = { -1, -1, 1, 1 }; // X 방향 (대각선)
    static int[] ay = { -1, 1, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int T = 1; T <= t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = 0;  // 최댓값 저장

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int plusSum = arr[i][j]; // + 방향 합
                    int crossSum = arr[i][j]; // x 방향 합

                    for (int k = 1; k < m; k++) {  // 1부터 m-1까지 이동
                        for (int d = 0; d < 4; d++) {  // 4방향 탐색
                            int cx = i + dx[d] * k;
                            int cy = j + dy[d] * k;

                            if (cx >= 0 && cx < n && cy >= 0 && cy < n) {
                                plusSum += arr[cx][cy];
                            }

                            int ax_cx = i + ax[d] * k;
                            int ax_cy = j + ay[d] * k;

                            if (ax_cx >= 0 && ax_cx < n && ax_cy >= 0 && ax_cy < n) {
                                crossSum += arr[ax_cx][ax_cy];
                            }
                        }
                    }
                    maxSum = Math.max(maxSum, Math.max(plusSum, crossSum));
                }
            }
            System.out.printf("#%d %d\n", T, maxSum);
        }
    }
}
