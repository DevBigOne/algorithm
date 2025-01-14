package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0 && k == 0) {
                break;
            }
            else if (k*k == n*n + m*m || m*m == n*n + k*k || n*n == m*m + k*k) {

                System.out.println("right");
            }
            else  {
                System.out.println("wrong");
            }
        }
    }
}
