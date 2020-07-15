package io.choerodon.iam.infra.dto;

import io.choerodon.iam.infra.valitador.Check;
import io.choerodon.iam.infra.valitador.Insert;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * FD_ROUTE_MEMBER_RULE DTO
 *
 * @author pengyuhua
 * @since 2019/10/25
 */
@Table(name = "fd_route_member_rule")
public class RouteMemberRuleDTO extends AuditDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private Long id;
    @ApiModelProperty(value = "用户ID/必填")
    @NotNull(message = "error.route.member.rule.user.id.can.not.be.null", groups = {Insert.class, Check.class})
    private Long userId;
    @ApiModelProperty(value = "路由编码/必填")
    private String routeRuleCode;

    @Transient
    private String realName;

    @Transient
    private String loginName;

    @Transient
    private String imageUrl;

    @Transient
    private String email;

    public Long getId() {
        return id;
    }

    public RouteMemberRuleDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public RouteMemberRuleDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getRouteRuleCode() {
        return routeRuleCode;
    }

    public RouteMemberRuleDTO setRouteRuleCode(String routeRuleCode) {
        this.routeRuleCode = routeRuleCode;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public RouteMemberRuleDTO setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public RouteMemberRuleDTO setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public RouteMemberRuleDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RouteMemberRuleDTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
