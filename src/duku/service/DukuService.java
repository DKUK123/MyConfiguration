package duku.service;

import java.util.List;

import duku.dao.DukuDao;
import duku.dao.imp.DukuDaoImp;
import duku.entity.Duku;

public class DukuService {
	
	DukuDao dao = new DukuDaoImp();
	public int add(Duku dk) {
		return dao.add(dk) ;		
	}
	public List<Duku> select() {
		return dao.select();
	}
}
