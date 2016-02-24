package head.javaiterator;

import java.util.Iterator;


public class TupleJavaIterator implements Iterator<String> {
	String [] tuples;
	int position = 0;
	
	TupleJavaIterator(String [] tuples){
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

	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
