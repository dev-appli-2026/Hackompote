-- Supprime toutes les données
-------
DELETE FROM compte;


-- Ajoute  une extension à PostgreSQL
-------
CREATE SCHEMA IF NOT EXISTS ext;
CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA ext;


-- compte
-------

INSERT INTO compte (id_compte, pseudo, empreinte_mdp, email, role_admin ) VALUES
( 1, 'admin', ext.crypt( 'admin', ext.gen_salt('bf')), 'admin@mail.com', TRUE ),
( 2, 'max', ext.crypt('max', ext.gen_salt('bf')), 'max@mail.com', FALSE ),
( 3, 'mika', ext.crypt('mika', ext.gen_salt('bf')), 'mika@mail.com', FALSE ),
( 4, 'tom', ext.crypt('tom', ext.gen_salt('bf')), 'tom@mail.com', FALSE ),
( 5, 'eva', ext.crypt('eva', ext.gen_salt('bf')), 'eva@mail.com', FALSE );

ALTER TABLE compte      ALTER COLUMN id_compte     RESTART WITH 10;
