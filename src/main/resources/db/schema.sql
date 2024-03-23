CREATE TABLE IF NOT EXISTS policy (
                                      id SERIAL PRIMARY KEY,
                                      policy_number VARCHAR(255) NOT NULL,
                                      date_init DATE,
                                      date_end DATE,
                                      date_emission TIMESTAMP,
                                      CONSTRAINT unique_policy_number UNIQUE (policy_number)
);

CREATE TABLE IF NOT EXISTS policy_beneficiary (
                                                  id SERIAL PRIMARY KEY,
                                                  policy_id BIGINT NOT NULL,
                                                  document_type VARCHAR(255),
                                                  document_value VARCHAR(255),
                                                  name VARCHAR(255),
                                                  order_beneficiary INTEGER,
                                                  FOREIGN KEY (policy_id) REFERENCES policy(id)
);

CREATE TABLE IF NOT EXISTS policy_insured (
                                                  id SERIAL PRIMARY KEY,
                                                  policy_id BIGINT NOT NULL,
                                                  document_type VARCHAR(255),
                                                  document_value VARCHAR(255),
                                                  name VARCHAR(255),
                                                  order_insured INTEGER,
                                                  FOREIGN KEY (policy_id) REFERENCES policy(id)
);

CREATE TABLE IF NOT EXISTS policy_coverage (
                                               id SERIAL PRIMARY KEY,
                                               policy_id BIGINT NOT NULL,
                                               coverage_name VARCHAR(255),
                                               coverage_value NUMERIC(19, 2),
                                               coverage_premium NUMERIC(19, 2),
                                               FOREIGN KEY (policy_id) REFERENCES policy(id)
);