package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface SeoulMapper {
	/*
	 *  	<select id="seoulListData" resultType="com.sist.web.vo.SeoulVO" parameterType="hashmap">
 		SELECT no,title,poster,address,hit
 		FROM ${table_name}
 		ORDER BY no ASC
 		OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY
 	</select>
 	<select id="seoulTotalPage" resultType="int" parameterType="hashmap">
 		SELECT CEIL(COUNT(*)/12.0)
 		FROM ${table_name}
 	</select>
	 * 
	 */
	List<SeoulVO> seoulListData(Map map);
	int seoulTotalPage(Map map);
	// public abstract
	// 1.8 => default 메소드 => 구현 메소드 => 추상클래스 대체
	// 공통적으로 적용되는 기능 설정
	
}
