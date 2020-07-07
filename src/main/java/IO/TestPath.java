package IO;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author wangjufeng1
 * @description
 * @date 2019/4/25
 */
public class TestPath {
    public static void main(String[] args) throws IOException {
        URL url = new URL("file://D:/项目/拍卖/sql.txt");
        url.openStream();
    }
    private void getPath(){
        String path = getClass().getProtectionDomain().getCodeSource().getLocation().getPath().replaceFirst("/","");

        System.out.println(path);
    }
}
