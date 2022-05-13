package cn.icatw.yeb.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.icatw.yeb.server.domain.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Admin)表数据库访问层
 *
 * @author icatw
 * @since 2022-05-11 16:38:32
 */
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 得到所有管理员
     *
     * @param id       id
     * @param keywords 关键字
     * @return {@link List}<{@link Admin}>
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}

