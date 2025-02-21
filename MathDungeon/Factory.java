package MathDungeon;

public abstract class Factory {
    protected int count = 0;
    public abstract int missLimit();
    public abstract void createQ(int a);
    public abstract int answer();
    public boolean isCount(){
        if(count > missLimit()) {
            return false;
        }
        return true;
    }
}
