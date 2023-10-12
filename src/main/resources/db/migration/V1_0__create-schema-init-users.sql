CREATE TABLE USERS
(
    id                         BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    uuid                       VARCHAR,
    username                   VARCHAR,
    password                   VARCHAR,
    user_role                  VARCHAR,
    is_account_non_expired     BOOLEAN,
    is_account_non_locked      BOOLEAN,
    is_credentials_non_expired BOOLEAN,
    is_enabled                 BOOLEAN
);
INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
                    is_credentials_non_expired, is_enabled)
VALUES (1,'f179fa95-67f4-4e10-8073-0935d8be426b', 'user', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'USER', true, true, true, true);

INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
             is_credentials_non_expired, is_enabled)
VALUES (2,'f179fa95-67f4-4e10-8073-0935d8be500b', 'superadmin', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'SUPER_ADMIN', true, true, true, true);

INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
                    is_credentials_non_expired, is_enabled)
VALUES (3,'f179fa95-67f4-4e10-8073-0935d8be120b', 'user1', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'USER', true, true, true, true);

INSERT INTO USERS(id, uuid, username, password, user_role, is_account_non_expired, is_account_non_locked,
             is_credentials_non_expired, is_enabled)
VALUES (4,'f179fa95-67f4-4e10-8072-0935d8be500b', 'superadmin1', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'SUPER_ADMIN', true, true, true, true);