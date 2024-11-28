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
('Viet Anh', 'NV01', 0901923045);

select * from NhanVien

select * from NhanVien where ten = 'Viet Anh';
