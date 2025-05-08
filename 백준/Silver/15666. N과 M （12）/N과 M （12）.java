import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] seq, arr;
    static StringBuilder sb = new StringBuilder();
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n]; // 값 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        seq = new int[m]; // 최종값저장
        ans = new LinkedHashSet<>();

        Arrays.sort( arr);

        dfs(0,0);

        for (String s : ans) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int index, int depth) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i : seq) {
                sb.append(i).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = index; i < n; i++) {
                seq[depth] = arr[i];
                dfs(i,depth + 1);
        }
    }
}
