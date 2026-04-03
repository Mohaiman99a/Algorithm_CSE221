import java.util.*;
import java.io.*;

public class F{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st1=new StringTokenizer(br.readLine(), " ");
        int n= Integer.parseInt(st1.nextToken());
        
        StringTokenizer st2=new StringTokenizer(br.readLine(), " ");
        int a= Integer.parseInt(st2.nextToken());
        int b= Integer.parseInt(st2.nextToken());
        ArrayList<int[]> moves= new ArrayList<>();

        for(int i=a-1; i<=a+1; i++){
            for(int j=b-1; j<=b+1; j++){

                if(i==a && j==b) continue;

                else if(i>=1 && i<=n && j>=1 && j<=n){
                    moves.add(new int[]{i,j});
                }

            }
        }

        out.println(moves.size());
        for(int i=0; i<moves.size(); i++){
            out.println(moves.get(i)[0]+ " "+ moves.get(i)[1]);
        }
        out.flush();
    }
}
