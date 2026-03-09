import java.util.*;
import java.io.*;


public class A7 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);


        int t=Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            //Filling
            int n= Integer.parseInt(br.readLine());
            String s_id= br.readLine();
            StringTokenizer st_id= new StringTokenizer(s_id, " ");
            int[] arr_id=new int[n];    


            String s_marks= br.readLine();
            StringTokenizer st_marks= new StringTokenizer(s_marks, " ");
            int[] arr_marks=new int[n];


            for(int j=0; j<n; j++){
                arr_id[j]=Integer.parseInt(st_id.nextToken());
                arr_marks[j]=Integer.parseInt(st_marks.nextToken());
            }

            //Arranging
            int min_swp=selection_sort(arr_id,arr_marks);    //Selection sort= min swap 


            //print
            out.println("Minimum swaps: " + min_swp);
            for(int k=0; k<n; k++){
                out.println("ID: "+ arr_id[k]+ " Mark: "+ arr_marks[k]);
            }
        }

        out.flush();
    }




//Selection sort
    public static int selection_sort(int[] arr_id, int[] arr_marks){
        int min_swp=0;


        for(int i=0; i<arr_id.length; i++){
            int max_indx= i;
            for(int j=i+1; j<arr_id.length; j++){
                if((arr_marks[max_indx]< arr_marks[j])||
                (arr_marks[max_indx]== arr_marks[j] && arr_id[max_indx]> arr_id[j])){
                    max_indx=j;
                }
            }



            if(max_indx!=i){
                int temp_id= arr_id[i];
                arr_id[i]=arr_id[max_indx];
                arr_id[max_indx]= temp_id;


                int temp_marks= arr_marks[i];
                arr_marks[i]=arr_marks[max_indx];
                arr_marks[max_indx]= temp_marks;


                min_swp++;
            }
        }
        return min_swp;
    }
}
