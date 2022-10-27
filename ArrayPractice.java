// public class ArrayPractice {

//     public static int arr[] = new int[10];

//     public static void main(String[] args) {
//         for (int i = 0; i < 10; i++) {
//             arr[i] = i;
//         }

//         insert(10, 1);

//         for (int i = 0; i < arr.length; i++) {
//             System.out.println(arr[i]);
//         }
//     }

//     public static void insert(int index, int value) {
//         if (index > arr.length - 1)
//             index = index % arr.length;
//         for (int i = arr.length - 1; i > index; i--) {
//             arr[i] = arr[i - 1];
//         }
//         arr[index] = value;
//     }
// }

class lab {
    public static int arr[] = { 1, 2, 2, 5, 5, 5, 10, 11, 4, 4, 0, 0, 0 };

    public static void main(String[] args) {
        duplicateDeletion();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void duplicateDeletion() {

        for (int i = 0; i < arr.length - 1; i++) {// deletes duplicates
            if (arr[i] == arr[i + 1]) {
                arr[i] = 0;
            }
        }

        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] == 0) {
                arr[j] = arr[j + 1];
                arr[j + 1] = 0;
            }
        }
    }
}