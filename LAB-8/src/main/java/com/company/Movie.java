package com.company;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movie {
    private int ID;
    private String name;
    private Date date_release;
    private int duration;
    private int score;

    public Date getDate_release(){
        return date_release;
    }
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public int getDuration(){
        return this.duration;
    }
    Movie(int id,String Name,Date date,int duration,int score){
        this.ID = id;
        this.name = Name;
        this.date_release = date;
        this.duration =duration;
        this.score = score;
    }
    public void findMovie(DatabaseHandler handler) throws SQLException{
        String sql="SELECT title FROM movies WHERE id=" + this.getID() + " AND title=" + "\""+this.getName() +"\"" + " ;";
        //System.out.println(sql);
        Statement stmt = handler.getConn().createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        boolean isThere=false;
        while(rs.next()) {
            isThere = true;
        }
        if(isThere){
            System.out.println("The movie has been found!");
        }
    }

}
