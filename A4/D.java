import java.util.*;
import java.io.*;

public class D{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        //Input 1
        StringTokenizer st1=new StringTokenizer(br.readLine(), " ");
        int n= Integer.parseInt(st1.nextToken());
        int m= Integer.parseInt(st1.nextToken());

        //Input 2 & 3
        StringTokenizer st2=new StringTokenizer(br.readLine(), " ");
        StringTokenizer st3=new StringTokenizer(br.readLine(), " ");
        int[] degree= new int[n+1];     //1 based (everything using degree array starts with 1)

        for(int i=0;  i<m; i++){
            int u =Integer.parseInt(st2.nextToken());
            int v=Integer.parseInt(st3.nextToken());

            degree[u]++;     //Out degree increase 
            degree[v]++;     //In degree increase
        }

    
        //Eurelian check 
        int odd=0;
        for(int i=1; i<=n; i++){
            if(degree[i]%2!=0) odd++;
        }

        if(odd==0 || odd==2) out.println("YES");
        else out.println("NO");
        out.flush();
    }
}
