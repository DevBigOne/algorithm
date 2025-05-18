import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] arra = new int[a];
            int[] arrb = new int[b];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < a; i++) {
                arra[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < b; i++) {
                arrb[i] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            int sum = 0;
            if (a > b) {
                for (int i = 0; i <= a - b; i++) {
                    sum = 0;
                    for (int j = 0; j < b; j++) {
                        sum += arra[i + j] * arrb[j];
                    }
                    max = Math.max(max, sum);
                }
            } else if (b > a){
                for (int i = 0; i <= b - a; i++) {
                    sum = 0;
                    for (int j = 0; j < a; j++) {
                        sum += arrb[i + j] * arra[j];
                    }
                    max = Math.max(max, sum);
                }
            }
            System.out.println("#" + t + " " + max);
        }
    }
}