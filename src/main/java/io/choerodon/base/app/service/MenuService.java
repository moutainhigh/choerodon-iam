package io.choerodon.base.app.service;


import io.choerodon.base.infra.dto.MenuDTO;

import java.util.List;

/**
 * @author wuguokai
 * @author superlee
 * @date 2018-04-10
 */
public interface MenuService {
    /**
     * 根据id查询菜单
     *
     * @param id
     * @return
     */
    MenuDTO query(Long id);

    void check(MenuDTO menu);

    /**
     * 查询当前登录用户可以查看的菜单
     *
     * @param code 顶级菜单的code
     * @param sourceId site和user为0，project和organization是对应的id
     * @return
     */
    MenuDTO menus(String code, Long sourceId);

    /**
     * 菜单配置界面根据层级查询树形菜单，菜单下包含权限信息
     *
     * @param code
     * @return
     */
    MenuDTO menuConfig(String code);

    /**
     * 根据前端传入的树形菜单，更新后端的树形结构
     *
     * @param code
     * @param menus
     */
    void saveMenuConfig(String code, List<MenuDTO> menus);

    /**
     * 查询所有菜单
     * @return
     */
    List<MenuDTO> list();

}
