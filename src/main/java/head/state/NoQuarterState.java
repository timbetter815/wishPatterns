package head.state;

/**
 * TODO 没有投币（25分）状态
 * @author ttx
 * @since 2016年2月19日 下午9:33:44
 */
public class NoQuarterState implements State{
	GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine){
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
