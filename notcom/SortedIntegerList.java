
import java.util.*;

public class SortedIntegerList{ 

	private boolean repeat; 

	private LinkedList<Integer> head = new LinkedList<Integer>();
	
	public SortedIntegerList(boolean check){
		repeat = check;
	}
	
	public void add(int value){
	
		if(head.size() == 0){
			Integer a = value;
			head.add(a);
			return;
		}
		
		else{
			Integer a;
			ListIterator<Integer> iter = head.listIterator();
			while(iter.hasNext()){
				a = iter.next();
				if( value == a.intValue() ){
					if( (repeat) && ( value == a.intValue() ) ){
						iter.add(a);
						return;
					}
					else 
						return;
				}
				
				else if( (value < a.intValue()) ){

						iter.previous();
						a = value;
						iter.add(a);
						return;
				}	
				
				
			}
			a = value;
			iter.add(a);

		}
	}
		
	public void remove(int value){
		Integer valDel;
		ListIterator<Integer> iter = head.listIterator();
		while( iter.hasNext() ){
			valDel = iter.next();
			if( value == valDel.intValue() ){
				iter.previous();
				iter.remove();
				return;
			}
		}
		
	}
	
	public boolean equals(Object a){
		if(a instanceof SortedIntegerList){
			SortedIntegerList list = (SortedIntegerList)a;
			if( head.size() == list.head.size() ){
				Integer that;
				Integer overThat;
				ListIterator<Integer> iterOverThat = list.head.listIterator();
				for(ListIterator<Integer> iterThat = head.listIterator(); iterThat.hasNext();){
					that = iterThat.next();
					overThat = iterOverThat.next();	
						if( that != overThat ){
							return false;
						}
				}
				return true;
			}
			else
				return false;
		}
		else{
			return false;
		}
	}
	
	public boolean overlap(){
		return repeat;
	}
	
	public SortedIntegerList intersection (SortedIntegerList list) {
		SortedIntegerList res = new SortedIntegerList(true);
		SortedIntegerList listCopy = new SortedIntegerList(list);
		ListIterator<Integer> it1 = this.head.listIterator();

		while(it1.hasNext()) {
			int tmp = it1.next();
			ListIterator<Integer> it2 = listCopy.head.listIterator();
			while(it2.hasNext()){
				int tmp2 = it2.next();
				if (tmp2 == tmp) {
					res.add(tmp);
					listCopy.remove(tmp);
					break;
				}
			}
		}

	return res;
	}
	
	public SortedIntegerList( SortedIntegerList list){

		repeat = list.repeat;
		this.head = new LinkedList<Integer>(list.head);
	}

	public String toString(){
		return head.toString();
	}
}