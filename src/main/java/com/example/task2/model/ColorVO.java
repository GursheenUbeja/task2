package com.example.task2.model;

import java.util.List;

public class ColorVO {

	private String name;
	private List<ColorVO> subClasses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ColorVO> getSubClasses() {
		return subClasses;
	}

	public void setSubClasses(List<ColorVO> subClasses) {
		this.subClasses = subClasses;
	}

}
