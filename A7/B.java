import java.io.*;
import java.util.*;

public class B{
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
        }





        //Dijkstra from S
        long[] distance_S= new long[N+1];
        Arrays.fill(distance_S, Long.MAX_VALUE);

        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{S, 0});
        distance_S[S]= 0;

        while(!pq.isEmpty()){
            long[] curr= pq.poll();           
            int node=(int) curr[0];
            long d= curr[1];
            if(d> distance_S[node]) continue;

            for(int i=0; i<arr[node].size(); i++){
                int[] next= arr[node].get(i);      
                int next_node= next[0];
                int next_weight= next[1];
                long next_distance= d + next_weight;

                if(next_distance < distance_S[next_node]){
                    distance_S[next_node]= next_distance;
                    pq.add(new long[]{next_node, next_distance});     
                }
            }
        }




        //Dijkstra from T
        long[] distance_T= new long[N+1];
        Arrays.fill(distance_T, Long.MAX_VALUE);

        pq= new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{T, 0});
        distance_T[T]= 0;

        while(!pq.isEmpty()){
            long[] curr= pq.poll();            //long
            int node=(int) curr[0];
            long d= curr[1];
            if(d> distance_T[node]) continue;

            for(int i=0; i<arr[node].size(); i++){
                int[] next= arr[node].get(i);        //int
                int next_node= next[0];
                int next_weight= next[1];
                long next_distance= d + next_weight;

                if(next_distance < distance_T[next_node]){
                    distance_T[next_node]= next_distance;
                    pq.add(new long[]{next_node, next_distance});     
                }
            }
        }






 //for loop -> shob node r moddhe kontay meet korbe
//if -> specific node e pouchay naki
// Update -> Case 1: distance small 
           Case 2: distance equal, i small
// distance update hoyni -> print (-1)

        long distance= Long.MAX_VALUE;
        int node= -1;
        
        for(int i=1; i<=N; i++){        
            if(distance_S[i]== Long.MAX_VALUE || distance_T[i]==Long.MAX_VALUE) continue;
            long currr_distance= Math.max(distance_S[i], distance_T[i]);
            if(currr_distance<distance){
               distance= currr_distance;
                node= i;
            }
            else if(currr_distance==distance && i<node) node=i;
        }
        if(distance==Long.MAX_VALUE) out.print(-1);
        else out.println(distance+ " "+ node);
        out.flush();
    }
    
}
