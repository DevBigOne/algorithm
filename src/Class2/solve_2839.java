package Class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = 0;
        int sum = 0;
        if((N%5)%3 == 0){
            sum = N/5;
        }
        System.out.println(sum);
    }
}
