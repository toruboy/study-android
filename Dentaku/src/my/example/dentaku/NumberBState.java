package my.example.dentaku;

public class NumberBState implements State {

	private static NumberBState instance = new NumberBState();

	private NumberBState() {
	}

	public static NumberBState getInstance() {
		return instance;
	}

	@Override
	public void onInputNumber(Context context, Number num) {
		context.addDisplayNumber(num);
	}

	@Override
	public void onInputOperation(Context context, Operation op) {
		try {
			context.saveDisplayNumberToB();
			context.doOperation();
			context.setOp(op);
			context.saveDisplayNumberToA();
			context.changeState(OperationState.getInstance());
		} catch (CalcException e) {
			context.setError();
			context.changeState(ErrorState.getInstance());
		}
	}

	@Override
	public void onInputEqual(Context context) {
		try {
			context.saveDisplayNumberToB();
			context.doOperation();
			context.changeState(ResultState.getInstance());
		} catch (CalcException e) {
			context.setError();
			context.changeState(ErrorState.getInstance());
		}
	}

	@Override
	public void onInputClear(Context context) {
		context.clearB();
		context.clearDisplay();
	}

	@Override
	public void onInputAllClear(Context context) {
		context.clearA();
		context.clearB();
		context.clearDisplay();
		context.changeState(NumberAState.getInstance());
	}

}
