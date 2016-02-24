package head.state;

public class GumballMachine {
	
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State soldOutState;
	private State winnerState;
	
	private State state = soldOutState;
	private int gumballNum = 0;
	
	public GumballMachine(int gumballNum){
		this.gumballNum = gumballNum;
		
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		soldOutState = new SoldOutState(this);
		
		if(this.gumballNum > 0){
			state = noQuarterState;
		}
	}
	
	public void releaseBall(){
		System.out.println("The GumballMachine release an ball...");
		if(gumballNum > 0){
			gumballNum--;
		}
	}
	
	public void insertQuarter() {
		state.insertQuarter();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	public void tumCrank() {
		state.tumCrank();
	}

	public void dispense() {
		state.dispense();	
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public int getGumballNum() {
		return gumballNum;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
