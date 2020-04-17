package com.huateng.report.pboc.service;

import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.orm.HQLDAO;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndiQueryService {

    public static IndiQueryService getInstance() {
//        return ApplicationContextUtils.getBean(IndiQueryService.class);
        return new IndiQueryService();
    }

    public Map<String, Object> getIndiReport(String uuid) {
        Map<String, Object> map = new HashMap();
        map.put("uuid", uuid);
        try{
            HQLDAO hqldao = ROOTDAOUtils.getHQLDAO();
            String[] objArg = new String[]{uuid};
            List list = null;

//            报告编号 报告时间 被查询者姓名 被查询者证件类型 被查询者证件号码 查询机构代码 查询原因代码
//            防欺诈警示标志 防欺诈警示联系电话 防欺诈警示生效日期 防欺诈警示截止日期 异议标注数目
            list = hqldao.queryBySQL2List("select PA01AI01,PA01AR01,PA01BQ01,PA01BD01,PA01BI01,PA01BI02,PA01BD02,PA01DQ01,PA01DQ02,PA01DR01,PA01DR02,PA01ES01" +
                    " from CR_PER_PRH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PRH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            证件类型 证件号码
            list = hqldao.queryBySQL2List("select PA01CD01,PA01CI01" +
                    " from CR_PER_PA01CH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PA01CH", isNotEmpty(list) ? list : (new ArrayList()));
//            性别 出生日期 学历 学位 就业状况 电子邮箱 通讯地址 国籍 户籍地址
            list = hqldao.queryBySQL2List("select PB01AD01,PB01AR01,PB01AD02,PB01AD03,PB01AD04,PB01AQ01,PB01AQ02,PB01AD05,PB01AQ03" +
                    " from CR_PER_PIM where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PIM", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            手机号码 信息更新日期
            list = hqldao.queryBySQL2List("select PB01BQ01,PB01BR01" +
                    " from CR_PER_PB01BH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PB01BH", isNotEmpty(list) ? list : (new ArrayList()));
//            婚姻状况 配偶姓名 配偶证件类型 配偶证件号码 配偶工作单位 配偶联系电话
            list = hqldao.queryBySQL2List("select PB020D01,PB020Q01,PB020D02,PB020I01,PB020Q02,PB020Q03" +
                    " from CR_PER_PMM where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PMM", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            居住状况 居住地址 住宅电话 信息更新日期
            list = hqldao.queryBySQL2List("select PB030D01,PB030Q01,PB030Q02,PB030R01" +
                    " from CR_PER_PRM where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PRM", isNotEmpty(list) ? list : (new ArrayList()));
//            就业状况 工作单位 单位性质 行业 单位地址 单位电话 职业 职务 职称 进入本单位年份 信息更新日期
            list = hqldao.queryBySQL2List("select PB040D01,PB040Q01,PB040D02,PB040D03,PB040Q02,PB040Q03,PB040D04,PB040D05,PB040D06,PB040R01,PB040R02" +
                    " from CR_PER_POM where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_POM", isNotEmpty(list) ? list : (new ArrayList()));
//            数字解读 相对位置 分数说明条数 分数说明
            list = hqldao.queryBySQL2List("select PC010Q01,PC010Q02,PC010S01,PC010D01" +
                    " from CR_PER_PSM where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PSM",  isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            信贷交易提示信息账户数合计 被追偿汇总信息账户数合计 被追偿汇总信息余额合计 呆账汇总信息账户数 呆账汇总信息余额
//            非循环贷账户管理机构数 非循环贷账户账户数 非循环贷账户授信总额 非循环贷账户贷余额 循环贷账户最近 6 个月平均应还款
//            循环额度下分账户管理机构数 循环额度下分账户账户数 循环额度下分账户授信总额 循环额度下分账户余额 循环额度下分账户最近 6 个月平均应还款
//            循环贷账户管理机构数 循环贷账户账户数 循环贷账户授信总额 循环贷账户余额 循环贷账户最近6 个月平均应还款
//            贷记卡账户发卡机构数 贷记卡账户账户数 贷记卡账户授信总额 贷记卡账户单家行最高授信额 贷记卡账户单家行最低授信额 贷记卡账户已用额度 贷记卡账户最近 6 个月平均使用额度
//            准贷记卡账户发卡机构数 准贷记卡账户账户数 准贷记卡账户授信总额 准贷记卡账户单家行最高授信额 准贷记卡账户单家行最低授信额 准贷记卡账户透支余额 准贷记卡账户最近 6 个月平均透支余额
            list = hqldao.queryBySQL2List("select PC02AS01,PC02BS01,PC02BJ01,PC02CS01,PC02CJ01,PC02ES01,PC02ES02,PC02EJ01,PC02EJ02,PC02EJ03," +
                    "PC02FS01,PC02FS02,PC02FJ01,PC02FJ02,PC02FJ03,PC02GS01,PC02GS02,PC02GJ01,PC02GJ02,PC02GJ03," +
                    "PC02HS01,PC02HS02,PC02HJ01,PC02HJ02,PC02HJ03,PC02HJ04,PC02HJ05,PC02IS01,PC02IS02,PC02IJ01,PC02IJ02,PC02IJ03,PC02IJ04,PC02IJ05" +
                    " from CR_PER_PCO where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PCO", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            业务类型 业务大类 账户数 首笔业务发放月份
            list = hqldao.queryBySQL2List("select PC02AD01,PC02AD02,PC02AS03,PC02AR01" +
                    " from CR_PER_PC02AH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PC02AH", isNotEmpty(list) ? list : (new ArrayList()));
//            业务类型 账户数 余额CR_PER_PDA
            list = hqldao.queryBySQL2List("select PC02BD01,PC02BS03,PC02BJ02" +
                    " from CR_PER_PC02BH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PC02BH", isNotEmpty(list) ? list : (new ArrayList()));
//            账户类型 账户数 月份数 单月最高逾期（透支）总额 最长逾期（透支）月数
            list = hqldao.queryBySQL2List("select PC02DD01,PC02DS02,PC02DS03,PC02DJ01,PC02DS04" +
                    " from CR_PER_PC02DH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PC02DH", isNotEmpty(list) ? list : (new ArrayList()));
//            借款人身份类别 还款责任类型 账户数 还款责任金额 余额
            list = hqldao.queryBySQL2List("select PC02KD01,PC02KD02,PC02KS02,PC02KJ01,PC02KJ02" +
                    " from CR_PER_PC02KH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PC02KH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            后付费业务类型 欠费账户数 欠费金额
            list = hqldao.queryBySQL2List("select PC030D01,PC030S02,PC030J01" +
                    " from CR_PER_PC030H where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PC030H", isNotEmpty(list) ? list : (new ArrayList()));
//            公共信息类型 记录数 涉及金额
            list = hqldao.queryBySQL2List("select PC040D01,PC040S02,PC040J01" +
                    " from CR_PER_PC040H where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PC040H", isNotEmpty(list) ? list : (new ArrayList()));
//            上一次查询日期 上一次查询机构机构类型 上一次查询机构代码 上一次查询原因
//            最近 1 个月内的查询机构数（贷款审批） 最近 1 个月内的查询机构数（信用卡审批） 最近 1 个月内的查询次数（贷款审批） 最近 1 个月内的查询次数（信用卡审批）
//            最近 1 个月内的查询次数（本人查询） 最近 2 年内的查询次数（贷后管理） 最近 2 年内的查询次数（担保资格审查） 最近 2 年内的查询次数（特约商户实名审查）
            list = hqldao.queryBySQL2List("select PC05AR01,PC05AD01,PC05AI01,PC05AQ01,PC05BS01,PC05BS02,PC05BS03,PC05BS04,PC05BS05,PC05BS06,PC05BS07,PC05BS08" +
                    " from CR_PER_PQO where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PQO", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            	授信协议编号 业务管理机构 授信协议标识 授信额度用途 授信额度 币种 生效日期 到期日期 已用额度 授信限额 授信限额编号
            list = hqldao.queryBySQL2List("select PD02AI01,PD02AI02,PD02AI03,PD02AD02,PD02AJ01,PD02AD03,PD02AR01,PD02AR02,PD02AJ04,PD02AJ03,PD02AI04" +
                    " from CR_PER_PCA where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PCA", isNotEmpty(list) ? list : (new ArrayList()));
//            奖励机构 奖励内容 生效年月 截止年月 标注及声明个数
            list = hqldao.queryBySQL2List("select PF08AQ01,PF08AQ02,PF08AR01,PF08AR02,PF08ZS01" +
                    " from CR_PER_PAH where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PAH", isNotEmpty(list) ? list : (new ArrayList()));
//            执业资格名称 颁发机构 等级 机构所在地 获得年月 到期年月 吊销年月
            list = hqldao.queryBySQL2List("select PF07AQ01,PF07AQ02,PF07AD01,PF07AD02,PF07AR01,PF07AR02,PF07AR03" +
                    " from CR_PER_PPQ where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PPQ", isNotEmpty(list) ? list : (new ArrayList()));
//            人员类别 所在地 工作单位 家庭月收入 申请日期 批准日期 信息更新日期
            list = hqldao.queryBySQL2List("select PF06AD01,PF06AQ01,PF06AQ02,PF06AQ03,PF06AR01,PF06AR02,PF06AR03" +
                    " from CR_PER_PBS where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PBS", isNotEmpty(list) ? list : (new ArrayList()));
//            参缴地 参缴日期 缴费状态 初缴月份 缴至月份 单位缴存比例 个人缴存比例 月缴存额 缴费单位 信息更新日期
            list = hqldao.queryBySQL2List("select PF05AQ01,PF05AR01,PF05AD01,PF05AR02,PF05AR03,PF05AQ02,PF05AQ03,PF05AJ01,PF05AQ04,PF05AR04" +
                    " from CR_PER_PHF where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PHF", isNotEmpty(list) ? list : (new ArrayList()));
//            处罚机构 处罚内容 处罚金额 处罚生效日期 处罚截止日期 行政复议结果
            list = hqldao.queryBySQL2List("select PF04AQ01,PF04AQ02,PF04AJ01,PF04AR01,PF04AR02,PF04AQ03" +
                    " from CR_PER_PAP where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PAP", isNotEmpty(list) ? list : (new ArrayList()));
//            执行法院 执行案由 立案日期 结案方式 案件状态 结案日期 申请执行标的 申请执行标的金额 已执行标的 已执行标的金额
            list = hqldao.queryBySQL2List("select PF03AQ01,PF03AQ02,PF03AR01,PF03AD01,PF03AQ03,PF03AR02,PF03AQ04,PF03AJ01,PF03AQ05,PF03AJ02" +
                    " from CR_PER_PCE where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PCE", isNotEmpty(list) ? list : (new ArrayList()));
//            立案法院 案由 立案日期 结案方式 判决/调解结果 判决/调解生效日期 诉讼标的 诉讼标的金额 标注及声明个数
            list = hqldao.queryBySQL2List("select PF02AQ01,PF02AQ02,PF02AR01,PF02AD01,PF02AQ03,PF02AR02,PF02AQ04,PF02AJ01,PF02ZS01" +
                    " from CR_PER_PCJ where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PCJ", isNotEmpty(list) ? list : (new ArrayList()));
//            主管税务机关 欠税总额 欠税统计日期
            list = hqldao.queryBySQL2List("select PF01AQ01,PF01AJ01,PF01AR01" +
                    " from CR_PER_POT where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_POT", isNotEmpty(list) ? list : (new ArrayList()));
//            业务管理机构 业务种类 开立日期 到期日期 相关还款责任人类型 保证合同编号 相关还款责任金额 币种 余额 五级分类 逾期月数
            list = hqldao.queryBySQL2List("select PD03AQ01,PD03AD02,PD03AR01,PD03AR02,PD03AD03,PD03AQ02,PD03AJ01,PD03AD04,PD03AJ02,PD03AD05,PD03AS01" +
                    " from CR_PER_PCR where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_PCR", isNotEmpty(list) ? list : (new ArrayList()));
//            查询日期 查询机构 查询原因
            list = hqldao.queryBySQL2List("select PH010R01,PH010Q02,PH010Q03" +
                    " from CR_PER_POQ where BATCH_ID = ? ", objArg, null);
            map.put("CR_PER_POQ", isNotEmpty(list) ? list : (new ArrayList()));




            /*被追偿信息 C1 Start*/
//            基本信息
            list = hqldao.queryBySQL2List("select PD01AD03,PD01AD01,PD01AI01,PD01AD02,PD01AI02,PD01AR01,PD01AJ01," +
                    "PD01AD10,PD01BD01,PD01BJ01,PD01BR02,PD01BR01,PD01BR03,PD01ZS01,PD01FS01,PD01GS01" +
                    " from CR_PER_PDA where BATCH_ID = ? " +
                    " and PD01AD01 = 'C1'", objArg, null);
            map.put("PDA_AD01_C1", isNotEmpty(list) ? list : (new ArrayList()));
//            标注及声明
            list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ? " +
                    " and A.PD01AD01 = 'C1'", objArg, null);
            map.put("PDA_AD01_C1_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//            特殊交易信息
            list = hqldao.queryBySQL2List("select B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ? " +
                    " and A.PD01AD01 = 'C1'", objArg, null);
            map.put("PDA_AD01_C1_PD01FH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            特殊事件说明
            /*list = hqldao.queryBySQL2List("select B.PD01GR01,B.PD01GD01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01GH B on A.PD01GS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ? " +
                    " and A.PD01AD01 = 'C1'", objArg, null);
            map.put("PDA_AD03_PD01GH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());*/
            /*被追偿信息 C1 End*/

            /*非循环贷账户 D1 Start*/
//            基本信息
            list = hqldao.queryBySQL2List("select PD01AI01,PD01AI04,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AR02,PD01AJ01," +
                    "PD01AD04,PD01AD03,PD01AD07,PD01AS01,PD01AD06,PD01AD05,PD01AD09,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03," +
                    "PD01BJ02,PD01BD04,PD01BR04,PD01BR01,PD01ER01,PD01ER02,PD01ZS01,PD01FS01,PD01GS01" +
                    " from CR_PER_PDA where BATCH_ID = ? " +
                    " and PD01AD01 = 'D1'", objArg, null);
            map.put("PDA_AD01_D1", isNotEmpty(list) ? list : (new ArrayList()));
//            最近5年内历史表现
            list = hqldao.queryBySQL2List("select A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'D1'", objArg, null);
            list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
            map.put("PDA_AD01_D1_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));

//            标注及声明
            list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'D1'", objArg, null);
            map.put("PDA_AD01_D1_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//            特殊交易信息
            list = hqldao.queryBySQL2List("select B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'D1'", objArg, null);
            map.put("PDA_AD01_D1_PD01FH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            特殊事件说明
            list = hqldao.queryBySQL2List("select B.PD01GR01,B.PD01GD01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01GH B on A.PD01GS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ? " +
                    "and A.PD01AD01 = 'D1'", objArg, null);
            map.put("PDA_AD01_D1_PD01GH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
            /*非循环贷账户 D1 End*/

            /*循环额度下分账户 R4 Start */
//            基本信息
            list = hqldao.queryBySQL2List("select PD01AI01,PD01AI04,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AR02,PD01AJ01," +
                    "PD01AD04,PD01AD03,PD01AD07,PD01AS01,PD01AD06,PD01AD05,PD01AD09,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03," +
                    "PD01BJ02,PD01BD04,PD01BR04,PD01BR01,PD01ER01,PD01ER02,PD01ZS01,PD01FS01,PD01GS01" +
                    " from CR_PER_PDA where BATCH_ID = ? " +
                    " and PD01AD01 = 'R4'", objArg, null);
            map.put("PDA_AD01_R4", isNotEmpty(list) ? list : (new ArrayList()));
//            最近5年内历史表现
            list = hqldao.queryBySQL2List("select A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R4'", objArg, null);
            list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
            map.put("PDA_AD01_R4_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));

//            标注及声明
            list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R4'", objArg, null);
            map.put("PDA_AD01_R4_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//            特殊交易信息
            list = hqldao.queryBySQL2List("select B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R4'", objArg, null);
            map.put("PDA_AD01_R4_PD01FH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
            /*循环额度下分账户 R4 End */

            /*循环贷账户 R1 Start */
//            基本信息
            list = hqldao.queryBySQL2List("select PD01AI01,PD01AI04,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AR02,PD01AJ01," +
                    "PD01AD04,PD01AD03,PD01AD07,PD01AS01,PD01AD06,PD01AD05,PD01AD09,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03," +
                    "PD01BJ02,PD01BD04,PD01BR04,PD01BR01,PD01ER01,PD01ER02,PD01ZS01,PD01FS01,PD01GS01" +
                    " from CR_PER_PDA where BATCH_ID = ? " +
                    " and PD01AD01 = 'R1'", objArg, null);
            map.put("PDA_AD01_R1", isNotEmpty(list) ? list : (new ArrayList()));
//            最近5年内历史表现
            list = hqldao.queryBySQL2List("select A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R1'", objArg, null);
            list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
            map.put("PDA_AD01_R1_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));

//            标注及声明
            list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R1'", objArg, null);
            map.put("PDA_AD01_R1_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//            特殊交易信息
            list = hqldao.queryBySQL2List("select B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R1'", objArg, null);
            map.put("PDA_AD01_R1_PD01FH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
            /*循环贷账户 R1 End */

            /*贷记卡账户 R2 Start */
//            基本信息
            list = hqldao.queryBySQL2List("select PD01AD01,PD01AI04,PD01AI01,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AJ02," +
                    "PD01AJ03,PD01AD04,PD01AD03,PD01AD07,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03,PD01BJ02,PD01BD04," +
                    "PD01BR01,PD01CR04,PD01CD01,PD01CJ01,PD01CJ02,PD01CJ03,PD01CS01,PD01CJ12,PD01CJ14,PD01CR02,PD01CJ04," +
                    "PD01CJ05,PD01CR03,PD01CS02,PD01CJ06,PD01HS01,PD01GS01,PD01FS01,PD01ZS01" +
                    " from CR_PER_PDA where BATCH_ID = ? " +
                    " and PD01AD01 = 'R2'", objArg, null);
            map.put("PDA_AD01_R2", isNotEmpty(list) ? list : (new ArrayList()));
//            最近5年内历史表现
            list = hqldao.queryBySQL2List("select A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R2'", objArg, null);
            list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
            map.put("PDA_AD01_R2_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));
//            大额专项分期信息
            list = hqldao.queryBySQL2List("select B.PD01HJ01,B.PD01HR01,B.PD01HR02,B.PD01HJ02" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01HH B on A.PD01HS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R2'", objArg, null);
            map.put("PDA_AD01_R2_PD01HH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            标注及声明
            list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R2'", objArg, null);
            map.put("PDA_AD01_R2_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//            特殊交易信息
            list = hqldao.queryBySQL2List("select B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R2'", objArg, null);
            map.put("PDA_AD01_R2_PD01FH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
//            特殊事件说明
            list = hqldao.queryBySQL2List("select B.PD01GR01,B.PD01GD01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01GH B on A.PD01GS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ? " +
                    "and A.PD01AD01 = 'R2'", objArg, null);
            map.put("PDA_AD01_R2_PD01GH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
            /*贷记卡账户 R2 End */

            /*准贷记卡账户 R3 Start */
//            基本信息
            list = hqldao.queryBySQL2List("select PD01AD01,PD01AI04,PD01AI01,PD01AD02,PD01AI02,PD01AI03,PD01AR01,PD01AJ02," +
                    "PD01AJ03,PD01AD04,PD01AD07,PD01BR03,PD01BD01,PD01BJ01,PD01BR02,PD01BD03,PD01BJ02,PD01BD04,PD01BR01,PD01CR04," +
                    "PD01CD01,PD01CJ01,PD01CJ13,PD01CJ15,PD01CR02,PD01CJ04,PD01CR03,PD01CJ11,PD01FS01,PD01ZS01" +
                    " from CR_PER_PDA where BATCH_ID = ? " +
                    " and PD01AD01 = 'R3'", objArg, null);
            map.put("PDA_AD01_R3", isNotEmpty(list) ? list : (new ArrayList()));
//            最近5年内历史表现
            list = hqldao.queryBySQL2List("select A.PD01ER01,A.PD01ER02,B.PD01ER03,B.PD01ED01,B.PD01EJ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01EH B on B.PARENT_ID = A.ID and B.PD01ER03 >= A.PD01ER01 and B.PD01ER03 <= A.PD01ER02" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R3'", objArg, null);
            list = PD01EH_Res_into_Year(list, "PD01ER03", "PD01ER01", "PD01ER02", "PD01ED01", "PD01EJ01");
            map.put("PDA_AD01_R3_PD01EH", isNotEmpty(list) ? list : (new ArrayList()));
//            标注及声明
            list = hqldao.queryBySQL2List("select B.PD01ZD01,B.PD01ZQ01,B.PD01ZR01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01ZH B on A.PD01ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R3'", objArg, null);
            map.put("PDA_AD01_R3_PD01ZH", isNotEmpty(list) ? list : (new ArrayList()));
//            特殊交易信息
            list = hqldao.queryBySQL2List("select B.PD01FD01,B.PD01FR01,B.PD01FS02,B.PD01FJ01,B.PD01FQ01" +
                    " from CR_PER_PDA A" +
                    " right join CR_PER_PD01FH B on A.PD01FS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD01AD01 = 'R3'", objArg, null);
            map.put("PDA_AD01_R3_PD01FH", isNotEmpty(list) ? list.get(0) : new HashMap<String, Object>());
            /*准贷记卡账户 R3 End */

            /*相关还款责任信息 Start */
//            基本信息 1-个人
            list = hqldao.queryBySQL2List("select PD03AD08,PD03AD01,PD03AQ01,PD03AD02,PD03AR01,PD03AR02,PD03AD03,PD03AJ01,PD03AD04,PD03AQ02,PD03AR03," +
                    "PD03AJ02,PD03AD05,PD03AD07,PD03ZS01" +
                    " from CR_PER_PCR where BATCH_ID = ?" +
                    " and PD03AD08 = '1'"
                    , objArg, null);
            map.put("PCR_AD08_1", isNotEmpty(list) ? list : (new ArrayList()));
//            标注及声明  1-个人
            /*list = hqldao.queryBySQL2List("select B.PF03ZD01,B.PF03ZQ01,B.PF03ZR01" +
                    " from CR_PER_PCR A" +
                    " right join CR_PER_PF03ZH B on A.PD03ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD03AD08 = '1'", objArg, null);
            map.put("PCR_AD08_1_PF03ZH", isNotEmpty(list) ? list : (new ArrayList()));*/

//            基本信息 2-企业
            list = hqldao.queryBySQL2List("select PD03AD08,PD03AD01,PD03AQ01,PD03AD02,PD03AR01,PD03AR02,PD03AD03,PD03AJ01,PD03AD04,PD03AQ02,PD03AR03," +
                    "PD03AJ02,PD03AD05,PD03AS01,PD03ZS01" +
                    " from CR_PER_PCR where BATCH_ID = ?" +
                    " and PD03AD08 = '2'"
                    , objArg, null);
            map.put("PCR_AD08_2", isNotEmpty(list) ? list : (new ArrayList()));
//            标注及声明  2-企业
            /*list = hqldao.queryBySQL2List("select B.PF03ZD01,B.PF03ZQ01,B.PF03ZR01" +
                    " from CR_PER_PCR A" +
                    " right join CR_PER_PF03ZH B on A.PD03ZS01 > 0 and B.PARENT_ID = A.ID" +
                    " where A.BATCH_ID = ?" +
                    " and A.PD03AD08 = '2'", objArg, null);
            map.put("PCR_AD08_2_PF03ZH", isNotEmpty(list) ? list : (new ArrayList()));*/

            /*相关还款责任信息 End */

            /*非信贷交易信息明细 后付费记录 Start */
//            基本信息
            list = hqldao.queryBySQL2List("select PE01AD01,PE01AQ01,PE01AD02,PE01AR01,PE01AD03,PE01AJ01,PE01AR02,PE01AQ02,PE01ZS01" +
                    " from CR_PER_PND where BATCH_ID = ?"
                    , objArg, null);
            list =CR_PER_PN_AQ02_into_Year(list,"PE01AQ02","PE01AR02");
            map.put("CR_PER_PND", isNotEmpty(list) ? list : (new ArrayList()));


            /*非信贷交易信息明细 后付费记录 End */


        } catch (Exception e) {

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
        if (list.size() < 0) return null;
        int startYear = Integer.parseInt(((String) list.get(0).get(dateStart)).substring(0, 4));
        int endYear = Integer.parseInt(((String) list.get(0).get(dateEnd)).substring(0, 4));
        List<Map> res = new ArrayList<>();
        for (int i = endYear; i <= startYear; i--) {
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

 /*   public static void main(String[] args) {
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
*/
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
                        AQ02Map.put("YEAR", (_year--) +"");
                    }
                    String month=new DecimalFormat("00").format(_month);
                    AQ02Map.put("M"+month,data);
                    _month--;
                    if(j==1){
                        list.get(i).put(recordDate+"_24", _year+ recordTime.substring(4,5)+month);
                        AQ02List.add(AQ02Map);
                    }
                }
                list.get(i).put("CR_PER_PN_AQ02",AQ02List);

            }
        }
        return list;
    }
}
