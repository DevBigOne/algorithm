import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        int sum = 0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            num = Character.getNumericValue(c);
            sum += num;
        }
        System.out.println(sum);
    }
}
