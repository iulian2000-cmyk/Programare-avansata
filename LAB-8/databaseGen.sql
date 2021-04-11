

CREATE TABLE movies(
    id INTEGER NOT NULL,
    title TEXT NOT NULL,
    release_date DATE NOT NULL,
    duration NUMBER(4,2) NOT NULL,
    score NUMBER(4,2) NOT NULL,
    PRIMARY KEY(id) 
);

CREATE TABLE genres(
    id INTEGER NOT NULL,
    name_genre TEXT NOT NULL,
    PRIMARY KEY(id)
    );
    
 CREATE TABLE associative_table(
      id_movie INTEGER NOT NULL,
      id_genre INTEGER NOT NULL
  );
       
  
 CREATE TABLE actors(
      id_actor INTEGER NOT NULL,
      name TEXT NOT NULL,
      id_movie INTEGER NOT NULL,
      PRIMARY KEY(id_actor),
      FOREIGN KEY(id_movie) REFERENCES movies(id_movie)
);

 CREATE TABLE directors(
    id_director INTEGER NOT NULL,
    name TEXT NOT NULL,
    id_movie INTEGER NOT NULL,
    PRIMARY KEY (id_director),
    FOREIGN KEY (id_movie) REFERENCES movies(id_movie)
);


