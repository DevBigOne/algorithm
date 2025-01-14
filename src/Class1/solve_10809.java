package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solve_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] aa = new int[26];
        Arrays.fill(aa, -1);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(aa[c - 'a'] == -1) {
                aa[c - 'a'] = i;
            }
        }
        for(int i = 0; i < aa.length; i++) {
            System.out.print(aa[i] + " ");
        }
    }
}
