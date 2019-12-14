create table tbx_s_container
(
    id          UUID primary key,
    description TEXT        NOT NULL,
    system_name VARCHAR(20) NOT NULL
);

create table tbx_s_entity_metadata
(
    id           UUID primary key,
    table_name   VARCHAR(50)    NOT NULL,
    system_name  VARCHAR(20)    NOT NULL,
    description  TEXT           NOT NULL,
    id_container UUID           NOT NULL REFERENCES tbx_s_container(id)
);

create table tbx_s_data_type
(
    id          UUID primary key,
    name        VARCHAR(36) NOT NULL
);

create table tbx_ch_characteristic
(
    id            UUID primary key,
    id_data_type  UUID          NOT NULL,
    title         VARCHAR(52)   NOT NULL REFERENCES tbx_s_data_type(id)
);

create table tbx_s_category
(
    id                 UUID primary key,
    title              VARCHAR(256) NOT NULL,
    id_parent_category UUID         NOT NULL REFERENCES tbx_s_category(id)
);

create table tbx_ch_double_characteristic
(
    id                          UUID primary key,
    value                       DECIMAL(19, 4) NOT NULL,
    id_product_characteristic   UUID NOT NULL REFERENCES tbx_ch_characteristic(id),
    id_entity_metadata          UUID NOT NULL REFERENCES tbx_s_entity_metadata(id)
);

create table tbx_ch_string_characteristic
(
    id                          UUID primary key,
    value                       TEXT NOT NULL,
    id_product_characteristic   UUID NOT NULL REFERENCES tbx_ch_characteristic(id),
    id_entity_metadata          UUID NOT NULL REFERENCES tbx_s_entity_metadata(id)
);

create table tbx_ch_double_characteristic
(
    id                          UUID primary key,
    value                       DECIMAL(19, 4) NOT NULL,
    id_product_characteristic   UUID NOT NULL REFERENCES tbx_ch_characteristic(id),
    id_entity_metadata          UUID NOT NULL REFERENCES tbx_s_entity_metadata(id),
    id_product_row              UUID NOT NULL
);

create table tbx_ch_string_characteristic
(
    id                          UUID primary key,
    value                       TEXT NOT NULL,
    id_product_characteristic   UUID NOT NULL REFERENCES tbx_ch_characteristic(id),
    id_entity_metadata          UUID NOT NULL REFERENCES tbx_s_entity_metadata(id),
    id_product_row              UUID NOT NULL
);

create table tbx_ch_double_list_characteristic
(
    id                          UUID primary key,
    value                       DECIMAL(19, 4) NOT NULL,
    id_product_characteristic   UUID NOT NULL REFERENCES tbx_ch_characteristic(id),
    id_entity_metadata          UUID NOT NULL REFERENCES tbx_s_entity_metadata(id),
    id_product_row              UUID NOT NULL
);

create table tbx_ch_string_list_characteristic
(
    id                          UUID primary key,
    value                       TEXT NOT NULL,
    id_product_characteristic   UUID NOT NULL REFERENCES tbx_ch_characteristic(id),
    id_entity_metadata          UUID NOT NULL REFERENCES tbx_s_entity_metadata(id),
    id_product_row              UUID NOT NULL
);

create table tbx_p_accessory
(
    id                          UUID primary key,
    title                       VARCHAR(256) NOT NULL,
    img                         VARCHAR(512) NOT NULL,
    id_category                 UUID NOT NULL REFERENCES tbx_s_category(id)
);

create table tbx_p_blind
(
    id                          UUID primary key,
    title                       VARCHAR(256) NOT NULL,
    img                         VARCHAR(512) NOT NULL,
    id_category                 UUID NOT NULL REFERENCES tbx_s_category(id)
);

create table tbx_p_cornice
(
    id                          UUID primary key,
    title                       VARCHAR(256) NOT NULL,
    img                         VARCHAR(512) NOT NULL,
    id_category                 UUID NOT NULL REFERENCES tbx_s_category(id)
);

create table tbx_p_curtain
(
    id                          UUID primary key,
    title                       VARCHAR(256) NOT NULL,
    img                         VARCHAR(512) NOT NULL,
    id_category                 UUID NOT NULL REFERENCES tbx_s_category(id)
);
