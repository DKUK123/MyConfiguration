package duku.dao;

import java.util.List;

import duku.entity.Duku;

public interface DukuDao {
	//��ѯ
	int add(Duku dk);
	//���
	List<Duku> select();

}