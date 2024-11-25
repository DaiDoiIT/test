create DATABASE DoanhNghiep;
CREATE TABLE NhanVien(
    ten VARCHAR(255) PRIMARY KEY NOT NULL,
    Ma VARCHAR(100) not null,
    SDT int NOT NULL
);

insert into NhanVien VALUES
('Nguyen Ba Quang', 'NV01', 0901564812);

select * from NhanVien