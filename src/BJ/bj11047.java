package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11047 {

    static int[] arr ;
    static int cnt, n, k ,nn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        nn =  n-1 ;
        bfs();
        System.out.println(cnt);
    }

    static void bfs() {
        while ((nn)>= 0 && k != 0) {
            if(k >= arr[nn]) {
                int s = k / arr[nn];
                cnt += s;
                k -= s * arr[nn];
            }
            nn--;
        }
    }
}
