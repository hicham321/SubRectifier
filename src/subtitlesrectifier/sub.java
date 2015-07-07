package subtitlesrectifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class sub {
	
	ArrayList<String> wordsList=new ArrayList<>();
	
	// Read subtitles File  
	private void ReadFile(File subFile) throws IOException{
		
		FileInputStream fileInpst= new FileInputStream(subFile);
		
        InputStreamReader inpst	= new InputStreamReader(fileInpst, "UTF-8");
        
        ArrayList<String> wordsList = new ArrayList<String>();
        
        BufferedReader br = new BufferedReader(inpst);
        
        String ligne = null;

		while( (ligne = br.readLine())!= null ){
		        // \\s+ means any number of whitespaces between tokens
		    String [] tokens = ligne.split("\\s+");
		    for(int i=0;i< tokens.length;i++){
		    	
		   wordsList.add(tokens[i]);
		    
		    }
//		    String var_1 = tokens[0];
//		    String var_2 = tokens[1];
//		    String var_3 = tokens[2];
		    }
		this.wordsList=wordsList;
		
		
	}
	
	//locate the strings that you want to work on
	//rectify the string.
	
	private void rectify (){
		
		for(int i=0;i< this.wordsList.size();i++){
			
		}
	}
	
	private void testsub() throws IOException{
		
		File file = new File("C:/Users/pharma/FFGFG.txt");
		
		ReadFile(file);
		
		
			System.out.println(wordsList);
			
		
	}

	public static void main(String[] args) throws IOException {
		sub subf = new sub();
		subf.testsub();
	}
}
