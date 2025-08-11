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

![todoapp.drawio (6).png](https://github.com/taicutm/todo-app/blob/main/img/class_diagram.png?raw=true)

### **3.4. Sơ đồ ERD**
![todoapp.drawio (6).png](https://raw.githubusercontent.com/taicutm/todo-app/refs/heads/main/img/ERD.png)
