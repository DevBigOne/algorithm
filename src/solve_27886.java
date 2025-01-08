import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_27886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String[] ss = new String[s.length()];
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ss[i] = String.valueOf(c);
        }
        System.out.println(ss[a -1]);

    }
}
