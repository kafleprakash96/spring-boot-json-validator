CREATE TABLE user (
                      id INT PRIMARY KEY NOT NULL,
                      name VARCHAR(255) NOT NULL,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      street VARCHAR(255),
                      city VARCHAR(255),
                      postalCode VARCHAR(10),
                      country VARCHAR(255),
                      newsletter BOOLEAN,
                      emailNotifications BOOLEAN,
                      smsNotifications BOOLEAN,
                      createdAt TIMESTAMP NOT NULL,
                      updatedAt TIMESTAMP NOT NULL
);

CREATE TABLE user_roles (
                            userId INT,
                            role VARCHAR(50) NOT NULL,
                            FOREIGN KEY (userId) REFERENCES user(id),
                            PRIMARY KEY (userId, role)
);

CREATE TABLE address (
                         userId INT PRIMARY KEY,
                         street VARCHAR(255) NOT NULL,
                         city VARCHAR(255) NOT NULL,
                         postalCode VARCHAR(10) NOT NULL,
                         country VARCHAR(255) NOT NULL,
                         FOREIGN KEY (userId) REFERENCES user(id)
);

CREATE TABLE preferences (
                             userId INT PRIMARY KEY,
                             newsletter BOOLEAN NOT NULL,
                             emailNotifications BOOLEAN NOT NULL,
                             smsNotifications BOOLEAN NOT NULL,
                             FOREIGN KEY (userId) REFERENCES user(id)
);

CREATE TABLE transactions (
                              transactionId VARCHAR(50) PRIMARY KEY NOT NULL,
                              userId INT,
                              amount DECIMAL(10, 2) NOT NULL,
                              currency VARCHAR(10) NOT NULL,
                              timestamp TIMESTAMP NOT NULL,
                              FOREIGN KEY (userId) REFERENCES user(id)
);

CREATE TABLE metadata (
                          version VARCHAR(50) NOT NULL,
                          source VARCHAR(50) NOT NULL
);
