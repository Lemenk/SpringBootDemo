package top.lemenk.springboot_demo.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: springboot_demo
 * @BelongsPackage: top.lemenk.springboot_demo.domain
 * @Author: Lemenk
 * @Blog: www.lemenk.top
 * @Date: Created in 2020/3/2 21:05
 * @Description: User实体类
 */
@ApiModel(description = "用户实体类")
public class User implements Serializable {

    @ApiModelProperty(value = "用户ID",example = "1")
    private Integer id;
    @ApiModelProperty(value = "用户名",example = "张三")
    private String username;
    @ApiModelProperty(value = "用户地址",example = "中国北京市")
    private String address;
    @ApiModelProperty(value = "用户性别",example = "男")
    private String sex;
    @ApiModelProperty(value = "用户生日",example = "2010/01/01")
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
