package jdk.function;

/**
 * @author wjf
 * @version 1.0
 * @date 2021/1/23 14:12
 * @desc
 */
public enum MergeEnum {
    AA(new TestMergeServiceImpl());

    private ITestMergeService iTestMergeService;

    MergeEnum(ITestMergeService iTestMergeService) {
        this.iTestMergeService = iTestMergeService;
    }

    public ITestMergeService getiTestMergeService() {
        return iTestMergeService;
    }

    public void setiTestMergeService(ITestMergeService iTestMergeService) {
        this.iTestMergeService = iTestMergeService;
    }
}
