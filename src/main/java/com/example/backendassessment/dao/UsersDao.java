package com.example.backendassessment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.backendassessment.models.Tbl_Users;

@Component
public class UsersDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<Tbl_Users> rowMapper = (rs, rowNum) -> {
		Tbl_Users tbl_users = new Tbl_Users();
		tbl_users.setUserId(rs.getInt(1));
		tbl_users.setUserName(rs.getString(2));
		tbl_users.setPassword(rs.getString(3));
		tbl_users.setStatus(rs.getString(4));
		tbl_users.setCreatedDate(rs.getString(5));
		tbl_users.setUpdateDate(rs.getString(6));
		tbl_users.setLogin(rs.getString(7));
		tbl_users.setProfileId(rs.getInt(8));
		return tbl_users;
	};
	
	// Retrieve specific user
	public List<Tbl_Users> findById(int id) {
		String sql = "SELECT u.idUser, u.userName, u.password, "
				+ "u.status, u.createdDate, u.updateDate, "
				+ "u.login, p.idProfile FROM tbl_users u "
				+ "INNER JOIN tbl_profiles p ON u.idProfile = p.idProfile "
				+ "WHERE u.idUser = " + id;
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	// Retrieve all users
	public List<Tbl_Users> findAll() {
		String sql = "SELECT u.idUser, u.userName, u.password, "
				+ "u.status, u.createdDate, u.updateDate, "
				+ "u.login, p.idProfile FROM tbl_users u "
				+ "INNER JOIN tbl_profiles p ON u.idProfile = p.idProfile";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	// Create user
	public Integer save(Tbl_Users instance) {
		String sql = "INSERT INTO tbl_users (userName, password, status, createdDate, updateDate, login, idProfile)"
				+ "VALUES (?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { instance.getUserName(), instance.getPassword(), instance.getStatus(), instance.getCreatedDate(), instance.getUpdateDate(), instance.getLogin(), instance.getProfileId() });
	}
	
	// Update user
	public Integer update(Tbl_Users instance) {
		String sql = "UPDATE tbl_users SET userName = ?, password=?, status=?, createdDate=?, updateDate=?, login=?, idProfile=?"
				+ " WHERE idUser = ?";
		return jdbcTemplate.update(sql, new Object[] { instance.getUserName(), instance.getPassword(), instance.getStatus(), instance.getCreatedDate(), instance.getUpdateDate(), instance.getLogin(), instance.getProfileId(), instance.getUserId() });
	}
	
	// Delete user
	public Integer delete(int id) {
		return jdbcTemplate.update("DELETE FROM tbl_users WHERE idUser =" + id);
	}
}
