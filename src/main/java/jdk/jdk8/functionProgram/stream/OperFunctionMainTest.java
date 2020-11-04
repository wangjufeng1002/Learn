package jdk.jdk8.functionProgram.stream;

public class OperFunctionMainTest {
    public static void main(String[] args) {
        OperFunction<Integer,Integer> of = (x,y)->{return x+y;};
        System.out.println(of.operator(20,20));
        //System.out.println(operator(20,20,(x,y)->{return x+y; }));
    }

    public static Integer operator(Integer x,Integer y,OperFunction<Integer,Integer> of){
        return of.operator(x, y);
    }
}
