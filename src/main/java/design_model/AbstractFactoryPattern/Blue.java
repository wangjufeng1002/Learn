package design_model.AbstractFactoryPattern;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/2/22
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
