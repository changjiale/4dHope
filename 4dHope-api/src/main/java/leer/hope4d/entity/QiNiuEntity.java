package leer.hope4d.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 七牛云相关资源
 *
 * @auther leer
 * @date 2018/12/31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QiNiuEntity implements Serializable {

    private String key; //对象KEY
    private String name; //对象名称
    private String type; //对象类型
    private long size; //对象大小
    private String url; //对象链接
}
