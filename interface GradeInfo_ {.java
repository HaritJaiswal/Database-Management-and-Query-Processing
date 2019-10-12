interface GradeInfo_ { 
 enum LetterGrade {A, Aminus, B, Bminus, C, Cminus, D, E, F, I;

}

public static int gradepoint(GradeInfo_.LetterGrade grade)
{ return 0; } 

public default LetterGrade grade()
{ return I; }
}

class GradeInfo implements GradeInfo_ { LetterGrade grade;
	GradeInfo(LetterGrade grade) { this.grade = grade; }
public LetterGrade grade() { return grade; } 
}

class Main {
public static void main(String args[]) {
GradeInfo_ gradeinfo = new GradeInfo(LetterGrade.A);
System.out.println(gradeinfo.grade()); }
}
