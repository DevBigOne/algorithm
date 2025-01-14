package Class1;

import java.io.*;

public class solve_2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(s[i]);
            sum = (int) (sum + Math.pow(a, 2));
        }
        int tot = sum % 10;
        System.out.println(tot);

    }
}
