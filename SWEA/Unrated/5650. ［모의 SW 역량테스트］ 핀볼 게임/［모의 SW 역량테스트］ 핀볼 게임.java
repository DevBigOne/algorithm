import java.io.*;
import java.util.*;

/*
 * SWEA 5650 - 핀볼 게임
 * - 방향을 정수(0~3)로 관리하며 한 칸씩 전진하는 시뮬레이션
 * - 블록(1~5)은 '진입 방향 -> 반사 방향'을 테이블(REFLECT)로 즉시 변환
 * - 웜홀(6~10)은 각 번호별 2지점 좌표를 미리 저장해 O(1)로 텔레포트
 * - 벽은 "블록 5"처럼 동작(정반사)하며 부딪힐 때마다 점수 +1
 * - 시작점으로 돌아오거나 블랙홀(-1)에 빠지면 시뮬레이션 종료
 */
public class Solution {
    static int N;
    static int[][] board;
    // wormholes[웜홀번호 6~10][엔드포인트 0/1][0=row, 1=col]
    static int[][][] wormholes;

    // 방향 인코딩: 0=위, 1=오른쪽, 2=아래, 3=왼쪽
    static final int[] DIR_ROW = {-1, 0, 1, 0};
    static final int[] DIR_COL  = { 0, 1, 0,-1};
    static final int DIRECTION_COUNT = 4;
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

    // 블록 반사 규칙: REFLECT[블록번호][진입방향] = 반사된 방향
    // (검증된 매핑. 여러 정답 코드에서 공통적으로 쓰는 테이블)
    static final int[][] REFLECT = {
        {},                      // 0번 인덱스는 사용하지 않음(더미)
        {DOWN, LEFT, RIGHT, UP}, // 블록 1
        {RIGHT, LEFT, UP, DOWN}, // 블록 2
        {LEFT, DOWN, UP, RIGHT}, // 블록 3
        {DOWN, UP, LEFT, RIGHT}, // 블록 4
        {DOWN, LEFT, UP, RIGHT}  // 블록 5(정반사)
    };

    static final int WORMHOLE_MIN = 6, WORMHOLE_MAX = 10;
    static final int ENDPOINT_0 = 0, ENDPOINT_1 = 1;
    static final int ROW = 0, COL = 1;

    static final int EMPTY = 0;       // 빈 칸
    static final int BLACK_HOLE = -1; // 블랙홀
    static final int WALL_BLOCK = 5;  // 벽은 블록 5처럼 반사
    static final int UNASSIGNED = -999999; // 웜홀 좌표 초기화용 값(보드와 무관)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine().trim());
            board = new int[N][N];
            wormholes = new int[WORMHOLE_MAX + 1][2][2];

            // 웜홀 좌표 초기화(아직 배정되지 않았음을 표시)
            for (int idx = WORMHOLE_MIN; idx <= WORMHOLE_MAX; idx++) {
                wormholes[idx][ENDPOINT_0][ROW] = UNASSIGNED;
                wormholes[idx][ENDPOINT_0][COL] = UNASSIGNED;
                wormholes[idx][ENDPOINT_1][ROW] = UNASSIGNED;
                wormholes[idx][ENDPOINT_1][COL] = UNASSIGNED;
            }

            // 보드 입력 및 웜홀 2지점 기록
            for (int r = 0; r < N; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for (int c = 0; c < N; c++) {
                    int v = Integer.parseInt(st.nextToken());
                    board[r][c] = v;
                    if (v >= WORMHOLE_MIN) {
                        if (wormholes[v][ENDPOINT_0][ROW] == UNASSIGNED) {
                            wormholes[v][ENDPOINT_0][ROW] = r;
                            wormholes[v][ENDPOINT_0][COL] = c;
                        } else {
                            wormholes[v][ENDPOINT_1][ROW] = r;
                            wormholes[v][ENDPOINT_1][COL] = c;
                        }
                    }
                }
            }

            // 모든 빈 칸(시작점 후보)에서 4방향으로 시뮬레이션하여 최대 점수 계산
            int maxScore = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] != EMPTY) continue;
                    for (int d = 0; d < DIRECTION_COUNT; d++) {
                        maxScore = Math.max(maxScore, simulate(r, c, d));
                    }
                }
            }

            sb.append('#').append(t).append(' ').append(maxScore).append('\n');
        }

        System.out.print(sb.toString());
    }

    // startRow, startCol에서 dir 방향으로 핀볼을 쏜 뒤 얻는 점수를 반환
    static int simulate(int startRow, int startCol, int dir) {
        int r = startRow, c = startCol, d = dir, score = 0;

        while (true) {
            // 1칸 전진
            r += DIR_ROW[d];
            c += DIR_COL[d];

            // 경계 밖으로 나가면 벽과 충돌한 것으로 간주
            // 벽은 블록 5처럼 정반사하고 점수 +1, 같은 칸에서 다시 진행
            if (r < 0 || r >= N || c < 0 || c >= N) {
                d = REFLECT[WALL_BLOCK][d];
                score++;
                continue;
            }

            // 시작점으로 돌아오거나 블랙홀에 빠지면 종료
            if ((r == startRow && c == startCol) || board[r][c] == BLACK_HOLE) {
                return score;
            }

            int cell = board[r][c];

            // 빈 칸이면 계속 직진
            if (cell == EMPTY) {
                continue;
            }

            // 블록(1~5)과 충돌: 반사 규칙에 따라 방향 갱신, 점수 +1
            if (1 <= cell && cell <= 5) {
                d = REFLECT[cell][d];
                score++;
                continue;
            }

            // 웜홀(6~10): 같은 번호의 다른 지점으로 좌표만 이동(방향은 유지)
            if (cell >= WORMHOLE_MIN) {
                int r0 = wormholes[cell][ENDPOINT_0][ROW];
                int c0 = wormholes[cell][ENDPOINT_0][COL];
                int r1 = wormholes[cell][ENDPOINT_1][ROW];
                int c1 = wormholes[cell][ENDPOINT_1][COL];

                if (r == r0 && c == c0) {
                    r = r1; c = c1;
                } else {
                    r = r0; c = c0;
                }
                // 방향 d는 그대로 유지
            }
        }
    }
}