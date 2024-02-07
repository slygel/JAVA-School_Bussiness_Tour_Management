# Ứng dụng quản lý các chuyến tham quan của sinh viên và giáo viên
## 1. Phân tích hệ thống

### 1.1. Các giao diện chính
⮚  Chức năng chung : 
Ứng dụng cho phép sinh viên và giáo viên tham gia đăng ký tham gia chuyến du lịch sắp diễn ra. 
Đồng thời Admin của ứng dụng có vai trò quản lý, cập nhật thông tin các tài khoản, dữ liệu có thể được thống kê và xuất file PDF, EXCEL.

⮚	Hệ thống gồm 16 giao diện chính:

○	Giao diện Đăng nhập

○	Giao diện Trang chủ (admin và user)

○	Giao diện Quản lý giáo viên

○	Giao diện xem danh sách chuyến tham quan của giáo viên

○	Giao diện Quản lý sinh viên

○	Giao diện Chuyến tham quan sinh viên tham gia

○	Giao diện Quản lý các chuyến tham quan doanh nghiệp

○	Giao diện danh sách sinh viên tham gia chuyến tham quan

○	Giao diện Quản lý doanh nghiệp liên kết

○	Giao diện các chuyến tham quan tới doanh nghiệp liên kết

○	Giao diện Quản lý lớp học

○	Giao diện danh sách sinh viên của lớp học

○	Giao diện tài khoản cá nhân

○	Quản lý tài khoản

○	Giao diện đánh giá sinh viên sau mỗi chuyến tham quan

### 1.2. Biểu đồ Usecase
<img src= "images-function/usecase.jpg" Height="500" width = "700"/>

### 1.3. Sơ đồ quan hệ giữa các bảng 
<img src= "images-function/diagram.jpg" Height="500" width = "700"/>

## 2. Giao diện hệ thống
### 2.1. Giao diện đăng nhập
<img src= "images-function/login.jpg" Height="500" width = "700"/>

*Giao diện đăng nhập của admin và user*

### 2.2. Giao diện admin
<img src= "images-function/adminHome.jpg" Height="500" width = "700"/>

### 2.3. Giao diện quản lý lớp học
<img src= "images-function/classroom.jpg" Height="500" width = "700"/>

#### 2.3.1. Giao diện danh sách sinh viên của lớp học
<img src= "images-function/studentClassroom.jpg" Height="500" width = "700"/>

### 2.4. Giao diện quản lý tài khoản hệ thống
<img src= "images-function/adminHome.jpg" Height="500" width = "700"/>

### 2.5. Giao diện quản lý các chuyến tham quan doanh nghiệp
<img src= "images-function/tour.jpg" Height="500" width = "700"/>

#### 2.5.1. Giao diện quản lý sinh viên trong các chuyến tham quan
<img src= "images-function/studentTour.jpg" Height="500" width = "700"/>

#### 2.5.2. Giao diện quản lý sinh viên trong các chuyến tham quan
<img src= "images-function/addStudentTour.jpg" Height="500" width = "700"/>

#### 2.5.3. Giao diện đánh giá sinh viên sau chuyến đi
<img src= "images-function/rateStudentTour.jpg" Height="500" width = "700"/>

### 2.6. Giao diện quản lý sinh viên
<img src= "images-function/student.jpg" Height="500" width = "700"/>

#### 2.6.1. Danh sách các chuyến tham quan sinh viên tham gia
<img src= "images-function/tourOfStudent.jpg" Height="500" width = "700"/>

### 2.7. Giao diện quản lý giáo viên
<img src= "images-function/teacher.jpg" Height="500" width = "700"/>

#### 2.7.1. Danh sách các chuyến tham quan giáo viên tham gia
<img src= "images-function/tourOfTeacher.jpg" Height="500" width = "700"/>

### 2.8. Giao diện quản lý các doanh nghiệp
<img src= "images-function/company.jpg" Height="500" width = "700"/>

#### 2.8.1. Các chuyến tham quan do doanh nghiệp tổ chức
<img src= "images-function/tourOfCompany.jpg" Height="500" width = "700"/>

### 2.9. Giao diện trang chủ của sinh viên
<img src= "images-function/studentHome.jpg" Height="500" width = "700"/>

#### 2.9.1. Các chuyến tham quan sinh viên đã đăng kí
<img src= "images-function/registedTourStudent.jpg" Height="500" width = "700"/>

#### 2.9.2. Tài khoản cá nhân của sinh viên
<img src= "images-function/studentProfile.jpg" Height="500" width = "700"/>

#### 2.9.3. Các chuyến tham quan diễn ra trong ngày của sinh viên
<img src= "images-function/tourToday.jpg" Height="500" width = "700"/>

#### 2.9.4. Các chuyến tham quan sắp diễn ra
<img src= "images-function/studentHome.jpg" Height="500" width = "700"/>

### 2.10. Giao diện trang chủ của giáo viên
<img src= "images-function/teacherHome.jpg" Height="500" width = "700"/>

#### 2.10.1. Các chuyến tham quan giáo viên đã đăng kí
<img src= "images-function/registedTeacherTour.jpg" Height="500" width = "700"/>

#### 2.10.2. Tài khoản cá nhân của giáo viên
<img src= "images-function/teacherProfile.jpg" Height="500" width = "700"/>

#### 2.10.3. Các chuyến tham quan sắp diễn ra
<img src= "images-function/teacherHome.jpg" Height="500" width = "700"/>

#### 2.10.4. Xem danh sách sinh viên của chuyến tham quan
<img src= "images-function/listStudentOfTour.jpg" Height="500" width = "700"/>

## 3. Nội dung học tập và các kỹ năng, kiến thức then chốt 
❖	Nội dung học tập:

- Cấu trúc của một chương trình Java

- Các kiểu dữ liệu và chuyển kiểu dữ liệu

- Các toán tử

- Các cấu trúc điều khiển

- Lớp và đối tượng trong Java

- Các hàm khởi tạo

- Phương thức tĩnh static

- Kế thừa, kết tập

- Tính trừu tượng, đa hình và interface

-	Ghi đè phương thức
  
-	Xử lý ngoại lệ
  
-	I/O theo luồng và thao tác với tệp
  
-	Collection
  
-	Giao diện Java Swing
  
❖	Kiến thức đã trang bị:

-	Lập trình Java cơ sở
  
-	Lập trình Java hướng đối tượng
  
-	Xử lý ngoại lệ và thao tác với tệp
  
-	Lập trình với cấu trúc Collection
  
-	Lập trình giao diện Java Swing
  
❖	Kỹ năng then chốt:

-	Kỹ năng làm việc nhóm
  
-	Kỹ năng phân tích và xử lý tình huống
  
-	Kỹ năng thu thập và chuẩn hóa thông tin
  
-	Kỹ năng xây dựng ý tưởng đề tài









