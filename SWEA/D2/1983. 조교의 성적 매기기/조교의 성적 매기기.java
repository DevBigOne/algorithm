import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for (int t = 1 ; t <= T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            Double[] score = new Double[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int mid = Integer.parseInt(st.nextToken());
                int last = Integer.parseInt(st.nextToken());
                int home = Integer.parseInt(st.nextToken());

                score[i] = (mid * 0.35) + (last * 0.45) + (home * 0.2);

            }

            double target = score[k - 1];
            Arrays.sort(score, Collections.reverseOrder());

            String answer = "";
            for (int i = 0; i < n; i++) {
                if (score[i] == target) {
                    answer = grade[i / (n / 10)];
                    break;
                }
            }
            System.out.println("#" + t + " " + answer);
        }
    }
}
