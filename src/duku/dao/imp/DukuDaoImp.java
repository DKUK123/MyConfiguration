package duku.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import duku.dao.BaseDao;
import duku.dao.DukuDao;
import duku.entity.Duku;

public class DukuDaoImp extends BaseDao implements DukuDao {

	PreparedStatement pre = null;
	ResultSet rs = null;
	Connection conn = null;
	
	/* (non-Javadoc)
	 * @see duku.dao.imp.DukuDao#add(duku.entity.Duku)
	 */
	@Override
	public int add(Duku dk) {
		
		conn = super.getConnection();
		
		try {
			String sql = "INSERT INTO `person`" + "(id,username,password,)" + "VALUES (?,?,?);";
			pre = conn.prepareStatement(sql);
			pre.setInt(1, dk.getId());
			pre.setString(2, dk.getUsername());
			pre.setString(3, dk.getPassword());
			return pre.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			super.closePreparedStatement(pre);
			super.closeConnection(conn);
		}
		return -1; 
	}

	/* (non-Javadoc)
	 * @see duku.dao.imp.DukuDao#select()
	 */
	@Override
	public List<Duku> select() {
		conn = super.getConnection();
		
		try {
			String sql = "select * from person";
			
			pre = conn.prepareStatement(sql);
			
			rs = pre.executeQuery();
			
			List<Duku> list = new ArrayList<Duku>();
			
			Duku dk;
			while(rs.next()) {
				dk = new Duku();
				
				dk.setId(rs.getInt("id"));
				dk.setUsername(rs.getString("username"));
				dk.setPassword(rs.getString("password"));
				
				list.add(dk);			
				}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closePreparedStatement(pre);
			super.closeResultSet(rs);
			super.closeConnection(conn);
		}		
		return null;		
	}
	
	
	public int add2(Duku dk) {
		conn = super.getConnection();		
		try {
			String sql="INSERT INTO `person`(id,username,password)  VALUES (?,?,?)";
			pre=conn.prepareStatement(sql);
			pre.setInt(1, dk.getId());
			pre.setString(2, dk.getUsername());
			pre.setString(3, dk.getPassword());
			return pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			super.closeConnection(conn);
			super.closePreparedStatement(pre);
		}
		return 0;		
	}
	
	
	public List<Duku> select2(){
		conn = super.getConnection();
		String sql = "select * from person";
		
		return null;		
	}
}
