# Fixture <img src="https://raw.githubusercontent.com/chrisPiemonte/Fixture/master/src/main/resources/static/images/logo_mini.d9252743.png?token=AJohXj5CL3cGEQo1QKfLO61AcODy-9kIks5amfafwA%3D%3D" width="64">

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

Everything runs inside **[Docker](https://www.docker.com/)** containers, linked together with **[Docker Compose](https://docs.docker.com/compose/overview/)**. As Analytics framework, the **[Elastic Stack](https://www.elastic.co/products)** has been used by sending data of interest to Elastic Search, through Logstash, and querying and analyzing it with Kibana.


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

###### ER Schema

![alt text](https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "Logo Title Text 1")
