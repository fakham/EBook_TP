create database ventes_ebook;

use ventes_ebook;

create table livres(
	id int primary key auto_increment,
    description varchar(100),
    prix float,
    qtte int
);

create table clients(
	id int primary key auto_increment,
    prenom varchar(30),
    nom varchar(30),
    email varchar(30),
    password varchar(30)
);

create table carts(
	id int primary key auto_increment,
    client int,
    constraint foreign key(client) references clients(id)
);

create table carts_livres(
	id int primary key auto_increment,
    cart int,
    livre int,
    constraint foreign key(cart) references carts(id),
    constraint foreign key(livre) references livre(id)
);


insert into livres(description, prix, qtte)
values('Au coeur de Java : Notions Fondamentales', 600.95, 10);
insert into livres(description, prix, qtte)
values('Au coeur de Java : Fonctions Avancees', 800.95, 10);
insert into livres(description, prix, qtte)
values('Java En concentre', 700.95, 10);
insert into livres(description, prix, qtte)
values('JSP et Servlet efficace', 400.95, 10);