package com.company;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.sql.*;

public class Compulsory {

    public static void main(String[] args) throws SQLException {
        DatabaseHandler handler = new DatabaseHandler();
        handler.setConn("jdbc:sqlite:app.db","root",null);

        Movie movie = new Movie(1,"Thor-Ragnarok",Date.valueOf("2017-03-31"),2,10);
        Genre genre = new Genre(1,"Action");

        //handler.insertingMovie(movie);
        //handler.insertGenre(genre);

        genre.findGenre(handler);
        movie.findMovie(handler);
        handler.findGenreOfMovie(movie);
    }
}
