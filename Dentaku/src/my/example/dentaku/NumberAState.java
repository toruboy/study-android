package my.example.dentaku;

public class NumberAState implements State {

	private static NumberAState instance = new NumberAState();

	private NumberAState() {
	}

	public static NumberAState getInstance() {
		return instance;
	}

	@Override
	public void onInputNumber(Context context, Number num) {
		context.addDisplayNumber(num);
	}

	@Override
	public void onInputOperation(Context context, Operation op) {
		context.saveDisplayNumberToA();
		context.setOp(op);
		context.changeState(OperationState.getInstance());
	}

	@Override
	public void onInputEqual(Context context) {
		context.saveDisplayNumberToA();
		context.showDisplay();
		context.changeState(ResultState.getInstance());

	}

	@Override
	public void onInputClear(Context context) {
		context.clearA();
		context.clearDisplay();
	}

	@Override
	public void onInputAllClear(Context context) {
		context.clearA();
		context.clearB();
		context.clearDisplay();

	}

}
