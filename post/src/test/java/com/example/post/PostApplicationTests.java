package com.example.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class PostApplicationTests {

	@Autowired
	private DataSource dataSource;

	@Test
	void h2DatabaseConnectionTest() throws Exception{
		try (Connection conn = dataSource.getConnection()){
			assertThat(conn).isNotNull();
			System.out.println("H2 DB 연결 성공");
		}
	}

}
