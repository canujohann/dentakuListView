package jp.ne.alij.dentakulistview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class MyPreferences {

	/* 画面取得 */
	public static SharedPreferences getContext(Context context){
		return PreferenceManager.getDefaultSharedPreferences(context);
	}

	/* データ保存 */
	public static void addPreferences(Context context, String val){

		SharedPreferences sp  = getContext(context);

		Editor editor = sp.edit();
		editor.putString("calList", val).commit();
	}

	/* データ削除 */
	public static void delPreferences(Context context){

		SharedPreferences sp  = getContext(context);

		Editor editor = sp.edit();
		editor.clear().commit();
	}

}
