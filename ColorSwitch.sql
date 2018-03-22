SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- Base de données :  ColorSwitch
CREATE DATABASE IF NOT EXISTS `ColorSwitch`
  DEFAULT CHARACTER SET utf16
  COLLATE utf16_bin;
USE `ColorSwitch`;

-- Structure de la table `partie`

DROP TABLE IF EXISTS `partie`;
CREATE TABLE `partie` (
  `ID_partie`                   INT(11)  NOT NULL,
  `ID_user`                     INT(11)  NOT NULL,
  `date_heur_partie`            DATETIME NOT NULL,
  `nb_portes_traversees_partie` INT(11)  NOT NULL,
  `nb_etoiles_ramassee_partie`  INT(11)  NOT NULL,
  `score_partie`                INT(11)  NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf16
  COLLATE = utf16_bin;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID_user`     INT(11)                        NOT NULL,
  `pseudo_user` VARCHAR(255) COLLATE utf16_bin NOT NULL
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf16
  COLLATE = utf16_bin;

ALTER TABLE `partie`
  ADD PRIMARY KEY (`ID_partie`),
  ADD KEY `FK_ID_user_in_partie` (`ID_user`);


ALTER TABLE `user`
  ADD PRIMARY KEY (`ID_user`),
  ADD UNIQUE KEY `ID_user` (`ID_user`);

ALTER TABLE `partie`
  MODIFY `ID_partie` INT(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `user`
  MODIFY `ID_user` INT(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `partie`
  ADD CONSTRAINT `FK_ID_user_in_partie` FOREIGN KEY (`ID_user`) REFERENCES `user` (`ID_user`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;