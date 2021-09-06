package cc.mrbird.febs.scm.service;

import cc.mrbird.febs.scm.entity.VMsgMaterinfovalid;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cc.mrbird.febs.common.domain.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author viki
 * @since 2020-04-09
 */
public interface IVMsgMaterinfovalidService extends IService<VMsgMaterinfovalid> {

        List<VMsgMaterinfovalid> GetMsgFileValid();
        }
