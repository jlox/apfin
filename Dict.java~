import java.io.*;
import java.util.*;

public class Dict{

    ArrayList<Entry> entries = new ArrayList<Entry>();

   
    private String[] ent;
    /*
    public void load() {
	Scanner sc = new Scanner(new File("werdz.txt"));
    }
    */
    
    public void read(File file) throws IOException{
	Scanner scanner = new Scanner(file);

	while(scanner.hasNext()){
	    ent = scanner.nextLine().split(";;");
	}
    }

    public void makeDict(){
	Entry addit;
	int i = 0;
	String e, g, d;
	while (i < ent.length){
	    e = ent[i].substring(0, ent[i].indexOf("; "));
	    g = ent[i].substring(ent[i].indexOf("; "), ent[i].substring(ent[i].indexOf("; ")).indexOf("; "));
	    d = ent[i].substring(ent[i].substring(ent[i].indexOf("; ")).indexOf("; "), ent[i].length());
	    addit = new Entry(e,g,d);
	    entries.add(addit);	    
	    //entr.Entry(e, g, d);
	}
    }
    public String search(String deutsch) {
	return "deutsch";
    }


    public static void main(String[] args){
	Dict d = new Dict();
	d.read(werdz.txt);
	d.makeDict();
	// System.out.println(entries);
    }
}
