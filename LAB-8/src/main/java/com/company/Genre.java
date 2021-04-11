package com.company;



import javax.xml.crypto.Data;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Genre {
    private int ID;
    private String name;

    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }

    Genre(int id,String name){
        this.setID(id);
        this.setName(name);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setID(int id){
        this.ID = id;
    }
    public void findGenre(DatabaseHandler handler) throws SQLException{
        String sql="SELECT * FROM genres WHERE id=" + this.getID() + " AND name_genre=" + "\"" + this.getName() + "\"" + ";" ;
        //System.out.println(sql);
        Statement stmt = handler.getConn().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean isThere = false;
        while(rs.next()) {
            isThere = true;
        }
        if(isThere){
            System.out.println("The genre has been found!");
        }
    }
}

