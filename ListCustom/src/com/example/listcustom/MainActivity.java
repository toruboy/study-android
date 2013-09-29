package com.example.listcustom;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// リストに表示するデータを準備
		String titles[] = { "革命のエチュード", "G線上のアリア", "シャコンヌ", "夜の女王のアリア" };
		String tags[] = { "ピアノ", "バイオリン", "チェロ", "声楽" };
		String descs[] = { "ピアノの詩人と言われたショパンの代表的なピアノ曲です。",
				"バッハの作品。バイオリンのG線のみで演奏できることからこのタイトルで親しまれています。",
				"バッハの作品。パルティータ第2番の終曲です。", "モーツァルト作曲のオペラ「魔笛」の中のアリアです。" };
		ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < titles.length; i++) {
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("title", titles[i]);
			item.put("tag", tags[i]);
			item.put("desc", descs[i]);
			data.add(item);
		}

		SimpleAdapter adapter = new SimpleAdapter(this, data,
				R.layout.list_item, new String[] { "title", "tag", "desc" },
				new int[] { R.id.title, R.id.tag, R.id.desc });
		ListView list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
