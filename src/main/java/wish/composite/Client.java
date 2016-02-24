package wish.composite;

/**
 * TODO 组合模式：允许你将对象组合成树形结构来表现"整体/部分"的层次结构。组合能让客户以一致的方式处理个别对象和组合对象。
 * 
 * ---- 组合模式实现（安全式为例）：
 *   -- 1、组合模式分为安全示和透明式（安全式将composite与leaf分开，而透明式：如果leaf对象调用了一些叶子对象不具备的方法会报错）
 *   -- 2、定义一个component抽象构建对象接口。该接口中，给composite与leaf出共同的行为方法
 *   -- 3、定义一个具体composite组合对象，该对象实现component抽象构建对象方法外，还应该具有add()/remove()/getChild()等方法
 *   -- 4、定义一个具体的leaf叶子对象。只需要实现component抽象构建对象接口默认行为方法即可。
 *   -- 5、这样可以通过composite对象的add将composite对象或者leaf对象组合到自身对象中，成为自身对象的child对象
 *   
 * @author ttx
 * @since 2016年2月15日 下午4:11:58
 */
public class Client {

	public static void main(String[] args) {
		Picture picture = new Picture();
		Graphics line = new Line();
		Graphics circle = new Circle();
		
		line.draw();
		
		picture.draw();
		
		picture.add(line);
		picture.add(line);
		picture.add(circle);
		
		picture.draw();
		
		picture.getChild(0).draw();
	}

}
