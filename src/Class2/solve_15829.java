package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        long sum = 0;
        int M = 1234567891;
        String s = br.readLine();
        long power = 1;
        for (int i = 0; i < L; i++) {
            int index = 0;
            index =( s.charAt(i) - 'a') + 1; // 위치
            sum = (sum + index * power) % M;
            power = (power * 31) % M;
        }
        System.out.println((int) sum);
    }
}
