package other.validator;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/5/22 16:27
 */
public class ValidatorUtil {
    //也可以使用spring注入的方式
    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    /**
     * 使用指定分组
     *
     * @param object 被校验的bean
     * @param groups 分组
     * @return
     */
    public static <T> Map<String, StringBuilder> validate(T object, Class<?>... groups) {
        Map<String, StringBuilder> errorMap = new HashMap<>(16);
        if (groups == null) {
            groups = new Class[]{Default.class};
        }
        Set<ConstraintViolation<T>> set = validator.validate(object, groups);
        if (CollectionUtils.isEmpty(set)) {
            return null;
        }
        String property;
        for (ConstraintViolation<T> c : set) {
            // 这里循环获取错误信息，可以自定义格式
            property = c.getPropertyPath().toString();
            if (errorMap.get(property) != null) {
                errorMap.get(property).append(",").append(c.getMessage());
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(c.getMessage());
                errorMap.put(property, sb);
            }
        }
        return errorMap;
    }

    public static void main(String[] args) {
        InformationBasicInfoAO object = new InformationBasicInfoAO();
        Map<String, StringBuilder> errorMap = ValidatorUtil.validate(object);
        if (!CollectionUtils.isEmpty(errorMap)) {
            System.out.println("------参数校验失败:{}"+errorMap.toString());
        }
    }
}
