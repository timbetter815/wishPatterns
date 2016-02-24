package head.state;

/**
 * TODO 糖果售卖中状态
 * @author ttx
 * @since 2016年2月19日 下午9:33:44
 */
public class SoldState implements State{
	GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter() {
		// TODO Auto-generated method stub
		
	}

	public void ejectQuarter() {
		// TODO Auto-generated method stub
		
	}

	public void tumCrank() {
		// TODO Auto-generated method stub
		
	}

	public void dispense() {
		// TODO Auto-generated method stub
		
	}

}
