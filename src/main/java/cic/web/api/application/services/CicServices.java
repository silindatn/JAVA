package cic.web.api.application.services;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cic.web.api.application.DbConnection;
import cic.web.api.application.model.Cic;
import cic.web.api.application.model.Email;
import cic.web.api.application.model.RequestBodyModel;


@Service
public class CicServices {

    public static Email getEmails() throws SQLException{
    	Connection connection = DbConnection.getDBConnection();
        PreparedStatement selectPreparedStatement = null;
        Email email =  new Email();

        String SelectQuery = "select * from CIC";

        try {
        	selectPreparedStatement = connection.prepareStatement(SelectQuery);
        	ResultSet rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
            	email.setEmailAddress(rs.getString("emailAddress"));
            	email.setEmailId(rs.getInt("emailId"));
            	email.setEmailName(rs.getString("emailName"));
                System.out.println("EmailId " + rs.getInt("EmailId"));
            }
            selectPreparedStatement.close();
            connection.commit();
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        
        return email;
    }
    public static List<Cic> getCicAll() throws SQLException{
    	Connection connection = DbConnection.getDBConnection();
        PreparedStatement selectPreparedStatement = null;
        List<Cic> list = new ArrayList<Cic>();
        String SelectQuery = "select * from CIC";

        try {
        	int x = 0;
            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
//            Array arr = new Array();
            while (rs.next()) {
                Cic cic = new Cic();
            	cic.setBody(rs.getString("body"));
            	cic.setCicId(rs.getInt("cicId"));
            	cic.setCicTimestamp(rs.getDate("cicTimestamp"));
            	cic.setCicType(rs.getString("cicType"));
            	cic.setSourceSystem(rs.getString("sourceSystem"));
            	cic.setSubject(rs.getString("subject"));
            	list.add(x, cic);
            	x+=1;
                System.out.println("cicId " + rs.getInt("cicId"));
            }
            selectPreparedStatement.close();
            connection.commit();
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        
        return list;
    }
    public static Cic getCic(long cicid) throws SQLException{
    	Connection connection = DbConnection.getDBConnection();
        PreparedStatement selectPreparedStatement = null;
        Cic cic = new Cic();
        
        String SelectQuery = "select * from CIC where CicId=" + cicid;

        try {
        	
            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            ResultSet rs = selectPreparedStatement.executeQuery();
            while (rs.next()) {
            	cic.setBody(rs.getString("body"));
            	cic.setCicId(rs.getInt("cicId"));
            	cic.setCicTimestamp(rs.getDate("cicTimestamp"));
            	cic.setCicType(rs.getString("cicType"));
            	cic.setSourceSystem(rs.getString("sourceSystem"));
            	cic.setSubject(rs.getString("subject"));
                System.out.println("EmailId " + rs.getInt("EmailId"));
            }
            selectPreparedStatement.close();
            connection.commit();
            
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        
        return cic;
    }
    private static ResultSet insertEmail(Email email) throws SQLException {
        Connection connection = DbConnection.getDBConnection();
        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;

        String CreateQuery = "CREATE TABLE EMAIL(EmailId int primary key, EmailName varchar(255), EmailAddress varchar(255))";
        String InsertQuery = "INSERT INTO EMAIL" + "(EmailId, EmailName, EmailAddress) values" + "(?,?,?)";
        String SelectQuery = "select * from EMAIL where EmailId = " + email.getEmailId();

        try {
            connection.setAutoCommit(false);

            try {
	            createPreparedStatement = connection.prepareStatement(CreateQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Exception Message " + e.getLocalizedMessage());
            }

            insertPreparedStatement = connection.prepareStatement(InsertQuery);
            insertPreparedStatement.setLong(1, email.getEmailId());
            insertPreparedStatement.setString(2, email.getEmailName());
            insertPreparedStatement.setString(3, email.getEmailAddress());
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();

            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
            while (rs.next()) {
                System.out.println("EmailId " + rs.getInt("EmailId"));
            }
            selectPreparedStatement.close();
           
            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return rs;
    }
    public static Cic insertCic(long EmailId,String EmailName,String EmailAddress,long CicId,String CicType,String Subject,String Body,String SourceSystem) throws SQLException {
        Connection connection = DbConnection.getDBConnection();
        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;
        PreparedStatement selectPreparedStatement = null;
        ResultSet rs = null;
        Cic cic = new Cic();
        Email email = new Email();

        String CreateQuery = "CREATE TABLE CIC(CicId int primary key, CicType varchar(255), Subject varchar(255), Body varchar(255), SourceSystem varchar(255), CicTimestamp Date)";
        String InsertQuery = "INSERT INTO CIC" + "(CicId, CicType, Subject, Body,SourceSystem, CicTimestamp) values" + "(?,?,?,?,?,?)";
        String SelectQuery = "select * from CIC where CicId=" + CicId;

        try {
            connection.setAutoCommit(false);

            try {
	            createPreparedStatement = connection.prepareStatement(CreateQuery);
	            createPreparedStatement.executeUpdate();
	            createPreparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Exception Message " + e.getLocalizedMessage());
            }

            insertPreparedStatement = connection.prepareStatement(InsertQuery);
            insertPreparedStatement.setLong(1, CicId);
            insertPreparedStatement.setString(2, CicType);
            insertPreparedStatement.setString(3, Subject);
            insertPreparedStatement.setString(4, Body);
            insertPreparedStatement.setString(5, SourceSystem);
            insertPreparedStatement.setDate(6, new Date(cic.getCicTimestamp()));
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();
            email.setEmailAddress(EmailAddress);
            email.setEmailId(EmailId);
            email.setEmailName(EmailName);
            ResultSet rsEmail = insertEmail(email);

            selectPreparedStatement = connection.prepareStatement(SelectQuery);
            rs = selectPreparedStatement.executeQuery();
            System.out.println("H2 In-Memory Database inserted through PreparedStatement");
            while (rs.next()) {
            	cic.setBody(rs.getString("body"));
            	cic.setCicId(rs.getInt("cicId"));
            	cic.setCicTimestamp(rs.getDate("cicTimestamp"));
            	cic.setCicType(rs.getString("cicType"));
            	cic.setSourceSystem(rs.getString("sourceSystem"));
            	cic.setSubject(rs.getString("subject"));
                System.out.println("CicId " + rs.getInt("CicId"));
            }
            selectPreparedStatement.close();

            connection.commit();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return cic;
    }
}