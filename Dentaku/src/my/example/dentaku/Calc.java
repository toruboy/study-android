package my.example.dentaku;

import android.widget.TextView;

public class Calc implements Context {

	private double a;
	private double b;
	private Operation op;
	protected AbstractDisplay disp;
	protected State state;

	public Calc() {
		a = 0d;
		b = 0d;
		op = null;
		changeState(NumberAState.getInstance());
	}

	public void setDisplay(TextView txt) {
		this.disp = new StringDisplay(txt);
	}

	public void onButtonNumber(Number num) {
		state.onInputNumber(this, num);
	}

	public void onButtonOp(Operation op) {
		state.onInputOperation(this, op);
	}

	public void onButtonClear() {
		state.onInputClear(this);
	}

	public void onButtonAllClear() {
		state.onInputAllClear(this);
	}

	public void onButtonEqual() {
		state.onInputEqual(this);
	}

	@Override
	public void addDisplayNumber(Number num) {
		if (num == Number.ZERO || num == Number.DOUBLE_ZERO) {
			if (disp.displayChar.size() == 0 && !disp.commaMode) {
				disp.showDisplay(false);
				return;
			}
		}
		if (num == Number.COMMA && !disp.commaMode
				&& disp.displayChar.size() == 0) {
			disp.onInputNumber(Number.ZERO);
		}

		disp.onInputNumber(num);
		disp.showDisplay(false);
	}

	@Override
	public void saveDisplayNumberToA() {
		a = disp.getNumber();
	}

	@Override
	public void setOp(Operation op) {
		this.op = op;
	}

	@Override
	public void changeState(State state) {
		this.state = state;
	}

	@Override
	public void showDisplay() {
		disp.showDisplay(false);
	}

	@Override
	public void clearA() {
		this.a = 0d;
	}

	@Override
	public void clearDisplay() {
		disp.clear();
		disp.showDisplay(false);
	}

	@Override
	public void clearB() {
		this.b = 0d;
	}

	@Override
	public Operation getOp() {
		return op;
	}

	@Override
	public void copyAtoB() {
		b = a;
	}

	@Override
	public double doOperation() {
		double result = op.eval(a, b);
		showDisplay(result);
		return result;
	}

	@Override
	public double getA() {
		return a;
	}

	@Override
	public void showDisplay(double d) {
		disp.setNumber(d);
		disp.showDisplay(true);
	}

	@Override
	public void saveDisplayNumberToB() {
		b = disp.getNumber();
	}

	@Override
	public void changeSign() {
		if (disp.getNumber() != 0d) {
			disp.minus = !disp.minus;
			disp.showDisplay(false);
		}
	}

}
