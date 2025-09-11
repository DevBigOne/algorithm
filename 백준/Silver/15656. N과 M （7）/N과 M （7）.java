import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] pick;
    static int n,m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        pick = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        back(0);

        System.out.println(sb.toString());

    }

    private static void back(int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                sb.append(pick[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        for (int i = 1; i <= n; i++) {
                pick[cnt] = arr[i];
                back(cnt + 1);
        }
    }
}
