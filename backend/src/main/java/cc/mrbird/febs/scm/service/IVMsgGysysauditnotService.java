package cc.mrbird.febs.scm.service;

import cc.mrbird.febs.scm.entity.VMsgGysysauditnot;
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
 * @since 2020-05-12
 */
public interface IVMsgGysysauditnotService extends IService<VMsgGysysauditnot> {

        List<VMsgGysysauditnot> GetMsg();
        }
