public interface Entity_ { // Entities Classes Hostel, Dept, and Course all have this functionality. 
   public String name();                 // Returns this  entityâ€™s name
   public CustomIterator_2<Student_> StudentList();        // Returns all Students of this entity
}