import java.io.*;
import java.util.*;

public class A{
    static ArrayList<Integer>[] arr;
    static int[] color;
    static boolean cycle;
    static Stack<Integer> stack;        //Print korar jonno

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int t= Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            StringTokenizer st= new StringTokenizer(br.readLine(), " ");
            int N= Integer.parseInt(st.nextToken());
            int M= Integer.parseInt(st.nextToken());

            arr= new ArrayList[N+1];
            color= new int[N+1];
            cycle=false;                   //Careful for lab quiz
            stack= new Stack<>();

            for(int j=0; j<=N; j++) arr[   j    ]= new ArrayList<>();    


            //Edges
            for(int k=0; k<M; k++){
                st= new StringTokenizer(br.readLine(), " ");
                int a= Integer.parseInt(st.nextToken());
                int b= Integer.parseInt(st.nextToken());

                arr[a].add(b);
            }


            //dfs
            for(int p=1; p<=N; p++){
                if(color[p]==0){
                    dfs(p);
                }
            }


            //Print
            if(cycle==true) out.println(-1);
            else{
                while(!stack.isEmpty()) out.print(stack.pop()+ " ");
                out.println();
            }
        }
        out.flush();
    }




    public static void dfs(int n){
        color[n]=1;

        for(int i=0; i<arr[n].size(); i++){
            int next=arr[n].get(i);
            if(color[next]==0){
                dfs(next);
            }
            else if(color[next]==1){
                cycle=true;
                return;
            }
        }

        color[n]=2;
        stack.push(n);     //ending e add korbo
    }
}
