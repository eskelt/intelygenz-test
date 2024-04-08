DROP TABLE IF EXISTS DATASETS_VALUES;
DROP TABLE IF EXISTS NUMBERS_DATASETS;

CREATE TABLE NUMBERS_DATASETS (
	ID BIGINT NOT NULL AUTO_INCREMENT,
	DATASET_CODE VARCHAR(100) NOT NULL,
	CONSTRAINT NUMBERS_DATASETS_PK PRIMARY KEY (ID)
);

CREATE TABLE DATASETS_VALUES (
	ID BIGINT NOT NULL AUTO_INCREMENT,
	NUMBERS_DATASETS_ID BIGINT NOT NULL,
	NUMBER_VALUE BIGINT NOT NULL,
	CONSTRAINT DATASETS_VALUES_PK PRIMARY KEY (ID),
	CONSTRAINT DATASETS_VALUES_NUMBERS_DATASETS_FK FOREIGN KEY (NUMBERS_DATASETS_ID) REFERENCES PUBLIC.NUMBERS_DATASETS(ID)
);