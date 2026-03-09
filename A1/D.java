import java.io.*;

public class A4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int t=Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int len=Integer.parseInt(br.readLine());
            String[] s=br.readLine().split(" ");
            boolean boo=true;


            for(int j=0; j<len-1; j++){
                int curr=Integer.parseInt(s[j]);
                int next= Integer.parseInt(s[j+1]);     //Next diye len-1 korle bhalo
                if(curr>next){
                    boo=false;
                    break;
                }
            }


            if(boo==true){
                out.println("YES");
            }
            else{
                out.println("NO");
            }
        }
        out.flush();
    }
}

