import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] num = {2 ,3 ,5, 7, 11};

        for (int t = 1; t <= T; t++) {
            int[] nums = new int[5];
            int n = Integer.parseInt(br.readLine());
            while (n > 1) {
                if (n % 2 == 0) {
                    n /= 2;
                    nums[0]++;
                }
                if (n % 3 == 0) {
                    n /= 3;
                    nums[1]++;
                }
                if (n % 5 == 0) {
                    n /= 5;
                    nums[2]++;
                }
                if (n % 7 == 0) {
                    n /= 7;
                    nums[3]++;
                }
                if (n % 11 == 0) {
                    n /= 11;
                    nums[4]++;
                }
            }

            System.out.println("#"+ t+" "+ nums[0] + " "+ nums[1] + " "+ nums[2] + " "+ nums[3] + " "+ nums[4]);
        }
    }
}
