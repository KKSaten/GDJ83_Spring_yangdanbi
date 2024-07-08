package com.winter.app.member;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.DefaultTest;

//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" }) // 설정파일의 위치
public class MemberDAOTest extends DefaultTest {
	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void loginTest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("ydb");

		List<Map<String, Object>> ar = memberDAO.login(memberDTO);

		assertNotNull(ar);

	}

}
