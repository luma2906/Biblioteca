-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-05-2018 a las 06:31:51
-- Versión del servidor: 10.1.30-MariaDB
-- Versión de PHP: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bibliotecas`
--

CREATE TABLE `bibliotecas` (
  `id_biblioteca` int(10) UNSIGNED NOT NULL,
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `correo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `url` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `bibliotecas`
--

INSERT INTO `bibliotecas` (`id_biblioteca`, `nombre`, `direccion`, `correo`, `url`, `deleted_at`, `created_at`, `updated_at`) VALUES
(1, 'la calle', 'carrera 12 # 12 ', 'algo@gmail.com', 'www.google.com', NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id_libro` int(10) UNSIGNED NOT NULL,
  `dni` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_libro` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `editorial` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `estado` int(11) NOT NULL,
  `id_biblioteca` int(10) UNSIGNED NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `codigo_unico` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id_libro`, `dni`, `nombre_libro`, `editorial`, `estado`, `id_biblioteca`, `deleted_at`, `created_at`, `updated_at`, `codigo_unico`, `id_categoria`) VALUES
(1, '1212', 'cien años', 'la 1', 0, 1, NULL, '0000-00-00 00:00:00', '2018-05-09 08:27:35', 1, 1),
(2, '2020', 'Me gustas', 'la 22', 0, 1, NULL, '0000-00-00 00:00:00', '2018-05-10 02:49:17', 2, 1),
(4, '5454', 'cien años', 'yu', 0, 1, NULL, '0000-00-00 00:00:00', '2018-05-10 02:49:05', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `migrations`
--

CREATE TABLE `migrations` (
  `migration` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `migrations`
--

INSERT INTO `migrations` (`migration`, `batch`) VALUES
('2018_05_07_145903_Usuarios', 1),
('2018_05_07_145904_Biblioteca', 1),
('2018_05_07_145926_Libros', 1),
('2018_05_07_215336_prestamos', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `id_prestamo` int(10) UNSIGNED NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `id_libro` int(10) UNSIGNED NOT NULL,
  `id_usuario` int(10) UNSIGNED NOT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `fecha_entrega` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`id_prestamo`, `fecha_prestamo`, `id_libro`, `id_usuario`, `deleted_at`, `created_at`, `updated_at`, `fecha_entrega`) VALUES
(44, '2018-05-08', 1, 1, '2018-05-09 00:40:47', '2018-05-09 00:40:46', '2018-05-09 00:40:47', '2018-05-11'),
(45, '2018-05-08', 4, 1, '2018-05-09 00:40:49', '2018-05-09 00:40:49', '2018-05-09 00:40:49', '2018-05-11'),
(46, '2018-05-08', 1, 1, '2018-05-09 00:40:54', '2018-05-09 00:40:51', '2018-05-09 00:40:54', '2018-05-11'),
(47, '2018-05-08', 4, 1, '2018-05-09 00:40:53', '2018-05-09 00:40:53', '2018-05-09 00:40:53', '2018-05-11'),
(48, '2018-05-08', 1, 1, '2018-05-09 00:55:50', '2018-05-09 00:55:47', '2018-05-09 00:55:50', '2018-05-11'),
(49, '2018-05-08', 1, 1, '2018-05-09 00:56:27', '2018-05-09 00:56:26', '2018-05-09 00:56:27', '2018-05-11'),
(50, '2018-05-08', 1, 1, '2018-05-09 01:01:39', '2018-05-09 01:01:01', '2018-05-09 01:01:39', '2018-05-06'),
(51, '2018-05-08', 1, 1, '2018-05-09 01:02:49', '2018-05-09 01:02:20', '2018-05-09 01:02:49', '2018-05-06'),
(52, '2018-05-08', 1, 1, '2018-05-09 01:04:07', '2018-05-09 01:03:40', '2018-05-09 01:04:07', '2018-05-06'),
(53, '2018-05-08', 1, 1, '2018-05-09 01:05:20', '2018-05-09 01:05:19', '2018-05-09 01:05:20', '2018-05-11'),
(54, '2018-05-08', 1, 1, '2018-05-09 01:05:48', '2018-05-09 01:05:33', '2018-05-09 01:05:48', '2018-05-06'),
(55, '2018-05-08', 1, 1, '2018-05-09 01:06:43', '2018-05-09 01:06:14', '2018-05-09 01:06:43', '2018-05-06'),
(56, '2018-05-08', 1, 1, '2018-05-09 01:07:26', '2018-05-09 01:07:05', '2018-05-09 01:07:26', '2018-05-06'),
(57, '2018-05-08', 1, 1, '2018-05-09 01:12:50', '2018-05-09 01:12:29', '2018-05-09 01:12:50', '2018-05-06'),
(58, '2018-05-08', 1, 1, '2018-05-09 01:17:14', '2018-05-09 01:14:23', '2018-05-09 01:17:14', '2018-05-06'),
(59, '2018-05-09', 1, 1, NULL, '2018-05-09 08:27:35', '2018-05-09 08:27:35', '2018-05-12'),
(60, '2018-05-09', 4, 1, NULL, '2018-05-10 02:49:05', '2018-05-10 02:49:05', '2018-05-12'),
(61, '2018-05-09', 2, 1, NULL, '2018-05-10 02:49:17', '2018-05-10 02:49:17', '2018-05-12');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(10) UNSIGNED NOT NULL,
  `correo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `cc` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `deleted_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `api_token` varchar(60) COLLATE utf8_unicode_ci DEFAULT 'NULL'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `correo`, `cc`, `nombre`, `apellido`, `password`, `edad`, `genero`, `remember_token`, `deleted_at`, `created_at`, `updated_at`, `api_token`) VALUES
(1, 'luma2906@gmail.com', '1088299818', 'Luisa Maria', 'sevilayha', '$2y$10$EiGsonhpfDwJ90XoQmYNEeCxE8su6nL1GF15ybXhPYQwTx25DuzyC', 25, 'f', 'sfn1qUNsAKmIGFEjYqMF6ztM1SHvwbLuKRFtJzQqM3258l6Fxhw3Fl822wkB', NULL, '2018-05-08 08:34:51', '2018-05-10 09:05:25', 'NULL'),
(2, 'alejo5600@gmail.om', '12345', 'alejo', 'perez', '$2y$10$EiGsonhpfDwJ90XoQmYNEeCxE8su6nL1GF15ybXhPYQwTx25DuzyC', 26, 'm', NULL, NULL, '0000-00-00 00:00:00', '0000-00-00 00:00:00', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `bibliotecas`
--
ALTER TABLE `bibliotecas`
  ADD PRIMARY KEY (`id_biblioteca`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id_libro`),
  ADD UNIQUE KEY `libros_dni_unique` (`dni`),
  ADD KEY `libros_id_biblioteca_foreign` (`id_biblioteca`),
  ADD KEY `nombre_libro` (`nombre_libro`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`id_prestamo`),
  ADD KEY `prestamos_id_libro_foreign` (`id_libro`),
  ADD KEY `prestamos_id_usuario_foreign` (`id_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `usuarios_correo_unique` (`correo`),
  ADD UNIQUE KEY `usuarios_cc_unique` (`cc`),
  ADD UNIQUE KEY `api_token` (`api_token`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `bibliotecas`
--
ALTER TABLE `bibliotecas`
  MODIFY `id_biblioteca` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id_libro` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `id_prestamo` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_id_biblioteca_foreign` FOREIGN KEY (`id_biblioteca`) REFERENCES `bibliotecas` (`id_biblioteca`);

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_id_libro_foreign` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro`),
  ADD CONSTRAINT `prestamos_id_usuario_foreign` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
