package com.contact;

import com.contact.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Management {
    public void addnewContact(Contact contact) throws Exception{
        try {
            Connection conn = com.contact.util.DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO contacts(Name,Company, Email,Phone) VALUES (?,?,?,?)");
            pstmt.setString(1,contact.getName());
            pstmt.setString(2,contact.getCompany());
            pstmt.setString(3,contact.getEmail());
            pstmt.setString(4,contact.getPhone());

            int updated = pstmt.executeUpdate();
            if(updated > 0) {
                System.out.println("Insert Contact success!!!");
            }

            pstmt.close();
            conn.close();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Contact getContactByName(String name) throws Exception {

        Contact ct = null;

        try {
            Connection conn =  DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "SELECT * FROM contacts WHERE name = ?");
            pstmt.setString(1, name);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                ct = new Contact(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return ct;
    }




    public void getAllContact() throws Exception{
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT Id, Name,Company, Email, Phone FROM contacts");

            while(rs.next()) {
                Contact ct = new Contact(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

                System.out.println(ct.toString());
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
