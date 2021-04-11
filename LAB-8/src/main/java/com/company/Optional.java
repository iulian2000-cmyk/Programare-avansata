package com.company;


import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.SQLException;

/**
 * https://data.world/ben-pfeifer/ben-pfeifer-movie-counts
 */
public class Optional {
    public static void main(String []args) throws SQLException,Exception {
        DatabaseHandler handler = new DatabaseHandler();
        handler.setConn("jdbc:sqlite:app.db", "root", null);
        //handler.populateDB_WithMovies("src/main/resources/Movie_Counts.csv");
        handler.populateDB_withActors("src/main/resources/performer-scores.csv");
    }
}
