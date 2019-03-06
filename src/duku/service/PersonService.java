package duku.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import duku.dao.PersonDao;
import duku.entity.Person;
import duku.mybatis.SqlFactory;

public class PersonService {
	/**
	 * ÃÌº”
	 * @param ps
	 * @return
	 */
	public static int add(Person ps) {
		SqlSession session = SqlFactory.getSqlSession();
		try {
			PersonDao dao = session.getMapper(PersonDao.class);
			int rs = dao.add(ps);
			session.commit();
			return rs;		
		} finally {
			session.close();
		}		
	}
	/**
	 * ≤È‘É
	 * @return
	 */
	public List<Person> select(){
		SqlSession session = SqlFactory.getSqlSession();
		try {
			PersonDao dao = session.getMapper(PersonDao.class);		
			return dao.select();	
		} finally {
			session.close();
		}			
	}
	
	
	public static void main(String args[]) {
		PersonService ps = new PersonService();
		List<Person> list = ps.select();
		for(Person obj : list) {
			System.out.println(obj.getId());
			System.out.println(obj.getPassword());
			System.out.println(obj.getUsername());
		}
		
		
		
		
		
		
		
//		Person prs = new Person();
//		prs.setId(231);
//		prs.setPassword("123");
//		prs.setUsername("dsadsa");
//		ps.add(prs);
	}
}
