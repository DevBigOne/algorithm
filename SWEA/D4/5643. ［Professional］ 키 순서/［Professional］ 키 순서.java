import java.io.*;
import java.util.*;

public class Solution {
	static int T;
	static int n, m;
	
	static List<Integer>[] af;
	static List<Integer>[] bf;
	static boolean[] visited;
	
	static int sum, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			
			af = new ArrayList[n + 1];
			bf = new ArrayList[n + 1];
			
			for (int i = 1; i <= n; i++) {
				af[i] = new ArrayList<>();
				bf[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				af[from].add(to);
				bf[to].add(from);
			}
			
			cnt = 0;
			
			for (int i = 1; i <= n; i++ ) {
				sum = 0;
				visited = new boolean[n + 1];
				af(i);
				
				visited = new boolean[n + 1];
				bf(i);
				
				if(sum == n - 1) {
					cnt++;
				}
			}
			
			System.out.println("#"+t+" " + cnt);
		}
		
		
	}
	private static void af(int i) {
		visited[i] = true;
		
		for(int next : af[i]) {
			if(!visited[next]) {
				sum++;
				af(next);
			}
		}
	}
	
	private static void bf(int i) {
		visited[i] = true;
		
		for(int next : bf[i]) {
			if(!visited[next]) {
				sum++;
				bf(next);
			}
		}
	}
}
