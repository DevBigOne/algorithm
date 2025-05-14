import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int n = Integer.parseInt(br.readLine());

            long[] arr = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum = 0;

            long temp = arr[n - 1];
            for (int j = n - 2; j >= 0 ; j--) {
                if (temp > arr[j]) {
                    sum += temp - arr[j];
                } else if (arr[j] > temp) {
                    temp = arr[j];
                }
            }

            sb.append("#").append(i).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
