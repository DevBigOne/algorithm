package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj14940 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    static boolean[][]visit;
    static int[][] arr, result ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];
        result=new int[n][m];

        int x= 0, y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                    x = i;
                    y = j;
                }else if(arr[i][j]==0) visit[i][j]=true;

            }
        }
        bfs(x,y);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visit[i][j]) { // 도달할 수 없는 위치
                    result[i][j]=-1;
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]>q =new LinkedList<>();
        q.add(new int[] {x,y});
        visit[x][y]=true;
        while (!q.isEmpty()){
            int temp[]= q.poll();
            for(int i=0; i<4; i++) {
                int a=temp[0]+dx[i];
                int b=temp[1]+dy[i];
                if(a>=0 && a< n && b>=0 && b<m) {
                    if(!visit[a][b] && arr[a][b]==1) {
                        visit[a][b]=true;
                        result[a][b]=result[temp[0]][temp[1]]+1;
                        q.add(new int[] {a,b});
                    }
                }
            }
        }
    }
}
