package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int count = 0;

        for (int i = 0; i < 6; i++) {
            count += arr[i] / T;
            if (arr[i] % T != 0) {
                    count++;
            }
        }

        int tot = N / S;
        int penother = N % S;

        System.out.println(count + "\n" + tot + " " + penother);

    }
}
