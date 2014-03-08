package my.example.dentaku;

public class ResultState implements State {

	private static ResultState instance = new ResultState();

	private ResultState() {
	}

	public static ResultState getInstance(){
		return instance;
	}

	@Override
	public void onInputNumber(Context context, Number num) {
		context.clearDisplay();
		context.addDisplayNumber(num);
		context.changeState(NumberAState.getInstance());
	}

	@Override
	public void onInputOperation(Context context, Operation op) {
		context.saveDisplayNumberToA();
		context.setOp(op);
		context.changeState(OperationState.getInstance());
	}

	@Override
	public void onInputEqual(Context context) {
	}

	@Override
	public void onInputClear(Context context) {
		context.clearA();
		context.clearB();
		context.clearDisplay();
		context.changeState(NumberAState.getInstance());
	}

	@Override
	public void onInputAllClear(Context context) {
		context.clearA();
		context.clearB();
		context.clearDisplay();
		context.changeState(NumberAState.getInstance());
	}

}
