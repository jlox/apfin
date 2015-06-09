import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Dict{

    ArrayList<Entry> entries = new ArrayList<Entry>();
    // what each entry is stored at - IN ENTRY FORM
    String e, g, d;
    
    
    File file = new File("werdz.txt");
    Scanner sc;

    public Dict() throws FileNotFoundException{
	sc = new Scanner(file);
    }
    
    int c = 0;

    public int fileLength(){
	while(sc.hasNextLine()){
	    c = c + 1;
	    sc.nextLine();
	}
	return c;
    }

    String ent[] = new String[fileLength()];
    // each entry is a line in werdz
    
    public void read() throws IOException{
	String s;
	int i = 0;
	if (ent.length != 0){
	    while(sc.hasNextLine()){
		s = sc.nextLine();
		ent[i] = s;
		i = i + 1;
	    }
	}
    }
    
    public void makeDict(){
	Entry addit;
	int i = 0;
	//String e, g, d;
	while (i < ent.length - 1){
	    e = ent[i].substring(0, ent[i].indexOf("; "));
	    g = ent[i].substring(ent[i].indexOf("; "), (ent[i].substring(ent[i].indexOf("; "))).indexOf("; ") + ent[i].indexOf("; "));
	    d = ent[i].substring((ent[i].substring(ent[i].indexOf("; "))).indexOf("; ") + ent[i].indexOf("; "), ent[i].length());
	    addit = new Entry(e,g,d);
	    entries.add(addit);	    
	    //entr.Entry(e, g, d);
	}
    }

    public String search(String deutsch) {
	return deutsch;
    }


    public static void main(String[] args) throws FileNotFoundException{
	Dict d = new Dict();

	try {
	    System.out.println(d.fileLength());
	    //System.out.println(d.ent.length);
	    d.read();
	    d.makeDict();
	    //System.out.println(d.ent[0]);
	    //System.out.println((d.entries.get(0)).toString());
	} catch (IOException e){
	    System.out.println("No file found");
	}
    }
}
