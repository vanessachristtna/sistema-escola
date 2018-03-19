create database EscolaProfessor;

use EscolaProfessor;



create table Escola(
	id_escola int not null,
	nome_escola varchar(100),
	
nome_diretor varchar(60),
	
primary key(id_escola)
);

create table Professor(
	cod_prof int not null,
	escola int,
	
horario varchar(5),
	
primary key(cod_prof),
	foreign key(escola) references Escola(id_escola) 
);

create table Sala(
	id_sala int not null



,
        id_escola int,
	id_professor int,
        primary key(id_sala),
        foreign key(id_escola) references Escola(id_escola),
	foreign key(id_professor) references Professor(cod_prof)
);






create table Aluno(
	id_aluno int not null,
	
nome_aluno varchar(100),
        id_sala int,
        primary key(id_aluno),
        foreign key(id_sala) references Sala(id_sala)
);

