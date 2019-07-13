package com.javatunes.util;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class ItemDAOMain {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB","GUEST","password");
            ItemDAO dao = new ItemDAO(conn);

            System.out.println("1 query:");
            System.out.println(dao.searchById(1L).toString());
            System.out.println();
            System.out.println("2 query:");
            System.out.println(dao.searchById(100L));

            System.out.println();
            System.out.println("3 query:");
            for(MusicItem x: dao.searchByKeyword("of"))
                System.out.println(x.toString());

            System.out.println();
            System.out.println("4 query:");
            for(MusicItem x: dao.searchByKeyword("Gay"))
                System.out.println(x);


            System.out.println();
            System.out.println("5 query:");
            MusicItem mi = new MusicItem( 22L,"t1","T2",new Date(),new BigDecimal(111),new BigDecimal(11));
            dao.create(mi);


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException ignored) { }
        }
    }
}
