# Fixture <img src="https://raw.githubusercontent.com/chrisPiemonte/Fixture/master/src/main/resources/static/images/logo_mini.d9252743.png?token=AJohXj5CL3cGEQo1QKfLO61AcODy-9kIks5amfafwA%3D%3D" width="50">

[![Docker](https://img.shields.io/badge/Docker-17.05-blue.svg?style=flat-square)](https://www.docker.com/)
[![AngularJS version](https://img.shields.io/badge/AngularJS-1.4.0-red.svg?style=flat-square)](https://angular.io/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-1.5.10-green.svg?style=flat-square)](https://spring.io/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-10.2-blue.svg?style=flat-square)](https://www.postgresql.org/)
[![ElasticSearch](https://img.shields.io/badge/ElasticSearch-6.2.1-yellow.svg?style=flat-square)](https://www.elastic.co/products/elasticsearch)
[![Logstash](https://img.shields.io/badge/Logstash-6.2.1-blue.svg?style=flat-square)](https://www.elastic.co/products/logstash)
[![Kibana](https://img.shields.io/badge/Kibana-6.2.1-ff69b4.svg?style=flat-square)](https://www.elastic.co/products/kibana)


**Ticketing system** service composed of three layers:

 - **Client**: Single Page Application made using **[AngularJS](https://angular.io/)**

 - **Server**: Server Side Application exposed over http made using **[Spring Boot](https://spring.io/)**

 - **Database**: **[PostgreSQL](https://www.postgresql.org/)**

<p align="justify">
Everything runs inside <a href="https://www.docker.com/"><b>Docker</b></a> containers, linked together with <a href="https://docs.docker.com/compose/overview/"><b>Docker Compose</b></a>. As Analytics framework, the <a href="https://www.elastic.co/products"><b>Elastic Stack</b></a> has been used by sending data of interest to Elastic Search, through Logstash, and querying and analyzing it with Kibana.
</p>

## Setup

### Linux:
1. Install [docker](https://docs.docker.com/install/), [docker-compose](https://docs.docker.com/compose/install/) and [git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

2. Clone this repo:<pre>git clone https://github.com/chrisPiemonte/Fixture.git </pre> <pre>cd Fixture/</pre>

3. Run:<pre>docker-compose -p fixture up -d </pre>

## Getting started
1. Open a web browser and go to <pre>http://localhost:8080</pre>

2. Kibana <pre>http://localhost:5601</pre>

3. To populate the Database go to <pre>http://localhost:8080/api/populate</pre> (it takes a while)

## Overview
- [Database](https://github.com/chrisPiemonte/Fixture#database)
- [Server](https://github.com/chrisPiemonte/Fixture#server)
- [Client](https://github.com/chrisPiemonte/Fixture#client)
- [Analytics](https://github.com/chrisPiemonte/Fixture#analytics)

### Database

###### Requirements

<table>
  <tr>
    <td colspan="2" align="center"><b>AFC United</b></td>
  </tr>
  <tr>
    <td align="justify">
    AFC United is a football club that host matches (also known as Fixtures) against an opposing team. A database is required by the club to hold information to support the booking of seats to watch a match at the club’s stadium over the course of several seasons. Prior to the start of a season a set of fixtures are arranged between AFC United (the home team) and an opposing team (the away team). Matches are watched by spectators who have registered with the club. These are called PassHolders. PassHolders must book seats in advance for any of the 20 home fixtures of that season. Once a Seat is booked (and payment made), the Pass Holder is issued with one or more Tickets. This because a PassHolder can purchase one or more tickets for seats for each fixture. For every ticket we know the associated person, with name, surname, date of birth and place of birth. A particular seat can have restricted occupancy. This is recorded as the seating type (for example "reserved for the president", "reserved for disabled"). Every seat, depending on its position/ sector has a different price, which can also change fixture by fixture.</td>
  </tr>
</table>

##### ER Schema

![ER Schema](https://raw.githubusercontent.com/chrisPiemonte/Fixture/master/documentation/img/er.png "ER Schema")

##### PostgreSQL Schema

The schema is defined in <a href="https://github.com/chrisPiemonte/Fixture/blob/master/database/schema/schema.sql">database/schema.sql</a>.

##### Physical Schema

<p align="justify">
Table Biglietto (Ticket) has been partitioned via table inheritance. Each partition is automatically created, as a child table, at the insertion of a new Stagione (Season), so there is a partition for each row in Stagione. The parent table itself is normally empty; it exists just to represent the entire table when queried. Insertions are redirected to child tables via <a href="https://github.com/chrisPiemonte/Fixture/blob/master/database/schema/schema.sql#L80">triggers</a>.

</br>

Table constraints are added to each child table to define the allowed key values in each partition. Constraint exclusion is a query optimization technique that improves performance for partitioned tables. Without constraint exclusion, the above query would scan each of the partitions of the measurement table. With constraint exclusion enabled (or set to PARTITION), the planner will examine the constraints of each partition and try to prove that the partition need not be scanned because it could not contain any rows meeting the query's WHERE clause. When the planner can prove this, it excludes the partition from the query plan.

</br>

![Explain](https://raw.githubusercontent.com/chrisPiemonte/Fixture/master/documentation/img/explain_partition.png "Explain")


This implementation is based on the official documentation as explained [here](https://www.postgresql.org/docs/9.1/static/ddl-partitioning.html).
</p></br>

### Server
REST API with [Spring Boot](https://projects.spring.io/spring-boot/) and ORM with [Hibernate](http://hibernate.org/)
</br></br>

### Client
Single page application with [AngularJS](https://angular.io/).
</br></br>

### Analytics
Insertions on table Biglietto are sent to [Logstash](https://www.elastic.co/products/logstash), as JSONs, through HTTP requests, which filters and send them to [Elastic Search](https://www.elastic.co/products/elasticsearch). Charts, dashboards and UI are provided by [Kibana](https://www.elastic.co/products/kibana).
