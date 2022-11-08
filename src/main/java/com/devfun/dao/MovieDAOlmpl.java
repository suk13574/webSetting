package com.devfun.dao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.devfun.vo.MovieVO;

@Repository
public class MovieDAOlmpl implements MovieDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String Namespace = "com.devfun.mybatis.sql.test";

	@Override
	public List<MovieVO> selectMove() throws Exception {
		
		return sqlSession.selectList(Namespace + ".selectMovie");
	}

}
