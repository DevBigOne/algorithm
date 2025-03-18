package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int mon = Integer.parseInt(st.nextToken());
            int mon3 = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] plan = new int[12];
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

        }
    }

    static void dfs(){

    }
}
