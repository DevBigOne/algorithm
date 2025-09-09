import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {  
    static int[] arr;
    static int[] pick;   
    static boolean[] used;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        pick = new int[m];
        used = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 사전순 출력을 위해 정렬

        back(0, 0); // start 파라미터는 그대로 둬도 됩니다.
    }

    private static void back(int start, int cnt) {
        if (cnt == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(pick[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {    
            if (used[i]) continue;       
            used[i] = true;
            pick[cnt] = arr[i];
            back(start, cnt + 1);        
            used[i] = false;           
        }
    }
}
