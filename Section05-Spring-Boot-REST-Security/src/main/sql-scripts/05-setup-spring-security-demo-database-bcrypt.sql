USE `employee_directory`;

DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: ahmed
--                           : ali
--                           : nader
--

INSERT INTO `users`
VALUES
('ahmed','{bcrypt}$2a$10$vP6.js3yIo8yv0V5oLEiKekDa0lfilhUldTCc2l2lY1GShrHXdEqO',1),
('ali','{bcrypt}$2a$10$AIZbVPqT1YjnZ3GexgizgeIjiiNPTm/vd4Pq3Y6q0/LkwnAGBimt6',1),
('nader','{bcrypt}$2a$10$qwXZajrVJyXRybH.cSTPFOWzb8LPt4e0iMiUU4q.G.BeWfxoJXsLO',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
    ('ali','ROLE_EMPLOYEE'),
    ('nader','ROLE_EMPLOYEE'),
    ('nader','ROLE_MANAGER'),
    ('ahmed','ROLE_EMPLOYEE'),
    ('ahmed','ROLE_MANAGER'),
    ('ahmed','ROLE_ADMIN');