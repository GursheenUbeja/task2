package com.example.task2.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.task2.model.Color;
import com.example.task2.model.ColorVO;
import com.example.task2.service.ColorService;
import com.example.task2.utility.JSONUtils;

@RestController
@RequestMapping("/color")
public class ColorController {

	@Autowired
	private ColorService cservice;

	@GetMapping("/getColor")
	public String findColor(@RequestParam Integer id) {
		Color cModel = cservice.findColor(id);
		JSONObject obj = JSONUtils.getJSONObject(cModel);
		return obj.toString();
	}

	@GetMapping("/getAll")
	public String getAll() {
		List<ColorVO> cList = cservice.getAllColors();
		JSONArray obj = JSONUtils.getJSON(cList);
		return obj.toString();
	}

}
