package my.example.dentaku;

import android.widget.TextView;

public class StringDisplay extends AbstractDisplay {

	private TextView txt;

	public StringDisplay(TextView disp) {
		clear();
		this.txt = disp;
	}

	@Override
	public void showDisplay(boolean format) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < displayChar.size(); i++) {
			String str = displayChar.get(i);
			sb.append(str);
		}
		if (commaMode && decimalPlaces > 0) {
			sb.insert(sb.length() - decimalPlaces, ".");
		}
		if (sb.length() == 0) {
			sb.append("0");
		}

		if (minus) {
			sb.insert(0, "-");
		}
		if (format && commaMode && decimalPlaces > 0) {
			StringBuffer sbOut = new StringBuffer();
			boolean commaFlg = false;
			for (int i = sb.length() - 1; i >= 0; i--) {
				if (commaFlg) {
					sbOut.insert(0, sb.charAt(i));
				} else {
					if (sb.charAt(i) == '0') {
						continue;
					}
					commaFlg = true;
					if (sb.charAt(i) != '.') {
						sbOut.insert(0, sb.charAt(i));
					}
				}
			}
			sb = sbOut;
		}
		System.out.println(sb);
		txt.setText(sb);
	}

	@Override
	public void onInputNumber(Number num) {
		switch (num) {
		case DOUBLE_ZERO:
			addNumber(num);
			addNumber(num);
			break;
		case COMMA:
			if (!commaMode) {
				commaMode = true;
				decimalPlaces = 0;
			}
			break;
		default:
			addNumber(num);
			break;
		}
	}

	private void addNumber(Number num) {
		if (displayChar.size() < DISPLAY_DIGIT) {
			displayChar.push(num.getValue());
			if (commaMode) {
				decimalPlaces++;
			}
		}
	}

	@Override
	public void onInputBackspace() {
		if (displayChar.size() > 0) {
			displayChar.pop();
			if (commaMode) {
				if (decimalPlaces > 0) {
					decimalPlaces--;
				} else {
					commaMode = false;
				}
			}
		}
	}

	@Override
	public void clear() {
		commaMode = false;
		decimalPlaces = 0;
		minus = false;
		displayChar.clear();
	}

	@Override
	public double getNumber() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < displayChar.size(); i++) {
			String str = displayChar.get(i);
			sb.append(str);
		}
		if (commaMode && decimalPlaces > 0) {
			sb.insert(sb.length() - decimalPlaces, ".");
		}
		if (minus) {
			sb.insert(0, "-");
		}
		try {
			return Double.parseDouble(sb.toString());
		} catch (NumberFormatException e) {
			return 0d;
		}
	}

	@Override
	public void setNumber(double d) {
		this.clear();
		StringBuffer formatStr = new StringBuffer();
		formatStr.append("%.");
		formatStr.append(String.valueOf(DISPLAY_DIGIT));
		formatStr.append("f");
		String numberString = String.format(formatStr.toString(), Math.abs(d));

		for (int i = 0; i < numberString.length(); i++) {
			char chr = numberString.charAt(i);
			if (chr != '.') {
				displayChar.push(String.valueOf(chr));
				if (commaMode) {
					decimalPlaces++;
				}
			} else {
				commaMode = true;
			}

			if (displayChar.size() >= DISPLAY_DIGIT) {
				break;
			}
		}
		if (d < 0) {
			minus = true;
		}
	}

	@Override
	public void setError() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void clearError() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
