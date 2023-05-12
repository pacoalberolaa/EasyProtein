insert into cesta values(1);

--Usuarios
insert into usuarios (username, passwd) values('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');

--Aminoacidos
insert into aminoacidos (nombre, marca, precio, cantidad, tipo, descripcion) values('alanina', 'prozis', 23.3, 100, 'esencial', 'aminoacido esencial');

--Barritas
insert into barritas (nombre, marca, precio, sabores, descripcion) values('barrita proteina', 'prozis', 3.3, 'chocolate' , 'barrita proteica');

--Carbohidratos
insert into carbohidratos (nombre, marca, precio, cantidad, tipo, descripcion) values('carbohidratos', 'prozis', 30.3, 100, 'mass gainer', 'hidratos de carbono');

--Creatinas
insert into creatina (nombre, marca, precio, cantidad, creapure, descripcion) values('creatinina', 'prozis', 29.3, 10, 1, 'creatina creapure');

--Proteinas
insert into proteina (nombre, marca, precio, cantidad, tipo, descripcion, imagen_url) values('whey protein', 'prozis', 33.3, 100, 'whey', 'proteina esencial', '/source/index/recomendados/wheyProtein_MP.png');

--Vitaminas
insert into vitaminas (nombre, marca, precio, cantidad, descripcion) values('vitamina D', 'prozis', 13.3, 10, 'vitaminas gominola');

--Otros
insert into otros (producto, marca, precio, descripcion) values('chuches 0', 'hsn', 3.3, 'chuches 0 calorias');

--Sabores
insert into sabores (sabores, id_creatina, id_aminoacidos) values('fresa', 1, 1);

--Sabores de proteina
insert into sabores_proteina (sabores_proteina, id_proteina) values('chocolate', 1);

--Sabores de avena
insert into sabores_avena (sabores_avena, id_carbohidratos) values('galleta', 1);
