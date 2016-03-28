package my.simpleFactory;


public class SimpleFactory {

	/**
	 * TODO 此处即简单工厂模式，在工厂类为核心，里面包含判断业务逻辑
	 * @param fruitType
	 * @return
	 * @throws Exception
	 * @author ttx
	 * @since 2016年2月9日 下午1:29:29
	 */
	public static Fruit FruitFacory(String fruitType){
		if(fruitType.equals("apple")){
			return new Apple();
		}else if(fruitType.equals("banana")){
			return new Banana();
		}else{
			try {
				throw new Exception("The fruitType is not support!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
