package cc.mrbird.febs.dcacopy.dao;

import cc.mrbird.febs.dcacopy.entity.DcaBCopyOtherwork;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 其他工作及成果，拟聘岗位工作思路及预期目标，个人总结 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2020-11-26
 */
public interface DcaBCopyOtherworkMapper extends BaseMapper<DcaBCopyOtherwork> {
        void updateDcaBCopyOtherwork(DcaBCopyOtherwork dcaBCopyOtherwork);
        IPage<DcaBCopyOtherwork> findDcaBCopyOtherwork(Page page, @Param("dcaBCopyOtherwork") DcaBCopyOtherwork dcaBCopyOtherwork);
        }
