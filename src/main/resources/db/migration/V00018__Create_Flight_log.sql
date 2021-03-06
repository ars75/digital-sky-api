CREATE TABLE ds_flight_log
(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FLY_DRONE_APPLICATION_ID   VARCHAR(24),
    UIN_NO VARCHAR(10),
    SIGNATURE MEDIUMTEXT,
    CREATED_TIMESTAMP TIMESTAMP,
    CONSTRAINT pk_flight_log UNIQUE (FLY_DRONE_APPLICATION_ID,UIN_NO)
)