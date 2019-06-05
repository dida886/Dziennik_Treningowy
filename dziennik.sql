-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 05 Cze 2019, 22:04
-- Wersja serwera: 10.1.40-MariaDB
-- Wersja PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `dziennik`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cwiczenie`
--

CREATE TABLE `cwiczenie` (
  `id_cwiczenie` int(11) NOT NULL,
  `nazwa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci DEFAULT NULL,
  `link` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `partiaMiesni` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `cwiczenie`
--

INSERT INTO `cwiczenie` (`id_cwiczenie`, `nazwa`, `link`, `partiaMiesni`) VALUES
(1, 'Pistolet', 'https://www.youtube.com/watch?v=TI74Bdxq_7k', 1),
(2, 'Przysiad sumo', 'https://www.youtube.com/watch?v=u9FEsUS51Ak', 1),
(3, 'Zakrok z hantlami', 'https://www.youtube.com/watch?v=k5axC9Lcvlg', 1),
(4, 'Side step-up', 'https://www.youtube.com/watch?v=gk-xS6mjIms', 1),
(5, 'Goblet squat', 'https://www.youtube.com/watch?v=MeIiIdhvXT4', 1),
(6, 'Wypychanie nóg na suwnicy', 'https://www.youtube.com/watch?v=HIAWxO-NPpA', 1),
(7, 'Przysiad na maszynie smitha', 'https://www.youtube.com/watch?v=VB9Cjw4XmbM', 1),
(8, 'Stiff leg deadlift', 'https://www.youtube.com/watch?v=zpW4ju4MHmc', 2),
(9, 'Frog hip thrust', 'https://www.youtube.com/watch?v=C2KZbm2lddQ', 2),
(10, 'Żuraw', 'https://www.youtube.com/watch?v=1XD_WOqUTm8', 2),
(11, 'Martwy ciąg na prostych nogach', 'https://www.youtube.com/watch?v=YkMJYZvJr6g', 2),
(12, 'Unoszenie tułowia na ławce jednonóż', 'https://www.youtube.com/watch?v=OFZvsxZDKrY', 2),
(13, 'Unoszenie bioder na jednej nodze', 'https://www.youtube.com/watch?v=KoivO8qif4w', 2),
(14, 'Martwy ciąg sumo', 'https://www.youtube.com/watch?v=96AxTvsMtbM', 2),
(15, 'Unoszenie bioder ze sztangą', 'https://www.youtube.com/watch?v=UV2FngGGZvw', 3),
(16, 'Wiosło Pendlaya', 'https://www.youtube.com/watch?v=aXZGAnzIhtE', 3),
(17, 'Trap y-raise', 'https://www.youtube.com/watch?v=2KWhRFlBuSA', 3),
(18, 'Podciąganie na drążku nachwytem', 'https://www.youtube.com/watch?v=E7o6BKIx2ow', 3),
(19, 'Wiosłowanie w podporze', 'https://www.youtube.com/watch?v=YHN0SGa-68Q', 3),
(20, 'Klasyczny martwy ciąg', 'https://www.youtube.com/watch?v=0_igODjLiXM', 3),
(21, 'Wiosłowanie hantlami w opadzie tułowia', 'https://www.youtube.com/watch?v=B-HryLsmU1w', 3),
(22, 'Rozpiętki na TRX', 'https://www.youtube.com/watch?v=IkBiK0Crv_8', 4),
(23, 'Floor press', 'https://www.youtube.com/watch?v=Ps_gf-1sLxY', 4),
(24, 'Przenoszenie sztangielki za głowę', 'https://www.youtube.com/watch?v=JpVnRFa1gJU', 4),
(25, 'Pompki klasyczne', 'https://www.youtube.com/watch?v=boSpmZZp74U', 4),
(26, 'Pompki na poręczach', 'https://www.youtube.com/watch?v=dl5XHQ_MyAo', 4),
(27, 'Rozpiętki na maszynie butterfly', 'https://www.youtube.com/watch?v=3N5WxWd0hUI', 4),
(28, 'Wyciskanie sztangi na ławce płaskiej', 'https://www.youtube.com/watch?v=bbGuHx07EDc', 4),
(29, 'Wyciskanie na maszynie hammer', 'https://www.youtube.com/watch?v=DgasTNLyQcg', 4),
(30, 'Cuban press', 'https://www.youtube.com/watch?v=oQJoK0a3h44', 5),
(31, 'T-raise na ławeczce', 'https://www.youtube.com/watch?v=6R2yfPjC5CY', 5),
(32, 'Arnoldki', 'https://www.youtube.com/watch?v=FVMC9qEbnrE', 5),
(33, 'Podciąganie sztangi pod brodę', 'https://www.youtube.com/watch?v=UJN3gVIvNk4', 5),
(34, 'Odwodzenie ramion w bok ze sztangielkami', 'https://www.youtube.com/watch?v=5qDTijyAJ_U', 5),
(35, 'Wyciskanie sztangi nad głowę', 'https://www.youtube.com/watch?v=uLt0SYcFnBA', 5),
(36, 'Wyciskanie sztangi na maszynie smitha siedząc', 'https://www.youtube.com/watch?v=YFG6U1JIp84', 5),
(37, 'Pike TRX', 'https://www.youtube.com/watch?v=To2LJgb-_FI', 6),
(38, 'Superman na TRX', 'https://www.youtube.com/watch?v=xUfHUUJNKTY', 6),
(39, 'Scyzoryki', 'https://www.youtube.com/watch?v=rwnb6DGyxQA', 6),
(40, 'Hollow body', 'https://www.youtube.com/watch?v=c7LEUqenAPA', 6),
(41, 'Rowerek', 'https://www.youtube.com/watch?v=vWE9Tc_vleM', 6),
(42, 'Świeca z prostowaniem nóg leżąc', 'https://www.youtube.com/watch?v=_1cR1uim7E8', 6),
(43, 'Dead bug', 'https://www.youtube.com/watch?v=I5xbsA71v1A', 6),
(44, 'Wąskie pompki', 'https://www.youtube.com/watch?v=ULPNHvuPWjM', 7),
(45, 'Pompki na triceps na poręczach', 'https://www.youtube.com/watch?v=flSs1CfQS6k', 7),
(46, 'Wyciskanie francuskie hantli', 'https://www.youtube.com/watch?v=wWz4w5_1y9Q', 7),
(47, 'Pompki w podporze tyłem na ławeczce', 'https://www.youtube.com/watch?v=59TBBRsO4Vw', 7),
(48, 'Wyciskanie sztangi łamanej wąskim chwytem na ławce', 'https://www.youtube.com/watch?v=b3qYZeDywgI', 7),
(49, 'Naprzemianstronne prostowanie przedramion ze sztangielką', 'https://www.youtube.com/watch?v=GyLV33v2SOA', 7),
(50, 'Prostowanie ramion na wyciągu górnym nachwytem', 'https://www.youtube.com/watch?v=qM10SRGkZPs', 7),
(51, 'Uginanie przedramion ze sztangą trzymaną nachwytem stojąc', 'https://www.youtube.com/watch?v=727Y9UFjXEI', 8),
(52, 'Zottman curl', 'https://www.youtube.com/watch?v=ZrpRBgswtHs', 8),
(53, 'Naprzemienne uginanie przedramion z hantlami chwytem młotkowym stojąc', 'https://www.youtube.com/watch?v=i_bbQJI7Y7M', 8),
(54, 'Jednoczesne uginanie przedramion z hantlami z supinacją stojąc', 'https://www.youtube.com/watch?v=RTYQSbHTwOg', 8),
(55, 'Uginanie przedramion na modlitewniku przy użyciu sztangi łamanej', 'https://www.youtube.com/watch?v=QkK9UjGI4Pw', 8),
(56, 'Uginanie przedramion ze sztangielkami podchwytem siedząc', 'https://www.youtube.com/watch?v=-qDmvQvOyK0', 8),
(57, 'Zginanie przedramienia z hantlem na modlitewniku', 'https://www.youtube.com/watch?v=Lu38qqoBTfs', 8),
(58, 'Wspięcia na palce jednonóż stojąc', 'https://www.youtube.com/watch?v=qmT1LcEihbs', 9),
(59, 'Wspięcia na palcach w pozycji siedzącej ze sztangą ułożoną na kolanach', 'https://www.youtube.com/watch?v=GTAAcFXcZz0', 9),
(60, 'Wspięcia na palce obunóż stojąc', 'https://www.youtube.com/watch?v=mbyTbDJBsR8', 9),
(61, 'Wspięcia na palce ze sztangą na karku stojąc przy użyciu maszyny Smitha', 'https://www.youtube.com/watch?v=vn2nW4tksMM', 9),
(62, 'Wspięcia na palce przy użyciu suwnicy', 'https://www.youtube.com/watch?v=cSmW6cdzDKk', 9),
(63, 'Wspięcia na palce siedząc', 'https://www.youtube.com/watch?v=5aYNiTFd8PM', 9);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `cwiczeniewplanie`
--

CREATE TABLE `cwiczeniewplanie` (
  `id_cwiczenie` int(11) DEFAULT NULL,
  `id_trening` int(11) DEFAULT NULL,
  `serie` int(11) DEFAULT NULL,
  `powtorzenia` int(11) DEFAULT NULL,
  `Czas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `cwiczeniewplanie`
--

INSERT INTO `cwiczeniewplanie` (`id_cwiczenie`, `id_trening`, `serie`, `powtorzenia`, `Czas`) VALUES
(16, 1, 4, 12, 0),
(18, 1, 4, 18, 0),
(14, 1, 3, 12, 0),
(12, 1, 3, 10, 0),
(21, 1, 4, 20, 0),
(2, 2, 3, 11, 0),
(17, 2, 3, 12, 0),
(18, 2, 3, 13, 0),
(7, 2, 3, 14, 0),
(2, 2, 3, 12, 0),
(3, 2, 3, 12, 0),
(7, 2, 3, 12, 0),
(8, 3, 3, 12, 0),
(25, 3, 3, 12, 0),
(24, 3, 3, 12, 0),
(5, 3, 3, 8, 0),
(2, 3, 3, 11, 0),
(3, 3, 3, 12, 0),
(2, 3, 3, 12, 0),
(5, 3, 3, 12, 0),
(4, 3, 3, 12, 0),
(2, 3, 3, 19, 0),
(7, 3, 3, 18, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `kategoria`
--

CREATE TABLE `kategoria` (
  `id_kategoria` int(11) NOT NULL,
  `nazwa` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `konto`
--

CREATE TABLE `konto` (
  `id_konto` int(11) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `konto`
--

INSERT INTO `konto` (`id_konto`, `login`, `password`, `email`) VALUES
(1, 'alex1927', 'asr0ma', 'alex231791@gmail.com'),
(2, 'marun', 'roma', 'dominik.maruniak@gmail.com');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `partiamiesni`
--

CREATE TABLE `partiamiesni` (
  `id_partia` int(11) NOT NULL,
  `partiaMiesni` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `partiamiesni`
--

INSERT INTO `partiamiesni` (`id_partia`, `partiaMiesni`) VALUES
(1, 'Czworogłowe uda'),
(2, 'Dwugłowe uda'),
(3, 'Plecy'),
(4, 'Klatka piersiowa'),
(5, 'Barki'),
(6, 'Brzuch'),
(7, 'Triceps'),
(8, 'Biceps'),
(9, 'Łydki'),
(10, 'Cardio');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `plantreningowy`
--

CREATE TABLE `plantreningowy` (
  `id_planTreningowy` int(11) NOT NULL,
  `nazwa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL,
  `autor` int(11) DEFAULT NULL,
  `dlaKogo` int(11) DEFAULT NULL,
  `publiczny` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `plantreningowy`
--

INSERT INTO `plantreningowy` (`id_planTreningowy`, `nazwa`, `autor`, `dlaKogo`, `publiczny`) VALUES
(1, 'plan 1', 1, 1, b'0');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `post`
--

CREATE TABLE `post` (
  `temat` int(11) DEFAULT NULL,
  `autor` int(11) DEFAULT NULL,
  `nr_Post` int(11) NOT NULL,
  `tresc` text COLLATE utf8_polish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `temat`
--

CREATE TABLE `temat` (
  `id_temat` int(11) NOT NULL,
  `Kategoria` int(11) DEFAULT NULL,
  `nazwa` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `trening`
--

CREATE TABLE `trening` (
  `id_trening` int(11) NOT NULL,
  `id_planTreningowy` int(11) DEFAULT NULL,
  `nazwa` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL,
  `uwagi` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `trening`
--

INSERT INTO `trening` (`id_trening`, `id_planTreningowy`, `nazwa`, `uwagi`) VALUES
(1, 1, 'trening 1', 'dobry trening 1'),
(2, 1, 'trening 2', 'dobry trening 2'),
(3, 1, 'trening 3', 'dobry trening 3');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `cwiczenie`
--
ALTER TABLE `cwiczenie`
  ADD PRIMARY KEY (`id_cwiczenie`),
  ADD KEY `partiaMiesni` (`partiaMiesni`);

--
-- Indeksy dla tabeli `cwiczeniewplanie`
--
ALTER TABLE `cwiczeniewplanie`
  ADD KEY `id_cwiczenie` (`id_cwiczenie`),
  ADD KEY `id_trening` (`id_trening`);

--
-- Indeksy dla tabeli `kategoria`
--
ALTER TABLE `kategoria`
  ADD PRIMARY KEY (`id_kategoria`);

--
-- Indeksy dla tabeli `konto`
--
ALTER TABLE `konto`
  ADD PRIMARY KEY (`id_konto`),
  ADD UNIQUE KEY `login` (`login`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indeksy dla tabeli `partiamiesni`
--
ALTER TABLE `partiamiesni`
  ADD PRIMARY KEY (`id_partia`);

--
-- Indeksy dla tabeli `plantreningowy`
--
ALTER TABLE `plantreningowy`
  ADD PRIMARY KEY (`id_planTreningowy`),
  ADD KEY `autor` (`autor`),
  ADD KEY `dlaKogo` (`dlaKogo`);

--
-- Indeksy dla tabeli `post`
--
ALTER TABLE `post`
  ADD KEY `temat` (`temat`),
  ADD KEY `autor` (`autor`);

--
-- Indeksy dla tabeli `temat`
--
ALTER TABLE `temat`
  ADD PRIMARY KEY (`id_temat`),
  ADD KEY `Kategoria` (`Kategoria`);

--
-- Indeksy dla tabeli `trening`
--
ALTER TABLE `trening`
  ADD PRIMARY KEY (`id_trening`),
  ADD KEY `id_planTreningowy` (`id_planTreningowy`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `cwiczenie`
--
ALTER TABLE `cwiczenie`
  MODIFY `id_cwiczenie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT dla tabeli `kategoria`
--
ALTER TABLE `kategoria`
  MODIFY `id_kategoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `konto`
--
ALTER TABLE `konto`
  MODIFY `id_konto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT dla tabeli `partiamiesni`
--
ALTER TABLE `partiamiesni`
  MODIFY `id_partia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `plantreningowy`
--
ALTER TABLE `plantreningowy`
  MODIFY `id_planTreningowy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT dla tabeli `temat`
--
ALTER TABLE `temat`
  MODIFY `id_temat` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT dla tabeli `trening`
--
ALTER TABLE `trening`
  MODIFY `id_trening` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `cwiczenie`
--
ALTER TABLE `cwiczenie`
  ADD CONSTRAINT `cwiczenie_ibfk_1` FOREIGN KEY (`partiaMiesni`) REFERENCES `partiamiesni` (`id_partia`);

--
-- Ograniczenia dla tabeli `cwiczeniewplanie`
--
ALTER TABLE `cwiczeniewplanie`
  ADD CONSTRAINT `cwiczeniewplanie_ibfk_1` FOREIGN KEY (`id_cwiczenie`) REFERENCES `cwiczenie` (`id_cwiczenie`),
  ADD CONSTRAINT `cwiczeniewplanie_ibfk_2` FOREIGN KEY (`id_trening`) REFERENCES `trening` (`id_trening`);

--
-- Ograniczenia dla tabeli `plantreningowy`
--
ALTER TABLE `plantreningowy`
  ADD CONSTRAINT `plantreningowy_ibfk_1` FOREIGN KEY (`autor`) REFERENCES `konto` (`id_konto`),
  ADD CONSTRAINT `plantreningowy_ibfk_2` FOREIGN KEY (`dlaKogo`) REFERENCES `konto` (`id_konto`);

--
-- Ograniczenia dla tabeli `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`temat`) REFERENCES `temat` (`id_temat`),
  ADD CONSTRAINT `post_ibfk_2` FOREIGN KEY (`autor`) REFERENCES `konto` (`id_konto`);

--
-- Ograniczenia dla tabeli `temat`
--
ALTER TABLE `temat`
  ADD CONSTRAINT `temat_ibfk_1` FOREIGN KEY (`Kategoria`) REFERENCES `kategoria` (`id_kategoria`);

--
-- Ograniczenia dla tabeli `trening`
--
ALTER TABLE `trening`
  ADD CONSTRAINT `trening_ibfk_1` FOREIGN KEY (`id_planTreningowy`) REFERENCES `plantreningowy` (`id_planTreningowy`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
