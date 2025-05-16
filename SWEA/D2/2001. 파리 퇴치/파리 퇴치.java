import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            int max = 0;
            
            for (int i = 0; i < arr.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < arr.length; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i <= n - m; i++) {  
                for (int j = 0; j <= n - m; j++) {  
                    int sum = 0;
                    for (int k = i; k < i + m; k++) {
                        for (int l = j; l < j + m; l++) {
                            sum += arr[k][l];
                        }
                    }
                    max = Math.max(max, sum);  
                }
            }

            System.out.println("#" + t + " " + max);

        }

    }
}
