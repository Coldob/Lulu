package com.proto.data;

import org.bukkit.entity.Player;
import java.io.File;
import java.sql.*;

public class dataaccess {
    public static void makeDatabase(){
        String path = "plugins/Lulu";
        File file = new File(path);

        file.mkdirs();
        String url = "jdbc:sqlite:plugins/Lulu/data.db";
        try(Connection conn = DriverManager.getConnection(url)) {
            if (conn != null){
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createTheTable(){
        String url = "jdbc:sqlite:plugins/Lulu/data.db";
        String sql = "Create TABLE IF NOT EXISTS Portals(players TEXT PRIMARY KEY, Portal1 INTEGER NOT NULL, Portal2 INTEGER NOT NULL, Portal3 INTEGER NOT NULL);";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void FPComplete(Player name){
        String url = "jdbc:sqlite:plugins/Lulu/data.db";
        String sname = name.getName();
        String sql = "INSERT INTO Portals VALUES('"+sname+"',1,0,0);";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void SPComplete(Player name){
        String url = "jdbc:sqlite:plugins/Lulu/data.db";
        String sname = name.getName();
        String sql = "UPDATE Portals set portal2  = 1 WHERE players = '"+sname+"'";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void tPComplete(Player name){
        String url = "jdbc:sqlite:plugins/Lulu/data.db";
        String sname = name.getName();
        String sql = "UPDATE Portals set portal3  = 1 WHERE players = '"+sname+"'";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int SQLSearch(String sql){
        String url = "jdbc:sqlite:plugins/Lulu/data.db";
        try(Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            int value = rs.getInt(1);
            return(value);
        } catch (SQLException e) {
            return 0;
        }
    }
}
