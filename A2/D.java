import java.util.*;
import java.io.*;

public class D{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //input 1
        int n=Integer.parseInt(br.readLine());
        String s1=br.readLine();
        StringTokenizer st1=new StringTokenizer(s1, " ");
        long[] arr1=new long[n];

        for(int i=0; i<n; i++){
            arr1[i]=Long.parseLong(st1.nextToken());
        }
        
        //input 2
        int m=Integer.parseInt(br.readLine());
        String s2=br.readLine();
        StringTokenizer st2=new StringTokenizer(s2, " ");
        long[] arr2=new long[m];

        for(int i=0; i<m; i++){
            arr2[i]=Long.parseLong(st2.nextToken());
        }



        //Printing sequentially. No need for another array
        int p1=0;
        int p2=0;
        while(p1<n && p2<m){
            if(arr1[p1]<=arr2[p2]){        //Equal to maintain stability
                out.print(arr1[p1]+ " ");
                p1++;
            }

            else if(arr1[p1]>arr2[p2]){
                out.print(arr2[p2]+ " ");
                p2++;
            }
        }


        //Remaining
        while(p1<n) out.print(arr1[p1++]+ " ");
        while(p2<m) out.print(arr2[p2++]+ " ");

        out.flush();
    }
}
