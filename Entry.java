public class Entry{
    //eng string may have multiple words (parallels to german one)
    //ger has one word
    private String eng, ger;
    private String def;

    public Entry(String g, String e, String d){
	eng = e;
	ger = g;
	def = d;
    }
    
    public String getEng(){
	return eng;
    }

    public String getWort(){
	return ger;
    }

    public String getDef(){
	return def;
    }

    public String toString(){
	return eng + ger + def;
    }
    

    /*
check guimon.java for input things
entries consist of word and definition
make arrays containing linkedlists - each index holds and entry that is a linkedlist

array (dictionary) containing entries that are comprised of the word(s) and definition(s)
the entry is made up of linkedLists, where the first node is the word and it points to definition(s)

have two sets of arrays, where one has english pointing to german and the other has german pointing to english


2d array with english word at first index, and then german in later indeces (of the internal array)
    */
}
