import java.util.Iterator;
import java.io.*;

interface Position_<T> {// Supports any class T
   public T value();          // Return value at position
   public Position_<T> after();// Returns the position after this position in its list
}

interface LinkedList_<T> {// Supports any class T
   public Position_<T> add(T e);              // Add element e to this list, returns it position in the list
   public CustomIterator_1<Position_<T>>  positions();// Returns an CustomIterator for all positions in the list
   public int  count();                      // Returns the number of elements in the list
}


class position<T> implements Position_<T>
{	
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

	//public CustomIterator<Position_<T>> CustomIterator()
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

// EVERYTHING ABOVE IT WORKS 100%(CHECKED)


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

interface CourseGrade__ {		// Tuple of course and grade
   //public String coursetitle();   	 // Returns course title 
   public String coursenum();   	 // Returns course code, e.g., COL106 
   //public GradeInfo_ grade();   	 // Returns student's letter grade
}

// interface GradeInfo_ {
//    enum LetterGrade {
// 	A, Aminus, B, Bminus, C, Cminus, D, E, F, I; 
//    } // I is the place-holder grade for the current semester, where grade has not been earned yet 
//    public static int gradepoint(GradeInfo_.Lettergrade points_earned)
//    {switch(points_earned)
// 		{case A:
// 			return 10;
// 		case Aminus:
// 			return 9;
// 		case B:
// 			return 8;
// 		case Bminus:
// 			return 7;
// 		case C:
// 			return 6;
// 		case Cminus:
// 			return 5;
// 		case D:
// 			return 4;
// 		case E:
// 			return 2;
// 		case F:
// 			return 0;
// 		case I:
// 			return 0;						
// 		}}  // Returns the points earned for each letter grade
// }

class Coursegrade implements CourseGrade_ 
{	String coursenum;
	String student_grade;
	public String coursenum(){return coursenum;}
	//public GradeInfo_ grade(){

	//}   	 // Returns student's letter grade

}

class courselist
{	LinkedList<Coursegrade> L;
	public courselist(LinkedList<Coursegrade> L){this.L=L;}
	public CustomIterator_2<Coursegrade> harit(){CustomIterator_2<Coursegrade> it = new CustomIterator_2<Coursegrade>(L);
		return it;}
}
// class Iterator<T>  implements Iterator<Coursegrade>
// {	int index=0,size;
// 	Coursegrade current_node;
// 	LinkedList<T> L;
// public CustomIterator(LinkedList<T> L){
// 	this.L = L;
// 	current_node=L.head;
// 	size=L.count();
// }
// 	//if next element is present
// 	 public boolean hasNext() { 
// 	 	if(index<size){return true;}
// 	 	else{return false;}
//     } 
      
//     // moves the cursor/CustomIterator to next element 
//     public position<T> next() {  if (this.hasNext())
//                {CourseGrade temp = current_node;
//                	index++;
//                 current_node=current_node.next;
//                 return temp;}
//             else
//                 return null;
//     } 
      
//     // Used to remove an element. Implement only if needed 
//     public void remove() { //Not required
//         // Default throws UnsupportedOperationException. 
//     }
// }


public class Course_grade
{
	public static void main(String[] args) {Coursegrade c1 = new Coursegrade();
		c1.coursenum="MTL100";
		Coursegrade c2 = new Coursegrade();
		c2.coursenum="PYL100";
		Coursegrade c3 = new Coursegrade();
		c3.coursenum="APL100";
		Coursegrade c4 = new Coursegrade();
		c4.coursenum="COL100";
		LinkedList<Coursegrade> L = new LinkedList<Coursegrade>();
		
		L.add(c1);
		L.add(c2);
		L.add(c3);
		L.add(c4);
		courselist cl = new courselist(L);

		CustomIterator_2<Coursegrade> it= cl.harit();
		System.out.println("Size of list: "+L.count());
		//System.out.println(c2.coursenum());
		while(it.hasNext())
			{Coursegrade cgd=it.next();
				System.out.println(cgd);
				System.out.println(cgd.coursenum());
			}
			
	}
}



