package com.example.task2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task2.model.Color;
import com.example.task2.model.ColorVO;
import com.example.task2.repository.ColorRepository;

@Service
public class ColorService {
	
	@Autowired
	ColorRepository crepo;
	
	public Color findColor(int id) {
		Color c = crepo.findById(id).get();
		return c;
	}

	
	public List<ColorVO> getAllColors(){
		List<Color> findAllColors = crepo.findAllColors();
		Map<Integer, Color> idMap= findAllColors.stream().collect(Collectors.toMap(Color::getId, java.util.function.Function.identity()));
		Map<Integer, Set<Integer>> mapped = findAllColors.stream().collect(Collectors.groupingBy(Color::getParent, Collectors.mapping(Color::getId, Collectors.toSet())));
		
		List<ColorVO> result = new ArrayList<>();
		for(Map.Entry<Integer, Set<Integer>>  map: mapped.entrySet()) {
			ColorVO cv = new ColorVO();
			
			Color color = idMap.get(map.getKey());
			if(color!=null) {
				cv.setName(color.getName());
				
			Set<Integer> subClasses = map.getValue();
			List<ColorVO> list = new ArrayList<>();
			for(Integer sub : subClasses) {
				
				ColorVO sb = new ColorVO();
				sb.setName(idMap.get(sub).getName());
				sb.setSubClasses(null);
				list.add(sb);
			}
			
			cv.setSubClasses(list);
			result.add(cv);
			}

			
		}
		
		return result;
	}
	

}
