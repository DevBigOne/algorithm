import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(bf.readLine());
    int []arr = new int[N];
    for(int i = 0 ; i<N; i++) {
    	arr[i] = Integer.parseInt(st.nextToken());
    }
    int []sum_arr = new int[N+1];
    for(int i = 1; i <= N ; i++) {
    	sum_arr[i] = sum_arr[i-1]+arr[i-1];
    }
    
    for(int y = 0; y<M; y++) {
    	st = new StringTokenizer(bf.readLine());
    	int i = Integer.parseInt(st.nextToken());
    	int j = Integer.parseInt(st.nextToken());
    	int sum = sum_arr[j]-sum_arr[i-1];
    	if(i==j) {
    		System.out.println(arr[i-1]);
    	}
    	else {
    	System.out.println(sum);
    		}
    	}
   }
	}


