package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class solve_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BigInteger a = new BigInteger(input[0]);
        BigInteger b = new BigInteger(input[1]);

        BigInteger GCD = a.gcd(b);
        System.out.println(GCD);
        BigInteger LCM = (a.multiply(b)).divide(GCD);
        System.out.println(LCM);
    }
}
