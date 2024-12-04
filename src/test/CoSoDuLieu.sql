create DATABASE DoanhNghiep;
CREATE TABLE NhanVien(
    ten VARCHAR(255) PRIMARY KEY NOT NULL,
    Ma VARCHAR(100) not null,
    SDT int NOT NULL
);

create table KhachHang(
    ten VARCHAR(255) NOT NULL,
    Ma VARCHAR(100) not null,
    SDT int NOT NULL,
    SoTinDung nchar(10) NOT NULL

);

INSERT INTO NhanVien VALUES
('Viet Anh', 'NV01', 0901923045),
('An', 'NV02', 0905784923),
('Binh','NV03',0192384726),
('Thanh','NV04',0912382326)

INSERT INTO KhachHang VALUES
('Nguyen Cao Quang', 'KH01', 0923102985, 'S19283'),
('Cao Nghia Hai', 'KH02', 0827394810, 'S019232'),
("Hang Say O", 'KH03', 09182384622, 'S91823');

select * from NhanVien
select * from NhanVien where ten = 'Viet Anh';
select * from NhanVien LIMIT 5;
select ten from KhachHang LIMIT 10;
select Ma from NhanVien where ten = 'Viet Anh';

-- Token COMMENT
select ten, KhachHang.ten from NhanVien AS NV
GROUP BY KhachHang on KhachHang.ten = NV.ten;

select * from KhachHang where MA = 'KH02';
-- Thiết lập bảo mật
SELECT session_id, encrypt_option 
FROM sys.dm_exec_connections;

SELECT * FROM NhanVien ASC;

-- Cài đặt extension
CREATE EXTENSION http_fdw;

-- Tạo server cho HTTP API
CREATE SERVER http_server
FOREIGN DATA WRAPPER http_fdw
OPTIONS (uri 'https://api.example.com');

-- Tạo bảng ánh xạ dữ liệu
CREATE FOREIGN TABLE api_data (
    id INTEGER,
    name TEXT
) SERVER http_server OPTIONS (format 'json');

UPDATE NhanVien
SET ten = 'Nguyen Binh Khang' WHERE Ma = 'NV01'







