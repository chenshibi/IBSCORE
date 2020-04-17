package com.huateng.report.pboc.service;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

/**
 * @author YiSiliang
 * @date 2019/1/4 14:05
 * @editor qx
 * @date 2019/5/22 15:35
 * 个人征信报告
 */
@Service
public class PbocQueryService {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PbocQueryService.class);

    public static PbocQueryService getInstance() {
        return ApplicationContextUtils.getBean(PbocQueryService.class);
    }

    public Map<String, Object> getPersonalReport(String uuid) {
    	Map<String, Object> map = new HashMap();
        map.put("uuid", uuid);
        try {
            HQLDAO hqldao = ROOTDAOUtils.getHQLDAO();
            String[] objArg = new String[]{uuid};
            List list = null;
//          报告编号 报告时间 被查询者姓名 被查询者证件类型 被查询者证件号码 查询机构代码 查询原因代码
//          防欺诈警示标志 防欺诈警示联系电话 防欺诈警示生效日期 防欺诈警示截止日期 异议标注数目
          list = hqldao.queryBySQL2List("select PA01AI01,PA01AR01,PA01BQ01,PA01BD01,PA01BI01,PA01BI02,PA01BD02,PA01DQ01,PA01DQ02,PA01DR01,PA01DR02,PA01ES01" +
                  " from CR_PER_PRH where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PRH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//          证件类型 证件号码
          list = hqldao.queryBySQL2List("select PA01CD01,PA01CI01" +
                  " from CR_PER_PA01CH where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PA01CH", isNotEmpty(list) ? list : (new ArrayList()));
//          性别 出生日期 学历 学位 就业状况 电子邮箱 通讯地址 国籍 户籍地址
          list = hqldao.queryBySQL2List("select PB01AD01,PB01AR01,PB01AD02,PB01AD03,PB01AD04,PB01AQ01,PB01AQ02,PB01AD05,PB01AQ03" +
                  " from CR_PER_PIM where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PIM", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//          手机号码 信息更新日期
          list = hqldao.queryBySQL2List("select PB01BQ01,PB01BR01" +
                  " from CR_PER_PB01BH where BATCH_ID = ? order by PB01BR01 desc ", objArg, null);
          map.put("CR_PER_PB01BH", isNotEmpty(list) ? list : (new ArrayList()));
//          婚姻状况 配偶姓名 配偶证件类型 配偶证件号码 配偶工作单位 配偶联系电话
          list = hqldao.queryBySQL2List("select PB020D01,PB020Q01,PB020D02,PB020I01,PB020Q02,PB020Q03" +
                  " from CR_PER_PMM where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PMM", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//          居住状况 居住地址 住宅电话 信息更新日期
          list = hqldao.queryBySQL2List("select a.PB030D01,a.PB030Q01,a.PB030Q02,a.PB030R01" +
                  " from CR_PER_PRM a where a.BATCH_ID = ? order by a.PB030R01  desc ", objArg, null);
          map.put("CR_PER_PRM", isNotEmpty(list) ? list : (new ArrayList()));
//          就业状况 工作单位 单位性质 行业 单位地址 单位电话 职业 职务 职称 进入本单位年份 信息更新日期
          list = hqldao.queryBySQL2List("select PB040D01,PB040Q01,PB040D02,PB040D03,PB040Q02,PB040Q03,PB040D04,PB040D05,PB040D06,PB040R01,PB040R02" +
                  " from CR_PER_POM where BATCH_ID = ? order by PB040R02 desc ", objArg, null);
          map.put("CR_PER_POM", isNotEmpty(list) ? list : (new ArrayList()));
//          数字解读 相对位置 分数说明条数 分数说明
          list = hqldao.queryBySQL2List("SELECT * FROM CR_PER_PSM" +
                  "  where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PSM", isNotEmpty(list) ? list : (new ArrayList())); 
          map.put("CR_PER_PSM_0",  isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          /**
           * 根据条数自动变行
           */
          /*list = hqldao.queryBySQL2List("select PC010Q01,PC010Q02,PC010S01,PC010D01" +
                  " from CR_PER_PSM where BATCH_ID = ? ", objArg, null);
          //sl 添加 PSM_PC010D01_into_List
          PSM_PC010D01_into_List(list,"PC010D01");
          map.put("CR_PER_PSM",  isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());*/
          
//          信贷交易提示信息账户数合计 被追偿汇总信息账户数合计 被追偿汇总信息余额合计 呆账汇总信息账户数 呆账汇总信息余额
//          非循环贷账户管理机构数 非循环贷账户账户数 非循环贷账户授信总额 非循环贷账户贷余额 循环贷账户最近 6 个月平均应还款
//          循环额度下分账户管理机构数 循环额度下分账户账户数 循环额度下分账户授信总额 循环额度下分账户余额 循环额度下分账户最近 6 个月平均应还款
//          循环贷账户管理机构数 循环贷账户账户数 循环贷账户授信总额 循环贷账户余额 循环贷账户最近6 个月平均应还款
//          贷记卡账户发卡机构数 贷记卡账户账户数 贷记卡账户授信总额 贷记卡账户单家行最高授信额 贷记卡账户单家行最低授信额 贷记卡账户已用额度 贷记卡账户最近 6 个月平均使用额度
//          准贷记卡账户发卡机构数 准贷记卡账户账户数 准贷记卡账户授信总额 准贷记卡账户单家行最高授信额 准贷记卡账户单家行最低授信额 准贷记卡账户透支余额 准贷记卡账户最近 6 个月平均透支余额
          list = hqldao.queryBySQL2List("select PC02BS02,PC02AS01,PC02BS01,PC02BJ01,PC02CS01,PC02CJ01,PC02ES01,PC02ES02,PC02EJ01,PC02EJ02,PC02EJ03," +
                  "PC02FS01,PC02FS02,PC02FJ01,PC02FJ02,PC02FJ03,PC02GS01,PC02GS02,PC02GJ01,PC02GJ02,PC02GJ03," +
                  "PC02HS01,PC02HS02,PC02HJ01,PC02HJ02,PC02HJ03,PC02HJ04,PC02HJ05,PC02IS01,PC02IS02,PC02IJ01,PC02IJ02,PC02IJ03,PC02IJ04,PC02IJ05" +
                  " from CR_PER_PCO where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PCO", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//          业务类型 业务大类 账户数 首笔业务发放月份
          /*list = hqldao.queryBySQL2List("select PC02AD01,PC02AD02,PC02AS03,PC02AR01" +
                  " from CR_PER_PC02AH where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PC02AH", isNotEmpty(list) ? list : (new ArrayList()));*/

        list = hqldao.queryBySQL2List("select PC02AD02,PC02AD01,PC02AS03,PC02AR01" +
                " from CR_PER_PC02AH where BATCH_ID = ? " +
                " order by PC02AD02", objArg, null);
        list = CR_PER_PC02AH1_into_List(list,"PC02AD02","PC02AD01","PC02AS03","PC02AR01");
        map.put("CR_PER_PC02AH", isNotEmpty(list) ? list : (new ArrayList()));
          
          
       // 贷款_个人住房贷款  账户数 首笔业务发放月份
          list = hqldao.queryBySQL2List("SELECT PC02AS03,PC02AR01 from CR_PER_PC02AH where PC02AD02 = '1' and PC02AD01 = '11' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02AH_1_11", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 贷款_个人商用房贷款（包括商住两用房）  账户数 首笔业务发放月份
          list = hqldao.queryBySQL2List("SELECT PC02AS03,PC02AR01 from CR_PER_PC02AH where PC02AD02 = '1' and PC02AD01 = '12' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02AH_1_12", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 贷款_其他类贷款  账户数 首笔业务发放月份
          list = hqldao.queryBySQL2List("SELECT PC02AS03,PC02AR01 from CR_PER_PC02AH where PC02AD02 = '1' and PC02AD01 = '19' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02AH_1_19", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 信用卡_贷记卡  账户数 首笔业务发放月份
          list = hqldao.queryBySQL2List("SELECT PC02AS03,PC02AR01 from CR_PER_PC02AH where PC02AD02 = '2' and PC02AD01 = '21' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02AH_2_21", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 信用卡_准贷记卡  账户数 首笔业务发放月份
          list = hqldao.queryBySQL2List("SELECT PC02AS03,PC02AR01 from CR_PER_PC02AH where PC02AD02 = '2' and PC02AD01 = '22' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02AH_2_22", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 其他_其他  账户数 首笔业务发放月份
          list = hqldao.queryBySQL2List("SELECT PC02AS03,PC02AR01 from CR_PER_PC02AH where PC02AD02 = '9' and PC02AD01 = '99' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02AH_9_99", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          
       /*被追偿信息汇总*/
//          业务类型 账户数 余额CR_PER_PDA
          list = hqldao.queryBySQL2List("select PC02BD01,PC02BS03,PC02BJ02" +
                  " from CR_PER_PC02BH where BATCH_ID = ? ", objArg, null);
          //map.put("CR_PER_PC02BH",isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          map.put("CR_PER_PC02BH", isNotEmpty(list) ? list : (new ArrayList()));
          
          // 1-资产处置业务   账户数 余额
          list = hqldao.queryBySQL2List("SELECT PC02BS03,PC02BJ02 from CR_PER_PC02BH where PC02BD01 = '1'  and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02BH_1", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
       
          // 2-垫款业务   账户数 余额
          list = hqldao.queryBySQL2List("SELECT PC02BS03,PC02BJ02 from CR_PER_PC02BH where PC02BD01 = '2'  and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02BH_2", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       /*逾期（透支）信息汇总*/
//          账户类型 账户数 月份数 单月最高逾期（透支）总额 最长逾期（透支）月数
          list = hqldao.queryBySQL2List("select PC02DD01,PC02DS02,PC02DS03,PC02DJ01,PC02DS04" +
                  " from CR_PER_PC02DH where BATCH_ID = ? ", objArg, null);
          //map.put("CR_PER_PC02DH",isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          map.put("CR_PER_PC02DH", isNotEmpty(list) ? list : (new ArrayList()));
          
       // 1-非循环贷账户  账户数 月份数 单月最高逾期（透支）总额 最长逾期（透支）
          list = hqldao.queryBySQL2List("SELECT PC02DS02,PC02DS03,PC02DJ01,PC02DS04 from CR_PER_PC02DH where PC02DD01 = '1' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02DH_1", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 2-循环额度下分账户  账户数 月份数 单月最高逾期（透支）总额 最长逾期（透支）
          list = hqldao.queryBySQL2List("SELECT PC02DS02,PC02DS03,PC02DJ01,PC02DS04 from CR_PER_PC02DH where PC02DD01 = '2' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02DH_2", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 3-循环贷账户  账户数 月份数 单月最高逾期（透支）总额 最长逾期（透支）
          list = hqldao.queryBySQL2List("SELECT PC02DS02,PC02DS03,PC02DJ01,PC02DS04 from CR_PER_PC02DH where PC02DD01 = '3' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02DH_3", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 4-贷记卡账户  账户数 月份数 单月最高逾期（透支）总额 最长逾期（透支）
          list = hqldao.queryBySQL2List("SELECT PC02DS02,PC02DS03,PC02DJ01,PC02DS04 from CR_PER_PC02DH where PC02DD01 = '4' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02DH_4", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
       // 5-准贷记卡账户  账户数 月份数 单月最高逾期（透支）总额 最长逾期（透支）
          list = hqldao.queryBySQL2List("SELECT PC02DS02,PC02DS03,PC02DJ01,PC02DS04 from CR_PER_PC02DH where PC02DD01 = '5' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02DH_5", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          /*相关还款责任信息汇总*/
//          借款人身份类别 还款责任类型 账户数 还款责任金额 余额
          list = hqldao.queryBySQL2List("select PC02KD01,PC02KD02,PC02KS02,PC02KJ01,PC02KJ02" +
                  " from CR_PER_PC02KH where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PC02KH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
       
          // 1-自然人_1-担保责任  账户数 还款责任金额 余额
          list = hqldao.queryBySQL2List("SELECT PC02KS02,PC02KJ01,PC02KJ02 from CR_PER_PC02KH where PC02KD01 = '1' and PC02KD02 = '1' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02KH_1_1", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          // 1-自然人_9-其他相关还款责任  账户数 还款责任金额 余额
          list = hqldao.queryBySQL2List("SELECT PC02KS02,PC02KJ01,PC02KJ02 from CR_PER_PC02KH where PC02KD01 = '1' and PC02KD02 = '9' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02KH_1_9", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          // 2-组织结构_1-担保责任  账户数 还款责任金额 余额
          list = hqldao.queryBySQL2List("SELECT PC02KS02,PC02KJ01,PC02KJ02 from CR_PER_PC02KH where PC02KD01 = '2' and PC02KD02 = '1' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02KH_2_1", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          // 2-组织结构_9-其他相关还款责任 账户数 还款责任金额 余额
          list = hqldao.queryBySQL2List("SELECT PC02KS02,PC02KJ01,PC02KJ02 from CR_PER_PC02KH where PC02KD01 = '2' and PC02KD02 = '9' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC02KH_2_9", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          
          /*后付费业务欠费信息汇总*/
//          后付费业务类型 欠费账户数 欠费金额
          list = hqldao.queryBySQL2List("select PC030D01,PC030S02,PC030J01" +
                  " from CR_PER_PC030H where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PC030H", isNotEmpty(list) ? list : (new ArrayList()));
         
          //电信业务 欠费账户数 欠费金额
          list = hqldao.queryBySQL2List("SELECT PC030S02,PC030J01 from CR_PER_PC030H where PC030D01 = '1' and BATCH_ID = ?", objArg, null);
          map.put("CR_PER_PC030H_1", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          
          
/*公共信息概要*/
//          公共信息类型 记录数 涉及金额
          list = hqldao.queryBySQL2List("select PC040D01,PC040S02,PC040J01" +
                  " from CR_PER_PC040H where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PC040H", isNotEmpty(list) ? list : (new ArrayList()));
          
/*查询记录概要*/
//          上一次查询日期 上一次查询机构机构类型 上一次查询机构代码 上一次查询原因
//          最近 1 个月内的查询机构数（贷款审批） 最近 1 个月内的查询机构数（信用卡审批） 最近 1 个月内的查询次数（贷款审批） 最近 1 个月内的查询次数（信用卡审批）
//          最近 1 个月内的查询次数（本人查询） 最近 2 年内的查询次数（贷后管理） 最近 2 年内的查询次数（担保资格审查） 最近 2 年内的查询次数（特约商户实名审查）
          list = hqldao.queryBySQL2List("select PC05AR01,PC05AD01,PC05AI01,PC05AQ01,PC05BS01,PC05BS02,PC05BS03,PC05BS04,PC05BS05,PC05BS06,PC05BS07,PC05BS08" +
                  " from CR_PER_PQO where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PQO", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//          	授信协议编号 业务管理机构 授信协议标识 授信额度用途 授信额度 币种 生效日期 到期日期 已用额度 授信限额 授信限额编号
          list = hqldao.queryBySQL2List("select PD02AI01,PD02AI02,PD02AI03,PD02AD02,PD02AJ01,PD02AD03,PD02AR01,PD02AR02,PD02AJ04,PD02AJ03,PD02AI04" +
                  " from CR_PER_PCA where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PCA", isNotEmpty(list) ? list : (new ArrayList()));
//          奖励机构 奖励内容 生效年月 截止年月 标注及声明个数
          list = hqldao.queryBySQL2List("select PF08AQ01,PF08AQ02,PF08AR01,PF08AR02,PF08ZS01" +
                  " from CR_PER_PAH where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PAH", isNotEmpty(list) ? list : (new ArrayList()));
//          执业资格名称 颁发机构 等级 机构所在地 获得年月 到期年月 吊销年月
          list = hqldao.queryBySQL2List("select PF07AQ01,PF07AQ02,PF07AD01,PF07AD02,PF07AR01,PF07AR02,PF07AR03" +
                  " from CR_PER_PPQ where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PPQ", isNotEmpty(list) ? list : (new ArrayList()));
//          人员类别 所在地 工作单位 家庭月收入 申请日期 批准日期 信息更新日期
          list = hqldao.queryBySQL2List("select PF06AD01,PF06AQ01,PF06AQ02,PF06AQ03,PF06AR01,PF06AR02,PF06AR03" +
                  " from CR_PER_PBS where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PBS", isNotEmpty(list) ? list : (new ArrayList()));
//          参缴地 参缴日期 缴费状态 初缴月份 缴至月份 单位缴存比例 个人缴存比例 月缴存额 缴费单位 信息更新日期
          list = hqldao.queryBySQL2List("select PF05AQ01,PF05AR01,PF05AD01,PF05AR02,PF05AR03,PF05AQ02,PF05AQ03,PF05AJ01,PF05AQ04,PF05AR04" +
                  " from CR_PER_PHF where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PHF", isNotEmpty(list) ? list : (new ArrayList()));
//          处罚机构 处罚内容 处罚金额 处罚生效日期 处罚截止日期 行政复议结果
          list = hqldao.queryBySQL2List("select PF04AQ01,PF04AQ02,PF04AJ01,PF04AR01,PF04AR02,PF04AQ03" +
                  " from CR_PER_PAP where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PAP", isNotEmpty(list) ? list : (new ArrayList()));
//          执行法院 执行案由 立案日期 结案方式 案件状态 结案日期 申请执行标的 申请执行标的金额 已执行标的 已执行标的金额
          list = hqldao.queryBySQL2List("select PF03AQ01,PF03AQ02,PF03AR01,PF03AD01,PF03AQ03,PF03AR02,PF03AQ04,PF03AJ01,PF03AQ05,PF03AJ02" +
                  " from CR_PER_PCE where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PCE", isNotEmpty(list) ? list : (new ArrayList()));
//          立案法院 案由 立案日期 结案方式 判决/调解结果 判决/调解生效日期 诉讼标的 诉讼标的金额 标注及声明个数
          list = hqldao.queryBySQL2List("select PF02AQ01,PF02AQ02,PF02AR01,PF02AD01,PF02AQ03,PF02AR02,PF02AQ04,PF02AJ01,PF02ZS01" +
                  " from CR_PER_PCJ where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PCJ", isNotEmpty(list) ? list : (new ArrayList()));
//          主管税务机关 欠税总额 欠税统计日期
          list = hqldao.queryBySQL2List("select PF01AQ01,PF01AJ01,PF01AR01" +
                  " from CR_PER_POT where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_POT", isNotEmpty(list) ? list : (new ArrayList()));
//          业务管理机构 业务种类 开立日期 到期日期 相关还款责任人类型 保证合同编号 相关还款责任金额 币种 余额 五级分类 逾期月数
          list = hqldao.queryBySQL2List("select PD03AQ01,PD03AD02,PD03AR01,PD03AR02,PD03AD03,PD03AQ02,PD03AJ01,PD03AD04,PD03AJ02,PD03AD05,PD03AS01" +
                  " from CR_PER_PCR where BATCH_ID = ? ", objArg, null);
          map.put("CR_PER_PCR", isNotEmpty(list) ? list : (new ArrayList()));
//          查询日期 查询机构 查询原因
          list = hqldao.queryBySQL2List("select PH010R01,PH010Q02,PH010Q03" +
                  " from CR_PER_POQ where BATCH_ID = ? order by PH010R01 desc", objArg, null);
          map.put("CR_PER_POQ", isNotEmpty(list) ? list : (new ArrayList()));




          /*被追偿信息 C1 Start*/
//          基本信息
          list = hqldao.queryBySQL2List("select ID,PD01AD03,PD01AD01,PD01AI01,PD01AD02,PD01AI02,PD01AR01,PD01AJ01," +
                  "PD01AD10,PD01BD01,PD01BJ01,PD01BR02,PD01BR01,PD01BR03,PD01ZS01,PD01FS01,PD01GS01" +
                  " from CR_PER_PDA where BATCH_ID = ? " +
                  " and PD01AD01 = 'C1' order by to_number(PD01AI01)", objArg, null);
          map.put("PDA_AD01_C1", isNotEmpty(list) ? list : (new ArrayList()));
//          标注及声明
          list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ? " +
                  " and A.PD01AD01 = 'C1'", objArg, null);
          map.put("PDA_AD01_C1_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊交易信息
          list = hqldao.queryBySQL2List("select B.PARENT_ID,B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ? " +
                  " and A.PD01AD01 = 'C1'", objArg, null);
          map.put("PDA_AD01_C1_PD01FH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊事件说明
          /*list = hqldao.queryBySQL2List("select B.PD01GR01,B.PD01GD01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01GH B on A.PD01GS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ? " +
                  " and A.PD01AD01 = 'C1'", objArg, null);
          map.put("PDA_AD03_PD01GH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());*/
          /*被追偿信息 C1 End*/

          /*非循环贷账户 D1 Start*/
//          基本信息
          list = hqldao.queryBySQL2List("select ID,PD01AI01,PD01AI04,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AR02,PD01AJ01," +
                  "PD01AD04,PD01AD03,PD01AD07,PD01AS01,PD01AD06,PD01AD05,PD01AD09,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03," +
                  "PD01BJ02,PD01BD04,PD01BR04,PD01BR01,PD01CR04,PD01CD01,PD01CD02,PD01CJ01,PD01CS01,PD01CJ04,PD01CR02,PD01CJ05,"
                  + "PD01CR03,PD01CS02,PD01CJ06,PD01CJ07,PD01CJ08,PD01CJ09,PD01CJ10,PD01ER01,PD01ER02,PD01ZS01,PD01FS01,PD01GS01" +
                  " from CR_PER_PDA where BATCH_ID = ? " +
                  " and PD01AD01 = 'D1' order by to_number(PD01AI01)", objArg, null);
          map.put("PDA_AD01_D1", isNotEmpty(list) ? list : (new ArrayList()));
          
          
          logger.info("-------------------------------------5年开始---------------------------------------");
//          最近5年内历史表现
          list = hqldao.queryBySQL2List("select B.PARENT_ID,A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'D1' ", objArg, null);
          
          list = groupListBy(list, "PARENT_ID");
		  for (int i = 0; i < list.size(); i++) {
        	  Map m =(Map)list.get(i);
        	  List<Map> l=(List<Map>) m.get("LIST");
        	  l=PD01EH_Res_into_Year(l, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
        	  m.put("LIST",l);
          }
          
//          list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
          map.put("PDA_AD01_D1_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));
          logger.info("-------------------------------------5年结束---------------------------------------");
//          标注及声明
          list = hqldao.queryBySQL2List("select B.PARENT_ID,B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'D1'", objArg, null);
          list = groupListBy(list, "PARENT_ID");
          map.put("PDA_AD01_D1_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊交易信息
/*          list = hqldao.queryBySQL2List("select B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
        		  " from CR_PER_PDA A" +
        		  " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
        		  " where A.BATCH_ID = ?" +
        		  " and A.PD01AD01 = 'D1'", objArg, null);
*/          list = hqldao.queryBySQL2List("select B.PARENT_ID,B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01FH B on  B.PARENT_ID = A.ID and A.PD01FS01 > 0 " +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'D1'", objArg, null);
          //list = groupListBy(list, "PARENT_ID");
          map.put("PDA_AD01_D1_PD01FH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊事件说明
          list = hqldao.queryBySQL2List("select B.PD01GR01,B.PD01GD01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01GH B on A.PD01GS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ? " +
                  "and A.PD01AD01 = 'D1'", objArg, null);
          list = groupListBy(list, "PARENT_ID");
          map.put("PDA_AD01_D1_PD01GH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          /*非循环贷账户 D1 End*/

          /*循环额度下分账户 R4 Start */
//          基本信息
          list = hqldao.queryBySQL2List("select ID,PD01AI01,PD01AI04,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AR02,PD01AJ01," +
                  "PD01AD04,PD01AD03,PD01AD07,PD01AS01,PD01AD06,PD01AD05,PD01AD09,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03," +
                  "PD01BJ02,PD01BD04,PD01BR04,PD01BR01,"
                  + "PD01CR04,PD01CD01,PD01CD02,PD01CJ01,PD01CS01,PD01CJ04,PD01CR02,PD01CJ05,PD01CR03,PD01CS02,PD01CJ06,PD01CJ07,PD01CJ08,PD01CJ09,PD01CJ10,PD01ER01,PD01ER02,PD01ZS01,PD01FS01,PD01GS01" +
                  " from CR_PER_PDA where BATCH_ID = ? " +
                  " and PD01AD01 = 'R4' order by PD01ER01 desc", objArg, null);
          map.put("PDA_AD01_R4", isNotEmpty(list) ? list : (new ArrayList()));
//          最近5年内历史表现
          list = hqldao.queryBySQL2List("select B.PARENT_ID,A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R4'", objArg, null);
//          LIST<MAP<String,List>>
          list = groupListBy(list, "PARENT_ID");
		  for (int i = 0; i < list.size(); i++) {
        	  Map m =(Map)list.get(i);
        	  List<Map> l=(List<Map>) m.get("LIST");
        	  l=PD01EH_Res_into_Year(l, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
        	  m.put("LIST",l);
          }
//          list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
          
          map.put("PDA_AD01_R4_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));

//          标注及声明
          list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R4'", objArg, null);
          map.put("PDA_AD01_R4_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊交易信息
          list = hqldao.queryBySQL2List("select B.PARENT_ID,B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R4'", objArg, null);
          //modify by chensibi 修改只显示一条特殊交易的bug
          map.put("PDA_AD01_R4_PD01FH", isNotEmpty(list) ? list : (new ArrayList()));
          /*循环额度下分账户 R4 End */

          /*循环贷账户 R1 Start */
//          基本信息
          list = hqldao.queryBySQL2List("select ID,PD01AI01,PD01AI04,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AR02,PD01AJ01," +
                  "PD01AD04,PD01AD03,PD01AD07,PD01AS01,PD01AD06,PD01AD05,PD01AD09,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03," +
                  "PD01BJ02,PD01BD04,PD01BR04,PD01BR01,PD01ER01,"
                  + "PD01CR04,PD01CD01,PD01CD02,PD01CJ01,PD01CS01,PD01CJ04,PD01CR02,PD01CJ05,PD01CR03,PD01CS02,PD01CJ06,PD01CJ07,PD01CJ08,PD01CJ09,PD01CJ10,PD01ER02,PD01ZS01,PD01FS01,PD01GS01" +
                  " from CR_PER_PDA where BATCH_ID = ? " +
                  " and PD01AD01 = 'R1' order by to_number(PD01AI01)", objArg, null);
          map.put("PDA_AD01_R1", isNotEmpty(list) ? list : (new ArrayList()));
//          最近5年内历史表现
          list = hqldao.queryBySQL2List("select A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R1'", objArg, null);
          list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
          map.put("PDA_AD01_R1_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));

//          标注及声明
          list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R1'", objArg, null);
          map.put("PDA_AD01_R1_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊交易信息
          list = hqldao.queryBySQL2List("select B.PARENT_ID,B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R1'", objArg, null);
          map.put("PDA_AD01_R1_PD01FH", isNotEmpty(list) ? list : (new ArrayList()));
          /*循环贷账户 R1 End */

          /*贷记卡账户 R2 Start */
//          基本信息
          /*list = hqldao.queryBySQL2List("select ID,PD01AD01,PD01AI04,PD01AI01,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AJ02," +
                  "PD01AJ03,PD01AD04,PD01AD03,PD01AD07,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03,PD01BJ02,PD01BD04," +
                  "PD01BR01,PD01CR04,PD01CD01,PD01CJ01,PD01CJ02,PD01CJ03,PD01CS01,PD01CJ12,PD01CJ14,PD01CR02,PD01CJ04," +
                  "PD01CJ05,PD01CR03,PD01CS02,PD01CJ06,PD01HS01,PD01GS01,PD01FS01,PD01ZS01,PD01ER01,PD01ER02" +
                  " from CR_PER_PDA where BATCH_ID = ? " +
                  " and PD01AD01 = 'R2' order by PD01ER01 desc", objArg, null);*/
          list = hqldao.queryBySQL2List("select ID,PD01AD01,PD01AI04,PD01AI01,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AJ02," +
        		  "PD01AJ03,PD01AD04,PD01AD03,PD01AD07,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03,PD01BJ02,PD01BD04," +
        		  "PD01BR01,PD01CR04,PD01CD01,PD01CJ01,PD01CJ02,PD01CJ03,PD01CS01,PD01CJ12,PD01CJ14,PD01CR02,PD01CJ04," +
        		  "PD01CJ05,PD01CR03,PD01CS02,PD01CJ06,PD01HS01,PD01GS01,PD01FS01,PD01ZS01,PD01ER01,PD01ER02" +
        		  " from CR_PER_PDA where BATCH_ID = ? " +
        		  " and PD01AD01 = 'R2' order by to_number(PD01AI01)", objArg, null);//去除顺序，便于对照原始报文 20200202
          map.put("PDA_AD01_R2", isNotEmpty(list) ? list : (new ArrayList()));
//          最近5年内历史表现
          list = hqldao.queryBySQL2List("select B.PARENT_ID,A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R2' order by A.PD01ER01 desc", objArg, null);
          list = groupListBy(list, "PARENT_ID");
		  for (int i = 0; i < list.size(); i++) {
        	  Map m =(Map)list.get(i);
        	  List<Map> l=(List<Map>) m.get("LIST");
        	  l=PD01EH_Res_into_Year(l, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
        	  m.put("LIST",l);
          }
         // list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
          map.put("PDA_AD01_R2_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));
//          大额专项分期信息
          list = hqldao.queryBySQL2List("select B.PD01HJ01,B.PD01HR01,B.PD01HR02,B.PD01HJ02" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01HH B on A.PD01HS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R2'", objArg, null);
          map.put("PDA_AD01_R2_PD01HH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//          标注及声明
          list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R2'", objArg, null);
          map.put("PDA_AD01_R2_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊交易信息
          list = hqldao.queryBySQL2List("select B.PARENT_ID,B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R2'", objArg, null);
          map.put("PDA_AD01_R2_PD01FH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊事件说明
          list = hqldao.queryBySQL2List("select B.PD01GR01,B.PD01GD01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01GH B on A.PD01GS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ? " +
                  "and A.PD01AD01 = 'R2'", objArg, null);
          map.put("PDA_AD01_R2_PD01GH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
          /*贷记卡账户 R2 End */

          /*准贷记卡账户 R3 Start */
//          基本信息
          list = hqldao.queryBySQL2List("select ID,PD01AD01,PD01AI04,PD01AI01,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AJ02," +
                  "PD01AJ03,PD01AD04,PD01AD07,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03,PD01BJ02,PD01BD04,PD01BR01,PD01CR04," +
                  "PD01CD01,PD01CJ01,PD01CJ13,PD01CJ15,PD01CR02,PD01CJ04,PD01CR03,PD01CJ11,PD01FS01,PD01ZS01,PD01ER01,PD01ER02" +
                  " from CR_PER_PDA where BATCH_ID = ? " +
                  " and PD01AD01 = 'R3' order by to_number(PD01AI01)", objArg, null);
          map.put("PDA_AD01_R3", isNotEmpty(list) ? list : (new ArrayList()));
//          最近5年内历史表现
          list = hqldao.queryBySQL2List("select A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01,B.PARENT_ID" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R3'", objArg, null);
          /*list = groupListBy(list, "PARENT_ID");
          list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");*/
          //add by chensibi 20200210 start
          list = groupListBy(list, "PARENT_ID");
		  for (int i = 0; i < list.size(); i++) {
        	  Map m =(Map)list.get(i);
        	  List<Map> l=(List<Map>) m.get("LIST");
        	  l=PD01EH_Res_into_Year(l, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
        	  m.put("LIST",l);
          }
          //add by chensibi 20200210 end
          map.put("PDA_AD01_R3_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));
//          标注及声明
          list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R3'", objArg, null);
          map.put("PDA_AD01_R3_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//          特殊交易信息
          list = hqldao.queryBySQL2List("select B.PARENT_ID,B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                  " from CR_PER_PDA A" +
                  " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD01AD01 = 'R3'", objArg, null);
          map.put("PDA_AD01_R3_PD01FH", isNotEmpty(list) ? list : (new ArrayList()));
          /*准贷记卡账户 R3 End */

          /*相关还款责任信息 Start */
//          基本信息 1-个人
          list = hqldao.queryBySQL2List("select PD03AD08,PD03AD01,PD03AQ01,PD03AD02,PD03AR01,PD03AR02,PD03AD03,PD03AJ01,PD03AD04,PD03AQ02,PD03AR03," +
                  "PD03AJ02,PD03AD05,PD03AD07,PD03ZS01" +
                  " from CR_PER_PCR where BATCH_ID = ?" +
                  " and PD03AD08 = '1' ORDER BY PD03AR01"
                  , objArg, null);
          map.put("PCR_AD08_1", isNotEmpty(list) ? list : (new ArrayList()));
//          标注及声明  1-个人
          /*list = hqldao.queryBySQL2List("select B.PF03ZD01,B.PF03ZQ01,B.PF03ZR01" +
                  " from CR_PER_PCR A" +
                  " right join CR_PER_PF03ZH B on A.PD03ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD03AD08 = '1'", objArg, null);
          map.put("PCR_AD08_1_PF03ZH", isNotEmpty(list) ? list : (new ArrayList()));*/

//          基本信息 2-企业
          list = hqldao.queryBySQL2List("select PD03AD08,PD03AD01,PD03AQ01,PD03AD02,PD03AR01,PD03AR02,PD03AD03,PD03AJ01,PD03AD04,PD03AQ02,PD03AR03," +
                  "PD03AJ02,PD03AD05,PD03AS01,PD03ZS01" +
                  " from CR_PER_PCR where BATCH_ID = ?" +
                  " and PD03AD08 = '2' ORDER BY PD03AR01"
                  , objArg, null);
          map.put("PCR_AD08_2", isNotEmpty(list) ? list : (new ArrayList()));
//          标注及声明  2-企业
          /*list = hqldao.queryBySQL2List("select B.PF03ZD01,B.PF03ZQ01,B.PF03ZR01" +
                  " from CR_PER_PCR A" +
                  " right join CR_PER_PF03ZH B on A.PD03ZS01 > 0 and B.PARENT_ID = A.ID" +
                  " where A.BATCH_ID = ?" +
                  " and A.PD03AD08 = '2'", objArg, null);
          map.put("PCR_AD08_2_PF03ZH", isNotEmpty(list) ? list : (new ArrayList()));*/

          /*相关还款责任信息 End */

          /*非信贷交易信息明细 后付费记录 Start */
//        基本信息
        list = hqldao.queryBySQL2List("select PE01AD01,PE01AQ01,PE01AD02,PE01AR01,PE01AD03,PE01AJ01,PE01AR02,PE01AQ02,PE01ZS01" +
                " from CR_PER_PND where BATCH_ID = ?"
                , objArg, null);
        list =CR_PER_PN_AQ02_into_Year(list,"PE01AQ02","PE01AR02");
        map.put("CR_PER_PND", isNotEmpty(list) ? list : (new ArrayList()));


        /*非信贷交易信息明细 后付费记录 End */
        
       /* 本人声明*/
        list = hqldao.queryBySQL2List("select PG010Q01,PG010R01" +
        		" from CR_PER_PG010H where BATCH_ID = ? and PG010D03 = '3'"
        		, objArg, null);
        map.put("CR_PER_PG010H_3", isNotEmpty(list) ? list : (new ArrayList()));
        
/* 数据库文档写错，       
        //1.低保救助记录--本人声明
        list = hqldao.queryBySQL2List("select PF06ZQ01,PF06ZR01" +
                " from CR_PER_PF06ZH where BATCH_ID = ? and PF06ZD01 = '3'"
                , objArg, null);
        map.put("CR_PER_PF06ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //2.行政处罚记录--本人声明
        list = hqldao.queryBySQL2List("select PF04ZQ01,PF04ZR01" +
        		" from CR_PER_PF04ZH where BATCH_ID = ? and PF04ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PF04ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //3.行政奖励记录--本人声明
        list = hqldao.queryBySQL2List("select PF08ZQ01,PF08ZR01" +
        		" from CR_PER_PF08ZH where BATCH_ID = ? and PF08ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PF08ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //4.后付费业务记录--本人声明
        list = hqldao.queryBySQL2List("select PE01ZQ01,PE01ZR01" +
        		" from CR_PER_PE01ZH where BATCH_ID = ? and PE01ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PE01ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //5.借贷账户信息--本人声明
        list = hqldao.queryBySQL2List("select PD01ZQ01,PD01ZR01" +
        		" from CR_PER_PD01ZH where BATCH_ID = ? and PD01ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PD01ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //6.民事判决记录--本人声明
        list = hqldao.queryBySQL2List("select PF02ZQ01,PF02ZR01" +
        		" from CR_PER_PF02ZH where BATCH_ID = ? and PF02ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PF02ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //7.强制执行记录--本人声明
        list = hqldao.queryBySQL2List("select PF03ZQ01,PF03ZR01" +
        		" from CR_PER_PF03ZH where BATCH_ID = ? and PF03ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PF03ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //8.授信协议信息--本人声明
        list = hqldao.queryBySQL2List("select PD02ZQ01,PD02ZR01" +
        		" from CR_PER_PD02ZH where BATCH_ID = ? and PD02ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PD02ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //9.相关还款责任信息--本人声明
        list = hqldao.queryBySQL2List("select PD03ZQ01,PD03ZR01" +
        		" from CR_PER_PD03ZH where BATCH_ID = ? and PD03ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PD03ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //10.执业资格记录--本人声明
        list = hqldao.queryBySQL2List("select PF07ZQ01,PF07ZR01" +
        		" from CR_PER_PF07ZH where BATCH_ID = ? and PF07ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PF07ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
        //11.住房公积金参缴记录--本人声明
        list = hqldao.queryBySQL2List("select PF05ZQ01,PF05ZR01" +
        		" from CR_PER_PF05ZH where BATCH_ID = ? and PF05ZD01 = '3'"
        		, objArg, null);
        map.put("CR_PER_PF05ZH_3", isNotEmpty(list) ? list : (new ArrayList()));
*/        
        
        
        /* 异议标注*/
        list = hqldao.queryBySQL2List("select PG010Q01,PG010R01" +
        		" from CR_PER_PG010H where BATCH_ID = ? and PG010D03 = '1'"
        		, objArg, null);
        map.put("CR_PER_PG010H_1", isNotEmpty(list) ? list : (new ArrayList()));
        
/*数据库文档错误，修改
        //1.低保救助记录--本人声明
        list = hqldao.queryBySQL2List("select PF06ZQ01,PF06ZR01" +
        		" from CR_PER_PF06ZH where BATCH_ID = ? and PF06ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PF06ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //2.行政处罚记录--本人声明
        list = hqldao.queryBySQL2List("select PF04ZQ01,PF04ZR01" +
        		" from CR_PER_PF04ZH where BATCH_ID = ? and PF04ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PF04ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //3.行政奖励记录--本人声明
        list = hqldao.queryBySQL2List("select PF08ZQ01,PF08ZR01" +
        		" from CR_PER_PF08ZH where BATCH_ID = ? and PF08ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PF08ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //4.后付费业务记录--本人声明
        list = hqldao.queryBySQL2List("select PE01ZQ01,PE01ZR01" +
        		" from CR_PER_PE01ZH where BATCH_ID = ? and PE01ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PE01ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //5.借贷账户信息--本人声明
        list = hqldao.queryBySQL2List("select PD01ZQ01,PD01ZR01" +
        		" from CR_PER_PD01ZH where BATCH_ID = ? and PD01ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PD01ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //6.民事判决记录--本人声明
        list = hqldao.queryBySQL2List("select PF02ZQ01,PF02ZR01" +
        		" from CR_PER_PF02ZH where BATCH_ID = ? and PF02ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PF02ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //7.强制执行记录--本人声明
        list = hqldao.queryBySQL2List("select PF03ZQ01,PF03ZR01" +
        		" from CR_PER_PF03ZH where BATCH_ID = ? and PF03ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PF03ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //8.授信协议信息--本人声明
        list = hqldao.queryBySQL2List("select PD02ZQ01,PD02ZR01" +
        		" from CR_PER_PD02ZH where BATCH_ID = ? and PD02ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PD02ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //9.相关还款责任信息--本人声明
        list = hqldao.queryBySQL2List("select PD03ZQ01,PD03ZR01" +
        		" from CR_PER_PD03ZH where BATCH_ID = ? and PD03ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PD03ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //10.执业资格记录--本人声明
        list = hqldao.queryBySQL2List("select PF07ZQ01,PF07ZR01" +
        		" from CR_PER_PF07ZH where BATCH_ID = ? and PF07ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PF07ZH_1", isNotEmpty(list) ? list : (new ArrayList()));
        //11.住房公积金参缴记录--本人声明
        list = hqldao.queryBySQL2List("select PF05ZQ01,PF05ZR01" +
        		" from CR_PER_PF05ZH where BATCH_ID = ? and PF05ZD01 = '1'"
        		, objArg, null);
        map.put("CR_PER_PF05ZH_1", isNotEmpty(list) ? list : (new ArrayList()));

*/
      } catch (Exception e) {
    	  e.printStackTrace();
      }
      return map;
  }
    
  

  private static boolean isNotEmpty(List list){
      if (list == null || list.size() == 0){
          return false;
      }
      return true;
  }

  private static List<Map> PD01EH_Res_into_Year(List<Map> list, String dateKey, String dateStart, String dateEnd, String ... otherKeys) {
      if (list == null || list.size() == 0) return null;
      int startYear = Integer.parseInt(((String) list.get(0).get(dateStart)).substring(0, 4));
      int endYear = Integer.parseInt(((String) list.get(0).get(dateEnd)).substring(0, 4));
      List<Map> res = new ArrayList<>();
      for (int i = endYear; i >= startYear; i--) {
          Map m = new HashMap<String, Object>();
          m.put("YEAR", i + "");
          res.add(m);
      }
      for (int i = 0; i < list.size(); i++) {
          Map map = list.get(i);
          String date = (String) map.get(dateKey);
          String year = date.substring(0, 4);
          String month = date.substring(5);
          for (int j = 0; j < res.size(); j++) {
              if(res.get(j).get("YEAR").equals(year)){
                  Map otherValues=new HashMap<String, Object>();
                  for (int k = 0; k < otherKeys.length; k++) {
                      otherValues.put(otherKeys[k],map.get(otherKeys[k]));
                  }
                  res.get(j).put("M" + month, otherValues);
                  break;
              }
          }
      }
      return res;
  }

  public static void main(String[] args) {
      Map m=new HashMap();
      m.put("START","2019.05");
      m.put("DATA","1234567890abcdefghijklmn");
      List l=new ArrayList();
      l.add(m);
      l=CR_PER_PN_AQ02_into_Year(l,"DATA","START");
      l.forEach(map -> {
          m.forEach((k, v) -> {
              System.out.println(k + " - " + v);
          });
      });
  }

  private static List<Map> CR_PER_PN_AQ02_into_Year(List<Map> list, String sourceKey, String recordDate) {
	    if (list == null || list.size() == 0) return list;
	    for (int i = 0; i < list.size(); i++) {
	        String latest24Data = (String) list.get(i).get(sourceKey);
	        String recordTime = (String) list.get(i).get(recordDate);
	        String recordYear=recordTime.substring(0,4);
	        String recordMonth=recordTime.substring(5,7);
	        if (latest24Data == null || latest24Data.equals("")) {
	            //没有数据
	            list.get(i).put("CR_PER_PN_AQ02", null);
	        } else {
	            List<Map> AQ02List = new ArrayList<>();
	            Map AQ02Map = new HashMap<String, Object>();
	            int _year = Integer.parseInt(recordYear);
	            int _month = Integer.parseInt(recordMonth);
	            AQ02Map.put("YEAR", _year+"");
	            for (int j = 24; j > 0; j--) {
	                String data = latest24Data.substring(j - 1, j);
	                if (_month == 0) {
	                    _month = 12;
	                    AQ02List.add(AQ02Map);
	                    AQ02Map = new HashMap<String, Object>();
	                    _year--;
	                    AQ02Map.put("YEAR", _year +"");
	                }
	                String month=new DecimalFormat("00").format(_month);
	                AQ02Map.put("M"+month,data);
	                _month--;
	                if(j==1){
	                    list.get(i).put(recordDate+"_START", _year+ recordTime.substring(4,5)+month);
	                    AQ02List.add(AQ02Map);
	                }
	            }
	            list.get(i).put("CR_PER_PN_AQ02",AQ02List);
	        }
	    }
	    return list;
	}
  private static List<Map> PSM_PC010D01_into_List(List<Map> list,String dateKey){
      if (list == null || list.size() == 0) return list;
      String data=(String)list.get(0).get(dateKey);
      List l=new ArrayList();
      if(data!=null){
          String [] items=data.split(",");
          for(int i=0;i<items.length;i++){
              Map map=new HashMap<>();
              map.put(dateKey+"_ITEM",items[i]);
              l.add(map);
          }
      }
//      else{
//          Map map=new HashMap<>();
//          map.put(dateKey+"_ITEM",null);
//          l.add(map);
//      }
      list.get(0).put(dateKey,l);
      return list;
  }
  
  private static List<Map> CR_PER_PC02AH1_into_List(List<Map> list,String dataKey,String ... others){
	    if (list == null || list.size() == 0) return list;
	    List<Map> res=new ArrayList<>();
	    for (int i = 0; i < list.size(); i++) {
	        Map item=new HashMap();
	        for (int k = 0; k < others.length; k++) {
	            item.put(others[k],list.get(i).get(others[k]));
	        }
	        String key=(String)list.get(i).get(dataKey);
	        for (int j = 0; ; j++) {
	            if(res.size() > 0 && key.equals(res.get(j).get(dataKey))){
	                ((List)res.get(j).get(dataKey+"_ITEM")).add(item);
	                break;
	            }
	            if(res.size()==0 || j==res.size()-1){
	                Map m=new HashMap();
	                m.put(dataKey,key);
	                List item_list=new ArrayList();
	                item_list.add(item);
	                m.put(dataKey+"_ITEM",item_list);
	                res.add(m);
	                break;
	            }
	        }
	    }
	    for (int i = 0; i < res.size(); i++) {
	        res.get(i).put(dataKey+"_COUNT",((List)res.get(i).get(dataKey+"_ITEM")).size());
	    }
	    return res;
	}
  
  public static List<Map> groupListBy(List<Map> res,String key){
		List<Map> lists = new ArrayList<Map>();
		for (int i = 0; i < res.size(); i++) {
			Map map = res.get(i);
			String _id = map.get(key).toString();
			if (lists.size() == 0) {
				List<Map> list = new ArrayList<Map>();
				Map m=new HashMap<>() ;
				list.add(res.get(i));
				m.put("PARENT_ID", _id);
				m.put("LIST", list);
				lists.add(m);
				continue;
			}
			for(int j=0;j<lists.size();j++) {
				Map<String, List<Map>> m1 = lists.get(j);
				if(_id.equals(m1.get("PARENT_ID"))) {
					List<Map> l = m1.get("LIST");
					l.add(res.get(i));
					break;
				} else {
					if (j == lists.size() - 1) {
						List<Map> list = new ArrayList<Map>();
						Map m=new HashMap<>() ;
						list.add(res.get(i));
						m.put("PARENT_ID", _id);
						m.put("LIST", list);
						lists.add(m);
						break;
					} else {
						continue;
					}
				}
			}
			
		}
		return lists;
	}


}


