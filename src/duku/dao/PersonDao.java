package duku.dao;

import java.util.List;

import duku.entity.Person;

public interface PersonDao {
	
	int add(Person ps);
	//≤È‘É
	List<Person> select();
}
