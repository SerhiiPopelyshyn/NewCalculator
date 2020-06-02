package Lesson5;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];

    static void counter(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Main.arr[i] = (float)(Main.arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    static void firstMethod() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        counter(arr);
        long stop = System.currentTimeMillis();
        System.out.println("Время работы первого метода: " + (stop - start) + " ms");
    }

    static void secondMethod() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long start = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            counter(a1);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            counter(a2);
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long stop = System.currentTimeMillis();
        System.out.println("Время работы второго метода:: " + (stop - start) + " ms");
    }



    public static void main(String[] args) {
        firstMethod();
        System.out.println("arr[5000000] = " + arr[5000000]);
        secondMethod();
        System.out.println("arr[5000000] = " + arr[5000000]);
    }
}




