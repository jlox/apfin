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
	String result = "We can't find that word!";
	for (int i = 0; i < entries.size() ; i++) {
	    // checks each entry
	    if ( (entries.get(i).getEng().toLowerCase()).contains(word.toLowerCase())){
		result = (entries.get(i)).getWort();
	    }
	}
	return result;
    }

    public String findE(String gword){
	String result = "We can't find that word!";
	for (int i = 0; i < entries.size() ; i++) {
	    
	    if (  (entries.get(i)).getWort().toLowerCase().equals(gword.toLowerCase())){
		result = (entries.get(i)).getEng();
	    }
	}
	return result;
    }

    public String findD(String word){
	String result = "";
	for (int i = 0; i < entries.size() ; i++) {
	    if ((entries.get(i)).getEng().contains(word.toLowerCase())){
		result = (entries.get(i)).getDef();
	    }
	}
	return result;
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
	    System.out.println("\n \n English-to-German: ");
	    System.out.println(d.findG(input));
	    System.out.println("\n German-to-English: ");
	    System.out.println(d.findE(input));
	    System.out.println("\n Definition(s): ");
	    System.out.println(d.findD(input));
	    System.out.println(d.findD(d.findE(input)));
	    System.out.println("\n");

	    /*
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
	   
	    */
	} catch (IOException e){
	    System.out.println("No file found");
	}
    }
}
