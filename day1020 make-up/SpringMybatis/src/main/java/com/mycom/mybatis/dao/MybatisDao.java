package com.mycom.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface MybatisDao {
	
	EmpDto empDetail(int employeeId); // 1건 상세
	List<EmpDto> empList(); // 전체 목록
	int empInsert(EmpDto dto); // 등록
	int empUpdate(EmpDto dto); // 수정( employeeId 기준 )
	int empDelete(int employeeId); // 삭제( employeeId 기준)
	
}

// MyBatis 사용하지 않을 시
// public class MybatisDaoImpl implements MybaatisDao
// method 생성 및 각각 필요한 .SQL 문 작성 및 실행 결과 리턴하는 클래스 만들었음

// 위 클래스를 생성하지 않는다.