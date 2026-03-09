import java.io.*;

public class P2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String s=br.readLine();
            String[] st=s.split(" ");

            float a= Float.parseFloat(st[1]);
            String b= st[2];
            float c= Float.parseFloat(st[3]);

            if(b.equals("+")) out.printf("%.6f\n", a+c);
            else if(b.equals("-")) out.printf("%.6f\n", a-c);
            else if(b.equals("*")) out.printf("%.6f\n", a*c);
            else if(b.equals("/")) out.printf("%.6f\n", a/c);
        }
        out.flush();
    }
}
