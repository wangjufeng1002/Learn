package design_model.AbstractFactoryPattern;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/2/22
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Squre::draw() method.");
    }
}
