package com.company;




import com.opencsv.CSVReader;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.FileReader;
import java.sql.*;
import java.util.Vector;
import java.sql.Date;
import java.util.concurrent.ThreadLocalRandom;



public class DatabaseHandler {
    private static  Connection conn;
    private static PreparedStatement stmt;
    private static String SQL_interogation;
    private static ResultSet result;

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public PreparedStatement getStmt(){
        return stmt;
    }
    public Connection getConn(){
        return conn;
    }
    public void setConn(String url,String user,String password ) throws SQLException
    {
        this.conn = DriverManager.getConnection(url,user,password);
    }
    public static void insertingMovie(Movie movie) throws  SQLException
    {
        String sql = "INSERT INTO movies VALUES (?,?,?,?,?);";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,String.valueOf(movie.getID()));
        stmt.setString(2,movie.getName());
        stmt.setString(3,String.valueOf(movie.getDate_release()));
        stmt.setString(4,String.valueOf(movie.getDuration()));
        stmt.setString(5,String.valueOf(movie.getScore()));
        stmt.execute();
    }
    public static void insertGenre(Genre genre) throws SQLException{
        String sql = "INSERT INTO genres VALUES ( ?,?);";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,String.valueOf(genre.getID()));
        stmt.setString(2,genre.getName());
        stmt.execute();
    }
    public void findGenreOfMovie(Movie movie) throws SQLException{
        String sql = "SELECT genres.name_genre FROM movies JOIN associative_table ON associative_table.id_movie=movies.id JOIN genres ON genres.id=associative_table.id_genre WHERE movies.title=\"" + movie.getName() + "\" ; ";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("The genre of the movie " + movie.getName() + "  is "  + rs.getString(1) + " . ");
    }
    public static void populateDB_WithMovies(String file) throws Exception
    {
        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
        Vector<Movie> movieVector = new Vector<Movie>();
        int line = 1;
        while ((nextRecord = csvReader.readNext()) != null) {
            if (line != 1 && nextRecord[0].matches("-?\\d+(\\.\\d+)?") && nextRecord[3].matches("-?\\d+(\\.\\d+)?")) {
                 int id = Integer.parseInt(nextRecord[0]);
                 String title = nextRecord[2];
                 Date date = Date.valueOf(nextRecord[3]+"-01-01");
                 int duration = ThreadLocalRandom.current().nextInt(1, 3);
                 int score = ThreadLocalRandom.current().nextInt(1,10);
                 Movie movie = new Movie(id,title,date,duration,score);
                 movieVector.add(movie);
            }else{
                line++;
            }
        }
        for(Movie movie: movieVector){
                insertingMovie(movie);
        }
    }
    public static void insertActor(Actors actor) throws SQLException{
        String sql = "INSERT INTO actors VALUES ( ?,?,?);";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1,String.valueOf(actor.getId()));
        stmt.setString(2,actor.getName());
        stmt.setString(3,String.valueOf(actor.getId_movie()));
        stmt.execute();
    }



    public static void populateDB_withActors(String file) throws Exception
    {
        FileReader filereader = new FileReader(file);
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
        Vector <Actors> actors = new Vector<Actors>();

        int id_actor=1;
        int line = 1;
        while ((nextRecord = csvReader.readNext()) != null) {
            if (line != 1) {
                 String name = nextRecord[0];
                 int id_movie = ThreadLocalRandom.current().nextInt(1,100);
                 Actors actor = new Actors(name,id_actor,id_movie);
                 actors.add(actor);
                 id_actor++;
            }else{
                line++;
            }
        }
        for(Actors actor : actors)
        {
           insertActor(actor);
        }
    }
}

