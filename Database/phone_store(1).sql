-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Czas generowania: 25 Maj 2019, 22:16
-- Wersja serwera: 10.1.13-MariaDB
-- Wersja PHP: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `phone_store`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `address`
--

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `country` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
  `street_number` varchar(10) NOT NULL,
  `home_number` varchar(10) DEFAULT NULL,
  `postal_code` char(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `address`
--

INSERT INTO `address` (`address_id`, `country`, `city`, `street`, `street_number`, `home_number`, `postal_code`) VALUES
(1, 'Polska', 'Kielce', 'Długa', '19', '2', '66-999'),
(3, 'qqq', 'www', 'dddd', '44', NULL, '22333'),
(4, 'Polska', 'Kielce', 'Żeromskiego', '33', NULL, '22-333'),
(5, 'Polska', 'Warszawa', 'Stroma', '3', NULL, '33-456'),
(6, '1213123', '234234', 'werwer', 'qweqwe', NULL, 'qweqwe'),
(7, 'Hiszpania', 'Madryt', 'Calle Sepúlveda', '7', NULL, '20-001'),
(8, 'USA', 'Albuquerque', 'Negra Arroyo Lane', '308', NULL, '87-104');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `phone`
--

CREATE TABLE `phone` (
  `phone_id` int(11) NOT NULL,
  `manufacturer` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `processor` varchar(45) NOT NULL,
  `system` varchar(45) NOT NULL,
  `screen_size` varchar(6) NOT NULL,
  `ram` varchar(5) NOT NULL,
  `storage` varchar(5) NOT NULL,
  `camera` varchar(25) DEFAULT NULL,
  `price` decimal(7,2) NOT NULL,
  `rating` decimal(10,2) DEFAULT NULL,
  `rating_count` int(11) DEFAULT NULL,
  `discount` decimal(3,2) NOT NULL,
  `quantity` int(12) NOT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `phone`
--

INSERT INTO `phone` (`phone_id`, `manufacturer`, `model`, `processor`, `system`, `screen_size`, `ram`, `storage`, `camera`, `price`, `rating`, `rating_count`, `discount`, `quantity`, `img`) VALUES
(1, 'Samsung', 'S10', 'Intel', 'Android', '6', '8', '128', '15', '2000.00', '5.00', 1, '0.00', 6, 'samsung s10.png'),
(2, 'Xiaomi', 'Redmi 5', 'Intel', 'Android 8.0', '6', '6', '64', '12', '800.00', '25.00', 5, '0.15', 10, 'xiaomi redmi 5.png'),
(3, 'Xiaomi', 'Redmi 5 plus', 'Intel', 'Android 8.0', '6', '6', '64', '12', '900.00', '14.00', 3, '0.00', 9, 'xiaomi redmi 5 plus.png'),
(4, 'Samsung', 'A50', 'Exynos', 'Android 9.0', '6', '4', '128', '25', '1599.00', '4.00', 1, '0.00', 2, 'samsung a50.png'),
(5, 'Huawei', 'P30', 'Kirin', 'Android 9', '6.1', '6', '128', '40', '2999.00', '5.00', 1, '0.00', 3, 'huawei p30.png'),
(6, 'iPhone', '6', 'Apple A8', 'IOS 8', '4.7', '1', '32', '8', '1549.00', '4.00', 1, '0.00', 11, 'iphone 6.png'),
(7, 'iPhone', 'XS', 'Apple A12', 'IOS', '5.85', '4', '64', '12', '4350.00', '44.00', 9, '0.00', 2, 'iphone xs.png'),
(8, 'Honor', '8x', 'Kirin 710', 'Android 8.0', '6.5', '4', '128', '20', '1010.00', '9.00', 2, '0.00', 21, 'honor 8x.png');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `sale`
--

CREATE TABLE `sale` (
  `sale_id` int(11) NOT NULL,
  `delivery` varchar(50) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `payment` varchar(50) CHARACTER SET utf32 COLLATE utf32_polish_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `date_order` date NOT NULL,
  `date_completed` date DEFAULT NULL,
  `sale_user_id` int(11) NOT NULL,
  `sale_phone_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `sale`
--

INSERT INTO `sale` (`sale_id`, `delivery`, `payment`, `quantity`, `date_order`, `date_completed`, `sale_user_id`, `sale_phone_id`) VALUES
(2, 'DHL', 'transfer', 1, '2019-03-21', NULL, 1, 2),
(3, 'DHL', 'cash on delivery', 2, '2019-04-21', NULL, 3, 1),
(4, 'DHL', 'transfer', 1, '2019-05-21', NULL, 2, 2),
(5, 'DHL', 'transfer', 3, '2019-05-21', NULL, 2, 3),
(6, 'DHL', 'transfer', 1, '2019-05-21', NULL, 2, 4),
(7, 'DHL', 'transfer', 1, '2019-05-21', NULL, 2, 1),
(8, 'DHL', 'transfer', 2, '2019-05-22', NULL, 1, 2),
(9, 'Poczta polska', 'transfer', 2, '2019-05-23', NULL, 3, 1),
(10, 'DHL', 'transfer', 2, '2019-05-23', NULL, 2, 1),
(11, 'DPD', 'cash on delivery', 1, '2019-05-23', NULL, 2, 1),
(12, 'Poczta polska', 'cash on delivery', 3, '2019-05-23', NULL, 3, 1),
(13, 'Poczta polska', 'cash on delivery', 1, '2019-05-24', NULL, 3, 4);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(60) NOT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user_usertype_id` int(11) NOT NULL,
  `user_address_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `user`
--

INSERT INTO `user` (`user_id`, `name`, `surname`, `email`, `phone`, `login`, `password`, `user_usertype_id`, `user_address_id`) VALUES
(1, 'Patrycjusz', 'Mania', 'worms308@wp.pl', '666444222', 'admin', '21232F297A57A5A743894A0E4A801FC3', 1, 1),
(2, 'Marianna', 'Południk', 'ee@wp.pl', NULL, 'worek', '21232f297a57a5a743894a0e4a801fc3', 6, 3),
(3, 'Stefan', 'Kowak', 'adres@wp.pl', '999222333', 'stefan', '2e970e822e1a8834203d06abb60f59ec', 7, 4),
(4, 'Łukasz', 'Źdźbło', 'wor@wp.pl', '234321654', 'lukasz', 'd7559b8c502dea1b5323af444e81e014', 8, 5),
(6, 'Arturo', 'Roman', 'arturo1@gmail.com', '345346233', 'arturo', '65deafcf3c1ad1751415736c4cc11f76', 10, 7),
(7, 'Walter', 'White', 'white69@qmail.com', '923543663', 'white', 'd508fe45cecaf653904a0e774084bb5c', 11, 8);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `usertype`
--

CREATE TABLE `usertype` (
  `usertype_id` int(11) NOT NULL,
  `description` varchar(45) NOT NULL,
  `login` varchar(100) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `usertype`
--

INSERT INTO `usertype` (`usertype_id`, `description`, `login`) VALUES
(1, 'admin', 'admin'),
(6, 'user', 'worek'),
(7, 'user', 'stefan'),
(8, 'user', 'lukasz'),
(9, 'user', 'qweqew'),
(10, 'user', 'arturo'),
(11, 'admin', 'white');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`address_id`);

--
-- Indexes for table `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`phone_id`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`sale_id`,`sale_user_id`,`sale_phone_id`),
  ADD KEY `fk_sale_user_idx` (`sale_user_id`),
  ADD KEY `fk_sale_phone_idx` (`sale_phone_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`,`user_usertype_id`,`user_address_id`),
  ADD KEY `fk_user_usertype_idx` (`user_usertype_id`),
  ADD KEY `fk_user_address_idx` (`user_address_id`);

--
-- Indexes for table `usertype`
--
ALTER TABLE `usertype`
  ADD PRIMARY KEY (`usertype_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `address`
--
ALTER TABLE `address`
  MODIFY `address_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `phone`
--
ALTER TABLE `phone`
  MODIFY `phone_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT dla tabeli `sale`
--
ALTER TABLE `sale`
  MODIFY `sale_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT dla tabeli `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT dla tabeli `usertype`
--
ALTER TABLE `usertype`
  MODIFY `usertype_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `sale`
--
ALTER TABLE `sale`
  ADD CONSTRAINT `fk_sale_phone` FOREIGN KEY (`sale_phone_id`) REFERENCES `phone` (`phone_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_sale_user` FOREIGN KEY (`sale_user_id`) REFERENCES `user` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Ograniczenia dla tabeli `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_address` FOREIGN KEY (`user_address_id`) REFERENCES `address` (`address_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_usertype` FOREIGN KEY (`user_usertype_id`) REFERENCES `usertype` (`usertype_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
