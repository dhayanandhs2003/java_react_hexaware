create database easypay_db;

use easypay_db;

create table users (
    user_id int primary key auto_increment,
    username varchar(100) unique,
    password_hash varchar(255),
    role enum('admin', 'hr', 'employee', 'manager', 'processor'),
    created_at timestamp default current_timestamp
);

create table employees (
    employee_id int primary key auto_increment,
    user_id int,
    name varchar(100),
    email varchar(100),
    dob date,
    designation varchar(100),
    doj date,
    salary decimal(10,2),
    status enum('active', 'inactive'),
    foreign key (user_id) references users(user_id)
);

create table payroll_policies (
    policy_id int primary key auto_increment,
    policy_name varchar(100),
    description text,
    tax_percentage decimal(5,2),
    benefit_percentage decimal(5,2),
    created_at timestamp default current_timestamp
);

create table benefits (
    benefit_id int primary key auto_increment,
    employee_id int,
    benefit_type varchar(100),
    amount decimal(10,2),
    effective_from date,
    foreign key (employee_id) references employees(employee_id)
);

create table payroll (
    payroll_id int primary key auto_increment,
    employee_id int,
    month varchar(20),
    year int,
    base_salary decimal(10,2),
    benefits decimal(10,2),
    tax decimal(10,2),
    net_pay decimal(10,2),
    generated_on timestamp default current_timestamp,
    foreign key (employee_id) references employees(employee_id)
);

create table leave_requests (
    leave_request_id int primary key auto_increment,
    employee_id int,
    leave_type varchar(50),
    start_date date,
    end_date date,
    status enum('pending', 'approved', 'rejected'),
    reason text,
    foreign key (employee_id) references employees(employee_id)
);

create table timesheets (
    timesheet_id int primary key auto_increment,
    employee_id int,
    work_date date,
    hours_worked decimal(4,2),
    remarks varchar(255),
    foreign key (employee_id) references employees(employee_id)
);

create table audit_logs (
    audit_id int primary key auto_increment,
    user_id int,
    action varchar(255),
    timestamp timestamp default current_timestamp,
    foreign key (user_id) references users(user_id)
);

create table notifications (
    notification_id int primary key auto_increment,
    user_id int,
    message text,
    is_read boolean default false,
    created_at timestamp default current_timestamp,
    foreign key (user_id) references users(user_id)
);

show tables;

desc benefits;
desc employees;
desc leave_requests;
desc payroll;
desc payroll_policies;
desc timesheets;
desc users;

