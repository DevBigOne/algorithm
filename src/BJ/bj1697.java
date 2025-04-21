package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1697 { // 아직 안품

    static int  n, k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for (int i = n; i < k; i++) {
            arr[i] = i;
        }

        bfs(n,k);

    }
    static void bfs(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();

    }
}
