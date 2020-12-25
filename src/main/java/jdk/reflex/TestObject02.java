package jdk.reflex;

import common.CacheKey;

/**
 *
 * @description:
 *
 * @author wangjufeng1
 * @date 2018/9/3
 */
public class TestObject02 {
    @CacheKey
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TestObject02(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public TestObject02() {
    }

    @Override
    public String toString() {
        return "TestObject02{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
