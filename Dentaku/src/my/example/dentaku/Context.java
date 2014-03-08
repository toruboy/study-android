package my.example.dentaku;

public interface Context {

	public void addDisplayNumber(Number num);

	public void saveDisplayNumberToA();

	public void setOp(Operation op);

	public void changeState(State state);

	public void showDisplay();

	public void clearA();

	public void clearDisplay();

	public void clearB();

	public Operation getOp();

	public void copyAtoB();

	public double doOperation();

	public double getA();

	public void showDisplay(double a);

	public void saveDisplayNumberToB();

	void changeSign();

}
