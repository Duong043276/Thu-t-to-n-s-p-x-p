import java.util.Random;

public class SortingTest {

    // Hàm tạo mảng ngẫu nhiên
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }

    // Hàm đo thời gian thực thi
    public static void measureExecutionTime(String algorithmName, Runnable sortingAlgorithm) {
        long startTime = System.currentTimeMillis();
        sortingAlgorithm.run();
        long endTime = System.currentTimeMillis();
        System.out.println(algorithmName + " completed in " + (endTime - startTime) + " ms");
    }
    public class BubbleSort {
        public static void sort(int[] arr) {
            int n = arr.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        // Hoán đổi hai phần tử
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        swapped = true;
                    }
                }
                // Nếu không có sự hoán đổi nào trong vòng lặp, mảng đã sắp xếp
                if (!swapped) {
                    break;
                }
            }
        }
    }

    public class SelectionSort {
        public static void sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public class InsertionSort {
        public static void sort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                // Hoán đổi phần tử nhỏ nhất với phần tử đầu tiên
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public class QuickSort {
        // Hàm để tráo đổi giá trị
        public static void swap(int[] arr, int num1, int num2) {
            int temp = arr[num1];
            arr[num1] = arr[num2];
            arr[num2] = temp;
        }

        // Hàm để chia mảng thành 2 phần, sử dụng phần tử chốt (pivot)
        public static int partition(int[] arr, int left, int right) {
            int pivot = arr[right]; // Chọn phần tử cuối làm pivot
            int i = left - 1; // Con trỏ bên trái

            for (int j = left; j < right; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, right);
            return i + 1;
        }

        // Hàm QuickSort chính
        public static void sort(int[] arr, int left, int right) {
            if (left < right) {
                int partitionIndex = partition(arr, left, right); // Chia mảng
                sort(arr, left, partitionIndex - 1); // Sắp xếp mảng con bên trái
                sort(arr, partitionIndex + 1, right); // Sắp xếp mảng con bên phải
            }
        }
    }
    public class MergeSort {
        // Hàm để hợp nhất hai mảng con
        public static void merge(int[] arr, int[] temp, int low, int mid, int high) {
            int i = low, j = mid + 1, k = low;

            // So sánh và hợp nhất
            while (i <= mid && j <= high) {
                if (arr[i] <= arr[j]) {
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }

            // Sao chép phần còn lại của mảng trái
            while (i <= mid) {
                temp[k++] = arr[i++];
            }

            // Sao chép phần còn lại của mảng phải
            while (j <= high) {
                temp[k++] = arr[j++];
            }

            // Sao chép từ mảng temp vào mảng chính
            for (i = low; i <= high; i++) {
                arr[i] = temp[i];
            }
        }

        // Hàm MergeSort chính
        public static void sort(int[] arr, int[] temp, int low, int high) {
            if (low < high) {
                int mid = (low + high) / 2;
                sort(arr, temp, low, mid); // Sắp xếp nửa đầu
                sort(arr, temp, mid + 1, high); // Sắp xếp nửa sau
                merge(arr, temp, low, mid, high); // Hợp nhất hai nửa
            }
        }
    }

    public static void main(String[] args) {
        int size = 100000;
        int[] arr = generateRandomArray(size);

        // Chạy Bubble Sort
        int[] bubbleSortArr = arr.clone();
        measureExecutionTime("Bubble Sort", () -> BubbleSort.sort(bubbleSortArr));

        // Chạy Selection Sort
        int[] selectionSortArr = arr.clone();
        measureExecutionTime("Selection Sort", () -> SelectionSort.sort(selectionSortArr));

        // Chạy Insertion Sort
        int[] insertionSortArr = arr.clone();
        measureExecutionTime("Insertion Sort", () -> InsertionSort.sort(insertionSortArr));

        // Chạy Quick Sort
        int[] quickSortArr = arr.clone();
        measureExecutionTime("Quick Sort", () -> QuickSort.sort(quickSortArr, 0, quickSortArr.length - 1));

        // Chạy Merge Sort
        int[] mergeSortArr = arr.clone();
        int[] temp = new int[size];
        measureExecutionTime("Merge Sort", () -> MergeSort.sort(mergeSortArr, temp, 0, mergeSortArr.length - 1));
    }
}