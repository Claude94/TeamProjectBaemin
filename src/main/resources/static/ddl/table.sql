CREATE SEQUENCE seq_rmboard;

CREATE TABLE rmboard(
    res_num NUMBER(10),
    res_name VARCHAR2(20) NOT NULL,
    tel_number VARCHAR2(10) NOT NULL,
    menus VARCHAR2(2000),
    CONSTRAINT pk_rmboard PRIMARY KEY (res_num)
);

SELECT
    *
FROM rmboard;
