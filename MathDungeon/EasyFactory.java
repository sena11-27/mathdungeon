package MathDungeon;
import java.util.Random;
import java.util.Scanner;

public class EasyFactory extends Factory{
    int miss, answer;

    EasyFactory(){
        this.miss = 0;
    }

    @Override
    public int missLimit(){
        return 3;
    }

    @Override
    public void createQ(int a){
        int num = a+1;
        Random random = new Random();
        int num1 = random.nextInt(100) + 10;
        int num2 = random.nextInt(100) + 10; 
        boolean w = random.nextBoolean(); 
        
        System.out.println("miss回数:"+ count);
        System.out.println("問題" + num);
        if (w) {
            answer = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = ?");
        } else {
            answer = num1 - num2;
            System.out.println(num1 + " - " + num2 + " = ?");
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
