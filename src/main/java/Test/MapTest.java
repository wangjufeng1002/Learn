package Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/8/5 17:43
 */
public class MapTest {

    public Map<String,String> aliasMap = new HashMap<>();

    public boolean hasAlias(String name, String alias) {
        for (Map.Entry<String, String> entry : this.aliasMap.entrySet()) {
            //registeredName == beanName
            String registeredName = entry.getValue();
            //
            if (registeredName.equals(name)) {
                String registeredAlias = entry.getKey();
                if (registeredAlias.equals(alias) || hasAlias(registeredAlias, alias)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<String, String> getAliasMap() {
        return aliasMap;
    }

    public void setAliasMap(Map<String, String> aliasMap) {
        this.aliasMap = aliasMap;
    }

    public MapTest(Map<String, String> aliasMap) {
        this.aliasMap = aliasMap;
    }
}
