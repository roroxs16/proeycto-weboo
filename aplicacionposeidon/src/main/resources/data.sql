INSERT INTO `role` (autoridad) VALUES ('ROLE_ADMIN');
INSERT INTO `role` (autoridad) VALUES ('ROLE_USER');
INSERT INTO `usuario` (apellidos, ciudad, correo, direccion, fecha_nacimiento, nombre, password, run, telefono) VALUES ( 'Admin', 'Chillan', 'admin@poseidon.cl', 'chillan', '2020-03-09 00:00:00', 'Admin', '$2a$10$YP5wLfS9YiURvmi1e2ENa.VMh2oCtpm4GHTM8QiriMcboHm4uxtZu', '33.333.333-3', '942750783');

INSERT INTO `usuario_roles` (usuario_id, roles_id) VALUES ('1', '1');