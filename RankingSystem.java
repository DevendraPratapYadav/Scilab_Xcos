/**
  Xcos on Desktop- Part A
  
  Author- Devendra Pratap Yadav
  		   B.Tech CSE, IIT Ropar
  		  2014csb1010@iitrpr.ac.in
  
  
  |README|
  
  The program supports argument for input from file.
  Use -f "filename"
  command line argument to read input from text file
  eg. $ java RankingSystem -f inp.txt
  
  NOTE: The filename can be a full file path as well.
  
  In the file, student data must be in the following format:
  roll no, name, math, science, env. science, language 1, language 2
  
  Each student entry should be in new line and 
  all data for one student must be comma (,) separated.
  
  Example:
  5,Rahul,67,87,99,76,56
  6,Ram,67,87,99,76,56
  
  
  If no command line argument is given, user is prompted for input
  and student data is to be entered according to message shown.
  
  Tabulated Ranking is shown in console as output.
   
   
   Sources/References:
   https://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html
   https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html
   
   
   
 */


import java.io.*;
import java.util.*;

/**
 * Main class for Ranking
 */
public class RankingSystem 
{
    
	/**
	 * Class for storing student record
	 */
    class Student implements Comparable<Student>
    {
     String name;  
     int totalMarks	;
     int rollNo;
     int lang1;
     int lang2;
     int math;
     int science;
     int evs;
     
     /**
      * Default constructor
      * */
     Student(int r,String n, int m, int sci,int ev, int l1,int l2)
     {
    	 name=n; 
    	 rollNo=r;
    	 lang1=l1;
    	 lang2=l2;
    	 math=m;
    	 science=sci;
    	 evs=ev;
    	 totalMarks=lang1+lang2+math+science+evs;
     }
     
     public void setTotal()
     {totalMarks=lang1+lang2+math+science+evs;}
     
     /**
      * Compare function for comparables interface. Used to compare student record
      */
     public int compareTo( Student w)
     {
    	 if (this.totalMarks>w.totalMarks)
    		 return 1;
    	 if (this.totalMarks<w.totalMarks)
    		 return -1;
    	 
    	 if(this.math>w.math)
    		 return 1;
    	 if(this.math<w.math)
    		 return -1;
    	
    	 if(this.science>w.science)
    		 return 1;
    	 if(this.science<w.science)
    		 return -1;
    	
    	 if(this.evs>w.evs)
    		 return 1;
    	 if(this.evs<w.evs)
    		 return -1;
    	 
    	 if(this.lang1>w.lang1)
    		 return 1;
    	 if(this.lang1<w.lang1)
    		 return -1;
    	 
    	 if(this.lang2>w.lang2)
    		 return 1;
    	 if(this.lang2<w.lang2)
    		 return -1;
    
    	 
    	 return -(this.name.compareTo(w.name));
    
     }
     
    }
    
    
    public static void main(String []args) 
	{
		
		RankingSystem rs=new RankingSystem();
		
		Scanner sc=new Scanner(System.in);
		
		String fil="";
		int inp=0;
		
		// Check for argument input
		if (args.length>0)
		{
		 if (args[0].equalsIgnoreCase("-f"))
		 {
			 fil=args[1];
			 inp=1;
		 }
			 
		}
		
		//System.out.println("Choose input type:\n1. Input from file\n2. Manual input via console\n(1 or 2)");
		//int inp=sc.nextInt();
		//sc.nextLine();
		
		
		
		// No command line argument given
		if (inp==0)
		{ 
			
			System.out.println("Enter the number of Students:"); 
			int totalStudents=sc.nextInt();	sc.nextLine();
			
			
			if (totalStudents<5)
				{System.out.println("Please input at least 5 students"); return;}
			
			Student []db=new Student[2*totalStudents];
			
			for (int i=0;i<totalStudents;i++)
			{
				db[i]=rs.new Student(0, "", 0, 0, 0, 0, 0);
				
				System.out.println("\n>> Student "+(i+1));
				System.out.print("Roll Number :");
				db[i].rollNo=sc.nextInt();sc.nextLine();
				
				System.out.print("Name :");
				db[i].name=sc.nextLine();
				
				System.out.print("Language 1 :");
				db[i].lang1=sc.nextInt();sc.nextLine();
				
				System.out.print("Language 2 :");
				db[i].lang2=sc.nextInt();sc.nextLine();
				
				System.out.print("Math :");
				db[i].math=sc.nextInt();sc.nextLine();
				
				System.out.print("Science :");
				db[i].science=sc.nextInt();sc.nextLine();
				
				System.out.print("Environmental Studies :");
				db[i].evs=sc.nextInt();
				
				db[i].setTotal();
				
			} // end for 
			
			
			// Sort student array according to comparables function
			Arrays.sort(db,0,totalStudents);

			// Print Tabulated Ranking
			
			System.out.println("RANK\tROLL NO\t"+String.format("%-25s","NAME")+"\tTOTAL\tMATH\tSCI\tEVS\tLANG 1\tLANG 2"); 
	 		
			for(int i=totalStudents-1;i>=0;i--)
	 		{
	 			
	 			System.out.println((totalStudents-i)+"\t"+db[i].rollNo+"\t"+String.format("%-25s",db[i].name)+"\t"+db[i].totalMarks+"\t"+
	 					+db[i].math+"\t"+db[i].science+"\t"+db[i].evs+"\t"+db[i].lang1+"\t"+db[i].lang2); 
	 			
	 		}
	    	
			
			
			
		}
		else if(inp==1)
		{
			//System.out.println("Enter filename/file path :"); 
			int lineCount=0;		// to count total number of students
			
			
			String filePath=fil;//sc.nextLine(); // get file path
			
	    	File f=new File(filePath);
	    	
	        BufferedReader br = null;
	         
	        
	        // Count total number of students first
	 		try {
	 			br = new BufferedReader(new FileReader(f));
	 			String s="";
	 			
	 	    	while ((s = br.readLine()) != null) 
	 	    	{
	 	    		lineCount++;
	 			}
	 		
	 		} catch (IOException e) {
	 			System.out.println("File read Error at "+filePath);	
	 			return;
	 			}
	     	
	     	
	 		

			if (lineCount<5)
				{System.out.println("Please input at least 5 students"); return;}
	 		
	 		// Array to store all records
	     	Student []db=new Student[2*lineCount];
	     	
	 		
	     	
	     	
	     	
	           br = null;
	          int totalStudents=0;
	           
	           // Read all records and insert them into array 
	 		try {
	 			br = new BufferedReader(new FileReader(f));
	 			String s="";
	 	    	
	 	    	while ((s = br.readLine()) != null) 
	 	    	{
	 				String[]arr=s.split(",");
	 	    		
	 				if (arr.length==7)
	 				{
	 	    		Student newStudent=rs.new Student(Integer.parseInt(arr[0].trim()), arr[1], Integer.parseInt(arr[2].trim()),
						 	    				Integer.parseInt(arr[3].trim()), Integer.parseInt(arr[4].trim()), 
						 	    				Integer.parseInt(arr[5].trim()), Integer.parseInt(arr[6].trim()) );
	 	    		
	 	    		db[totalStudents++]=newStudent;
	 	    		
	 	    		
	 				} // end if 
	 	    		
	 			} // end while
	 			
	 	    
	 		} catch (IOException e) {
	 			System.out.println("File read Error at "+filePath);	return;
	 			}
	     	
	 		
	 		// Sort student array according to comparables function
			Arrays.sort(db,0,totalStudents);

			
			// Print Tabulated Ranking
			
	 		System.out.println("RANK\tROLL NO\t"+String.format("%-25s","NAME")+"\tTOTAL\tMATH\tSCI\tEVS\tLANG 1\tLANG 2"); 
	 			
	 		for(int i=totalStudents-1;i>=0;i--)
	 		{
	 			
	 			
	 			System.out.println((totalStudents-i)+"\t"+db[i].rollNo+"\t"+String.format("%-25s",db[i].name)+"\t"+db[i].totalMarks+"\t"+
	 					+db[i].math+"\t"+db[i].science+"\t"+db[i].evs+"\t"+db[i].lang1+"\t"+db[i].lang2); 
	 			
	 			//String.format("%-50s", num[i].word)
	 			
	 		}
	    	
	    	
	    	
	 		try {	br.close();		} 
			catch (IOException e) {
			}
			
		} // end inp==1
					    
		
    	sc.close();
	
	
	} //end main





	
	
	
	
} // end WordCount
