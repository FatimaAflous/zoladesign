-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 25 août 2024 à 01:26
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `zoladesign`
--

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES
(6, '$2a$10$OfGAZtUmKTu1OGKpX6IKj.jJ/MkapooxQ69Yo/9ZI3G40DBRFBQ6u', 'CLIENT', 'assia'),
(7, '$2a$10$HF/0AE.jn9wfYF9NYQGVKelJyVhcY8jHLMF8/H5LrQKtBSwfKO0uC', 'CLIENT', 'douaa'),
(13, '$2a$10$VoJmIG.rCiBUQtcEVvUyLO5jPr3StAfiC150bInHJy6wQNRxZX.H.', 'CLIENT', 'hanae'),
(15, '$2a$10$3QGMq7908kiapD7NIw4jkeuNsSxZjraRjffS2Gf1Loi5aajEDMbLm', 'CLIENT', 'wissal'),
(17, '$2a$10$H8jeZ1mZfdbP2M45xysP6.noWG8rirbfs2S/hKpaQUXaJD5CChLl2', 'ADMIN', 'fatima');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
