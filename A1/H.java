import java.util.*;
import java.io.*;


public class A8 {
    //Train class
    public static class Train{
        String name;
        int time;
        int indx;
        String line;

        Train(String name, int time, int indx, String line){
            this.name=name;
            this.time=time;
            this.indx=indx;
            this.line=line;
        }
    }


    //main method
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int c=Integer.parseInt(br.readLine());
        ArrayList<Train> train_list= new ArrayList<>();


        //Fill arraylist
        for(int i=0; i<c; i++){
            String line= br.readLine();
            StringTokenizer st=new StringTokenizer(line, " ");

            //First token == Name
            String name=st.nextToken();

            //Last token==time
            String time_string="";
            while(st.hasMoreTokens()){
                time_string=st.nextToken();
            }
            int time=convt_time(time_string);

            train_list.add(new Train(name, time, i, line));
        }



        //Collection.sort(-1 -> No change && 1 -> sort)
        Collections.sort(train_list, new Comparator<Train>(){
            public int compare(Train t1, Train t2){
                //name
                int comp_name=comp_Name(t1.name,t2.name);
                if(comp_name<0) return -1;
                if(comp_name>0) return 1;           //Do not use else

                //time(age boro)
                if(t1.time>t2.time) return -1;
                if(t1.time<t2.time) return 1;           //Careful with 1 and -1

                //index (Age choto)
                if(t1.indx<t2.indx) return -1;
                if(t1.indx>t2.indx) return 1;

                return 0;          
            }
        });




        //print
        for(int i=0; i<train_list.size(); i++){
            out.println(train_list.get(i).line);
        }
        out.flush();
    }

   //time_string -> time_int
    public static int convt_time(String time_string){
        String[] p=time_string.split(":");
        int hour=Integer.parseInt(p[0]);
        int min=Integer.parseInt(p[1]);

        return 60*hour + min;
    }




   //helper compare name
    public static int comp_Name(String t1, String t2){
        int n=Math.min(t1.length(), t2.length());
        for(int i=0; i<n; i++){
            char c1=t1.charAt(i);
            char c2=t2.charAt(i);

	//Case 1: Same letter
            if(c1==c2) continue;

	//Case 2: Different letter
            boolean low1=Character.isLowerCase(c1);
            boolean low2=Character.isLowerCase(c2);


            if(low1 && low2){
                if(c1<c2) return -1;
                else return 1;
            }

            if(!low1 && !low2){
                if(c1<c2) return -1;
                else return 1;
            }

            if(low1) return -1;
            if(low2) return 1;
        }

        //Case 3: One of them is longer 
        if(t1.length()<t2.length()) return -1;
        if(t1.length()>t2.length()) return 1;

        return 0;
    }






}
