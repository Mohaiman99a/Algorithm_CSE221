import java.io.*;
import java.util.*;

public class F {
    static boolean[] visited= new boolean[10000];
    static boolean[] forbidden= new boolean[10000];
    static int[] distance= new int[10000];

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        String start= st.nextToken();
        String end= st.nextToken();

        //Input 2
        st= new StringTokenizer(br.readLine(), " ");
        int f_length= Integer.parseInt(st.nextToken());
  
        //Input 3
        for(int i=0; i<f_length; i++){
            st= new StringTokenizer(br.readLine(), " ");
            int f= Integer.parseInt(st.nextToken());
            forbidden[f]= true;
        }

        out.println(bfs(start, end));
        out.flush();
    }



    static int bfs(String start, String end){
        Queue<String> q= new LinkedList<>();

        q.add(start);
        visited[Integer.parseInt(start)]= true;
        distance[Integer.parseInt(start)]= 0;

        while(!q.isEmpty()){
            String curr= q.poll();
            if(curr.equals(end)) return distance[Integer.parseInt(curr)];

            for(int i=0; i<4; i++){
                String next1= move(curr, i, "increase");                       
                if(!visited[Integer.parseInt(next1)] && !forbidden[Integer.parseInt(next1)]){
                    q.add(next1);
                    visited[Integer.parseInt(next1)]= true;
                    distance[Integer.parseInt(next1)]= distance[Integer.parseInt(curr)]+1;
                }

                String next2= move(curr, i, "decrease");
                if(!visited[Integer.parseInt(next2)] && !forbidden[Integer.parseInt(next2)]){
                    q.add(next2);
                    visited[Integer.parseInt(next2)]= true;
                    distance[Integer.parseInt(next2)]= distance[Integer.parseInt(curr)]+1;
                }
            }
        }
        return -1;
    }





    public static String move(String curr, int i, String s){          //i refers to MSB to LSB
        char[] arr= curr.toCharArray();

        if(s.equals("increase") && arr[i]=='9'){
            arr[i]= '0';
        }
        else if(s.equals("increase")){
            arr[i]++;
        }
        else if(s.equals("decrease") && arr[i]=='0'){
            arr[i]= '9';
        }
        else if(s.equals("decrease")){
            arr[i]--;
        }
        return new String(arr);
    }
}
