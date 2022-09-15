public class Main{
	public static void main(String [] args){
		try{
		SortedIntegerList w = new SortedIntegerList(true);
		w.add(8);
		w.add(9);
		w.add(10);
		w.add(10);
		w.add(10);


		System.out.println(w);
		SortedIntegerList c = new SortedIntegerList(true);
		c.add(8);
		c.add(9);
		c.add(10);
		c.add(10);
		c.add(10);
		System.out.println(c);
		c = w.intersection(c);
    		System.out.println(c);
		}catch(RuntimeException e){
			System.out.println(e.getMessage());
		}
	}
}
