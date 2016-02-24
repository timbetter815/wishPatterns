package head.template;

public class Coffee extends BrewBeverage {

	@Override
	void addCondiment() {
		System.out.println("Add coffee to the cup!!!");
	}

	// 茶里面不应该加糖，因此覆盖父类的钩子方法
	boolean isAddSugar(){
		return false;
	}
}
