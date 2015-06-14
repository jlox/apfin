import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Dict{

    String notfound = "This word is not found.";
    
    ArrayList<Entry> entries = new ArrayList<Entry>();
    // what each entry is stored at - IN ENTRY FORM
    String e, g, d;
    
    private static Scanner scanner = new Scanner(System.in);

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
    // calculates file length


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

	String e;
	String g; 
	String d;
	for (int i = 0; i < ent.length - 1; i++) {
      
	    String[] parts = ent[i].split("; ");
	    e = parts[0];
	    g = parts[1];
	    d = parts[2];
	    addit = new Entry(e,g,d);
	    
	    entries.add(addit);
	}       
    }
    


    public String search(String deutsch) {
	return deutsch;
    }

    public String findG(String word){
	for (int i = 0; i < entries.size() ; i++) {
	    // checks each entry
	    if ( (entries.get(i).getEng().toLowerCase()).contains(word.toLowerCase())){
		return (entries.get(i)).getWort();
	    }
	}
	return notfound;
    }

    public String findE(String gword){
	for (int i = 0; i < entries.size() ; i++) {
	    
	    if (  (entries.get(i)).getWort().toLowerCase().equals(gword.toLowerCase())){
		return (entries.get(i)).getEng();
	    }
	}
	return notfound;
    }

    public String findD(String word){
	for (int i = 0; i < entries.size() ; i++) {
	    if ((entries.get(i)).getEng().contains(word.toLowerCase())){
	       return (entries.get(i)).getDef();
	    }
	}
	return notfound;
    }

    public static void main(String[] args) throws FileNotFoundException{
	Dict d = new Dict();

	try {
	    d.makeEnt();
	    d.makeDict();
	    System.out.println("\n ~~Welcome to the Deutsch Java Wordbook!~~ \n Willkommen auf dem Deutsch-Englische Java Woertbuch");
	    System.out.println("We translate from German to English and English to German.");
	    //System.out.print("We have ");
	    // System.out.print(d.entries.size());
	    //	    System.out.print(" words. \n");
	    System.out.println("Type your word.");
	    String input = scanner.nextLine();

	    System.out.println("\n \n German: ");
	    // System.out.print(d.findG(input));
	    
	    if (d.findG(input).equals(d.notfound)) {
		System.out.println(d.findG(d.findE(input)));
	    } else {
		System.out.println(d.findG(input));
	    }
	   

	    System.out.println("\n English: ");
	    if (d.findE(input).equals(d.notfound)) {
		System.out.println(d.findE(d.findG(input)));
	    } else {
		System.out.println(d.findE(input));
	    }

	   
	    System.out.println("\n Definition(s): ");
	    if (d.findD(input).equals(d.notfound)) {
		System.out.println(d.findD(d.findE(input)));
	    } else {
		System.out.println(d.findD(input));
	    }

	   	   
	} catch (IOException e){
	    System.out.println("No file found");
	}
    }
}
