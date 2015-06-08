import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Dict{

    ArrayList<Entry> entries = new ArrayList<Entry>();
    
    int c = 0;
    
    File file = new File("werdz.txt");

    Scanner sc = new Scanner(file);
    
    public int fileLength(File file) throws IOException{
	Scanner scanner = new Scanner(file);
	while(scanner.hasNextLine()){
	    c = c + 1;
	    scanner.nextLine();
	}
	c = c-1;
	return c;
    }

    String ent[] = new String[c];
    
    public void read(File file) throws IOException{
	Scanner scanner = new Scanner(file);
	String s;
	int i = 0;
	if (ent.length != 0){
	    while(scanner.hasNextLine()){
		s = scanner.nextLine();
		ent[i] = s;
		i = i + 1;
	    }
	}
    }
    
    public void makeDict(){
	Entry addit;
	int i = 0;
	String e, g, d;
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


    public static void main(String[] args){
	Dict d = new Dict();
	//File file = new File("werdz.txt");
	try {
	    d.fileLength(file);
	    d.read(file);
	} catch (IOException e){
	    System.out.println("No file found");
	}
	d.makeDict();
	System.out.println(d.entries);
    }
}
