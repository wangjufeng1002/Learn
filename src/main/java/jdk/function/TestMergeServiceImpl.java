package jdk.function;

/**
 * @author wjf
 * @version 1.0
 * @date 2021/1/23 14:11
 * @desc
 */

public class TestMergeServiceImpl implements ITestMergeService {

    @Override
    public Integer a(String a) {
        System.out.println("String");
        return null;
    }

    @Override
    public String a(Integer a) {
        System.out.println("Integer");
        return null;
    }
}
