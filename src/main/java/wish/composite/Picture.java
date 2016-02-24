package wish.composite;

import java.util.Vector;

public class Picture implements Graphics {
	
	private Vector<Graphics> vector = new Vector<Graphics>();

	public void draw() {
		if(vector.size() == 0){
			System.out.println("I'm picture(composite object),i have no draw obj, please add it!!!");
			return;
		}
		for(Graphics graphic : vector){
			graphic.draw();
		}
	}
	
	public void add(Graphics graphic){
		vector.add(graphic);
	}
	
	public void remove(Graphics graphic){
		vector.remove(graphic);
	}

	public Graphics getChild(int index){
		return vector.get(index);
	}
}
