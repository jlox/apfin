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
    Scanner sc = null;
    
    int c = 0;

    public int fileLength(){
	try {
	    sc = new Scanner(file);
	    while(sc.hasNextLine()){
		c = c + 1;
		sc.nextLine();
	    } 
	    return c;
	} catch (FileNotFoundException e){
	    return c;
	}
    }

    String ent[] = new String[fileLength()];
    // each entry is a line in werdz

    public void makeEnt() throws IOException{
	try {
	    sc = new Scanner(file);
	    String s;
	    int i = 0;
	    while(sc.hasNextLine()){
		s = sc.nextLine();
		ent[i] = s;
		i = i + 1;
	    }
	} catch (FileNotFoundException e){
	    ent = null;
	}
    }
    
    /*
    public void makeDict(){
	Entry addit;
	int i = 0;
	String e;
	String g; 
	String d;
	while (i < ent.length - 1){
	    e = ent[i].substring(0, ent[i].indexOf("; "));
	    g = ent[i].substring(ent[i].indexOf("; "), (ent[i].substring(ent[i].indexOf("; ")).indexOf("; ") + ent[i].indexOf("; ")));
	    d = ent[i].substring((ent[i].substring(ent[i].indexOf("; ")).indexOf("; ") + ent[i].indexOf("; ")), ent[i].length() - 1);
	addit = new Entry(e,g,d);
	entries.add(addit);
	}
	//return e + g + d;	        
    }
    */

    public String test(){
	String thing = ent[0];
	String e;
	String g;
	String d;
	e = thing.substring(0, thing.indexOf("; "));
	g = thing.substring(thing.indexOf(";"), (thing.substring(thing.indexOf("; ")).indexOf("; ") + thing.indexOf("; ")));
	d = thing.substring((thing.substring(thing.indexOf("; ")).indexOf("; ")+thing.indexOf("; ")), thing.length()-1);
	return e + "/n" + g + "/n" + d;
    }

    public String search(String deutsch) {
	return deutsch;
    }

    public static void main(String[] args) throws FileNotFoundException{
	Dict d = new Dict();

	try {
	    System.out.println(d.fileLength());
	    System.out.println(d.c);
	    System.out.println(d.ent.length);
	    d.makeEnt();
	    //d.makeDict();
	    System.out.println(d.ent[0]);
	    System.out.println(d.ent[d.ent.length - 1]);
	    System.out.println(d.test());
	    //System.out.println((d.entries.get(0)).toString());
	} catch (IOException e){
	    System.out.println("No file found");
	}
    }
}
