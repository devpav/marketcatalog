--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tbx_ch_characteristic; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_ch_characteristic (
    id uuid NOT NULL,
    title character varying(255),
    id_data_type uuid
);


ALTER TABLE tbx_ch_characteristic OWNER TO marketcatalog;

--
-- Name: tbx_ch_double_characteristic; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_ch_double_characteristic (
    id uuid NOT NULL,
    id_product_row uuid,
    value double precision,
    id_entity_metadata uuid,
    id_product_characteristic uuid
);


ALTER TABLE tbx_ch_double_characteristic OWNER TO marketcatalog;

--
-- Name: tbx_ch_string_characteristic; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_ch_string_characteristic (
    id uuid NOT NULL,
    id_product_row uuid,
    value character varying(255),
    id_entity_metadata uuid,
    id_product_characteristic uuid
);


ALTER TABLE tbx_ch_string_characteristic OWNER TO marketcatalog;

--
-- Name: tbx_p_accessory; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_p_accessory (
    id uuid NOT NULL,
    img character varying(255),
    title character varying(255),
    id_category uuid
);


ALTER TABLE tbx_p_accessory OWNER TO marketcatalog;

--
-- Name: tbx_p_cornice; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_p_cornice (
    id uuid NOT NULL,
    img character varying(255),
    title character varying(255),
    id_category uuid
);


ALTER TABLE tbx_p_cornice OWNER TO marketcatalog;

--
-- Name: tbx_p_jalosie; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_p_jalosie (
    id uuid NOT NULL,
    img character varying(255),
    title character varying(255),
    id_category uuid
);


ALTER TABLE tbx_p_jalosie OWNER TO marketcatalog;

--
-- Name: tbx_p_rolstor; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_p_rolstor (
    id uuid NOT NULL,
    img character varying(255),
    title character varying(255),
    id_category uuid
);


ALTER TABLE tbx_p_rolstor OWNER TO marketcatalog;

--
-- Name: tbx_s_category; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_s_category (
    id uuid NOT NULL,
    system_name character varying(255),
    title character varying(255),
    id_parent_category uuid
);


ALTER TABLE tbx_s_category OWNER TO marketcatalog;

--
-- Name: tbx_s_container; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_s_container (
    id uuid NOT NULL,
    description character varying(255),
    system_name character varying(255)
);


ALTER TABLE tbx_s_container OWNER TO marketcatalog;

--
-- Name: tbx_s_data_type; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_s_data_type (
    id uuid NOT NULL,
    name character varying(255)
);


ALTER TABLE tbx_s_data_type OWNER TO marketcatalog;

--
-- Name: tbx_s_entity_metadata; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_s_entity_metadata (
    id uuid NOT NULL,
    description character varying(255),
    table_name character varying(255),
    id_container uuid
);


ALTER TABLE tbx_s_entity_metadata OWNER TO marketcatalog;

--
-- Name: tbx_s_product_type; Type: TABLE; Schema: public; Owner: marketcatalog
--

CREATE TABLE tbx_s_product_type (
    id uuid NOT NULL,
    title character varying(255)
);


ALTER TABLE tbx_s_product_type OWNER TO marketcatalog;

--
-- Data for Name: tbx_ch_characteristic; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_ch_characteristic (id, title, id_data_type) FROM stdin;
\.


--
-- Data for Name: tbx_ch_double_characteristic; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_ch_double_characteristic (id, id_product_row, value, id_entity_metadata, id_product_characteristic) FROM stdin;
\.


--
-- Data for Name: tbx_ch_string_characteristic; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_ch_string_characteristic (id, id_product_row, value, id_entity_metadata, id_product_characteristic) FROM stdin;
\.


--
-- Data for Name: tbx_p_accessory; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_p_accessory (id, img, title, id_category) FROM stdin;
\.


--
-- Data for Name: tbx_p_cornice; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_p_cornice (id, img, title, id_category) FROM stdin;
\.


--
-- Data for Name: tbx_p_jalosie; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_p_jalosie (id, img, title, id_category) FROM stdin;
\.


--
-- Data for Name: tbx_p_rolstor; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_p_rolstor (id, img, title, id_category) FROM stdin;
\.


--
-- Data for Name: tbx_s_category; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_s_category (id, system_name, title, id_parent_category) FROM stdin;
5762a94b-43ce-4e0b-a635-c776e04b73ed	cornice	Карнизы	5762a94b-43ce-4e0b-a635-c776e04b73ed
4afac74f-dfa0-4423-82b4-b0b50bb034c3	metallic	Металические	5762a94b-43ce-4e0b-a635-c776e04b73ed
e5c91db9-7696-404c-a2a1-a9f6398f2793	plastic_ceilings	Пластиковые потолочные	5762a94b-43ce-4e0b-a635-c776e04b73ed
3a1142bf-9377-431f-bbc4-24b036afb2b2	wall_metal_plastic	Настенные металлопластиковые	5762a94b-43ce-4e0b-a635-c776e04b73ed
3f948223-2db4-4b7e-8a42-037c41494d86	flexible	Гибкие	5762a94b-43ce-4e0b-a635-c776e04b73ed
282313fa-3d9b-4839-842a-7a56ef2bc222	accessories_for_ceiling	Комплектующие для потолочных	5762a94b-43ce-4e0b-a635-c776e04b73ed
ec5dc3c2-a6b7-46ee-8bee-8978e742d134	metal_plastic_accessories	Металлопластиковая фурнитура	5762a94b-43ce-4e0b-a635-c776e04b73ed
c4c33ec7-488d-4c26-970e-b8009b1b6c21	accessories_for_metal	Комплектующие для металлических	5762a94b-43ce-4e0b-a635-c776e04b73ed
f9ba484d-b696-4a9a-ac79-f2fbd0cfa551	rolstor	Рольшторы	f9ba484d-b696-4a9a-ac79-f2fbd0cfa551
b04302c0-2771-466e-baba-d2977e97ad2f	day_night	День/ночь	f9ba484d-b696-4a9a-ac79-f2fbd0cfa551
dc77d8d8-c96c-4889-bf8a-4e5930ed641a	standard	Стандарт	f9ba484d-b696-4a9a-ac79-f2fbd0cfa551
7a28617c-2a5f-4b3f-9e58-7dfa0b4d74bb	in_box	В коробке	f9ba484d-b696-4a9a-ac79-f2fbd0cfa551
6027dad3-9c43-4bf9-8520-5796d59a1300	premium	Премиум	f9ba484d-b696-4a9a-ac79-f2fbd0cfa551
bd93cb0e-50f1-4c7b-9a73-b515129d0e1b	blackout	Блэкаут	f9ba484d-b696-4a9a-ac79-f2fbd0cfa551
3ec43fef-647c-41f3-9fb5-2f930f60c089	jalousie	Жалюзи	3ec43fef-647c-41f3-9fb5-2f930f60c089
b569605e-a61f-4e66-b7b9-802edc7d8165	accessory	Акссуары	b569605e-a61f-4e66-b7b9-802edc7d8165
61984db7-c6e2-4935-af7b-b14d8a3a67e6	luversa	Люверсы	b569605e-a61f-4e66-b7b9-802edc7d8165
b334c012-7e0f-47e8-8053-6d0e19adc9e6	grips_holders_hooks	Подхваты, держатели, крючки	b569605e-a61f-4e66-b7b9-802edc7d8165
e43e326a-14e3-45f2-849c-2fd371797d0f	magnetic_clips	Клипсы магнитные	b569605e-a61f-4e66-b7b9-802edc7d8165
\.


--
-- Data for Name: tbx_s_container; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_s_container (id, description, system_name) FROM stdin;
a19e2196-9a8e-4a25-8e98-6d8eb578458f	Продукт	p
a531733a-7f3c-4001-9afa-77c5fbdfa7cf	Характеристика	ch
a2f67e2c-f430-42f1-84f0-c0bd459831ba	Системный	s
\.


--
-- Data for Name: tbx_s_data_type; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_s_data_type (id, name) FROM stdin;
f8a17421-5b48-4d22-8899-25a8765bbecc	STRING
bb2c2f80-6fed-4504-ae5a-e8604ae8591f	DOUBLE
\.


--
-- Data for Name: tbx_s_entity_metadata; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_s_entity_metadata (id, description, table_name, id_container) FROM stdin;
3247f7e1-2adf-4c23-9c60-6952c5740793	Корниз	cornice	a19e2196-9a8e-4a25-8e98-6d8eb578458f
d4508d64-acf9-4aea-9edc-ddde1eaa6ba9	Аксессуар	accessory	a19e2196-9a8e-4a25-8e98-6d8eb578458f
30b9c908-cbde-4511-bc67-6f9886e90861	Жалюзи	jalosie	a19e2196-9a8e-4a25-8e98-6d8eb578458f
57ef02b6-eed2-489d-a41b-584a5bdc970a	Рольштора	rolstor	a19e2196-9a8e-4a25-8e98-6d8eb578458f
\.


--
-- Data for Name: tbx_s_product_type; Type: TABLE DATA; Schema: public; Owner: marketcatalog
--

COPY tbx_s_product_type (id, title) FROM stdin;
\.


--
-- Name: tbx_ch_characteristic tbx_ch_characteristic_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_characteristic
    ADD CONSTRAINT tbx_ch_characteristic_pkey PRIMARY KEY (id);


--
-- Name: tbx_ch_double_characteristic tbx_ch_double_characteristic_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_double_characteristic
    ADD CONSTRAINT tbx_ch_double_characteristic_pkey PRIMARY KEY (id);


--
-- Name: tbx_ch_string_characteristic tbx_ch_string_characteristic_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_string_characteristic
    ADD CONSTRAINT tbx_ch_string_characteristic_pkey PRIMARY KEY (id);


--
-- Name: tbx_p_accessory tbx_p_accessory_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_accessory
    ADD CONSTRAINT tbx_p_accessory_pkey PRIMARY KEY (id);


--
-- Name: tbx_p_cornice tbx_p_cornice_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_cornice
    ADD CONSTRAINT tbx_p_cornice_pkey PRIMARY KEY (id);


--
-- Name: tbx_p_jalosie tbx_p_jalosie_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_jalosie
    ADD CONSTRAINT tbx_p_jalosie_pkey PRIMARY KEY (id);


--
-- Name: tbx_p_rolstor tbx_p_rolstor_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_rolstor
    ADD CONSTRAINT tbx_p_rolstor_pkey PRIMARY KEY (id);


--
-- Name: tbx_s_category tbx_s_category_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_s_category
    ADD CONSTRAINT tbx_s_category_pkey PRIMARY KEY (id);


--
-- Name: tbx_s_container tbx_s_container_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_s_container
    ADD CONSTRAINT tbx_s_container_pkey PRIMARY KEY (id);


--
-- Name: tbx_s_data_type tbx_s_data_type_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_s_data_type
    ADD CONSTRAINT tbx_s_data_type_pkey PRIMARY KEY (id);


--
-- Name: tbx_s_entity_metadata tbx_s_entity_metadata_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_s_entity_metadata
    ADD CONSTRAINT tbx_s_entity_metadata_pkey PRIMARY KEY (id);


--
-- Name: tbx_s_product_type tbx_s_product_type_pkey; Type: CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_s_product_type
    ADD CONSTRAINT tbx_s_product_type_pkey PRIMARY KEY (id);


--
-- Name: index_s_system_name_category; Type: INDEX; Schema: public; Owner: marketcatalog
--

CREATE INDEX index_s_system_name_category ON tbx_s_category USING btree (system_name);


--
-- Name: tbx_s_category fk30lvxxrwkf7hi2seoo8kkqcar; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_s_category
    ADD CONSTRAINT fk30lvxxrwkf7hi2seoo8kkqcar FOREIGN KEY (id_parent_category) REFERENCES tbx_s_category(id);


--
-- Name: tbx_s_entity_metadata fk42sfn8p24ih8m5p6mv0ur7sri; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_s_entity_metadata
    ADD CONSTRAINT fk42sfn8p24ih8m5p6mv0ur7sri FOREIGN KEY (id_container) REFERENCES tbx_s_container(id);


--
-- Name: tbx_p_cornice fk705ip4o8x5574tiruqmtiqsjl; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_cornice
    ADD CONSTRAINT fk705ip4o8x5574tiruqmtiqsjl FOREIGN KEY (id_category) REFERENCES tbx_s_category(id);


--
-- Name: tbx_p_accessory fk92k9me64mbsg6t5r0xsgnfve3; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_accessory
    ADD CONSTRAINT fk92k9me64mbsg6t5r0xsgnfve3 FOREIGN KEY (id_category) REFERENCES tbx_s_category(id);


--
-- Name: tbx_ch_string_characteristic fkh21r3ubefa4iubahecyx6x3ww; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_string_characteristic
    ADD CONSTRAINT fkh21r3ubefa4iubahecyx6x3ww FOREIGN KEY (id_product_characteristic) REFERENCES tbx_ch_characteristic(id);


--
-- Name: tbx_ch_string_characteristic fkhcg2j9t638ssgehq44oihp6d9; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_string_characteristic
    ADD CONSTRAINT fkhcg2j9t638ssgehq44oihp6d9 FOREIGN KEY (id_entity_metadata) REFERENCES tbx_s_entity_metadata(id);


--
-- Name: tbx_ch_double_characteristic fki7j8ulaojjwmni0vcc44th35n; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_double_characteristic
    ADD CONSTRAINT fki7j8ulaojjwmni0vcc44th35n FOREIGN KEY (id_entity_metadata) REFERENCES tbx_s_entity_metadata(id);


--
-- Name: tbx_p_rolstor fkk8gyo26eqxa2nlk7absja8947; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_rolstor
    ADD CONSTRAINT fkk8gyo26eqxa2nlk7absja8947 FOREIGN KEY (id_category) REFERENCES tbx_s_category(id);


--
-- Name: tbx_ch_characteristic fkkthor157qns2rpjni2k11977d; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_characteristic
    ADD CONSTRAINT fkkthor157qns2rpjni2k11977d FOREIGN KEY (id_data_type) REFERENCES tbx_s_data_type(id);


--
-- Name: tbx_p_jalosie fkqx0big0erqkasmfxu1pcqta0; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_p_jalosie
    ADD CONSTRAINT fkqx0big0erqkasmfxu1pcqta0 FOREIGN KEY (id_category) REFERENCES tbx_s_category(id);


--
-- Name: tbx_ch_double_characteristic fkqxadrl8r60kkfg2pab016jrig; Type: FK CONSTRAINT; Schema: public; Owner: marketcatalog
--

ALTER TABLE ONLY tbx_ch_double_characteristic
    ADD CONSTRAINT fkqxadrl8r60kkfg2pab016jrig FOREIGN KEY (id_product_characteristic) REFERENCES tbx_ch_characteristic(id);


--
-- PostgreSQL database dump complete
--

