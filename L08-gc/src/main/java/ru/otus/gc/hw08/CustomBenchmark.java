package ru.otus.gc.hw08;

import java.util.ArrayList;
import java.util.List;

class CustomBenchmark implements CustomBenchmarkMBean {
    private volatile int size = 0;

    public CustomBenchmark() {
    }

    void run() throws Exception {

        while (true){

            List<String> stringArrayList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                stringArrayList.add(new String("Hello Otus!"));
            }

            for (int i = 0; i < stringArrayList.size(); i++) {

                if (i > 0 && i % 3 == 0){
                    stringArrayList.remove(i);
                }
            }
            Thread.sleep(10);
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        System.out.println("new size:" + size);
        this.size = size;
    }
}
