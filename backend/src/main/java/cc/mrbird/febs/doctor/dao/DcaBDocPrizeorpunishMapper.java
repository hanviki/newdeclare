package cc.mrbird.febs.doctor.dao;

import cc.mrbird.febs.doctor.entity.DcaBDocPrizeorpunish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 何时受奖励处分 Mapper 接口
 * </p>
 *
 * @author viki
 * @since 2021-01-11
 */
public interface DcaBDocPrizeorpunishMapper extends BaseMapper<DcaBDocPrizeorpunish> {
        void updateDcaBDocPrizeorpunish(DcaBDocPrizeorpunish dcaBDocPrizeorpunish);
        IPage<DcaBDocPrizeorpunish> findDcaBDocPrizeorpunish(Page page, @Param("dcaBDocPrizeorpunish") DcaBDocPrizeorpunish dcaBDocPrizeorpunish);

@Update(" update dca_b_doc_prizeorpunish set IS_DELETEMARK=0 where user_account=#{useraccount}  and (state=0 or state=2)")
        void deleteByAccount(@Param("useraccount") String useraccount);
@Select(" select IFNULL(max(display_index),0) As maxIndex from  dca_b_doc_prizeorpunish  where user_account=#{useraccount} ")
        int getMaxDisplayIndexByuseraccount(@Param("useraccount") String useraccount);
        }
