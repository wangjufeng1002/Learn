package design_model.AbstractFactoryPattern;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/2/22
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
