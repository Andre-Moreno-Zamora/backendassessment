package com.example.backendassessment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.backendassessment.models.Tbl_Profiles;

@Component
public class ProfilesDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<Tbl_Profiles> rowMapper = (rs, rowNum) -> {
		Tbl_Profiles tbl_profiles = new Tbl_Profiles();
		tbl_profiles.setProfileId(rs.getInt(1));
		tbl_profiles.setProfile(rs.getString(2));
		return tbl_profiles;
	};
	
	// Retrieve specific profile
	public List<Tbl_Profiles> findById(int id) {
		String sql = "SELECT idProfile, profile "
				+ "FROM tbl_profiles "
				+ "WHERE idProfile = " + id;
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	// Retrieve all profiles
	public List<Tbl_Profiles> findAll(){
		String sql = "SELECT idProfile, profile "
				+ "FROM tbl_profiles";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	// Create profile
	public Integer save(Tbl_Profiles instance) {
		String sql = "INSERT INTO tbl_profiles (profile)"
				+ "VALUES (?)";
		return jdbcTemplate.update(sql, new Object[] { instance.getProfile() });
	}
	
	// Update profile
	public Integer update(Tbl_Profiles instance) {
		String sql = "UPDATE tbl_profiles SET profile=?"
				+ " WHERE idProfile = ?";
		return jdbcTemplate.update(sql, new Object[] { instance.getProfile(), instance.getProfileId() });
	}
	
	// Delete profile
	public Integer delete(int id) {
		return jdbcTemplate.update("DELETE FROM tbl_profiles WHERE idProfile = " + id);
	}
	
}
