package my.example.dentaku;

import java.util.Stack;

public abstract class AbstractDisplay {

	protected final int DISPLAY_DIGIT = 12;
	protected final Stack<String> displayChar = new Stack<String>();
	protected boolean commaMode;
	protected int decimalPlaces;
	protected boolean minus;

	public abstract void showDisplay(boolean format);

	public abstract void onInputNumber(Number num);

	public abstract void onInputBackspace();

	public abstract void clear();

	public abstract double getNumber();

	public abstract void setNumber(double d);

	public abstract void setError();

	public abstract void clearError();

	public boolean isOverflow(double d) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < DISPLAY_DIGIT; i++) {
			sb.append("9");
		}
		double max = Double.parseDouble(sb.toString());
		if (d > max) {
			return true;
		}
		return false;
	}

	public String toString() {
		return displayChar.toString();
	}
}
