import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] arr = new int[n];
        int[] arrSort = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arrSort = arr.clone();
        Arrays.sort(arrSort);

        int count = 0;

        for (int i = 0; i < n; i++) { 
            if(!map.containsKey(arrSort[i])){
                map.put(arrSort[i], count++);
            }
        }

        for (int i = 0; i <n; i++) {
           sb.append(map.get(arr[i]) + " ");
        }
        System.out.println(sb);
    }
}
