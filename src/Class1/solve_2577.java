package Class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class solve_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int sum = a * b * c;

        String s = Integer.toString(sum);
        int[] nums = new int[10];
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0') {
                nums[0]++;
            }
            if (s.charAt(i) == '1') {
                nums[1]++;
            }
            if (s.charAt(i) == '2') {
                nums[2]++;
            }
            if (s.charAt(i) == '3') {
                nums[3]++;
            }
            if (s.charAt(i) == '4') {
                nums[4]++;
            }
            if (s.charAt(i) == '5') {
                nums[5]++;
            }
            if (s.charAt(i) == '6') {
                nums[6]++;
            }
            if (s.charAt(i) == '7') {
                nums[7]++;
            }
            if (s.charAt(i) == '8') {
                nums[8]++;
            }
            if (s.charAt(i) == '9') {
                nums[9]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(nums[i]);
        }
    }
}
