package czj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author czj
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户密码，
     */
    private String password;

    /**
     * 用户邮箱，不可重复
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 状态标记：0未激活1激活2无效
     */
    private Integer flag;

    /**
     * 角色：0管理员1会员
     */
    private Integer role;

    /**
     * 激活码
     */
    private String code;


}
