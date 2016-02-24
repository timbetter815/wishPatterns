package head.iterator;


public class TupleIterator implements Iterator<String> {
	String [] tuples;
	int position = 0;
	
	TupleIterator(String [] tuples){
		this.tuples = tuples;
	}

	public boolean hasNext() {
		if(position == tuples.length){
			return false;
		}else{
			return true;
		}
		
	}

	public String next() {
		String temp = tuples[position];
		position++;	
		return temp;
	}

}
