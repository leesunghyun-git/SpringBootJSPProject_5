package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.SeoulMapper;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
/*		***** 1번
 * 		DAO => table 1개 제어 => 순수하게 SQL문장만 수행
 * 			   ----------------------------------- Repository
 * 		Service => DAO 여러개 동시에 제어 / 추가 기능을 수행
 * 			| BI
 * 
 * 
 * 
 */
public class SeoulServiceImpl implements SeoulService{
	private final SeoulMapper sMapper;
	@Override
	public List<SeoulVO> seoulListData(Map map) {
		// TODO Auto-generated method stub
		return sMapper.seoulListData(map);
	}
	@Override
	public int seoulTotalPage(Map map) {
		// TODO Auto-generated method stub
		return sMapper.seoulTotalPage(map);
	}
}
