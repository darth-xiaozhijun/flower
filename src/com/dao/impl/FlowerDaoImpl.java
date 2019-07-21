package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.FlowerDao;
import com.pojo.Flower;
/**
 * 数据库访问层要有异常处理
 * @author Administrator
 *
 */
public class FlowerDaoImpl implements FlowerDao{

	@Override
	public List<Flower> selAll() {
		//jdk 1.7 开始后面泛型可以省略
		List<Flower> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			ps = conn.prepareStatement("select * from flower");
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(new Flower(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public int insFlower(Flower flower) {
		int  index= 0;
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssm?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true","root","123456");
			ps = conn.prepareStatement("insert into flower values(default,?,?,?)");
			ps.setObject(1, flower.getName());
			ps.setObject(2, flower.getPrice());
			ps.setObject(3, flower.getProduction());
			index = ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return index;
	}

}
