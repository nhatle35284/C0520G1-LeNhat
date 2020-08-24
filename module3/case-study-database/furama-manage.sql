drop database if exists furama_quan_ly;
create database furama_quan_ly;
use furama_quan_ly;

-- task 1:Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.
create table vi_tri(
	id_vi_tri int primary key,
	ten_vi_tri varchar(45)
    check(ten_vi_tri="Lễ Tân" 
    or ten_vi_tri="Phục Vụ"
    or ten_vi_tri="Chuyên Viên"
    or ten_vi_tri="Giám Sát"
    or ten_vi_tri="Quản Lý"
    or ten_vi_tri="Giám Đốc"
	)
);
create table trinh_do(
	id_trinh_do int primary key,
	ten_trinh_do varchar(45)
    check(ten_trinh_do="Trung Cấp" 
    or ten_trinh_do="Cao Đẳng"
    or ten_trinh_do="Đai Học"
    or ten_trinh_do="sau Đai Học"
	)
);
create table bo_phan(
	id_bo_phan int primary key,
	ten_bo_phan varchar(45)
    check(ten_bo_phan="Sale_Marketing" 
    or ten_bo_phan="Hành Chính"
    or ten_bo_phan="Phục Vụ"
    or ten_bo_phan="Quản Lý"
	)
);
create table nhan_vien( 
	id_nhan_vien int primary key,
	ho_ten varchar(50),
	id_vi_tri int,
	id_trinh_do int,
	id_bo_phan int,
	ngay_sinh date,
	so_cmtnd varchar(45),
	luong double,
	sdt varchar(45),
	email varchar(45),
	dia_chi varchar(45),
    foreign key (id_vi_tri) references vi_tri(id_vi_tri),
    foreign key (id_trinh_do) references trinh_do(id_trinh_do),
    foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);
create table loai_khach(
	id_loai_khach int primary key,
	ten_loai_khach varchar(45)
);
create table khach_hang(
	id_khach_hang int primary key,
	id_loai_khach int,
	ho_ten varchar(50),
    ngay_sinh date,
	so_cmtnd varchar(45),
	sdt varchar(45),
	email varchar(45),
	dia_chi varchar(45),
    foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);
create table kieu_thue(
	id_kieu_thue int primary key ,
	ten_kieu_thue varchar(45),
	gia double
);
create table loai_dich_vu(
	id_loai_dich_vu int primary key,
    ten_loai_dich_vu varchar(45)
);
create table dich_vu( 
	id_dich_vu int primary key,
	ten_dich_vu varchar(45),
    dien_tich double,
    so_nguoi_toi_da int,
    chi_phi_thue double,
    id_kieu_thue int,
    id_loai_dich_vu int,
    trang_thai varchar(45),
    foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue),
    foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu)
);
create table hop_dong( 
	id_hop_dong int primary key,
	id_nhan_vien int,
	id_khach_hang int,
	id_dich_vu int,
	ngay_lam_hop_dong date,
	ngay_ket_thuc_hop_dong date,
	tien_dat_coc double,
	tong_tien double,
    foreign key (id_khach_hang) references khach_hang(id_khach_hang),
    foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);
create table dich_vu_di_kem(
	id_dich_vu_di_kem int primary key,
    ten_dich_vu_di_kem varchar(45),
    gia double,
    don_vi varchar(45),
    trang_thai_kha_dung varchar(45)
);
create table hop_dong_chi_tiet(
	id_hop_dong_chi_tiet int primary key,
	id_hop_dong int,
	id_dich_vu_di_kem int,
	so_luong int,
    foreign key(id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem),
    foreign key(id_hop_dong) references hop_dong(id_hop_dong)
);
-- task 1.Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thõa mãn các yêu cầu bên dưới.

-- thêm vị trí
insert into vi_tri 
values (1,"Lễ Tân"),
(2,"Phục Vụ"),
(3,"Chuyên Viên"),
(4,"Giám Sát"),
(5,"Quản Lý"),
(6,"Giám Đốc");

-- thêm trình độ
insert into trinh_do 
values (1,"Trung Cấp"),
(2,"Cao Đẳng"),
(3,"Đại Học"),
(4,"Sau Đại Học");

-- thêm bộ phận
insert into bo_phan 
values (1,"Sale_Marketing"),
(2,"Hành Chính"),
(3,"Phục Vụ"),
(4,"Quản Lý");
    
-- thêm nhân viên
insert into nhan_vien 
values (1,"Hoa",1,1,1,'1997/12/12',"14124134",5500000,"091234556","hoa1997@gmail.com","Da Nang"),
(2,"Khanh",1,1,1,'1997/12/12',"14124134",5500000,"091234556","hoa1997@gmail.com","Da Nang"),
(3,"Tùng",1,1,1,'1997/12/12',"14124134",5500000,"091234556","hoa1997@gmail.com","Da Nang"),
(4,"Thu",1,1,1,'1997/12/12',"14124134",5500000,"091234556","hoa1997@gmail.com","Da Nang"),
(5,"Hoang",1,1,1,'1997/12/12',"14124134",5500000,"091234556","hoa1997@gmail.com","Da Nang");

-- thêm loại khách 
insert into loai_khach 
values (1,"Diamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

-- thêm Khách hàng
insert into khach_hang 
values (1,1,"Hoang Thi A",'1999/12/07',"312314124","0123452432","athihoang11@gmail.com","Quảng Nam"),
(2,3,"Tu Hong B",'2003/12/13',"312314124","0123452432","btuhong11@gmail.com","Quảng Trị"),
(3,1,"Khanh Thi C",'1980/12/07',"312314124","0123452432","cthihoang11@gmail.com","Đà Nẵng"),
(4,4,"Nguyen Thi D",'1999/12/07',"312314124","0123452432","dthihoang11@gmail.com","Quảng Trị");

-- thêm kiểu thuê

insert into kieu_thue 
values (1,"Đêm",100),
(2,"Ngày",300),
(3,"Tháng",2000);

-- thêm loại dịch vụ 
insert into loai_dich_vu 
values (1,"Villa"),
(2,"House"),
(3,"Room");

-- thêm dịch vụ 
insert into dich_vu
values (1,"Villa1",70,4,2000,1,1,"Tốt"),
(2,"Villa1",65,4,2000,2,1,"Tốt"),
(3,"Villa1",80,4,2000,1,2,"Tốt");

-- thêm hợp đồng
insert into hop_dong
values (1,1,1,1,'2020/12/04','2020/07/05',100,2000),
(2,1,3,1,'2020/12/04','2020/07/05',100,2000),
(3,1,2,3,'2020/12/04','2020/07/05',100,2000),
(4,1,2,2,'2020/12/04','2020/07/05',100,2000);

-- thêm loại dịch vụ di kèm
insert into dich_vu_di_kem
values (1,"massage","50","USD","Tốt"),
(2,"karaoke","45","USD","Tốt"),
(3,"thức ăn","10","USD","Tốt"),
(4,"nước uống","5","USD","Tốt"),
(5,"xe di chuyển tham quan quanh resort","30","USD","Tốt");

-- thêm hợp đồng chi tiết
insert into hop_dong_chi_tiet
values (1,1,1,2),
(2,3,3,2),
(3,4,2,2),
(4,2,1,2);

/* task 2 .Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”,
 “T” hoặc “K” và có tối đa 15 ký tự.*/
select*from nhan_vien where ho_ten like "H%" or ho_ten like "T%"or ho_ten like "K%" and length(ho_ten)<15;

/* task 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng”
 hoặc “Quảng Trị”.*/
select*
 from khach_hang 
 where datediff(curdate(),ngay_sinh)/365 
 between 18 and 50 
 and dia_chi in("Đà Nẵng","Quảng Trị");
 
select *
from khach_hang
where dia_chi in("Đà Nẵng" , "Quảng Trị")
having year(now()) - year(ngay_sinh) between 18 and 50;

/*task 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần.
 Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng.
 Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
 
select khach_hang.ho_ten , count(hop_dong.id_hop_dong) as 'tổng lần đặt phòng'
from  khach_hang
right join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
where khach_hang.id_loai_khach = 1
group by khach_hang.id_khach_hang;

/* task 5.Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, 
TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là
 từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt 
 phòng cũng phải hiển thị ra).*/
 
select khach_hang.id_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,
	hop_dong.id_hop_dong,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc_hop_dong,
    dich_vu.chi_phi_thue+(dich_vu_di_kem.don_vi*dich_vu_di_kem.gia) as "Tổng Tiền"
from khach_hang
left join hop_dong on khach_hang.id_khach_hang=hop_dong.id_khach_hang
left join loai_khach on loai_khach.id_loai_khach=khach_hang.id_loai_khach
left join dich_vu on dich_vu.id_dich_vu=hop_dong.id_dich_vu
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong=hop_dong.id_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem=hop_dong_chi_tiet.id_dich_vu_di_kem;

/*6.Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa 
từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).*/

select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.chi_phi_thue,
loai_dich_vu.ten_loai_dich_vu
from dich_vu 
left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu=dich_vu.id_loai_dich_vu
left join hop_dong on hop_dong.id_dich_vu=dich_vu.id_dich_vu
where ((datediff(hop_dong.ngay_lam_hop_dong,'2019/01/01')>0)) or ((datediff(hop_dong.ngay_lam_hop_dong,'2019/31/03')<0));

/*task 7.Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của
 tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng
 đặt phòng  trong năm 2019.*/
 
 select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue,
loai_dich_vu.ten_loai_dich_vu
from dich_vu 
left join loai_dich_vu on loai_dich_vu.id_loai_dich_vu=dich_vu.id_loai_dich_vu
left join hop_dong on hop_dong.id_dich_vu=dich_vu.id_dich_vu
where (hop_dong.ngay_lam_hop_dong between '2018/01/01' and '2018/31/12/2018') 
and (hop_dong.ngay_lam_hop_dong between '2019/01/01/2019' and '2019/31/12');

/* task 8.Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên*/

-- cáchh 1:
select distinct khach_hang.ho_ten 
from khach_hang;

-- cách 2:
select khach_hang.ho_ten 
from khach_hang
union
select khach_hang.ho_ten 
from khach_hang;

-- cách 3: 
select khach_hang.ho_ten 
from khach_hang
group by khach_hang.ho_ten
having count(ho_ten)>=1;

/* task 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì
 sẽ có bao nhiêu khách hàng thực hiện đặt phòng.*/

select substr(hop_dong.ngay_lam_hop_dong,6,2) as thang_2019 ,count(hop_dong.id_khach_hang) as so_lan_dat 
from hop_dong
where hop_dong.ngay_lam_hop_dong like '2019%'
group by substr(hop_dong.ngay_lam_hop_dong,6,2);

/*task 10. Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả 
 hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
 (được tính dựa trên việc count các IDHopDongChiTiet)*/
 select hop_dong.id_hop_dong,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc_hop_dong,
 hop_dong.tien_dat_coc,hop_dong_chi_tiet.so_luong
 from hop_dong
 left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong;
 
 /*task 11.11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng
 bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là
 “Vinh” hoặc “Quảng Ngãi”.*/
select id_dich_vu_di_kem,ten_dich_vu_di_kem ,gia,don_vi,trang_thai_kha_dung 
from dich_vu_di_kem 
left join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem=dich_vu_di_kem.id_dich_vu_di_kem