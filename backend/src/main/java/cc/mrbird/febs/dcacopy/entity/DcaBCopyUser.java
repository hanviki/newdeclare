package cc.mrbird.febs.dcacopy.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import cc.mrbird.febs.common.converter.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author viki
 * @since 2020-12-25
 */

@Excel("dca_b_copy_user")
@Data
@Accessors(chain = true)
public class DcaBCopyUser implements Serializable{

private static final long serialVersionUID=1L;

    /**
     * 主键
     */
                            
        @ExcelField(value ="主键")
    private String id;

    /**
     * 姓名
     */
        
        @ExcelField(value ="姓名")
    private String userAccountName;

    /**
     * 人事编号
     */
        
        @ExcelField(value ="人事编号")
    private String userAccount;

    /**
     * 科室
     */
        
        @ExcelField(value ="科室")
    private String ks;

    /**
     * 系列
     */
        
        @ExcelField(value ="系列")
    private String xl;

    /**
     * 手机号
     */
        
        @ExcelField(value ="手机号")
    private String telephone;

    /**
     * 所在院系
     */
        
        @ExcelField(value ="所在院系")
    private String deptName;

    /**
     * 现岗位职务
     */
        
        @ExcelField(value ="现岗位职务")
    private String positionName;
    public String getPositionName(){
        return  (zyjsgw==null?"":zyjsgw)+(zyjsgwLc==null?"":zyjsgwLc);
    }
    /**
     * 拟聘岗位职务
     */
        
        @ExcelField(value ="拟聘岗位职务")
    private String npPositionName;

    /**
     * 性别
     */
        
        @ExcelField(value ="性别")
    private String sexName;

    /**
     * 出生年月
     */
        
        @ExcelField(value ="出生年月", writeConverter = DateConverter.class)
    private Date birthday;
    private transient String birthdayFrom;
    private transient String birthdayTo;

    /**
     * 来校工作时间
     */
        
        @ExcelField(value ="来校工作时间", writeConverter = DateConverter.class)
    private Date schoolDate;
    private transient String schoolDateFrom;
    private transient String schoolDateTo;

    /**
     * 现专业技术岗位
     */
        
        @ExcelField(value ="现专业技术岗位")
    private String zyjsgw;

    /**
     * 现专业技术岗位（临床）
     */
        
        @ExcelField(value ="现专业技术岗位（临床）")
    private String zyjsgwLc;

    /**
     * 现从事专业及专长
     */
        
        @ExcelField(value ="现从事专业及专长")
    private String xcszyjzc;

    /**
     * 聘任时间
     */
        
        @ExcelField(value ="聘任时间", writeConverter = DateConverter.class)
    private Date appointedDate;
    private transient String appointedDateFrom;
    private transient String appointedDateTo;

    /**
     * 本人排名
     */
        
        @ExcelField(value ="本人排名")
    private Integer patentRanknum;

    /**
     * 是否授权
     */
        
        @ExcelField(value ="是否授权")
    private String isAuthority;

    /**
     * 附件
     */
        
        @ExcelField(value ="附件")
    private String fileId;

    /**
     * 是否转让
     */
        
        @ExcelField(value ="是否转让")
    private String isZhuanrang;

    /**
     * 附件地址
     */
        
        @ExcelField(value ="附件地址")
    private String fileUrl;

    @ExcelField(value ="职位职级")
    private String staffGrade;
    @ExcelField(value ="职位聘任时间")
    private String staffDate;

    @ExcelField(value ="照片id")
    private String pictureId;
    @ExcelField(value ="照片地址")
    private String pictureUrl;

    /**
     * 转让效益
     */
        
        @ExcelField(value ="转让效益")
    private String patentGood;

    /**
     * 状态
     */
        
        @ExcelField(value ="状态")
    private Integer state;

    /**
     * 是否删除
     */
    @TableField("IS_DELETEMARK")
        
        @ExcelField(value ="是否删除")
    private Integer isDeletemark;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
        
        @ExcelField(value ="创建时间", writeConverter = DateConverter.class)
    private Date createTime;
    private transient String createTimeFrom;
    private transient String createTimeTo;

    /**
     * 排序
     */
        
        @ExcelField(value ="排序")
    private Integer displayIndex;

    /**
     * 修改时间
     */
    @TableField("MODIFY_TIME")
        
        @ExcelField(value ="修改时间", writeConverter = DateConverter.class)
    private Date modifyTime;
    private transient String modifyTimeFrom;
    private transient String modifyTimeTo;

    /**
     * 创建人
     */
    @TableField("CREATE_USER_ID")
        
        @ExcelField(value ="创建人")
    private Long createUserId;

    /**
     * 修改人
     */
    @TableField("MODIFY_USER_ID")
        
        @ExcelField(value ="修改人")
    private Long modifyUserId;

    /**
     * 审核人
     */
    @TableField("auditMan")
        
        @ExcelField(value ="审核人")
    private String auditMan;

    /**
     * 审核人姓名
     */
    @TableField("auditManName")
        
        @ExcelField(value ="审核人姓名")
    private String auditManName;

    /**
     * 审核时间
     */
    @TableField("auditDate")
        
        @ExcelField(value ="审核时间", writeConverter = DateConverter.class)
    private Date auditDate;
    private transient String auditDateFrom;
    private transient String auditDateTo;

    /**
     * 审核意见
     */
    @TableField("auditSuggestion")
        
        @ExcelField(value ="审核意见")
    private String auditSuggestion;

    /**
     * 是否用于本次评审
     */
    @TableField("IsUse")
        
        @ExcelField(value ="是否用于本次评审")
    private Boolean IsUse;

    /**
     * 聘任时间（临床）
     */
        
        @ExcelField(value ="聘任时间（临床）", writeConverter = DateConverter.class)
    private Date appointedDateLc;
    private transient String appointedDateLcFrom;
    private transient String appointedDateLcTo;

    /**
     * 附件（临床）
     */
        
        @ExcelField(value ="附件（临床）")
    private String fileIdLc;

    /**
     * 附件地址（临床）
     */
        
        @ExcelField(value ="附件地址（临床）")
    private String fileUrlLc;

    private transient  String zygwDate;

    public String getZygwDate(){
        String na="";
        try {
            if (appointedDate != null) {
                na=  DateUtil.format(appointedDate, "yyyy-MM-dd");
            }
            if (appointedDateLc != null) {
                na+= (na==""?"":"/")+ DateUtil.format(appointedDateLc, "yyyy-MM-dd");
            }
        }catch (Exception ex) {

        }
        return  na;
    }
    /**
     * 岗位等级
     */
    @ExcelField(value ="岗位等级")
    private String gwdj;



    /**
     * 员工组
     */
        
        @ExcelField(value ="员工组")
    private String yuangongzu;

    /**
     * 现任岗位级别
     */
        
        @ExcelField(value ="现任岗位级别")
    private String xrgwjb;

    /**
     * 现任岗位级别聘任时间
     */
        
        @ExcelField(value ="现任岗位级别聘任时间", writeConverter = DateConverter.class)
    private Date xrgwjbprsj;
    private transient String xrgwjbprsjFrom;
    private transient String xrgwjbprsjTo;

    /**
     * 担(兼)任党政职务
     */
        
        @ExcelField(value ="担(兼)任党政职务")
    private String djrdzzw;

        
    private String dcaYear;

    /**
     * 是否通过初级考核
     */
        
        @ExcelField(value ="是否通过初级考核")
    private Boolean isChujikh;

    /**
     * 通过初级考核时间
     */
        
        @ExcelField(value ="通过初级考核时间", writeConverter = DateConverter.class)
    private Date chujikhDate;
    private transient String chujikhDateFrom;
    private transient String chujikhDateTo;

    /**
     * 是否通过中级考核
     */
        
        @ExcelField(value ="是否通过中级考核")
    private Boolean isZhongjikh;

    /**
     * 通过中级考核时间
     */
        
        @ExcelField(value ="通过中级考核时间", writeConverter = DateConverter.class)
    private Date zhongjikhDate;
    private transient String zhongjikhDateFrom;
    private transient String zhongjikhDateTo;

    /**
     * 政治面貌
     */
        
        @ExcelField(value ="政治面貌")
    private String politicalStatus;

    /**
     * 身份证号
     */
        
        @ExcelField(value ="身份证号")
    private String idCard;



    public static final String ID ="id" ;

    public static final String USER_ACCOUNT_NAME ="user_account_name" ;

    public static final String USER_ACCOUNT ="user_account" ;

    public static final String KS ="ks" ;

    public static final String XL ="xl" ;

    public static final String TELEPHONE ="telephone" ;

    public static final String DEPT_NAME ="dept_name" ;

    public static final String POSITION_NAME ="position_name" ;

    public static final String NP_POSITION_NAME ="np_position_name" ;

    public static final String SEX_NAME ="sex_name" ;

    public static final String BIRTHDAY ="birthday" ;

    public static final String SCHOOL_DATE ="school_date" ;

    public static final String ZYJSGW ="zyjsgw" ;

    public static final String ZYJSGW_LC ="zyjsgw_lc" ;

    public static final String XCSZYJZC ="xcszyjzc" ;

    public static final String APPOINTED_DATE ="appointed_date" ;

    public static final String PATENT_RANKNUM ="patent_ranknum" ;

    public static final String IS_AUTHORITY ="is_authority" ;

    public static final String FILE_ID ="file_id" ;

    public static final String IS_ZHUANRANG ="is_zhuanrang" ;

    public static final String FILE_URL ="file_url" ;

    public static final String PATENT_GOOD ="patent_good" ;

    public static final String STATE ="state" ;

    public static final String IS_DELETEMARK ="IS_DELETEMARK" ;

    public static final String CREATE_TIME ="CREATE_TIME" ;

    public static final String DISPLAY_INDEX ="display_index" ;

    public static final String MODIFY_TIME ="MODIFY_TIME" ;

    public static final String CREATE_USER_ID ="CREATE_USER_ID" ;

    public static final String MODIFY_USER_ID ="MODIFY_USER_ID" ;

    public static final String AUDITMAN ="auditMan" ;

    public static final String AUDITMANNAME ="auditManName" ;

    public static final String AUDITDATE ="auditDate" ;

    public static final String AUDITSUGGESTION ="auditSuggestion" ;

    public static final String ISUSE ="IsUse" ;

    public static final String APPOINTED_DATE_LC ="appointed_date_lc" ;

    public static final String FILE_ID_LC ="file_id_lc" ;

    public static final String FILE_URL_LC ="file_url_lc" ;

    public static final String YUANGONGZU ="yuangongzu" ;

    public static final String XRGWJB ="xrgwjb" ;

    public static final String XRGWJBPRSJ ="xrgwjbprsj" ;

    public static final String DJRDZZW ="djrdzzw" ;

    public static final String DCA_YEAR ="dca_year" ;

    public static final String IS_CHUJIKH ="is_chujikh" ;

    public static final String CHUJIKH_DATE ="chujikh_date" ;

    public static final String IS_ZHONGJIKH ="is_zhongjikh" ;

    public static final String ZHONGJIKH_DATE ="zhongjikh_date" ;

    public static final String POLITICAL_STATUS ="political_status" ;

    public static final String ID_CARD ="id_card" ;

        }