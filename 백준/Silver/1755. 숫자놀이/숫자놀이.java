import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dic = {8,5,4,9,1,7,6,3,2,0};
    static int M, N;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // dic 순서로 시작 숫자 반복 (0 제외)
        for(int i = 0; i < 10; i++) {
            if(dic[i] != 0) dfs(dic[i]);
        }
        if(cnt % 10 != 0) System.out.println();
    }

    static void dfs(int num) {
        if(num > N) return;           // N보다 크면 종료
        if(num >= M) {
            System.out.print(num + " ");
            cnt++;
            if(cnt % 10 == 0) System.out.println();
        }
        // 다음 자리수 붙이기
        for(int i = 0; i < 10; i++) {
            int next = num * 10 + dic[i];
            dfs(next);
        }
    }
}
