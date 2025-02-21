package MathDungeon;

import java.util.Random;
import java.util.Scanner;

public class NormalFactory extends Factory{
    int miss, answer;

    NormalFactory(){
        this.miss = 0;
    }

    @Override
    public int missLimit(){
        return 2;
    }

    @Override
    public void createQ(int a){
        int num = a+1;
        Random random = new Random();
        int num1 = random.nextInt(900) + 100;
        int num2 = random.nextInt(900) + 100; 
        int num3 = random.nextInt(100) + 10; 
        int num4 = random.nextInt(10) + 1; 
        int w = random.nextInt(4)+1; 

        System.out.println("miss回数:"+ count);
        System.out.println("問題" + num);
        if (w == 1) {
            answer = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = ?");
        } else if(w == 2){
            answer = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = ?");
        }else if(w == 3){
            answer = num3 * num4;
            System.out.println(num3 + " * " + num4 + " = ?");
        }else{
            answer = num3 / num4;
            System.out.println("小数点以下切り捨て");
            System.out.println(num3 + " / " + num4 + " = ?");
        }
    }

    @Override
    public int answer(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("your answer >> ");
        int a = scanner.nextInt();
        if (a == answer) {
            System.out.println("正解！\n");
            return 1;
        } else {
            System.out.println("不正解...\n");
            count++;
            return 0;
        }
    }
    @Override
    public boolean isCount(){
        if(count >= missLimit()) {
            return false;
        }
        return true;
    }
}
