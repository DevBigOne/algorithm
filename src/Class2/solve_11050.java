package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve_11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if(n >=0 || m >=0){
            int s = 1;
            for (int i = 1; i <= n; i++) {
                s *= i;
            }
            int ss = 1;
            for (int i = 1; i <= m; i++) {
                ss *= i;
            }
            int sss = 1;
            for (int i = 1; i <= (n-m); i++) {
                sss *= i;
            }
            System.out.println(s / (ss * sss));
        }
        else {
            System.out.println(1);
        }
    }
}
