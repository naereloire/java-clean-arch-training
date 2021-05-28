insert into recommendation.categories(category_name)
values
  ('Leitura'),
  ('Eletrodomesticos'),
  ('Beleza');

insert into recommendation.subcategories( subcategory_name,category_id)
values
    ('Livros',1),
    ('HQ',1),
    ('Fogoes',2),
    ('Cafeteiras',2),
    ('Cabelo',3),
    ('Maquiagem',3);

insert into recommendation.products( product_name,subcategory_id, price)
values
    ('Vidas Secas',1,10.99),
    ('Game of Thrones',1,29.99),
    ('The mighty Thor',2,89.99),
    ('Batman: A Piada Mortal',2,89.99),
    ('Cooktop',3,399.99),
    ('A Gás',3,899.99),
    ('Nespresso',4,250.99),
    ('Dolce Gusto',4,350.99),
    ('Condicionador',5,40.99),
    ('shampoo',5,28.99),
    ('Batons',6,32.99),
    ('Base',6,78.99);