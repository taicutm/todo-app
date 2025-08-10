# Todo App

## 1. Chức năng chính 🥰

---

- ✅ Thêm việc cần làm
- 📝 Sửa việc
- 🗑️ Xóa việc
- ☑️ Đánh dấu hoàn thành
- 📅  Gắn ngày hoặc deadline

## 2. Công nghệ

- **Frontend**: Next.js (TypeScript, MUI – Material UI)
- **Backend**: Spring Boot, MyBatis
- **Database**: PostgreSQL
- **ORM**: Prisma

## 3. Thiết kế Cơ Sở Dữ Liệu

### **3.1. Entities Và Thuộc Tính**

### 3.1.1. Account (Người Dùng)

- Id (PK)
- Username (Unique)
- Email (Unique)
- Password_Hash
- Created_At
- Updated_At

---

### 3.1.2. Task (Công Việc)

- **Id** (PK)
- **Title**
- **Description**
- **Is_Completed**
- **Due_Date**
- **Account_Id** (FK) — Liên Kết Tới `Account.Id`
- **Task_Category_Id** (FK) — (Nếu Có)

---

### 3.1.3. Task_Category (Loại Công Việc)

- **Id** (PK)
- **Name**
- **Description**

---

### 3.1.4. Task_Tag (Thẻ)

- **Id** (PK)
- **Name**

---

### 3.1.5. Task_Tag_Map (Bảng Liên Kết N-N Giữa Task Và Tag)

- **Task_Id** (FK) — Tới `Task.Id`
- **Tag_Id** (FK) — Tới `Task_Tag.Id`
- **Khóa Chính**: (`Task_Id`, `Tag_Id`)

---

### 3.1.6. Task_Comment (Bình Luận)

- **Id** (PK)
- **Task_Id** (FK) — Tới `Task.Id`
- **Account_Id** (FK) — Tới `Account.Id`
- **Comment**
- **Created_At**

### **3.2 Mối Quan Hệ**

| Quan Hệ | 	Mô Tả | 	Loại Quan Hệ |
| --- | --- | --- |
| Account - Task | Một Người Dùng Có Thể Tạo Nhiều Task | 1-N (1 Account - Nhiều Task) |
| Task - Task_Category | Một Task Thuộc Một Loại Category (Nếu Có `Category_Id`) | N-1 (Nhiều Task - 1 Category) |
| Task - Task_Tag | Một Task Có Thể Có Nhiều Tag, Một Tag Thuộc Nhiều Task | N-N Qua `Task_Tag_Map` |
| Task - Task_Comment | Một Task Có Nhiều Bình Luận | 1-N (1 Task - Nhiều Comment) |
| Account - Task_Comment | Một Người Dùng Có Thể Viết Nhiều Bình Luận | 1-N (1 Account - Nhiều Comment) |

### **3.3. Sơ đồ Class Diagram**

![todoapp.drawio (6).png](https://private-user-images.githubusercontent.com/69153374/476287422-495a63b4-60c1-47f3-8091-2b6207649782.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NTQ4MzM4NDMsIm5iZiI6MTc1NDgzMzU0MywicGF0aCI6Ii82OTE1MzM3NC80NzYyODc0MjItNDk1YTYzYjQtNjBjMS00N2YzLTgwOTEtMmI2MjA3NjQ5NzgyLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTA4MTAlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwODEwVDEzNDU0M1omWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWMwNmFlNTI2NmFkNzI5MTIzMzU2MmJiNzVmZWY0MzkwNzk1ZmY4MTZjZTkwMTIxYTRjNzkxMmE3YjZkNzNkOWEmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0._sGewzhntCi9SZP0wX7KccjVMhltVlS9OOlsARGJ9XU)

### **3.4. Sơ đồ ERD**
![todoapp.drawio (6).png](https://private-user-images.githubusercontent.com/69153374/476290650-56fe11be-fd41-48a0-932f-8dc86baa650a.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3NTQ4MzM4ODAsIm5iZiI6MTc1NDgzMzU4MCwicGF0aCI6Ii82OTE1MzM3NC80NzYyOTA2NTAtNTZmZTExYmUtZmQ0MS00OGEwLTkzMmYtOGRjODZiYWE2NTBhLnBuZz9YLUFtei1BbGdvcml0aG09QVdTNC1ITUFDLVNIQTI1NiZYLUFtei1DcmVkZW50aWFsPUFLSUFWQ09EWUxTQTUzUFFLNFpBJTJGMjAyNTA4MTAlMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1EYXRlPTIwMjUwODEwVDEzNDYyMFomWC1BbXotRXhwaXJlcz0zMDAmWC1BbXotU2lnbmF0dXJlPWQyODcwOWZmN2E2NGIxMjA3ODBmY2ZmMWFkZTM5NDliMjg0ZTY1ZTNmNzJmOTMxZjgyMTFlYTFmYTY4OTFhN2YmWC1BbXotU2lnbmVkSGVhZGVycz1ob3N0In0.xzR_dSi48JZtxl6HgZSBJ_0bl0S2E5L_MVhhubXtHx0)
