//Merge Sort là thuật toán sắp xếp ổn định nhất (không bị ảnh hưởng bởi trạng thái mảng đầu vào)
public class MergeSort {
    public void mergeSort(int[] arr, int[] temp, int low, int mid, int high) {// thực hiện việc gộp 2 mảng con đã được sắp xếp
        int l1; //con trỏ để duyệt phần mảng trái
        int l2,i;//l2 là con trỏ để duyệt phần mảng phải
        l1 = low;
        l2 = mid + 1;
        for (i=low;l1<=mid&&l2<=high;i++) {//duyệt qua cả 2 mảng con để gộp chúng lại thành một mảng đã sắp xếp trong temp
            if(arr[l1]<=arr[l2]) {//so sánh phần tử tại l1 và l2, gán phần tử nhỏ hơn vào temp
                temp[i] = arr[l1++];//tăng con trỏ tương ứng sau khi gán
            }else{
                temp[i] = arr[l2++];
            }
        }
        while (l1<=mid) {// sao chép các phần tử từ mảng trái(nếu mảng phải đã hết phần tử)
            temp[i++] = arr[l1++];
        }
        while (l2<=high) {// sao chép các phần tử còn lại từ mảng phải(nếu mảng trái đã hết phần tử)
            temp[i++] = arr[l2++];
        }
        for (i=low;i<=high;i++) {//sao chép lại mảng temp(đã gộp và sắp xếp) vào mảng gốc arr
            arr[i] = temp[i];
        }
    }
    public void sort(int[] arr, int[] temp, int low, int high) {//hàm thực hiện việc chia nhỏ mảng và gọi đệ quy để sắp xếp các phần mảng con
        int mid;
        if (low < high) {//Điều kiện dừng đệ quy: nếu low >= high nghĩa là mảng chỉ có 1 phần tử hoặc 0 phần tử, không cần sắp xếp
            //Tìm điểm giữa của mảng để chia mảng thành 2 phần
            mid = (low + high) / 2; // phần trái từ low đến mid, phần phải từ mid+1 đến high
            sort(arr, temp, low, mid);// đệ quy gọi chính nó để sắp xếp mảng con bên trái
            sort(arr, temp, mid + 1, high);// ....
            mergeSort(arr, temp, low, mid, high); // gộp 2 mảng con đã sắp xếp thành 1 mảng lớn hơn
            //hiển thị mảng
            display(arr);
        }else{
            return;
        }
    }
    public void display(int[] arr) {
        int i;
        System.out.println("[");
        //duyệt qua tất cả phần tử
        for (i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        //khởi tạo mảng arr
        int arr[] = {
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
        int temp[] = new int[10];
        MergeSort mergeSort = new MergeSort();
        System.out.println("Mảng dữ liệu đầu vào:");
        mergeSort.display(arr);
        System.out.println("---------------------");
        mergeSort.sort(arr, temp, 0, arr.length-1);
        System.out.println("---------------------");
        System.out.println("Mảng dữ liệu đầu vào:");
        mergeSort.display(arr);
    }
}
