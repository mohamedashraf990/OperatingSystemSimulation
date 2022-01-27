import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class project {
	
 @SuppressWarnings("unchecked")
     static Hashtable<String,String> memory[] = new Hashtable [65];
	 static Queue<String> RR = new LinkedList<String>();
	 static int readcounter=0;
	//static ArrayList<String> txt = new ArrayList<String>();
	 
	public static void main(String[] args) {
		 RR.add("Program 1.txt");
		 RR.add("Program 2.txt");
		 RR.add("Program 3.txt");
		 creatPCb("Program 1.txt");
		 creatPCb("Program 2.txt");
		 creatPCb("Program 3.txt");
         fillMemory("Program 1.txt");
         fillMemory("Program 2.txt");
         fillMemory("Program 3.txt");

         
    	 while(!RR.isEmpty())
    	 {
            execute();

    	 }
  
  	 print("");
   	 print("No more programs are in the queue");
    	 
	}
	
    
	public static String readFile(String fileName) {
		int index=0;
		  print("");
		if(fileName.equals("Program 1.txt")) {
			Hashtable<String, String> lineDividerHashtable=new Hashtable<>();
			lineDividerHashtable.put("Program 1.txt", "Lines");
			memory[15]=lineDividerHashtable;  
			index=16;
		}else if(fileName.equals("Program 2.txt")) {
			Hashtable<String, String> lineDividerHashtable2=new Hashtable<>();
			lineDividerHashtable2.put("Program 2.txt", "Lines");
			memory[31]=lineDividerHashtable2;
			index=32;
		}
		else
		{
			Hashtable<String, String> lineDividerHashtable3=new Hashtable<>();
			lineDividerHashtable3.put("Program 3.txt", "Lines");
			memory[48]=lineDividerHashtable3;
			index=49;
		}
		String fileString="";
		int lineNumber=0;
		  try {
		      File myObj = new File(fileName);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) { 
		        String data = myReader.nextLine();
		        if(readcounter<14) {
		        	 print(data+" "+"(Unparsed line number "+lineNumber+")");
		        	 readcounter++;
		        }
		       
		       
		        Hashtable<String, String> lines=new Hashtable<>();
				lines.put(lineNumber + "", data);
	            memory[index]=lines;
	            index++;
		        lineNumber++;
		        
		        data = data + " ";
		        fileString=fileString+data+"\n";
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      print("An error occurred.");
		      e.printStackTrace();
		    }
		  lineNumber=0;
		  return fileString;
		  }

public static void codeParser(String filename,String upperboundary,String lowerBoundary1) {
		
		
		
		//String resString=readFile(filename);
	    int upperbound = Integer.parseInt(upperboundary);
	    
	    
	    
	    
	    
	    int upperbound1 = Integer.parseInt(upperboundary); //max
	    int minValue=Integer.parseInt(lowerBoundary1);
	    
	    
	    
	    
	    
		String splittedArray[]=filename.split(" ");
		String a="";
		

		for(int i=0;i<splittedArray.length;i++) {
			splittedArray[i]=splittedArray[i].trim();
	}
		
		  for(int i=0;i<splittedArray.length;i++) {

		  if(splittedArray[i].equals("assign")) {
			  
			  while(readMemory(upperbound,minValue,upperbound1)!=null)
				  upperbound--;
			 if(splittedArray[i+2].equals("input"))	
		        assign1(upperbound, splittedArray[i+1], splittedArray[i+2],upperbound1,minValue);
			 if(splittedArray[i+2].equals("readFile"))
			    assign2(upperbound, splittedArray[i+1] , splittedArray[i+2],splittedArray[i+3],upperbound1,minValue); 
		  }
		  
		  
		  
			  if(splittedArray[i].equals("writeFile")) {
					int i1 = upperbound1;
					Set<String> o1 = readMemory(upperbound1,minValue,upperbound1).keySet();
					String s1 = o1.toString();
					while(!(s1.equals("["+splittedArray[i+1]+"]")))
					{
						i1--;
						o1 = readMemory(i1,minValue,upperbound1).keySet();
						s1 = o1.toString();
					}
					
					String x = readMemory(i1,minValue,upperbound1).get(splittedArray[i+1]);
						int i2 = upperbound1;
						Set<String> o2 =readMemory(upperbound1,minValue,upperbound1).keySet();
						String s2 = o2.toString();
						while(!(s2.equals("["+splittedArray[i+2]+"]")))
						{
							i2--;
							o2 = readMemory(i2,minValue,upperbound1).keySet();
							s2 = o2.toString();
						}
						
						String x2 = readMemory(i2,minValue,upperbound1).get(splittedArray[i+2]);
				        writeFile(x,x2);
			  }
			  if(splittedArray[i].equals("add")) {
				  int i1 = upperbound1;
					Set<String> o1 = readMemory(upperbound1,minValue,upperbound1).keySet();
					String s1 = o1.toString();
					while(!(s1.equals("["+splittedArray[i+1]+"]")))
					{
						i1--;
						o1 = readMemory(i1,minValue,upperbound1).keySet();
						s1 = o1.toString();
					}
					
					String x = readMemory(i1,minValue,upperbound1).get(splittedArray[i+1]);
						int i2 = upperbound1;
						Set<String> o2 = readMemory(upperbound1,minValue,upperbound1).keySet();
						String s2 = o2.toString();
						while(!(s2.equals("["+splittedArray[i+2]+"]")))
						{
							i2--;
							o2 = readMemory(i2,minValue,upperbound1).keySet();
							s2 = o2.toString();
						}
						
						String x2 = readMemory(i2,minValue,upperbound1).get(splittedArray[i+2]);
				        int i3 = Integer.parseInt(x);
				        int i4 = Integer.parseInt(x2);
				        i3 =add(i3, i4);
				         Hashtable<String, String> s=new Hashtable<>();
				        s.put(splittedArray[i+1], i3+"");
				        memory[i1]= s;
				        writeMemory(s, i1, 0, upperbound1);   // checker
			  }
		   
		  if(splittedArray[i].equals("print")) {
			  
			  if(splittedArray[i+1].equals("Enter_file_name")||splittedArray[i+1].equals("Enter_file_data")||splittedArray[i+1].equals("Enter_first_number")||splittedArray[i+1].equals("Enter_second_number")) {
				  print(splittedArray[i+1]);
			  }
			  else {		  
				    int i1 = upperbound1;
				   
				
					Set<String> o1 = readMemory(upperbound1,minValue,upperbound1).keySet();
					String s1 = o1.toString();
					
					while(!(s1.equals("["+splittedArray[i+1]+"]")))
					{
						i1--;
						o1 = readMemory(i1,minValue,upperbound1).keySet();
						s1 = o1.toString();
					}
					String x = readMemory(i1,minValue,upperbound1).get(splittedArray[i+1]);
				    print(x);
			  } 
		  }
		}
}
	public static void writeFile(String filename,String data) {
		  try {
		      FileWriter myWriter = new FileWriter(filename,true);
		      myWriter.write("\n"+data);
		      myWriter.close();
		     
		    } catch (IOException e) {
		      
		      e.printStackTrace();
		    }
		  }
	
	
	public static String input() {
		Scanner scanner=new Scanner(System.in);
		String a=scanner.nextLine();
		return a;
	}
	
	public static void print(String x) {
		System.out.println(x);
	}
	
	public static int add(int a,int b) {
		return a+b;
	}
	
	
			
	public static void assign1(int upperbound,String s1 , String s2 ,int maxValue,int minValue)
	{
		if(s2.equals("input"))
		{
			Hashtable<String, String> s=new Hashtable<>();
			s.put(s1, input());

			writeMemory(s, upperbound, 0, 100);  // checker
			
			
			
			 
		}

	}
	public static void assign2(int upperbound,String s1 , String s2,String value,int upperboundary,int minValue)
	{
		
		if(s2.equals("readFile"))
		{
			int i = upperboundary;
			Set<String> o = readMemory(upperboundary,minValue,upperboundary).keySet();
			String s = o.toString();
			while(!(s.equals("["+value+"]")))
			{
				i--;
			}
			
			String x = readFile(readMemory(i,minValue,upperboundary).get(value)  );
			Hashtable<String, String> h=new Hashtable<>();
			h.put(s1, x);
			writeMemory(h, upperbound, 0, 100);  // checker
			
		}
	}
	
	
	public static void fillMemory(String ProcessName) {	
            readFile(ProcessName);
	 }
	public static void execute()
	{
		String x = RR.poll();
		int i =0;
		if(x.equals("Program 1.txt"))
		{
			int k=0;
			Hashtable<String, String>minHashtable= memory[k+3];
			Hashtable<String, String>maxHashtable=memory[k+4];
			String min=minHashtable.get("Boundariesstart");
			String max=maxHashtable.get("BoundariesFinish");
			int minValue=Integer.parseInt(min);
			int maxValue=Integer.parseInt(max);
			Hashtable<String, String> xHashtable=new Hashtable<>();
			print("");
			print("Program ID: 1");
			xHashtable.put("Pstate", "running");
			writeMemory(xHashtable, k+1, minValue, maxValue);
			
			
			Hashtable<String, String>ProgramCounter=readMemory(k+2,minValue,maxValue);
			String pcString=ProgramCounter.get("Pcounter");
			
			int programcounter = Integer.parseInt(pcString);
			while(i<2)
			{
				if(!(readMemory(16+programcounter,minValue,maxValue)==null))
				{
					
				    codeParser(readMemory(16+programcounter,minValue,maxValue).get(programcounter+""),max,min);
				}
				else {
					break;
				}
				programcounter++;
				i++;
			}
			print("");
			print("Program ID: 1");
			print("Quanta" + ":" + i);
			print("");
			
			
			Hashtable<String, String> xHashtableWrite=new Hashtable<>();
			xHashtableWrite.put("Pstate", "notrunning");
			writeMemory(xHashtableWrite, k+1, minValue, maxValue);
			
			
			Hashtable<String, String> PCWrite=new Hashtable<>();
			PCWrite.put("Pcounter", programcounter+"");
			writeMemory(PCWrite, k+2, minValue, maxValue);
			if(!(readMemory(16+programcounter,minValue,maxValue)==null)) {
			
			    RR.add("Program 1.txt");
		}
		}
		else if(x.equals("Program 2.txt"))
		{
			int k=5;
			Hashtable<String, String>minHashtable=memory[k+3];
			Hashtable<String, String>maxHashtable=memory[k+4];
			String min=minHashtable.get("Boundariesstart");
			String max=maxHashtable.get("BoundariesFinish");
			int minValue=Integer.parseInt(min);
			int maxValue=Integer.parseInt(max);
			
			
			
			print("");
			
			print("Program ID: 2");

			Hashtable<String, String> xHashtable=new Hashtable<>();
			xHashtable.put("Pstate", "running");
			writeMemory(xHashtable, k+1, minValue, maxValue);
			
			
			
			
			Hashtable<String, String>ProgramCounter=readMemory(k+2,minValue,maxValue);
			String pcString=ProgramCounter.get("Pcounter");
			
			int programcounter = Integer.parseInt(pcString);
			while(i<2)
			{
				if(!(readMemory(32+programcounter,minValue,maxValue)==null))
				{
				   
				    codeParser(readMemory(32+programcounter,minValue,maxValue).get(programcounter+"") ,max,min);
				}
				else
					break;
				programcounter++;
				i++;
			}
			print("");
			print("Program ID: 2");
			print("Quanta" + ":" + i);
			print("");
			Hashtable<String, String> xHashtableWrite=new Hashtable<>();
			xHashtableWrite.put("Pstate", "notrunning");
			writeMemory(xHashtableWrite, k+1, minValue, maxValue);
			
			
			Hashtable<String, String> PCWrite=new Hashtable<>();
			PCWrite.put("Pcounter", programcounter+"");
			writeMemory(PCWrite, k+2, minValue, maxValue);
			
			if(!(readMemory(32+programcounter,minValue,maxValue)==null))
			  RR.add("Program 2.txt");
		}
		else
		{
			
			int k=10;	
			Hashtable<String, String>minHashtable=memory[k+3];
			Hashtable<String, String>maxHashtable=memory[k+4];
			String min=minHashtable.get("Boundariesstart");
			String max=maxHashtable.get("BoundariesFinish");
		
			int minValue=Integer.parseInt(min);
			int maxValue=Integer.parseInt(max);
			print("");
			print("Program ID: 3");

			Hashtable<String, String> xHashtable=new Hashtable<>();
			xHashtable.put("Pstate", "running");
			writeMemory(xHashtable, k+1, minValue, maxValue);
			
			Hashtable<String, String>ProgramCounter=readMemory(k+2,minValue,maxValue);
			String pcString=ProgramCounter.get("Pcounter");
			
			int programcounter = Integer.parseInt(pcString);
			while(i<2)
			{
				if(!(readMemory(49+programcounter,minValue,maxValue)==null))
				{
					
				    codeParser(readMemory(49+programcounter,minValue,maxValue).get(programcounter+""),max,min);
				}
				else
					break;
				programcounter++;
			
				i++;
			}
			print("");
			print("Program ID: 3");
			print("Quanta" + ":" + i);
			print("");
			Hashtable<String, String> xHashtableWrite=new Hashtable<>();
			xHashtableWrite.put("Pstate", "notrunning");
			writeMemory(xHashtableWrite, k+1, minValue, maxValue);
			
			
			Hashtable<String, String> PCWrite=new Hashtable<>();
			PCWrite.put("Pcounter", programcounter+"");
			writeMemory(PCWrite, k+2, minValue, maxValue);
			
			
			if(!(readMemory(49+programcounter,minValue,maxValue)==null))
			    RR.add("Program 3.txt");
		}
	}
	
	
		
	
	public static void creatPCb(String ProcessName) {
		
		if(ProcessName.equals("Program 1.txt")) {
			   
			Hashtable<String, String> pid=new Hashtable<>();
			pid.put(ProcessName, "1");
			
			
			Hashtable<String, String> pstate=new Hashtable<>();
			pstate.put("Pstate", "notrunning");
			
			
			
			Hashtable<String, String> pcounter=new Hashtable<>();
			pcounter.put("Pcounter", "0");
			
			
			
			Hashtable<String, String> boundariesStart=new Hashtable<>();
			boundariesStart.put("Boundariesstart", "14");
			
			
			
			Hashtable<String, String> boundariesfinish=new Hashtable<>();
			boundariesfinish.put("BoundariesFinish", "30");
             memory[0]=pid;
 	         memory[1]=pstate;
 	         memory[2]=pcounter;
 	         memory[3]=boundariesStart;
 	         memory[4]=boundariesfinish;

 	        
 	        print(pid+"");
 	        print(pstate+"");
 	        print(pcounter+"");
 	        print(boundariesStart+"");
 	        print(boundariesfinish+"");
 	        print("");
		
		
		}
		
		
		if(ProcessName.equals("Program 2.txt")) {
			   Hashtable<String, String> pid2=new Hashtable<>();
				pid2.put(ProcessName, "2");
				
				
				Hashtable<String, String> pstate2=new Hashtable<>();
				pstate2.put("Pstate", "notrunning");
				
				
				
				Hashtable<String, String> pcounter2=new Hashtable<>();
				pcounter2.put("Pcounter", "0");
				
				
				
				Hashtable<String, String> boundariesStart2=new Hashtable<>();
				boundariesStart2.put("Boundariesstart", "31");
				
				
				
				Hashtable<String, String> boundariesfinish2=new Hashtable<>();
				boundariesfinish2.put("BoundariesFinish", "47");

    	        memory[5]=pid2;
    	        memory[6]=pstate2;
    	        memory[7]=pcounter2;
    	        memory[8]=boundariesStart2;
    	        memory[9]=boundariesfinish2;
    	        
    	        
    	            print(pid2+"");
    	 	        print(pstate2+"");
    	 	        print(pcounter2+"");
    	 	        print(boundariesStart2+"");
    	 	        print(boundariesfinish2+"");
    	 	        print("");
		}
		
	
	        	if(ProcessName.equals("Program 3.txt")) {
	        		   
	        		   
	        		   
	        		   Hashtable<String, String> pid3=new Hashtable<>();
	        			pid3.put(ProcessName, "3");
	        			
	        			
	        			Hashtable<String, String> pstate3=new Hashtable<>();
	        			pstate3.put("Pstate", "notrunning");
	        			
	        			
	        			
	        			Hashtable<String, String> pcounter3=new Hashtable<>();
	        			pcounter3.put("Pcounter", "0");
	        			
	        			
	        			
	        			Hashtable<String, String> boundariesStart3=new Hashtable<>();
	        			boundariesStart3.put("Boundariesstart", "48");
	        			
	        			
	        			
	        			Hashtable<String, String> boundariesfinish3=new Hashtable<>();
	        			boundariesfinish3.put("BoundariesFinish", "64");
	        	        memory[10]=pid3;
	        	        memory[11]=pstate3;
	        	        memory[12]=pcounter3;
	        	        memory[13]=boundariesStart3;
	        	        memory[14]=boundariesfinish3;
	        	        print(pid3+"");
	    	 	        print(pstate3+"");
	    	 	        print(pcounter3+"");
	    	 	        print(boundariesStart3+"");
	    	 	        print(boundariesfinish3+"");
	    	 	        print("");
	        	}
	}
	public static void writeMemory(Hashtable<String, String> value,int location,int min ,int max) { 

		
				if( (location>=min && location<=max) || location<=14) {
					memory[location]=value;
			    	print("Writing in "+location+" With Value "+value);	
				}
		    	     
	}
	

	public static Hashtable<String,String> readMemory(int location,int min,int max) {
		    
		if( (location>=min && location<=max) || location<=14) {
			Hashtable<String, String> x = memory[location];
				print("Reading from "+location+" Value "+x);
				return x;
		}
		return null;

		}
	

	}

	