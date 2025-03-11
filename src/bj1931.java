import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         int[][] t = new int[n][2];

         for(int i = 0; i < n; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine());
             t[i][0] = Integer.parseInt(st.nextToken());
             t[i][1] = Integer.parseInt(st.nextToken());
         }
        /**
         * 여기 아래 복습하기
         */
         Arrays.sort(t, new Comparator<int[]>() {
             @Override
             public int compare(int[] o1, int[] o2) {
                 if (o1[1] == o2[1])
                     return o1[0] - o2[0];
                 return o1[1] - o2[1];
             }
         });

         int time = t[0][1];
         int cnt = 1;
         for (int i = 1; i < n; i++) {
             if(time <= t[i][0]) {
                 cnt++;
                 time = t[i][1];
             }
         }
        System.out.println(cnt);
    }
}
