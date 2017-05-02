package has.spellChecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItalianDic extends Dictionary{

	@Override
	public void loadDictionary() {
		// TODO Auto-generated method stub
		
		try {
			FileReader fr= new FileReader("./rsc/Italian.txt");
			BufferedReader br=new BufferedReader(fr);
			String word;
			richWords=new ArrayList<>();
			
			while((word=br.readLine())!=null)
			{
				richWords.add(word);
				
			}
			br.close();fr.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//	public static void main(String [] args)
//	{
//		ItalianDic dic=new ItalianDic();
//		dic.loadDictionary();
//		System.out.println(dic.richWords.size());
//		System.out.println(dic.richWords.get(1000));
//	}
	
	

}
