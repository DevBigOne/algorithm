import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solve_10250 { // 나중에 재풀이 필요
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = (N - 1)%H + 1; // 나눈 나머지를 구하면 층수 YY
            int num = (N - 1)/H + 1; // 나눈 것을 구하면 룸 번호 XX
            int room = (floor * 100) + num;

            System.out.println(room);
        }
    }
}
