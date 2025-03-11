import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1959 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] a1 = new int[a];
            int[] b1 = new int[b];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < a; j++) {
                a1[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                b1[j] = Integer.parseInt(st.nextToken());
            }
            int ss = 0;
            if(a > b) {
                for (int j = 0; j <= (a - b) ; j++) {
                    int s = 0;
                    for (int k = 0; k < b; k++) {
                        s += a1[j+k] * b1[k];
                    }
                    ss = Math.max(ss, s);
                }
            } else {
                for (int e = 0; e <= (b - a) ; e++) {
                    int s = 0;
                    for (int k = 0; k < a; k++) {
                        s += b1[e+k] * a1[k];
                    }
                    ss = Math.max(ss, s);
                }
            }
            System.out.println("#" + (i + 1) + " "+ ss);


        }
    }
}
