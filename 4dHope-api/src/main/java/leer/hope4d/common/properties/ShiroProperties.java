package leer.hope4d.common.properties;

import lombok.Data;

/**
 * @author leer
 * @date 2019-09-20
 */
@Data
public class ShiroProperties {

    private long sessionTimeout;
    private int cookieTimeout;
    private String anonUrl;
}
