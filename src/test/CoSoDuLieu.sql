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
('Binh','NV03',0192384726);
('Thanh','NV04',0912382326);
INSERT INTO KhachHang VALUES
('Nguyen Cao Quang', 'KH01', 0923102985, 'S19283');
('Cao Nghia Hai', 'KH02', 0827394810, 'S019232');

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

-- Tạo server audit
CREATE SERVER AUDIT AuditLog
TO FILE (FILEPATH = 'C:\AuditLogs\', MAXSIZE = 10 MB, MAX_ROLLOVER_FILES = 10);

-- Bật audit
ALTER SERVER AUDIT AuditLog WITH (STATE = ON);

-- Tạo audit specification cho các hành động cụ thể
CREATE SERVER AUDIT SPECIFICATION AuditSpec
FOR SERVER AUDIT AuditLog
ADD (FAILED_LOGIN_GROUP),
ADD (SUCCESSFUL_LOGIN_GROUP);

-- Bật audit specification
ALTER SERVER AUDIT SPECIFICATION AuditSpec WITH (STATE = ON);

-- Kiểm tra các truy vấn đang chạy
SELECT session_id, status, command, blocking_session_id, wait_time, wait_type, last_wait_type, cpu_time, memory_usage
FROM sys.dm_exec_requests;

-- Kiểm tra lịch sử truy vấn
SELECT TOP 10
    qs.sql_handle,
    qs.execution_count,
    qs.total_worker_time AS CPUTime,
    qs.total_elapsed_time AS ElapsedTime,
    SUBSTRING(st.text, (qs.statement_start_offset / 2) + 1,
    ((CASE qs.statement_end_offset
          WHEN -1 THEN DATALENGTH(st.text)
          ELSE qs.statement_end_offset
      END - qs.statement_start_offset) / 2) + 1) AS QueryText
FROM sys.dm_exec_query_stats qs
CROSS APPLY sys.dm_exec_sql_text(qs.sql_handle) st
ORDER BY qs.total_worker_time DESC;

select ten, Ma from NhanVien;





