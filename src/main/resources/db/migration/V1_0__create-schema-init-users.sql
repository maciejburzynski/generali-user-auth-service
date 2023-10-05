CREATE TABLE USERS
(
    id                         BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username                   VARCHAR,
    password                   VARCHAR,
    user_role                  VARCHAR,
    is_account_non_expired     BOOLEAN,
    is_account_non_locked      BOOLEAN,
    is_credentials_non_expired BOOLEAN,
    is_enabled                 BOOLEAN
);
INSERT INTO USERS(id, username, password, user_role, is_account_non_expired, is_account_non_locked,
                    is_credentials_non_expired, is_enabled)
VALUES (1, 'user', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'USER', true, true, true, true);

INSERT INTO USERS(id, username, password, user_role, is_account_non_expired, is_account_non_locked,
             is_credentials_non_expired, is_enabled)
VALUES (2, 'superadmin', '$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW', 'SUPER_ADMIN', true, true, true, true);