import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Dict{
    
    ArrayList<Entry> entries = new ArrayList<Entry>();
    // what each entry is stored at - IN ENTRY FORM
    String e, g, d;
    
    private static Scanner scanner = new Scanner(System.in);

    File file = new File("werdz.txt");
    Scanner sc = null;
    
    int c = 0;

    public String findG(String word){
	int i = 0;
	while ((i < entries.size()) && (word != entries.get(i).getEng())){
	    i = i + 1;
	}
	return entries.get(i).getWort();
    }

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
    
    public void makeDict(){
	Entry addit;
	int i = 0;
	String e;
	String g; 
	String d;
	while (i < ent.length - 1){
	    String[] parts = ent[i].split("; ");
	    e = parts[0];
	    g = parts[1];
	    d = parts[2];
	    addit = new Entry(e,g,d);
	    //System.out.println(addit.toString());
	    entries.add(addit);
	    i = i + 1;
	}       
    }
    
    /*
    public String test(){
	String thing = ent[0];
	String e;
	String g;
	String d;
	String[] parts = thing.split("; ");
	e = parts[0];
	g = parts[1];
	d = parts[2];
	return e + "/n" + g + "/n" + d;
    }
    */

    public String search(String deutsch) {
	return deutsch;
    }

    public static void main(String[] args) throws FileNotFoundException{
	Dict d = new Dict();

	try {
	    System.out.println("What word would you like?");
	    String input = scanner.nextLine();
	    //System.out.println(d.fileLength());
	    //System.out.println(d.c);
	    System.out.println(d.findG(input));
	    System.out.println(d.ent.length);
	    d.makeEnt();
	    d.makeDict();
	    //System.out.println(d.entries.size());
	    //String out =  d.entries.get(0).toString();
	    //System.out.println(out);
	    //System.out.println(d.ent[0]);
	    //System.out.println(d.ent[d.ent.length - 1]);
	    //System.out.println(d.test());
	} catch (IOException e){
	    System.out.println("No file found");
	}
    }
}
