package jp.ne.alij.dentakulistview;

public class Calculator {

	// 入力中の文字列
	StringBuilder mInputNumber = new StringBuilder();
	// 入力中の演算子
	String mOperator;
	// 計算結果
	int mResult = 0;

	/***
	 * 数値か判定
	 */
	private boolean isNumber(String key){
		try {
			Integer.parseInt(key);
			return true;
		} catch (NumberFormatException e){
		}
		return false;
	}

	/***
	 * 演算か判定
	 */
	private boolean isSupportedOperator(String key){
		if (key.equals("+")){
			return true;
		} else if (key.equals("-")){
			return true;
		} else if (key.equals("*")){
			return true;
		} else if (key.equals("/")){
			return true;
		} else if (key.equals("=")){
			return true;
		}
		return false;
	}

	/***
	 * 演算を実行
	 */
	private void doCalculation(String ope){
		if (ope.equals("+")){
			mResult = mResult + Integer.parseInt(mInputNumber.toString());
		} else if (ope.equals("-")){
			mResult = mResult - Integer.parseInt(mInputNumber.toString());
		} else if (ope.equals("*")){
			mResult = mResult * Integer.parseInt(mInputNumber.toString());
		} else if (ope.equals("/")){
			mResult = mResult / Integer.parseInt(mInputNumber.toString());
		}
		mInputNumber = new StringBuilder();
	}

	/***
	 * 値をリセット
	 */
	public void reset(){
		mOperator = null;
		mResult = 0;
		mInputNumber = new StringBuilder();
	}

	/***
	 * 入力された文字を表示する
	 */
	public String putInput(String key){
		if (isNumber(key)){
			mInputNumber.append(key);
			return mInputNumber.toString();
		} else if (isSupportedOperator(key)){
			if (key.equals("=")){
				//演算が＝の場合、計算結果を返却
				if (mOperator != null){
					doCalculation(mOperator);
					mOperator = null;
				}
				return Integer.toString(mResult);
			}
			else {
				if(mOperator != null){
					// 前データを用いて演算
					doCalculation(mOperator);
					mOperator = null;
				} else if(mInputNumber.length() > 0){
					// 前データが無い場合は設定
					mResult = Integer.parseInt(mInputNumber.toString());
					mInputNumber = new StringBuilder();
				}
				mOperator = key;
				return mOperator;
			}

		} else {
			return null;
		}
	}
}
