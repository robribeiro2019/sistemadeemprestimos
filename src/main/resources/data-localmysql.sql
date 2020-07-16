insert into customer (address, customer_name) values ('Rua A, casa 2 - Niterói-RJ', 'José das Coves');
insert into customer (address, customer_name) values ('Rua B, casa 1 - Rio de Janeiro-RJ', 'Maria da Vida');
insert into customer (address, customer_name) values ('Rua C, casa 8 - São Gonçalo-RJ', 'Manoel e Joaquim');
insert into customer (address, customer_name) values ('Rua D, casa 52 - Rio de Janeiro-RJ', 'Silvia da Rosa');
insert into customer (address, customer_name) values ('Rua E, casa 22 - Niterói-RJ', 'Elis Regina Souza');

insert into collector (collector_name) values ('Banco Santander');
insert into collector (collector_name) values ('Banco Bradesco');
insert into collector (collector_name) values ('NuBank');
insert into collector (collector_name) values ('Banco do Brasil');

insert into payment_type (payment_type_description) values ('Débito');
insert into payment_type (payment_type_description) values ('Crédito');

insert into loan_contract (Date_Contract_Starts, Date_Contract_Ends, Interest_Rate, Loan_Amount, Loan_Payment_Amount_Due, Loan_Payment_Frequency, Loan_Payment_Due_Date, Customer_Number, CollectorID) values ('0001-01-01','0001-01-01',10,10,10,10,'0001-01-01',1,1);