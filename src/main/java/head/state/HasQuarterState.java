package head.state;

/**
 * TODO 拥有投币（25分）状态
 * @author ttx
 * @since 2016年2月19日 下午9:33:44
 */
public class HasQuarterState implements State{
	GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter() {
		System.out.println("You can't insert another quarter, because it already has a quarter.");
	}

	public void ejectQuarter() {
		System.out.println("Quarter returned!!!");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
	}

	public void tumCrank() {
		System.out.println("You tum the crank!!!");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

	public void dispense() {
		System.out.println("No gumball dispensed!!!");
	}

}
