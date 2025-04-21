package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj11725 {

    static int[] bomo;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        tree = new ArrayList[n + 1];
        bomo = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(bomo[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        bomo[start] = 0;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int node : tree[a]) {
                if (bomo[node] == 0) {
                    bomo[node] = a;
                    q.add(node);
                }
            }
        }
    }
}
