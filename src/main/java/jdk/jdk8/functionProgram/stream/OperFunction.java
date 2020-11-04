package jdk.jdk8.functionProgram.stream;

@FunctionalInterface
public interface OperFunction<R,T> {
    R operator(T a,T b);
}
