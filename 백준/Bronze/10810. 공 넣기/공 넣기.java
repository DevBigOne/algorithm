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

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int i  = Integer.parseInt(st.nextToken()); 
            int j = Integer.parseInt(st.nextToken());  
            int k = Integer.parseInt(st.nextToken());  

            for (int b = i; b <= j; b++) {
                arr[b] = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int b = 1; b <= n; b++) {
            sb.append(arr[b]).append(' ');
        }
        System.out.print(sb.toString());
    }
}
