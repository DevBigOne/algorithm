import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1]; 
        for (int idx = 1; idx <= n; idx++){
            arr[idx] = idx;
        } 

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());


            int l = i;
            int r = j;
            while (l < r) {
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
                l++;
                r--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx <= n; idx++) {
            sb.append(arr[idx]).append(' ');
        }
        System.out.print(sb.toString());
    }
}
