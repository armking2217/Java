package dz5;

public class MainOsnova {
    public static void main(String[] args) {

         double[] arr=new double[1000000];
        for (int i = 0; i <arr.length ; i++) arr[i]=-1;
        method1(arr);
        method2(arr);// вопрос по этому методу дальше будет
        //можете в след раз дать доп дз на нити пожалуйста, какое нибудь посложнее, чтобы понять, где  и w8 и notify использовать надо было, примерно как вы писали
        //я подумал что можно не делить на 2 массива, надеюсь это было не обзательно
    }

    public static void method1(double[] arr){
        long a=System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        System.out.println(System.currentTimeMillis()-a);
    }
    public static void method2(double[] arr){
        long a=System.currentTimeMillis();
        /*Thread[] threads = new Thread[4];
        for (int i = 0; i <threads.length ; i++) {
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = i; j <arr.length ; j+=threads.length) {
                        // ругается на i то, что не FINAl, как обойти? Можете ответить, пожалуйста
                    }
                }
            })
        }*/
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <arr.length ; i+=4) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <arr.length ; i+=4) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i <arr.length ; i+=4) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i <arr.length ; i+=4) arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-a);
    }
}
