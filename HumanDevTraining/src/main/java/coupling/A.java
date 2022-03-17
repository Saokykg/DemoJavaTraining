package coupling;

public abstract class A implements IA{

    int a;

    public A(int a){
        this.a = a;
    }

    public int getA(){
        return this.a;
    }

    public int getValue(){
        return this.a;
    }

}
