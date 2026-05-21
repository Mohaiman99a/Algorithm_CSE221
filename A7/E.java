import java.io.*;
import java.util.*;

public class E{
    //(node, 0) -> Even
   //(node, 1) -> Oddd
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());

        int[] u= new int[M];
        int[] v= new int[M];
        int[] w= new int[M];       

        StringTokenizer st_u= new StringTokenizer(br.readLine(), " ");
        StringTokenizer st_v= new StringTokenizer(br.readLine(), " ");
        StringTokenizer st_w= new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++){
            u[i]= Integer.parseInt(st_u.nextToken());
            v[i]= Integer.parseInt(st_v.nextToken());
            w[i]= Integer.parseInt(st_w.nextToken());
        }


        ArrayList<int[]>[] arr= new ArrayList[N+1];
        for(int i=1; i<=N; i++) arr[i]= new ArrayList<>();
        for(int i=0; i<M; i++){
            arr[u[i]].add(new int[]{v[i], w[i]});      
        }






     //Dijkstra
        long[][] distance= new long[ N+1 ][2];                     
        for(int i=1; i<=N; i++) Arrays.fill(distance[i], Long.MAX_VALUE);

       //a= {node, parity, distance}
        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a -> a[2]));
        pq.add(new long[]{1, 0, 0}); 
        pq.add(new long[]{1, 1, 0});   
        distance[1][0]= 0;
        distance[1][1]= 0;

        while(!pq.isEmpty()){
            long[] curr= pq.poll();         
            int curr_node=(int) curr[0];
            int curr_Parity= (int) curr[1];
            long curr_d= curr[2];
            if(curr_d> distance[curr_node][curr_Parity]) continue;

            for(int i=0; i<arr[curr_node].size(); i++){
                int[] next = arr[curr_node].get(i);      
                int next_node= next[0];
                int next_weight= next[1];

                int next_parity= next_weight % 2;
                if(next_parity == curr_Parity) continue;

                long next_distance= curr_d+ next_weight;
                if(next_distance < distance[next_node][parity]){
                    distance[next_node][parity]= next_distance;
                    pq.add(new long[]{next_node, parity, next_distance});    
                }
            }
        }


        long ans= Math.min(distance[N][0], distance[N][1]);
        if(ans==Long.MAX_VALUE) out.print(-1);
        else out.print(ans);
        out.flush();
    }
    
}
