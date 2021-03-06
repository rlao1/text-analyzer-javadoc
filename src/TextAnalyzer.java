import java.util.*;
import java.io.*;

/**
 * Text analyzer class that analyzes word occurences in a file
 * @author Richmond
 *
 */
public class TextAnalyzer {
	
	File file = new File("file");
	List<String> list = new ArrayList<String>();
	List<Word> wordList = new ArrayList<Word>();
	List<String> resultList = new ArrayList<String>();
	Boolean duplicate = false;
	
	/**
	 * Opens, scans and sorts all words of file in descending order</br>
	 * This method instantiates a custom {@link Word} object</br>
	 * Used in {@link Controller#handleAnalyzeClick()}
	 * @return A list containing preformatted strings of Word member variables and its respective rank order
	 * @throws IOException
	 */
	public List<String> getList() throws IOException 
	{
		Scanner scan = new Scanner(file); 
		scan.useDelimiter("[^A-Za-z]+");
		while(scan.hasNextLine()) 
		{ 
			try 
			{ 
				list.add(scan.next().toUpperCase()); 
			} catch(NoSuchElementException e) {} 
		} 

		for(String w : list) 
		{
			duplicate = false;
			
			for(Word wo : wordList) 
			{
				if(w.equals(wo.getWord()))
				{
					wo.incrementCount();
					duplicate = true;
					break;
				}
			}
			
			if(!duplicate) wordList.add(new Word(w));
		}
		
		Collections.sort(wordList, Word.descendingCount);
		String result;
		int i = 1;
		for(Word wo : wordList) 
		{
			String tempString = wo.getWord().toString();
			String tempInt = String.valueOf(wo.getCount());
			result = String.valueOf(i) + "\t" + tempString + ", " + tempInt;
			resultList.add(result);
			i++;
		}
		
		return resultList;
	}
}
