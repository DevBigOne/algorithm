package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String s = "";
        s += n;
        s += k;

        System.out.println(n+k-m);
        System.out.println(Integer.parseInt(s) - m);
    }
}
