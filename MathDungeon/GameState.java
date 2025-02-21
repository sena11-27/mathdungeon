package MathDungeon;

import java.util.Scanner;

public class GameState implements State {
    private Context context;
    private Factory factory;

    public GameState(Context context, Factory factory) {
        this.context = context;
        this.factory = factory;
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        System.out.println(factory.getClass().getSimpleName() + "モードスタート!!\n");
        
        while (count < 10 && factory.isCount()) { 
            factory.createQ(count); 
            int result = factory.answer();  
            count++;
        }

        if (count == 10) {
            System.out.print("10問正解！！");
            context.setState(new EndState(context));
            context.request();
        } else {
            System.out.print("失敗...リトライしますか？(y/n) >> ");
            char continueGame = scanner.next().charAt(0);
            if (continueGame == 'y' || continueGame == 'Y') {
                context.setState(new GameState(context, factory));
            } else {
                context.setState(new EndState(context));
            }
            context.request();
        }
    }
}
