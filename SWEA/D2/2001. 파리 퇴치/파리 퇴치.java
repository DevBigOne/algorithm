import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int  M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            
            int max = 0;
            for (int i = 0; i <= N - M; i++) { // 전체 돌리기
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int k = i; k <  i + M; k++) { // m만큼 돌리기
                        for (int l = j; l < j + M; l++) {
                            sum += arr[k][l];
                        }
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#"+ t + " " + max );
        }
    }
}
