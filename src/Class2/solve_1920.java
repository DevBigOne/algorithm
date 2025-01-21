package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] n = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            n[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n);

        int m = Integer.parseInt(br.readLine());
        int[] a = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for (int s: a) {
            int re = Arrays.binarySearch(n, s);

            if(re >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
