package com.sist.web.restcontroller;
//	front 연동 => vue : pinia
//						=> vue의 문법 => javascript
//	1. java 2. oracle 3. jsp (mvc) 4. spring
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class SeoulRestController {
	private final SeoulService sService;
	private String[] tables= {"","seoul_location","seoul_nature","seoul_shop"};
	@GetMapping("/seoul/list_vue/")
	public ResponseEntity<Map> seoul_list(@RequestParam("type")int type,@RequestParam("page")int page)
	{
		Map map = new HashMap();
		try {
			map.put("table_name", tables[type]);
			map.put("start", (page-1)*6);
			List<SeoulVO> list = sService.seoulListData(map);
			int totalPage= sService.seoulTotalPage(map);
			int startPage=((page-1)/10*10)+1;
			int endPage=((page-1)/10*10)+10;
			if (endPage>totalPage)
				endPage=totalPage;
			map = new HashMap();
			map.put("list", list);
			map.put("curPage", page);
			map.put("totalPage", totalPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("type", type);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
}
