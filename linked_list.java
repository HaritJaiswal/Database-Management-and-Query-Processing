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

class CustomIterator_2<T>  implements Iterator<T>
{	int index=0,size;
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

public class linked_list{
	public static void main(String[] args) {
		LinkedList<Integer> L = new LinkedList<Integer>();
		// position<Integer> p1 =new position<Integer>(2);
		// position<Integer> p2 =new position<Integer>(3);
		// p1.next=p2;
		//System.out.println(p1.value());
		//System.out.println(p1.after());
		L.add(1);
		L.add(2);
		L.add(3);
		L.add(4);
		L.add(5);
		L.add(6);
		L.add(7);
		System.out.println("Size of list: "+L.count());
		System.out.println("Value of head in list: "+L.head.value());
		CustomIterator_2<Integer> it= new CustomIterator_2<Integer>(L);
		System.out.println("CustomIterator of list returned from positions(): "+it); 
		//CustomIterator it = new CustomIterator(L);
		
		while(it.hasNext())
			{
			int node=it.next();
			System.out.println(node);
			System.out.println(node.value());
			}	

	}
}