package io.choerodon.base.app.service;

import java.util.List;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import io.choerodon.base.infra.dto.OrganizationDTO;
import org.springframework.data.domain.Pageable;
import io.choerodon.base.infra.dto.ProjectDTO;
import io.choerodon.base.infra.dto.UserDTO;

/**
 * @author flyleft
 */
public interface ProjectService {

    ProjectDTO queryProjectById(Long projectId);

    PageInfo<UserDTO> pagingQueryTheUsersOfProject(Long id, Long userId, String email, Pageable Pageable, String param);

    ProjectDTO update(ProjectDTO projectDTO);

    ProjectDTO disableProject(Long id);

    Boolean checkProjCode(String code);

    List<Long> listUserIds(Long projectId);

    List<ProjectDTO> queryByIds(Set<Long> ids);

    List<Long> getProListByName(String name);

    /**
     * 根据项目id，查询项目所属组织信息
     * @param projectId
     * @return
     */
    OrganizationDTO getOrganizationByProjectId(Long projectId);

    /**
     * 检查项目是否存在
     * @param projectId
     * @return 存在返回项目信息，不存在抛出not.exist exception
     */
    ProjectDTO checkNotExistAndGet(Long projectId);
}
