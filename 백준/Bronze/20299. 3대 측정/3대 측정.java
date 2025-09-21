import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int s = 0;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] arr2 = new int[n][3];
        for (int i = 0; i < n; i++) {
            int x1 = arr[i][0];
            int x2 = arr[i][1];
            int x3 = arr[i][2];

            if((x1 + x2 + x3) >= k && x1 >= l && x2 >= l && x3 >= l) {
                cnt++;
                arr2[s][0] = x1;
                arr2[s][1] = x2;
                arr2[s][2] = x3;
                s++;
            }
        }
        sb.append(cnt).append("\n");
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(arr2[i][j] + " ");
            }
        }

        System.out.println(sb.toString());
    }
}
