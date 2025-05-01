import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int x;
        int time;

        public Node (int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int n, k;
    static int min = Integer.MAX_VALUE;
    static int max = 100_000;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visit = new boolean[100_001];

        if (n == k) {
            System.out.println(0);
        } else {
            bfs();
            System.out.println(min);
        }
    }

    static void bfs () {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(n, 0));

        while (!q.isEmpty()) {
            Node current = q.poll();
            // x: 현재 수빈이의 위치
            // time: 현재 시간
            int x = current.x;
            int time = current.time;

            // 수빈이 위치랑 동생 위치가 동일해졌으면 끝
            if (x == k) {
                min = Math.min(min ,time);
                break;
            }

            if (x - 1 >= 0 && !visit[x - 1]) {
                visit[x - 1] = true;
                q.add(new Node(x - 1, time + 1));
            }

            if (x + 1 <= max && !visit[x + 1]) {
                visit[x + 1] = true;
                q.add(new Node(x + 1, time + 1));
            }

            if (x * 2 <= max && !visit[x * 2]) {
                visit[x * 2] = true;
                q.add(new Node(x * 2, time + 1));
            }
        }
    }
}
