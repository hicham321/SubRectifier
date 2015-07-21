package subtitlesrectifier;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

public class sub {
	
	private ArrayList<String> wordsList=new ArrayList<>();
	
	private Scanner sc = new Scanner(System.in);
	
	private double timeRectifying ;
	
	private String operation;
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
	
	private void PrintToUser(){
		
		System.out.println("enter the seconds you want to add or substract :");
		
		double time= this.sc.nextDouble();
		
		this.timeRectifying= time;
		System.out.println("Do you want to add or substract seconds :");
		boolean entry =false;
		
		while(!entry){
		System.out.println("Write either add or substract ");
		
		 operation = this.sc.nextLine();
		
		if(operation.equals("add")){
			
			
			entry=true;
		}
		if(operation.equals("substract")){
		
			
			entry=true;
		}
		else{
			System.out.println("enter add or substaract");
		}
		}
		
		
	}
	
	private ArrayList<String> LocateAndRectify (){
		
		ArrayList<String> list= new ArrayList<>();
		
		list=this.wordsList;
		
		for(int i=0;i< list.size()-3;i++){
			if(IsInteger(list.get(i))){
				
				double firstTime=Rectify(list.get(i+1));
				double secondTime=Rectify(list.get(i+3));
				
				
				if(this.operation.equals("add")){
					
					String modifiedTime1 = String.valueOf(firstTime+timeRectifying);
					
					String modifiedTime2 = String.valueOf(firstTime+timeRectifying);
					
					
				}
				if(this.operation.equals("substract")){
					
                    String modifiedTime1 = String.valueOf(firstTime-timeRectifying);
					
					String modifiedTime2 = String.valueOf(firstTime-timeRectifying);
					
				}
			}
		}
		return list;
	}
	private double Rectify (String s){
		
		String TimeString=s.substring(6);
		
		double  TimeDouble= Double.parseDouble(TimeString);
		
		
		return TimeDouble;
		
	}
	private boolean IsInteger (String s){
		if (s == null) {
			return false;
		}
		int length = s.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (s.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = s.charAt(i);
			if (c <= '/' || c >= ':') {
				return false;
			}
		}
		
		return true;
	}
	
	private void testsub() throws IOException{
		String worksapce1="C:/Users/pharma/FFGFG.txt";
		String worksapce2="C:/Users/Hicham/Desktop/ffff.txt";

		File file = new File(worksapce1);
		
		ReadFile(file);
		
		
			System.out.println(wordsList);
			
		
	}

	public static void main(String[] args) throws IOException {
		sub subf = new sub();
		subf.testsub();
	}
}
