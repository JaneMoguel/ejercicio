CREATE DATABASE PRUEBA;

USE [PRUEBA]
GO

/****** Object:  Table [dbo].[personas]    Script Date: 14/07/2022 01:08:15 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[persona](
	[idpersona] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
	[nombre] [varchar](50) NOT NULL,
	[genero] [varchar](50) NOT NULL,
	[edad] [int] NOT NULL,
	[identificacion] [varchar](50) NOT NULL,
	[direccion] [varchar](250) NOT NULL,
	[telefono] [varchar](10) NOT NULL
) ON [PRIMARY]
GO





USE [PRUEBA]
GO

/****** Object:  Table [dbo].[clientes]    Script Date: 14/07/2022 12:55:32 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cliente](
	[idpersona] [int] NOT NULL,
	[idcliente] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
	[contraseña] [varchar](50) NOT NULL,
	[estado] [varchar](50) NOT NULL,
	FOREIGN KEY (idpersona) REFERENCES persona(idpersona)
) ON [PRIMARY]
GO




USE [PRUEBA]
GO

/****** Object:  Table [dbo].[cuentas]    Script Date: 14/07/2022 12:56:52 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[cuentas](
	[idcliente] [int] NOT NULL,
	[idcuenta] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
	[numero] [varchar](50) NOT NULL,
	[tipo] [varchar](50) NOT NULL,
	[saldo] [decimal](18,2) NOT NULL,
	[estado] [tinyint] NOT NULL,
	FOREIGN KEY (idcliente) REFERENCES cliente(idcliente)
) ON [PRIMARY]
GO

USE [PRUEBA]
GO

/****** Object:  Table [dbo].[movimientos]    Script Date: 14/07/2022 12:57:59 p. m. ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[movimientos](
	[idCuenta] [int] NOT NULL,
	[idMovimiento] [int] NOT NULL IDENTITY(1,1) PRIMARY KEY,
	[fecha] [datetime] NOT NULL,
	[tipo] [varchar](50) NOT NULL,
	[valor] [decimal](18, 2) NOT NULL,
	[saldo] [decimal](18, 2) NOT NULL,
	FOREIGN KEY (idcuenta) REFERENCES cuentas(idcuenta)
) ON [PRIMARY]
GO








