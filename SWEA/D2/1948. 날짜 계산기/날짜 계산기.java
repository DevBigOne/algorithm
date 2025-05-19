import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arrm = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fm = Integer.parseInt(st.nextToken());
            int fd = Integer.parseInt(st.nextToken());
            int lm = Integer.parseInt(st.nextToken());
            int ld = Integer.parseInt(st.nextToken());

            int sum = 0;

            if (fm == lm) {
                    sum = ld - fd + 1;
            } else {
                for (int j = fm; j < lm ; j++) {
                    sum += arrm[j];
                }
                sum += ld - fd + 1;
            }

            System.out.println("#" + t + " " + sum);
        }
    }
}
