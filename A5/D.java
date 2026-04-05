import java.io.*;
import java.util.*;

public class D {
    static boolean[] visited;
    static int[] parent;
    static int[] distance;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st1= new StringTokenizer(br.readLine(), " ");
        int nodes= Integer.parseInt(st1.nextToken());
        int edges= Integer.parseInt(st1.nextToken());
        int s= Integer.parseInt(st1.nextToken());
        int d= Integer.parseInt(st1.nextToken());
        int k= Integer.parseInt(st1.nextToken());    //Mandatory node

        //Make arrayList before making the graph
        ArrayList<Integer>[] graph = new ArrayList[nodes+1];
        for(int i=1; i<= nodes; i++){
            graph[i]= new ArrayList<>();
        }


        //making the graph
         for(int i=0; i<edges; i++){
            StringTokenizer st2= new StringTokenizer(br.readLine(), " ");
            int u= Integer.parseInt(st2.nextToken());
            int v= Integer.parseInt(st2.nextToken());

            graph[u].add(v);    //Directed
        }
        


        //-----BFS 1: s to k--------
        ArrayList<Integer> path1= bfs(graph, s, k, nodes);
        if(path1.size()==1 && path1.get(0)== -1){      //path1.size()==1 means one node only
                                                              //path1.get(0)== -1 means unreaceable
            out.println(-1);
            out.flush();
            return;
        }

        int distance1= distance[k];

        //-----BFS 2: k to d--------
        ArrayList<Integer> path2= bfs(graph, k, d, nodes);
        if(path2.size()==1 && path2.get(0)== -1){
            out.println(-1);
            out.flush();
            return;
        }

        int distance2= distance[d];


        //Output 1: Distance
        out.println(distance1 + distance2); 

        //Output 2: Path
        ArrayList<Integer> finalPath= new ArrayList<>();
        for(int i=0; i<path1.size(); i++){
            finalPath.add(path1.get(i));
        }
        for(int i=1; i<path2.size(); i++){
            finalPath.add(path2.get(i));   //skip extra k
        }

        for(int i=0; i<finalPath.size(); i++){
            out.print(finalPath.get(i));
            if(i+1<finalPath.size()) out.print(" ");
        }
        out.flush();
    }




    public static ArrayList<Integer> bfs(ArrayList<Integer>[] graph, int s, int d, int nodes){
        visited= new boolean[nodes+1];
        parent= new int[nodes+1];
        distance= new int[nodes+1];

        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited[s]= true;
        distance[s]=0;
        parent[s]=0;

        while(!q.isEmpty()){
            int curr= q.poll();
            for(int neighbor: graph[curr]){
                if(!visited[neighbor]){
                q.add(neighbor);
                visited[neighbor]= true;
                distance[neighbor]=distance[curr]+1;
                parent[neighbor]= curr;
                }
            }
        }


        //Backtrack
        ArrayList<Integer> path= new ArrayList<>();
        if(!visited[d]){
            path.add(-1);
            return path;
        }
        int curr= d;

        while(curr!=0){      //stops when parent becomes 0
            path.add(curr);
            curr= parent[curr];
        }

        //reverse the path
        Collections.reverse(path);
        return path;
    }
}
