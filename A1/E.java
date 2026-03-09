import java.io.*;
import java.util.ArrayList;

public class A5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        //Filling up the array
        int n=Integer.parseInt(br.readLine());
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s, " ");    //*  */

        int[] arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }


        //Initializing things to print
        boolean srt_possible=true;
        int moves=0;
        ArrayList<int[]> moves_indx=new ArrayList<>();


        //Arranging subarray
        for(int i=1; i<n-1; i++){
            for(int j=1;j<n-1;j++){
                if(arr[j-1]>arr[j+1]){
                int temp= arr[j+1];
                arr[j+1]=arr[j-1];
                arr[j-1]=temp;

                moves_indx.add(new int[]{j, j+2});    //* */
                moves++;
                }
            }

        }


        //Check if possible
        for(int i=0; i<n-1; i++){     
            if(arr[i]>arr[i+1]){
                srt_possible=false;
                break;
            }
        }


        //print
        if(srt_possible==false){
            out.println("NO");
        }
        else{
            out.println("YES");
            out.println(moves);
            for(int i=0; i<moves; i++){
                int[] op= moves_indx.get(i);
                out.println(op[0]+ " " + op[1]);      
            }
        }
        out.flush();
    }
}
