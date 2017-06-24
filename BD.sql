/*
SQLyog Ultimate v9.63 
MySQL - 5.6.34-log : Database - sil2
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sil2` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sil2`;

/*Table structure for table `cf_opciones_menu` */

DROP TABLE IF EXISTS `cf_opciones_menu`;

CREATE TABLE `cf_opciones_menu` (
  `OM_codigoMenu` int(11) NOT NULL AUTO_INCREMENT,
  `OM_codigoMenuPadre` int(11) DEFAULT NULL,
  `OM_descripcion` varchar(45) DEFAULT NULL,
  `OM_ruta` varchar(45) DEFAULT NULL,
  `OM_orden` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OM_codigoMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `cf_opciones_menu` */

insert  into `cf_opciones_menu`(`OM_codigoMenu`,`OM_codigoMenuPadre`,`OM_descripcion`,`OM_ruta`,`OM_orden`) values (2,NULL,'Intercambio',NULL,NULL),(3,2,'Intercambio','intercambio.xhtml',NULL),(4,NULL,'Comercializacion',NULL,NULL),(5,4,'Comercializacion','comercializacion.xhtml',NULL);

/*Table structure for table `cf_perfil` */

DROP TABLE IF EXISTS `cf_perfil`;

CREATE TABLE `cf_perfil` (
  `PL_CodigoPerfil` int(11) NOT NULL AUTO_INCREMENT,
  `PL_NombrePerfil` varchar(45) NOT NULL,
  `PL_Estado` int(11) NOT NULL,
  PRIMARY KEY (`PL_CodigoPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `cf_perfil` */

insert  into `cf_perfil`(`PL_CodigoPerfil`,`PL_NombrePerfil`,`PL_Estado`) values (1,'Web',1),(2,'Administrador',1);

/*Table structure for table `cf_perfil_opciones_menu` */

DROP TABLE IF EXISTS `cf_perfil_opciones_menu`;

CREATE TABLE `cf_perfil_opciones_menu` (
  `PO_codigoPerfilOpciones` int(11) NOT NULL AUTO_INCREMENT,
  `PL_CodigoPerfil` int(11) DEFAULT NULL,
  `OM_codigoMenu` int(11) DEFAULT NULL,
  PRIMARY KEY (`PO_codigoPerfilOpciones`),
  KEY `FK_REFERENCE_7` (`PL_CodigoPerfil`),
  KEY `FK_REFERENCE_8` (`OM_codigoMenu`),
  CONSTRAINT `FK_REFERENCE_7` FOREIGN KEY (`PL_CodigoPerfil`) REFERENCES `cf_perfil` (`PL_CodigoPerfil`),
  CONSTRAINT `FK_REFERENCE_8` FOREIGN KEY (`OM_codigoMenu`) REFERENCES `cf_opciones_menu` (`OM_codigoMenu`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `cf_perfil_opciones_menu` */

insert  into `cf_perfil_opciones_menu`(`PO_codigoPerfilOpciones`,`PL_CodigoPerfil`,`OM_codigoMenu`) values (1,1,2),(2,1,3),(3,2,4),(4,2,5);

/*Table structure for table `co_autor` */

DROP TABLE IF EXISTS `co_autor`;

CREATE TABLE `co_autor` (
  `AT_CodigoAutor` int(11) NOT NULL AUTO_INCREMENT,
  `AT_Nombre` varchar(45) NOT NULL,
  `AT_ApellidoPaterno` varchar(45) NOT NULL,
  `AT_ApellidoMaterno` varchar(45) DEFAULT NULL,
  `AT_Nacionalidad` varchar(45) DEFAULT NULL,
  `AT_EsPublico` int(11) DEFAULT NULL,
  `AT_EsComerciable` int(11) DEFAULT NULL,
  PRIMARY KEY (`AT_CodigoAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `co_autor` */

insert  into `co_autor`(`AT_CodigoAutor`,`AT_Nombre`,`AT_ApellidoPaterno`,`AT_ApellidoMaterno`,`AT_Nacionalidad`,`AT_EsPublico`,`AT_EsComerciable`) values (1,'Cesar','Vallejo','asd','Peruano',1,1),(2,'Alfredo','Echenique','asd','Argentino',1,NULL),(3,'Maria','Tinoco','asdf','Peruano',1,NULL),(4,'Jessica','Torres','asf','Chileno',NULL,NULL);

/*Table structure for table `co_editorial` */

DROP TABLE IF EXISTS `co_editorial`;

CREATE TABLE `co_editorial` (
  `ED_CodigoEditorial` int(11) NOT NULL AUTO_INCREMENT,
  `ED_Nombre` varchar(45) DEFAULT NULL,
  `ED_Contacto` varchar(45) DEFAULT NULL,
  `ED_Direccion` varchar(45) DEFAULT NULL,
  `ED_Nacionalidad` varchar(45) DEFAULT NULL,
  `ED_CorreoContacto` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ED_CodigoEditorial`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `co_editorial` */

insert  into `co_editorial`(`ED_CodigoEditorial`,`ED_Nombre`,`ED_Contacto`,`ED_Direccion`,`ED_Nacionalidad`,`ED_CorreoContacto`) values (1,'Santillana',NULL,NULL,NULL,NULL);

/*Table structure for table `co_etiquetas` */

DROP TABLE IF EXISTS `co_etiquetas`;

CREATE TABLE `co_etiquetas` (
  `ET_CodigoEtiqueta` int(11) NOT NULL AUTO_INCREMENT,
  `ET_DescripcionEtiqueta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ET_CodigoEtiqueta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_etiquetas` */

/*Table structure for table `co_producto` */

DROP TABLE IF EXISTS `co_producto`;

CREATE TABLE `co_producto` (
  `PD_CodigoProducto` int(11) NOT NULL AUTO_INCREMENT,
  `PD_Descripcion` varchar(45) DEFAULT NULL,
  `PD_TipoProducto` int(11) DEFAULT NULL COMMENT 'Tipo Producto desde Parametrica',
  `PD_PrecioUnitario` double DEFAULT NULL,
  `PD_PrecioMayor` double DEFAULT NULL,
  `PD_CantidadMinima` int(11) DEFAULT NULL,
  `TX_CodigoTexto` int(11) NOT NULL,
  PRIMARY KEY (`PD_CodigoProducto`),
  KEY `FK_REFERENCE_31` (`PD_TipoProducto`),
  KEY `FK_REFERENCE_4` (`TX_CodigoTexto`),
  CONSTRAINT `FK_REFERENCE_31` FOREIGN KEY (`PD_TipoProducto`) REFERENCES `lb_parametricadet` (`PD_CodigoParametroDet`),
  CONSTRAINT `FK_REFERENCE_4` FOREIGN KEY (`TX_CodigoTexto`) REFERENCES `co_texto` (`TX_CodigoTexto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

Select * from co_promocionprod cpp, co_producto cp where cpp.PR_CodigoPromocion = 24 and cpp.PD_CodigoProducto = cp.PD_CodigoProducto

/*Data for the table `co_producto` */

insert  into `co_producto`(`PD_CodigoProducto`,`PD_Descripcion`,`PD_TipoProducto`,`PD_PrecioUnitario`,`PD_PrecioMayor`,`PD_CantidadMinima`,`TX_CodigoTexto`) values (1,'Es un buen producto',26,30,40,500,1),(2,'AA',1,50,45,400,1),(3,'BB',1,40,35,100,1),(5,'CC',2,60,55,50,1);

/*Table structure for table `co_productoetiquetas` */

DROP TABLE IF EXISTS `co_productoetiquetas`;

CREATE TABLE `co_productoetiquetas` (
  `CO_ProductoEtiqueta` int(11) NOT NULL AUTO_INCREMENT,
  `PD_CodigoProducto` int(11) DEFAULT NULL,
  `ET_CodigoEtiqueta` int(11) DEFAULT NULL,
  PRIMARY KEY (`CO_ProductoEtiqueta`),
  KEY `FK_REFERENCE_14` (`PD_CodigoProducto`),
  KEY `FK_REFERENCE_15` (`ET_CodigoEtiqueta`),
  CONSTRAINT `FK_REFERENCE_14` FOREIGN KEY (`PD_CodigoProducto`) REFERENCES `co_producto` (`PD_CodigoProducto`),
  CONSTRAINT `FK_REFERENCE_15` FOREIGN KEY (`ET_CodigoEtiqueta`) REFERENCES `co_etiquetas` (`ET_CodigoEtiqueta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_productoetiquetas` */

/*Table structure for table `co_promociocliente` */

DROP TABLE IF EXISTS `co_promociocliente`;

CREATE TABLE `co_promociocliente` (
  `PC_CodigoPromoCli` int(11) NOT NULL AUTO_INCREMENT,
  `PR_CodigoPromocion` int(11) DEFAULT NULL,
  `PE_CodigoPersona` int(11) DEFAULT NULL,
  PRIMARY KEY (`PC_CodigoPromoCli`),
  KEY `FK_REFERENCE_25` (`PR_CodigoPromocion`),
  KEY `FK_REFERENCE_26` (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_25` FOREIGN KEY (`PR_CodigoPromocion`) REFERENCES `co_promocion` (`PR_CodigoPromocion`),
  CONSTRAINT `FK_REFERENCE_26` FOREIGN KEY (`PE_CodigoPersona`) REFERENCES `in_cliente` (`PE_CodigoPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_promociocliente` */

/*Table structure for table `co_promocion` */

DROP TABLE IF EXISTS `co_promocion`;

CREATE TABLE `co_promocion` (
  `PR_CodigoPromocion` int(11) NOT NULL AUTO_INCREMENT,
  `PR_Nombre` varchar(50) DEFAULT NULL,
  `PR_OpcionCliente` int(11) DEFAULT NULL,
  `PR_OpcionProducto` int(11) DEFAULT NULL,
  `PR_FechaInicio` date DEFAULT NULL,
  `PR_FechaVenc` date DEFAULT NULL,
  `PR_fechaInsercion` date DEFAULT NULL,
  `PR_TipoPromocion` int(11) DEFAULT NULL,
  `PR_EstadoPromocion` int(11) DEFAULT NULL,
  PRIMARY KEY (`PR_CodigoPromocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_promocion` */

/*Table structure for table `co_promocionprod` */

DROP TABLE IF EXISTS `co_promocionprod`;

CREATE TABLE `co_promocionprod` (
  `PR_CodigoPromoProd` int(11) NOT NULL AUTO_INCREMENT,
  `PR_CodigoPromocion` int(11) DEFAULT NULL,
  `PD_CodigoProducto` int(11) DEFAULT NULL,
  PRIMARY KEY (`PR_CodigoPromoProd`),
  KEY `FK_REFERENCE_27` (`PR_CodigoPromocion`),
  KEY `FK_REFERENCE_28` (`PD_CodigoProducto`),
  CONSTRAINT `FK_REFERENCE_27` FOREIGN KEY (`PR_CodigoPromocion`) REFERENCES `co_promocion` (`PR_CodigoPromocion`),
  CONSTRAINT `FK_REFERENCE_28` FOREIGN KEY (`PD_CodigoProducto`) REFERENCES `co_producto` (`PD_CodigoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_promocionprod` */

/*Table structure for table `co_proveedor` */

DROP TABLE IF EXISTS `co_proveedor`;

CREATE TABLE `co_proveedor` (
  `PR_CodigoProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `PR_RazonSocialProveedor` varchar(45) DEFAULT NULL,
  `PR_DireccionProveedor` varchar(45) DEFAULT NULL,
  `PR_ContactoProveedor` varchar(100) DEFAULT NULL,
  `PR_TelefonoContacProveedor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PR_CodigoProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `co_proveedor` */

insert  into `co_proveedor`(`PR_CodigoProveedor`,`PR_RazonSocialProveedor`,`PR_DireccionProveedor`,`PR_ContactoProveedor`,`PR_TelefonoContacProveedor`) values (1,'Proveedores SA',NULL,NULL,NULL);

/*Table structure for table `co_proveedorproducto` */

DROP TABLE IF EXISTS `co_proveedorproducto`;

CREATE TABLE `co_proveedorproducto` (
  `CO_ProveedorProducto` int(11) NOT NULL AUTO_INCREMENT,
  `PR_CodigoProveedor` int(11) DEFAULT NULL,
  `PD_CodigoProducto` int(11) DEFAULT NULL,
  PRIMARY KEY (`CO_ProveedorProducto`),
  KEY `FK_REFERENCE_16` (`PR_CodigoProveedor`),
  KEY `FK_REFERENCE_17` (`PD_CodigoProducto`),
  CONSTRAINT `FK_REFERENCE_16` FOREIGN KEY (`PR_CodigoProveedor`) REFERENCES `co_proveedor` (`PR_CodigoProveedor`),
  CONSTRAINT `FK_REFERENCE_17` FOREIGN KEY (`PD_CodigoProducto`) REFERENCES `co_producto` (`PD_CodigoProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `co_proveedorproducto` */

insert  into `co_proveedorproducto`(`CO_ProveedorProducto`,`PR_CodigoProveedor`,`PD_CodigoProducto`) values (1,1,1);

/*Table structure for table `co_regla` */

DROP TABLE IF EXISTS `co_regla`;

CREATE TABLE `co_regla` (
  `RL_CodigoRegla` int(11) NOT NULL AUTO_INCREMENT,
  `PR_CodigoPromocion` int(11) DEFAULT NULL,
  `RL_PorCada` int(11) DEFAULT NULL,
  `RL_CostoBajaEn` decimal(11,2) DEFAULT NULL,
  `RL_BajarPrecioUnitEn` decimal(11,2) DEFAULT NULL,
  `RL_DescontarEn` decimal(11,2) DEFAULT NULL,
  `RL_TipoUnidadDesc` int(11) DEFAULT NULL,
  `RL_MontoMayorA` decimal(11,2) DEFAULT NULL,
  `RL_DescuentoDe` decimal(11,2) DEFAULT NULL,
  `RL_TipoCliente` int(11) DEFAULT NULL,
  `RL_ProdGenero` int(11) DEFAULT NULL,
  `RL_TipoProducto` int(11) DEFAULT NULL,
  PRIMARY KEY (`RL_CodigoRegla`),
  KEY `FK_REFERENCE_24` (`PR_CodigoPromocion`),
  CONSTRAINT `FK_REFERENCE_24` FOREIGN KEY (`PR_CodigoPromocion`) REFERENCES `co_promocion` (`PR_CodigoPromocion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*Data for the table `co_regla` */

/*Table structure for table `co_texto` */

DROP TABLE IF EXISTS `co_texto`;

CREATE TABLE `co_texto` (
  `TX_CodigoTexto` int(11) NOT NULL AUTO_INCREMENT,
  `TX_Titulo` varchar(100) DEFAULT NULL,
  `TX_ISBN` varchar(50) DEFAULT NULL,
  `TX_AnioEdicion` varchar(45) DEFAULT NULL,
  `TX_NumEdicion` varchar(45) DEFAULT NULL,
  `TX_NumPagina` varchar(45) DEFAULT NULL,
  `TX_Observacion` varchar(45) DEFAULT NULL,
  `TX_Estado` int(11) NOT NULL,
  `TX_FechaRegistro` varchar(45) DEFAULT NULL,
  `ED_CodigoEditorial` int(11) NOT NULL,
  `AT_CodigoAutor` int(11) DEFAULT NULL,
  `TX_EsPublico` int(11) DEFAULT NULL,
  `TX_EsComerciable` int(11) DEFAULT NULL,
  `PD_CodigoGenero` int(11) DEFAULT NULL,
  `PD_CodigoTipPublicacion` int(11) DEFAULT NULL,
  `PD_CodigoTipTapa` int(11) DEFAULT NULL,
  PRIMARY KEY (`TX_CodigoTexto`),
  KEY `FK_REFERENCE_11` (`AT_CodigoAutor`),
  KEY `FK_REFERENCE_2` (`ED_CodigoEditorial`),
  KEY `FK_REFERENCE_40` (`PD_CodigoGenero`),
  KEY `FK_REFERENCE_42` (`PD_CodigoTipTapa`),
  KEY `FK_REFERENCE_43` (`PD_CodigoTipPublicacion`),
  CONSTRAINT `FK_REFERENCE_11` FOREIGN KEY (`AT_CodigoAutor`) REFERENCES `co_autor` (`AT_CodigoAutor`),
  CONSTRAINT `FK_REFERENCE_2` FOREIGN KEY (`ED_CodigoEditorial`) REFERENCES `co_editorial` (`ED_CodigoEditorial`),
  CONSTRAINT `FK_REFERENCE_40` FOREIGN KEY (`PD_CodigoGenero`) REFERENCES `lb_parametricadet` (`PD_CodigoParametroDet`),
  CONSTRAINT `FK_REFERENCE_42` FOREIGN KEY (`PD_CodigoTipTapa`) REFERENCES `lb_parametricadet` (`PD_CodigoParametroDet`),
  CONSTRAINT `FK_REFERENCE_43` FOREIGN KEY (`PD_CodigoTipPublicacion`) REFERENCES `lb_parametricadet` (`PD_CodigoParametroDet`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `co_texto` */

insert  into `co_texto`(`TX_CodigoTexto`,`TX_Titulo`,`TX_ISBN`,`TX_AnioEdicion`,`TX_NumEdicion`,`TX_NumPagina`,`TX_Observacion`,`TX_Estado`,`TX_FechaRegistro`,`ED_CodigoEditorial`,`AT_CodigoAutor`,`TX_EsPublico`,`TX_EsComerciable`,`PD_CodigoGenero`,`PD_CodigoTipPublicacion`,`PD_CodigoTipTapa`) values (1,'La Caperucita Rota','ISBN00001','2000','12145','500','se lee',1,NULL,1,1,1,1,NULL,NULL,NULL),(3,'Edipo Rey','ISBN00002','2010','13','150',NULL,1,NULL,1,1,1,0,NULL,NULL,NULL),(4,'Metamorfosis','ISBN00003','2011','520','100',NULL,1,NULL,1,1,1,0,NULL,NULL,NULL),(5,'Los miserables','ISBN00004','2010','50','50','revisa',1,NULL,1,1,1,0,NULL,NULL,NULL),(6,'El jugador','ISBN00005','1999','20','150',NULL,1,NULL,1,1,1,0,NULL,NULL,NULL),(7,'Ana frank','ISBN00006','1540','480','50','112xa',1,NULL,1,1,1,0,NULL,NULL,NULL),(8,'Maria','ISBN00007','259','100','100',NULL,1,NULL,1,1,1,0,NULL,NULL,NULL);

/*Table structure for table `co_venta` */

DROP TABLE IF EXISTS `co_venta`;

CREATE TABLE `co_venta` (
  `VT_CodigoVenta` int(11) NOT NULL AUTO_INCREMENT,
  `VT_TipoDocumentoVenta` int(11) DEFAULT NULL COMMENT 'Tipo Doc Venta desde Parametrica',
  `VT_DocumentoSerie` varchar(50) DEFAULT NULL,
  `PE_CodigoPersonaCliente` int(11) DEFAULT NULL,
  `PE_CodigoPersonaTrabajador` int(11) DEFAULT NULL,
  `VT_FechaVenta` datetime DEFAULT NULL,
  `VT_EstadoVenta` int(11) DEFAULT NULL,
  `VT_SubTotal` decimal(11,2) DEFAULT NULL,
  `VT_ValorIGV` decimal(11,2) DEFAULT NULL,
  `VT_Total` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`VT_CodigoVenta`),
  KEY `FK_REFERENCE_19` (`PE_CodigoPersonaCliente`),
  KEY `FK_REFERENCE_20` (`PE_CodigoPersonaTrabajador`),
  CONSTRAINT `FK_REFERENCE_19` FOREIGN KEY (`PE_CodigoPersonaCliente`) REFERENCES `in_cliente` (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_20` FOREIGN KEY (`PE_CodigoPersonaTrabajador`) REFERENCES `lb_trabajador` (`PE_CodigoPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_venta` */

/*Table structure for table `co_ventadetalle` */

DROP TABLE IF EXISTS `co_ventadetalle`;

CREATE TABLE `co_ventadetalle` (
  `VD_VentaDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `PV_CodigoVenta` int(11) DEFAULT NULL,
  `VD_Cantidad` int(11) DEFAULT NULL,
  `VD_PrecioUnit` decimal(11,2) DEFAULT NULL,
  `VD_PrecioTotal` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`VD_VentaDetalle`),
  KEY `FK_REFERENCE_21` (`PV_CodigoVenta`),
  CONSTRAINT `FK_REFERENCE_21` FOREIGN KEY (`PV_CodigoVenta`) REFERENCES `co_venta` (`VT_CodigoVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_ventadetalle` */

/*Table structure for table `in_archivosadjunto` */

DROP TABLE IF EXISTS `in_archivosadjunto`;

CREATE TABLE `in_archivosadjunto` (
  `AJ_CodigoArchivoAdjunto` int(11) NOT NULL AUTO_INCREMENT,
  `MI_CodigoMovIntercambio` int(11) DEFAULT NULL,
  `AJ_RutaArchivoAdjunto` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`AJ_CodigoArchivoAdjunto`),
  KEY `FK_REFERENCE_29` (`MI_CodigoMovIntercambio`),
  CONSTRAINT `FK_REFERENCE_29` FOREIGN KEY (`MI_CodigoMovIntercambio`) REFERENCES `in_movimientointercambio` (`MI_CodigoMovIntercambio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*Table structure for table `co_venta_tmp` */

DROP TABLE IF EXISTS `co_venta_tmp`;

CREATE TABLE `co_venta_tmp` (
  `VT_CodigoVenta` int(11) NOT NULL AUTO_INCREMENT,
   `PV_CodigoVenta` int(11) DEFAULT NULL,
  `VT_TipoDocumentoVenta` int(11) DEFAULT NULL COMMENT 'Tipo Doc Venta desde Parametrica',
  `VT_DocumentoSerie` varchar(50) DEFAULT NULL,
  `PE_CodigoPersonaCliente` int(11) DEFAULT NULL,
  `PE_CodigoPersonaTrabajador` int(11) DEFAULT NULL,
  `VT_FechaVenta` datetime DEFAULT NULL,
  `VT_EstadoVenta` int(11) DEFAULT NULL,
  `VT_SubTotal` decimal(11,2) DEFAULT NULL,
  `VT_ValorIGV` decimal(11,2) DEFAULT NULL,
  `VT_Total` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`VT_CodigoVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_venta_tmp` */

/*Table structure for table `co_ventadetalle` */

DROP TABLE IF EXISTS `co_ventadetalle_tmp`;

CREATE TABLE `co_ventadetalle_tmp` (
  `VD_VentaDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `PV_CodigoVenta` int(11) DEFAULT NULL,
  `PD_CodigoProducto` int(11) DEFAULT NULL,
  `VD_Cantidad` int(11) DEFAULT NULL,
  `VD_PrecioUnit` decimal(11,2) DEFAULT NULL,
  `VD_PrecioTotal` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`VD_VentaDetalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `co_ventadetalle_tmp` */

/*Data for the table `in_archivosadjunto` */

/*Table structure for table `in_cliente` */

DROP TABLE IF EXISTS `in_cliente`;

CREATE TABLE `in_cliente` (
  `PE_CodigoPersona` int(11) NOT NULL AUTO_INCREMENT,
  `US_EstadoCliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_5` FOREIGN KEY (`PE_CodigoPersona`) REFERENCES `tb_persona` (`PE_CodigoPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `in_cliente` */

insert  into `in_cliente`(`PE_CodigoPersona`,`US_EstadoCliente`) values (1,1),(2,1),(3,1),(4,1),(5,1),(6,1);

/*Table structure for table `in_intercambio` */

DROP TABLE IF EXISTS `in_intercambio`;

CREATE TABLE `in_intercambio` (
  `IN_CodigoIntercambio` int(11) NOT NULL AUTO_INCREMENT,
  `MI_CodigoMovIntercambio` int(11) DEFAULT NULL,
  `IN_EstadoIntercambio` char(10) DEFAULT NULL,
  PRIMARY KEY (`IN_CodigoIntercambio`),
  KEY `FK_REFERENCE_30` (`MI_CodigoMovIntercambio`),
  CONSTRAINT `FK_REFERENCE_30` FOREIGN KEY (`MI_CodigoMovIntercambio`) REFERENCES `in_movimientointercambio` (`MI_CodigoMovIntercambio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `in_intercambio` */

/*Table structure for table `in_intercambiosproceso` */

DROP TABLE IF EXISTS `in_intercambiosproceso`;

CREATE TABLE `in_intercambiosproceso` (
  `PI_CodigoPreIntercambio` int(11) NOT NULL AUTO_INCREMENT,
  `MI_CodigoMovIntercambioOferta` int(11) DEFAULT NULL,
  `MI_CodigoMovIntercambioSolicitud` int(11) DEFAULT NULL,
  `PI_EstadoPreIntercambio` datetime DEFAULT NULL,
  PRIMARY KEY (`PI_CodigoPreIntercambio`),
  KEY `FK_REFERENCE_37` (`MI_CodigoMovIntercambioOferta`),
  KEY `FK_REFERENCE_38` (`MI_CodigoMovIntercambioSolicitud`),
  CONSTRAINT `FK_REFERENCE_37` FOREIGN KEY (`MI_CodigoMovIntercambioOferta`) REFERENCES `in_movimientointercambio` (`MI_CodigoMovIntercambio`),
  CONSTRAINT `FK_REFERENCE_38` FOREIGN KEY (`MI_CodigoMovIntercambioSolicitud`) REFERENCES `in_movimientointercambio` (`MI_CodigoMovIntercambio`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `in_intercambiosproceso` */

insert  into `in_intercambiosproceso`(`PI_CodigoPreIntercambio`,`MI_CodigoMovIntercambioOferta`,`MI_CodigoMovIntercambioSolicitud`,`PI_EstadoPreIntercambio`) values (5,35,26,NULL);

/*Table structure for table `in_movimientointercambio` */

DROP TABLE IF EXISTS `in_movimientointercambio`;

CREATE TABLE `in_movimientointercambio` (
  `MI_CodigoMovIntercambio` int(11) NOT NULL AUTO_INCREMENT,
  `MI_TipoOperacion` varchar(50) DEFAULT NULL,
  `PE_CodigoPersona` int(11) DEFAULT NULL,
  `AT_CodigoAutor` int(11) DEFAULT NULL,
  `MI_NombreAutor` varchar(50) DEFAULT NULL,
  `TX_CodigoTexto` int(11) DEFAULT NULL,
  `MI_TituloTexto` varchar(50) DEFAULT NULL,
  `MI_Calificacion` int(11) DEFAULT NULL,
  `MI_Genero` int(11) DEFAULT NULL,
  `MI_ISBN` varchar(45) NOT NULL,
  `MI_AnioEdicion` int(11) DEFAULT NULL,
  `MI_NumEdicion` varchar(45) DEFAULT NULL,
  `MI_NumPagina` varchar(45) DEFAULT NULL,
  `MI_Comentario` varchar(250) DEFAULT NULL,
  `MI_fechaRegistro` datetime DEFAULT NULL,
  `MI_EstadoMovIntercambio` int(11) DEFAULT NULL,
  PRIMARY KEY (`MI_CodigoMovIntercambio`),
  KEY `FK_REFERENCE_23` (`PE_CodigoPersona`),
  KEY `FK_REFERENCE_35` (`TX_CodigoTexto`),
  KEY `FK_REFERENCE_36` (`AT_CodigoAutor`),
  CONSTRAINT `FK_REFERENCE_22` FOREIGN KEY (`AT_CodigoAutor`) REFERENCES `co_autor` (`AT_CodigoAutor`),
  CONSTRAINT `FK_REFERENCE_23` FOREIGN KEY (`PE_CodigoPersona`) REFERENCES `in_cliente` (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_35` FOREIGN KEY (`TX_CodigoTexto`) REFERENCES `co_texto` (`TX_CodigoTexto`),
  CONSTRAINT `FK_REFERENCE_36` FOREIGN KEY (`AT_CodigoAutor`) REFERENCES `co_autor` (`AT_CodigoAutor`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `in_movimientointercambio` */

insert  into `in_movimientointercambio`(`MI_CodigoMovIntercambio`,`MI_TipoOperacion`,`PE_CodigoPersona`,`AT_CodigoAutor`,`MI_NombreAutor`,`TX_CodigoTexto`,`MI_TituloTexto`,`MI_Calificacion`,`MI_Genero`,`MI_ISBN`,`MI_AnioEdicion`,`MI_NumEdicion`,`MI_NumPagina`,`MI_Comentario`,`MI_fechaRegistro`,`MI_EstadoMovIntercambio`) values (22,'O',1,1,NULL,6,NULL,8,1,'001',2000,'100','199',NULL,NULL,1),(23,'S',1,1,NULL,3,NULL,6,1,'001',1999,'11','198',NULL,NULL,1),(24,'S',1,1,NULL,4,NULL,8,1,'001',2001,'11','165',NULL,NULL,1),(25,'S',1,1,NULL,5,NULL,6,2,'001',2002,NULL,'100',NULL,NULL,1),(26,'O',2,1,NULL,5,NULL,5,1,'001',1658,'11','50',NULL,NULL,2),(27,'O',1,1,NULL,7,NULL,9,2,'001',2000,'11','45',NULL,NULL,1),(28,'O',1,1,NULL,8,NULL,7,1,'001',1999,'11','50',NULL,NULL,1),(35,'S',2,1,NULL,6,NULL,8,1,'002',2001,'10','180',NULL,NULL,2),(36,'S',2,1,NULL,7,NULL,5,1,'003',1998,'11','150',NULL,NULL,1),(37,'O',3,1,NULL,4,NULL,4,1,'004',1900,'10','70',NULL,NULL,1),(38,'S',3,1,NULL,6,NULL,4,1,'005',1995,'15','42 ',NULL,NULL,1),(42,'O',4,1,NULL,5,NULL,4,1,'008',1999,'10','40',NULL,NULL,1),(43,'O',4,1,NULL,3,NULL,5,1,'009',1999,'20','50',NULL,NULL,1);

/*Table structure for table `in_textovalidacion` */

DROP TABLE IF EXISTS `in_textovalidacion`;

CREATE TABLE `in_textovalidacion` (
  `TV_CodigoTextoValidacion` int(11) NOT NULL AUTO_INCREMENT,
  `MI_CodigoMovIntercambio` int(11) DEFAULT NULL,
  `TV_Titulo` varchar(100) DEFAULT NULL,
  `TV_Autor` varchar(45) DEFAULT NULL,
  `TV_ISBN` varchar(45) DEFAULT NULL,
  `TV_AnioEdicion` varchar(45) DEFAULT NULL,
  `TV_NumEdicion` varchar(45) DEFAULT NULL,
  `TV_FechaRegistro` datetime DEFAULT NULL,
  `TV_PersonaRegistra` varchar(100) DEFAULT NULL,
  `TV_FechaValidacion` datetime DEFAULT NULL,
  `TV_PersonaValida` varchar(100) DEFAULT NULL,
  `TV_EstadoValidacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`TV_CodigoTextoValidacion`),
  KEY `FK_REFERENCE_34` (`MI_CodigoMovIntercambio`),
  CONSTRAINT `FK_REFERENCE_34` FOREIGN KEY (`MI_CodigoMovIntercambio`) REFERENCES `in_movimientointercambio` (`MI_CodigoMovIntercambio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `in_textovalidacion` */

/*Table structure for table `lb_gustosliterarios` */

DROP TABLE IF EXISTS `lb_gustosliterarios`;

CREATE TABLE `lb_gustosliterarios` (
  `GL_CodigoGusto` int(11) NOT NULL AUTO_INCREMENT,
  `PE_CodigoPersona` int(11) DEFAULT NULL,
  `PD_CodigoGenero` int(11) DEFAULT NULL,
  PRIMARY KEY (`GL_CodigoGusto`),
  KEY `FK_REFERENCE_39` (`PE_CodigoPersona`),
  KEY `FK_REFERENCE_41` (`PD_CodigoGenero`),
  CONSTRAINT `FK_REFERENCE_39` FOREIGN KEY (`PE_CodigoPersona`) REFERENCES `tb_persona` (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_41` FOREIGN KEY (`PD_CodigoGenero`) REFERENCES `lb_parametricadet` (`PD_CodigoParametroDet`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `lb_gustosliterarios` */

insert  into `lb_gustosliterarios`(`GL_CodigoGusto`,`PE_CodigoPersona`,`PD_CodigoGenero`) values (1,1,1);

/*Table structure for table `lb_parametricacab` */

DROP TABLE IF EXISTS `lb_parametricacab`;

CREATE TABLE `lb_parametricacab` (
  `PR_CodigoParametroCab` int(11) NOT NULL AUTO_INCREMENT,
  `PR_NombreParametroCab` varchar(50) DEFAULT NULL,
  `PR_DescripcionParametroCab` varchar(50) DEFAULT NULL,
  `PR_EstadoParametroCab` int(11) DEFAULT NULL,
  PRIMARY KEY (`PR_CodigoParametroCab`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `lb_parametricacab` */

insert  into `lb_parametricacab`(`PR_CodigoParametroCab`,`PR_NombreParametroCab`,`PR_DescripcionParametroCab`,`PR_EstadoParametroCab`) values (1,'Tipo Documento Identidad',NULL,1),(2,'Tipo Documento Venta',NULL,1),(3,'Tipo Estado Civil',NULL,1),(4,'Tipo Intercambio',NULL,1),(5,'Tipo Genero',NULL,1),(6,'Tipo Tapa',NULL,1),(7,'Tipo Publicacion',NULL,1),(8,'Tipo Producto',NULL,1),(9,'Tipo Cliente',NULL,1),(10,'Tipo Promocion',NULL,1),(11,'Estado Promocion',NULL,1);
/*Table structure for table `lb_parametricadet` */

DROP TABLE IF EXISTS `lb_parametricadet`;

CREATE TABLE `lb_parametricadet` (
  `PD_CodigoParametroDet` int(11) NOT NULL AUTO_INCREMENT,
  `PR_CodigoParametroCab` int(11) DEFAULT NULL,
  `PD_NombreElemento` varchar(50) DEFAULT NULL,
  `PD_ValorAtrbuto1` varchar(50) DEFAULT NULL,
  `PD_ValorAtrbuto2` varchar(50) DEFAULT NULL,
  `PD_ValorAtrbuto3` varchar(50) DEFAULT NULL,
  `PD_ValorAtrbuto4` varchar(50) DEFAULT NULL,
  `PD_EstadoElemento` int(11) DEFAULT NULL,
  PRIMARY KEY (`PD_CodigoParametroDet`),
  KEY `FK_REFERENCE_18` (`PR_CodigoParametroCab`),
  CONSTRAINT `FK_REFERENCE_18` FOREIGN KEY (`PR_CodigoParametroCab`) REFERENCES `lb_parametricacab` (`PR_CodigoParametroCab`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `lb_parametricadet` */

insert  into `lb_parametricadet`(`PD_CodigoParametroDet`,`PR_CodigoParametroCab`,`PD_NombreElemento`,`PD_ValorAtrbuto1`,`PD_ValorAtrbuto2`,`PD_ValorAtrbuto3`,`PD_ValorAtrbuto4`,`PD_EstadoElemento`) values (0,1,'RUC',NULL,NULL,NULL,NULL,NULL),(1,1,'DNI',NULL,NULL,NULL,NULL,NULL),(2,1,'CE',NULL,NULL,NULL,NULL,NULL),(3,2,'Boleta',NULL,NULL,NULL,NULL,NULL),(4,2,'Factura',NULL,NULL,NULL,NULL,NULL),(5,3,'Soltero',NULL,NULL,NULL,NULL,NULL),(6,3,'Casado',NULL,NULL,NULL,NULL,NULL),(7,4,'Coincidente',NULL,NULL,NULL,NULL,NULL),(8,4,'Posible Intercambio',NULL,NULL,NULL,NULL,NULL),(9,4,'Intento Intercambio',NULL,NULL,NULL,NULL,NULL),(10,4,'Intercambio Inteligente',NULL,NULL,NULL,NULL,NULL),(11,5,'Genero 1',NULL,NULL,NULL,NULL,NULL),(12,6,'Tapa1',NULL,NULL,NULL,NULL,NULL),(13,7,'Publicacion tipo 1',NULL,NULL,NULL,NULL,NULL), (19,10,'Descuento',NULL,NULL,NULL,NULL,NULL),(20,10,'Bajar Precio',NULL,NULL,NULL,NULL,NULL),(21,10,'Cantidad Ofrecida',NULL,NULL,NULL,NULL,NULL),(22,10,'Monto Mayor a',NULL,NULL,NULL,NULL,NULL), (23,9,'Minorista',NULL,NULL,NULL,NULL,NULL), (24,10,'Mayorista',NULL,NULL,NULL,NULL,NULL),  (26,8,'Texto',NULL,NULL,NULL,NULL,NULL), (27,8,'Lamina',NULL,NULL,NULL,NULL,NULL),(28,8,'Juego educativo',NULL,NULL,NULL,NULL,NULL),(29,11,'Vigente',NULL,NULL,NULL,NULL,NULL),(30,11,'Caducado',NULL,NULL,NULL,NULL,NULL),(31,11,'Anulado',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `lb_sede` */

DROP TABLE IF EXISTS `lb_sede`;

CREATE TABLE `lb_sede` (
  `SD_CodigoSede` int(11) NOT NULL AUTO_INCREMENT,
  `SD_Nombre` varchar(100) NOT NULL,
  `SD_Direccion` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SD_CodigoSede`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `lb_sede` */

insert  into `lb_sede`(`SD_CodigoSede`,`SD_Nombre`,`SD_Direccion`) values (1,'Sede 01','Av. abc'),(2,'Sede02','Av.Ayacucho');

/*Table structure for table `lb_trabajador` */

DROP TABLE IF EXISTS `lb_trabajador`;

CREATE TABLE `lb_trabajador` (
  `PE_CodigoPersona` int(11) NOT NULL AUTO_INCREMENT,
  `TJ_CorreoCorporativo` varchar(45) NOT NULL,
  `TJ_EstadoTrabajador` int(11) DEFAULT NULL,
  PRIMARY KEY (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_3` FOREIGN KEY (`PE_CodigoPersona`) REFERENCES `tb_persona` (`PE_CodigoPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `lb_trabajador` */

insert  into `lb_trabajador`(`PE_CodigoPersona`,`TJ_CorreoCorporativo`,`TJ_EstadoTrabajador`) values (1,'lennin12@hotmail.com',1),(3,'alanperales@gmail.com',1);

/*Table structure for table `lb_ubicacion` */

DROP TABLE IF EXISTS `lb_ubicacion`;

CREATE TABLE `lb_ubicacion` (
  `UB_CodigoUbicacion` int(11) NOT NULL AUTO_INCREMENT,
  `SD_CodigoSede` int(11) DEFAULT NULL,
  `PD_Codigo
` int(11) DEFAULT NULL,
  `UB_Ubicacion` varchar(100) DEFAULT NULL,
  `UB_Referencia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UB_CodigoUbicacion`),
  KEY `FK_REFERENCE_12` (`SD_CodigoSede`),
  KEY `FK_REFERENCE_13` (`PD_CodigoProducto`),
  CONSTRAINT `FK_REFERENCE_12` FOREIGN KEY (`SD_CodigoSede`) REFERENCES `lb_sede` (`SD_CodigoSede`),
  CONSTRAINT `FK_REFERENCE_13` FOREIGN KEY (`PD_CodigoProducto`) REFERENCES `co_producto` (`PD_CodigoProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `lb_ubicacion` */

/*Table structure for table `lb_ubigeo` */

DROP TABLE IF EXISTS `lb_ubigeo`;

CREATE TABLE `lb_ubigeo` (
  `UB_CodigoUbigeo` int(11) NOT NULL AUTO_INCREMENT,
  `UB_CodigoUbigeoPadre` int(11) DEFAULT NULL,
  `UB_CodExpresion` varchar(50) DEFAULT NULL,
  `UB_Descripcion` varchar(50) DEFAULT NULL,
  `UB_EstadoUbigeo` int(11) DEFAULT NULL,
  `UB_LatitudGps` varchar(50) DEFAULT NULL,
  `UB_LongitudGps` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UB_CodigoUbigeo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `lb_ubigeo` */

insert  into `lb_ubigeo`(`UB_CodigoUbigeo`,`UB_CodigoUbigeoPadre`,`UB_CodExpresion`,`UB_Descripcion`,`UB_EstadoUbigeo`,`UB_LatitudGps`,`UB_LongitudGps`) values (1,NULL,'01','Lima',1,NULL,NULL),(2,1,'0101','Lima',1,NULL,NULL),(3,2,'010101','Lois Olivos',1,NULL,NULL),(4,NULL,'030000','APURIMAC',1,NULL,NULL),(5,1,'030100','ABANCAY',1,NULL,NULL),(6,2,'030101','ABANCAY',1,NULL,NULL);

/*Table structure for table `sil_usuario_gps` */

DROP TABLE IF EXISTS `sil_usuario_gps`;

CREATE TABLE `sil_usuario_gps` (
  `UG_UsuarioGps` int(11) NOT NULL AUTO_INCREMENT,
  `PE_CodigoPersona` int(11) NOT NULL,
  `UG_Latitud` varchar(45) DEFAULT NULL,
  `UG_Longitud` varchar(45) DEFAULT NULL,
  `UG_EstadoGps` int(11) DEFAULT NULL,
  PRIMARY KEY (`UG_UsuarioGps`),
  KEY `FK_REFERENCE_10` (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_10` FOREIGN KEY (`PE_CodigoPersona`) REFERENCES `tb_usuario` (`PE_CodigoPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `sil_usuario_gps` */

insert  into `sil_usuario_gps`(`UG_UsuarioGps`,`PE_CodigoPersona`,`UG_Latitud`,`UG_Longitud`,`UG_EstadoGps`) values (1,1,'-11.9620649','-77.0810626',1),(2,2,'-11.960117','-77.079697',1),(3,3,'-11.9613436','-77.0718584',1),(18,4,'-11.9626976','-77.072132',1);

/*Table structure for table `tb_persona` */

DROP TABLE IF EXISTS `tb_persona`;

CREATE TABLE `tb_persona` (
  `PE_CodigoPersona` int(11) NOT NULL AUTO_INCREMENT,
  `PE_Nombre` varchar(100) NOT NULL,
  `PE_ApellidoPaterno` varchar(100) NOT NULL,
  `PE_ApellidoMaterno` varchar(100) DEFAULT NULL,
  `PE_FechaNacimiento` datetime DEFAULT NULL,
  `PE_NumeroDocIdentidad` varchar(20) DEFAULT NULL,
  `PE_EmailPersonal` varchar(45) DEFAULT NULL,
  `PE_Direccion` varchar(45) DEFAULT NULL,
  `PE_Urbanizacion` varchar(45) DEFAULT NULL,
  `PE_ReferenciaDomiciliaria` varchar(45) DEFAULT NULL,
  `PE_TelefonoCasa` varchar(45) DEFAULT NULL,
  `PE_Celular` varchar(45) DEFAULT NULL,
  `PE_Sexo` int(11) NOT NULL,
  `PD_CodigoEstadoCivil` int(11) DEFAULT NULL COMMENT 'Estado Civil desde Parametrica',
  `UB_CodigoUbigeo` int(11) NOT NULL,
  `PD_CodigoTipoDocIdentidad` int(11) DEFAULT NULL COMMENT 'Tipo Documento desde Parametrica',
  `PE_RutaFoto` varchar(45) DEFAULT NULL,
  `PE_FechaRegistro` datetime DEFAULT NULL,
  `PE_FechaActualizacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PE_CodigoPersona`),
  KEY `FK_REFERENCE_32` (`PD_CodigoEstadoCivil`),
  KEY `FK_REFERENCE_33` (`PD_CodigoTipoDocIdentidad`),
  KEY `FK_REFERENCE_9` (`UB_CodigoUbigeo`),
  CONSTRAINT `FK_REFERENCE_32` FOREIGN KEY (`PD_CodigoEstadoCivil`) REFERENCES `lb_parametricadet` (`PD_CodigoParametroDet`),
  CONSTRAINT `FK_REFERENCE_33` FOREIGN KEY (`PD_CodigoTipoDocIdentidad`) REFERENCES `lb_parametricadet` (`PD_CodigoParametroDet`),
  CONSTRAINT `FK_REFERENCE_9` FOREIGN KEY (`UB_CodigoUbigeo`) REFERENCES `lb_ubigeo` (`UB_CodigoUbigeo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_persona` */

insert  into `tb_persona`(`PE_CodigoPersona`,`PE_Nombre`,`PE_ApellidoPaterno`,`PE_ApellidoMaterno`,`PE_FechaNacimiento`,`PE_NumeroDocIdentidad`,`PE_EmailPersonal`,`PE_Direccion`,`PE_Urbanizacion`,`PE_ReferenciaDomiciliaria`,`PE_TelefonoCasa`,`PE_Celular`,`PE_Sexo`,`PD_CodigoEstadoCivil`,`UB_CodigoUbigeo`,`PD_CodigoTipoDocIdentidad`,`PE_RutaFoto`,`PE_FechaRegistro`,`PE_FechaActualizacion`) values (1,'Lennin','Davila','Sedano',NULL,'43588996','lennin.davila@gmail.com',NULL,NULL,NULL,NULL,NULL,1,3,3,1,NULL,NULL,NULL),(2,'Fanny','Salinas','Flores',NULL,'42577884','fsalinas2710@gmail.com',NULL,NULL,NULL,NULL,NULL,2,3,3,1,NULL,NULL,NULL),(3,'Alan','Perales','Arbizu',NULL,'48453321','alanperales@gmail.com',NULL,NULL,NULL,NULL,NULL,1,3,3,1,NULL,NULL,NULL),(4,'Diana','Torres','roja',NULL,'74528595','marytnc0507@gmail.com ',NULL,NULL,NULL,NULL,NULL,1,3,3,1,NULL,NULL,NULL),(5,'Omar','davila','davila',NULL,'45236584','fanny2710_11@hotmail.com',NULL,NULL,NULL,NULL,'',1,3,3,1,NULL,NULL,NULL),(6,'Mary','Tinoco','Sanchez',NULL,'47484642','diana2710_9@hotmail.com',NULL,NULL,NULL,NULL,NULL,1,3,1,1,NULL,NULL,NULL);

/*Table structure for table `tb_usuario` */

DROP TABLE IF EXISTS `tb_usuario`;

CREATE TABLE `tb_usuario` (
  `PE_CodigoPersona` int(11) NOT NULL AUTO_INCREMENT,
  `PL_CodigoPerfil` int(11) DEFAULT NULL,
  `US_usuario` varchar(45) DEFAULT NULL,
  `US_contrasenia` varchar(45) DEFAULT NULL,
  `US_EstadoTrabajdor` int(11) DEFAULT NULL,
  `US_Ultimasesion` datetime DEFAULT NULL,
  PRIMARY KEY (`PE_CodigoPersona`),
  KEY `FK_REFERENCE_6` (`PL_CodigoPerfil`),
  CONSTRAINT `FK_REFERENCE_1` FOREIGN KEY (`PE_CodigoPersona`) REFERENCES `tb_persona` (`PE_CodigoPersona`),
  CONSTRAINT `FK_REFERENCE_6` FOREIGN KEY (`PL_CodigoPerfil`) REFERENCES `cf_perfil` (`PL_CodigoPerfil`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `tb_usuario` */

insert  into `tb_usuario`(`PE_CodigoPersona`,`PL_CodigoPerfil`,`US_usuario`,`US_contrasenia`,`US_EstadoTrabajdor`,`US_Ultimasesion`) values (1,2,'ldavila','123',1,NULL),(2,1,'fsalinas','123',1,NULL),(3,2,'aperales','123',1,NULL),(4,2,'diana','123',1,NULL);

/*Table structure for table `temporalintercambio` */

DROP TABLE IF EXISTS `temporalintercambio`;

CREATE TABLE `temporalintercambio` (
  `TipoIntercambio` varchar(50) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL,
  `Usuario` varchar(50) DEFAULT NULL,
  `idtitsolicitado` int(11) DEFAULT NULL,
  `TituloSolicitado` varchar(50) DEFAULT NULL,
  `idtitofrecido` int(11) DEFAULT NULL,
  `TituloOfrecido` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `latitud` varchar(45) DEFAULT NULL,
  `longitud` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `temporalintercambio` */

insert  into `temporalintercambio`(`TipoIntercambio`,`idusuario`,`Usuario`,`idtitsolicitado`,`TituloSolicitado`,`idtitofrecido`,`TituloOfrecido`,`id`,`latitud`,`longitud`) values ('Coincidente',NULL,'Juan',NULL,'TextoS 1',NULL,'TextoO 1',1,'-11.9625375','-77.0811942'),('Coincidente',NULL,'Juan',NULL,'TextoS 1',NULL,'TextoO 2',2,'-11.9743307','-77.0741413'),('Coincidente',NULL,'Pedro',NULL,'TextoS 1',NULL,'TextoO 3',3,'-11.96345','-77.0688167'),('Coincidente',NULL,'Pedro',NULL,'TextoS 1',NULL,'TextoO 1',4,'-12.0802361','-77.0256756'),('Coincidente',NULL,'Pedro',NULL,'TextoS 1',NULL,'TextoO 1',5,'-12.062756','-77.0256756'),('Coincidente',NULL,'Pedro',NULL,'TextoS 1',NULL,'TextoO 1',6,'-12.0553011','-77.0802425'),('Posible intercambio',NULL,'Luis',NULL,'',NULL,'Miserables',7,'-12.0037712','-77.1876928');

/* Procedure structure for procedure `USP_AUTENTICACION_USUARIO` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_AUTENTICACION_USUARIO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_AUTENTICACION_USUARIO`(IN v_usuario varchar(45), IN v_contrasenia varchar(45))
BEGIN
	 SELECT 
			   U.PE_CodigoPersona,
			   U.PL_CodigoPerfil,
			   U.US_usuario,
			   P.PE_Nombre,
               P.PE_ApellidoPaterno,
               P.PE_ApellidoMaterno,
			   U.US_EstadoTrabajdor,
			   U.US_Ultimasesion,               
               CONCAT_WS(' / ',DEP.UB_Descripcion,PROV.UB_Descripcion,DIS.UB_Descripcion) AS ubigeo
	 FROM SIL2.tb_usuario U 
		inner join SIL2.tb_persona P on (P.PE_CodigoPersona = U.PE_CodigoPersona)
        INNER JOIN lb_ubigeo DIS ON (DIS.UB_CodigoUbigeo = P.UB_CodigoUbigeo)
		INNER JOIN lb_ubigeo PROV ON (PROV.UB_CodigoUbigeo = DIS.UB_CodigoUbigeoPadre)
		INNER JOIN lb_ubigeo DEP ON (DEP.UB_CodigoUbigeo = PROV.UB_CodigoUbigeoPadre)        
     WHERE U.US_usuario = v_usuario and U.US_contrasenia = v_contrasenia;
END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_INTERCAMBIAR` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_INTERCAMBIAR` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_INTERCAMBIAR`(IN v_codigoOfertado INT(11),IN v_codigoSolicitado INT(11))
BEGIN
	INSERT INTO `in_intercambiosproceso`(`MI_CodigoMovIntercambioOferta`,`MI_CodigoMovIntercambioSolicitud`)VALUES(v_codigoOfertado,v_codigoSolicitado);
	UPDATE `in_movimientointercambio` SET MI_EstadoMovIntercambio = 2 WHERE MI_CodigoMovIntercambio IN (v_codigoOfertado,v_codigoSolicitado);
END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_OBTENER_DET_PARAMETRICA_POR_CAB` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_OBTENER_DET_PARAMETRICA_POR_CAB` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_DET_PARAMETRICA_POR_CAB`(IN v_CodigoParametroCab int)
BEGIN
	SELECT * 
    FROM sil2.lb_parametricadet
    WHERE PR_CodigoParametroCab = v_CodigoParametroCab;
END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_OBTENER_OFERTAS_POR_OFERTANTE` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_OBTENER_OFERTAS_POR_OFERTANTE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_OFERTAS_POR_OFERTANTE`(IN v_codigoPersona INT(11))
BEGIN
	SELECT MI.MI_CodigoMovIntercambio,
		   MI.AT_CodigoAutor,
		   AT.AT_Nombre,
		   AT.AT_ApellidoPaterno,
		   MI.TX_CodigoTexto,
		   TX.TX_Titulo,
		   MI.MI_ISBN,
		   MI.MI_NumEdicion,
		   MI.MI_AnioEdicion
	FROM sil2.in_movimientointercambio MI
		 inner join sil2.co_texto TX on (TX.TX_CodigoTexto = MI.TX_CodigoTexto)
		 inner join sil2.co_autor AT on (AT.AT_CodigoAutor = MI.AT_CodigoAutor)
	where MI.MI_TipoOperacion = 'O' and MI.PE_CodigoPersona = v_codigoPersona;
END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_OBTENER_RESULTADO_INTERCAMBIOS` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_OBTENER_RESULTADO_INTERCAMBIOS` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_RESULTADO_INTERCAMBIOS`(IN v_codigoPersona INT(11),IN v_tipoIntercambio INT(11),IN v_textoOfrecido INT(11),IN v_textoSolicitado INT(11))
BEGIN
	DECLARE V_TIPO_INTERCAMBIO INT DEFAULT -1;
	SET @tipoIntercambio = v_tipoIntercambio;
	SET @textoOfrecido = v_textoOfrecido;
	SET @textoSolicitado = v_textoSolicitado;
         
         /*Intercambio Coincidente = 7*/
	/*Posible Intercambio = 8*/
	/*Intento Intercambio = 9*/
	/*Intercambio Inteligente = 10*/    
	
    
	DROP TEMPORARY TABLE IF EXISTS MIS_SOLICITADOS;
	CREATE TEMPORARY TABLE IF NOT EXISTS MIS_SOLICITADOS AS (
	SELECT *
	FROM sil2.in_movimientointercambio
	where MI_TipoOperacion = 'S' and PE_CodigoPersona = v_codigoPersona and MI_EstadoMovIntercambio = 1
	);    
    
	DROP TEMPORARY TABLE IF EXISTS MIS_OFRECIDOS;
	CREATE TEMPORARY TABLE IF NOT EXISTS MIS_OFRECIDOS AS (
	SELECT *
	FROM sil2.in_movimientointercambio
	where MI_TipoOperacion = 'O' and PE_CodigoPersona = v_codigoPersona and MI_EstadoMovIntercambio = 1
	);
    
	DROP TEMPORARY TABLE IF EXISTS ME_OFERTAN;
	CREATE TEMPORARY TABLE IF NOT EXISTS ME_OFERTAN AS (
	SELECT MV.* 
	FROM MIS_SOLICITADOS SL
	INNER JOIN sil2.in_movimientointercambio MV ON (MV.TX_CodigoTexto = SL.TX_CodigoTexto AND MV.MI_TipoOperacion = 'O' AND MV.MI_EstadoMovIntercambio=1)
	);    
    
	DROP TEMPORARY TABLE IF EXISTS ME_SOLICITAN;
	CREATE TEMPORARY TABLE IF NOT EXISTS ME_SOLICITAN AS (
	SELECT MV.*   
	FROM MIS_OFRECIDOS OF
	INNER JOIN sil2.in_movimientointercambio MV ON (MV.TX_CodigoTexto = OF.TX_CodigoTexto AND MV.MI_TipoOperacion = 'S' AND MV.MI_EstadoMovIntercambio=1)
	);
    
    /*COINCIDENTE*/
    DROP TEMPORARY TABLE IF EXISTS TMP_INT_COINCIDENTE;
	CREATE TEMPORARY TABLE IF NOT EXISTS TMP_INT_COINCIDENTE AS (
	SELECT MS.MI_CodigoMovIntercambio as idSolicitados,
		   MO.MI_CodigoMovIntercambio as idOfertados,
		   MS.PE_CodigoPersona,
		   MS.TX_CodigoTexto AS TS,           
		   MO.TX_CodigoTexto AS `TO`         
	FROM ME_SOLICITAN MS
		 INNER JOIN ME_OFERTAN MO ON (MO.PE_CodigoPersona = MS.PE_CodigoPersona)
	);
         
     /*POSIBLE INTERCAMBIO*/
    DROP TEMPORARY TABLE IF EXISTS TMP_POS_INTERCAMBIO;
	CREATE TEMPORARY TABLE IF NOT EXISTS TMP_POS_INTERCAMBIO AS (     
	 SELECT '' as idSolicitados,
		    MO.MI_CodigoMovIntercambio as idOfertados,
		    MO.PE_CodigoPersona,
		    '' AS TS,
		    MO.TX_CodigoTexto AS `TO`
	 FROM MIS_SOLICITADOS MS
		INNER JOIN ME_OFERTAN  MO ON (MO.TX_CodigoTexto = MS.TX_CodigoTexto)
	 WHERE MO.PE_CodigoPersona not in ( 
									 SELECT MV.PE_CodigoPersona
									 FROM sil2.in_movimientointercambio MV 
									 WHERE MV.PE_CodigoPersona <> 1 
											and MV.MI_EstadoMovIntercambio = 1 
											and MV.MI_TipoOperacion = 'S')
	);
                                            
	/*INTERCAMBIO INTELIGENTE*/
    DROP TEMPORARY TABLE IF EXISTS TMP_INT_INTELIGENTE;
	CREATE TEMPORARY TABLE IF NOT EXISTS TMP_INT_INTELIGENTE AS (     
	SELECT SEL1.* 
	FROM (
	SELECT MV.*
	FROM sil2.in_movimientointercambio MV 
	WHERE MV.TX_CodigoTexto NOT IN (SELECT MSS.TX_CodigoTexto FROM MIS_SOLICITADOS MSS)
	)SEL1 
	INNER JOIN (SELECT MV.* 
	FROM MIS_OFRECIDOS  MSO
		 INNER JOIN sil2.in_movimientointercambio MV ON (MV.TX_CodigoTexto = MSO.TX_CodigoTexto AND MV.MI_TipoOperacion = 'S')
	) SEL2 ON (SEL1.TX_CodigoTexto = SEL2.TX_CodigoTexto AND SEL1.PE_CodigoPersona = SEL2.PE_CodigoPersona)
    );
	/*INTENTO INTERCAMBIO*/
    DROP TEMPORARY TABLE IF EXISTS TMP_INT_INTERCAMBIO;
	CREATE TEMPORARY TABLE IF NOT EXISTS TMP_INT_INTERCAMBIO AS (       
	SELECT SEL1.* 
	FROM (
	SELECT MV.*
	FROM sil2.`in_movimientointercambio` MV 
	INNER JOIN MIS_SOLICITADOS MSS ON (MV.TX_CodigoTexto = MSS.TX_CodigoTexto )
	WHERE MV.MI_TipoOperacion = 'O'
	)SEL1 
	INNER JOIN (
	SELECT MV.*
	FROM sil2.in_movimientointercambio MV 
	INNER JOIN MIS_OFRECIDOS MSO ON (MV.TX_CodigoTexto <> MSO.TX_CodigoTexto )
	WHERE MV.MI_TipoOperacion = 'S'
	)SEL2 ON (SEL1.TX_CodigoTexto = SEL2.TX_CodigoTexto AND SEL1.PE_CodigoPersona = SEL2.PE_CodigoPersona)
    );    
    DROP TEMPORARY TABLE IF EXISTS TMP_RESULTADO_INTERCAMBIO;
    CREATE TEMPORARY TABLE IF NOT EXISTS TMP_RESULTADO_INTERCAMBIO AS (
	SELECT SELALL.*
	FROM (
	    SELECT 
		   TMC.idSolicitados as id,
		   '7' AS tipoIntercambio,
		   TMC.idOfertados,
		   TMC.PE_CodigoPersona,
		   CONCAT(P.`PE_Nombre`, ' ', P.`PE_ApellidoPaterno`,' ',P.`PE_ApellidoMaterno`) AS NombrePersona,
		   TMC.TS AS idSolicitado,
		   ST.`TX_Titulo` AS TituloS,
		   TMC.`TO`  AS idOfertado,
		   OT.`TX_Titulo` as TituloO,
		   GPS.`UG_Latitud` as latitud,
		   GPS.`UG_Longitud` as longitud,
		   '15' as distancia
	    FROM TMP_INT_COINCIDENTE TMC
		LEFT JOIN `tb_persona` P ON (P.`PE_CodigoPersona` = TMC.PE_CodigoPersona)
		LEFT JOIN `co_texto` ST ON (ST.`TX_CodigoTexto` = TMC.TS)
		LEFT JOIN `co_texto` OT ON (OT.`TX_CodigoTexto` = TMC.`TO`)
		left join `sil_usuario_gps` GPS on (GPS.`PE_CodigoPersona` = TMC.PE_CodigoPersona and GPS.`UG_EstadoGps` = 1)
	    UNION ALL
	    SELECT 
		   TMI.idSolicitados as id,
		   '8' AS tipoIntercambio,
		   TMI.idOfertados,
		   TMI.PE_CodigoPersona,
		   CONCAT(P.`PE_Nombre`, ' ', P.`PE_ApellidoPaterno`,' ',P.`PE_ApellidoMaterno`) AS NombrePersona,
		   TMI.TS as idSolicitado,
		   ST.`TX_Titulo` AS TituloS,
		   TMI.`TO` as idOfertado,
		   OT.`TX_Titulo` AS TituloO,
		   GPS.`UG_Latitud` as latitud,
		   GPS.`UG_Longitud` as longitud,
		   '15' as distancia		   
	    FROM TMP_POS_INTERCAMBIO TMI
		LEFT JOIN `tb_persona` P ON (P.`PE_CodigoPersona` = TMI.PE_CodigoPersona)
		LEFT JOIN `co_texto` ST ON (ST.`TX_CodigoTexto` = TMI.TS)
		LEFT JOIN `co_texto` OT ON (OT.`TX_CodigoTexto` = TMI.`TO`)
		LEFT JOIN `sil_usuario_gps` GPS ON (GPS.`PE_CodigoPersona` = TMI.PE_CodigoPersona AND GPS.`UG_EstadoGps` = 1)    
	    )SELALL
    );
    
    
    SELECT 	   
	   R.id,
	   R.tipoIntercambio,
	   R.idOfertados,
	   R.PE_CodigoPersona,
           R.NombrePersona,
	   R.idSolicitado,
	   R.TituloS,
	   R.idOfertado,
	   R.TituloO,
	   R.latitud,
	   R.longitud,
	   R.distancia
    FROM TMP_RESULTADO_INTERCAMBIO R
    WHERE (v_tipoIntercambio = 0 or R.tipoIntercambio = v_tipoIntercambio)
	  AND (v_textoSolicitado = 0 or R.idSolicitado = v_textoSolicitado )
	  AND (v_textoOfrecido = 0 or R.idOfertado = v_textoOfrecido);
    
  /* 
   
SET @query = "
    SELECT 	   
	   R.id,
	   R.tipoIntercambio,
	   R.idOfertados,
	   R.PE_CodigoPersona,
           R.NombrePersona,
	   R.idSolicitado,
	   R.TituloS,
	   R.idOfertado,
	   R.TituloO,
	   R.latitud,
	   R.longitud,
	   R.distancia
    FROM TMP_RESULTADO_INTERCAMBIO R;";
    
	if @tipoIntercambio > "0" then
	    SET @query = CONCAT(@query,' where  R.tipoIntercambio = ',@tipoIntercambio);
	elseif @textoOfrecido > "0" then
	    SET @query = CONCAT(@query,' where  R.tipoIntercambio = ',@textoOfrecido);
	ELSEIF @textoSolicitado > "0" THEN
	    SET @query = CONCAT(@query,' where  R.tipoIntercambio = ',@textoSolicitado);
	end if;
	
	   
	PREPARE stmt FROM @query;
	EXECUTE stmt;
	DEALLOCATE PREPARE stmt; 
    */
    /*UNION ALL
    SELECT * FROM TMP_INT_INTELIGENTE;
    /*UNION ALL
    SELECT * FROM TMP_INT_INTERCAMBIO;*/
   /* DROP TEMPORARY TABLE IF EXISTS TB_TEMP1;
	CREATE TEMPORARY TABLE IF NOT EXISTS TB_TEMP1 AS (
	SELECT PE_CodigoPersona,TX_CodigoTexto
	FROM sil2.in_movimientointercambio
	where MI_TipoOperacion = 'O'  and PE_CodigoPersona <> v_codigoPersona and TX_CodigoTexto in (select TX_CodigoTexto from TB_TEMP0) and MI_EstadoMovIntercambio = 1
	);
	DROP TEMPORARY TABLE IF EXISTS TB_TEMP2;
	CREATE TEMPORARY TABLE IF NOT EXISTS TB_TEMP2 AS (
	SELECT PE_CodigoPersona,TX_CodigoTexto
	FROM sil2.in_movimientointercambio
	where MI_TipoOperacion = 'S'  and PE_CodigoPersona in(select PE_CodigoPersona from TB_TEMP1) and MI_EstadoMovIntercambio = 1
	);
	DROP TEMPORARY TABLE IF EXISTS TB_TEMP3;
	CREATE TEMPORARY TABLE IF NOT EXISTS TB_TEMP3 AS (
	SELECT PE_CodigoPersona,TX_CodigoTexto
	FROM sil2.in_movimientointercambio
	where MI_TipoOperacion = 'O'  and PE_CodigoPersona = v_codigoPersona and TX_CodigoTexto in(select TX_CodigoTexto from TB_TEMP2) and MI_EstadoMovIntercambio = 1
	);*/
	/*select * from TB_TEMP0;
	select * from TB_TEMP1;
	select * from TB_TEMP2;
	select * from TB_TEMP3;*/
	    /*
	SELECT (@V_PASO_0:= count(*)) from TB_TEMP0;
    SELECT (@V_PASO_1:= count(*)) from TB_TEMP1;
    SELECT (@V_PASO_2:= count(*)) from TB_TEMP2;
    SELECT (@V_PASO_3:= count(*)) from TB_TEMP3;*/
    
    /*SELECT @V_PASO_0;*/
    
    /*Intercambio Coincidente*/
    /*
	IF @V_PASO_0 > 0 AND @V_PASO_1 > 0 AND @V_PASO_2 > 0 AND @V_PASO_3 > 0 THEN
        SET V_TIPO_INTERCAMBIO = 11; /*Intercambio Coincidente*/
        /*
		DROP TEMPORARY TABLE IF EXISTS TB_COINCIDENTE0;
		CREATE TEMPORARY TABLE IF NOT EXISTS TB_COINCIDENTE0 AS (
			SELECT 'Coincidente' AS TipoIntercambio,
				   O.PE_CodigoPersona,
				   U.US_usuario,
				   O.TX_CodigoTexto AS CodigoOfrecido,
				   TXO.TX_titulo AS TextoOfrecido,
				   S1.TX_CodigoTexto AS CodigoSolicitado,
				   TXS.TX_titulo AS TextoSolicitado
			FROM TB_TEMP1 O
				  inner join TB_TEMP2 S on (S.PE_CodigoPersona= O.PE_CodigoPersona)
				  inner join TB_TEMP3 S1 on (S1.TX_CodigoTexto = S.TX_CodigoTexto)
				  left join sil2.co_texto TXO on (TXO.TX_CodigoTexto = O.TX_CodigoTexto)
				  left join sil2.co_texto TXS on (TXS.TX_CodigoTexto = S.TX_CodigoTexto)
				  left join sil2.tb_usuario U on (U.PE_CodigoPersona = O.PE_CodigoPersona)
		); 
	END IF;*/
    
    /*Posible Intercambio*/
	/*IF @V_PASO_0 > 0 AND @V_PASO_1 > 0 THEN
        SET V_TIPO_INTERCAMBIO = 8; /*Posible Intercambio*/
	/*END IF; 
    */
    /*
    SELECT * FROM TB_COINCIDENTE0;*/
END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_OBTENER_SOLICITUDES_POR_SOLICITANTE` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_OBTENER_SOLICITUDES_POR_SOLICITANTE` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_SOLICITUDES_POR_SOLICITANTE`(IN v_codigoPersona INT(11))
BEGIN
	SELECT MI.MI_CodigoMovIntercambio,
		   MI.AT_CodigoAutor,
		   AT.AT_Nombre,
		   AT.AT_ApellidoPaterno,
		   MI.TX_CodigoTexto,
		   TX.TX_Titulo
	FROM sil2.in_movimientointercambio MI
		 inner join sil2.co_texto TX on (TX.TX_CodigoTexto = MI.TX_CodigoTexto)
		 inner join sil2.co_autor AT on (AT.AT_CodigoAutor = MI.AT_CodigoAutor)
	where MI.MI_TipoOperacion = 'S' and MI.PE_CodigoPersona = v_codigoPersona;
END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_OBTENER_TEXTOS_INTERCAMBIO` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_OBTENER_TEXTOS_INTERCAMBIO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_TEXTOS_INTERCAMBIO`()
BEGIN
	SELECT * 
    FROM sil2.co_texto
    WHERE TX_EsPublico = 1;
END */$$
DELIMITER ;

/* Procedure structure for procedure `USP_OBTENER_TEXTO_OFERTADO` */

/*!50003 DROP PROCEDURE IF EXISTS  `USP_OBTENER_TEXTO_OFERTADO` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `USP_OBTENER_TEXTO_OFERTADO`(IN v_codigoTexto INT(11))
BEGIN
	SELECT 
		TXT.`TX_CodigoTexto`,
		TXT.`TX_Titulo`,
		TXT.`TX_ISBN`,
		TXT.`TX_AnioEdicion`,
		TXT.`TX_NumEdicion`,
		TXT.`TX_NumPagina`,
		TXT.`TX_Observacion`,
		TXT.`TX_Estado`,
		TXT.`ED_CodigoEditorial`,
		TXT.`AT_CodigoAutor`,
		AUT.`AT_CodigoAutor`,
		CONCAT(AUT.`AT_Nombre`, ' ', AUT.`AT_ApellidoPaterno`,' ',AUT.`AT_ApellidoMaterno`) AS NombreAutor,
		TXT.`TX_EsPublico`,
		TXT.`TX_EsComerciable`,
		TXT.`PD_CodigoGenero`,
		TXT.`PD_CodigoTipPublicacion`,
		TXT.`PD_CodigoTipTapa`
	FROM `co_texto` TXT
	INNER JOIN `co_autor` AUT ON (TXT.`AT_CodigoAutor` = AUT.`AT_CodigoAutor`)
	WHERE TXT.`TX_CodigoTexto` = v_codigoTexto;
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
