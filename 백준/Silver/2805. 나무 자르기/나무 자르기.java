import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] wood;
    static int start, end, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        wood = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            wood[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wood);
        start = 0; 
        end = wood[n - 1]; 
        Parametric(m);
    }

    static void Parametric(int m) {
        ans = 0;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            long sum = 0; 

            for (int i = 0; i < wood.length; i++) {
                if (wood[i] > mid) {
                    sum += wood[i] - mid;
                }
            }

            if (sum >= m) {
                ans = mid; 
                start = mid + 1; 
            } else {
                end = mid - 1; 
            }
        }

        System.out.println(ans);
    }
}
