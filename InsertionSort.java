//Insertion Sort phù hợp nhất cho mảng nhỏ hoặc gần như đã sắp xếp
public class InsertionSort {
    public void insertionSort(int[] arr){
        int valueToInsert; //giá trị cần chèn vào vị trí phù hợp trong mảng
        int holePosition; //vị trí lỗ trống trong mảng, nơi cần chèn giá trị
        int i; //biến đếm
        //lặp qua tất cả các số, bắt đầu từ phần tử 2 vì phần tử đầu tiên được coi là đã sắp xếp
        for(i=1;i<arr.length;i++){
            //chọn 1 giá trị để chèn
            valueToInsert = arr[i];
            //lựa chọn vị trí để chèn
            holePosition=i;
            //kiểm tra xem số liền trước có lớn hơn giá trị được chèn không
            while (holePosition>0&&arr[holePosition-1]>valueToInsert){ //nếu phần tử trước arr[holePosition - 1] lớn hơn giá trị cần chèn, di chuyển pt đó về sau
                arr[holePosition] = arr[holePosition-1]; //gán giá trị của arr[holePosition - 1] vào arr[holePosition]
                holePosition--; //và giảm holePosition để tiếp tục kiểm tra phần tử trước đó
                System.out.println("Di chuyển phần tử:"+ arr[holePosition]);
            }
            if(holePosition != i){ //nếu holePosition thay đổi ...
                System.out.println("Chèn phần tử:"+valueToInsert+"tại vị trí:"+holePosition);
                //chèn phần tử tại vị trí chèn
                arr[holePosition] = valueToInsert;
            }
            System.out.println("Vòng lặp thứ: " + i); //hiển thị trạng thái mảng
            display(arr);
        }
    }
    public void display(int[] arr){
        int i;
        System.out.println("[");
        //duyệt qua tất cả phần tử
        for(i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]\n");
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
        InsertionSort insertionSort = new InsertionSort();
        System.out.println("Mảng dữ liệu đầu vào: ");
        insertionSort.display(arr);
        System.out.println("----------------------");
        insertionSort.insertionSort(arr);
        System.out.println("----------------------");
        System.out.println("Mảng dữ liệu đầu vào khi đã sắp xếp");
        insertionSort.display(arr);
    }
}
