import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] arr= new ArrayList[N+1];
        for(int i=0; i<=N; i++) arr[i]= new ArrayList<>();
        
        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine(), " ");
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());
            int w= Integer.parseInt(st.nextToken());
            arr[u].add(new int[]{v, w});
            arr[v].add(new int[]{u, w});
        }


        long[] distance= new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);
        PriorityQueue<long[]> pq= new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
        pq.add(new long[]{1, 0});
        distance[1]=0;

        while(!pq.isEmpty()){
            long[] curr= pq.poll();
            int curr_node= (int) curr[0];
            long curr_distance= curr[1];
            if(curr_distance > distance[curr_node]) continue;

            for(int i=0; i < arr[curr_node].size(); i++){
                int[] next= arr[curr_node].get(i);
                int next_node= (int) next[0];
                long worst_distance= Math.max(next[1], curr_distance);
                if(worst_distance<distance[next_node]){
                    distance[next_node]= worst_distance;
                    pq.add(new long[]{next_node, worst_distance});
                }
            }
        }



        for(int i=1; i<=N; i++){
            if(distance[i]==Long.MAX_VALUE) out.print(-1+ " ");
            else out.print(distance[i]+ " ");
        }
        out.flush();

    }
}

