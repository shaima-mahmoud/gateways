DROP TABLE IF EXISTS device;

DROP TABLE IF EXISTS gateway;

CREATE TABLE gateway (
	id INT AUTO_INCREMENT PRIMARY KEY,
	serial_number VARCHAR(250) UNIQUE,
	name VARCHAR(250),
	address VARCHAR(15) NOT NULL
);

CREATE TABLE device (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	UID INT UNIQUE,
  	vendor VARCHAR(250),
	created DATE,
	status BOOLEAN,
	gateway_id INT,
	FOREIGN KEY (gateway_id) REFERENCES gateway(id)
);


INSERT INTO gateway (id, serial_number, name, address) VALUES (1,'GTW-1','Gateway 1','123.187.65.1');
INSERT INTO gateway (id, serial_number, name, address) VALUES (2,'GTW-2','Gateway 2','123.187.65.2');
INSERT INTO gateway (id, serial_number, name, address) VALUES (3,'GTW-3','Gateway 3','123.187.65.3');
INSERT INTO gateway (id, serial_number, name, address) VALUES (4,'GTW-4','Gateway 4','123.187.65.4');


INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (1,001,'huawei', parsedatetime('17-09-2012', 'dd-MM-yyyy'), true, 1);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (2,002,'intel', parsedatetime('11-07-2013', 'dd-MM-yyyy'), false, 1);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (3,003,'sony', parsedatetime('01-01-2015', 'dd-MM-yyyy'),true, 1);

INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (4,004,'sony', parsedatetime('17-09-2012', 'dd-MM-yyyy'),true, 2);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (5,005,'huawei', parsedatetime('11-10-2013', 'dd-MM-yyyy'),true, 2);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (6,006,'dell', parsedatetime('04-05-2010', 'dd-MM-yyyy'),true, 2);


INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (7,007,'sony', parsedatetime('13-09-2020', 'dd-MM-yyyy'),false, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (8,008,'dell', parsedatetime('05-09-2012', 'dd-MM-yyyy'),false, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (9,009,'intel', parsedatetime('12-12-2013', 'dd-MM-yyyy'),true, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (10,010,'dell', parsedatetime('17-07-2009', 'dd-MM-yyyy'),false, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (11,011,'sony', parsedatetime('15-05-2015', 'dd-MM-yyyy'),true, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (12,012,'toshiba', parsedatetime('09-09-2017', 'dd-MM-yyyy'),true, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (13,013,'intel', parsedatetime('10-10-2018', 'dd-MM-yyyy'),true, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (14,014,'dell', parsedatetime('11-11-2011', 'dd-MM-yyyy'),true, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (15,015,'sony', parsedatetime('01-06-2021', 'dd-MM-yyyy'),false, 3);
INSERT INTO device (id, UID, vendor, created, status, gateway_id) VALUES (16,016,'sony', parsedatetime('17-06-2012', 'dd-MM-yyyy'),true, 3);


