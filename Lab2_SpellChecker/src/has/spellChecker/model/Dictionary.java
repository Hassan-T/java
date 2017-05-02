package has.spellChecker.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	protected List<String> richWords;	
	
	public void loadDictionary(){}
	
	public List<RichWord> spellCheckText(List<String> inputTextList)
	{
		List<RichWord> listR=new LinkedList<>();
		
		for(String s : inputTextList)
		{
			
			
			
			if(richWords.contains(s))
				listR.add(new RichWord(s, true));
			else
				listR.add(new RichWord(s, false));
				
		}
		
		
		return listR;
	}
	
	
//	private boolean binarySearch(String s)
//	{
//		int start=0;int end=richWords.size();
//		
//		while(start!=end)
//		{
//			int average=start +(end - start)/2;
//			if(s.compareToIgnoreCase(richWords.get(average))==0)return true;
//			else if(s.compareToIgnoreCase(richWords.get(average))>0) start=average+1;
//			else end=average;
//		}
//		
//		
//		
//		
//		return false;
//	}

}
