import java.io.*;
import java.util.*;

public class Solution {
    static int V, E;
    static int[][] arr;      
    static boolean[] visit;
    static int[] result;     
    static int idx;        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t <= 10; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            arr = new int[V + 1][V + 1];
            visit = new boolean[V + 1];
            result = new int[V + 1];
            idx = V; 

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }

    
            for (int i = 1; i <= V; i++) {
                if (!visit[i]) {
                    dfs(i);
                }
            }

            System.out.print("#" + t + " ");
            for (int i = 1; i <= V; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
    }

    static void dfs(int cur) {
        visit[cur] = true;

        for (int next = 1; next <= V; next++) {
            if (arr[cur][next] == 1 && !visit[next]) {
                dfs(next);
            }
        }

        result[idx--] = cur;
    }
}
