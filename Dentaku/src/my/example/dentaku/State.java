package my.example.dentaku;

public interface State {

	public void onInputNumber(Context context, Number num);

	public void onInputOperation(Context context, Operation op);

	public void onInputEqual(Context context);

	public void onInputClear(Context context);

	public void onInputAllClear(Context context);
}
