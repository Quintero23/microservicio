insert into categoria (id, nombre) values (1, 'shoes');
insert into categoria (id, nombre) values (2, 'books');
insert into categoria (id, nombre) values (3, 'electronics');


insert into producto (id, nombre, descripcion, stock, price, estado, fecha_creacion, categoria_id)
values (1, 'Adidas', 'Nueva version', 30, 500, 'Nuevos','2018-09-05',1);

insert into producto (id, nombre, descripcion, stock, price, estado, fecha_creacion, categoria_id)
values (2, 'La venganza', 'Nueva editorial', 500, 200, 'Editoriales','2020-05-01',2);

insert into producto (id, nombre, descripcion, stock, price, estado, fecha_creacion, categoria_id)
values (3, 'Refrigerador', 'MABE', 200, 5000, 'Linea Blanca','2021-10-08',3);