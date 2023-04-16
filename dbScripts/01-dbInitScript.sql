ALTER USER postgres WITH PASSWORD 'password';

CREATE DATABASE "url_shortener";

GRANT ALL ON DATABASE url_shortener TO postgres;