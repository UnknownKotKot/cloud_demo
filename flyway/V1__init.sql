create table products
(
    id              bigserial primary key,
    title           varchar(255),
    price           int,
    created_at      timestamp default current_timestamp,
    updated_at      timestamp default current_timestamp
);
insert into products (title, price)
values
('Bread', 25),
('Milk', 80),
('Aqua', 30),
('Salt', 20),
('Sugar', 40),
('Potato', 16),
('Tomato', 256),
('Cucumber', 140);





