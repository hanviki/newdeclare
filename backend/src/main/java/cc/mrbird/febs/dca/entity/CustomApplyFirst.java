package cc.mrbird.febs.dca.entity;

import cc.mrbird.febs.dcacopy.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class CustomApplyFirst {
    /**
     * 姓名
     */
    private String name;

    private String tel;

    private String picUrl;

    /**
     * 顺序号
     */
    private  String confirmIndex;

    /**
     *  人事编号
     */
    private String rsbh;

    /**
     * 所在院系
     */
    private String szyx;

    /**
     * 现岗位职务
     */
  private  String xgwzw;

    /**
     * 拟聘岗位
     */
    private  String npgw;

    /**
     * 岗位类别
     */
    private  String gwlb;

    /**
     * 教师资格证编号及获得时间
     */
    private String jszgzbhjhdsj;

    /**
     * 担任辅导员教师班主任及考核情况
     */
    private String  drfdyjsbzrjkhqk;
    /**
     * 完成上一聘期工作任务情况
     */

    private  String wcsypqgzrwqk;
    /**
     * 拟聘岗位职务
     */
    private  String npgwzw;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生年月
     */
   private String birthday;

    /**
     * 现专业技术岗位
     */
    private  String xzyjsgw;

    /**
     * 聘任时间
     */
    private String prsj;

    /**
     * 来校工作时间
     */
    private String lxgzsj;

    /**
     * 现岗位级别
     */
    private String xrgwjb;
    /**
     * 现岗位级别聘任时间
     */
    private String xrgwjbprsj;

    /**
     *担(兼)任党政职务
     */
    private String djrdzzw;

    /**
     * 现从事专业及专长
     */
    private String xcszyjzc;



    /**
     * 社会兼职
     */
    private String shjz;

    private List<DcaBCopyParttimejob> dcaBParttimejobList;
    private List<DcaBCopyTeacherqualify> dcaBCopyTeacherqualifyList;
    private List<DcaBCopyTurtor> dcaBTurtorList;

    /**
     * 何时何地受奖励及处分
     */
    private String hshdshjljcf;
    private  List<DcaBCopyPrizeorpunish> dcaBPrizeorpunishList;

    /**
     * 考核百分比
     */
    private String khpecentage;

    /**
     * 近5年考核情况
     */
    private String j5nkhqk;

    /**
     * 近3年考核情况
     */
    private String j3nkhqk;

    /**
     * 主要学习及工作经历
     */
    private List<DcaBCopyEducationexperice> dcaBEducationexpericeList;

    /**
     * 个人细想政治及师德师风表现情况
     */
    private String grsxzzjsdsf;

    /**
     * 申报拟聘岗位理由
     */
private  String sbnpgwly;

    /**
     * 其他工作及成果
     */
    private String qtgzjcg;

    /**
     * 拟聘岗位工作思路及预期目标
     */
    private String npgwgzsljyqmb;
    /**
     * 任现职以来完成教学、人才培养情况
     */
private List<DcaBCopyEmploy> dcaBCopyEmployList;

/**
 * 任职以来发表的论文、出版著作和教材
 */
private  List<DcaBCopyEssaypublish> dcaBEssaypublishList;

    /**
     * 任现职以来承担的主要科研项目
     */
    private List<DcaBCopySciencesearch> dcaBSciencesearchList;

    /**
     * 任现职以来科研获奖情况
     */
    private List<DcaBCopyScientificprize> dcaBScientificprizeList;

    /**
     * 任现职以来完成研究生教学、人才培养情况
     */
    private  List<DcaBCopyTalent> dcaBTalentList;

    /**
     * 任现职以来申请专利情况
     */
    private List<DcaBCopyPatent> dcaBPatentList;

    /**
     * 任现职以来独立指导研究生情况
     */
    private  DcaBCopyGraduate dcaBGraduate;

    private List<DcaBCopyGraduate> dcaBCopyGraduateList;

    /**
     * 完成本科教学情况
     */
    private  List<DcaBCopyUndergraduate> dcaBUndergraduateList;

    /**
     * 任现职以来发表的教学论文、出版教材
     */
    private List<DcaBCopyPaperspublish> dcaBPaperspublishList;

    /**
     * 任现职以来发表的科研论文、出版著作等
     */
    private List<DcaBCopySciencepublish> dcaBSciencepublishList;

    /**
     * 任现职以来发表的科研论文、出版著作等
     */
    private List<DcaBCopyPublicarticle> dcaBPublicarticleList;
    private List<DcaBCopyAttachfile> dcaBAttachfileList;

    private  List<DcaBCopyExportcountry> dcaBExportcountryList;
    private  List<DcaBCopyTeacherprize> dcaBTeacherprizeList;
    private  List<DcaBCopySchoolprize> dcaBSchoolprizeList;
    private  List<DcaBCopyCourseclass> dcaBCourseclassList;
    private  List<DcaBCopyYoungprize> dcaBYoungprizeList;

    /**
     * 任现职以来本科教学工作获奖
     */
    private List<DcaBCopyUndergraduateprize> dcaBUndergraduateprizeList;


    /**
     * 本科教学改革及建设项目
     */
    private  List<DcaBCopyInnovatebuild> dcaBInnovatebuildList;

    /**
     * 学术
     */
    private  List<DcaBCopyAcademic> dcaBCopyAcademicList;

    /**
     * 医疗业绩
     */
    private  List<DcaBCopyAchievement> dcaBCopyAchievementList;

    /**
     * 医疗事故
     */
    private List<DcaBCopyMedicalaccident> dcaBCopyMedicalaccidentList;

    /**
     * 博士导师硕士导师
     */
    private List<DcaBCopyDoctorturtor> dcaBCopyDoctorturtorList;

    /**
     * 个人总结
     */
    private  String grzj;

    private String ks;

    /**
     * 代表性表述
     */
    private String dbxcgbs;

}
