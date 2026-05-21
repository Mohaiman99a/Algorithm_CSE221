// distance array -> Distance from S
// Priority Queue -> Own Distance sorted
// Parent array -> To print the path

//curr_node, next_node -> Integer type hobe, cuz they act as index

import java.util.*;
import java.io.*;

public class A{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int S= Integer.parseInt(st.nextToken());
        int D= Integer.parseInt(st.nextToken());

        int[] u= new int[ M ];
        int[] v= new int[ M ];
        int[] w= new int[ M ];
        ArrayList<int[]>[] arr= new ArrayList[N+1];
       for(int i=1; i<=N; i++) arr[i]= new ArrayList<>();
     
        StringTokenizer st_u= new StringTokenizer(br.readLine(), " ");
        StringTokenizer st_v= new StringTokenizer(br.readLine(), " ");
        StringTokenizer st_w= new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< M ; i++){
            u[i]= Integer.parseInt(st_u.nextToken());
            v[i]= Integer.parseInt(st_v.nextToken());
            w[i]= Integer.parseInt(st_w.nextToken());
        }

        //Fill them
        for(int i=0; i< M ; i++){
            arr[u[i]].add(new int[]{v[i], w[i]});
        }
        








    //Priority Queue: long[]{node, distance} 
        long[] distance= new long[N+1];
        int[] parent= new int[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(parent, -1);
        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{S, 0});
        distance[S]= 0;     
        parent[S]= -1;

        while(!pq.isEmpty()){
            long[] curr= pq.poll();
            int curr_node= (int) curr[0];
            long curr_distance= curr[1];
            if(curr_distance> distance[curr_node]) continue;            //Current node r aro short path ase ki?

            for(int i=0; i< arr[curr_node].size(); i++){
                int[] next= arr[curr_node].get(i);
                int next_node= next[0];
                int next_distance= next[1];
                long new_distance= curr_distance + next_distance;     //* */

                if(new_distance< distance[next_node]){
                    distance[next_node]= new_distance;
                    parent[next_node]= curr_node;
                    pq.add(new long[]{next_node, new_distance});
                }
            }
        }






    //output 1
        if(distance[D]== Long.MAX_VALUE){
            out.print("-1");
            out.flush();
            return;
        }
        out.println(distance[D]);


    //output 2
        ArrayList<Integer> path= new ArrayList<>();
        int curr= D;
        while(curr!= -1){
            path.add(curr);
            curr= parent[curr];
        }
        Collections.reverse(path);
        for(int i=0; i<path.size(); i++){
            out.print(path.get(i)+ " ");
        }
        out.flush();

    }

}
