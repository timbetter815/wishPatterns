package head.state;

/**
 * DESC 糖果售罄状态
 * @author ttx
 * @since 2016年2月19日 下午9:33:44
 */
public class SoldOutState implements State{
	GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter() {
		// DESC Auto-generated method stub
		
	}

	public void ejectQuarter() {
		// DESC Auto-generated method stub
		
	}

	public void tumCrank() {
		// DESC Auto-generated method stub
		
	}

	public void dispense() {
		// DESC Auto-generated method stub
		
	}

}
