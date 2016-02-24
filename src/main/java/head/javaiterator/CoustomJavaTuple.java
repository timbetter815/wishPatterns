package head.javaiterator;

import java.util.Iterator;

public class CoustomJavaTuple implements Iterable<String>{
	String [] myTuples = {"1","2","3","4","5"};
	
	public Iterator<String> iterator(){
			return new TupleJavaIterator(myTuples);
	}
	
}
