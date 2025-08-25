import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int a, b, n, m;
    static int[] parents;

    private static void make() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {  
            parents[i] = i; // make set : 자신을 자신의 부모로 초기화(자신이 곧 루트)
        }
    }

    private static int find(int a) { // a가 속한 집합(대표자) 찾기
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]); // 경로 압축
    }

    private static boolean union(int a, int b) { // a,b가 속한 집합을 합치기
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false; // 이미 같은 집합

        parents[rootB] = rootA;
        return true; // 합치기 성공
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); 
            m = Integer.parseInt(st.nextToken());  
            make();

            System.out.print("#" + tc + " ");
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken()); // 0: 합집합, 1: 같은 집합인가
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (cmd == 0) {
                    union(a, b);
                } else { 
                    if (find(a) == find(b)) {
                        System.out.print(1); 
                    } else {
                        System.out.print(0);
                    }
                }
            }
            System.out.println(); 
        }
    }
}