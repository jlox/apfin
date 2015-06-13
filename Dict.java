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

    public String findG(String word){
	int i = 0;
	String result = "We can't find that word!";
	while (i < entries.size()){
	    //System.out.println(entries.get(i).toString() + "/n");
	    if ((entries.get(i)).getEng().equals(word)){
		result = (entries.get(i)).getWort();
	    }
	    i = i + 1;
	}
	return result;
    }

    public String findE(String gword){
	int i = 0;
	String result = "We can't find that word!";
	while (i < entries.size()){
	    //System.out.println(entries.get(i).toString() + "/n");
	    if ((entries.get(i)).getWort().equals(gword)){
		result = (entries.get(i)).getEng();
	    }
	    i = i + 1;
	}
	return result;
    }

    public String findD(String word){
	int i = 0;
	String result = "We can't find that word!";
	while (i < entries.size()){
	    //System.out.println(entries.get(i).toString() + "/n");
	    if ((entries.get(i)).getEng().equals(word)){
		result = (entries.get(i)).getDef();
	    }
	    i = i + 1;
	}
	return result;
    }

    public static void main(String[] args) throws FileNotFoundException{
	Dict d = new Dict();

	try {
	    d.makeEnt();
	    d.makeDict();
	    System.out.println("What function would you like?");
	    System.out.println("1. English to German");
	    System.out.println("2. German to English");
	    System.out.println("3. English Definition");
	    System.out.println("Please select the number of your choice!");
	    String input = scanner.nextLine();
	    if (input.equals("1")){
		System.out.println("What word would you like translated?");
		input = scanner.nextLine();
		System.out.println(d.findG(input));
	    } else if (input.equals("2")){
		System.out.println("What word would you like translated?");
		input = scanner.nextLine();
		System.out.println(d.findE(input));
	    } else if (input.equals("3")){
		System.out.println("Which word's definition would you like?");
		input = scanner.nextLine();
		System.out.println(d.findD(input));
	    } else {
		System.out.println("Sorry, we don't recognize that command. Please make sure you are entering JUST the number of the choice you'd like!");
	    }
	    
	    //System.out.println(d.fileLength());
	    //System.out.println(d.c);
	    //System.out.println(d.ent.length);
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
