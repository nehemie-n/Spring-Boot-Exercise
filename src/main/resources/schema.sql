create table if not exists photoz(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    file_name varchar(255),
    content_type varchar(255),
    data BINARY LARGE OBJECT
);