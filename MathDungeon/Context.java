package MathDungeon;

public class Context {
    private State state;

    public Context() {
        this.state = new StartState(this);
    }

    public void setState(State state) {
        State keep = this.state;
        this.state = state;
        try{
            System.out.print(" \n Loading ");
            Thread.sleep(1000);
            System.out.print("・");
            Thread.sleep(1000);
            System.out.print("・");
            Thread.sleep(1000);
            System.out.print("・");
            Thread.sleep(1000);
            System.out.println(keep + "から" + this.state + "へ状態が変化しました\n");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
    }
    

    public void request() {
        state.action();
    }
}

