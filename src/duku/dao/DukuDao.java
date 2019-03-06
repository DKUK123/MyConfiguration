package duku.dao;

import java.util.List;

import duku.entity.Duku;

public interface DukuDao {
	//²éÑ¯
	int add(Duku dk);
	//Ìí¼Ó
	List<Duku> select();

}