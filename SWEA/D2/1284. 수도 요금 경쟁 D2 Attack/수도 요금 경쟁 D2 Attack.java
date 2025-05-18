import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int a = 0;
            int b = 0;

            a = p * w;
            if (r >= w) {
                b = q;
            } else {
                b = q + ((w - r) * s);
            }

           if (b > a) {
               System.out.println("#" + t + " " + a);
           } else {
               System.out.println("#" + t + " " + b);
           }

        }
    }
}
