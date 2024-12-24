//Quick Sort là thuật toán sắp xếp nhanh nhất với cách chọn pivot hợp lý
public class QuickSort {
    //hàm để tráo đổi giá trị
    public void swap(int[] arr, int num1, int num2) { //phương thức swap để hoán đổi giá trị giữa 2 phần tử arr[num1] và arr[num2] trong mảng arr.
        int temp = arr[num1]; //dùng biến tạm để lưu giá trị num1
        arr[num1] = arr[num2]; //gán giá trị của arr[num2] cho arr[num1]
        arr[num2] = temp; // gán giá trị temp(ban đầu là arr[num1]) cho arr[num2]
    }
    //hàm để chia mảng thành 2 phần, sử dụng phần tử chốt(pivot), các phần tử nhỏ hơn pivot nằm bên trái, lớn hơn nằm bên phải
    public int partition(int[] arr, int left, int right, int pivot) { //arr: mảng cần sắp xếp, left: chỉ số đầu tiên của vùng đang xử lý, right:chỉ số cuối cùng
        //của vùng đang xử lý, pivot: giá trị được chọn làm chốt
        int leftPointer = left-1;//chỉ số di chuyển từ trái sang phải để tìm phần tử lớn hơn pivot
        int rightPointer = right;//chỉ số di chuyển từ phải sang trái để tìm phần tử nhỏ hơn pivot
        while (true){
            while (arr[++leftPointer] < pivot){// tìm phần từ lớn hơn pivot từ trái sang phải đến khi thấy phần tử lớn hơn thì dừng
                //không làm gì
            }
            while (rightPointer > 0 && arr[--rightPointer] > pivot){//tìm phần tử nhỏ hơn pivot từ phải sang trái
                //không làm gì
            }
            if (leftPointer >= rightPointer){//nếu ... dừng việc phân chia
                break;
            }else{//nếu không, hoán đổi phần từ tại leftPointer và rightPointer
                System.out.println("Phần tử được trao đổi: " + arr[leftPointer] + ", " + arr[rightPointer]);
                swap(arr, leftPointer, rightPointer);
            }
        }
        //đặt pivot vào đúng vị trí trong mảng
        System.out.println("Phần tử được trao đổi: " + arr[leftPointer] + ", " + arr[right]);
        swap(arr, leftPointer, right);
        display(arr);
        return leftPointer; //trả về vị trí mà tại đó pivot đã được đặt
    }
    //hàm sắp xếp
    public void quickSort(int[] arr, int left, int right) {
        if(right - left <= 0){ //nếu vùng xử lý có 1 hoặc 0 phần tử, thoát khỏi hàm vì không cần sắp xếp
            return;
        }else{
            int pivot = arr[right]; //chọn phần tử cuối cùng của vùng làm chốt
            int partitionPoint = partition(arr, left, right, pivot); //gọi hàm partition để phân chia mảng và lấy vị trí của pivot
            quickSort(arr, left, partitionPoint - 1); //vùng bên trái, left đến partitionPoint-1
            quickSort(arr, partitionPoint + 1, right);//vùng bên phải, partitionPoint+1 đến right
        }
    }
    public void display(int[] arr) {// In ra trạng thái mảng hiện tại
        int i;
        System.out.println("[");
        //duyệt qua tất cả phần tử
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]\n");
    }
    public static void main(String[] args) {
        //khởi tạo mảng arr
        int arr[]={
                6,
                7,
                4,
                3,
                9,
                1,
                2,
                5,
                8
        };
        QuickSort quickSort = new QuickSort();
        System.out.println("Mảng dữ liệu đầu vào:");
        quickSort.display(arr);
        System.out.println("---------------------");
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println("---------------------");
        System.out.println("Mảng dữ liệu đầu vào khi đã sắp xếp");
        quickSort.display(arr);
    }
}
