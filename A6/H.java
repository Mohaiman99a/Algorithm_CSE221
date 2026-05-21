import java.util.*;
import java.io.*;

public class H {
    static ArrayList<Integer>[] arr= new ArrayList[26];
    static int[] indegree= new int[26];
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        int N= Integer.parseInt(br.readLine());
        for(int i=0; i<26; i++) arr[i]= new ArrayList<>();     //* */

        String[] words= new String[N];
        boolean[] used= new boolean[26];
        for(int i=0; i<N; i++){
            words[i]= br.readLine();         //* */
            for(int j=0; j<words[i].length(); j++) used[words[i].charAt(j)- 'a']=true;
        } 

        
        //Make the graph
        for(int i=0; i<N-1; i++){
            String a= words[i];
            String b= words[i+1];
            int length= Math.min(a.length(), b.length());
            boolean foundDiff= false;

            for(int j=0; j<length; j++){
                if(a.charAt(j)!= b.charAt(j)){
                    int u=a.charAt(j)- 'a';       //a ke 0 niye numbering shuru
                    int v=b.charAt(j)- 'a';

                    arr[u].add(v);
                    indegree[v]++;
                    foundDiff=true;
                    break;
                }
            }

            if(!foundDiff && a.length()> b.length()){     //same hole age choto ta howar kotha
                out.println(-1);
                out.flush();
                return;
            }
        }




        //Arranging
        PriorityQueue<Integer> q= new PriorityQueue<>();  //Choto gula pop kore
        StringBuilder sb= new StringBuilder();
        for(int i=0; i<26; i++){
            if(used[i] && indegree[i]==0){
                q.add(i);      //free ones
            }
        }

        while(!q.isEmpty()){
            int curr= q.poll();
            sb.append((char)(curr+'a'));

            for(int i=0; i<arr[curr].size(); i++){
                int next= arr[curr].get(i);
                indegree[next]--;
                if(indegree[next]==0) q.add(next);     //Age kichu nai ar. So can add
            }
        }


        //Cycle check
        for(int i=0; i<26; i++){
            if(used[i] && indegree[i]>0){
                out.println(-1);
                out.flush();
                return;
            }
        }


        out.println(sb.toString());
        out.flush();
    }
}

