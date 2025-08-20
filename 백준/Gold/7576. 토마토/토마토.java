import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int[][] arr;
    static int n, m, max = Integer.MIN_VALUE;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        bfs();

        // 익지 않은 토마토가 존재하는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    max = -1;
                    break;
                }
            }
            if (max == -1)
                break;
        }

        sb.append(max);

        System.out.println(sb);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();

            // 토마토가 익은 날짜 중에 max 값 찾아줌
            // arr[x][y]에 1 빼는 이유: 초기 토마토 값이 1이라 -1을 빼줘야 답임
            max = Math.max(arr[x][y] - 1, max);

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (isIn(cx, cy)) {
                    if (arr[cx][cy] == 0) { // 익지 않은 토마토인지 판단
                        // 익었으면 큐에 넣고 해당 토마토가 익은 날짜 업데이트
                        queue.add(new int[] {cx, cy});
                        arr[cx][cy] = arr[x][y] + 1;
                    }
                }
            }
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}