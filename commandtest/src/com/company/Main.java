package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        processArray pr = new processArray();
        int[] intArray = {1,2,3,4,5,6,7,8,9,10,12};
        pr.process(intArray, new printArray());
        pr.process(intArray, new sumArray());
        pr.process(intArray, new Command() {
            @Override
            public void process(int[] target) {
                System.out.println("目标数组的长度为 " + target.length);
            }
        });
        pr.process(intArray, (int[] target) -> {
            int sum = 0;
            for(int i : target){
                sum = sum + i;
            }
            System.out.println("目标数组的和*2为：" + sum*2);
        });
    }
}

interface Command {
    void process(int[] target);
}
class processArray {
    public void process(int[] target, Command cmd){
        cmd.process(target);
    }
}
class printArray implements Command {
    public void process(int[] target){
        for(int i : target){
            System.out.println("迭代目标数组的元素 " + i);
        }
    }
}
class sumArray implements Command {
    public void process(int[] target){
        int sum = 0;
        for(int i : target){
            sum = sum + i;
        }
        System.out.println("目标数组的和为：" + sum);
    }
}