package head.template;

public abstract class BrewBeverage {

	/**
	 * DESC 此处为模板方法(即将所有子类完成特定功能的若干个步骤方法，封装成一个模板方法)
	 * @author ttx
	 * @since 2016年2月14日 下午6:01:09
	 */
	void prepareBrewBeverage(){
		this.boilWater();
		this.getCup();
		this.addCondiment();
		this.letBoilWaterIntoCup();
		
		if(this.isAddSugar()){
			this.addSugar();
		}
	};
	
	// 此处为子类共用方法，如果子类有不同行为，覆盖此方法即可
	void boilWater(){
		System.out.println("I'm boiling the water...");
	}
	
	// 此处为子类共用方法，如果子类有不同行为，覆盖此方法即可
	void getCup(){
		System.out.println("I'm getting the cup...");
	}
	
	// 此处为子类特殊方法，必须由子类覆盖实现，因此定义为Abstract
	abstract void addCondiment();
	
	void letBoilWaterIntoCup(){
		System.out.println("Let boil water into the cup!!!");
	}
	
	void addSugar(){
		System.out.println("add sugar to the beverage!!!");
	}
	
	// 此处为hook钩子方法，即子类可以实现，也可以不实现（子类可以通过hook方法来控制）
	// 钩子方法作用：让子类能够有机会对模板方法中的某些即将发生的（或刚刚发生的）步骤作出反应
	boolean isAddSugar(){
		return true;
	}
}
