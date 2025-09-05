import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T ; t++) {
            int tt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[101];
            int max = 0;
            int idx = 0;
            for (int i = 0; i < 1000; i++) {
                int a = Integer.parseInt(st.nextToken());
                arr[a]++;

                if(arr[a] >= max) {
                    max = arr[a];
                    idx = a;
                }
            }
            System.out.println("#" + t + " " + idx);
        }
    }
}
