package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ;
        while (true) {
            s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            StringBuilder sb = new StringBuilder(s);
            String ss = sb.reverse().toString();
            if (s.equals(ss)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
