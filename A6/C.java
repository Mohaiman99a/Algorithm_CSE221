import java.io.*;
import java.util.*;

public class C {
    static int N;
    static boolean[][] visited;
    static int[][] distance;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        N=Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int x1= Integer.parseInt(st.nextToken());
        int y1= Integer.parseInt(st.nextToken());
        int x2= Integer.parseInt(st.nextToken());
        int y2= Integer.parseInt(st.nextToken());

        visited= new boolean[N+1][N+1];
        distance= new int[N+1][N+1];
        out.println(bfs(x1, y1, x2, y2));
        out.flush();
    }



    static int[] dx= {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy= {-1, 1, -2, 2, -2, 2, -1, 1 };
    static int bfs(int x1, int y1, int x2, int y2){
        if(x1 == x2 && y1 == y2) return 0;
        Queue<int[]> q= new LinkedList<>();

        q.add(new int[]{x1, y1});
        visited[x1][y1]=true;
        distance[x1][y1]=0;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int curr_x= curr[0];
            int curr_y= curr[1];

            if(curr_x==x2 && curr_y==y2) return distance[curr_x][curr_y];

            for(int i=0; i<8; i++){
                int nx= curr_x+dx[i];
                int ny=curr_y+dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=N){
                    if(!visited[nx][ny]){
                        q.add(new int[]{nx, ny});
                        visited[nx][ny]=true;
                        distance[nx][ny]= distance[curr_x][curr_y]+1;
                    }
                }
            }
        }
        return -1;
    }
    
}
