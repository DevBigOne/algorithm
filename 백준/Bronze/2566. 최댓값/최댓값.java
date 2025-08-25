import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[9][9];
        int a = 0;
        int b = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                if (max == arr[i][j]){
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((a + 1) + " " + (b+1));
    }
}
