-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-01-2022 a las 17:21:37
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reji`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito`
--

CREATE TABLE `carrito` (
  `id` int(11) NOT NULL,
  `n_bebidas` int(11) NOT NULL,
  `n_entradas` int(11) NOT NULL,
  `n_palomitas` int(11) NOT NULL,
  `precio_total` double NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_registration` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carrito`
--

INSERT INTO `carrito` (`id`, `n_bebidas`, `n_entradas`, `n_palomitas`, `precio_total`, `id_usuario`, `id_registration`) VALUES
(1, 1, 4, 2, 41.5, NULL, NULL),
(2, 0, 1, 0, 15, NULL, NULL),
(3, 3, 3, 2, 39, NULL, NULL),
(18, 3, 2, 2, 31.5, NULL, NULL),
(19, 1, 3, 2, 34, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `id` int(11) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cine`
--

INSERT INTO `cine` (`id`, `direccion`, `nombre`) VALUES
(1, 'San Fernando - Cádiz\r\nCalle Real, 13', 'REJI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `id` int(11) NOT NULL,
  `id_carrito` int(11) DEFAULT NULL,
  `id_sesion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(20);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `id` int(11) NOT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `pegi` int(11) NOT NULL,
  `sinopsis` longtext DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`id`, `genero`, `pegi`, `sinopsis`, `titulo`, `url`) VALUES
(1, 'Ciencia ficción', 2, 'Un futuro lejano, en el que las familias de nobles se disputan el dominio del árido planeta Arrakis, también conocido como Dune por su geografía compuesta por desiertos de dunas. Arrakis es el único lugar donde se encuentra \'la especia\', la sustancia más codiciada y valiosa del universo que producen gigantescos gusanos de arena. Debido a su rareza, y a su arriesgada extracción, quien controla la producción de la especia, controla el destino no sólo del Imperio, sino de toda la humanidad. El Duque Leto Atreides (Oscar Isaac) aceptará la administración de este peligroso planeta y será enviado a Arrakis junto con Lady Jessica (Rebecca Ferguson) y su hijo Paul (Timothée Chalamet). Será entonces cuando la familia Atreides corra un gran riesgo por estar en el punto de mira de fuerzas malvadas como las de su enemigo el Barón Vladimir Harkonnen (Stellan Skarsgård).', 'Dune', 'https://es.web.img2.acsta.net/c_310_420/pictures/21/08/25/14/35/3349802.jpg'),
(2, 'Comedia', 2, 'Callie (Carrie Coon) es una madre soltera que se muda a un pequeño pueblo con sus dos hijos, Trevor (Finn Wolfhard) y Phoebe (Mckenna Grace). Allí, en mitad de la nada, se encuentra la granja que han heredado de su abuelo. En seguida esta familia conocerá algunos de los secretos relacionados con ellos mismos y con este lugar, ya que el legado de su abuelo conecta con los orígenes de los Cazafantasmas. Junto con Mr. Grooberson (Paul Rudd), un sismólogo y maestro que ha llegado a la localidad porque han estado sucediendo misteriosos terremotos, descubrirán una réplica de una trampa para capturar fantasmas, algo insólito, ya que no se han visto fantasmas en 30 años, desde que en los años 80 se hicieran famosos el equipo formado por Venkman, Stantz, Winston y Spengler.', 'Cazafantasmas 3', 'https://es.web.img3.acsta.net/c_310_420/pictures/21/10/19/15/10/4629875.jpg'),
(3, 'Acción', 2, 'Después de que Mysterio desvelara la identidad de Spider-Man a todo el mundo en Lejos de casa, Peter Parker (Tom Holland), desesperado por volver a la normalidad y recuperar su anterior vida, pide ayuda a Doctor Strange para enmendar tal acción. El Hechicero Supremo de Marvel accede a ayudar al joven Hombre Araña, sin embargo, algo sale mal y el multiverso se convierte en la mayor amenaza hasta el momento.', 'Spider-Man: No way home', 'https://es.web.img3.acsta.net/c_310_420/pictures/21/12/01/12/07/0243323.jpg'),
(4, 'Crimen', 2, 'Nadie ha podido robar el Banco de España. Una entidad financiera absolutamente inexpugnable, de la que no hay planos, ni datos de qué clase de ingeniería se utilizó hace más de cien años para construir su cámara acorazada. Pero este auténtico misterio no asusta a Thom Johnson (Freddie Highmore), el brillante y joven ingeniero reclutado para averiguar cómo descubrir el secreto para acceder a su interior. El objetivo será un pequeño tesoro, depositado en el banco tan solo durante diez días. En diez días, Thom y su equipo tendrán que descubrir el secreto de la caja, montar un plan y preparar el asalto. La fuga tras el golpe coincidirá con la esperada final del Mundial de Fútbol de Sudáfrica, que enfrenta a España y Holanda, y que reunirá a cientos de miles de aficionados a las puertas del mismísimo Banco de España. ¿Serán capaces de alcanzar la gloria o acabarán en prisión?', 'Way Down', 'https://es.web.img3.acsta.net/c_310_420/pictures/21/10/19/10/35/4358534.jpg'),
(5, 'Suspense', 2, 'Una dura sequía asola las vastas extensiones de arrozales en el Levante español. Ricardo, un prestigioso biólogo, después de viajar por todo el mundo, tiene la oportunidad de volver a sus orígenes para cumplir una misión: proteger el paraje natural donde creció. Las medidas que debe tomar le enfrentarán radicalmente a los lugareños, que ven atacada su forma de vida y subsistencia, un enfrentamiento que tendrá consecuencias trágicas.', 'El lodo', 'https://es.web.img2.acsta.net/c_310_420/pictures/21/09/08/11/33/1129949.jpg'),
(6, 'Terror', 2, 'Una joven visita a su madre a la que no ve desde hace mucho tiempo, que se encuentra en coma internada en un centro llamado Therapol donde está conectada a un simulador. Tras cometer un homicidio, la mujer quedó en ese estado y, ahora, el equipo del centro pide ayuda a su hija para entre en la simulación y descubra los motivos que llevaron a su progenitora a cometer aquel crimen tan atroz.\r\n\r\nCuando entre, la versión virtual de su madre le pedirá que abandone la simulación por extraños motivos. Tras desconectarse, comenzará a tener extrañas alucinaciones y es que se ha traído consigo a unas fuerzas malignas que parecen venir de otro mundo.', 'Demonic', 'https://es.web.img2.acsta.net/c_310_420/pictures/21/10/19/16/58/2827211.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registration`
--

CREATE TABLE `registration` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registration`
--

INSERT INTO `registration` (`id`, `email`, `name`, `password`) VALUES
(0, 'admin@admin.com', 'admin', 'ADMIN@admin'),
(1, 'usuario1@usuario.com', 'usuario1', 'usuario1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `id` int(11) NOT NULL,
  `num_sala` int(11) NOT NULL,
  `id_cine` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`id`, `num_sala`, `id_cine`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE `sesion` (
  `id` int(11) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `id_pelicula` int(11) DEFAULT NULL,
  `id_sala` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`id`, `fecha`, `id_pelicula`, `id_sala`) VALUES
(1, '2022-01-13 16:00:00', 1, 1),
(2, '2022-01-13 18:00:00', 1, 1),
(3, '2022-01-13 16:00:00', 2, 2),
(4, '2022-01-13 18:00:00', 2, 2),
(5, '2022-01-13 16:00:00', 3, 3),
(6, '2022-01-13 18:00:00', 3, 3),
(7, '2022-01-13 20:00:00', 4, 1),
(8, '2022-01-13 22:00:00', 4, 1),
(9, '2022-01-13 20:00:00', 5, 2),
(10, '2022-01-13 22:00:00', 5, 2),
(11, '2022-01-13 20:00:00', 6, 3),
(12, '2022-01-13 22:00:00', 6, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `contraseña` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `apellidos`, `contraseña`, `correo`, `nombre`) VALUES
(1, 'Cano Canalejas', '1234', 'esperanza.canocanalejas@alum.uca.es', 'Esperanza'),
(2, 'Alba Gómez', '1234', 'ivan.albagomez@alum.uca.es', 'Iván');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsbqpxk63xrpyck17xawl195dt` (`id_usuario`),
  ADD KEY `FKt73secfxlg33oxgthugfugxpp` (`id_registration`);

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa1ey1uor94nd18jsxplohawi4` (`id_carrito`),
  ADD KEY `FK5iei3m76tco9n7wkep8gs16wc` (`id_sesion`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg7n5cfxm28b0lrr87c1ieib3g` (`id_cine`);

--
-- Indices de la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKreswko6pff40p8weqnnbely4p` (`id_pelicula`),
  ADD KEY `FKiquheqhoyr73kkkevhsbsgt9j` (`id_sala`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrito`
--
ALTER TABLE `carrito`
  ADD CONSTRAINT `FKsbqpxk63xrpyck17xawl195dt` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FKt73secfxlg33oxgthugfugxpp` FOREIGN KEY (`id_registration`) REFERENCES `registration` (`id`);

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `FK5iei3m76tco9n7wkep8gs16wc` FOREIGN KEY (`id_sesion`) REFERENCES `sesion` (`id`),
  ADD CONSTRAINT `FKa1ey1uor94nd18jsxplohawi4` FOREIGN KEY (`id_carrito`) REFERENCES `carrito` (`id`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `FKg7n5cfxm28b0lrr87c1ieib3g` FOREIGN KEY (`id_cine`) REFERENCES `cine` (`id`);

--
-- Filtros para la tabla `sesion`
--
ALTER TABLE `sesion`
  ADD CONSTRAINT `FKiquheqhoyr73kkkevhsbsgt9j` FOREIGN KEY (`id_sala`) REFERENCES `sala` (`id`),
  ADD CONSTRAINT `FKreswko6pff40p8weqnnbely4p` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
