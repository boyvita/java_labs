/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */

package com.javatunes.util;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;

public class ItemDAO {
    // connection to the database (assumed to be open)
    private Connection m_conn = null;
    
    //// PreparedStatement Lab ////
    //-- declare the PreparedStatement for searchByKeyword --//
    PreparedStatement pstmt;
    
    //// Update Lab ////
    //-- declare the PreparedStatement for create --//
    PreparedStatement stmt;
    
    // constructor
    public ItemDAO(Connection conn)
            throws SQLException {
        // store the connection
        m_conn = conn;
        
        //// PreparedStatement Lab ////
        //-- define the ?-SQL for searchByKeyword --//
        String sql = "select * from GUEST.ITEM WHERE TITLE LIKE ?";
        
        //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
        pstmt = m_conn.prepareStatement(sql);
        
        //// Update Lab ////
        //-- define the ?-SQL for create --//
        sql = "INSERT INTO Item VALUES (DEFAULT,?,?,?,?,?,1)";
        
        
        //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
        stmt = m_conn.prepareStatement(sql);
    }
    
    
    //// DAO Lab ////
    public MusicItem searchById(Long id)
            throws SQLException {
        // declare return value
        MusicItem result = null;
        
        // declare JDBC objects
        Statement stmt = null;
        
        //-- build the SQL statement --//
        String sql = "select * from GUEST.ITEM where ITEM_ID=" + id;
        
        try {
            //-- initialize the Statement object --//
            stmt = m_conn.createStatement();
            
            //-- execute the SQL statement, get a ResultSet back --//
            ResultSet rs = stmt.executeQuery(sql);
            
            //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
            //-- if ID not found, the return value remains null --//
            if (rs.next()) {
                String title = rs.getString("TITLE");
                String artist = rs.getString("ARTIST");
                Date releaseDate = rs.getDate(4);
                BigDecimal listPrice = rs.getBigDecimal(5);
                BigDecimal price = rs.getBigDecimal("PRICE");
                result = new MusicItem(id, title, artist, releaseDate, listPrice, price);
            }
        } finally {
            //-- close the Statement - this closes its ResultSet --//
            stmt.close();
        }
        
        // return the value object
        return result;
    }
    
    
    //// PreparedStaement Lab ////
    public Collection<MusicItem> searchByKeyword(String keyword)
            throws SQLException {
        // create storage for the results
        Collection<MusicItem> result = new ArrayList<MusicItem>();
        
        // create the %keyword% wildcard syntax used in SQL LIKE operator
        String wildcarded = "%" + keyword + "%";
        
        //-- set the ? parameters on the PreparedStatement --//
        pstmt.setString(1, wildcarded);
        
        //-- execute the PreparedStatement, get a ResultSet back --//
        ResultSet rs = pstmt.executeQuery();
        
        //-- iterate through the ResultSet, extracting data from each row and creating an ItemValue from it --//
        //-- add the ItemValue to the Collection via Collection's add method --//
        while (rs.next()) {
            Long id = rs.getLong("ITEM_ID");
            String title = rs.getString("TITLE");
            String artist = rs.getString("ARTIST");
            Date releaseDate = rs.getDate(4);
            BigDecimal listPrice = rs.getBigDecimal(5);
            BigDecimal price = rs.getBigDecimal("PRICE");
            MusicItem musicItem = new MusicItem(id, title, artist, releaseDate, listPrice, price);
            result.add(musicItem);
        }
        
        // return the Collection
        return result;
    }
    
    
    //// Update Lab ////
    public void create(MusicItem item)
            throws SQLException {
        // Use the following releaseDate value in the  prepared statement for setDate
        java.sql.Date releaseDate = new java.sql.Date(item.getReleaseDate().getTime());
        
        //-- set the ? parameters on the PreparedStatement --//
        stmt.setString(1, item.getTitle());
        stmt.setString(2, item.getArtist());
        stmt.setDate(3, releaseDate);
        stmt.setBigDecimal(4, item.getListPrice());
        stmt.setBigDecimal(5, item.getPrice());
        
        //-- execute the PreparedStatement - ignore the update count --//
        int rows = stmt.executeUpdate();
        System.out.println("Rows inserted: " + rows);
        m_conn.commit();
    }
    
    
    //// PreparedStatement and Update Labs ////
    public void close() {
        try {
            //// PreparedStatement Lab ////
            //-- close the PreparedStatement for searchByKeyword --//
            pstmt.close();
            
            //// Update Lab ////
            //-- close the PreparedStatement for create --//
            stmt.close();
            
        } catch (SQLException sqle) {
            JDBCUtilities.printSQLException(sqle);
        }
        
    }
}
