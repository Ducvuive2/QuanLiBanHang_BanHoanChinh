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
select * from hoadon;
select * from cthd;
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
    NGHD                 DATE,
   MAKH                 CHAR(4)            ,
   MANV                 CHAR(4)              not null,  
   TRIGIA               NUMBER,
   constraint PK_HOADON primary key (SOHD)
);
select * from hoadon;

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
   DOANHSO              NUMBER,
   NGDK                 DATE,
   constraint PK_KHACHHANG primary key (MAKH)
);
select * from nhanvien;
drop table hoadon;
drop table khachhang;
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
   USERID               VARCHAR2(20),
   PASSWORD             VARCHAR2(20),
   LOAINV             VARCHAR2(20),
   constraint PK_NHANVIEN primary key (MANV)
);
commit;
ALTER TABLE NHANVIEN  
  RENAME COLUMN NGSINH to ngVL ;
select * from nhanvien;
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
commit ;
select * from hoadon;
-- KHACHHANG
alter session set NLS_DATE_FORMAT = 'DD/MM/YYYY';
INSERT INTO KHACHHANG  VALUES ('KH01', 'Nguyen Van A', '731, Tran Hung Dao, Q5, TPHCM', '08823451', '22/10/1960', 13060000, '22/07/2006');
INSERT INTO KHACHHANG  VALUES ('KH02', 'Tran Ngoc Han', '23/5 Nguyen Trai, Q5, TpHCM', '0908256478', '03/04/1974', 280000, '30/07/2006');
INSERT INTO KHACHHANG  VALUES ('KH03', 'Tran Ngoc Linh', '45 Nguyen Canh Chan, Q1, TpHCM', '0938776266', '12/06/1980', 3860000, '05/08/2006');
INSERT INTO KHACHHANG  VALUES ('KH04', 'Tran Minh Long', '50/34 Le Dai hanh, Q10, TpHCM', '0917325476', '09/03/1965', 250000, '02/10/2006');
INSERT INTO KHACHHANG  VALUES ('KH05', 'Le Nhat Minh', '34 Truong Dinh, Q3, TPHCM', '08246108', '10/03/1960', 21000, '28/10/2006');
INSERT INTO KHACHHANG  VALUES ('KH06', 'Le Hoai Thuong', '227 Nguyen Van Cu, Q5, TpHCM', '08631738', '31/12/1981', 915000, '24/11/2006');
INSERT INTO KHACHHANG  VALUES ('KH07', 'Nguyen Van Tam', '32/3 Tran Binh Trong, Q5, TpHCM', '0916783565', '06/04/1971', 12500, '01/12/2006');
INSERT INTO KHACHHANG  VALUES ('KH08', 'Phan Thi Thanh', '45/2 An Duong Vuong, Q5, TPHCM', '0938435756', '10/01/1971', 365000, '13/12/2006');
INSERT INTO KHACHHANG  VALUES ('KH09', 'Le Ha Vinh', '873 Le Hong Phong, Q5, TPHCM', '08654763', '03/09/1979', 70000, '14/01/2007');
INSERT INTO KHACHHANG  VALUES ('KH10', 'Ha Duy Lap', '34/34B Nguyen Trai, Q1, TPHCM', '08768904', '02/05/1963', 67500, '16/01/2007');
INSERT INTO KHACHHANG  VALUES ('KH11', 'Nguyen Thi Lin', 'ktx khu a, Dong hoa, Di An, Binh Duong', '0345678542', '02/05/2001', 0, '16/01/2020');
INSERT INTO KHACHHANG  VALUES ('KH12', 'Nguyen Thuy Tien', 'Duong Phan Thi Tu, Vinh Loc A, Binh Chanh, TPHCM', '0345670942', '02/06/2001', 0, '16/02/2020');
INSERT INTO KHACHHANG  VALUES ('KH13', 'Nguyen Man', 'Duong Phan Thi Tu, Vinh Loc A, Binh Chanh, TPHCM', '0345678576', '02/05/1982', 0, '04/03/2020');
INSERT INTO KHACHHANG  VALUES ('KH14', 'Le Dinh Trai', 'Duong Thoi Hoa, Vinh Loc A, Binh Chanh, TPHCM', '0355678576', '02/08/1982', 0, '04/03/2021');
INSERT INTO KHACHHANG  VALUES ('KH15', 'Nguyen Thu Hang', 'Duong Quach Dieu, Vinh Loc A, Binh Chanh, TPHCM', '0987678576', '02/05/1990', 0, '05/10/2020');

commit;
-- NHANVIEN
INSERT INTO NHANVIEN VALUES('NV01','Nguyen Nhu Nhut', '13/4/2006', 'Nu', '197402123', '432 Tran Hung Dao, Q5, TP HCM', '0927345678','NV01', '123456','QUAN LY');
INSERT INTO NHANVIEN VALUES('NV02','Le Thi Phi Yen','21/4/2006', 'Nu', ' 205456372', 'Phan Thi Tu, Binh Chanh, TP HCM', '0987567390', 'NV02','123456','NHAN VIEN');
INSERT INTO NHANVIEN VALUES('NV03','Nguyen Van B','27/4/2006', 'Nam', '204678432', 'Lien ap 123, Binh Hung Hoa, Binh Tan, TP HCM', '0997047382','NV03','124356','NHAN VIEN');
INSERT INTO NHANVIEN VALUES('NV04','Ngo Thanh Tuan','24/6/2006', 'Nam', '197506386', '345 Le Hong Phong, Q5, TP HCM', '0913758498','NV04', '213465','NHAN VIEN');
INSERT INTO NHANVIEN VALUES('NV05','Nguyen Thi Truc Thanh','20/7/2006', 'Nu', '234564867', '32/2 An Duong Vuong, Q5, TP HCM', '0918590387','NV05 ', '643251','NHAN VIEN');
select * from nhanvien;
--SAN PHAM--
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('BC01', 'But Chi', 'cay', 'Singapore', 3000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('BC02', 'But Chi', 'cay', 'Singapore', 5000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('BC03', 'But Chi', 'cay', 'Viet Nam', 3500);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('BC04', 'But Chi', 'hop', 'Viet Nam', 30000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('BB01', 'But bi', 'cay', 'Viet Nam', 5000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('BB02', 'But bi', 'cay', 'Trung Quoc', 7000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('BB03', 'But bi', 'hop', 'Thai Lan', 100000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('TV01', 'Tap 100 giay mong', 'quyen', 'Trung Quoc', 2500);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('TV02', 'Tap 200 giay mong', 'quyen', 'Trung Quoc', 4500);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('TV03', 'Tap 100 giay tot', 'quyen', 'Viet Nam', 3000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('TV04', 'Tap 200 giay tot', 'quyen', 'Viet Nam', 5500);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('TV05', 'Tap 100 trang', 'chuc', 'Viet Nam', 23000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('TV06', 'Tap 200 trang', 'chuc', 'Viet Nam', 53000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('TV07', 'Tap 100 trang', 'chuc', 'Trung Quoc', 34000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST01', 'So tay 500 trang', 'quyen', 'Trung Quoc', 40000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST02', 'So tay loai 1', 'quyen', 'Viet Nam', 55000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST03', 'So tay loai 2', 'quyen', 'Viet Nam', 51000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST04', 'So tay', 'quyen', 'Thai Lan', 55000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST05', 'So tay mong', 'quyen', 'Thai Lan', 20000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST06', 'Phan viet bang', 'hop', 'Viet Nam', 5000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST07', 'Phan khong bui', 'hop', 'Viet Nam', 5000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST08', 'Bong bang', 'cai', 'Viet Nam', 1000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST09', 'But long', 'cay', 'Viet Nam', 5000);
INSERT INTO SANPHAM (MASP, TENSP, DVT, NUOCSX, GIA) VALUES ('ST10', 'But long', 'cay', 'Trung Quoc', 7000);
select * from nhanvien;
commit;
--HOA DON--
--SET DATEFORMAT DMY
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1001, '23/07/2006', 'KH01', 'NV01', 320000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1002, '12/08/2006', 'KH01', 'NV02', 840000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1003, '23/08/2006', 'KH02', 'NV01', 100000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1004, '01/09/2006', 'KH02', 'NV01', 180000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1005, '20/10/2006', 'KH01', 'NV02', 3800000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1006, '16/10/2006', 'KH01', 'NV03', 2430000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1007, '28/10/2006', 'KH03', 'NV03', 510000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1008, '28/10/2006', 'KH01', 'NV03', 440000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1009, '28/10/2006', 'KH03', 'NV04', 320000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1010, '01/11/2006', 'KH01', 'NV01', 5200000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1011, '04/11/2006', 'KH04', 'NV03', 250000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1012, '30/11/2006', 'KH05', 'NV03', 21000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1013, '12/12/2006', 'KH06', 'NV01', 5000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1014, '31/12/2006', 'KH03', 'NV02', 3150000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1015, '01/01/2007', 'KH06', 'NV01', 910000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1016, '01/01/2007', 'KH07', 'NV02', 12500);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1017, '02/01/2007', 'KH08', 'NV03', 35000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1018, '13/01/2007', 'KH08', 'NV03', 330000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1019, '13/01/2007', 'KH01', 'NV03', 30000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1020, '14/01/2007', 'KH09', 'NV04', 70000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1021, '16/01/2007', 'KH10', 'NV04', 67500);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1022, '16/01/2007', Null, 'NV03', 7000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1023, '17/01/2007', Null, 'NV01', 330000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1024, '17/01/2007', Null, 'NV01', 330000);
INSERT INTO HOADON (SOHD, NGHD, MAKH, MANV, TRIGIA) VALUES (1026, '17/01/2007', Null, 'NV01', 330000);
--delete from HOADON;
--CTHD--
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1001, 'TV02', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1001, 'ST01', 5);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1001, 'BC01', 5);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1001, 'BC02', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1001, 'ST08', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1002, 'BC04', 20);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1002, 'BB01', 20);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1002, 'BB02', 20);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1003, 'BB03', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1004, 'TV01', 20);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1004, 'TV02', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1004, 'TV03', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1004, 'TV04', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1005, 'TV05', 50);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1005, 'TV06', 50);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1006, 'TV07', 20);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1006, 'ST01', 30);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1006, 'ST02', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1007, 'ST03', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1008, 'ST04', 8);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1009, 'ST05', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1010, 'TV07', 50);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1010, 'ST07', 50);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1010, 'ST08', 100);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1010, 'ST04', 50);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1010, 'TV03', 100);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1011, 'ST06', 50);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1012, 'ST07', 3);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1013, 'ST08', 5);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1014, 'BC02', 80);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1014, 'BB02', 100);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1014, 'BC04', 60);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1014, 'BB01', 50);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1015, 'BB02', 30);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1015, 'BB03', 7);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1016, 'TV01', 5);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1017, 'TV02', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1017, 'TV03', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1017, 'TV04', 5);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1018, 'ST04', 6);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1019, 'ST05', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1019, 'ST06', 2);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1020, 'ST07', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1021, 'ST08', 5);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1021, 'TV01', 7);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1021, 'TV02', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1022, 'TV02', 10);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1023, 'ST04', 6);





-----------------------TimSoHD------------------
set serveroutput on;
create or replace function TimSoHD
return int
is
    cursor cur is select sohd from hoadon ORDER BY sohd asc ;
    so_hd hoadon.sohd%type;
    c_sohd hoadon.sohd%type;
begin
    open cur;
    so_hd:=1001;
    loop
        fetch cur into c_sohd;
        dbms_output.put_line(so_hd||' '||c_sohd);
        exit when so_hd!=c_sohd or cur%notfound; 
        so_hd:=so_hd+1;
    end loop;
    close cur;
    return so_hd;
end;

select * from hoadon;
declare
n int;
begin
    n:= TimSoHD();
    dbms_output.put_line('so hd'||n);
end;
select * from hoadon;
--------------Check xem ma da có ch?a--------------
create or replace function Check_Sohd(so_hd int)
return int
is
     cursor cur is select sohd from hoadon;
     check1 int;
     c_sohd hoadon.sohd%type;
begin
    check1:=0;
    open cur;
    --so_hd:=1001;
    loop
        fetch cur into c_sohd;
        --dbms_output.put_line(so_hd||' '||c_sohd);
        exit when cur%notfound; 
        if(so_hd = c_sohd) 
        then check1:=1;
        end if;
    end loop;
    close cur;
    return check1;
end;


commit;


declare 
n int;
begin
    n:=Check_Sohd(1026);
    if(n=1)then dbms_output.put_line('Co so hoa don') ;
    else dbms_output.put_line('Khong co so hoa don');
    end if;
end;



------------------Tang tu dong tong gia hoa don----------------
/*set serveroutput on;
create or replace trigger update_tonghoadon 
after insert on CTHD
for each row 
declare 
gia1 sanpham.gia%type;
tonggiatri hoadon.trigia%type;
begin
    select s.gia into gia1
    from sanpham s
    where s.masp=:new.masp;
    dbms_output.put_line('gia san pham: '||gia1);
    select trigia into tonggiatri
    from hoadon
    where hoadon.sohd=:new.sohd;
    dbms_output.put_line('gia tri cu: '||tonggiatri);
    Update hoadon 
    set hoadon.trigia =tonggiatri+gia1*:new.sl
    where hoadon.sohd=:new.sohd;
    dbms_output.put_line('Cap nhat tri gia thanh cong');
end;*/

/*
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1006, 'BC02', 2);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1006, 'ST10', 2);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1006, 'ST04', 1);
INSERT INTO CTHD (SOHD, MASP, SL) VALUES (1006, 'ST05', 1);
commit;*/





------------------So dien thoai phai 10 so va bat dau bang so 0 ----------------
/*set serveroutput on;
create or replace function Check_SDT(sdt in varchar2) return number is
 v_num number;
begin
 begin
   select to_number(sdt) into v_num from dual;
   --v_num:=to_number(sdt);
 exception
   when invalid_number then
   return null;
 end;
 return v_num;
end;
 commit;
 

declare
n varchar2(255);
k int;
begin
    n:='123r';
    k:=Check_SDT(n);
    if(k>0)then dbms_output.put_line('gia tri '||k);
    else  dbms_output.put_line('break');
    end if;
end;



INSERT INTO KHACHHANG  VALUES ('KH16', 'Nguyen Van A', '731, Tran Hung Dao, Q5, TPHCM', '08823dt51', '22/10/1960', 13060000, '22/07/2006');
DELETE FROM khachhang where makh='KH14';
INSERT INTO KHACHHANG  VALUES ('KH14', 'Nguyen Van A', '731, Tran Hung Dao, Q5, TPHCM', '08888888', '22/10/1960', 13060000, '22/07/2006');
select * from khachhang;

*/

/*===================TRIGGER============================*/

/*==============Xoa_Hoa_Don=================*/
create or replace procedure xoa_hoa_don (v_makh hoadon.makh%type)
is
    cursor hd_cur is select sohd from hoadon where makh=v_makh;
    v_sohd hoadon.sohd%type;
begin
    open hd_cur;
    loop
         fetch hd_cur into v_sohd;
         exit when hd_cur%notfound;
         if(v_sohd is not null) then
            delete cthd where sohd = v_sohd;
        end if;
    end loop;
    close hd_cur;
    
    delete hoadon
    where makh=v_makh;
    exception
        when no_data_found then
              delete hoadon
              where makh=v_makh;
end;


/*===================TRIGGER=======================*/

/*=================== CHECK_NGDK_NGHD =====================*/
create or replace TRIGGER CHECK_NGDK_NGHD BEFORE INSERT OR UPDATE OF NGHD  ON HOADON
FOR EACH ROW
DECLARE
V_NGDK KHACHHANG.NGDK%TYPE;
BEGIN
        SELECT NGDK  INTO V_NGDK
        FROM KHACHHANG
        WHERE MAKH = :NEW.MAKH;

        IF V_NGDK > :NEW.NGHD THEN
         RAISE_APPLICATION_ERROR(-20000,'Ngay hoa don khong hop le, vui long nhap lai') ;
        ELSE
        DBMS_OUTPUT.PUT_LINE('Da them thanh cong');
        END IF; 
END;

/*===================  CHECK_NGSINH_NGAYDK =====================*/
create or replace TRIGGER CHECK_NGSINH_NGAYDK BEFORE  INSERT OR UPDATE OF NGDK, NGSINH
ON KHACHHANG
FOR EACH ROW
BEGIN
     IF :NEW.NGDK < :NEW.NGSINH  THEN 
       RAISE_APPLICATION_ERROR(-20000,'Ngay dang khi khong hop le, vui long nhap lai') ;
    ELSE
   DBMS_OUTPUT.PUT_LINE('Da them thanh cong');
    END IF; 
END;

/*=================== check_sdt_insert_or_update_kh =====================*/
create or replace trigger check_sdt_insert_or_update_kh before insert or update of sodt on khachhang
for each row

begin
        if (length(:new.sodt) = 10 and (REGEXP_LIKE(:new.sodt, '^[[:digit:]]+$')  = true )) then
                dbms_output.put_line('them thanh cong');
        else 
                RAISE_APPLICATION_ERROR(-20000,'so dien thoai khong hop le, vui long nhap lai') ;
        end if;    
end;

/*=================== check_sdt_insert_or_update_NV =====================*/

create or replace trigger check_sdt_insert_or_update_nv before insert or update of sodt on nhanvien
for each row

begin
        if (length(:new.sodt) = 10 and (REGEXP_LIKE(:new.sodt, '^[[:digit:]]+$')  = true )) then
                dbms_output.put_line('them thanh cong');
        else 
                RAISE_APPLICATION_ERROR(-20000,'so dien thoai khong hop le, vui long nhap lai') ;
        end if;    
end;
/*=================== DOANHSO =====================*/
/*=================== CHECK_DOANHSO =====================*/

CREATE OR REPLACE TRIGGER CHECK_DOANHSO BEFORE INSERT  ON HOADON
FOR EACH ROW
BEGIN

    UPDATE KHACHHANG
    SET DOANHSO = DOANHSO + :NEW.TRIGIA
    WHERE MAKH = :NEW.MAKH;
    DBMS_OUTPUT.PUT_LINE('Da them thanh cong');
END;

/*============== KIEMTRA_DOANHSO_UP ================*/
CREATE OR REPLACE TRIGGER CHECK_DOANHSO_up BEFORE update of trigia  ON HOADON
FOR EACH ROW
declare 
total number;
BEGIN
    UPDATE KHACHHANG
    SET DOANHSO = doanhso - :old.trigia +:new.trigia
    WHERE MAKH = :NEW.MAKH;
    DBMS_OUTPUT.PUT_LINE('Da them thanh cong');
    
END

/*============== KIEMTRA_DOANHSO_DELE ================*/
CREATE OR REPLACE TRIGGER CHECK_DOANHSO_DELE BEFORE DELETE ON HOADON
FOR EACH ROW
BEGIN

    UPDATE KHACHHANG
    SET DOANHSO = DOANHSO - :OLD.TRIGIA
    WHERE MAKH = :OLD.MAKH;
    DBMS_OUTPUT.PUT_LINE('Da xoa thanh cong');
    
END;

--------------------------------------------------------------------------------


/*============== update_trigia ================*/
create or replace trigger update_trigia before insert  on cthd
for each row
declare
v_gia sanpham.gia%type;
begin
        select gia into v_gia
        from sanpham
        where masp = :new.masp;
        
        update hoadon
        set trigia = trigia + :new.sl*v_gia
        where sohd = :new.sohd;
        
        dbms_output.put_line('Da them thanh cong');
end;


/*============== update_trigia_up ================*/
create or replace trigger update_trigia_up before update of sl  on cthd
for each row
declare
v_gia sanpham.gia%type;
begin
        select gia into v_gia
        from sanpham
        where masp = :new.masp;
        
        update hoadon
        set trigia = trigia - :old.sl*v_gia + :new.sl*v_gia
        where sohd = :new.sohd;
        
        dbms_output.put_line('Da them thanh cong');
end;
/*============== update_trigia_dele ================*/

create or replace trigger update_trigia_DELE before DELETE on cthd
for each row
declare
v_gia sanpham.gia%type;
begin
        select gia into v_gia
        from sanpham
        where masp = :OLD.masp;
        
        update hoadon
        set trigia = trigia - :OLD.sl*v_gia
        where sohd = :OLD.sohd;
        
        dbms_output.put_line('Da xoa thanh cong');
end;
