import java.io.*;
public class Assignment1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int count=Integer.parseInt(br.readLine());

        for(int i=1; i<=count; i++){
            int N= Integer.parseInt(br.readLine());

            if(N%2==0){
                out.println(N + " is an Even number.");
            }

            else{
                out.println(N + " is an Odd number.");
            }
        }

        out.flush();
    }
}
