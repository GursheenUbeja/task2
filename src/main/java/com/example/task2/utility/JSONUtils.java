package com.example.task2.utility;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.task2.model.Color;
import com.example.task2.model.ColorVO;

public class JSONUtils {

	public static JSONArray getJSON(List<ColorVO> objects) {
		JSONArray finalArr = new JSONArray();

		objects.stream().forEach(o -> {
			JSONObject jObj = new JSONObject();
			JSONArray jArr = new JSONArray();
			List<ColorVO> subClasses = o.getSubClasses();
			for (ColorVO cv : subClasses) {
				JSONObject j = new JSONObject();
				try {
					j.put("name", cv.getName());
					jArr.put(j);
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}

			try {
				jObj.put("name", o.getName());
				jObj.put("SubClasses", jArr);
				finalArr.put(jObj);

			} catch (JSONException e) {
				e.printStackTrace();
			}

		});	
		return finalArr;

	}

	public static JSONObject getJSONObject(Color c) {

		JSONObject obj = new JSONObject();
		try {
			obj.put("parent", c.getParent());
			obj.put("name", c.getName());
			obj.put("color", c.getColor());
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return obj;
	}

}
