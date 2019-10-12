public interface Student_ {
   public String name();               	// Returns Student's name
   public String entryNo();            	// Returns Student's entry number
   public String hostel();             	// Returns Student's hostel name
   public String department();         	// Returns Student's department name
   public String completedCredits();   	// Returns Student's credits earned
   public String cgpa();   		// Returns Student's cgpa until the previous semester
   public CustomIterator_2<CourseGrade_> courseList();// Returns an iterator for all courses for this Student
					      // including those in the current semester	
}