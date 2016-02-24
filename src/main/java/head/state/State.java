package head.state;

public interface State {
	// 投入硬币
	void insertQuarter();
	// 退出硬币
	void ejectQuarter();
	// 转动曲柄
	void tumCrank();
	// 发放糖果
	void dispense();
}
