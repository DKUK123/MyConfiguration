package duku.dao;

import java.util.List;

import duku.entity.Person;

public interface PersonDao {
	
	int add(Person ps);
	//��ԃ
	List<Person> select();
}
