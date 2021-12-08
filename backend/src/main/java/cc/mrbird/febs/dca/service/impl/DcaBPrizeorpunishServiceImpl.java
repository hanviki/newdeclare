package cc.mrbird.febs.dca.service.impl;

import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.utils.SortUtil;
import cc.mrbird.febs.dca.dao.DcaBSciencepublishMapper;
import cc.mrbird.febs.dca.entity.DcaBPrizeorpunish;
import cc.mrbird.febs.dca.dao.DcaBPrizeorpunishMapper;
import cc.mrbird.febs.dca.entity.userXuhao;
import cc.mrbird.febs.dca.service.IDcaBPrizeorpunishService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cc.mrbird.febs.dca.service.IDcaBUserapplyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.util.stream.Collectors;

/**
 * <p>
 * 何时受奖励处分 服务实现类
 * </p>
 *
 * @author viki
 * @since 2020-10-20
 */
@Slf4j
@Service("IDcaBPrizeorpunishService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DcaBPrizeorpunishServiceImpl extends ServiceImpl<DcaBPrizeorpunishMapper, DcaBPrizeorpunish> implements IDcaBPrizeorpunishService {

    @Autowired
    IDcaBUserapplyService iDcaBUserapplyService;

    @Autowired
    private DcaBSciencepublishMapper dcaBSciencepublishMapper;

    @Override
    public IPage<DcaBPrizeorpunish> findDcaBPrizeorpunishs(QueryRequest request, DcaBPrizeorpunish dcaBPrizeorpunish) {
        try {
            LambdaQueryWrapper<DcaBPrizeorpunish> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(DcaBPrizeorpunish::getIsDeletemark, 1);//1是未删 0是已删

            if (StringUtils.isNotBlank(dcaBPrizeorpunish.getUserAccount())) {
                queryWrapper.and(wrap -> wrap.eq(DcaBPrizeorpunish::getUserAccount, dcaBPrizeorpunish.getUserAccount()).or()
                        .like(DcaBPrizeorpunish::getUserAccountName, dcaBPrizeorpunish.getUserAccount()));

            }
            if (StringUtils.isNotBlank(dcaBPrizeorpunish.getAuditManName())) {// 年度 和高级、中级、初级
                List<String> userAccountsList = this.iDcaBUserapplyService.getApplyAccount(dcaBPrizeorpunish.getAuditMan(), dcaBPrizeorpunish.getAuditManName());
                if (userAccountsList.size() == 0) {
                    userAccountsList.add("qiuc09");
                }
                queryWrapper.in(DcaBPrizeorpunish::getUserAccount, userAccountsList);
            }
            if (dcaBPrizeorpunish.getState() != null) {
                queryWrapper.eq(DcaBPrizeorpunish::getState, dcaBPrizeorpunish.getState());
            }
            if (dcaBPrizeorpunish.getAuditState() != null && (dcaBPrizeorpunish.getAuditState() >= 0)) {
                queryWrapper.eq(DcaBPrizeorpunish::getAuditState, dcaBPrizeorpunish.getAuditState());
            }
            if (StringUtils.isNotBlank(dcaBPrizeorpunish.getCreateTimeFrom()) && StringUtils.isNotBlank(dcaBPrizeorpunish.getCreateTimeTo())) {
                queryWrapper
                        .ge(DcaBPrizeorpunish::getCreateTime, dcaBPrizeorpunish.getCreateTimeFrom())
                        .le(DcaBPrizeorpunish::getCreateTime, dcaBPrizeorpunish.getCreateTimeTo());
            }
            if (StringUtils.isNotBlank(dcaBPrizeorpunish.getModifyTimeFrom()) && StringUtils.isNotBlank(dcaBPrizeorpunish.getModifyTimeTo())) {
                queryWrapper
                        .ge(DcaBPrizeorpunish::getModifyTime, dcaBPrizeorpunish.getModifyTimeFrom())
                        .le(DcaBPrizeorpunish::getModifyTime, dcaBPrizeorpunish.getModifyTimeTo());
            }
            if (dcaBPrizeorpunish.getAuditXuhaoS() != null && (dcaBPrizeorpunish.getAuditXuhaoS() > 0)) {
                if (dcaBPrizeorpunish.getAuditXuhaoE() == null || dcaBPrizeorpunish.getAuditXuhaoE().equals(0)) {
                    dcaBPrizeorpunish.setAuditXuhaoE(dcaBPrizeorpunish.getAuditXuhaoS());
                }
                queryWrapper.apply(" dca_b_prizeorpunish.user_account in " +
                        "(select user_account from dca_b_user where patent_ranknum" +
                        " between " + dcaBPrizeorpunish.getAuditXuhaoS() + " and" +
                        " " + dcaBPrizeorpunish.getAuditXuhaoE() + ")");
            }

            Page<DcaBPrizeorpunish> page = new Page<>();
            SortUtil.handlePageSort(request, page, false);//true 是属性  false是数据库字段可两个

            List<userXuhao> xuhaoList = this.dcaBSciencepublishMapper.getXuhao();
            IPage<DcaBPrizeorpunish> result = this.page(page, queryWrapper);
            for (DcaBPrizeorpunish item : result.getRecords()
            ) {
                List<userXuhao> list2 = xuhaoList.stream().filter(p -> p.getUserAccount().equals(item.getUserAccount())).collect(Collectors.toList());
                if (list2.size() > 0) {
                    item.setAuditXuhao(list2.get(0).getPatentRanknum());
                }
            }
            return  result;
        } catch (Exception e) {
            log.error("获取字典信息失败", e);
            return null;
        }
    }

    @Override
    public IPage<DcaBPrizeorpunish> findDcaBPrizeorpunishList(QueryRequest request, DcaBPrizeorpunish dcaBPrizeorpunish) {
        try {
            Page<DcaBPrizeorpunish> page = new Page<>();
            SortUtil.handlePageSort(request, page, false);//true 是属性  false是数据库字段可两个
            return this.baseMapper.findDcaBPrizeorpunish(page, dcaBPrizeorpunish);
        } catch (Exception e) {
            log.error("获取何时受奖励处分失败", e);
            return null;
        }
    }

    @Override
    @Transactional
    public void createDcaBPrizeorpunish(DcaBPrizeorpunish dcaBPrizeorpunish) {
        dcaBPrizeorpunish.setId(UUID.randomUUID().toString());
        dcaBPrizeorpunish.setCreateTime(new Date());
        dcaBPrizeorpunish.setIsDeletemark(1);
        this.save(dcaBPrizeorpunish);
    }

    @Override
    @Transactional
    public void updateDcaBPrizeorpunish(DcaBPrizeorpunish dcaBPrizeorpunish) {
        dcaBPrizeorpunish.setModifyTime(new Date());
        this.baseMapper.updateDcaBPrizeorpunish(dcaBPrizeorpunish);
    }

    @Override
    @Transactional
    public void deleteDcaBPrizeorpunishs(String[] Ids) {
        List<String> list = Arrays.asList(Ids);
        this.baseMapper.deleteBatchIds(list);
    }

    @Override
    @Transactional
    public void deleteByuseraccount(String userAccount) {
        this.baseMapper.deleteByAccount(userAccount);
    }

    @Override
    @Transactional
    public int getMaxDisplayIndexByuseraccount(String userAccount) {
        return this.baseMapper.getMaxDisplayIndexByuseraccount(userAccount);
    }
}