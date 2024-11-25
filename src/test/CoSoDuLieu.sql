create DATABASE DoanhNghiep;
CREATE TABLE NhanVien(
    ten VARCHAR(255) PRIMARY KEY NOT NULL,
    Ma VARCHAR(100) not null,
    SDT int NOT NULL
);

insert into NhanVien VALUES
('Nguyen Ba Quang', 'NV01', 0901564812),
('Cao Ba Quat', 'NV02', 0981374123),
('Nguyen Minh Quang', 'NV03', 0971263456);

select * from NhanVien

select ten from NhanVien where Ma = 'NV01';