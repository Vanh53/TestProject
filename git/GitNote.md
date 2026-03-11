1. ## SSH và HTTPS
- Tạo cặp key-value giữa máy tính và github: ssh-keygen -t ed25519 -C "hoangem05032004@gmail.com"
    <br>
    ![alt text](image/image-7.png)

- In nội dung khóa ra màn hình: cat ~/.ssh/id_ed25519.pub
    <br>
    ![alt text](image-8.png)


- Chuyển đổi giữa HTTPS và SSH: git remote set-url
    - Từ HTTPS chuyển sang SSH 
        <br>
        ![alt text](image-9.png)
    - Từ SSH chuyển sang HTTPS
        <br>
        ![alt text](image-10.png)

2. ## Remote Management

- Liên kết kho lưu trữ **cục bộ** với kho lưu trữ **từ xa**: git remote add origin https://github.com/Vanh53/TestProject.git
    <br>
    ![alt text](image-1.png)

- Liệt kê các kết nối: Git remote -v
    <br>
    ![alt text](image-2.png)

3. ## Regular Workflow

- Đưa thay đổi vào vùng chờ staging:
    - Thêm 1 file: git add README.md
        <br>
       ![alt text](image-12.png)
    - Thêm tất cả thay đổi: git add .
        <br>
        ![alt text](image-11.png)

- Ghi lại những thay đổi: Git commit -m “create file README.md”
    <br>
    ![alt text](image-3.png)

- Kéo dữ liệu từ remote về local một các an toàn: 
    - git fetch origin master
    - Xem danh sách các commit trên remote có mà local k có: git log master..origin/master --oneline
    - Merge thủ công: git merge origin/master

- Kéo dữ liệu từ remote về và tự động merge vào nhánh hiện tại: git pull origin master

- Kéo code từ nhánh khác trên local -> thực hiện merge

- Đẩy dữ liệu từ nhánh hiện tại lên kho lưu trữ từ xa: git push origin master
    <br>
    ![alt text](image-6.png)

- Sử dụng -h hoặc --help để tìm hiểu thêm về 1 lệnh cụ thể
    Ví dụ: 
    <br>
    ![alt text](image-13.png)

- Hiển thị danh sách các commit: git log
    <br>
    ![alt text](image-14.png)

- Hiển thị danh sách commit, mỗi commit trên 1 dòng: git log --oneline
    <br>
    ![alt text](image-15.png)

4. ## Branching & Navigation

- Tạo và chuyển sang 1 nhánh mới: git checkout -b nhanh1
    <br>
    ![alt text](image-4.png)

- Chuyển sang nhánh khác: git checkout master
    <br>
    ![alt text](image-5.png)

- Xem danh sách nhánh: git branch
    <br>
    ![alt text](image-16.png)

- Đưa thư mục làm việc (Working directory) trở về trạng thái của 1 commit nhất định: git checkout <revision>
    - Ví dụ: git checkout 373a95c
        <br>
        ![alt text](image-17.png)
    - Muốn thay đổi từ commit trước -> tạo nhánh mới: git checkout -b ten-nhanh 373a95c

- Xóa nhánh: git branch -d nhanh2
    <br>
    ![alt text](image-18.png)

- Đưa file trở về trạng thái commit gần nhất: git checkout -- GitNote.md
    <br>
    ![alt text](image-19.png)

5. ## Merging 

- Fast-forward Merge
    - Cú pháp: git merge <ten-nhanh>
    - Merge mà không tạo commit mới

- No Fast-forward Merge 
    - Cú pháp: git merge --no-ff <ten-nhanh>.
    - Merge có tạo commit để ghi lại lịch sử gộp 2 nhánh

- Squash Merge
    - Cú pháp: git merge --squash <ten-nhanh>.
    - Lấy toàn bộ commit trên nhánh phụ, nên lại và tạo thành 1 commit trên nhánh chính

6. ## ontext Switching

- Lưu lại những thay đổi để chuyển nhánh mà không cần commit, đưa vào danh sách: 
    - git stash
    - Lưu lại tất cả: git stash -u (kể cả các file untracked chưa được add hoặc commit)

- Lấy 1 trạng thái từ đầu danh sách và xóa nó khỏi danh sách: git stash pop

- Làm trống danh sách stash: git stash clear

- Xem danh sách stash: git stash list

7. ## Reset

- Git Reset --soft:
    - Cú pháp: git reset --soft <commit-id>
    - Chỉ di chuyển con trỏ HEAD về commit cũ, vùng staging và working không thay đổi
    - Dùng khi muốn thay đổi nội dung của commit

- Git Reset --hard:
    - Cú pháp: git reset --hard <commit-id>
    - Đưa toàn bộ HEAD, vùng Staging và thư mục làm việc về y hệt trạng thái của commit cũ
    - Dùng khi code lỗi, reset lại toàn bộ

- Git Reset --mixed (mặc định):
    - Cú pháp: git reset --mixed <commit-id>
    - Di chuyển HEAD và cập nhật lại vùng Staging Area giống với commit cũ, vùng làm việc giữ nguyên
    - Dùng khi muốn thay đổi các file đã add

- Đẩy dữ liệu lên kho lưu trữ từ xa và ghi đè (ghi đè tất cả commit trên kho lưu trữ từ xa thành commit trên máy cục bộ): git push --force origin master

# 4 vùng làm việc
1. Vùng làm việc (Working directory) là vùng người dùng thực hiện code

2. Vùng chờ (Staging area) là vùng lưu dữ liệu thay đổi (thêm vào bằng add)

3. Kho lưu trữ cục bộ (local repository) để lưu dữ liệu trên máy (thêm vào bằng commit)

4. Kho lưu trữ từ xa (github, ... ) để lưu dữ liệu từ xa (thực hiện với push, pull)


