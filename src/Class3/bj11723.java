package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int M = Integer.parseInt(br.readLine());
        int s = 0;
        while (M--> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("all")) s = (1 << 21) - 1;
            else if(order.equals("empty")) s = 0;
            else {
                int num = Integer.parseInt(st.nextToken());
                if(order.equals("add"))
                    s |= (1 << num);
                else if(order.equals("remove"))
                    s &= ~(1 << num);
                else if(order.equals("check"))
                    sb.append((s & (1 << num)) != 0 ? 1 : 0).append("\n");
                else if(order.equals("toggle"))
                    s ^= (1 << num);
            }
        }
        System.out.println(sb);
    }
}
