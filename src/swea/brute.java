package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class brute {

    static boolean[] visit;
    static char[] arr;
    static int n;
    static String max = "-1", min = "9999999999";

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        arr = new char[n];
        visit = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        for (int i = 0; i < 10; i++) {
            visit[i] = true;
            dfs(0, i + "");
            visit[i] = false;
        }

        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    static void dfs(int depth, String num) {
        if (depth == n) {
            max = Long.parseLong(max) > Long.parseLong(num) ? max : num;
            min = Long.parseLong(min) < Long.parseLong(num) ? min : num;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (arr[depth] == '<') {
                if (!visit[i] && i > (num.charAt(depth) - '0')) {
                    visit[i] = true;
                    dfs(depth + 1, num + i);
                    visit[i] = false;
                }
            } else {
                if (!visit[i] && i < (num.charAt(depth) - '0')) {
                    visit[i] = true;
                    dfs(depth + 1, num + i);
                    visit[i] = false;
                }
            }
        }
    }
}