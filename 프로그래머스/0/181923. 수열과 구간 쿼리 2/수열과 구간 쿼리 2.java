import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int q = queries.length;
        int[] answer = new int[q];
        Arrays.fill(answer, -1); // 기본값 -1

        for (int qi = 0; qi < q; qi++) {
            int s = queries[qi][0];
            int e = queries[qi][1];
            int k = queries[qi][2];

            int best = Integer.MAX_VALUE;

            for (int i = s; i <= e; i++) {
                int v = arr[i];
                if (v > k && v < best) best = v;
            }

            answer[qi] = (best == Integer.MAX_VALUE) ? -1 : best;
        }
        return answer;
    }
}
