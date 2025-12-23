package com.sist.web.restcontroller;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BusanRestController {
	private final BusanService bService;
	
	@GetMapping("/busan/list_vue/")
	public ResponseEntity<Map> busan_list(@RequestParam("type")int type, @RequestParam("page")int page)
	{
		Map map=new HashMap();
		try {
			map.put("type", type);
			map.put("start", (page-1)*6);
			List<BusanVO> list = bService.busanListData(map);
			int totalPage=bService.busanTotalPage(map);
			map = new HashMap();
			int startPage=((page-1)/10*10)+1;
			int endPage=((page-1)/10*10)+10;
			if(endPage>totalPage)
				endPage=totalPage;
			map.put("totalPage", totalPage);
			map.put("curPage", page);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("list", list);
			map.put("type", type);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<Map>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
