--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.0

-- Started on 2017-03-17 22:12:55

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

SET default_with_oids = false;

--
-- TOC entry 181 (class 1259 OID 16396)
-- Name: countries; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE countries (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


--
-- TOC entry 182 (class 1259 OID 16402)
-- Name: country_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE country_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2192 (class 0 OID 0)
-- Dependencies: 182
-- Name: country_id_seq; Type: SEQUENCE OWNED BY; Schema: travel; Owner: -
--

ALTER SEQUENCE country_id_seq OWNED BY countries.id;


--
-- TOC entry 191 (class 1259 OID 16440)
-- Name: hotel_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE hotel_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 189 (class 1259 OID 16434)
-- Name: hotels; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE hotels (
    id integer DEFAULT nextval('hotel_id_seq'::regclass) NOT NULL,
    name character varying(150) NOT NULL,
    address character varying(150),
    town_id integer NOT NULL
);


--
-- TOC entry 186 (class 1259 OID 16422)
-- Name: role_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 185 (class 1259 OID 16419)
-- Name: roles; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE roles (
    id integer DEFAULT nextval('role_id_seq'::regclass) NOT NULL,
    name character varying(50) NOT NULL
);


--
-- TOC entry 193 (class 1259 OID 16444)
-- Name: tour_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE tour_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 187 (class 1259 OID 16428)
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
    start_date date NOT NULL,
    end_date date NOT NULL,
    hot boolean DEFAULT false NOT NULL,
    user_id integer,
    used boolean DEFAULT false NOT NULL,
    booking timestamp with time zone,
    paid boolean DEFAULT false NOT NULL,
    archive boolean DEFAULT false NOT NULL
);


--
-- TOC entry 192 (class 1259 OID 16442)
-- Name: town_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE town_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 188 (class 1259 OID 16431)
-- Name: towns; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE towns (
    id integer DEFAULT nextval('town_id_seq'::regclass) NOT NULL,
    name character varying(100) NOT NULL,
    country_id integer NOT NULL
);


--
-- TOC entry 184 (class 1259 OID 16410)
-- Name: user_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE user_id_seq
    START WITH 8
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 190 (class 1259 OID 16437)
-- Name: user_roles; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE user_roles (
    user_id integer NOT NULL,
    role_id integer NOT NULL
);


--
-- TOC entry 183 (class 1259 OID 16407)
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
-- TOC entry 2018 (class 2604 OID 16404)
-- Name: id; Type: DEFAULT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries ALTER COLUMN id SET DEFAULT nextval('country_id_seq'::regclass);


--
-- TOC entry 2175 (class 0 OID 16396)
-- Dependencies: 181
-- Data for Name: countries; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO countries (id, name) VALUES (3, 'Russia');
INSERT INTO countries (id, name) VALUES (4, 'Poland');
INSERT INTO countries (id, name) VALUES (5, 'Lithuania');
INSERT INTO countries (id, name) VALUES (6, 'Ukraine');
INSERT INTO countries (id, name) VALUES (7, 'Honduras');
INSERT INTO countries (id, name) VALUES (8, 'USA');


--
-- TOC entry 2193 (class 0 OID 0)
-- Dependencies: 182
-- Name: country_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('country_id_seq', 8, true);


--
-- TOC entry 2194 (class 0 OID 0)
-- Dependencies: 191
-- Name: hotel_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('hotel_id_seq', 1, false);


--
-- TOC entry 2183 (class 0 OID 16434)
-- Dependencies: 189
-- Data for Name: hotels; Type: TABLE DATA; Schema: travel; Owner: -
--



--
-- TOC entry 2195 (class 0 OID 0)
-- Dependencies: 186
-- Name: role_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('role_id_seq', 1, false);


--
-- TOC entry 2179 (class 0 OID 16419)
-- Dependencies: 185
-- Data for Name: roles; Type: TABLE DATA; Schema: travel; Owner: -
--



--
-- TOC entry 2196 (class 0 OID 0)
-- Dependencies: 193
-- Name: tour_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('tour_id_seq', 1, false);


--
-- TOC entry 2181 (class 0 OID 16428)
-- Dependencies: 187
-- Data for Name: tours; Type: TABLE DATA; Schema: travel; Owner: -
--



--
-- TOC entry 2197 (class 0 OID 0)
-- Dependencies: 192
-- Name: town_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('town_id_seq', 1, false);


--
-- TOC entry 2182 (class 0 OID 16431)
-- Dependencies: 188
-- Data for Name: towns; Type: TABLE DATA; Schema: travel; Owner: -
--



--
-- TOC entry 2198 (class 0 OID 0)
-- Dependencies: 184
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('user_id_seq', 1, true);


--
-- TOC entry 2184 (class 0 OID 16437)
-- Dependencies: 190
-- Data for Name: user_roles; Type: TABLE DATA; Schema: travel; Owner: -
--



--
-- TOC entry 2177 (class 0 OID 16407)
-- Dependencies: 183
-- Data for Name: users; Type: TABLE DATA; Schema: travel; Owner: -
--



--
-- TOC entry 2029 (class 2606 OID 16762)
-- Name: countries_name_key; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries
    ADD CONSTRAINT countries_name_key UNIQUE (name);


--
-- TOC entry 2031 (class 2606 OID 16406)
-- Name: country_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);


--
-- TOC entry 2049 (class 2606 OID 16580)
-- Name: hotel_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY hotels
    ADD CONSTRAINT hotel_pkey PRIMARY KEY (id);


--
-- TOC entry 2037 (class 2606 OID 16582)
-- Name: role_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY roles
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- TOC entry 2043 (class 2606 OID 16584)
-- Name: tour_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_pkey PRIMARY KEY (id);


--
-- TOC entry 2046 (class 2606 OID 16586)
-- Name: town_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY towns
    ADD CONSTRAINT town_pkey PRIMARY KEY (id);


--
-- TOC entry 2033 (class 2606 OID 16588)
-- Name: user_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2052 (class 2606 OID 16709)
-- Name: user_roles_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);


--
-- TOC entry 2035 (class 2606 OID 16590)
-- Name: users_username_key; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_username_key UNIQUE (username);


--
-- TOC entry 2047 (class 1259 OID 16768)
-- Name: fki_hotel_fk0; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_hotel_fk0 ON hotels USING btree (town_id);


--
-- TOC entry 2038 (class 1259 OID 16791)
-- Name: fki_tour_fk0; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk0 ON tours USING btree (hotel_id);


--
-- TOC entry 2039 (class 1259 OID 16797)
-- Name: fki_tour_fk1; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk1 ON tours USING btree (town_id);


--
-- TOC entry 2040 (class 1259 OID 16803)
-- Name: fki_tour_fk2; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk2 ON tours USING btree (country_id);


--
-- TOC entry 2041 (class 1259 OID 16809)
-- Name: fki_tour_fk3; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_tour_fk3 ON tours USING btree (user_id);


--
-- TOC entry 2044 (class 1259 OID 16774)
-- Name: fki_town_fk0; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_town_fk0 ON towns USING btree (country_id);


--
-- TOC entry 2050 (class 1259 OID 16785)
-- Name: fki_user_roles_fk1; Type: INDEX; Schema: travel; Owner: -
--

CREATE INDEX fki_user_roles_fk1 ON user_roles USING btree (role_id);


--
-- TOC entry 2058 (class 2606 OID 16763)
-- Name: hotel_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY hotels
    ADD CONSTRAINT hotel_fk0 FOREIGN KEY (town_id) REFERENCES towns(id);


--
-- TOC entry 2053 (class 2606 OID 16786)
-- Name: tour_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk0 FOREIGN KEY (hotel_id) REFERENCES hotels(id);


--
-- TOC entry 2054 (class 2606 OID 16792)
-- Name: tour_fk1; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk1 FOREIGN KEY (town_id) REFERENCES towns(id);


--
-- TOC entry 2055 (class 2606 OID 16798)
-- Name: tour_fk2; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk2 FOREIGN KEY (country_id) REFERENCES countries(id);


--
-- TOC entry 2056 (class 2606 OID 16804)
-- Name: tour_fk3; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY tours
    ADD CONSTRAINT tour_fk3 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2057 (class 2606 OID 16769)
-- Name: town_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY towns
    ADD CONSTRAINT town_fk0 FOREIGN KEY (country_id) REFERENCES countries(id);


--
-- TOC entry 2059 (class 2606 OID 16775)
-- Name: user_roles_fk0; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_fk0 FOREIGN KEY (user_id) REFERENCES users(id);


--
-- TOC entry 2060 (class 2606 OID 16780)
-- Name: user_roles_fk1; Type: FK CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_fk1 FOREIGN KEY (role_id) REFERENCES roles(id);


-- Completed on 2017-03-17 22:12:56

--
-- PostgreSQL database dump complete
--

