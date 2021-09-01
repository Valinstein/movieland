CREATE TABLE movie
(
    id              SERIAL PRIMARY KEY,
    name_russian    VARCHAR(255),
    name_native     VARCHAR(255),
    year_of_release DATE,
    description     VARCHAR(1000),
    rating          DOUBLE PRECISION,
    price           DOUBLE PRECISION,
    picture_path    VARCHAR(255),
    votes           INT
);