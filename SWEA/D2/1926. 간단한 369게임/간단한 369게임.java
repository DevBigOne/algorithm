import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            int cnt = 0;

            for (char c : s.toCharArray()) {
                if (c == '3' || c == '6' || c == '9') {
                    cnt++;
                }
            }

            if (cnt > 0) {
                for (int j = 0; j < cnt; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }


        }

    }
}
