package MathDungeon;

import java.util.Scanner;

public class StartState implements State {
    private Context context;

    public StartState(Context context) {
        this.context = context;
    }
    
    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("\nM A T H DungeoN!!\n");
            System.out.println("ルール: 次々と出題される計算問題の答えを入力してゴールを目指そう！\n難易度によって計算問題の難易度は上がるよ！\n");
            Thread.sleep(2000);

            System.out.println("難易度を選んで、ゲームスタート!!");
            System.out.println("難易度easy:PRESS 1 ※間違えれるのは3回");
            System.out.println("難易度normal:PRESS 2 ※間違えれるのは2回");
            System.out.println("難易度hard:PRESS 3 ※間違えれるのは1回");
            System.out.print(">>PRESS: ");
            int level = scanner.nextInt();

            Factory factory;
            if (level == 1) {
                factory = new EasyFactory();
            } else if (level == 2) {
                factory = new NormalFactory();
            } else if (level == 3) {
                factory = new HardFactory();
            } else {
                System.out.println("NOTHING LEVEL...");
                action();
                return;
            }

            context.setState(new GameState(context, factory));
            context.request();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
    }
}
