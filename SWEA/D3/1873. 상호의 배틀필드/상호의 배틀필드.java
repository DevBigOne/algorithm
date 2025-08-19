
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 방향: U, D, L, R (위, 아래, 왼쪽, 오른쪽)
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static int H, W, r, c;

    static int dirIdx(char ch) {
        if (ch == '^') return 0;
        if (ch == 'v') return 1;
        if (ch == '<') return 2;
        if (ch == '>') return 3;
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];
            r = c = -1;

            // 지도 입력 + 전차 위치 찾기
            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if ("^v<>".indexOf(map[i][j]) != -1) {
                        r = i;
                        c = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine().trim());
            String cmds = br.readLine().trim();

            for (int i = 0; i < N; i++) {
                char cmd = cmds.charAt(i);

                if (cmd == 'U') {
                    map[r][c] = '^';
                    if (r - 1 >= 0 && map[r - 1][c] == '.') {
                        map[r][c] = '.';
                        r--;
                        map[r][c] = '^';
                    }
                } else if (cmd == 'D') {
                    map[r][c] = 'v';
                    if (r + 1 < H && map[r + 1][c] == '.') {
                        map[r][c] = '.';
                        r++;
                        map[r][c] = 'v';
                    }
                } else if (cmd == 'L') {
                    map[r][c] = '<';
                    if (c - 1 >= 0 && map[r][c - 1] == '.') {
                        map[r][c] = '.';
                        c--;
                        map[r][c] = '<';
                    }
                } else if (cmd == 'R') {
                    map[r][c] = '>';
                    if (c + 1 < W && map[r][c + 1] == '.') {
                        map[r][c] = '.';
                        c++;
                        map[r][c] = '>';
                    }
                } else if (cmd == 'S') {
                    int d = dirIdx(map[r][c]);
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    while (0 <= nr && nr < H && 0 <= nc && nc < W) {
                        if (map[nr][nc] == '*') {
                            map[nr][nc] = '.';
                            break;
                        } else if (map[nr][nc] == '#') {
                            break;
                        } else {
                            nr += dr[d];
                            nc += dc[d];
                        }
                    }
                }
            }

            // === 출력 형식 수정: "#t " + 첫 번째 줄 지도 ===
            out.append('#').append(t).append(' ');
            for (int j = 0; j < W; j++) out.append(map[0][j]);
            out.append('\n');
            for (int i = 1; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    out.append(map[i][j]);
                }
                out.append('\n');
            }
        }

        System.out.print(out.toString());
    }
}