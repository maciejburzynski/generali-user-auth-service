CREATE SEQUENCE USERS_SEQ START WITH 1 INCREMENT BY 50;

CREATE TABLE USERS
(
    id                         BIGINT NOT NULL PRIMARY KEY,
    uuid                       VARCHAR,
    username                   VARCHAR,
    password                   VARCHAR,
    user_role                  VARCHAR,
    is_account_non_expired     BOOLEAN,
    is_account_non_locked      BOOLEAN,
    is_credentials_non_expired BOOLEAN,
    is_enabled                 BOOLEAN,
    version                    INT
);
INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
                  is_credentials_non_expired, is_enabled, version)
VALUES (NEXTVAL('USERS_SEQ'), 'f179fa95-67f4-4e10-8073-0935d8be426b', 'user',
        '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'USER', true, true, true, true, 0);

INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
                  is_credentials_non_expired, is_enabled, version)
VALUES (NEXTVAL('USERS_SEQ'), 'f179fa95-67f4-4e10-8073-0935d8be500b', 'superadmin',
        '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'SUPER_ADMIN', true, true, true, true, 0);

INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
                  is_credentials_non_expired, is_enabled, version)
VALUES (NEXTVAL('USERS_SEQ'), 'f179fa95-67f4-4e10-8073-0935d8be120b', 'user1',
        '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'USER', true, true, true, true,0);

INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
                  is_credentials_non_expired, is_enabled, version)
VALUES (NEXTVAL('USERS_SEQ'), 'f179fa95-67f4-4e10-8072-0935d8be500b', 'superadmin1',
        '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'SUPER_ADMIN', true, true, true, true,0);