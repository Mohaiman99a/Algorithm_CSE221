//arr -> Doesn’t have a array inside(no weight)
// PriorityQueue-> has array inside(includes weight)

import java.io.*;
import java.util.*;

public class C{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int S= Integer.parseInt(st.nextToken());
        int T= Integer.parseInt(st.nextToken());

        int[] u= new int[M];
        int[] v= new int[M];
        int[] w= new int[N+1];       //Node r weight, not edge r  

        st= new StringTokenizer(br.readLine(), " ");
        for(int i=1; i<=N; i++){
            w[i]= Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine(), " ");
            u[i]= Integer.parseInt(st.nextToken());
            v[i]= Integer.parseInt(st.nextToken());
        }


        ArrayList<Integer>[] arr= new ArrayList[N+1];
        for(int i=1; i<=N; i++) arr[i]= new ArrayList<>();
        for(int i=0; i<M; i++){
            arr[u[i]].add(v[i]);       
        }





     //Dijkstra
        long[] distance= new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{S, w[S]});      
        distance[S]= w[S];

        while(!pq.isEmpty()){
            long[] curr= pq.poll();          
            int curr_node=(int) curr[0];
            long curr_d= curr[1];
            if(curr_d> distance[curr_node]) continue;

            for(int i=0; i<arr[curr_node].size(); i++){
                int next = arr[curr_node].get(i);               
                long next_distance= curr_d + w[next];

                if(next_distance < distance[next]){
                    distance[next]= next_distance;
                    pq.add(new long[]{next, next_distance});     //distance, not individual weight
                }
            }
        }



        if(distance[T]==Long.MAX_VALUE) out.print(-1 + " ");
        else out.print(distance[T]+ " ");
       
        out.flush();
    }
    
}
