package com.revature.Videoservicespring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.Videoservicespring.exception.DBException;
import com.revature.Videoservicespring.model.Video;
import com.revature.Videoservicespring.util.MessageConstants;

public class VideoDAOImp implements VideoDAO{

	@Autowired
	private DataSource datasource;
	public Boolean addVideo(Video video)throws DBException, SQLException{
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con=datasource.getConnection();
			String sql="insert into organization_details(name,alias_name,type,salesforce_id,"
					+ "enable_user_verification,sign_up_page,theme_id)values(?,?,?,?,?,?,?,?)";
		} catch (SQLException e) {
			throw new DBException(MessageConstants.video_exist);
		}
		finally {
			con.close();
		}
		return null;
}
}
