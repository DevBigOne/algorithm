/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //도시의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		//도시들까지의 거리 입력받기
		int[] dist = new int[N-1];
		for(int i = 0 ; i < N-1; i++){
		    dist[i] = Integer.parseInt(st.nextToken());
		}
		//각 도시의 기름 가격 입력 받기 
		st = new StringTokenizer(br.readLine());
		int[] oil = new int[N];
		for(int i = 0 ; i < N ; i++){
		    oil[i] = Integer.parseInt(st.nextToken());
		}
		int cost = 0; //비용 담을 변수 
		//메인 로직
		for(int i = 0 ; i < N-1 ; i++){
		    //그 뒤의 가격 비교
		    int flag = 0;
		    for(int j = i+1; j < N-1 ; j++ ){
		        if(oil[j] < oil[i]) flag = 1; //작은 가격이 후에 있음
		    }
		    //그 뒤에 작은 가격이 있다면
		    if(flag == 1){
		        cost += oil[i]*dist[i];
		    } else { // 지금이 제일 가격 적다면 
		        for(int k = i ; k < N-1 ; k++){
		            cost += oil[i]*dist[k];
		        }
		        break; //반복문 탈출 
		    }
		    
		}
		//정답 출력 
		System.out.println(cost);
		
	}
}