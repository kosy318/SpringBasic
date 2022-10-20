package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.EmpDto;

public interface MybatisService {
	
	EmpDto empDetail(int employeeId); // 1건 상세
	List<EmpDto> empList(); // 전체 목록
	int empInsert(EmpDto dto); // 등록
	int empUpdate(EmpDto dto); // 수정( employeeId 기준 )
	int empDelete(int employeeId); // 삭제( employeeId 기준)
	
}
