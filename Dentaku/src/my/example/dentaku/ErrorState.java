package my.example.dentaku;

public class ErrorState implements State {

	private static ErrorState instance = new ErrorState();

	private ErrorState() {
	}

	public static ErrorState getInstance() {
		return instance;
	}

	@Override
	public void onInputNumber(Context context, Number num) {
	}

	@Override
	public void onInputOperation(Context context, Operation op) {
	}

	@Override
	public void onInputEqual(Context context) {
	}

	@Override
	public void onInputClear(Context context) {
	}

	@Override
	public void onInputAllClear(Context context) {
		context.clearA();
		context.clearB();
		context.clearDisplay();
		context.clearError();
		context.changeState(NumberAState.getInstance());
	}

}
