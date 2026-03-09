import java.util.*;
import java.io.*;

public class D{

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);
       StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            //Fill the array
            String s= br.readLine();
            StringTokenizer st=new StringTokenizer(s, " ");
            long[][] arr=new long[2][2];

            arr[0][0]=Long.parseLong(st.nextToken());
            arr[0][1]=Long.parseLong(st.nextToken());
            arr[1][0]=Long.parseLong(st.nextToken());
            arr[1][1]=Long.parseLong(st.nextToken());
            

            //take the power
            long power=Long.parseLong(br.readLine());
            long[][] result= modularPower(arr, power);


            //print
           sb.append(result[0][0]).append(" ").append(result[0][1]).append("\n");
            sb.append(result[1][0]).append(" ").append(result[1][1]).append("\n");
        }
        out.print(sb.toString());
        out.flush();




    static long[][] modularPower(long[][] arr, long power){   
        long[][] result={{1,0}, {0,1}};                     //identity matrix
        long[][] a=arr;

        while(power>0){           
            if(power%2==1){
                result = multiply(result, a);
            }
            a=multiply(a,a);
            power=power/2;
        }

        return result;
    }



    static long MOD= 1000000007;
    static long[][] multiply(long[][] A, long[][] B){

        long a00= (A[0][0] * B[0][0] % MOD + A[0][1] * B[1][0] % MOD) % MOD;
        long a01 = (A[0][0] * B[0][1] % MOD + A[0][1] * B[1][1] % MOD) % MOD;
        long a10 = (A[1][0] * B[0][0] % MOD + A[1][1] * B[1][0] % MOD) % MOD;
        long a11 = (A[1][0] * B[0][1] % MOD + A[1][1] * B[1][1] % MOD) % MOD;
        
        A[0][0]= a00;
        A[0][1]= a01;
        A[1][0]= a10;
        A[1][1]= a11;

        return A;
    }
}
