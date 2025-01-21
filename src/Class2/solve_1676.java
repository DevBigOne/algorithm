package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int divisor = 5;
        while (n / divisor > 0) {
            count += n / divisor;
            divisor *= 5;
        }
        System.out.println(count);
    }
}
