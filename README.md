# Database-Management-and-Query-Processing
You may only use external packages java.util.Iterator and java.io.* for this assignment.

· First, implement the following LinkedList_ interface, which uses a Position_ interface:

  
public interface Position_<T> {// Supports any class T
   public T value();          // Return value at position
   public Position_<T> after();// Returns the position after this position in its list
}

public interface LinkedList_<T> {// Supports any class T
   public Position_<T> add(T e);              // Add element e to this list, returns it position in the list
   public Iterator<Position_<T>>  positions();// Returns an iterator for all positions in the list
   public int  count();                      // Returns the number of elements in the list
}
A student has three entities: department, hostel and courses. In this assignment, you are required to maintain at least these three linked lists to manage these entities: allHostels includes all hostels, allDepartments includes all departments and allCourses includes all courses. In addition, each element in the lists allHostels, allDepartments, allCourses itself should maintain lists that includes all students in that hostel, department, or course, respectively. 
· In order to organize these entities, use interface Entity_:


public interface Entity_ { // Entities Classes Hostel, Dept, and Course all have this functionality. 
   public String name();                 // Returns this  entity's name
   public Iterator<Student_> studentList();        // Returns all students of this entity
}

· You may implement classes Hostel, Department, and Course, which are derived from Entity_. You must also implement interface Student_:

 
 
public interface GradeInfo_ {
   enum LetterGrade {
	A, Aminus, B, Bminus, C, Cminus, D, E, F, I; 
   } // I is the place-holder grade for the current semester, where grade has not been earned yet 
   public static int gradepoint(GradeInfo_.LetterGrade grade)// Returns the points earned for each letter grade
	{

		if (grade == GradeInfo_.LetterGrade.A) return 10;

		else if (grade == GradeInfo_.LetterGrade.Aminus) return 9;

		else if (grade == GradeInfo_.LetterGrade.B) return 8;

		else if (grade == GradeInfo_.LetterGrade.Bminus) return 7;

		else if (grade == GradeInfo_.LetterGrade.C) return 6;

		else if (grade == GradeInfo_.LetterGrade.Cminus) return 5;

		else if (grade == GradeInfo_.LetterGrade.D) return 4;

		else return 0;

	}

   // I grade for every course. Override the function in implementation as needed.
    public default LetterGrade grade() 
	{ return LetterGrade.I;
	}
  
}
 
public interface CourseGrade_ {		// Tuple of course and grade
   public String coursetitle();   	 // Returns course title 
   public String coursenum();   	 // Returns course code, e.g., COL106 
   public GradeInfo_ grade();   	 // Returns student's letter grade
}
 
public interface Student_ {
   public String name();               	// Returns student's name
   public String entryNo();            	// Returns student's entry number
   public String hostel();             	// Returns student's hostel name
   public String department();         	// Returns student's department name
   public String completedCredits();   	// Returns student's credits earned
   public String cgpa();   		// Returns student's cgpa until the previous semester
   public Iterator<CourseGrade_> courseList();// Returns an iterator for all courses for this student
					      // including those in the current semester	
}
· Finally, implement a public class Assignment1, with a static main that has two parts: private static functions getData and answerQueries. The main method takes as command line argument three strings; each string is a file name. The first file (student record file) contains personal data about the students, the second (course file) contains the list of courses taken by students, and finally the third (student query file) contains some queries to process. The first two files are passed to the method getData. The third file is processed by the method answerQueris. i

getData reads information per student from the specified student record file and course file, inserting the information in the respective linked lists (e.g., allHostels, allDepartments, allCourses), updating all data structures.

Student record file will contain record details of student in this order: entry number, name, department, and hostel. These names are single word strings, separated by space (See examples later). Every line contains one record of one student. The student record file will hence act as your source of student information.

The course file lists on each line the grade of one student in one course. It has four strings: the first indicates the student's unique entry number, the second indicates the course number with no spaces (e.g., COL106), the letter grade, and the course title. The title may have multiple words (space separated).

answerQueries will read the student query file, which contains one query per line. For each query, your program must output the correct answer to System.out, one answer per line in the specified format -- but in reverse order of the queries, \ie, the first query's answer comes at the end. Three types of queries have to be supported. Their formats and their explanation are given below:

INFO student
INFO is the keyword. List information about student with the given entry number or the given name: Entry number, Name, Department, Hostel, CGPA, and the course-numbers of all courses taken with the obtained grades in each, sorted lexicographically by the course number (each separated by space), in that order. 

Note: Each course is of 3 credits. While computing CGPA, please ignore the courses which have grade I. CGPA should be rounded off to 2 places of decimal. Use below formula for computation of CGPA. Here n is the number of courses taken by student. 

cgpa 
SHARE studententrynumber entityname
SHARE is the keyword. Provide space separated list of the entry numbers of all students who share the given entity with him or her. 

Note:The result of query SHARE will be sorted in lexicographical order
COURSETITLE coursenumber
COURSETITLE is the keyword. Provide the full title of the given course number.
Example

Example student record file, course file, and student query file have been provided. The required solution for the included query file is given in the third file. Your output must match this format to be counted correct.
