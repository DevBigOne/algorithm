import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long max = 1;
        if (N == 0) System.out.println(max);
        else {
            for (int i = 1; i <= N; i++) {
                max *= i;
            }
            System.out.println(max);
        }
    }
}
