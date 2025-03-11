import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int T = 1; T <= t; T++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            /**
             * 정은이 풀이
             */
//            for (int i = 0; i < n - m; i++) {
//                for (int j = 0; j < n - m; j++) {
//                    int sum = 0;
//                    for (int k = i; k < i + m; k++) {
//                        for (int l = j; l < j + m; l++) {
//                            sum += arr[k][l];
//                        }
//                    }
//                    answer = Math.max(sum, answer);
//                }
//            }
            /**
             * 대원이 풀이 활용
             */
            int cnt1 = 0;
            int cnt2 = 0;
            int cnt3 = m;
            int cnt4 = m;
            for (int k = 0; k < n * n; k++) {
                int sum = 0;
                for (int i = cnt1; i < cnt3; i++) {
                    for (int j = cnt2; j < cnt4; j++) {
                        sum += arr[i][j];
                    }
                }


                cnt1 = k / n;
                cnt3 = k / n + m;

                cnt2 = k % n;
                cnt4 = (k - m) % n;

                System.out.println(cnt1 + " " + cnt3 + " " + cnt2 + " " + cnt4);

                answer = Math.max(sum, answer);
            }

            /**
             * 대원이 풀이
             */
//            int sum = 0;
//            int[] suarr = new int[n*n];
//            for (int k = 0; k < n*n; k++) {
//                for (int i = cnt1; i < cnt3; i++) {
//                    for (int j = cnt2; j < cnt4; j++) {
//                        sum = sum + arr[i][j];
//                    }
//                    cnt1++;
//                    cnt2++;
//                    cnt3++;
//                    cnt4++;
//                }
//
//                suarr[k] = sum;
//
//            }
//            Arrays.sort(suarr);
//            answer = suarr[0];
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
