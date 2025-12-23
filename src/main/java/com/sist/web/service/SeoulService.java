package com.sist.web.service;

import java.util.List;
import java.util.Map;

import com.sist.web.vo.SeoulVO;

public interface SeoulService {
	List<SeoulVO> seoulListData(Map map);
	int seoulTotalPage(Map map);
}
