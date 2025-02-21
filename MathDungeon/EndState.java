package MathDungeon;

import java.util.Scanner;

public class EndState implements State {
    private Context context;

    public EndState(Context context) {
        this.context = context;
    }

    @Override
    public void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ステージ終了!!");
        System.out.print("タイトル画面に戻りますか？ ※もどらない場合ゲーム終了 (y or n) >> ");

        char c = scanner.next().charAt(0);
        if (c == 'y' || c == 'Y') {
            context.setState(new StartState(context));
            context.request();
        } else {
            System.out.println("Thank you for PLAYING!!\n");
        }        
    }
}

