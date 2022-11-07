package com.rejointech.Rejoinschool.rowmappers;

import com.rejointech.Rejoinschool.model.Contact;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {

    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact=new Contact();
        contact.setContactId(rs.getInt("CONTACT_ID"));
    }
}
