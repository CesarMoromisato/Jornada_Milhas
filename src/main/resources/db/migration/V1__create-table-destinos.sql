create table destinos(
    id bigint not null auto_increment,
    foto1 varchar(100) not null,
    foto2 varchar(100) not null,
    nome varchar(100) not null,
    meta varchar(160) not null,
    textodescritivo varchar(250),

    primary key(id)
);