import java.io.*;
import java.util.*;

public class E {
    static ArrayList<Integer>[] arr;
    static int[] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int S= Integer.parseInt(st.nextToken());
        int Q= Integer.parseInt(st.nextToken());

        arr= new ArrayList[N+1];
        distance= new int[N+1];
        Arrays.fill(distance, -1);
        for(int i=0; i<=N; i++) arr[i]= new ArrayList<>();

        for(int i=0; i<M; i++){
            st= new StringTokenizer(br.readLine(), " ");
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }



        //source
        int[] source= new int[S];       //Not S+1
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<S; i++){
            source[i]= Integer.parseInt(st.nextToken());
        }


        //bfs
        bfs(source);



        //queries
        st= new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();

        for(int i=0; i<Q; i++){
            int destination= Integer.parseInt(st.nextToken());
            sb.append(distance[destination]).append(" ");
        }
        out.println(sb.toString());
        out.flush();
    }






    static void bfs(int[] source){      
        Queue<Integer> q= new LinkedList<>();

        //push all sources
        for(int i=0; i< source.length; i++){       
            int s= source[i];
            if(distance[s]==-1){
                distance[s]=0;
                q.add(s);
            }
        }


        //normal BFS
        while(!q.isEmpty()){
            int curr= q.poll();
            for(int i=0; i<arr[curr].size(); i++){
                int next= arr[curr].get(i);
                if(distance[next]==-1){
                    distance[next]= distance[curr]+1;
                    q.add(next);
                }
            }
        }
    }
}
