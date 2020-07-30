package io.choerodon.iam.infra.mapper;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import io.choerodon.iam.api.vo.QuickLinkVO;
import io.choerodon.iam.infra.dto.QuickLinkDTO;
import io.choerodon.mybatis.common.BaseMapper;

/**
 * 〈功能简述〉
 * 〈〉
 *
 * @author wanghao
 * @since 2020/6/11 16:08
 */
public interface QuickLinkMapper extends BaseMapper<QuickLinkDTO> {

    List<QuickLinkVO> queryByPids(@Param("projectId") Long projectId,
                                  @Param("userId") Long userId,
                                  @Param("pIds") Set<Long> pIds);

    List<QuickLinkVO> queryAll(@Param("organizationId") Long organizationId,
                               @Param("projectId") Long projectId,
                               @Param("userId") Long userId);
}