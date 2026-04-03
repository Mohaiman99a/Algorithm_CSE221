import java.util.*;
import java.io.*;

public class E{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st1=new StringTokenizer(br.readLine(), " ");
        int n= Integer.parseInt(st1.nextToken());
        int m= Integer.parseInt(st1.nextToken());

        int[] outdegree=new int[n+1];    //1 based
        int[] indegree= new int[n+1];
        int[] diff= new int[n+1];

        StringTokenizer st2= new StringTokenizer(br.readLine(), " ");
        StringTokenizer st3= new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< m ; i++){
            int u= Integer.parseInt(st2.nextToken());
            int v= Integer.parseInt(st3.nextToken());
            
            outdegree[u]++;
            indegree[v]++;
        }


        //Print difference
        for(int i=1; i<=n; i++){
            diff[i]= indegree[i]- outdegree[i];
            out.print(diff[i]);
            if(i<n) out.print(" ");
        }

        out.flush();
    }
}
