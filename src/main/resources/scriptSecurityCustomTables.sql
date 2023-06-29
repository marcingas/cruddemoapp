USE student_tracker;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

CREATE TABLE `members` (
`user_id` varchar(50) NOT NULL,
`paw` varchar(68) NOT NULL,
`active` tinyint NOT NULL,
PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `members`
VALUES
('john', '{bcrypt}$2a$10$eFn0NixyHKA9eMRY5QEZr.JhcCl.Mld0GlxX0KEW.emm4h14.OKL2',1),
('mary','{bcrypt}$2a$10$eFn0NixyHKA9eMRY5QEZr.JhcCl.Mld0GlxX0KEW.emm4h14.OKL2',1),
('ann','{bcrypt}$2a$10$eFn0NixyHKA9eMRY5QEZr.JhcCl.Mld0GlxX0KEW.emm4h14.OKL2',1);

CREATE TABLE `roles` (
`user_id` varchar(50) NOT NULL,
`role` varchar(50) NOT NULL,
UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `roles`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('ann','ROLE_EMPLOYEE'),
('ann','ROLE_MANAGER'),
('ann','ROLE_ADMIN');
