CREATE TABLE IF NOT EXISTS connections(
 follower BIGINT NOT NULL,
 followee BIGINT NOT NULL,
 PRIMARY KEY(follower, followee)
);
