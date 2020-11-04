package jdk.jdk8.functionProgram.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainTest {

    @Test
    public void testGroupReduce() {
        List<TestEntity> list = new ArrayList<>();
        list.add(TestEntity.builder().id("1").num(1).build());
        list.add(TestEntity.builder().id("1").num(10).build());

        list.add(TestEntity.builder().id("2").num(1).build());
        list.add(TestEntity.builder().id("2").num(10).build());
        list.add(TestEntity.builder().id("3").num(1).build());
        list.add(TestEntity.builder().id("3").num(10).build());

        Map<String, TestEntity> collect = list.stream().collect(Collectors.groupingBy(TestEntity::getId, Collectors.reducing(new TestEntity(), (e1, e2) -> {
            return TestEntity.builder().id(e1.getId()).num(e1.getNum() + e2.getNum()).build();
        })));
        list.forEach(testEntity -> {
            System.out.println(testEntity);
        });
        System.out.println("==============");
        collect.forEach((k,v)->{
            System.out.println(v);
        });

    }
}
