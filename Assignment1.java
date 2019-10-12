import java.util.Iterator;
import java.io.*;

class position<T> implements Position_<T>
{	//public position head;
	T data;
	public position next=null;
	//constructor
	public position(T d)
	{data=d;
	next = null;
	}
	public T value(){return data;}
	public Position_<T> after(){return next;}
}

class LinkedList<T> implements LinkedList_<T>//, Iterable<position<T>>
{	public int  count=0; 
	public position head;
	public Position_<T> add(T e){position new_node = new position(e);
		count++;
		if(head == null){head = new_node;
			return head;}
            else
            {position end = head;
            	while(end.next!=null)
            		{end=end.next;}
            	end.next=new_node;
            	return end.next;
            }

	}
	public int count(){return count;}

	//public CustomIterator<Position_<T>> iterator()
	//{
	//	return new CustomIterator<T>(this);
	//}

	public CustomIterator_1<Position_<T>>  positions(){CustomIterator_1 iter = new CustomIterator_1(this);
		return iter;
			}
		
}


class CustomIterator_1<T>  implements Iterator<Position_<T>>
{	int index=0,size;
	position<T> current_node;
	LinkedList<T> L;
public CustomIterator_1(LinkedList<T> L){
	this.L = L;
	current_node=L.head;
	size=L.count();
}
	//if next element is present
	 public boolean hasNext() { 
	 	if(index<size){return true;}
	 	else{return false;}
    } 
      
    // moves the cursor/CustomIterator to next element 
    public position<T> next() {  if (this.hasNext())
               {position<T> temp = current_node;
               	index++;
                current_node=current_node.next;
                return temp;}
            else
                return null;
    } 
      
    // Used to remove an element. Implement only if needed 
    public void remove() { //Not required
        // Default throws UnsupportedOperationException. 
    }
}

class CustomIterator_2<T> implements Iterator<T>
{int index=0,size;
	position<T> current_node;
	LinkedList<T> L;
public CustomIterator_2(LinkedList<T> L){
	this.L = L;
	current_node=L.head;
	size=L.count();
}
	//if next element is present
	 public boolean hasNext() { 
	 	if(index<size){return true;}
	 	else{return false;}
    } 
      
    // moves the cursor/CustomIterator to next element 
    public T next() {  if (this.hasNext())
               {position<T> temp = current_node;
               	index++;
                current_node=current_node.next;
                return temp.value();}
            else
                return null;
    } 
      
    // Used to remove an element. Implement only if needed 
    public void remove() { //Not required
        // Default throws UnsupportedOperationException. 
    }
}


// EVERYTHING ABOVE IT WORKS 100%(CHECKED)

class Hostel implements Entity_
{	String hostel_name;
	LinkedList<Student_> HostelStudents = new LinkedList<Student_>();

	public String name(){return hostel_name;}                 // Returns this  entityâ€™s name
   public CustomIterator_2<Student_> StudentList(){CustomIterator_2<Student_> it = new CustomIterator_2<Student_>(HostelStudents);
		return it;
   }        // Returns all Students of this entity
}

class Department implements Entity_
{String dept_name;
	LinkedList<Student_> DeptStudents = new LinkedList<Student_>();

	public String name(){return dept_name;} 
	public CustomIterator_2<Student_> StudentList(){CustomIterator_2<Student_> it = new CustomIterator_2<Student_>(DeptStudents);
		return it;
   }  

}

class Course implements Entity_
{String course_name;
	String course_title;
	LinkedList<Student_> CourseStudents = new LinkedList<Student_>();

	public String name(){return course_name;} 
	public CustomIterator_2<Student_> StudentList(){CustomIterator_2<Student_> it = new CustomIterator_2<Student_>(CourseStudents);
		return it;
   }  

}


class grade_info implements GradeInfo_
{
	String grade;
	grade_info(String grade){this.grade=grade;
	}
public int GetPointsOfGrade()
	{GradeInfo_.LetterGrade lg = GradeInfo_.LetterGrade.valueOf(grade);
		return GradeInfo_.gradepoint(lg);}
}

class Coursegrade implements CourseGrade_ 
{String coursetitle;
	String coursenum;
	String student_grade;
	public String coursetitle(){return coursetitle;}
	public String coursenum(){return coursenum;}
	public GradeInfo_ grade(){grade_info gi = new grade_info(student_grade);
		return gi;

	}   	 // Returns Student's letter grade
}
class Student implements Student_
{String name;
	String entryNo;
	String hostel;
	String department;
	String cgpa;
	LinkedList<CourseGrade_> list_of_courses = new LinkedList<CourseGrade_>();

	public String name(){return name;}
	public String entryNo(){return entryNo;}
	public String hostel(){return hostel;}
	public String department(){return department;} 
	public String completedCredits(){int net_credits=0;
		CustomIterator_2<CourseGrade_> tor=this.courseList();
		while(tor.hasNext())
		{CourseGrade_ a_course=tor.next();
			grade_info gi =(grade_info)a_course.grade();
			int point = gi.GetPointsOfGrade();
			if(point!=0){net_credits+=3;}
		}	
		return String.valueOf(net_credits);
	} 
	public String cgpa(){int sum=0;
		CustomIterator_2<CourseGrade_> tor=this.courseList();
		while(tor.hasNext())
		{CourseGrade_ a_course=tor.next();
			grade_info gi =(grade_info)a_course.grade();
			int point = gi.GetPointsOfGrade();
			sum+=point;
		}	
		sum=sum*3;
		double total_credits= Integer.parseInt(this.completedCredits());
		double cgpa = (float)sum;
		cgpa=cgpa/total_credits;
		cgpa=Math.round(cgpa*100.0)/100.0;
		return String.valueOf(cgpa);
	}

	public CustomIterator_2<CourseGrade_> courseList(){
		CustomIterator_2<CourseGrade_> cure = new CustomIterator_2<CourseGrade_>(this.list_of_courses);
		return cure;}

}


class hostel_finder 
{
	public static boolean find(LinkedList<Hostel> L,String s)
	{ CustomIterator_2<Hostel> it = new CustomIterator_2<Hostel>(L);
		
		while(it.hasNext())
			{Hostel obj = it.next();
				if(s.equals(obj.name())){return false;}
				
			}
			return true;
	}
}

class dept_finder 
{
	public static boolean find(LinkedList<Department> L,String s)
	{ CustomIterator_2<Department> it = new CustomIterator_2<Department>(L);
		
		while(it.hasNext())
			{Department obj = it.next();
				if(s.equals(obj.name())){return false;}
				
			}
			return true;
	}
}

class course_finder 
{
	public static boolean find(LinkedList<Course> L,String s)
	{ CustomIterator_2<Course> it = new CustomIterator_2<Course>(L);
		
		while(it.hasNext())
			{Course obj = it.next();
				if(s.equals(obj.name())){return false;}
				
			}
			return true;
	}
}

class Sort_array
{	public static String[] sorter(String[] courses)
	{int size = courses.length;
		for(int p=0;p<size-1;p++)
		{for(int j=p+1;j<size;j++)
			{	if(courses[p].compareTo(courses[j])>0)
					{String temp = courses[p];
						courses[p] = courses[j];
						courses[j]=temp;
					}
			}	
		}
		return courses;
	}
}

public class Assignment1
{
	static LinkedList<Hostel>  allHostels = new LinkedList<Hostel>();
    static LinkedList<Department>  allDepartments  = new LinkedList<Department>();
    static LinkedList<Course>  allCourses = new LinkedList<Course>();
    static LinkedList<Student> allStudents = new LinkedList<Student>();

	private static void getData(String s1, String s2){
    try{
    BufferedReader br1 = new BufferedReader(new FileReader(s1));
    BufferedReader br2 = new BufferedReader(new FileReader(s2));
    String line1,line2;

    while((line1 = br1.readLine())!= null){
    	String[] part1 = line1.split(" ");
   
    	Student s =new Student();
    	s.entryNo=part1[0];
		s.name=part1[1];
		s.department=part1[2];
		s.hostel=part1[3];

		Assignment1.allStudents.add(s);

		}
		//filling the allStudents list 
		while((line2 = br2.readLine())!= null){
			String[] part2 = line2.split(" ",4);
			CustomIterator_2<Student> tor = new CustomIterator_2<Student>(Assignment1.allStudents);
			while(tor.hasNext())
				{Student s=tor.next();
					if(s.entryNo.equals(part2[0]))
					{Coursegrade cg = new Coursegrade();
						cg.coursenum=part2[1];
						cg.student_grade=part2[2];
						cg.coursetitle=part2[3];
						s.list_of_courses.add(cg);
					}	
				}		
		}

		br1.close();
		br2.close();

		//filling other lists using allStudents
		CustomIterator_2<Student> torus = new CustomIterator_2<Student>(Assignment1.allStudents);

		if(torus.hasNext()){Student s = torus.next();
			Hostel h = new Hostel();
			Department dept = new Department();

			h.hostel_name=s.hostel();
			//h.HostelStudents.add(s);
			Assignment1.allHostels.add(h);

			dept.dept_name=s.department();
			//dept.DeptStudents.add(s);
			Assignment1.allDepartments.add(dept);

			CustomIterator_2<CourseGrade_> iter_cg = new CustomIterator_2<CourseGrade_>(s.list_of_courses);
			while(iter_cg.hasNext())
			{	Course c = new Course();
				Coursegrade cg = (Coursegrade)iter_cg.next();
				c.course_name = cg.coursenum();
				c.course_title  = cg.coursetitle();
				//c.CourseStudents.add(s);
				Assignment1.allCourses.add(c);
			}
		}

		while(torus.hasNext())
		{Student s = torus.next();
			
			if(hostel_finder.find(allHostels,s.hostel())){
				Hostel h = new Hostel();
				h.hostel_name=s.hostel();
				//h.HostelStudents.add(s);
				Assignment1.allHostels.add(h);}

			if(dept_finder.find(allDepartments,s.department())){Department dept = new Department();
			dept.dept_name=s.department();
			//dept.DeptStudents.add(s);
			Assignment1.allDepartments.add(dept);}

			CustomIterator_2<CourseGrade_> rat_cg = new CustomIterator_2<CourseGrade_>(s.list_of_courses);
			while(rat_cg.hasNext())
			{				Coursegrade cg = (Coursegrade)rat_cg.next();
				if(course_finder.find(allCourses,cg.coursenum()))
				{Course c = new Course();
				c.course_name = cg.coursenum();
				c.course_title  = cg.coursetitle();
				//c.CourseStudents.add(s);
				Assignment1.allCourses.add(c);}
			}

		}

		CustomIterator_2<Student> oos = new CustomIterator_2<Student>(Assignment1.allStudents);	
		while(oos.hasNext())
		{Student s = oos.next();
			CustomIterator_2<Hostel> ooh = new CustomIterator_2<Hostel>(Assignment1.allHostels);
			while(ooh.hasNext())
				{Hostel h = ooh.next();
					if(s.hostel.equals(h.name())){h.HostelStudents.add(s);}
				}
		} 

		CustomIterator_2<Student> ds = new CustomIterator_2<Student>(Assignment1.allStudents);
		while(ds.hasNext())
		{Student s = ds.next();
			CustomIterator_2<Department> ooh = new CustomIterator_2<Department>(Assignment1.allDepartments);
			while(ooh.hasNext())
				{Department d = ooh.next();
					if(s.department.equals(d.name())){d.DeptStudents.add(s);}
				}
		}

		CustomIterator_2<Student> cs = new CustomIterator_2<Student>(Assignment1.allStudents);
		while(cs.hasNext())
		{Student s = cs.next();
			CustomIterator_2<Course> ooh = new CustomIterator_2<Course>(Assignment1.allCourses);
			while(ooh.hasNext())
				{Course c = ooh.next();
					CustomIterator_2<CourseGrade_> g = s.courseList();
					while(g.hasNext())
					{Coursegrade gd = (Coursegrade)g.next();
						if((gd.coursenum()).equals(c.name())){c.CourseStudents.add(s);}}
				}
		}

	}

catch (FileNotFoundException ex)  {}
    catch (IOException ex) {}

}

private static void answerQueries(String s3)
	{ try{
		BufferedReader br3 = new BufferedReader(new FileReader(s3));
		BufferedReader br4 = new BufferedReader(new FileReader(s3));
		String line1,line2;
		int no_of_queries=0;
		while((line1=br3.readLine())!=null)
		{no_of_queries++;}
		String[] queries = new String[no_of_queries];
		int index=0;
		while((line2=br4.readLine())!=null){
			queries[no_of_queries-index-1]=line2;
			index++;
		}

		for(int i=0;i<no_of_queries;i++)
			{String[] parts = queries[i].split(" ");
				if(parts[0].equals("SHARE"))
				{//if hostel matches
					CustomIterator_2<Hostel> toph=new CustomIterator_2<Hostel>(Assignment1.allHostels);
					while(toph.hasNext())
						{Hostel h=toph.next();
							if(parts[2].equals(h.name()))
							{CustomIterator_2<Student_> t = h.StudentList();
								int number=0;
								while(t.hasNext())
									{Student s = (Student)t.next();
										if(parts[1].compareTo(s.entryNo())!=0){number++;}

									}
									String[] entries = new String[number];
									int position=0;
									CustomIterator_2<Student_> tx = h.StudentList();
									while(tx.hasNext())
										{Student s = (Student)tx.next();
											if(parts[1].compareTo(s.entryNo())!=0){entries[position]=s.entryNo();
												position++;}

										}
										String[] ordered_entries = Sort_array.sorter(entries);
										for (int mo=0;mo<number ;mo++ ) {
											System.out.print(ordered_entries[mo]+" ");
										}
	
	
							}
						}

						//if dept matches
						CustomIterator_2<Department> topd=new CustomIterator_2<Department>(Assignment1.allDepartments);
					while(topd.hasNext())
						{Department d=topd.next();
							if(parts[2].equals(d.name()))
							{
								CustomIterator_2<Student_> t = d.StudentList();
								int number=0;
								while(t.hasNext())
									{Student s = (Student)t.next();
										if(parts[1].compareTo(s.entryNo())!=0){number++;}

									}
								String[] entries = new String[number];
									int position=0;
									CustomIterator_2<Student_> tx = d.StudentList();
									while(tx.hasNext())
										{Student s = (Student)tx.next();
											if(parts[1].compareTo(s.entryNo())!=0){entries[position]=s.entryNo();
												position++;}

										}
										String[] ordered_entries = Sort_array.sorter(entries);
										for (int mo=0;mo<number ;mo++ ) {
											System.out.print(ordered_entries[mo]+" ");
										}	
															
							}
						}

						//if course matches
						CustomIterator_2<Course> topc=new CustomIterator_2<Course>(Assignment1.allCourses);
					while(topc.hasNext())
						{Course c=topc.next();
							if(parts[2].equals(c.name()))
							{CustomIterator_2<Student_> t = c.StudentList();
								int number=0;
								while(t.hasNext())
									{Student s = (Student)t.next();
										if(parts[1].compareTo(s.entryNo())!=0){number++;}

									}
								String[] entries = new String[number];
									int position=0;
									CustomIterator_2<Student_> tx = c.StudentList();
									while(tx.hasNext())
										{Student s =(Student) tx.next();
											if(parts[1].compareTo(s.entryNo())!=0){entries[position]=s.entryNo();
												position++;}

										}
										String[] ordered_entries = Sort_array.sorter(entries);
										for (int mo=0;mo<number ;mo++ ) {
											System.out.print(ordered_entries[mo]+" ");
										}	
														
							}
						}
						System.out.println();

				}

				if(parts[0].equals("COURSETITLE"))
				{CustomIterator_2<Course> vain = new CustomIterator_2<Course>(Assignment1.allCourses);
					while(vain.hasNext())
					{Course c = vain.next();
						if(parts[1].equals(c.name())){System.out.println(c.course_title);}

					}

				}
				
				if(parts[0].equals("INFO"))
				{	
					CustomIterator_2<Student> iter = new CustomIterator_2<Student>(Assignment1.allStudents);
					while(iter.hasNext())
					{
						Student s =iter.next();
						if(parts[1].equals(s.name()) || parts[1].equals(s.entryNo())){
							CustomIterator_2<CourseGrade_> bor = s.courseList();
							int size=s.list_of_courses.count();
							String[] courses = new String[size];
							int counter=0;
							while(bor.hasNext())
							{Coursegrade n = (Coursegrade)bor.next();
								String line = n.coursenum()+ " " +n.student_grade;
								courses[counter]=line;
								counter++;
							}

							String[] ordered_courses = Sort_array.sorter(courses);
							System.out.print(s.entryNo() +" "+ s.name() +" "+ s.department() +" "+ s.hostel() +" "+ s.cgpa() +" " );
							for (int k=0;k<size ;k++ ) {
								System.out.print(ordered_courses[k]+" ");
							}
							System.out.println();
							break;
						}
							
					}
				}
		    }
		    br3.close();
		    br4.close();

		}

		catch (FileNotFoundException ex)  {}
    catch (IOException ex) {}
		
	}

	

	public static void main(String[] args) {

		Assignment1.getData(args[0],args[1]);
		CustomIterator_2<Student> hi = new CustomIterator_2<Student>(Assignment1.allStudents);
		while(hi.hasNext())
			{Student s = hi.next();
				if(s.entryNo().equals("2018EE10462"))
				{System.out.println(s.name());
					CustomIterator_2<CourseGrade_> iter = s.courseList();
					System.out.println(s.list_of_courses.count());
					while(iter.hasNext())
						{Coursegrade cg = (Coursegrade)iter.next();
							System.out.print(cg.coursenum()+" "+cg.student_grade+" "+cg.coursetitle()+"| ");}
					
				}
			}
			System.out.println('\n' + "Checking in allCourses");
			CustomIterator_2<Course> cs  = new CustomIterator_2<Course>(Assignment1.allCourses);
			while(cs.hasNext())
				{Course t = cs.next();
					System.out.println(t.name()+" "+t.course_title+"|");
				}



			System.out.println('\n' + "/////////////////////////////////////////////////////////////////////////////////////");
		Assignment1.answerQueries(args[2]);

	}

}
