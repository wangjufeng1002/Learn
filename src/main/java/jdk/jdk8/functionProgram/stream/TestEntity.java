package jdk.jdk8.functionProgram.stream;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity {
    private String id;
    private Integer num = 0;

    @Override
    public String toString() {
        return "TestEntity{" +
                "id='" + id + '\'' +
                ", num=" + num +
                '}';
    }
}
