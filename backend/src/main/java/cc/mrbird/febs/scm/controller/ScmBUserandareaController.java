package cc.mrbird.febs.scm.controller;

import cc.mrbird.febs.common.annotation.Log;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.domain.router.VueRouter;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.domain.QueryRequest;

import cc.mrbird.febs.scm.service.IScmBUserandareaService;
import cc.mrbird.febs.scm.entity.ScmBUserandarea;

import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.system.domain.User;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author viki
 * @since 2019-11-13
 */
@Slf4j
@Validated
@RestController
@RequestMapping("scmBUserandarea")

public class ScmBUserandareaController extends BaseController{

private String message;
@Autowired
public IScmBUserandareaService iScmBUserandareaService;


/**
 * 分页查询数据
 *
 * @param bootStrapTable  分页信息
 * @param scmBUserandarea 查询条件
 * @return
 */
@GetMapping
@RequiresPermissions("scmBUserandarea:view")
public Map<String, Object> List(QueryRequest request, ScmBUserandarea scmBUserandarea){
        return getDataTable(this.iScmBUserandareaService.findScmBUserandareas(request, scmBUserandarea));
        }

/**
 * 跳转添加页面
 * @param request
 * @param response
 * @param model
 * @return
 */
@Log("新增/按钮")
@PostMapping
@RequiresPermissions("scmBUserandarea:add")
public void addScmBUserandarea(@Valid ScmBUserandarea scmBUserandarea)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
        scmBUserandarea.setCreateUserId(currentUser.getUserId());
        this.iScmBUserandareaService.createScmBUserandarea(scmBUserandarea);
        }catch(Exception e){
        message="新增/按钮失败" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }

/**
 * 跳转修改页面
 * @param request
 * @param id  实体ID
 * @return
 */
@Log("修改")
@PutMapping
@RequiresPermissions("scmBUserandarea:update")
public void updateScmBUserandarea(@Valid ScmBUserandarea scmBUserandarea)throws FebsException{
        try{
        User currentUser= FebsUtil.getCurrentUser();
      scmBUserandarea.setModifyUserId(currentUser.getUserId());
        this.iScmBUserandareaService.updateScmBUserandarea(scmBUserandarea);
        }catch(Exception e){
        message="修改成功" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }


@Log("删除")
@DeleteMapping("/{ids}")
@RequiresPermissions("scmBUserandarea:delete")
public void deleteScmBUserandareas(@NotBlank(message = "{required}") @PathVariable String ids)throws FebsException{
        try{
        String[]arr_ids=ids.split(StringPool.COMMA);
        this.iScmBUserandareaService.deleteScmBUserandareas(arr_ids);
        }catch(Exception e){
        message="删除成功" ;
        log.error(message,e);
        throw new FebsException(message);
        }
        }
@PostMapping("excel")
@RequiresPermissions("scmBUserandarea:export")
public void export(QueryRequest request, ScmBUserandarea scmBUserandarea, HttpServletResponse response) throws FebsException {
        try {
        List<ScmBUserandarea> scmBUserandareas = this.iScmBUserandareaService.findScmBUserandareas(request, scmBUserandarea).getRecords();
        ExcelKit.$Export(ScmBUserandarea.class, response).downXlsx(scmBUserandareas, false);
        } catch (Exception e) {
        message = "导出Excel失败";
        log.error(message, e);
        throw new FebsException(message);
        }
        }

@GetMapping("/{id}")
public ScmBUserandarea detail(@NotBlank(message = "{required}") @PathVariable String id) {
    ScmBUserandarea scmBUserandarea=this.iScmBUserandareaService.getById(id);
        return scmBUserandarea;
        }
        }