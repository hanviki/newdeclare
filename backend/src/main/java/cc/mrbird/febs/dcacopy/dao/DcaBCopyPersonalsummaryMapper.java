package cc.mrbird.febs.dcacopy.dao;

import cc.mrbird.febs.dcacopy.entity.DcaBCopyPersonalsummary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 个人总结 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2020-11-26
 */
public interface DcaBCopyPersonalsummaryMapper extends BaseMapper<DcaBCopyPersonalsummary> {
        void updateDcaBCopyPersonalsummary(DcaBCopyPersonalsummary dcaBCopyPersonalsummary);
        IPage<DcaBCopyPersonalsummary> findDcaBCopyPersonalsummary(Page page, @Param("dcaBCopyPersonalsummary") DcaBCopyPersonalsummary dcaBCopyPersonalsummary);
        }
