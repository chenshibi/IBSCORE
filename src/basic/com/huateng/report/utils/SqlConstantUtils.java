package com.huateng.report.utils;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * 
 * @author Grassy
 *
 */
public class SqlConstantUtils {
	
	public static final String TMP_PER_REPORTID="tmp_per_reportId";
	public static final String TMP_CUST_APPID="tmp_cust_appId";
	public static final String TMP_CORP_REPORTID="tmp_corp_reportId";
	public static final String TMP_CORP_CUSTID="tmp_corp_custId";
	public static final String TMP_PER_REPORTID_SQL="select trim(t.rptId) from tmp_per_reportId t";
	public static final String TMP_CUST_APPID_SQL="select trim(t.inqCustAppId) from tmp_cust_appId t";
	public static final String TMP_CORP_REPORTID_SQL="select trim(t.rptKey)  from tmp_corp_reportId t";
	public static final String TMP_CORP_CUSTID_SQL="select trim(t.corpCustId) from tmp_corp_custId t";
	
	public static String getGen2CorpSql(String rptIds,String key){
		LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
		tableMap.put( "CR_COM_EAA" , "select count(id) from CR_COM_EAA     where id in ("+rptIds+")" );
		tableMap.put( "CR_COM_EA01CH" , "select count(id) from CR_COM_EA01CH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ECA" , "select count(id) from CR_COM_ECA     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EC020H" , "select count(id) from CR_COM_EC020H  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EC030H" , "select count(id) from CR_COM_EC030H  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EC050H" , "select count(id) from CR_COM_EC050H  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EC050H" , "select count(id) from CR_COM_EC050H  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EBA" , "select count(id) from CR_COM_EBA     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EBB" , "select count(id) from CR_COM_EBB     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EB02AH" , "select count(id) from CR_COM_EB02AH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EB02BH" , "select count(id) from CR_COM_EB02BH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EB02CH" , "select count(id) from CR_COM_EB02CH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EBC" , "select count(id) from CR_COM_EBC     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EB03AH" , "select count(id) from CR_COM_EB03AH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EB03BH" , "select count(id) from CR_COM_EB03BH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EBD" , "select count(id) from CR_COM_EBD     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EBE" , "select count(id) from CR_COM_EBE     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EB05AH" , "select count(id) from CR_COM_EB05AH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EB05BH" , "select count(id) from CR_COM_EB05BH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EDA" , "select count(id) from CR_COM_EDA     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED01" , "select count(id) from CR_COM_ED01    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED02" , "select count(id) from CR_COM_ED02    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED03" , "select count(id) from CR_COM_ED03    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED01B" , "select count(id) from CR_COM_ED01B   where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED01C" , "select count(id) from CR_COM_ED01C   where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED01BH" , "select count(id) from CR_COM_ED01BH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED01CH" , "select count(id) from CR_COM_ED01CH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EDB" , "select count(id) from CR_COM_EDB     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED04" , "select count(id) from CR_COM_ED04    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED04B" , "select count(id) from CR_COM_ED04B   where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED05" , "select count(id) from CR_COM_ED05    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EDC" , "select count(id) from CR_COM_EDC     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED06" , "select count(id) from CR_COM_ED06    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED07" , "select count(id) from CR_COM_ED07    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED08" , "select count(id) from CR_COM_ED08    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_ED09" , "select count(id) from CR_COM_ED09    where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EEA" , "select count(id) from CR_COM_EEA     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EE01BH" , "select count(id) from CR_COM_EE01BH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EFA" , "select count(id) from CR_COM_EFA     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EFB" , "select count(id) from CR_COM_EFB     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EFC" , "select count(id) from CR_COM_EFC     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EFD" , "select count(id) from CR_COM_EFD     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EF05BH" , "select count(id) from CR_COM_EF05BH  where batch_id in ("+rptIds+")");
		tableMap.put( "CR_COM_EFE" , "select count(id) from CR_COM_EFE     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EFF" , "select count(id) from CR_COM_EFF     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EFG" , "select count(id) from CR_COM_EFG     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EGA" , "select count(id) from CR_COM_EGA     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EHA" , "select count(id) from CR_COM_EHA     where id in ("+rptIds+")");
		tableMap.put( "CR_COM_EIA" , "select count(id) from CR_COM_EIA     where id in ("+rptIds+")");
		return tableMap.get(key).trim();
	}
	
	public static String getPerGen2Sql(String rptIds,String key){
		LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
		tableMap.put("CR_PER_PRH","select count(id) from CR_PER_PRH where id in ("+rptIds+")" );
		tableMap.put("CR_PER_PA01CH","select count(id) from CR_PER_PA01CH where batch_id in ("+rptIds+")" );
		tableMap.put("CR_PER_POQ" ,"select count(id) from CR_PER_POQ where id in ("+rptIds+")");
		tableMap.put("CR_PER_PQO" ,"select count(id) from CR_PER_PQO where id in ("+rptIds+")");
		tableMap.put("CR_PER_PBS" , "select count(id) from CR_PER_PBS where id in ("+rptIds+")");
		tableMap.put("CR_PER_PF06ZH","select count(id) from  CR_PER_PF06ZH where batch_id in ("+rptIds+")" );
		tableMap.put("CR_COM_EC050H" ,"select count(id) from CR_COM_EC050H where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PNO" ,"select count(id) from CR_PER_PNO where id in ("+rptIds+")");
		tableMap.put("CR_PER_PC030H","select count(id) from CR_PER_PC030H where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PPO" ,"select count(id) from CR_PER_PPO where id in ("+rptIds+")");
		tableMap.put("CR_PER_PC040H" ,"select count(id) from CR_PER_PC040H where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PAP" ,"select count(id) from CR_PER_PAP where id in ("+rptIds+")");
		tableMap.put("CR_PER_PF04ZH" ,"select count(id) from CR_PER_PF04ZH where batch_id in ("+rptIds+")" );
		tableMap.put("CR_PER_PAH" ,"select count(id) from CR_PER_PAH where id in ("+rptIds+")");
		tableMap.put("CR_PER_PF08ZH" ,"select count(id) from CR_PER_PF08ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PG010H" ,"select count(id) from CR_PER_PG010H where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PND" ,"select count(id) from CR_PER_PND where id in ("+rptIds+")");
		tableMap.put("CR_PER_PE01ZH" ,"select count(id) from CR_PER_PE01ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PF01ZH" ,"select count(id) from CR_PER_PF01ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PMM" ,"select count(id) from CR_PER_PMM where id in ("+rptIds+")");
		tableMap.put("CR_PER_PDA" ,"select count(id) from CR_PER_PDA where id in ("+rptIds+")");
		tableMap.put("CR_PER_PD01ZH","select count(id) from  CR_PER_PD01ZH where batch_id in ("+rptIds+")" );
		tableMap.put("CR_PER_PD01HH" ,"select count(id) from CR_PER_PD01HH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PD01FH" ,"select count(id) from CR_PER_PD01FH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PD01GH" ,"select count(id) from CR_PER_PD01GH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PD01DH" ,"select count(id) from CR_PER_PD01DH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PD01EH" ,"select count(id) from CR_PER_PD01EH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PRM" ,"select count(id) from CR_PER_PRM where id in ("+rptIds+")");
		tableMap.put("CR_PER_PCJ" ,"select count(id) from CR_PER_PCJ where id in ("+rptIds+")");
		tableMap.put("CR_PER_PF02ZH" ,"select count(id) from CR_PER_PF02ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PSM" ,"select count(id) from CR_PER_PSM where id in ("+rptIds+")");
		tableMap.put("CR_PER_POS" ,"select count(id) from CR_PER_POS where id in ("+rptIds+")");
		tableMap.put("CR_PER_POT" ,"select count(id) from CR_PER_POT where id in ("+rptIds+")");
		tableMap.put("CR_PER_PCE" ,"select count(id) from CR_PER_PCE where id in ("+rptIds+")");
		tableMap.put("CR_PER_PF03ZH" ,"select count(id) from CR_PER_PF03ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PIM" ,"select count(id) from CR_PER_PIM where id in ("+rptIds+")");
		tableMap.put("CR_PER_PB01BH" ,"select count(id) from CR_PER_PB01BH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PCA" ,"select count(id) from CR_PER_PCA where id in ("+rptIds+")");
		tableMap.put("CR_PER_PD02ZH" ,"select count(id) from CR_PER_PD02ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PCR" ,"select count(id) from CR_PER_PCR where id in ("+rptIds+")");
		tableMap.put("CR_PER_PD03ZH" ,"select count(id) from CR_PER_PD03ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PCO" ,"select count(id) from CR_PER_PCO where id in ("+rptIds+")");
		tableMap.put("CR_PER_PC02BH" ,"select count(id) from CR_PER_PC02BH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PC02KH" ,"select count(id) from CR_PER_PC02KH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PC02AH" ,"select count(id) from CR_PER_PC02AH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PC02DH" ,"select count(id) from CR_PER_PC02DH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_PPQ" ,"select count(id) from CR_PER_PPQ where id in ("+rptIds+")");
		tableMap.put("CR_PER_PF07ZH" ,"select count(id) from CR_PER_PF07ZH where batch_id in ("+rptIds+")");
		tableMap.put("CR_PER_POM" ,"select count(id) from CR_PER_POM where id in ("+rptIds+")");
		tableMap.put("CR_PER_PHF","select count(id) from CR_PER_PHF where id in ("+rptIds+")" );
		tableMap.put("CR_PER_PF05ZH","select count(id) from CR_PER_PF05ZH where batch_id in ("+rptIds+")" );
		tableMap.put("IND_ADDR","select count(*) from IND_ADDR  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_APP","select count(*)  from IND_APP  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_CRD_DETAIL","select count(*)  from IND_CRD_DETAIL  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_CRD_SUM","select count(*) from IND_CRD_SUM  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_DETAIL_INFO","select  count(*)  from IND_DETAIL_INFO  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_ENQUIRY","select  count(*)  from IND_ENQUIRY  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_HOUSEFUND_DEPOSIT","select  count(*)  from IND_HOUSEFUND_DEPOSIT  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_INFO","select  count(*) from IND_INFO  where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_JOB", "select  count(*)   from IND_JOB   where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_LON_DETAIL", "select  count(*)   from IND_LON_DETAIL   where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_PBOC_SCORE", "select  count(*)   from IND_PBOC_SCORE   where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("IND_SPECIAL",    "select  count(*)   from IND_SPECIAL      where  trim(rpt_id) in ("+rptIds+")" );
		tableMap.put("T_BLACKLIST",    "select  count(*)   from T_BLACKLIST      where 1=1  " );
		tableMap.put("T_COMPANY",    "select  count(*)   from T_COMPANY      where  1=1   " );
		tableMap.put("SYS_HIST",    "select  count(*)   from SYS_HIST      where  1=1  "+rptIds+"" );
		return tableMap.get(key).trim();
	}
	
	public static String getDataTableMap(String rptIds,String custAppIds,String reprtId,String corpCustId,String key){
		  LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
		  tableMap.put("t_detail_ind_app" , "select count(*) from t_detail_ind_app           where 1=1 and trim(rpt_key) in ("+rptIds+") " );         
		  tableMap.put("assure_ind_app" , "select count(*) from assure_ind_app             where 1=1 and trim(rpt_key) in ("+rptIds+") " );
		  tableMap.put("ind_assurance" , "select count(*) from ind_assurance              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_assurance_detail" , "select count(*) from ind_assurance_detail       where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_award" , "select count(*) from ind_award                  where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_breach" , "select count(*) from ind_breach                 where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_car_trade" , "select count(*) from ind_car_trade              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_disposal" , "select count(*) from ind_disposal               where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ensure" , "select count(*) from ind_ensure                 where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_housefund" , "select count(*) from ind_housefund              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_housefund_deposit" , "select count(*) from ind_housefund_deposit      where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ins_deposit" , "select count(*) from ind_ins_deposit            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ins_detail" , "select count(*) from ind_ins_detail             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ins_payment" , "select count(*) from ind_ins_payment            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_no_close_cc" , "select count(*) from ind_no_close_cc            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_no_close_loan" , "select count(*) from ind_no_close_loan          where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_no_close_pdc" , "select count(*) from ind_no_close_pdc           where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_overdue" , "select count(*) from ind_overdue                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_owe_tax" , "select count(*) from ind_owe_tax                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_pboc_score" , "select count(*) from ind_pboc_score             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_prompt" , "select count(*) from ind_prompt                 where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_public_record" , "select count(*) from ind_public_record          where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_special" , "select count(*) from ind_special                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_special_new" , "select count(*) from ind_special_new            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_statement" , "select count(*) from ind_statement              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_succour" , "select count(*) from ind_succour                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_sys_enqids" , "select count(*) from ind_sys_enqids             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_telecom_payment" , "select count(*) from ind_telecom_payment        where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_scrub_info" , "select count(*) from ind_scrub_info             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("inq_cust" , "select count(*) from inq_cust                   where 1=1 and trim(inq_cust_appid) in ("+custAppIds+")  " );
		  tableMap.put("ind_overdue_detail" , "select count(*) from ind_overdue_detail         where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_enquiry_summary" , "select count(*) from ind_enquiry_summary        where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_app" , "select count(*) from ind_app                    where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_detail_info" , "select count(*) from ind_detail_info            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_addr" , "select count(*) from ind_addr                   where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_enquiry" , "select count(*) from ind_enquiry                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_crd_detail" , "select count(*) from ind_crd_detail             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_crd_sum" , "select count(*) from ind_crd_sum                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_lon_detail" , "select count(*) from ind_lon_detail             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_info" , "select count(*) from ind_info                   where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_job" , "select count(*) from ind_job                    where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("t_corp_detail_assure" , "select count(*) from t_corp_detail_assure       where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_assure_item" , "select count(*) from t_corp_detail_assure_item  where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_loan" , "select count(*) from t_corp_detail_loan         where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_others" , "select count(*) from t_corp_detail_others       where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_summary" , "select count(*) from t_corp_detail_summary      where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_history_enquiry" , "select count(*) from t_corp_history_enquiry     where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_basic" , "select count(*) from t_corp_info_basic          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_executive" , "select count(*) from t_corp_info_executive      where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_investor" , "select count(*) from t_corp_info_investor       where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_relevant_corp" , "select count(*) from t_corp_info_relevant_corp  where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_public_award" , "select count(*) from t_corp_public_award        where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_public_owe_tax" , "select count(*) from t_corp_public_owe_tax      where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_public_text" , "select count(*) from t_corp_public_text         where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_report" , "select count(*) from t_corp_report              where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_statement" , "select count(*) from t_corp_statement           where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_assure" , "select count(*) from t_corp_sum_assure          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_credit" , "select count(*) from t_corp_sum_credit          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("corp_cust" , "select count(*) from corp_cust                  where 1=1 and trim(id) in ("+corpCustId+")  " );
		  tableMap.put("t_corp_app" , "select count(*) from t_corp_app                 where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("corp_scurb_info" , "select count(*) from corp_scurb_info            where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("T_CORP_DETAIL_APP" , "select count(*) from T_CORP_DETAIL_APP          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_debit_history" , "select count(*) from t_corp_sum_debit_history   where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_credit_items" , "select count(*) from t_corp_sum_credit_items    where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("logrequest" ,   "select count(*) from logrequest                 where 1=1 and trim(rptId) in ("+rptIds+")  " );
		  tableMap.put("logrequestaps" , "select count(*) from logrequestaps              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("logrequestlaps" , "select count(*) from logrequestlaps             where 1=1 and trim(rptId) in ("+rptIds+")  " );
		  tableMap.put("logresponse" , "select count(*) from logresponse                where 1=1 and trim(reportId) in ("+rptIds+")  " );
		  tableMap.put("logresponseaps" , "select count(*) from logresponseaps             where 1=1 and trim(reportId) in ("+rptIds+")  " );
		  tableMap.put("logresponselaps" , "select count(*) from logresponselaps            where 1=1 and trim(reportId) in ("+rptIds+")  " );
		  tableMap.put("t_corp_judge_record",         "select count(*) from t_corp_judge_record where 1=1");
		  tableMap.put("corp_loancard_scurb_info" , "select count(*) from corp_loancard_scurb_info   where 1=1   " );
		  tableMap.put("t_corp_loancard_inq" , "select count(*) from t_corp_loancard_inq        where 1=1   " );
		  tableMap.put("t_corp_loancard_resp" , "select count(*) from t_corp_loancard_resp       where 1=1   " );
		  tableMap.put("t_blacklist" , "select count(*) from t_blacklist                where 1=1   " );
		  tableMap.put("t_company" , "select count(*) from t_company                  where 1=1   " );
		  tableMap.put("t_corp_batch" , "select count(*) from t_corp_batch               where 1=1   " );
		  tableMap.put("t_related_party_log" , "select count(*) from t_related_party_log        where 1=1   " );
		  tableMap.put("tmp_company" , "select count(*) from tmp_company                where 1=1   " );
		  tableMap.put("tmp_individual" , "select count(*) from tmp_individual             where 1=1   " );
		  tableMap.put("TLR_INFO_CHANGE" , "select count(*) from TLR_INFO_CHANGE            where 1=1   " );
		  tableMap.put("TLR_ROLE_REL_CHANGE" , "select count(*) from TLR_ROLE_REL_CHANGE        where 1=1   " );
		  tableMap.put("LOGRESPONSEAPS_EXD",  "select count(*) from LOGRESPONSEAPS_EXD         where 1=1   " );
		  tableMap.put("sys_hist" , "select count(*) from sys_hist                   where 1=1   " );
		  tableMap.put("sys_user" , "select count(*) from sys_user                   where 1=1   " );
		  return tableMap.get(key).trim();
		
	}
	
	public static LinkedHashMap<String,String> getDataTableMap(String rptIds,String custAppIds,String reprtId,String corpCustId){
		  LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
		  tableMap.put("t_detail_ind_app          " , "select * from t_detail_ind_app           where 1=1 and trim(rpt_key) in ("+rptIds+") " );         
		  tableMap.put("assure_ind_app            " , "select * from assure_ind_app             where 1=1 and trim(rpt_key) in ("+rptIds+") " );
		  tableMap.put("ind_assurance             " , "select * from ind_assurance              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_assurance_detail      " , "select * from ind_assurance_detail       where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_award                 " , "select * from ind_award                  where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_breach                " , "select * from ind_breach                 where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_car_trade             " , "select * from ind_car_trade              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_disposal              " , "select * from ind_disposal               where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ensure                " , "select * from ind_ensure                 where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_housefund             " , "select * from ind_housefund              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_housefund_deposit     " , "select * from ind_housefund_deposit      where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ins_deposit           " , "select * from ind_ins_deposit            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ins_detail            " , "select * from ind_ins_detail             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_ins_payment           " , "select * from ind_ins_payment            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_no_close_cc           " , "select * from ind_no_close_cc            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_no_close_loan         " , "select * from ind_no_close_loan          where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_no_close_pdc          " , "select * from ind_no_close_pdc           where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_overdue               " , "select * from ind_overdue                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_owe_tax               " , "select * from ind_owe_tax                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_pboc_score            " , "select * from ind_pboc_score             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_prompt                " , "select * from ind_prompt                 where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_public_record         " , "select * from ind_public_record          where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_special               " , "select * from ind_special                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_special_new           " , "select * from ind_special_new            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_statement             " , "select * from ind_statement              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_succour               " , "select * from ind_succour                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_sys_enqids            " , "select * from ind_sys_enqids             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_telecom_payment       " , "select * from ind_telecom_payment        where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_scrub_info            " , "select * from ind_scrub_info             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("inq_cust                  " , "select * from inq_cust                   where 1=1 and trim(inq_cust_appid) in ("+custAppIds+")  " );
		  tableMap.put("ind_overdue_detail        " , "select * from ind_overdue_detail         where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_enquiry_summary       " , "select * from ind_enquiry_summary        where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_app                   " , "select * from ind_app                    where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_detail_info           " , "select * from ind_detail_info            where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_addr                  " , "select * from ind_addr                   where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_enquiry               " , "select * from ind_enquiry                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_crd_detail            " , "select * from ind_crd_detail             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_crd_sum               " , "select * from ind_crd_sum                where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_lon_detail            " , "select * from ind_lon_detail             where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_info                  " , "select * from ind_info                   where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("ind_job                   " , "select * from ind_job                    where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("t_corp_detail_assure      " , "select * from t_corp_detail_assure       where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_assure_item " , "select * from t_corp_detail_assure_item  where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_loan        " , "select * from t_corp_detail_loan         where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_others      " , "select * from t_corp_detail_others       where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_detail_summary     " , "select * from t_corp_detail_summary      where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_history_enquiry    " , "select * from t_corp_history_enquiry     where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_basic         " , "select * from t_corp_info_basic          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_executive     " , "select * from t_corp_info_executive      where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_investor      " , "select * from t_corp_info_investor       where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_info_relevant_corp " , "select * from t_corp_info_relevant_corp  where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_public_award       " , "select * from t_corp_public_award        where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_public_owe_tax     " , "select * from t_corp_public_owe_tax      where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_public_text        " , "select * from t_corp_public_text         where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_report             " , "select * from t_corp_report              where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_statement          " , "select * from t_corp_statement           where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_assure         " , "select * from t_corp_sum_assure          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_credit         " , "select * from t_corp_sum_credit          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("corp_cust                 " , "select * from corp_cust                  where 1=1 and trim(id) in ("+corpCustId+")  " );
		  tableMap.put("t_corp_app                " , "select * from t_corp_app                 where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("corp_scurb_info           " , "select * from corp_scurb_info            where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("T_CORP_DETAIL_APP         " , "select * from T_CORP_DETAIL_APP          where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_debit_history  " , "select * from t_corp_sum_debit_history   where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("t_corp_sum_credit_items   " , "select * from t_corp_sum_credit_items    where 1=1 and trim(rpt_key) in ("+reprtId+")  " );
		  tableMap.put("logrequest              " ,   "select * from logrequest                 where 1=1 and trim(rptId) in ("+rptIds+")  " );
		  tableMap.put("logrequestaps             " , "select * from logrequestaps              where 1=1 and trim(rpt_id) in ("+rptIds+")  " );
		  tableMap.put("logrequestlaps            " , "select * from logrequestlaps             where 1=1 and trim(rptId) in ("+rptIds+")  " );
		  tableMap.put("logresponse               " , "select * from logresponse                where 1=1 and trim(reportId) in ("+rptIds+")  " );
		  tableMap.put("logresponseaps            " , "select * from logresponseaps             where 1=1 and trim(reportId) in ("+rptIds+")  " );
		  tableMap.put("logresponselaps           " , "select * from logresponselaps            where 1=1 and trim(reportId) in ("+rptIds+")  " );
		  tableMap.put("t_corp_judge_record",         "select * from t_corp_judge_record where 1=1");
		  tableMap.put("corp_loancard_scurb_info  " , "select * from corp_loancard_scurb_info   where 1=1   " );
		  tableMap.put("t_corp_loancard_inq       " , "select * from t_corp_loancard_inq        where 1=1   " );
		  tableMap.put("t_corp_loancard_resp      " , "select * from t_corp_loancard_resp       where 1=1   " );
		  tableMap.put("t_blacklist               " , "select * from t_blacklist                where 1=1   " );
		  tableMap.put("t_company                 " , "select * from t_company                  where 1=1   " );
		  tableMap.put("t_corp_batch              " , "select * from t_corp_batch               where 1=1   " );
		  tableMap.put("t_related_party_log       " , "select * from t_related_party_log        where 1=1   " );
		  tableMap.put("tmp_company               " , "select * from tmp_company                where 1=1   " );
		  tableMap.put("tmp_individual            " , "select * from tmp_individual             where 1=1   " );
		  tableMap.put("TLR_INFO_CHANGE           " , "select * from TLR_INFO_CHANGE            where 1=1   " );
		  tableMap.put("TLR_ROLE_REL_CHANGE       " , "select * from TLR_ROLE_REL_CHANGE        where 1=1   " );
		  tableMap.put("LOGRESPONSEAPS_EXD        ",  "select * from LOGRESPONSEAPS_EXD         where 1=1   " );
		  tableMap.put("sys_hist                  " , "select * from sys_hist                   where 1=1   " );
		  tableMap.put("sys_user                  " , "select * from sys_user                   where 1=1   " );
		  return tableMap;
		
	}
	
	public static String getPerGen2TableName(String key) {
		Map<String,String> tableMap=new LinkedHashMap<String,String>();
		tableMap.put("63","T_BLACKLIST");
		tableMap.put("64","T_COMPANY");
		tableMap.put("65","SYS_HIST");
		return tableMap.get(key).trim();
	}
	
	public static LinkedHashMap<String,String> getPerGen2TableMap(String rptIds){
		LinkedHashMap<String,String> tableMap=new LinkedHashMap<String,String>();
		tableMap.put("T_BLACKLIST","select * from T_BLACKLIST where id in ("+rptIds+")" );
		tableMap.put("T_COMPANY","select * from T_COMPANY where id in ("+rptIds+")" );
		tableMap.put("SYS_HIST","select * from SYS_HIST where id in ("+rptIds+")" );
		return tableMap;
		
	}



	
}
