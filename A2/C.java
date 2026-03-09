import java.util.*;
import java.io.*;

public class C {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //Input line 1
        String s_n=br.readLine();
        StringTokenizer st_n= new StringTokenizer(s_n, " ");
        int n= Integer.parseInt(st_n.nextToken());
        long sum= Long.parseLong(st_n.nextToken());

        //Input line 2
        String s=br.readLine();
        StringTokenizer st= new StringTokenizer(s, " ");
        long[] arr=new long[n];
        for(int i=0; i<n; i++){
            arr[i]= Long.parseLong(st.nextToken());
        }


        //Location
        HashMap<Long, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], i);   //value, index
        }
        
        //Finding possible sum
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                long more= sum-arr[i]-arr[j];

                if(map.containsKey(more)){
                    int k=map.get(more);
                    
                    if(k!=i && k!=j){
                    out.println((i+1)+ " "+ (j+1)+ " "+ (k+1));
                    out.flush();    //Before return. Has multiple solutions
                    return;        //break would only end the inner loop. Make sure no repeat
                    }
                }
            }
        }
        out.print("-1");
        out.flush();
    }
}
