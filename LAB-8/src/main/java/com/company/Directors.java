package com.company;

class Directors {
    private int id;
    private String name;
    private int id_movie;

    Directors(String Name,int id,int id_movie){
        this.setId(id);
        this.setName(Name);
        this.setId_movie(id_movie);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(int id){
        this.id = id;
    }

    public void setId_movie(int id_movie) {
        this.id_movie = id_movie;
    }

    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }

    public int getId_movie() {
        return id_movie;
    }
}
