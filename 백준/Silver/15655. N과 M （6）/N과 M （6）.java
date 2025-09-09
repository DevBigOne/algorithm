import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] pick;   // 조합 결과 담는 배열
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        pick = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i= 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        back( 0,0);

    }

    private static void back(int start, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(pick[i] + " ");
            }
            System.out.println();
            return;
        }
        int i;
        for (i = start; i < n; i++) {
                pick[cnt] = arr[i];
                back(i + 1, cnt + 1);
        }
    }
}
