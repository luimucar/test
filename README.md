# To configurate mysql:

It needs a mysql database called "pets" and a table called usuario. sql creation for this table in:
fireware-test-model/order.sql 

For the access configuration to db in:
fireware-test-model/src/main/resources/META-INF/persistence.xml


# To execute:

in the parent project:
mvn clean install

in the fiveware-test-web folder:

mvn tomcat7:run

then access in http://localhost:8080
