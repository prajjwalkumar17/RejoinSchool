package com.rejointech.Rejoinschool.repository;

import com.rejointech.Rejoinschool.model.Contact;
import com.rejointech.Rejoinschool.rowmappers.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ContactRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public int saveContactMsg(Contact contact){
        String sql="INSERT INTO CONTACT_MSG (NAME,MOBILE_NUM,EMAIL,SUBJECT,MESSAGE,STATUS,"
                +"CREATED_AT,CREATED_BY) VALUES (?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),contact.getEmail(),
                contact.getSubject(),contact.getMessage(),contact.getStatus(),contact.getCreatedAt(),
                contact.getCreatedBy());
    }
    public  List<Contact> findMsgWithStatus(String status){
        String sql="SELECT * FROM CONTACT_MSG WHERE STATUS = ?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,status);
            }
        },new ContactRowMapper());
    }
}
