# So sánh hiệu suất các thuật toán sắp xếp

MÔ TẢ

Chương trình thực hiện so sánh hiệu suất của các thuật toán sắp xếp, bao gồm:
- Bubble Sort
- Selection Sort
- Insertion Sort
- Quick Sort
- Merge Sort

THUẬT TOÁN NHANH NHẤT
Trong chương trình, thuật toán QuickSort là nhanh nhất do:
1. Sử dụng chiến lược chia để trị: Chia mảng lớn thành các mảng nhỏ giúp tối ưu hóa số lượng phép so sánh và hoán đổi.
2. Độ phức tạp trung bình: O(n log n)
3. Hiệu quả bộ nhớ: không yêu cầu bộ nhớ bổ sung lớn

CÁCH CHẠY CHƯƠNG TRÌNH
1. Tạo mảng ngẫu nhiên:
- Hàm generateRandomArray tạo một mảng ngẫu nhiên với số lượng phần tử được chỉ định
- Kích thước mảng mặc định đang để là 100000
2. Thực thi các thuật toán sắp xếp:
- Từng thuật toán sẽ thực thi trên một bản sao của mảng ban đầu
- Kết quả trả về là thời gian thực thi
3. Hiển thị kết quả:
- Thời gian thực thi của từng thuật toán sẽ được in ra màn hình console

YÊU CẦU HỆ THỐNG
- Java JDK: phiên bản 23.0.1
- IDE: IntelliJ IDEA, Eclipse, ...
- Công cụ dòng lệnh (Command Line)
HƯỚNG DẪN SỬ DỤNG
1. Clone dự án:
- git clone URL
2. Mở dự án trong IDE
- Mở IDE
- Import project từ thư mục vừa tải về
3. Chạy chương trình: 
- Cách 1: chạy bằng IDE
+ Tìm tệp muốn chạy, nhấn chuột phải và chọn Run để chạy chương trình
- Cách 2: chạy bằng dòng lệnh
+ Mở thư mục và chuyển đến thư mục chứa dự án
+ Biên dịch file SortingTest.Java: javac SortingTest.java
+ Chạy chương trình: java SortingTest
3. Tùy chỉnh kích thước mảng:
- Chỉnh sửa giá trị của biến size trong hàm main để thay đổi kích thước mảng

CÁC LỚP THUẬT TOÁN SẮP XẾP
- BubbleSort: Sắp xếp theo từng cặp phần tử và hoán đổi nếu chúng không đúng thứ tự
- SelectionSort: Tìm phần tử nhỏ nhất và hoán đổi với phần tử đầu tiên của mảng
- InsertionSort: Chèn phần tử hiện tại vào vị trí thích hợp trong phần mảng đã sắp xếp
- QuickSort: Chọn 1 phần tử làm pivot và chia mảng thành 2 mảng nhỏ dựa trên giá trị pivot
- MergeSort: Chia mảng thành các mảng nhỏ, sắp xếp chúng và hợp nhất lại

CÁC HÀM HỖ TRỢ:
- generateRandomArray(int size): Tạo mảng ngẫu nhiên với kích thước cho trước
- measureExecutionTime(String algorithmName, Runable sortingAlgorithm): Đo thời gian thực thi của 1 thuật toán sắp xếp
