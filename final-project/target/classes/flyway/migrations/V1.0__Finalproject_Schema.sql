DROP TABLE IF EXISTS libraries;
DROP TABLE IF EXISTS readers_books;
DROP TABLE IF EXISTS readers;
DROP TABLE IF EXISTS books;

CREATE TABLE readers (
  readernumber_pk int unsigned NOT NULL AUTO_INCREMENT,
  reader_id varchar(40) NOT NULL,
  first_name varchar(30) NOT NULL, 
  last_name varchar(50) NOT NULL,
  phone varchar(15),
  email varchar(32),
  PRIMARY KEY (readernumber_pk)
);

CREATE TABLE books (
  booknumber_pk int unsigned AUTO_INCREMENT,
  isbn varchar(30) NOT NULL,
  genre enum('ADVENTURE', 'COMP_FORENSICS', 'CYBER_SEC', 'EDUCATION', 'FICTION', 'JAVA', 'MANAGEMENT', 'RECIPES', 'SCIFI', 'SPIRITUAL', 'THRILLER') NOT NULL,
  title varchar(128) NOT NULL,
  book_authors varchar(128) NOT NULL,
  notes text(58),
  PRIMARY KEY (booknumber_pk)
);

CREATE TABLE readers_books (
  readernumber_fk int unsigned,
  booknumber_fk int unsigned,
  FOREIGN KEY (readernumber_fk) REFERENCES readers (readernumber_pk) ON DELETE CASCADE,
  FOREIGN KEY (booknumber_fk) REFERENCES books (booknumber_pk) ON DELETE cascade,
  unique key (readernumber_fk, booknumber_fk)
);

CREATE TABLE libraries (
  libraryid_pk int unsigned NOT NULL AUTO_INCREMENT,
  library_name varchar(128),
  readernumber_fk int unsigned NOT NULL,
  PRIMARY KEY (libraryid_pk),
  FOREIGN KEY (readernumber_fk) REFERENCES readers (readernumber_pk) ON DELETE CASCADE
);