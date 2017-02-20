--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2017-02-19 20:58:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 11 (class 2615 OID 31383)
-- Name: travel; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA travel;


SET search_path = travel, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 204 (class 1259 OID 31397)
-- Name: countries; Type: TABLE; Schema: travel; Owner: -
--

CREATE TABLE countries (
    id integer NOT NULL,
    name character varying
);


--
-- TOC entry 203 (class 1259 OID 31395)
-- Name: country_id_seq; Type: SEQUENCE; Schema: travel; Owner: -
--

CREATE SEQUENCE country_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2160 (class 0 OID 0)
-- Dependencies: 203
-- Name: country_id_seq; Type: SEQUENCE OWNED BY; Schema: travel; Owner: -
--

ALTER SEQUENCE country_id_seq OWNED BY countries.id;


--
-- TOC entry 2037 (class 2604 OID 31400)
-- Name: id; Type: DEFAULT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries ALTER COLUMN id SET DEFAULT nextval('country_id_seq'::regclass);


--
-- TOC entry 2155 (class 0 OID 31397)
-- Dependencies: 204
-- Data for Name: countries; Type: TABLE DATA; Schema: travel; Owner: -
--

INSERT INTO countries (id, name) VALUES (3, 'Russia');
INSERT INTO countries (id, name) VALUES (4, 'Poland');
INSERT INTO countries (id, name) VALUES (5, 'Lithuania');
INSERT INTO countries (id, name) VALUES (6, 'Ukraine');
INSERT INTO countries (id, name) VALUES (7, 'Honduras');
INSERT INTO countries (id, name) VALUES (8, 'USA');


--
-- TOC entry 2161 (class 0 OID 0)
-- Dependencies: 203
-- Name: country_id_seq; Type: SEQUENCE SET; Schema: travel; Owner: -
--

SELECT pg_catalog.setval('country_id_seq', 8, true);


--
-- TOC entry 2039 (class 2606 OID 31405)
-- Name: country_pkey; Type: CONSTRAINT; Schema: travel; Owner: -
--

ALTER TABLE ONLY countries
    ADD CONSTRAINT country_pkey PRIMARY KEY (id);


-- Completed on 2017-02-19 20:58:32

--
-- PostgreSQL database dump complete
--

