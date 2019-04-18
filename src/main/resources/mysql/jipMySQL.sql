-- create jip database
DROP DATABASE IF EXISTS jip_jianyu;
CREATE DATABASE jip_jianyu;

Use jip_jianyu;

-- create user and grant permission
-- GRANT all ON jip_jianyu.* TO 'fish'@"%" IDENTIFIED BY "fish";
GRANT all ON jip_jianyu.* TO 'fish'@"localhost" IDENTIFIED BY "fish";

-- create patient table
DROP TABLE IF EXISTS patient;

CREATE TABLE `patient` (
  `PatientID` int(11) NOT NULL AUTO_INCREMENT,
  `LastName` varchar(45) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `Diagnosis` text,
  `AdmissionDate` timestamp NULL DEFAULT NULL,
  `ReleaseDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`PatientID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `jip_jianyu`.`patient` (`LastName`, `FirstName`, `Diagnosis`, `AdmissionDate`, `ReleaseDate`) VALUES ('Ron', 'Ray', 'flu#1\r\nflu#2', DATE_ADD(NOW(), INTERVAL -100 HOUR),  DATE_ADD(NOW(), INTERVAL -100 MINUTE));
INSERT INTO `jip_jianyu`.`patient` (`LastName`, `FirstName`, `Diagnosis`, `AdmissionDate`, `ReleaseDate`) VALUES ('Bean', 'Ben', 'cold#1\r\ncold#2', DATE_ADD(NOW(), INTERVAL -120 HOUR),  DATE_ADD(NOW(), INTERVAL -200 MINUTE));
INSERT INTO `jip_jianyu`.`patient` (`LastName`, `FirstName`, `Diagnosis`, `AdmissionDate`, `ReleaseDate`) VALUES ('Cray', 'Cris', 'fever', DATE_ADD(NOW(), INTERVAL -150 HOUR),  DATE_ADD(NOW(), INTERVAL -300 MINUTE));
INSERT INTO `jip_jianyu`.`patient` (`LastName`, `FirstName`, `Diagnosis`, `AdmissionDate`, `ReleaseDate`) VALUES ('Jay', 'John', 'not big deal', DATE_ADD(NOW(), INTERVAL -110 HOUR),  DATE_ADD(NOW(), INTERVAL -400 MINUTE));
INSERT INTO `jip_jianyu`.`patient` (`LastName`, `FirstName`, `Diagnosis`, `AdmissionDate`, `ReleaseDate`) VALUES ('Louis', 'Lucy', 'stomachache', DATE_ADD(NOW(), INTERVAL -20 HOUR), null);
INSERT INTO `jip_jianyu`.`patient` (`LastName`, `FirstName`, `Diagnosis`, `AdmissionDate`, `ReleaseDate`) VALUES ('Tom', 'Ted', 'a little cold\r\nthats it', DATE_ADD(NOW(), INTERVAL -18 HOUR),  null);
INSERT INTO `jip_jianyu`.`patient` (`LastName`, `FirstName`, `Diagnosis`, `AdmissionDate`, `ReleaseDate`) VALUES ('Ma', 'Land', 'recovered', DATE_ADD(NOW(), INTERVAL -10 HOUR),  null);

-- create inpatient table
DROP TABLE IF EXISTS inpatient;

CREATE TABLE `inpatient` (
  `InpatientID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) NOT NULL,
  `Date` timestamp NULL DEFAULT NULL,
  `RoomNumber` varchar(45) DEFAULT NULL,
  `DailyRoomRate` decimal(13,2) DEFAULT NULL,
  `RoomSupplies` decimal(13,2) DEFAULT NULL,
  `RoomServices` decimal(13,2) DEFAULT NULL,
  PRIMARY KEY `patientID_idx` (`InpatientID`),
  CONSTRAINT `inpatient.patientid` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (2, DATE_ADD(NOW(), INTERVAL -1 DAY), 'room101', 88, 22, 11);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (3, DATE_ADD(NOW(), INTERVAL -1 DAY), 'room102', 99, 33, 9.99);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (4, DATE_ADD(NOW(), INTERVAL -1 DAY), 'room103', 50, 19.99, 8.99);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (5, DATE_ADD(NOW(), INTERVAL -1 DAY), 'room104', 80, 20, 10);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (5, DATE_ADD(NOW(), INTERVAL -2 DAY), 'room104', 180, 20, 10);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (6, DATE_ADD(NOW(), INTERVAL -1 DAY), 'room105', 80, 120, 10);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (7, DATE_ADD(NOW(), INTERVAL -2 DAY), 'room106', 80, 30, 110);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (7, DATE_ADD(NOW(), INTERVAL -1 DAY), 'room107', 80, 130, 10);
INSERT INTO `jip_jianyu`.`inpatient` (`PatientID`, `Date`, `RoomNumber`, `DailyRoomRate`, `RoomSupplies`, `RoomServices`) VALUES (8, DATE_ADD(NOW(), INTERVAL -1 DAY), 'room108', 150, 35, 10);

-- create surgical table
DROP TABLE IF EXISTS surgical;

CREATE TABLE `surgical` (
  `SurgicalID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) NOT NULL,
  `Date` timestamp NULL DEFAULT NULL,
  `SurgicalProcedure` varchar(256) DEFAULT NULL,
  `OperatingRoomFee` decimal(13,2) DEFAULT NULL,
  `SurgeonFee` decimal(13,2) DEFAULT NULL,
  `SurgicalSupplies` decimal(13,2) DEFAULT NULL,
  PRIMARY KEY `patientid_idx` (`SurgicalID`),
  CONSTRAINT `surgical.patientid` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (2, DATE_ADD(NOW(), INTERVAL -1 DAY), 'put plaster', 45, 100, 50);
INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (3, DATE_ADD(NOW(), INTERVAL -2 DAY), 'cure cold', 55, 150, 50);
INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (4, DATE_ADD(NOW(), INTERVAL -1 DAY), 'put plaster', 65, 100, 50);
INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (5, DATE_ADD(NOW(), INTERVAL -2 DAY), 'cure cold', 75, 150, 50);
INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (6, DATE_ADD(NOW(), INTERVAL -1 DAY), 'put plaster', 85, 100, 50);
INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (7, DATE_ADD(NOW(), INTERVAL -2 DAY), 'cure cold', 95, 150, 50);
INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (8, DATE_ADD(NOW(), INTERVAL -1 DAY), 'put plaster', 105, 100, 50);
INSERT INTO `jip_jianyu`.`surgical` (`PatientID`, `Date`, `SurgicalProcedure`, `OperatingRoomFee`, `SurgeonFee`, `SurgicalSupplies`) VALUES (8, DATE_ADD(NOW(), INTERVAL -2 DAY), 'cure cold', 115, 150, 50);

-- create medication table
DROP TABLE IF EXISTS medication;

CREATE TABLE `medication` (
  `MedicationID` int(11) NOT NULL AUTO_INCREMENT,
  `PatientID` int(11) NOT NULL,
  `Date` timestamp NULL DEFAULT NULL,
  `Medication` varchar(256) DEFAULT NULL,
  `CostPerUnit` decimal(13,2) DEFAULT NULL,
  `NumberOfUnits` int(11) DEFAULT NULL,
  PRIMARY KEY `patient_idx` (`MedicationID`),
  CONSTRAINT `medication.patientid` FOREIGN KEY (`PatientID`) REFERENCES `patient` (`PatientID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (2, DATE_ADD(NOW(), INTERVAL -10 HOUR), 'red pill', 25, 2);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (3, DATE_ADD(NOW(), INTERVAL -20 HOUR), 'blue pill', 20, 2);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (4, DATE_ADD(NOW(), INTERVAL -25 HOUR), 'yellow pill', 30, 1);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (5, DATE_ADD(NOW(), INTERVAL -16 HOUR), 'white pill', 25, 1);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (5, DATE_ADD(NOW(), INTERVAL -22 HOUR), 'white pill', 25, 1);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (5, DATE_ADD(NOW(), INTERVAL -15 HOUR), 'white pill', 25, 1);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (6, DATE_ADD(NOW(), INTERVAL -24 HOUR), 'blue pill', 30, 2);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (7, DATE_ADD(NOW(), INTERVAL -12 HOUR), 'white pill', 15, 1);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (7, DATE_ADD(NOW(), INTERVAL -18 HOUR), 'white pill', 15, 1);
INSERT INTO `jip_jianyu`.`medication` (`PatientID`, `Date`, `Medication`, `CostPerUnit`, `NumberOfUnits`) VALUES (8, DATE_ADD(NOW(), INTERVAL -1 HOUR), 'white pill', 15, 2);
