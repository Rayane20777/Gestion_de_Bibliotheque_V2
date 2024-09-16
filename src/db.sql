CREATE TYPE document_status AS ENUM ('available', 'borrowed', 'booked');

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name varchar(50),
                       email varchar(150)
);

CREATE TABLE student(
                         faculty varchar(100),
                         grade varchar(100)
) inherits (users);

CREATE TABLE professor(
                           department varchar(100)
) inherits (users);

CREATE TABLE documents(
                          id int SERIAL PRIMARY KEY,
                          title varchar(250),
                          author varchar(100),
                          publication_date date,
                          status status,
                          borrower_id int ,
                          booker_id int ,
                          FOREIGN KEY (borrower_id) REFERENCES users(id),
                          FOREIGN KEY (booker_id) REFERENCES users(id)
);

CREATE TABLE book(
                      isbn varchar(13)
) inherits (document);

CREATE TABLE magazine(
                          number int
) inherits (document);

CREATE TABLE scientific_journal(
                                   researchDomain varchar(100),
) inherits (document);

CREATE TABLE university_thesis(
                                  research_domain varchar(250),

) inherits (document);
