
/*ROLES */
insert into roles (id, name) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'USER');
insert into roles (id, name) values ('4d0f7301-c123-4189-9636-066531275bf4', 'DEV');
insert into roles (id, name) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'ADMIN');


/*AUTHORITIES */
insert into authorities (id, name) values ('4ab22cdc-0cf9-4354-92ab-68702d54ffd0', 'USER_READ');
insert into authorities (id, name) values ('b7a6d679-9ebc-4f8a-b5be-52aa35a2285c', 'PLANTS_READ');
insert into authorities (id, name) values ('fd22ce26-6e5a-45a7-ab37-2c5e0ca83777', 'PLANTS_WRITE');




/*USER */
insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', '4ab22cdc-0cf9-4354-92ab-68702d54ffd0');
insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'b7a6d679-9ebc-4f8a-b5be-52aa35a2285c');
insert into role_authority (role_id, authority_id) values ('a05d3a73-5f6a-4cb3-ac13-a493163515a4', 'fd22ce26-6e5a-45a7-ab37-2c5e0ca83777');


/*DEV */
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', '4ab22cdc-0cf9-4354-92ab-68702d54ffd0');
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'b7a6d679-9ebc-4f8a-b5be-52aa35a2285c');
insert into role_authority (role_id, authority_id) values ('4d0f7301-c123-4189-9636-066531275bf4', 'fd22ce26-6e5a-45a7-ab37-2c5e0ca83777');


/*ADMIN*/
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', '4ab22cdc-0cf9-4354-92ab-68702d54ffd0');
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'b7a6d679-9ebc-4f8a-b5be-52aa35a2285c');
insert into role_authority (role_id, authority_id) values ('8383b369-3f33-4b39-97dd-ddf172b39e45', 'fd22ce26-6e5a-45a7-ab37-2c5e0ca83777');














