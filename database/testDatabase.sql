BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `book` (
	`ID`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`Name`	TEXT NOT NULL,
	`Price`	INTEGER NOT NULL
);
INSERT INTO `book` VALUES (1,'6 Awake','10$');
INSERT INTO `book` VALUES (2,'The Lord of Rings','35.72$');
INSERT INTO `book` VALUES (3,'The Goldfinch','12$');
INSERT INTO `book` VALUES (4,'How much for young','5$');
INSERT INTO `book` VALUES (5,'One Way Train','16$');
COMMIT;
