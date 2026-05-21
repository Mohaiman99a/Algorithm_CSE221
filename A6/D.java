import java.io.*;
import java.util.*;

public class D {
    static ArrayList<Integer>[] arr;
    static int N;
    static int farNode;
    static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        N = Integer.parseInt(br.readLine());
        arr= new ArrayList[N+1];
        for(int i=0; i<=N; i++) arr[i]= new ArrayList<>();

        for(int i=0; i<N-1; i++){
            StringTokenizer st= new StringTokenizer (br.readLine());
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }


        //bfs 1
        bfs(1);
        int A= farNode; 

        //bfs 2
        bfs(A);
        int B= farNode;


        out.println(max);
        out.println(A+" "+ B);
        out.flush();
    }





    static void bfs(int s){
        Queue<Integer> q= new LinkedList<>();
        boolean[] visited= new boolean[N+1];
        int[] distance= new int[N+1];

        farNode= s;
        max=0;

        q.add(s);
        visited[s]= true;
        distance[s]= 0;

        while(!q.isEmpty()){
            int curr= q.poll();
            for(int i=0; i<arr[curr].size(); i++){
                int next= arr[curr].get(i);
                if(!visited[next]){
                    q.add(next);
                    visited[next]=true;
                    distance[next]= distance[curr]+1;

                    if(distance[next]>max){
                        max=distance[next];
                        farNode= next;
                    }
                }
            }
        }
    }
}

