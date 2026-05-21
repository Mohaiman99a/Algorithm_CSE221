import java.io.*;
import java.util.*;

public class F{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int S= Integer.parseInt(st.nextToken());
        int D= Integer.parseInt(st.nextToken());

        int[] u= new int[M];
        int[] v= new int[M];
        int[] w= new int[M];       

        
        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine(), " ");
            u[i]= Integer.parseInt(st.nextToken());
            v[i]= Integer.parseInt(st.nextToken());
            w[i]= Integer.parseInt(st.nextToken());
        }

        ArrayList<int[]>[] arr= new ArrayList[N+1];
        for(int i=1; i<=N; i++) arr[i]= new ArrayList<>();
        for(int i=0; i<M; i++){
            arr[u[i]].add(new int[]{v[i], w[i]});
            arr[v[i]].add(new int[]{u[i], w[i]});     
        }





       //Dijkstra
        long[][] distance= new long[N+1][2];               //[node][0]= shortest, [1]=second shortest
        for(int i=1; i<=N; i++) Arrays.fill(distance[i], Long.MAX_VALUE);

       //a= {node, distance}
        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{S, 0});   
        distance[S][0]= 0;


        while(!pq.isEmpty()){
            long[] curr= pq.poll();            
            int node=(int) curr[0];
            long d= curr[1];
            //No check on this one

            for(int i=0; i<arr[node].size(); i++){
                int[] next = arr[node].get(i);        
                int next_node= next[0];
                int next_weight= next[1];
                long next_distance= d+ next_weight;

                if(next_distance < distance[next_node][0]){
                    distance[next_node][1]= distance[next_node][0];
                    distance[next_node][0]= next_distance;
                    pq.add(new long[]{next_node, next_distance});     
                }

                else if(next_distance> distance[next_node][0] && next_distance< distance[next_node][1]){
                    distance[next_node][1]= next_distance;
                    pq.add(new long[]{next_node, next_distance});
                }
            }
        }


        if(distance[D][1]==Long.MAX_VALUE) out.print(-1);
        else out.print(distance[D][1]);
        out.flush();
    }
    
}

