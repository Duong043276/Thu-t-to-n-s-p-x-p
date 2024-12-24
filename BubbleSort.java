//Thuật toán sắp xếp nổi bọt hoạt động dựa trên việc so sánh các cặp phần tử liền kề và hoán đổi vị trí nếu phần tử trước lớn hơn phần tử sau.
//Sau mỗi vòng lặp, phần tử lớn nhất sẽ nổi lên cuối mảng. Quá trình tiếp tục đến khi toàn bộ mảng được sắp xếp.
//BubbleSort là thuật toán sắp xếp chậm nhất
public class BubbleSort{
    public void BubbleSort(int[] arr){
        int temp; //biến tạm dùng để hoán đổi vị trí
        int i,j; //biến đếm cho vòng lặp ngoài (i) và vòng lặp trong (j)

        boolean swapped = false; //kiểm tra xem có tồn tại hoán đổi nào trong vòng lặp không

        //Lặp qua tất cả các số
        for(i=0;i<arr.length-1;i++){ //đây là số lần lặp cần thiết để sắp xếp các phần tử
            swapped = false;

            //Vòng lặp thứ 2
            for(j=0;j<arr.length-1;j++){ //duyệt qua các phần tử trong mảng và so sánh từng cặp phần tử liên tiếp
                System.out.println("So sánh các phần tử:["+arr[j]+", "+arr[j+1]+"]");

                //Kiểm tra xem số kế tiếp có nhỏ hơn số hiện tại hay không
                //Trao đổi các số
                //Mục đích: làm nổi bọt số lớn nhất
                if(arr[j]>arr[j+1]){ //nếu phần tử arr[j] > arr[j+1], thực hiện hoán đổi và gán swapped = true để báo hiệu rằng mảng chưa dc sắp xếp hoàn toàn
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swapped = true;
                    System.out.println("=> trao đổi ["+arr[j]+", "+arr[j+1]+"]");
                }else{
                    System.out.println("không cần trao đổi");
                }
            }
            //Nếu không cần trao đổi nữa tức là mảng đã được sắp xếp và thoát khỏi vòng lặp
            if(!swapped){
                break;
            }
            System.out.println("Vòng lặp thứ" + (i+1));
            display(arr);
        }
    }

    private void display(int[] arr) { //hàm display in ra các phần tử trong mảng hiện tại, giúp kiểm tra trạng thái của mảng trong từng vòng lặp
        int i;
        System.out.println("[");

        //duyệt qua tất cả phan tử
        for(i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
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
        BubbleSort bubbleSort = new BubbleSort(); //gọi phương thức BubbleSort để thực hiện sắp xếp mảng
        System.out.println("Mảng dữ liệu đầu vào: ");
        bubbleSort.display(arr); //in mảng đã được sắp xếp ra màn hình
        System.out.println("------------------");
        bubbleSort.BubbleSort(arr);
        System.out.println("------------------");
        System.out.println("Mảng đầu vào khi đã sắp xếp: ");
        bubbleSort.display(arr);
    }
}
