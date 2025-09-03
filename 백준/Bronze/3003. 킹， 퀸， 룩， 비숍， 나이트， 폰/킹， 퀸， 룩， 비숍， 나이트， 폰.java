import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[6];
        int[] arr1 = {1, 1, 2, 2, 2, 8};

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 6; i++) {
            if(arr[i] == arr1[i]){
                System.out.print(0 + " ");
            } else if (arr[i] != arr1[i]) {
                System.out.print((arr1[i] -arr[i]) + " ");
            }
        }
    }
}
