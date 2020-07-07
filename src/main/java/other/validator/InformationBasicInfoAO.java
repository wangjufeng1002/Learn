package other.validator;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Description: <br>
 *
 * @author 作者 jufeng.wang
 * @version 创建时间: 2020/5/22 16:24
 */
public class InformationBasicInfoAO {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 文章标题
     */
   // @NotNull(message = "文章标题不能为空")
    @NotNull(message = "文章标题不能为空")
    private String title;
    /**
     * 发布日期
     */

    @NotNull(message = "发布时间不能为空")
    private Date releaseDate;
    /**
     * 文章来源
     */
    //@NotNull(message = "文章来源不能为空")
    @NotNull(message = "文章来源不能为空")
    private String source;
}
