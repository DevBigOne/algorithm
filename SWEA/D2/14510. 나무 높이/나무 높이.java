
import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int king = 0; // 제일 큰 나무
            // 입력 받기, 제일 큰 나무 구하기
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                king = Math.max(king, arr[i]);
            }
            int sum = 0; // 나무들이 제일 큰 나무만큼 자라기 위해 필요한 총 키
            for (int i = 0; i < N; i++) {
                sum += king - arr[i];
            }
            int max2 = 0; // 가능한 최대 +2 횟수
            for (int i = 0; i < N; i++) {
                // 각각의 나무마다 가능한 +2의 개수
                max2 += (king - arr[i]) / 2;
            }
            int min = Integer.MAX_VALUE;
            // +2 횟수 : 0 ~ max2 인 경우
            for (int i = 0; i <= max2; i++) {
                int cnt1 = sum - i * 2; // +1의 개수
                int cnt2 = i; // +2의 개수
                // +1 cnt1개, +2 cnt2개 인 여러 조합 중 최종 물주는 날을 비교. 가장 빨리 끝나는 날 구하기
                min = Math.min(min, Math.max(cnt1*2-1, cnt2*2));
            }
            sb.append("#").append(t + 1).append(" ").append(min).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
