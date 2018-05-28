package com.gupao.springbootjsp.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: spring-boot-jsp
 * @description:权限的用户表
 * @author:Daniel.zhao
 * @create:2018-05-25 10:59
 **/

/**
 * SpringSecurity是专门针对基于Spring项目的安全框架，充分利用了依赖注入和AOP来实现安全管控。在很多大型企业级系统中权限是最核心的部分，一个系统的好与坏全都在于权限管控是否灵活，是否颗粒化。在早期的SpringSecurity版本中我们需要大量的xml来进行配置，而基于SpringBoot整合SpringSecurity框架相对而言简直是重生了，简单到不可思议的地步。

 SpringSecurity框架有两个概念认证和授权，认证可以访问系统的用户，而授权则是用户可以访问的资源，下面我们来简单讲解下SpringBoot对SpringSecurity安全框架的支持。

 链接：https://www.jianshu.com/p/c3b49d0a490b
 來源：简书
 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
@Entity
@Table(name = "users")
public class UserEntity  implements Serializable ,UserDetails {

    private static final long serialVersionUID = 4475839742876142510L;
    @Id
    @Column(name = "u_id")
    private Long id;


    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;


    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
           name = "user_roles",
           joinColumns = {
                   @JoinColumn(name = "ur_user_id")
           },
            inverseJoinColumns = {
                   @JoinColumn(name = "ur_role_id")
            }

    )
    private List<RoleEntity> roles;

    /**
     * UserDetails是SpringSecurity验证框架内部提供的用户验证接口
     * （我们下面需要用到UserEntity来完成自定义用户认证功能），
     * 我们需要实现getAuthorities方法内容，将我们定义的角色列表添加到授权的列表内
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority>auths=new ArrayList<>();
        List<RoleEntity> roles = getRoles();
        for(RoleEntity role:roles){
            auths.add(new SimpleGrantedAuthority(role.getFlag()));
        }
        return auths;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
