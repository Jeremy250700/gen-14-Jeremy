/**
 * 
 */
package com.prodemy.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.prodemy.model.Dosen;
import com.sun.tools.javac.util.List;

/**
 * @author Jeremy
 *
 */
public class DataDosenDao {
	static String sql = "insert into dosen(kode_dosen,nama_dosen)"+"values(?,?)";
	static String sql2= "update dosen set nama_dosen = ? where kode_dosen =?";
	static String sql3 = "select * from dosen order by kode_dosen asc";
	static String sql4="select * from dosen where kode_dosen=?";
	static String sql5 = "delete from dosen where kode_dosen=?";
	static String url = "jdbc:postgresql://localhost:5432/datakampus";
	static String username ="postgres";
	static String password ="jeremy250700";
	
	public Dosen addDosen(String kode_dosen,String nama_dosen){
		Dosen d = new Dosen();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st =con.prepareStatement(sql);
			st.setString(1, kode_dosen);
			st.setString(2, nama_dosen);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				d.setKode_dosen(rs.getString("kode_dosen"));
				d.setNama_dosen(rs.getString("nama_dosen"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return d;
	}
	
	public void updateDosen(String kode_dosen, String nama_dosen) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st =con.prepareStatement(sql2);
			st.setString(1, nama_dosen);
			st.setString(2, kode_dosen);
			st.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void deleteDosen(String kode_dosen) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st =con.prepareStatement(sql5);
			st.setString(1, kode_dosen);
			st.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static ArrayList<Dosen> getDosen(){
		ArrayList<Dosen> listData = new ArrayList<Dosen>();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st =con.prepareStatement(sql3);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Dosen d = new Dosen();
				d.setKode_dosen(rs.getString("kode_dosen"));
				d.setNama_dosen(rs.getString("nama_dosen"));
				listData.add(d);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listData;
	}
	public static Dosen getData(String kode_dosen) {
		Dosen d = new Dosen();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url,username,password);
			PreparedStatement st =con.prepareStatement(sql4);
			st.setString(1, kode_dosen);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				d.setKode_dosen(rs.getString("kode_dosen"));
				d.setNama_dosen(rs.getString("nama_dosen"));
			}
			rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return d;
	}
		
	}
