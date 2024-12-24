public class SelectionSort {
    public void selectionSort(int[] arr) {
        int indexMin,i,j;//indexMin lưu trữ chỉ số của phần tử nhỏ nhất tìm được trong mảng. i và j là biến đếm cho 2 vòng lặp
        //lặp qua tất cả các số đến trước phần tử cuối
        for(i=0;i<arr.length-1;i++) {
            //thiết lập phần tử tại i là nhỏ nhất
            indexMin = i;
            //kiểm tra phần tử hiện tại có phải nhỏ nhất không
            for(j=i+1;j<arr.length;j++) {
                if(arr[j]<arr[indexMin]) {//nếu tìm thấy 1 phần tử nhỏ hơn arr[indexMin], cập nhật indexMin là chỉ số của phần tử này
                    indexMin = j;
                }
            }
            if(indexMin != i) { //nếu phần tử nhỏ nhất được tìm thấy không nằm ở vị trí ban đầu(indexMin != i) thực hiên hoán đổi
                System.out.println("=> Tráo đổi phần tử:["+arr[i]+","+arr[indexMin]+"]");
                //Tráo đổi các số
                int temp = arr[indexMin]; //lưu giá trị phần tử nhỏ nhất vào các biến tạm
                arr[indexMin] = arr[i];
                arr[i] = temp;
            }
            System.out.println("Vòng lặp thứ: " + (i+1));
            display(arr);// gọi phương thức display để hiển thị trạng thái mảng sau mỗi lần hoán đổi
        }
    }
    public void display(int[] arr) { //In ra trạng thái hiện tại của mảng arr dưới dạng danh sách các phần tử
        int i;
        System.out.println("[");
        //duyệt qua tất cả phần tử
        for(i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("]\n");
    }
    public static void main(String[] args) {
        int arr[]={ //mảng dữ liệu đầu vào cần được sắp xếp
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
        SelectionSort selectionSort = new SelectionSort();
        System.out.println("Mảng dữ liệu đầu vào:");
        selectionSort.display(arr);// in ra trạng thái ban đầu của bảng
        System.out.println("---------------------");
        selectionSort.selectionSort(arr); //Thực hiện thuật toán sắp xếp
        System.out.println("---------------------");
        System.out.println("Mảng dữ liệu đầu vào khi đã sắp xếp:");
        selectionSort.display(arr); //sau khi sắp xếp, hiển thị trạng thái mảng đã được sắp xếp bằng phương thức display
    }
}
