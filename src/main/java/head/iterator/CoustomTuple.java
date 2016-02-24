package head.iterator;

public class CoustomTuple {
	String [] myTuples = {"1","2","3","4","5"};
	
	public Iterator iterator(){
			return new TupleIterator(myTuples);
	}
	
}
