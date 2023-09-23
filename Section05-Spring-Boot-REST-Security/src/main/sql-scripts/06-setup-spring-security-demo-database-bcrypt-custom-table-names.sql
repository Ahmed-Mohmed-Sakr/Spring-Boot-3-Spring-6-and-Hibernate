USE `employee_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pw` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: ahmed
--                           : ali
--                           : nader
--

INSERT INTO `members`
VALUES
    ('ahmed','{bcrypt}$2a$10$vP6.js3yIo8yv0V5oLEiKekDa0lfilhUldTCc2l2lY1GShrHXdEqO',1),
    ('ali','{bcrypt}$2a$10$AIZbVPqT1YjnZ3GexgizgeIjiiNPTm/vd4Pq3Y6q0/LkwnAGBimt6',1),
    ('nader','{bcrypt}$2a$10$qwXZajrVJyXRybH.cSTPFOWzb8LPt4e0iMiUU4q.G.BeWfxoJXsLO',1);



--
-- Table structure for table `authorities`
--

CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
    ('ali','ROLE_EMPLOYEE'),
    ('nader','ROLE_EMPLOYEE'),
    ('nader','ROLE_MANAGER'),
    ('ahmed','ROLE_EMPLOYEE'),
    ('ahmed','ROLE_MANAGER'),
    ('ahmed','ROLE_ADMIN');