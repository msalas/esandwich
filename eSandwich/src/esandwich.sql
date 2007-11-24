-- Database: esandwich

-- DROP DATABASE esandwich;

CREATE DATABASE esandwich;




-- Table: persona

-- DROP TABLE persona;

CREATE TABLE persona
(
  id serial NOT NULL,
  nif character varying(9),
  nombre character varying(50),
  apellido1 character varying(100),
  apellido2 character varying(100),
  direccion character varying(100),
  poblacion character varying(100),
  telefono character varying(16),
  movil character varying(16),
  email character varying(100),
  fecha_baja date,
  CONSTRAINT persona_pkey PRIMARY KEY (id)
) 
WITHOUT OIDS;


-- Table: usuario

-- DROP TABLE usuario;

CREATE TABLE usuario
(
  cod_usuario integer NOT NULL,
  pasword character varying(10),
  desactivado boolean,
  CONSTRAINT usuario_pkey PRIMARY KEY (cod_usuario),
  CONSTRAINT usuario_cod_usuario_fkey FOREIGN KEY (cod_usuario)
      REFERENCES persona (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: rol

-- DROP TABLE rol;

CREATE TABLE rol
(
  id serial NOT NULL,
  descripcion character varying(50),
  letra_rol character varying(1),
  CONSTRAINT rol_pkey PRIMARY KEY (id),
  CONSTRAINT rol_letrarol_key UNIQUE (letra_rol)
) 
WITHOUT OIDS;


-- Table: empleado

-- DROP TABLE empleado;

CREATE TABLE empleado
(
  cod_empleado integer NOT NULL,
  id_rol integer,
  CONSTRAINT empleado_pkey PRIMARY KEY (cod_empleado),
  CONSTRAINT empleado_cod_empleado_fkey FOREIGN KEY (cod_empleado)
      REFERENCES persona (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT empleado_id_rol_fkey FOREIGN KEY (id_rol)
      REFERENCES rol (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: cliente

-- DROP TABLE cliente;

CREATE TABLE cliente
(
  cod_cliente integer NOT NULL,
  tarjeta_credito character varying(19),
  puntos numeric,
  CONSTRAINT cliente_pkey PRIMARY KEY (cod_cliente),
  CONSTRAINT cliente_cod_cliente_fkey FOREIGN KEY (cod_cliente)
      REFERENCES persona (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: familia

-- DROP TABLE familia;

CREATE TABLE familia
(
  id serial NOT NULL,
  descripcion character varying(100),
  CONSTRAINT familia_pkey PRIMARY KEY (id)
) 
WITHOUT OIDS;


-- Table: producto

-- DROP TABLE producto;

CREATE TABLE producto
(
  id serial NOT NULL,
  descripcion character varying(200),
  descripcion_ampliada character varying(400),
  existencias numeric,
  id_familia integer,
  precio numeric(6,2),
  CONSTRAINT producto_pkey PRIMARY KEY (id),
  CONSTRAINT producto_id_familia_fkey FOREIGN KEY (id_familia)
      REFERENCES familia (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: tipo_sandwich

-- DROP TABLE tipo_sandwich;

CREATE TABLE tipo_sandwich
(
  id serial NOT NULL,
  descripcion character varying(100),
  fecha_baja date,
  CONSTRAINT tiposandwich_pkey PRIMARY KEY (id)
) 
WITHOUT OIDS;


-- Table: sandwich

-- DROP TABLE sandwich;

CREATE TABLE sandwich
(
  id integer NOT NULL,
  nombre character varying(100),
  id_tipo_sandwich integer,
  fecha_baja date,
  CONSTRAINT sandwich_pkey PRIMARY KEY (id),
  CONSTRAINT sandwich_id_fkey FOREIGN KEY (id)
      REFERENCES producto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT sandwich_id_tipo_sandwich_fkey FOREIGN KEY (id_tipo_sandwich)
      REFERENCES tipo_sandwich (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: ingrediente

-- DROP TABLE ingrediente;

CREATE TABLE ingrediente
(
  id_producto integer NOT NULL,
  id_ingrediente integer NOT NULL,
  cantidad numeric,
  CONSTRAINT ingrediente_pkey PRIMARY KEY (id_producto, id_ingrediente),
  CONSTRAINT ingrediente_id_ingrediente_fkey FOREIGN KEY (id_ingrediente)
      REFERENCES producto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT ingrediente_id_producto_fkey FOREIGN KEY (id_producto)
      REFERENCES producto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: tipo_promocion

-- DROP TABLE tipo_promocion;

CREATE TABLE tipo_promocion
(
  id serial NOT NULL,
  descripcion character varying(100),
  fecha_baja date,
  CONSTRAINT tipopromocion_pkey PRIMARY KEY (id)
) 
WITHOUT OIDS;


-- Table: promocion

-- DROP TABLE promocion;

CREATE TABLE promocion
(
  id serial NOT NULL,
  id_tipo_promocion integer,
  id_sandwich integer,
  id_producto integer,
  valor numeric,
  puntos_minimos numeric,
  fecha_baja date,
  CONSTRAINT promocion_pkey PRIMARY KEY (id),
  CONSTRAINT promocion_id_producto_fkey FOREIGN KEY (id_producto)
      REFERENCES producto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT promocion_id_sandwich_fkey FOREIGN KEY (id_sandwich)
      REFERENCES sandwich (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT promocion_id_tipo_promocion_fkey FOREIGN KEY (id_tipo_promocion)
      REFERENCES tipo_promocion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: pedido

-- DROP TABLE pedido;

CREATE TABLE pedido
(
  id serial NOT NULL,
  id_cliente integer,
  id_promocion integer,
  id_producto integer,
  importe numeric(6,2),
  fecha date,
  CONSTRAINT pedido_pkey PRIMARY KEY (id),
  CONSTRAINT pedido_id_cliente_fkey FOREIGN KEY (id_cliente)
      REFERENCES cliente (cod_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT pedido_id_producto_fkey FOREIGN KEY (id_producto)
      REFERENCES producto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT pedido_id_promocion_fkey FOREIGN KEY (id_promocion)
      REFERENCES promocion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: linea_pedido

-- DROP TABLE linea_pedido;

CREATE TABLE linea_pedido
(
  id_pedido integer NOT NULL,
  id_producto integer NOT NULL,
  unidades integer,
  CONSTRAINT linea_pedido_pkey PRIMARY KEY (id_pedido, id_producto),
  CONSTRAINT linea_pedido_id_pedido_fkey FOREIGN KEY (id_pedido)
      REFERENCES pedido (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT linea_pedido_id_producto_fkey FOREIGN KEY (id_producto)
      REFERENCES producto (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;


-- Table: factura

-- DROP TABLE factura;

CREATE TABLE factura
(
  id serial NOT NULL,
  id_pedido integer,
  fecha date,
  importe numeric,
  CONSTRAINT factura_pkey PRIMARY KEY (id),
  CONSTRAINT factura_id_pedido_fkey FOREIGN KEY (id_pedido)
      REFERENCES pedido (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
) 
WITHOUT OIDS;