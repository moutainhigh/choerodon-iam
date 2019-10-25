package io.choerodon.base.app.service;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Pageable;
import io.choerodon.base.api.dto.LdapAccountDTO;
import io.choerodon.base.api.dto.LdapConnectionDTO;
import io.choerodon.base.infra.dto.LdapDTO;
import io.choerodon.base.infra.dto.LdapErrorUserDTO;
import io.choerodon.base.infra.dto.LdapHistoryDTO;

import java.util.Map;

/**
 * @author wuguokai
 */
public interface LdapService {
    LdapDTO create(Long organizationId, LdapDTO ldapDTO);

    LdapDTO update(Long organizationId, Long id, LdapDTO ldapDTO);

    LdapDTO queryByOrganizationId(Long organizationId);

    void delete(Long organizationId, Long id);

    /**
     * 测试是否能连接到ldap
     *
     * @param organizationId 组织id
     * @param id             ldapId
     * @return LdapConnectionDTO 连接测试结构体
     */
    LdapConnectionDTO testConnect(Long organizationId, Long id, LdapAccountDTO ldapAccountDTO);

    Map<String, Object> testConnect(LdapDTO ldap);

    /**
     * 根据ldap配置同步用户
     *
     * @param organizationId
     * @param id
     */
    void syncLdapUser(Long organizationId, Long id);

    LdapDTO validateLdap(Long organizationId, Long id);

    /**
     * 根据ldap id 查询最新的一条记录
     *
     * @param ldapId ldapId
     * @return
     */
    LdapHistoryDTO queryLatestHistory(Long ldapId);

    LdapDTO enableLdap(Long organizationId, Long id);

    LdapDTO disableLdap(Long organizationId, Long id);

    LdapHistoryDTO stop(Long id);

    /**
     * 根据ldapId分页查询ldap history
     * @param ldapId
     * @return
     */
    PageInfo<LdapHistoryDTO> pagingQueryHistories(Pageable Pageable, Long ldapId);

    PageInfo<LdapErrorUserDTO> pagingQueryErrorUsers(Pageable Pageable, Long id, LdapErrorUserDTO ldapErrorUserDTO);
}
