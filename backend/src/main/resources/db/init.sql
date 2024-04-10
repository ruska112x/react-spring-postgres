CREATE TABLE inters (
    inter_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    id_in_messenger bigint NOT NULL,
    full_name varchar(127) NOT NULL,
    messenger_type varchar(127) NOT NULL
);
CREATE TABLE messages (
    mes_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    mes_text text NOT NULL,
    mes_time varchar(5) NOT NULL,
    is_inter boolean NOT NULL,
    inter_id INT NOT NULL REFERENCES inters (inter_id)
);