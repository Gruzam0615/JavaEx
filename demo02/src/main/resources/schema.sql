DROP TABLE Board IF EXISTS;

CREATE TABLE board(
    idx BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    author VARCHAR(50),
    content VARCHAR(4000),
    count BIGINT,
    likecount BIGINT,
    createddate DATE,
    lastdate DATE
);