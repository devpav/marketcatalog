create table tbx_s_container
(
    id          UUID primary key,
    description TEXT,
    system_name VARCHAR(20)
);

create table tbx_s_entity_metadata
(
    id          UUID primary key,
    table_name  VARCHAR(50),
    system_name VARCHAR(20),
    description TEXT,
    id_container UUID REFERENCES tbx_s_container(id)
);

create table tbx_s_data_type
(
    id          UUID primary key,
    name        VARCHAR(36)
);

create table tbx_s_category
(
    id                 UUID primary key,
    title              VARCHAR(256),
    id_parent_category UUID REFERENCES tbx_s_category(id)
);
