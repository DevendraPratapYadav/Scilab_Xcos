# Xcos on Desktop

### *Devendra Pratap Yadav*
##### *2014csb1010@iitrpr.ac.in*

Two programs have been made:

  - Java Swing Application
  - Student Ranking System



## 1. Java Swing Program

Use Terminal/Console
>#### *Compile Instructions*
```sh
$ javac LabelBox.java
```
>#### *Execute using*
```sh
$ java LabelBox
```

Running the program creates a window with "Changing Properties" label.

Right click the label to open a menu. 

Selecting properties opens a new window with input options:
 - Change Background Colour
 - Change Font Colour
 - Change Text

Enter the colour as Hexadecimal values. Error message is displayed if values are invalid.

Click the "Submit" button to see the changes on the label.


## 2. Student Ranking System

Use Terminal/Console
>#### *Compile Instructions*
```sh
$ javac RankingSystem.java
```


>#### *Execute using*

##### 1. Enter manually:  
```sh
$ java RankingSystem
```
This allows manual input of values to the program. 
 - Enter the number of students
 - Enter details for each student one by one as prompted by the program
 
 The input is processed and a Tabulated Ranking List is shown.

 
##### 2. Take input from file
```sh
$ java RankingSystem -f "filename"
```

The -f argument allows the program to read the input from a file specified. The full path of the file can be specified or just the filename if it is in the same directory as the program.
Example : 
```sh
$ java RankingSystem -f input.txt
```

In the text file, student data must be in the following format:

  *roll no* , *name* , *math* , *science* , *environmental science* , *language 1* , *language 2*
  
Each student entry should be in new line and all data for one student must be comma (,) separated.
#### Example :

Data for **Sam Smith**:
 - Roll no : 23
 - Name : Sam Smith
 - Math : 100
 - Science : 85
 - Environmental Science : 94
 - Language 1 : 88
 - Language 2 : 95
 
> Input.txt
```
23,Sam Smith,100,85,94,88,95
12,Mike Rockwell,87,76,87,67,56
13,Jane Parker,99,97,94,88,95
31,Sean Paul,96,45,87,78,68
5,Rahul Sharma,67,87,99,76,56
```

The input is processed and a Tabulated Ranking List is shown:
```
RANK   ROLL NO  NAME             TOTAL   MATH    SCI     EVS     LANG 1  LANG 2
1       13      Jane Parker        473     99      97      94      88      95
2       23      Sam Smith          462     100     85      94      88      95
3       5       Rahul Sharma       385     67      87      99      76      56
4       31      Sean Paul          374     96      45      87      78      68
5       12      Mike Rockwell      373     87      76      87      67      56
```

