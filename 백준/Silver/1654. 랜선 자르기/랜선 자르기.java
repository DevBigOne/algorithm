import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long max = 0;
        long[] arr = new long[n];

        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]); // 왜 맥스값을 뽑죠?
        }

        max++;
        long min = 0;
        long answer = 0;
        
        // min이 max와 같거나, min이 더 커질 경우 break
        while (min < max) { // 이분탐색
            long sum = 0;
            long mid = (min + max) / 2;

            // mid 사이즈만큼 잘랐을 때 랜선이 몇개 나오는지 확인
            for (int i = 0; i < n; i++) {
                sum += arr[i] / mid;
            }

            // sum의 갯수가 n보다 작다?? 그럼 mid의 값이 큰거임 -> max값 줄여줌
            if (sum < n) {
                max = mid;
            } else {
                answer = Math.max(answer, mid);
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}

