-- Books
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-7653-7112-6', 'ADVENTURE', 'The Rising', 'Heather Graham and Jon Land', 'Paperback 2016');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-13-767362-9', 'COMP_FORENSICS', 'Guide To Computer Forensics', 'Bill Nelson, Amelia Phillips, Chris Steuart', '12th Edition');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-19-991811-9', 'CYBER_SEC', 'Cybersecurity and Cyberwar', 'P.W. Singer and Allan Friedman', '2014');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-1-59749-957-6', 'CYBER_SEC', 'Violent Python', 'TJ OConnor', 'Publisher Syngress');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('0-02-008095-6', 'EDUCATION', 'The Elements of Business Writing', 'Gary Blake and Robert W. Bly', 'Paperback 1991');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-8048-4241-9', 'EDUCATION', 'Essential Korean', 'Soyeung Koh and Gene Baik', 'Paperback');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-7641-4595-7', 'EDUCATION', 'French Grammar', 'Christopher Kendris and Theodore Kendris', '3rd Edition');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-06-238179-8', 'FICTION', 'Crucible: A Thriller', 'James Rollins', NULL);
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-425-27511-5', 'FICTION', 'Field of Prey', 'John Sandford', 'Paperback 2014');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-0-7653-8802-5', 'FICTION', 'Vostok: Sequel To The Loch', 'Steve Alten', 'Paperback 2015');
INSERT INTO books (isbn, genre, title, book_authors, notes) VALUES('978-1-138-91952-5', 'MANAGEMENT', 'Customer Relationship Management', 'Roger J. Baran and Robert J. Galka', '2nd Edition and paper back');

-- Readers
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('EDWIN_BELMONTE', 'Edwin', 'Belmonte', '678-209-6601', 'edwin_b@village.com');
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('ELENA_ZARAGOSA', 'Elena', 'Zaragoza', '808-432-1221', 'ez808@hottmail.com');
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('MARICEL_SMITH', 'Maricel', 'Smith', '404-552-0012', 'marsmi404@hottmail.com');
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('LUIS_JONES', 'Luis', 'Jones', '755.223.5969', 'lujo725@compress.com');
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('JUAN_LUNA', 'Juan', 'Luna', '503-235-5232', 'jlunax@geemail.com');
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('VICENTE_ELIZALDE', 'Vicente', 'Elizalde', '940-521-2309', 'viczal@compress.com');
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('GERALDINE_JAVIER', 'Geraldine', 'Javier', '230-994-4425', 'javine492@geemail.com');
INSERT INTO readers (reader_id, first_name, last_name, phone, email) VALUES('OFELIA_ROMEO', 'Ofelia', 'Romeo', '774-229-0592', 'oferom1022@nawawala.com');

-- Libraries
INSERT INTO libraries (library_name, readernumber_fk) VALUES ('Edwin''s Library', 1);
INSERT INTO libraries (library_name, readernumber_fk) VALUES ('Luis'' Library', 4);
INSERT INTO libraries (library_name, readernumber_fk) VALUES ('Geraldine''s Library', 7);

-- Readers_Books
INSERT INTO readers_books (readernumber_fk, booknumber_fk) VALUES (1, 2);
INSERT INTO readers_books (readernumber_fk, booknumber_fk) VALUES (1, 7);
INSERT INTO readers_books (readernumber_fk, booknumber_fk) VALUES (4, 5);
INSERT INTO readers_books (readernumber_fk, booknumber_fk) VALUES (7, 10);
