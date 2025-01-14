package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int score = 0;
            int count = 0;
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == 'O') {
                    count++;
                    score += count;
                } else {
                    count = 0;
                }
            }
            System.out.println(score);
        }
    }
}
