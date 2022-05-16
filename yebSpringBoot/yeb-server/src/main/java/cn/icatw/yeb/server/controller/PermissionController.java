package cn.icatw.yeb.server.controller;

import cn.icatw.yeb.server.common.R;
import cn.icatw.yeb.server.domain.Menu;
import cn.icatw.yeb.server.domain.MenuRole;
import cn.icatw.yeb.server.domain.Role;
import cn.icatw.yeb.server.service.MenuRoleService;
import cn.icatw.yeb.server.service.MenuService;
import cn.icatw.yeb.server.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限控制器
 *
 * @author icatw
 * @date 2022/5/12
 * @email 762188827@qq.com
 * @apiNote
 */
@Api(tags = "权限组模块")
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {
    @Autowired
    private RoleService roleService;
    @Autowired
    MenuService menuService;
    @Autowired
    MenuRoleService menuRoleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles() {
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public R addRole(@RequestBody Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        if (roleService.save(role)) {
            return R.ok("添加成功！", "");
        }
        return R.fail("添加失败！");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public R delRole(@PathVariable Integer rid) {
        if (roleService.removeById(rid)) {
            return R.ok("删除成功！", "");
        }
        return R.fail("删除失败！");
    }

    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid) {
        List<MenuRole> menuRoleList = menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid", rid));
        //stream流转为id菜单
        List<Integer> list = menuRoleList.stream().map(MenuRole::getMid).collect(Collectors.toList());
        return list;
    }

    @ApiOperation(value = "更新角色菜单")
    @PutMapping("/")
    public R updateMenuRole(Integer rid, Integer[] mids) {
        return menuRoleService.updateMenuRole(rid, mids);
    }
}
