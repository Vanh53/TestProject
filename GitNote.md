- Liên kết kho lưu trữ **cục bộ** với kho lưu trữ **từ xa**: git remote add origin https://github.com/Vanh53/TestProject.git
![alt text](image-1.png)

- Liệt kê các kết nối: Git remote -v
![alt text](image-2.png)

- Chuyển đổi giữa HTTPS và SSH: git remote set-url
    - Từ HTTPS chuyển sang SSH 
        <br>
        ![alt text](image-9.png)
    - Từ SSH chuyển sang HTTPS
        <br>
        ![alt text](image-10.png)

- Đưa thay đổi vào vùng chờ staging:
    - Thêm 1 file: git add README.md

    ![alt text](image-12.png)

    - Thêm tất cả thay đổi: git add .
    
    ![alt text](image-11.png)

- Ghi lại những thay đổi: Git commit -m “create file README.md”
![alt text](image-3.png)

- Tạo và chuyển sang 1 nhánh mới: git checkout -b nhanh1
![alt text](image-4.png)

- Chuyển sang nhánh khác: git checkout master
![alt text](image-5.png)

- Đẩy dữ liệu từ nhánh hiện tại lên kho lưu trữ từ xa: git push origin master
![alt text](image-6.png)

- 

### SSH và HTTPS
- Tạo cặp key-value giữa máy tính và github: ssh-keygen -t ed25519 -C "hoangem05032004@gmail.com"
![alt text](image-7.png)

- In nội dung khóa ra màn hình: cat ~/.ssh/id_ed25519.pub
![alt text](image-8.png)

# 4 vùng làm việc
1. vùng làm việc (Working directory) là vùng người dùng thực hiện code

2. vùng chờ (Staging area) là vùng lưu dữ liệu thay đổi (thêm vào bằng add)

3. kho lưu trữ cục bộ (local repository) để lưu dữ liệu trên máy (thêm vào bằng commit)

4. kho lưu trữ từ xa (github, ... ) để lưu dữ liệu từ xa (thực hiện với push)