import java.util.*;
import java.io.*;

public class E{

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int t=Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            String s= br.readLine();
            StringTokenizer st=new StringTokenizer(s, " ");
            long a=Long.parseLong(st.nextToken());
            long n=Long.parseLong(st.nextToken());
            long m=Long.parseLong(st.nextToken());

            
            //Series sum
            if(a==1) out.println(n%m);
            else{
                long[] ans=geometricSum(a,n,m);
                out.println(ans[1]);
            }        
        }  
        out.flush();
    }


    static long[] geometricSum(long a, long n, long m) {
        if (n == 1) return new long[] {a % m, a%m};

        if (n % 2 == 0) {
            long[] half = geometricSum(a, n/2, m);

            long pow_half = half[0];     //a^n % m
            long sum_half = half[1];     //S(n) % m    where S(n) = a + a² + ... + aⁿ

            long fullPow = (pow_half * pow_half) % m;   //half power multiply korle full power ashe
            long fullSum = (sum_half + (pow_half * sum_half) % m) % m;

            return new long[]{fullPow, fullSum};

        } else {
            long[] prev = geometricSum(a, n - 1, m);

            long pow = (prev[0] * a) % m;
            long sum = (prev[1] + pow) % m;

            return new long[]{pow, sum};
        }
    }



    static long power(long a, long b, long mod){
        long result=1;
        a=a%mod;

        while(b>0){           
            if((b&1)==1){
                result = (result * a)% mod;
            }
            a=(a*a)%mod;
            b>>=1;
        }

        return result;
    }
}
