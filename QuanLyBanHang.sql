/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     14/5/2021 8:42:06 PM                         */
/*==============================================================*/


alter table CTHD
   drop constraint FK_CTHD_CTHD_SANPHAM;

alter table CTHD
   drop constraint FK_CTHD_CTHD2_HOADON;

alter table HOADON
   drop constraint FK_HOADON_LAP_NHANVIEN;

alter table HOADON
   drop constraint FK_HOADON_MUA_KHACHHAN;

drop index CTHD2_FK;

drop index CTHD_FK;

drop table CTHD cascade constraints;

drop index MUA_FK;

drop index LAP_FK;

drop table HOADON cascade constraints;

drop table KHACHHANG cascade constraints;

drop table NHANVIEN cascade constraints;

drop table SANPHAM cascade constraints;

/*==============================================================*/
/* Table: CTHD                                                  */
/*==============================================================*/
create table CTHD 
(
   MASP                 CHAR(4)              not null,
   SOHD                 INTEGER              not null,
   SL                   INTEGER,
   constraint PK_CTHD primary key (MASP, SOHD)
);

/*==============================================================*/
/* Index: CTHD_FK                                               */
/*==============================================================*/
create index CTHD_FK on CTHD (
   MASP ASC
);

/*==============================================================*/
/* Index: CTHD2_FK                                              */
/*==============================================================*/
create index CTHD2_FK on CTHD (
   SOHD ASC
);

/*==============================================================*/
/* Table: HOADON                                                */
/*==============================================================*/
create table HOADON 
(
   SOHD                 INTEGER              not null,
   MAKH                 CHAR(4)              not null,
   MANV                 CHAR(4)              not null,
   NGHD                 DATE,
   TRIGIA               NUMBER(8,2),
   constraint PK_HOADON primary key (SOHD)
);

/*==============================================================*/
/* Index: LAP_FK                                                */
/*==============================================================*/
create index LAP_FK on HOADON (
   MANV ASC
);

/*==============================================================*/
/* Index: MUA_FK                                                */
/*==============================================================*/
create index MUA_FK on HOADON (
   MAKH ASC
);

/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/
create table KHACHHANG 
(
   MAKH                 CHAR(4)              not null,
   HOTEN                VARCHAR2(40),
   DCHI                 VARCHAR2(50),
   SODT                 VARCHAR2(20),
   NGSINH               DATE,
   NGDK                 DATE,
   constraint PK_KHACHHANG primary key (MAKH)
);

/*==============================================================*/
/* Table: NHANVIEN                                              */
/*==============================================================*/
create table NHANVIEN 
(
   MANV                 CHAR(4)              not null,
   HOTEN                VARCHAR2(40),
   NGSINH               DATE,
   GIOITINH             VARCHAR2(5),
   CMND                 VARCHAR2(10),
   DIACHI               VARCHAR2(50),
   SODT                 VARCHAR2(20),
   PASSWORD             VARCHAR2(20),
   constraint PK_NHANVIEN primary key (MANV)
);

/*==============================================================*/
/* Table: SANPHAM                                               */
/*==============================================================*/
create table SANPHAM 
(
   MASP                 CHAR(4)              not null,
   TENSP                VARCHAR2(40),
   DVT                  VARCHAR2(20),
   NUOCSX               VARCHAR2(40),
   GIA                  NUMBER(8,2),
   constraint PK_SANPHAM primary key (MASP)
);

alter table CTHD
   add constraint FK_CTHD_CTHD_SANPHAM foreign key (MASP)
      references SANPHAM (MASP);

alter table CTHD
   add constraint FK_CTHD_CTHD2_HOADON foreign key (SOHD)
      references HOADON (SOHD);

alter table HOADON
   add constraint FK_HOADON_LAP_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);

alter table HOADON
   add constraint FK_HOADON_MUA_KHACHHAN foreign key (MAKH)
      references KHACHHANG (MAKH);

-- INSERT D? LI?U
-- KHACHHANG
alter session set NLS_DATE_FORMAT = 'DD/MM/YYYY';
INSERT INTO KHACHHANG VALUES('KH01', 'Nguyen Van A','731 Tran Hung Dao, Q5, TpHCM','098823451','22/10/1960', '22/07/2006');
INSERT INTO KHACHHANG VALUES('KH02', 'Tran Ngoc Han',' 23/5 Nguyen Trai, Q5, TpHCM', '0908256478','3/4/1974','30/07/2006');
INSERT INTO KHACHHANG VALUES('KH03', 'Tran Ngoc Linh', '45 Nguyen Canh Chan, Q1, TpHCM', '0938776266', '12/6/1980', '05/08/2006');
INSERT INTO KHACHHANG VALUES('KH04', 'Tran Minh Long',' 50/34 Le Dai Hanh, Q10, TpHCM',' 0917325476', '9/3/1965', '02/10/2006');
INSERT INTO KHACHHANG VALUES('KH05', 'Le Nhat Minh',' 34 Truong Dinh, Q3, TpHCM', '08246108', '10/3/1950','28/10/2006' );
INSERT INTO KHACHHANG VALUES('KH06', 'Le Hoai Thuong',' 227 Nguyen Van Cu, Q5, TpHCM', '08631738',' 31/12/1981', '24/11/2006');
INSERT INTO KHACHHANG VALUES('KH07', 'Nguyen Van Tam',' 32/3 Tran Binh Trong, Q5, TpHCM',' 0916783565', '6/4/1971','01/12/2006');
INSERT INTO KHACHHANG VALUES('KH08', 'Phan Thi Thanh','45/2 An Duong Vuong, Q5, TpHCM','0938435756', '10/1/1971',' 13/12/2006');
INSERT INTO KHACHHANG VALUES('KH09', 'Le Ha Vinh', '873 Le Hong Phong, Q5, TpHCM','08654763',' 3/9/1979','14/01/2007');
INSERT INTO KHACHHANG VALUES('KH10', 'Ha Duy Lap', '34/34B Nguyen Trai, Q1, TpHCM', '08768904', '2/5/1983', '16/01/2007');

-- NHANVIEN
INSERT INTO NHANVIEN VALUES('NV01','Nguyen Nhu Nhut', '13/4/2006', 'Nu', '197402123', '432 Tran Hung Dao, Q5, TP HCM', '0927345678', '123456');
INSERT INTO NHANVIEN VALUES('NV02','Le Thi Phi Yen','21/4/2006', 'Nu', ' 205456372', 'Phan Thi Tu, Binh Chanh, TP HCM', '0987567390', '132465');
INSERT INTO NHANVIEN VALUES('NV03','Nguyen Van B','27/4/2006', 'Nam', '204678432', 'Lien ap 123, Binh Hung Hoa, Binh Tan, TP HCM', '0997047382','124356');
INSERT INTO NHANVIEN VALUES('NV04','Ngo Thanh Tuan','24/6/2006', 'Nam', '197506386', '345 Le Hong Phong, Q5, TP HCM', '0913758498', '213465');
INSERT INTO NHANVIEN VALUES('NV05','Nguyen Thi Truc Thanh','20/7/2006', 'Nu', '234564867', '32/2 An Duong Vuong, Q5, TP HCM', '0918590387', '643251');

-- SANPHAM
INSERT INTO SANPHAM VALUES('BC01','But chi', 'cay', 'Singapore', 3000);
INSERT INTO SANPHAM VALUES('BC03','But chi', 'cay','Viet Nam', 3500);
INSERT INTO SANPHAM VALUES('BC04','But chi', 'hop','Viet Nam', 3000);
INSERT INTO SANPHAM VALUES('BB01','But bi', 'cay', 'Viet Nam', 5000);
INSERT INTO SANPHAM VALUES('BB02','But bi', 'cay', 'Trung Quoc', 7000);
INSERT INTO SANPHAM VALUES('BB03', 'But bi', 'hop', 'Thai Lan', 100000);
INSERT INTO SANPHAM VALUES('TV01', 'Tap 100 giay mong', 'quyen', 'Trung Quoc', 2500);
INSERT INTO SANPHAM VALUES('TV02', 'Tap 200 giay mong', 'quyen', 'Trung Quoc', 4500);
INSERT INTO SANPHAM VALUES('TV03', 'Tap 100 giay tot', 'quyen', 'Viet Nam', 3500);
INSERT INTO SANPHAM VALUES('TV04', 'Tap 200 giay tot', 'quyen', 'Viet Nam', 5500);
INSERT INTO SANPHAM VALUES('TV05', 'Tap 100 trang', 'chuc', 'Viet Nam', 23000);
INSERT INTO SANPHAM VALUES('TV06', 'Tap 200 trang', 'chuc', 'Viet Nam', 53000);
INSERT INTO SANPHAM VALUES('TV07', 'Tap 100 trang', 'chuc', 'Trung Quoc', 34000);
INSERT INTO SANPHAM VALUES('ST01','So tay 500 trang', 'quyen','Trung Quoc', 40000);
INSERT INTO SANPHAM VALUES('ST02','So tay loai 1', 'quyen',' Viet Nam ', 55000);
INSERT INTO SANPHAM VALUES('ST03','So tay loai 2', 'quyen',' Viet Nam ', 51000);
INSERT INTO SANPHAM VALUES('ST04','So tay', 'quyen','Thai Lan', 55000);
INSERT INTO SANPHAM VALUES('ST05','So tay mong', 'quyen','Thai Lan', 20000);
INSERT INTO SANPHAM VALUES('ST06','Phan viet bang', 'hop',' Viet Nam ', 5000);
INSERT INTO SANPHAM VALUES('ST07','Phan khong bui', 'hop',' Viet Nam ', 7000);
INSERT INTO SANPHAM VALUES('ST08','Bong bang', 'cai',' Viet Nam ', 1000);
INSERT INTO SANPHAM VALUES('ST09','But long', 'cay',' Viet Nam ', 5000);
INSERT INTO SANPHAM VALUES('ST10','But long', 'cay','Trung Quoc', 7000);

-- HOA DON
INSERT INTO HOADON VALUES(1001, 'KH01', 'NV01',  '23/07/2006', 320000);
INSERT INTO HOADON VALUES(1002, 'KH01', 'NV02', '12/08/2006', 840000);
INSERT INTO HOADON VALUES(1003, 'KH02', 'NV01', '23/08/2006', 100000);
INSERT INTO HOADON VALUES(1004, 'KH02', 'NV01', '01/09/2006', 180000);
INSERT INTO HOADON VALUES(1005, 'KH01', 'NV02', '20/10/2006', 3800000);
INSERT INTO HOADON VALUES(1006, 'KH01', 'NV03', '16/10/2006', 2430000);
INSERT INTO HOADON VALUES(1007, 'KH03', 'NV03', '28/10/2006', 510000);
INSERT INTO HOADON VALUES(1008, 'KH01', 'NV03', '28/10/2006', 440000);
INSERT INTO HOADON VALUES(1009, 'KH03', 'NV04', '28/10/2006', 200000);
INSERT INTO HOADON VALUES(1010, 'KH01', 'NV01', '01/11/2006', 5200000);
INSERT INTO HOADON VALUES(1011, 'KH04', 'NV03', '04/11/2006', 250000);
INSERT INTO HOADON VALUES(1012, 'KH05', 'NV03', '30/11/2006', 21000);
INSERT INTO HOADON VALUES(1013 , 'KH06', 'NV01', '12/12/2006', 5000);
INSERT INTO HOADON VALUES(1014, 'KH03', 'NV02' , '31/12/2006', 3150000);
INSERT INTO HOADON VALUES(1015, 'KH06', 'NV01' , '01/01/2007', 910000);
INSERT INTO HOADON VALUES(1016, 'KH07', 'NV02' , '01/01/2007', 12500);
INSERT INTO HOADON VALUES(1017, 'KH08', 'NV03', '02/01/2007', 35000);
INSERT INTO HOADON VALUES(1018, 'KH08', 'NV03', '13/01/2007', 330000);
INSERT INTO HOADON VALUES(1019, 'KH01', 'NV03', '13/01/2007', 300000);
INSERT INTO HOADON VALUES(1020, 'KH09', 'NV04', '14/01/2007', 70000);
INSERT INTO HOADON VALUES(1021, 'KH10', 'NV03', '16/01/2007', 67500);

-- CTHD
INSERT INTO CTHD VALUES('TV02',1001,  10);
INSERT INTO CTHD VALUES( 'ST01',1001,  5);
INSERT INTO CTHD VALUES('BC01',1001,  5);
INSERT INTO CTHD VALUES('BC02',1001,  10);
INSERT INTO CTHD VALUES('ST08',1001,  10);
INSERT INTO CTHD VALUES('BC04',1002,  20);
INSERT INTO CTHD VALUES('BB01',1002,  20);
INSERT INTO CTHD VALUES('BB02',1002,  20);
INSERT INTO CTHD VALUES('BB03',1003,  10);
INSERT INTO CTHD VALUES('TV01',1004,  20);
INSERT INTO CTHD VALUES('TV02',1004,  10);
INSERT INTO CTHD VALUES('TV03',1004,  10);
INSERT INTO CTHD VALUES('TV04',1004,  10);
INSERT INTO CTHD VALUES('TV05',1005,  50);
INSERT INTO CTHD VALUES('TV06',1005,  50);
INSERT INTO CTHD VALUES( 'TV07',1006, 20);
INSERT INTO CTHD VALUES('ST01',1006,  30);
INSERT INTO CTHD VALUES( 'ST05',1009, 10);
INSERT INTO CTHD VALUES('TV07',1010,  50);
INSERT INTO CTHD VALUES( 'ST07',1010, 50);
INSERT INTO CTHD VALUES('ST08',1010,  100);
INSERT INTO CTHD VALUES('TV03',1010,  100);
INSERT INTO CTHD VALUES('ST06', 1011, 50);
INSERT INTO CTHD VALUES('ST07', 1012, 3);
INSERT INTO CTHD VALUES('ST08',1013,  5);
INSERT INTO CTHD VALUES( 'BC02',1014, 80);
INSERT INTO CTHD VALUES( 'BB02',1014, 100);
INSERT INTO CTHD VALUES('BC04',1014,  60);
INSERT INTO CTHD VALUES( 'BB01',1014, 50);
INSERT INTO CTHD VALUES('BB02',1015,  30);
INSERT INTO CTHD VALUES('BB03',1015,  7);
INSERT INTO CTHD VALUES('TV01',1016,  5);
INSERT INTO CTHD VALUES('TV02',1017,  1);
INSERT INTO CTHD VALUES('TV03',1017,  1);
INSERT INTO CTHD VALUES('TV04',1017,  5);
INSERT INTO CTHD VALUES( 'ST04',1018, 6);
INSERT INTO CTHD VALUES('ST05',1019,  1);
INSERT INTO CTHD VALUES( 'ST06',1019, 2);
INSERT INTO CTHD VALUES('ST07',1020, 'ST07', 10);
INSERT INTO CTHD VALUES( 'ST08', 1021, 5);
INSERT INTO CTHD VALUES('TV01',1021,  7);
INSERT INTO CTHD VALUES('TV02',1021,  10);

select* from nhanvien



