import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n =  Integer.parseInt(br.readLine());

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                }
            }

            int sum = 0;
            int mid = n / 2;
            for (int i = 0; i < n; i++) {
                int range = Math.abs(mid - i); 
                for (int j = range; j < n - range; j++) { 
                    sum += arr[i][j];
                }
            }

            System.out.println("#" + t + " " + sum);
        }
    }
}