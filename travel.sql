--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.0

-- Started on 2017-04-12 00:27:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 7 (class 2615 OID 16395)
-- Name: travel; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA travel;


SET search_path = travel, pg_catalog;

--
-- TOC entry 187 (class 1259 OID 16422)
-- Name: authority_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE authority_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 16419)
-- Name: authorities; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE authorities (
    id integer DEFAULT nextval('authority_id_seq'::regclass) NOT NULL,
    authority character varying(50) NOT NULL
);


--
-- TOC entry 182 (class 1259 OID 16396)
-- Name: countries; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE countries (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


--
-- TOC entry 183 (class 1259 OID 16402)
-- Name: country_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE country_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2231 (class 0 OID 0)
-- Dependencies: 183
-- Name: country_id_seq; Type: SEQUENCE OWNED BY; Schema: travel; Owner: -
--

ALTER SEQUENCE country_id_seq OWNED BY countries.id;


--
-- TOC entry 192 (class 1259 OID 16440)
-- Name: hotel_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 190 (class 1259 OID 16434)
-- Name: hotels; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE hotels (
    id integer DEFAULT nextval('hotel_id_seq'::regclass) NOT NULL,
    name character varying(150) NOT NULL,
    address character varying(150),
    town_id integer NOT NULL
);


--
-- TOC entry 194 (class 1259 OID 16444)
-- Name: tour_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE tour_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 188 (class 1259 OID 16428)
-- Name: tours; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE tours (
    id integer DEFAULT nextval('tour_id_seq'::regclass) NOT NULL,
    hotel_id integer,
    town_id integer,
    country_id integer,
    price numeric,
    nights smallint,
    persons smallint NOT NULL,
    start_date timestamp without time zone NOT NULL,
    end_date timestamp without time zone NOT NULL,
    user_id integer,
    used boolean DEFAULT false NOT NULL,
    booking timestamp with time zone,
    paid boolean DEFAULT false NOT NULL,
    archive boolean DEFAULT false NOT NULL
);


--
-- TOC entry 193 (class 1259 OID 16442)
-- Name: town_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE town_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 189 (class 1259 OID 16431)
-- Name: towns; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE towns (
    id integer DEFAULT nextval('town_id_seq'::regclass) NOT NULL,
    name character varying(100) NOT NULL,
    country_id integer NOT NULL
);


--
-- TOC entry 191 (class 1259 OID 16437)
-- Name: user_authorities; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE user_authorities (
    user_id integer NOT NULL,
    authority_id integer NOT NULL
);


--
-- TOC entry 185 (class 1259 OID 16410)
-- Name: user_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE user_id_seq
    START WITH 8
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 184 (class 1259 OID 16407)
-- Name: users; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE users (
    id integer DEFAULT nextval('user_id_seq'::regclass) NOT NULL,
    username character varying(300) NOT NULL,
    password character varying(500) NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    phone_number character varying(50) NOT NULL,
    mail character varying(100)
);


--
-- TOC entry 2054 (class 2604 OID 16404)
-- Name: id; Type: DEFAULT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries ALTER COLUMN id SET DEFAULT nextval('country_id_seq'::regclass);


--
-- TOC entry 2218 (class 0 OID 16419)
-- Dependencies: 186
-- Data for Name: authorities; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO authorities (id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authorities (id, authority) VALUES (2, 'ROLE_MANAGER');
INSERT INTO authorities (id, authority) VALUES (3, 'ROLE_USER');


--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 187
-- Name: authority_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('authority_id_seq', 3, true);


--
-- TOC entry 2214 (class 0 OID 16396)
-- Dependencies: 182
-- Data for Name: countries; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO countries (id, name) VALUES (12, 'Испания');
INSERT INTO countries (id, name) VALUES (56, 'Китай');
INSERT INTO countries (id, name) VALUES (123, 'Латвия');
INSERT INTO countries (id, name) VALUES (124, 'Португалия');
INSERT INTO countries (id, name) VALUES (126, 'Тунис');
INSERT INTO countries (id, name) VALUES (127, 'Франция');
INSERT INTO countries (id, name) VALUES (122, 'Ливия');
INSERT INTO countries (id, name) VALUES (4, 'Польша');
INSERT INTO countries (id, name) VALUES (8, 'США');
INSERT INTO countries (id, name) VALUES (3, 'Россия');
INSERT INTO countries (id, name) VALUES (55, 'Турция');
INSERT INTO countries (id, name) VALUES (76, 'Грузия');
INSERT INTO countries (id, name) VALUES (5, 'Литва');


--
-- TOC entry 2233 (class 0 OID 0)
-- Dependencies: 183
-- Name: country_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('country_id_seq', 133, true);


--
-- TOC entry 2234 (class 0 OID 0)
-- Dependencies: 192
-- Name: hotel_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('hotel_id_seq', 12, true);


--
-- TOC entry 2222 (class 0 OID 16434)
-- Dependencies: 190
-- Data for Name: hotels; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO hotels (id, name, address, town_id) VALUES (2, 'Столица', 'ул. Тверская', 2);
INSERT INTO hotels (id, name, address, town_id) VALUES (3, 'Жемчужина', 'ул. Черноморская, 3', 22);
INSERT INTO hotels (id, name, address, town_id) VALUES (5, 'Монте Карло', 'Oba Mahallesi, 10', 14);
INSERT INTO hotels (id, name, address, town_id) VALUES (4, 'Кактус', 'ул. Набережная, 47', 14);
INSERT INTO hotels (id, name, address, town_id) VALUES (11, 'Маракуя', 'Ленина 7', 14);
INSERT INTO hotels (id, name, address, town_id) VALUES (12, 'Кремль', 'ул.Ленина, 1', 2);


--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 194
-- Name: tour_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('tour_id_seq', 15, true);


--
-- TOC entry 2220 (class 0 OID 16428)
-- Dependencies: 188
-- Data for Name: tours; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (3, 5, 14, 55, 465, 4, 2, '2017-04-28 00:00:00', '2017-05-02 00:00:00', NULL, false, NULL, false, false);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (7, 2, 2, 3, 543, 2, 4, '2017-04-17 00:00:00', '2017-04-19 00:00:00', NULL, false, '2017-04-07 20:03:47.363+00', false, false);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (10, 2, 2, 3, 546, 5, 3, '2017-04-05 12:00:00', '2017-04-10 12:00:00', NULL, false, NULL, false, true);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (11, 5, 14, 55, 768, 6, 4, '2017-04-07 12:00:00', '2017-04-13 12:00:00', NULL, false, NULL, false, true);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (6, 2, 2, 3, 656, 6, 1, '2017-04-26 00:00:00', '2017-05-02 00:00:00', 2, false, '2017-04-07 23:23:02.94+00', false, false);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (9, 2, 2, 3, 656, 3, 2, '2017-04-19 00:00:00', '2017-04-22 00:00:00', NULL, false, NULL, false, false);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (5, 2, 2, 3, 555, 5, 3, '2017-04-22 00:00:00', '2017-04-27 00:00:00', 4, false, '2017-04-09 13:52:07.957+00', false, false);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (8, 2, 2, 3, 765, 5, 1, '2017-04-20 00:00:00', '2017-04-25 00:00:00', 3, false, '2017-04-09 14:34:15.429+00', false, false);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (15, 5, 14, 55, 5643, 10, 4, '2017-04-29 12:00:00', '2017-05-09 12:00:00', NULL, false, NULL, false, false);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (13, 5, 14, 55, 989, 9, 4, '2017-04-10 00:00:00', '2017-04-19 12:00:00', NULL, false, NULL, false, true);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (12, 3, 22, 3, 777, 8, 2, '2017-04-11 12:00:00', '2017-04-19 12:00:00', NULL, false, NULL, false, true);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (14, 5, 14, 55, 565, 9, 1, '2017-04-11 12:00:00', '2017-04-20 12:00:00', 3, false, '2017-04-09 14:34:25.487+00', true, true);
INSERT INTO tours (id, hotel_id, town_id, country_id, price, nights, persons, start_date, end_date, user_id, used, booking, paid, archive) VALUES (4, 4, 14, 55, 676, 5, 2, '2017-04-20 00:00:00', '2017-04-25 00:00:00', 4, false, '2017-04-11 20:42:53.873+00', false, false);


--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 193
-- Name: town_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('town_id_seq', 36, true);


--
-- TOC entry 2221 (class 0 OID 16431)
-- Dependencies: 189
-- Data for Name: towns; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO towns (id, name, country_id) VALUES (3, 'Варшва', 4);
INSERT INTO towns (id, name, country_id) VALUES (4, 'Гданьск', 4);
INSERT INTO towns (id, name, country_id) VALUES (5, 'Паланга', 5);
INSERT INTO towns (id, name, country_id) VALUES (6, 'Бостон', 8);
INSERT INTO towns (id, name, country_id) VALUES (7, 'Вашингтон', 8);
INSERT INTO towns (id, name, country_id) VALUES (13, 'Стамбул', 55);
INSERT INTO towns (id, name, country_id) VALUES (18, 'Уфа', 3);
INSERT INTO towns (id, name, country_id) VALUES (22, 'Сочи', 3);
INSERT INTO towns (id, name, country_id) VALUES (23, 'Смоленск', 3);
INSERT INTO towns (id, name, country_id) VALUES (25, 'Тверь', 3);
INSERT INTO towns (id, name, country_id) VALUES (26, 'Пермь', 3);
INSERT INTO towns (id, name, country_id) VALUES (28, 'Кузница', 4);
INSERT INTO towns (id, name, country_id) VALUES (29, 'Мадрид', 12);
INSERT INTO towns (id, name, country_id) VALUES (30, 'Барселона', 12);
INSERT INTO towns (id, name, country_id) VALUES (31, 'Майорка', 12);
INSERT INTO towns (id, name, country_id) VALUES (32, 'Коста-Брава', 12);
INSERT INTO towns (id, name, country_id) VALUES (33, 'Иркутск', 3);
INSERT INTO towns (id, name, country_id) VALUES (34, 'Калининград', 3);
INSERT INTO towns (id, name, country_id) VALUES (35, 'Курск', 3);
INSERT INTO towns (id, name, country_id) VALUES (1, 'Питербург', 3);
INSERT INTO towns (id, name, country_id) VALUES (24, 'Владимир', 3);
INSERT INTO towns (id, name, country_id) VALUES (2, 'Москва', 3);
INSERT INTO towns (id, name, country_id) VALUES (14, 'Алания', 55);
INSERT INTO towns (id, name, country_id) VALUES (36, 'Париж', 127);


--
-- TOC entry 2223 (class 0 OID 16437)
-- Dependencies: 191
-- Data for Name: user_authorities; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO user_authorities (user_id, authority_id) VALUES (2, 1);
INSERT INTO user_authorities (user_id, authority_id) VALUES (3, 3);
INSERT INTO user_authorities (user_id, authority_id) VALUES (4, 3);


--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 185
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('user_id_seq', 4, true);


--
-- TOC entry 2216 (class 0 OID 16407)
-- Dependencies: 184
-- Data for Name: users; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO users (id, username, password, first_name, last_name, phone_number, mail) VALUES (4, 'user2', 'test', 'Иван', 'Иванов', '+3751111111', 'qwerty@mail.ru');
INSERT INTO users (id, username, password, first_name, last_name, phone_number, mail) VALUES (2, 'travel', 'test', 'Админ', 'lName', '556235', 'travel@tut.by');
INSERT INTO users (id, username, password, first_name, last_name, phone_number, mail) VALUES (3, 'user', 'test', 'Петр', 'Петров', '12345', 'qw@er.ru');


--
-- TOC entry 2064 (class 2606 OID 16762)
-- Name: countries_name_key; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries
    ADD CONSTRAINT countries_name_key UNIQUE (name);


--
-- TOC entry 2066 (class 2606 OID 16406)
-- Name: country_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);


--
-- TOC entry 2086 (class 2606 OID 16580)
-- Name: hotel_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY hotels
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (id);


--
-- TOC entry 2088 (class 2606 OID 17034)
-- Name: hotels_name_address_town_key; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY hotels
    ADD CONSTRAINT hotels_name_address_town_key UNIQUE (name, address, town_id);


--
-- TOC entry 2072 (class 2606 OID 16582)
-- Name: role_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY authorities
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2078 (class 2606 OID 16584)
-- Name: tour_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_pkey PRIMARY KEY (id);


--
-- TOC entry 2081 (class 2606 OID 16586)
-- Name: town_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY towns
    ADD CONSTRAINT town_pkey PRIMARY KEY (id);


--
-- TOC entry 2083 (class 2606 OID 17031)
-- Name: towns_name_country_key; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY towns
    ADD CONSTRAINT towns_name_country_key UNIQUE (name, country_id);


--
-- TOC entry 2091 (class 2606 OID 16709)
-- Name: user_authorities_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY user_authorities
    ADD CONSTRAINT user_authorities_pkey PRIMARY KEY (user_id, authority_id);


--
-- TOC entry 2068 (class 2606 OID 16588)
-- Name: user_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2070 (class 2606 OID 16590)
-- Name: users_username_key; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- TOC entry 2084 (class 1259 OID 16768)
-- Name: fki_hotel_fk0; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_hotel_fk0 ON hotels USING btree (town_id);


--
-- TOC entry 2073 (class 1259 OID 16791)
-- Name: fki_tour_fk0; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk0 ON tours USING btree (hotel_id);


--
-- TOC entry 2074 (class 1259 OID 16797)
-- Name: fki_tour_fk1; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk1 ON tours USING btree (town_id);


--
-- TOC entry 2075 (class 1259 OID 16803)
-- Name: fki_tour_fk2; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk2 ON tours USING btree (country_id);


--
-- TOC entry 2076 (class 1259 OID 16809)
-- Name: fki_tour_fk3; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk3 ON tours USING btree (user_id);


--
-- TOC entry 2079 (class 1259 OID 16774)
-- Name: fki_town_fk0; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_town_fk0 ON towns USING btree (country_id);


--
-- TOC entry 2089 (class 1259 OID 16785)
-- Name: fki_user_roles_fk1; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_user_roles_fk1 ON user_authorities USING btree (authority_id);


--
-- TOC entry 2097 (class 2606 OID 16763)
-- Name: hotel_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY hotels
    ADD CONSTRAINT hotel_fk0 FOREIGN KEY (town_id) REFERENCES towns(id);


--
-- TOC entry 2092 (class 2606 OID 16786)
-- Name: tour_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk0 FOREIGN KEY (hotel_id) REFERENCES hotels(id);


--
-- TOC entry 2093 (class 2606 OID 16792)
-- Name: tour_fk1; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk1 FOREIGN KEY (town_id) REFERENCES towns(id);


--
-- TOC entry 2094 (class 2606 OID 16798)
-- Name: tour_fk2; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk2 FOREIGN KEY (country_id) REFERENCES countries(id);


--
-- TOC entry 2095 (class 2606 OID 16804)
-- Name: tour_fk3; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk3 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2096 (class 2606 OID 16769)
-- Name: town_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY towns
    ADD CONSTRAINT town_fk0 FOREIGN KEY (country_id) REFERENCES countries(id);


--
-- TOC entry 2098 (class 2606 OID 16775)
-- Name: user_authorities_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY user_authorities
    ADD CONSTRAINT user_authorities_fk0 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2099 (class 2606 OID 16780)
-- Name: user_authorities_fk1; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY user_authorities
    ADD CONSTRAINT user_authorities_fk1 FOREIGN KEY (authority_id) REFERENCES authorities(id);


-- Completed on 2017-04-12 00:27:04

--
-- PostgreSQL database dump complete
--

