import java.util.*;
import java.io.*;

public class A{
    static long inversion=0;    

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int n= Integer.parseInt(br.readLine());
        String s= br.readLine();
        StringTokenizer st=new StringTokenizer(s, " ");
        int[] arr=new int[n];

        //filling up the array
        for(int i=0; i<n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, n-1);

        out.println(inversion);
        for(int i=0; i<n; i++){
            out.print(arr[i] + " ");
        }
        out.println();
        out.flush();
    }


    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid=(l+r)/2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);

            merge(arr, l, mid, r); 
        }
    }
        


    public static void merge(int[] arr, int l, int mid, int r){
        int n1=mid-l+ 1; 
        int n2= r-mid;

        int[] arr1= new int[n1];
        int[] arr2= new int[n2];

        for(int i=0; i<n1; i++) arr1[i]= arr[l+ i ];   //* */
        for(int i=0; i<n2; i++) arr2[i]= arr[mid+1 + i];   

        int i=0, j=0, k=l;

        while(i<n1 && j<n2){
            if(arr1[i]< arr2[j]) arr[k++] = arr1[i++]; 

            else if(arr2[j]< arr1[i]){
                arr[k++] = arr2[j++];
                inversion+=(n1-i);        //Inversion r jonno merge sort bhalo
            }
        }

        while(i<n1) arr[k++]=arr1[i++];
        while(j<n2) arr[k++]=arr2[j++];
    }
    
}


//Inversion hocche koyta value of L, oi R r value r age boshar kotha chilo

