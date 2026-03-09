import java.util.*;
import java.io.*;

public class B{

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int n= Integer.parseInt(br.readLine());
        String s= br.readLine();
        StringTokenizer st=new StringTokenizer(s, " ");
        long[] arr=new long[n];

        //filling up the array
        for(int i=0; i<n; i++){
            arr[i]= Long.parseLong(st.nextToken());
        }

        long result= mergeSort(arr, 0, n-1);

        out.println(result);
        out.flush();
    }


    public static long mergeSort(long[] arr, int l, int r){
        if(l>=r) return 0;
        
        else{
            int mid=(l+r)/2;
            int count=0;

            count+= mergeSort(arr, l, mid);
            count+= mergeSort(arr, mid+1, r);

            count+= merge(arr, l, mid, r);  

            return count;
        }
    }



    public static long merge(long[] arr, int l, int mid, int r){
        if(l>=r) return 0;
        
        int n1=mid-l+ 1;  
        int n2= r-mid;
        int count=0;

        long[] arr1= new long[n1];
        long[] arr2= new long[n2];

        for(int i=0; i<n1; i++) arr1[i]= arr[l+ i];  
        for(int i=0; i<n2; i++) arr2[i]= arr[mid+1 + i];  



        //count part (Binary search)
        for(int j = 0; j < n2; j++){
        long target = (long)arr2[j] * arr2[j];
        int low = 0, high = n1;
        while(low < high){
            int mid_1 = (low + high) / 2;
            if(arr1[mid_1] > target) high = mid_1;
            else low = mid_1 + 1;
        }
        count += n1 - low;  // all elements from low to n1-1 satisfy arr1[i] > arr2[j]^2
        }


        //sort part
        int i=0, j=0, k=l;    
        while(i<n1 && j<n2){
            if(arr1[i]<= arr2[j]) arr[k++] = arr1[i++];    

            else{
                arr[k++] = arr2[j++];
            }
        }

        while(i<n1) arr[k++]=arr1[i++];
        while(j<n2) arr[k++]=arr2[j++];
        return count;
    }
    
}
