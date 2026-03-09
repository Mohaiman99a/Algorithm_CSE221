import java.util.*;
import java.io.*;

public class F {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        //input 
        StringTokenizer n_st=new StringTokenizer(br.readLine(), " ");
        int n=Integer.parseInt(n_st.nextToken());
        int k= Integer.parseInt(n_st.nextToken());
        String s1=br.readLine();
        StringTokenizer st1=new StringTokenizer(s1, " ");
        int[] arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st1.nextToken());
        }


        //Finding the longest subarray
        int l=0;
        int maxLength=0;
        int distinct=0;
        HashMap<Integer, Integer> map=new HashMap<>();

        for(int r=0; r<n; r++){
            map.put(arr[r], map.getOrDefault(arr[r],0) + 1);
            if(map.get(arr[r])==1) distinct++;     //Notun add

            while(distinct>k && l<=r){
                map.put(arr[l], map.getOrDefault(arr[left],0) -1);   
                if(map.get(arr[l])==0) distinct--;
                l++;
            }

            maxLength= Math.max(maxLength, (right-left+1));    //Don't forget 
        }

        
        out.println(maxLength);
        out.flush();
    }
}

