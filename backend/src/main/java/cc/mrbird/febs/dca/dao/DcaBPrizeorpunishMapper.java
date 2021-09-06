package cc.mrbird.febs.dca.dao;

import cc.mrbird.febs.dca.entity.DcaBPrizeorpunish;
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
 * @since 2020-10-20
 */
public interface DcaBPrizeorpunishMapper extends BaseMapper<DcaBPrizeorpunish> {
        void updateDcaBPrizeorpunish(DcaBPrizeorpunish dcaBPrizeorpunish);
        IPage<DcaBPrizeorpunish> findDcaBPrizeorpunish(Page page, @Param("dcaBPrizeorpunish") DcaBPrizeorpunish dcaBPrizeorpunish);

@Update(" update dca_b_prizeorpunish set IS_DELETEMARK=0 where user_account=#{useraccount}  and (state=0 or state=2)")
        void deleteByAccount(@Param("useraccount") String useraccount);
@Select(" select IFNULL(max(display_index),0) As maxIndex from  dca_b_prizeorpunish  where user_account=#{useraccount} ")
        int getMaxDisplayIndexByuseraccount(@Param("useraccount") String useraccount);
        }
