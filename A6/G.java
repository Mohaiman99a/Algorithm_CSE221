import java.io.*;
import java.util.*;

public class G{
    static ArrayList<String>[] startWith= new ArrayList[26]; //26 letters in English

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(System.out);

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        String start = st.nextToken();
        String target= st.nextToken();

        for(int i=0; i<26; i++) startWith[i]= new ArrayList<>();

        //Fill array
        for(int i=0; i<n; i++){
            String node= br.readLine();
            char first= node.charAt(0);        //First character
            int indx= first- 'A';                    //Index starts with 0

            startWith[indx].add(node);
        }

        //bfs
        boolean possible= bfs(start,target);
        if(possible) out.print("YES");
        else out.print("NO");
        out.flush();
    }




    static boolean bfs(String start, String target){
        Queue<String> q= new LinkedList<>();
        HashSet<String> visited= new HashSet<>();

        q.add(start);
        visited.add(start);

        while(!q.isEmpty()){
            String curr= q.poll();
            if(curr.equals(target)) return true;

            char last=curr.charAt(curr.length()-1);
            int indx= last- 'A';
            ArrayList<String> storeList= startWith[indx];      //Last & First mila arraylist store

            for(int i=0; i<storeList.size(); i++){
                String next= storeList.get(i);
                if(!visited.contains(next)){
                    visited.add(next);
                    q.add(next);
                }
            }
            startWith[indx].clear();
        }
        return false;
    }
}
