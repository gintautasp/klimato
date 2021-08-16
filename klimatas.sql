CREATE TABLE `miestai` (
  `id` int(10) UNSIGNED NOT NULL,
  `pav` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `kodas_salies` char(3) COLLATE utf8_unicode_ci NOT NULL,
  `platuma` decimal(10,6) NOT NULL,
  `ilguma` decimal(10,6) NOT NULL,
  `skaicius_gyv` int(10) UNSIGNED NOT NULL,
  `plotas` float NOT NULL,
  `duom_gav_laikas` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `miestai`
--

INSERT INTO `miestai` (`id`, `pav`, `kodas_salies`, `platuma`, `ilguma`, `skaicius_gyv`, `plotas`, `duom_gav_laikas`) VALUES
(1, 'Vilnius', 'LTL', '0.000000', '0.000000', 800000, 401, '2020-12-08 12:25:13'),
(2, 'Kaunas', 'LTL', '0.000000', '0.000000', 270000, 157, '2020-12-08 12:25:13'),
(3, 'Klaipeda', '', '0.000000', '0.000000', 100000, 200, '2020-12-16 11:08:50'),
(4, 'Šiauliai', 'LTL', '0.000000', '0.000000', 80000, 100, '2020-12-16 12:34:43'),
(5, 'Kedainiai', 'LTL', '0.000000', '0.000000', 50000, 50000, '2021-02-22 09:35:16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `miestai`
--
ALTER TABLE `miestai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kodas_salies` (`kodas_salies`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `miestai`
--
ALTER TABLE `miestai`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;


--
-- Table structure for table `temperaturos`
--

CREATE TABLE `temperaturos` (
  `id` int(10) UNSIGNED NOT NULL,
  `id_miesto` int(10) UNSIGNED NOT NULL,
  `metai` int(11) NOT NULL,
  `laikotarpis` enum('metine','sausio','liepos') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'metine',
  `temperatura` decimal(5,1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `temperaturos`
--
ALTER TABLE `temperaturos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_miesto` (`id_miesto`);

--
-- AUTO_INCREMENT for dumped tables
--

ALTER TABLE `temperaturos` ADD FOREIGN KEY (`id_miesto`) REFERENCES `miestai`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- https://osp.stat.gov.lt/statistiniu-rodikliu-analize?indicator=S2R003#/

INSERT IGNORE INTO `miestai` ( `pav`, `kodas_salies` ) SELECT `miestas` AS `pav`, 'LTL' AS `kodas_salies` FROM `duoemnys_zali` GROUP BY `miestas`

INSERT INTO `temperaturos` (`id_miesto`, `metai`, `laikotarpis`, `temperatura`) 
SELECT 
	`miestai`.`id` AS `id_miesto` 
	, `laikotarpis` AS `metai` 
	, SUBSTRING(`periodiskumas`,1,6) AS `laikotarpis` 
	, `reiksme` AS `temperatura` 
FROM `duoemnys_zali` 
LEFT JOIN `miestai` ON ( `duoemnys_zali`.`miestas`=`miestai`.`pav` ) 
WHERE 1