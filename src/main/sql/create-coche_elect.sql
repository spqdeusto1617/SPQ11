/* DELETE 'coche_elect' database*/
DROP SCHEMA IF EXISTS coche_elect;
/* DELETE USER 'spq' AT LOCAL SERVER*/
DROP USER IF EXISTS 'spq'@'%';
/* CREATE 'coche_elect' DATABASE */
CREATE SCHEMA coche_elect;
/* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
CREATE USER IF NOT EXISTS 'spq'@'%' IDENTIFIED BY 'spq';

GRANT ALL ON coche_elect.* TO 'spq'@'%';