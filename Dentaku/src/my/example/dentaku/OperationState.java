package my.example.dentaku;

public class OperationState implements State {

	private static OperationState instance = new OperationState();

	private OperationState() {
	}

	public static OperationState getInstance() {
		return instance;
	}

	@Override
	public void onInputNumber(Context context, Number num) {
		context.clearDisplay();
		context.addDisplayNumber(num);
		context.changeState(NumberBState.getInstance());
	}

	@Override
	public void onInputOperation(Context context, Operation op) {
		context.setOp(op);
	}

	@Override
	public void onInputEqual(Context context) {
		try {
			switch (context.getOp()) {
			case DIVIDE:
			case MULTIPLY:
				context.copyAtoB();
				context.doOperation();
				context.changeState(ResultState.getInstance());
				break;
			case PLUS:
			case MINUS:
				context.showDisplay(context.getA());
				context.changeState(ResultState.getInstance());
				break;
			default:
				break;
			}
		} catch (CalcException e) {
			context.setError();
			context.changeState(ErrorState.getInstance());
		}
	}

	@Override
	public void onInputClear(Context context) {
		context.clearA();
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
