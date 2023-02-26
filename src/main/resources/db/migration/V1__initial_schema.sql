CREATE TABLE persons (
  id BIGSERIAL,
  first_name TEXT NOT NULL,
  last_name TEXT NOT NULL,
  email TEXT NOT NULL,
  CONSTRAINT pk_persons PRIMARY KEY (id),
  CONSTRAINT uk_persons_email UNIQUE (email)
);
CREATE TABLE notes (
  id BIGSERIAL,
  person_id BIGINT,
  body TEXT,
  CONSTRAINT pk_notes PRIMARY KEY (id),
  CONSTRAINT fk_notes_persons FOREIGN KEY (person_id) REFERENCES persons (id)
);