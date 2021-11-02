package co.tofu.mybatis.comm;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	private static SqlSessionFactory sqlsessionfactory;

	public static SqlSessionFactory getInstance() {
		String resource = "mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sqlsessionfactory;
	}
}
