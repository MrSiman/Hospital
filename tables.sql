create table userlist (
	id int auto_increment primary key,
    user_name varchar(255) not null,
    user_password varchar(255) not null,
    user_admin boolean default false
);

create table profession (
	code_p varchar(6) not null primary key,
    name_prof varchar(255) not null
);

create table doctors (
	num_passport varchar(8) not null primary key,
    FIO varchar(255) not null,
    prof_code varchar(6),
    salary int,
    sex boolean,
    foreign key (prof_code) references profession(code_p)
);

create table service_type (
	code_t varchar(6) not null primary key,
    type_name varchar(255) not null
);

create table service_list (
	code_s varchar(6) not null primary key,
    type_code varchar(6),
    name_service varchar(255) not null,
    cost int,
    foreign key (type_code) references service_type(code_t)
);


create table patients (
	num_passport varchar(8) not null primary key,
    num_passport_doctor varchar(8),
    FIO varchar(255) not null,
    DoB date,
    recording_date date not null,
    sex boolean,
    foreign key (num_passport_doctor) references doctors(num_passport)
);

create table complete_services (
	id int auto_increment primary key,
    service_name varchar(255),
    doctor_FIO varchar(255),
    patient_FIO varchar(255),
    date_complete date,
    time_begin time,
    time_end time,
    cost int
)