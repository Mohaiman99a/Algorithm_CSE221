import java.io.*;
import java.util.*;

public class B{
    static ArrayList<Integer>[] arr;
    static int[] color;
    static int[] bipartite;
    static int human;         //0
    static int robot;           //1

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);
        
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        
        arr= new ArrayList[N+1];
        for(int j=0; j<=N; j++) arr[j]= new ArrayList<>();     //* */

        color= new int[N+1];
        bipartite= new int[N+1];
        Arrays.fill(bipartite, -1);

        //Edges
        for(int k=0; k<M; k++){
            st= new StringTokenizer(br.readLine(), " ");
            int u= Integer.parseInt(st.nextToken());
            int v= Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }



        //dfs
        int ans=0;
        for(int i=1; i<=N; i++){
            if(bipartite[i]==-1){        //New node
                human=0;                //reset
                robot=0;
                dfs(i,0);
                ans+=Math.max(human, robot);
            }
        }

        out.println(ans);
        out.flush();
    }




    public static void dfs(int n, int g){
        color[n]= 1;
        bipartite[n]= g;
        if(g==0) human++;
        else robot++;

        for(int i=0; i<arr[n].size(); i++){
            int next=arr[n].get(i);
            if(bipartite[next]==-1){
                dfs(next, 1-g);
            }
        }

        color[n]=2;
    }
}
