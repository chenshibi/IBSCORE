package com.huateng.report.pboc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.orm.HQLDAO;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

@Service
public class PbocCorpQueryService
{
  private static final Logger logger = Logger.getLogger(PbocCorpQueryService.class);

  public static PbocCorpQueryService getInstance() {
    return (PbocCorpQueryService)ApplicationContextUtils.getBean(PbocCorpQueryService.class);
  }

  public static boolean isNotEmpty(List list)
  {
    return (list != null) && (list.size() != 0);
  }

  public Map<String, Object> getCorpReport(String uuid)
  {
    Map map = new HashMap();
    map.put("uuid", uuid);
    try {
      HQLDAO hqldao = ROOTDAOUtils.getHQLDAO();
      String[] objArg = { uuid };
      List list = null;
      List list1= null;
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EAA where id = ? ", objArg, null);
      map.put("EAA", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ECA where id = ? ", objArg, null);
      map.put("ECA", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EBA where id = ? ", objArg, null);
      map.put("EBA", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EBB where id = ? and EB02AS01 is not null", objArg, null);//未结清
      map.put("EBB", isNotEmpty(list) ? list.get(0) : new HashMap());
      //add by chensibi start
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EBB where id = ? and EB02BS01 is not null", objArg, null); //已结清
      map.put("EBB1", isNotEmpty(list) ? list.get(0) : new HashMap());
      //add by chensibi end
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EBC where id = ? ", objArg, null);
      map.put("EBC", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EBD where id = ? ", objArg, null);
      map.put("EBD", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EBE where id = ? ", objArg, null);
      map.put("EBE", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EDA where id = ? ", objArg, null);
      map.put("EDA", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.ED01BJ01,ED01BH.ED01BR01,ED01BH.ED01BD01,ED01BH.ED01BR04,ED01BH.ED01BJ02,ED01BH.ED01BD02,ED01BH.ED01BR05,ED01BH.ED01BJ03,ED01BH.ED01BJ04,ED01BH.ED01BJ05,ED01BH.ED01BS02,ED01BH.ED01BS03,ED01CH.ED01CD01  from (select * from CR_COM_ED01  where batch_id = ?  and (ED01AD05 = '41' or ED01AD05 = '51')) ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      StringBuffer sql1=new StringBuffer();
      sql1.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01AR01,s.ED01AD07,s.ED01AJ01,s.ED01AR04,s.ED01AR03,s.ED01BJ01,s.ED01BR01,s.ED01BD01,s.ED01BR04,s.ED01BJ02,s.ED01BD02,s.ED01BR05,s.ED01BJ03,s.ED01BJ04,s.ED01BJ05,s.ED01BS02,s.ED01BS03,s.ED01CD01")
      .append(" from (select ED01.*,ED01BH.*,ED01CH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR01 desc) as a_index")
      .append(" from (select *from CR_COM_ED01 where batch_id = ?  and (ED01AD05 = '41' or ED01AD05 = '51')) ED01 ")
      .append(" left join CR_COM_ED01BH ED01BH  on ED01.ID = ED01BH.PARENTID left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID) s")
      .append(" where s.a_index <= 1");  
      list1 = hqldao.queryBySQL2List(sql1.toString(),objArg,null);  
      map.put("ED01_51", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_51List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(
        " select * from CR_COM_ED01  where batch_id = ?  and (ED01AD05 = '41' or ED01AD05 = '51')  ", 
        objArg, null);
      map.put("ED01_51Size", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED03 where batch_id = ? order by ED030I02,ED030R02 desc", objArg, null); //排序
      list1 = hqldao.queryBySQL2List("select s.* from (select ed03.*,row_number() over (partition by ed03.ED030I02 order by ed03.ED030I02,ed03.ED030R02 desc) ed03_index from(SELECT * FROM CR_COM_ED03  where batch_id = ? ) ed03) s where s.ed03_index<=1", objArg, null); 
      map.put("ED03", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED03List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.ED01BJ01,ED01BH.ED01BR01,ED01BH.ED01BD01,ED01BH.ED01BR04,ED01BH.ED01BJ02,ED01BH.ED01BD02,ED01BH.ED01BR05,ED01BH.ED01BJ03,ED01BH.ED01BJ04,ED01BH.ED01BJ05,ED01BH.ED01BS02,ED01BH.ED01BS03,ED01CH.ED01CD01  from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30'))  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      StringBuffer sql2=new StringBuffer();
      sql2.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01AD06,s.ED01AR01,s.ED01AR02,s.ED01AD07,s.ED01AJ01,s.ED01AD10,s.ED01AD08,s.ED01AI03,s.ED01BJ01,s.ED01BR01,s.ED01BD01,s.ED01BR04,s.ED01BJ02,s.ED01BD02,s.ED01BR05,s.ED01BJ03,s.ED01BJ04,s.ED01BJ05,s.ED01BS02,s.ED01BS03,s.ED01CD01")
      .append(" from (select ED01.*,ED01BH.*,ED01CH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR01 desc) as a_index")
      .append(" from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30')) ED01 ")
      .append(" left join CR_COM_ED01BH ED01BH  on ED01.ID = ED01BH.PARENTID left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID) s")
      .append(" where s.a_index <= 1");  
      list1 = hqldao.queryBySQL2List(sql2.toString(),objArg,null);  
      map.put("ED01_1_23", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_1_23List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("select * from CR_COM_ED01  where batch_id = ? and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30')", 
        objArg, null);
      map.put("ED01_1_23Size", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.ED01BJ01,ED01BH.ED01BR01,ED01BH.ED01BD01,ED01BH.ED01BR04,ED01BH.ED01BJ02,ED01BH.ED01BD02,ED01BH.ED01BR05,ED01BH.ED01BJ03,ED01BH.ED01BJ04,ED01BH.ED01BJ05,ED01BH.ED01BS02,ED01BH.ED01BS03,ED01CH.ED01CD01  from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      StringBuffer sql3=new StringBuffer();
      sql3.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01AD06,s.ED01AR01,s.ED01AR02,s.ED01AD07,s.ED01AJ01,s.ED01AD10,s.ED01AD08,s.ED01AI03,s.ED01BJ01,s.ED01BR01,s.ED01BD01,s.ED01BR04,s.ED01BJ02,s.ED01BD02,s.ED01BR05,s.ED01BJ03,s.ED01BJ04,s.ED01BJ05,s.ED01BS02,s.ED01BS03,s.ED01CD01")
      .append(" from (select ED01.*,ED01BH.*,ED01CH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR01 desc) as a_index")
      .append(" from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10') ED01 ")
      .append(" left join CR_COM_ED01BH ED01BH  on ED01.ID = ED01BH.PARENTID left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID) s")
      .append(" where s.a_index <= 1");  
      list1 = hqldao.queryBySQL2List(sql3.toString(),objArg,null);  
      map.put("ED01_1_1", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_1_1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("select * from CR_COM_ED01  where batch_id = ? and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10'", 
        objArg, null);
      map.put("ED01_1_1Size", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.ED01BJ01,ED01BH.ED01BR01,ED01BH.ED01BD01,ED01BH.ED01BR04,ED01BH.ED01BJ02,ED01BH.ED01BD02,ED01BH.ED01BR05,ED01BH.ED01BJ03,ED01BH.ED01BJ04,ED01BH.ED01BJ05,ED01BH.ED01BS02,ED01BH.ED01BS03,ED01CH.ED01CD01  from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and ED01AD02 = 'R1')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      StringBuffer sql4=new StringBuffer();
      sql4.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01AD06,s.ED01AR01,s.ED01AR02,s.ED01AD07,s.ED01AJ01,s.ED01AD10,s.ED01AD08,s.ED01AI03,s.ED01BJ01,s.ED01BR01,s.ED01BD01,s.ED01BR04,s.ED01BJ02,s.ED01BD02,s.ED01BR05,s.ED01BJ03,s.ED01BJ04,s.ED01BJ05,s.ED01BS02,s.ED01BS03,s.ED01CD01")
      .append(" from (select ED01.*,ED01BH.*,ED01CH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR01 desc) as a_index")
      .append(" from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and ED01AD02 = 'R1') ED01 ")
      .append(" left join CR_COM_ED01BH ED01BH  on ED01.ID = ED01BH.PARENTID left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID) s")
      .append(" where s.a_index <= 1");  
      list1 = hqldao.queryBySQL2List(sql4.toString(),objArg,null);  
      map.put("ED01_1_R1", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_1_R1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("select * from CR_COM_ED01  where batch_id = ? and ED01AD01 = '1' and ED01AD02 = 'R1'", 
        objArg, null);
      map.put("ED01_1_R1Size", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.ED01BJ01,ED01BH.ED01BR01,ED01BH.ED01BD01,ED01BH.ED01BR04,ED01BH.ED01BJ02,ED01BH.ED01BD02,ED01BH.ED01BR05,ED01BH.ED01BJ03,ED01BH.ED01BJ04,ED01BH.ED01BJ05,ED01BH.ED01BS02,ED01BH.ED01BS03,ED01CH.ED01CD01  from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30'))  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR04 desc", 
        objArg, null);
      StringBuffer sql5=new StringBuffer();
      sql5.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01AD06,s.ED01AR01,s.ED01AR02,s.ED01AD07,s.ED01AJ01,s.ED01AD10,s.ED01AD08,s.ED01AI03,s.ED01BJ01,s.ED01BR01,s.ED01BD01,s.ED01BR04,s.ED01BJ02,s.ED01BD02,s.ED01BR05,s.ED01BJ03,s.ED01BJ04,s.ED01BJ05,s.ED01BS02,s.ED01BS03,s.ED01CD01")
      .append(" from (select ED01.*,ED01BH.*,ED01CH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR04 desc) as a_index")
      .append(" from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30')) ED01 ")
      .append(" left join (select * from CR_COM_ED01BH where ED01BR04 is not null) ED01BH  on ED01.ID = ED01BH.PARENTID left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID) s")
      .append(" where s.a_index <= 1");  
      list1 = hqldao.queryBySQL2List(sql5.toString(),objArg,null);  
      map.put("ED01_2_23", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_2_23List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("select * from CR_COM_ED01  where batch_id = ? and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30')", 
        objArg, null);
      map.put("ED01_2_23Size", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.ED01BJ01,ED01BH.ED01BR01,ED01BH.ED01BD01,ED01BH.ED01BR04,ED01BH.ED01BJ02,ED01BH.ED01BD02,ED01BH.ED01BR05,ED01BH.ED01BJ03,ED01BH.ED01BJ04,ED01BH.ED01BJ05,ED01BH.ED01BS02,ED01BH.ED01BS03,ED01CH.ED01CD01  from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR04 desc", 
        objArg, null);
      StringBuffer sql6=new StringBuffer();
      sql6.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01AD06,s.ED01AR01,s.ED01AR02,s.ED01AD07,s.ED01AJ01,s.ED01AD10,s.ED01AD08,s.ED01AI03,s.ED01BJ01,s.ED01BR01,s.ED01BD01,s.ED01BR04,s.ED01BJ02,s.ED01BD02,s.ED01BR05,s.ED01BJ03,s.ED01BJ04,s.ED01BJ05,s.ED01BS02,s.ED01BS03,s.ED01CD01")
      .append(" from (select ED01.*,ED01BH.*,ED01CH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR04 desc) as a_index")
      .append(" from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10') ED01 ")
      .append(" left join (select * from CR_COM_ED01BH where ED01BR04 is not null) ED01BH  on ED01.ID = ED01BH.PARENTID left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID) s")
      .append(" where s.a_index <= 1");  
      list1 = hqldao.queryBySQL2List(sql6.toString(),objArg,null);  
      map.put("ED01_2_1", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_2_1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("select * from CR_COM_ED01  where batch_id = ? and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10'", 
        objArg, null);
      map.put("ED01_2_1Size", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.ED01BJ01,ED01BH.ED01BR01,ED01BH.ED01BD01,ED01BH.ED01BR04,ED01BH.ED01BJ02,ED01BH.ED01BD02,ED01BH.ED01BR05,ED01BH.ED01BJ03,ED01BH.ED01BJ04,ED01BH.ED01BJ05,ED01BH.ED01BS02,ED01BH.ED01BS03,ED01CH.ED01CD01  from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and ED01AD02 = 'R1') ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR04 desc", 
        objArg, null);
      StringBuffer sql7=new StringBuffer();
      sql7.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01AD06,s.ED01AR01,s.ED01AR02,s.ED01AD07,s.ED01AJ01,s.ED01AD10,s.ED01AD08,s.ED01AI03,s.ED01BJ01,s.ED01BR01,s.ED01BD01,s.ED01BR04,s.ED01BJ02,s.ED01BD02,s.ED01BR05,s.ED01BJ03,s.ED01BJ04,s.ED01BJ05,s.ED01BS02,s.ED01BS03,s.ED01CD01")
      .append(" from (select ED01.*,ED01BH.*,ED01CH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR04 desc) as a_index")
      .append(" from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and ED01AD02 = 'R1') ED01 ")
      .append(" left join (select * from CR_COM_ED01BH where ED01BR04 is not null) ED01BH  on ED01.ID = ED01BH.PARENTID left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID) s")
      .append(" where s.a_index <= 1");  
      list1 = hqldao.queryBySQL2List(sql7.toString(),objArg,null);  
      map.put("ED01_2_R1", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_2_R1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("select * from CR_COM_ED01  where batch_id = ? and ED01AD01 = '2' and ED01AD02 = 'R1'", 
        objArg, null);
      map.put("ED01_2_R1Size", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED02 where batch_id = ? and ED020S01 is not null order by ED020I02", objArg, null);  //排序
      map.put("ED02List", isNotEmpty(list) ? list : new ArrayList()); //未结清
      
      //add by chensibi start
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED02 where batch_id = ? and ED020S02 is not null order by ED020I02", objArg, null);  //排序
      map.put("ED02List1", isNotEmpty(list) ? list : new ArrayList());//已结清
      //add by chensibi end

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED05 where (ED050D02 = '51' or ED050D02 = '61') and batch_id = ? and ED050S01 is not null order by ED050I02", 
        objArg, null);
      map.put("ED05_51_61List1", isNotEmpty(list) ? list : new ArrayList());//未结清
      
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED05 where (ED050D02 = '51' or ED050D02 = '61') and batch_id = ? and ED050S02 is not null order by ED050I02", 
    	        objArg, null);
      map.put("ED05_51_61List2", isNotEmpty(list) ? list : new ArrayList());//已结清

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED05 where ED050D02 <> '51' and ED050D02 <> '61' and batch_id = ? and ED050S01 is not null order by ED050I02",   //排序
        objArg, null);
      map.put("ED05_51_otherList", isNotEmpty(list) ? list : new ArrayList());//未结清
      
      //add by chensibi start
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED05 where ED050D02 <> '51' and ED050D02 <> '61' and batch_id = ? and ED050S02 is not null order by ED050I02",   //排序
    	        objArg, null);
      map.put("ED05_51_otherList1", isNotEmpty(list) ? list : new ArrayList());//已结清
      //add by chensibi end

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EDB where id = ? ", objArg, null);
      map.put("EDB", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED06 where batch_id = ? order by ED060I01,ED060I02,ED060R03 desc", objArg, null);   //排序
      map.put("ED06", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EDCList", isNotEmpty(list) ? list : new ArrayList());
      list1 = hqldao.queryBySQL2List("select s.* from (select ed06.*,row_number() over (partition by ed06.ED060I01,ed06.ED060I02 order by ed06.ED060I01,ed06.ED060I02,ed06.ED060R03 desc) ed03_index from(SELECT * FROM CR_COM_ED06  where batch_id = ? ) ed06) s where s.ed03_index<=1", objArg, null); 
      map.put("EDCList1", isNotEmpty(list1) ? list1 : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED07 where ED070I01 IS NOT NULL and batch_id = ? order by ED070I01,ED070I02,ED070R03 desc", objArg, null);
      map.put("ED07", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EDD_1", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED08 where ED080I01 IS NOT NULL and batch_id = ? order by ED080I01,ED080I02 desc", objArg, null);
      map.put("ED08", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EDD_2", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED09 where ED090I01 IS NOT NULL and batch_id = ? order by ED090I01,ED090I02 desc", objArg, null);
      map.put("ED09", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EDD_3", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EEA where id = ? ", objArg, null);
      map.put("EEA", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EFA where id = ? ", objArg, null);
      map.put("EFA", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EFAList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EFB where id = ? ", objArg, null);
      map.put("EFB", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EFBList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EFC where id = ? ", objArg, null);
      map.put("EFC", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EFCList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EFD where id = ? ", objArg, null);
      map.put("EFD", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EFDList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EFE where id = ? ", objArg, null);
      map.put("EFE", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EFEList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EFF where id = ? ", objArg, null);
      map.put("EFF", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EFFList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EFG where id = ? ", objArg, null);
      map.put("EFG", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EFGList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EHA where id = ? ", objArg, null);
      map.put("EHA", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EHAList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EIA where id = ? ", objArg, null);
      map.put("EIA", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EIAList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EA01CH where batch_id = ? ", objArg, null);
      map.put("EA01CH", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EC020H where batch_id = ? ", objArg, null);
      map.put("EC020H", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EC030H where batch_id = ? ", objArg, null);
      map.put("EC030H", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EC050H where batch_id = ? ", objArg, null);
      map.put("EC050H", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where id = ? ", objArg, null);
      map.put("EB02AH", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '1' and EB02AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02AH_1_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '1' and EB02AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02AH_1_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '1' and EB02AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02AH_1_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '1' and EB02AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02AH_1_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '2' and EB02AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02AH_2_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '2' and EB02AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02AH_2_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '2' and EB02AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02AH_2_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '2' and EB02AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02AH_2_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '3' and EB02AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02AH_3_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '3' and EB02AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02AH_3_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '3' and EB02AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02AH_3_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '3' and EB02AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02AH_3_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '4' and EB02AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02AH_4_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '4' and EB02AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02AH_4_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '4' and EB02AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02AH_4_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '4' and EB02AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02AH_4_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '0' and EB02AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02AH_0_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '0' and EB02AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02AH_0_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '0' and EB02AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02AH_0_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02AH where EB02AD01 = '0' and EB02AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02AH_0_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where batch_id = ? ", objArg, null);
      map.put("EB02BH", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '1' and EB02BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02BH_1_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '1' and EB02BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02BH_1_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '1' and EB02BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02BH_1_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '1' and EB02BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02BH_1_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '2' and EB02BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02BH_2_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '2' and EB02BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02BH_2_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '2' and EB02BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02BH_2_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '2' and EB02BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02BH_2_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '3' and EB02BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02BH_3_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '3' and EB02BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02BH_3_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '3' and EB02BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02BH_3_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '3' and EB02BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02BH_3_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '4' and EB02BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02BH_4_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '4' and EB02BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02BH_4_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '4' and EB02BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02BH_4_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '4' and EB02BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02BH_4_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '0' and EB02BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB02BH_0_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '0' and EB02BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB02BH_0_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '0' and EB02BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB02BH_0_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02BH where EB02BD01 = '0' and EB02BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB02BH_0_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB02CH where batch_id = ? order by EB02CR01 ", objArg, null);
      map.put("EB02CH", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where batch_id = ? ", objArg, null);
      map.put("EB03AH", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '1' and EB03AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03AH_1_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '1' and EB03AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03AH_1_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '1' and EB03AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03AH_1_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '1' and EB03AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03AH_1_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '2' and EB03AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03AH_2_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '2' and EB03AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03AH_2_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '2' and EB03AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03AH_2_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '2' and EB03AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03AH_2_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '3' and EB03AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03AH_3_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '3' and EB03AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03AH_3_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '3' and EB03AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03AH_3_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '3' and EB03AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03AH_3_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '9' and EB03AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03AH_9_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '9' and EB03AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03AH_9_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '9' and EB03AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03AH_9_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '9' and EB03AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03AH_9_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '0' and EB03AD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03AH_0_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '0' and EB03AD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03AH_0_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '0' and EB03AD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03AH_0_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03AH where EB03AD01 = '0' and EB03AD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03AH_0_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where batch_id = ? ", objArg, null);
      map.put("EB03BH", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '1' and EB03BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03BH_1_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '1' and EB03BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03BH_1_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '1' and EB03BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03BH_1_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '1' and EB03BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03BH_1_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '2' and EB03BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03BH_2_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '2' and EB03BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03BH_2_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '2' and EB03BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03BH_2_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '2' and EB03BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03BH_2_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '3' and EB03BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03BH_3_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '3' and EB03BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03BH_3_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '3' and EB03BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03BH_3_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '3' and EB03BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03BH_3_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '9' and EB03BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03BH_9_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '9' and EB03BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03BH_9_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '9' and EB03BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03BH_9_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '9' and EB03BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03BH_9_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '0' and EB03BD02 = '1' and batch_id = ? ", objArg, null);
      map.put("EB03BH_0_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '0' and EB03BD02 = '2' and batch_id = ? ", objArg, null);
      map.put("EB03BH_0_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '0' and EB03BD02 = '3' and batch_id = ? ", objArg, null);
      map.put("EB03BH_0_3", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB03BH where EB03BD01 = '0' and EB03BD02 = '0' and batch_id = ? ", objArg, null);
      map.put("EB03BH_0_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05AH where batch_id = ? ", objArg, null);
      map.put("EB05AH", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05AH where EB05AD01 ='1' and batch_id = ? ", objArg, null);
      map.put("EB05AH_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05AH where EB05AD01 ='2' and batch_id = ? ", objArg, null);
      map.put("EB05AH_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05AH where EB05AD01 ='9' and batch_id = ? ", objArg, null);
      map.put("EB05AH_9", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05AH where EB05AD01 ='0' and batch_id = ? ", objArg, null);
      map.put("EB05AH_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05BH where batch_id = ? ", objArg, null);
      map.put("EB05BH", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05BH where EB05BD01 ='1' and batch_id = ? ", objArg, null);
      map.put("EB05BH_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05BH where EB05BD01 ='2' and batch_id = ? ", objArg, null);
      map.put("EB05BH_2", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05BH where EB05BD01 ='9' and batch_id = ? ", objArg, null);
      map.put("EB05BH_9", isNotEmpty(list) ? list.get(0) : new HashMap());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EB05BH where EB05BD01 ='0' and batch_id = ? ", objArg, null);
      map.put("EB05BH_0", isNotEmpty(list) ? list.get(0) : new HashMap());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED01BH where batch_id = ? ", objArg, null);
      map.put("ED01BH", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_ED01CH where batch_id = ? ", objArg, null);
      map.put("ED01CH", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EE01BH where batch_id = ? ", objArg, null);
      map.put("EE01BH", isNotEmpty(list) ? list : new ArrayList());
      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EF05BH where batch_id = ? ", objArg, null);
      map.put("EF05BH", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT * FROM CR_COM_EGA where id = ? ", objArg, null);
      map.put("EGA", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("EGAList", isNotEmpty(list) ? list : new ArrayList());

      Date nowday = new Date();
      int nowyear = nowday.getYear() + 1900;
      int year1 = nowyear - 1;
      int year2 = nowyear - 2;
      int year3 = nowyear - 3;
      map.put("nowyear", Integer.valueOf(nowyear));
      map.put("year1", Integer.valueOf(year1));
      map.put("year2", Integer.valueOf(year2));
      map.put("year3", Integer.valueOf(year3));

      list = hqldao.queryBySQL2List("SELECT EG01AR01,EG01AD02,EG01AD03 FROM CR_COM_EGA where  EG01AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_fuzha(list, map, "EG01AR01", "EG01AD02", "EG01AD03");
      list = hqldao.queryBySQL2List("SELECT EG02AR01,EG02AD02,EG02AD03 FROM CR_COM_EGA where  EG02AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_fuzha(list, map, "EG02AR01", "EG02AD02", "EG02AD03");
      list = hqldao.queryBySQL2List("SELECT EG07AR01,EG07AD02,EG07AD03 FROM CR_COM_EGA where  EG07AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_fuzha(list, map, "EG07AR01", "EG07AD02", "EG07AD03");
      list = hqldao.queryBySQL2List("SELECT EG08AR01,EG08AD02,EG08AD03 FROM CR_COM_EGA where  EG08AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_fuzha(list, map, "EG08AR01", "EG08AD02", "EG08AD03");

      list = hqldao.queryBySQL2List("SELECT EG03AR01,EG03AD02,EG03AD03 FROM CR_COM_EGA where  EG03AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_shouru(list, map, "EG03AR01", "EG03AD02", "EG03AD03");
      list = hqldao.queryBySQL2List("SELECT EG04AR01,EG04AD02,EG04AD03 FROM CR_COM_EGA where  EG04AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_shouru(list, map, "EG04AR01", "EG04AD02", "EG04AD03");
      list = hqldao.queryBySQL2List("SELECT EG09AR01,EG09AD02,EG09AD03 FROM CR_COM_EGA where  EG09AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_shouru(list, map, "EG09AR01", "EG09AD02", "EG09AD03");
      list = hqldao.queryBySQL2List("SELECT EG10AR01,EG10AD02,EG10AD03 FROM CR_COM_EGA where  EG10AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_shouru(list, map, "EG10AR01", "EG10AD02", "EG10AD03");

      list = hqldao.queryBySQL2List("SELECT EG05AR01,EG05AD02,EG05AD03 FROM CR_COM_EGA where  EG05AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_xianjin(list, map, "EG05AR01", "EG05AD02", "EG05AD03");
      list = hqldao.queryBySQL2List("SELECT EG06AR01,EG06AD02,EG06AD03 FROM CR_COM_EGA where  EG06AI01 IS NOT NULL and  id = ? ", 
        objArg, null);
      finance_xianjin(list, map, "EG06AR01", "EG06AD02", "EG06AD03");

      list = hqldao.queryBySQL2List(   //排序1
        "select ED01.*,ED01BH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and (ED01AD05 = '41' or ED01AD05 = '51')) ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      StringBuffer sql=new StringBuffer();
      sql.append("select s.ED01AI01,s.ED01AI02,s.ED01AD05,s.ED01BR01,s.ED01BJ01,s.ED01BR02,s.ED01BD01,s.ED01BR03,s.ED01BR04,s.ED01BJ02,s.ED01BD02")
      .append(" from (select ED01.*,ED01BH.*,")
      .append(" row_number() over(partition by ED01.ED01AI01, ED01.ED01AI02 order by ED01.ED01AI01, ED01.ED01AI02, ED01BH.ED01BR01 desc) as a_index")
      .append(" from (select *from CR_COM_ED01 where batch_id = ?  and ED01AD01 = '1' and (ED01AD05 = '41' or ED01AD05 = '51')) ED01 ")
      .append(" left join CR_COM_ED01BH ED01BH  on ED01.ID = ED01BH.PARENTID) s")
      .append(" where s.a_index <= 1");              
      list1 = hqldao.queryBySQL2List(sql.toString(),objArg,null);   
      map.put("ED01_41_51", isNotEmpty(list1) ? list1 : new ArrayList());
      map.put("ED01_41_51List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and (ED01AD05 = '41' or ED01AD05 = '51')) ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_41_51", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_41_51List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.*,ED01CH.*  from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30'))  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_1_23", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_1_23List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and (ED01AD03 = '20' or ED01AD03 = '30'))  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_2_23", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_2_23List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.*,ED01CH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_1_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_1_1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and (ED01AD02 = 'D1' or ED01AD02 = 'R4')  and ED01AD03 = '10')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_2_1", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_2_1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.*,ED01CH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and ED01AD02 = 'R1')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_1_R1", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_1_R1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and ED01AD02 = 'R1')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_2_R1", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_2_R1List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(   //排序
        "select ED01.*,ED01BH.*,ED01CH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '1' and ED01AD02 = 'D2')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID  left join CR_COM_ED01CH ED01CH on ED01.ID = ED01CH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_1_D2", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_1_D2List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List(  //排序
        "select ED01.*,ED01BH.* from (select * from CR_COM_ED01  where batch_id = ?  and ED01AD01 = '2' and ED01AD02 = 'D2')  ED01  left join CR_COM_ED01BH ED01BH on ED01.ID = ED01BH.PARENTID order by ED01.ED01AI01,ED01.ED01AI02,ED01BH.ED01BR01 desc", 
        objArg, null);
      map.put("ED01_1_2_D2", isNotEmpty(list) ? list.get(0) : new HashMap());
      map.put("ED01_1_2_D2List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT a.ED04AI02,a.ED04AD03,a.ED04AI01,a.ED04AR01,a.ED04AR02,a.ED04AD04,a.ED04AJ01,a.ED04AD05,a.ED04AQ01,a.ED04AI03,b.* FROM CR_COM_ED04 a ,CR_COM_ED04B b where a.batch_id=?and (a. ED04AD03 = '51' or a.ED04AD03 = '61')    and  a.ID = b.PARENT_ID  and b.ED04BD01 = '1' order by a.ED04AI01,a.ED04AI02,b.ED04BR01 desc", 
        objArg, null);  //排序
      map.put("ED04_1_51_61List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT a.ED04AI02,a.ED04AD03,a.ED04AI01,a.ED04AR01,a.ED04AR02,a.ED04AD04,a.ED04AJ01,b.* FROM CR_COM_ED04 a ,CR_COM_ED04B b where a.batch_id=?and (a. ED04AD03 = '51' or a.ED04AD03 = '61')    and  a.ID = b.PARENT_ID  and b.ED04BD01 = '2' order by a.ED04AI01,a.ED04AI02,b.ED04BR01 desc", 
        objArg, null);  //排序
      map.put("ED04_2_51_61List", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT a.ED04AI02,a.ED04AD03,a.ED04AI01,a.ED04AR01,a.ED04AR02,a.ED04AD04,a.ED04AJ01,a.ED04AD05,a.ED04AQ01,a.ED04AI03,b.* FROM CR_COM_ED04 a ,CR_COM_ED04B b where a.batch_id=?and (a. ED04AD03 <> '51' and a.ED04AD03 <>'61')    and  a.ID = b.PARENT_ID  and b.ED04BD01 = '1' order by a.ED04AI01,a.ED04AI02,b.ED04BR01 desc", 
        objArg, null);  //排序
      map.put("ED04_1_51_61otherList", isNotEmpty(list) ? list : new ArrayList());

      list = hqldao.queryBySQL2List("SELECT a.ED04AI02,a.ED04AD03,a.ED04AI01,a.ED04AR01,a.ED04AR02,a.ED04AD04,a.ED04AJ01,b.* FROM CR_COM_ED04 a ,CR_COM_ED04B b where a.batch_id=?and (a. ED04AD03 <> '51' and a.ED04AD03 <>'61')    and  a.ID = b.PARENT_ID  and b.ED04BD01 = '2' order by a.ED04AI01,a.ED04AI02,b.ED04BR01 desc", 
        objArg, null);  //排序
      map.put("ED04_2_51_61otherList", isNotEmpty(list) ? list : new ArrayList());
    }
    catch (Exception e)
    {
      logger.error(e.getMessage(), e);
    }
    return map;
  }

  private void finance_fuzha(List list, Map<String, Object> map, String financeyear, String financetype, String financename) {
    String[] years = { "nowyear", "year1", "year2", "year3" };
    String[] types = { "10", "20", "30", "40", "50", "60", "70" };
    String[] names = { "EGA_1_0_10", "EGA_1_1_10", "EGA_1_2_10", "EGA_1_3_10", 
      "EGA_1_0_20", "EGA_1_1_20", "EGA_1_2_20", "EGA_1_3_20", 
      "EGA_1_0_30", "EGA_1_1_30", "EGA_1_2_30", "EGA_1_3_30", 
      "EGA_1_0_40", "EGA_1_1_40", "EGA_1_2_40", "EGA_1_3_40", 
      "EGA_1_0_50", "EGA_1_1_50", "EGA_1_2_50", "EGA_1_3_50", 
      "EGA_1_0_60", "EGA_1_1_60", "EGA_1_2_60", "EGA_1_3_60", 
      "EGA_1_0_70", "EGA_1_1_70", "EGA_1_2_70", "EGA_1_3_70" };

    for (int i = 0; i < list.size(); i++) {
      HashMap EGA = (HashMap)list.get(i);

      String year = (String)EGA.get(financeyear);
      String type = (String)EGA.get(financetype);
      String name = (String)EGA.get(financename);
      for (int j = 0; j < types.length; j++) {
        for (int k = 0; k < years.length; k++) {
          if ((map.get(years[k]).equals(year)) && (types[j].equals(type))) {
            int num = k + j * years.length;
            map.put(names[num], name);
            j = types.length;
            k = years.length;
          }
        }
      }
    }

    System.out.println("over");
  }

  private void finance_shouru(List list, Map<String, Object> map, String financeyear, String financetype, String financename)
  {
    String[] years = { "nowyear", "year1", "year2", "year3" };
    String[] types = { "10", "20", "30", "40", "50", "60", "70" };
    String[] names = { "EGA_2_0_10", "EGA_2_1_10", "EGA_2_2_10", "EGA_2_3_10", 
      "EGA_2_0_20", "EGA_2_1_20", "EGA_2_2_20", "EGA_2_3_20", 
      "EGA_2_0_30", "EGA_2_1_30", "EGA_2_2_30", "EGA_2_3_30", 
      "EGA_2_0_40", "EGA_2_1_40", "EGA_2_2_40", "EGA_2_3_40", 
      "EGA_2_0_50", "EGA_2_1_50", "EGA_2_2_50", "EGA_2_3_50", 
      "EGA_2_0_60", "EGA_2_1_60", "EGA_2_2_60", "EGA_2_3_60", 
      "EGA_2_0_70", "EGA_2_1_70", "EGA_2_2_70", "EGA_2_3_70" };

    for (int i = 0; i < list.size(); i++) {
      HashMap EGA = (HashMap)list.get(i);

      String year = (String)EGA.get(financeyear);
      String type = (String)EGA.get(financetype);
      String name = (String)EGA.get(financename);
      for (int j = 0; j < types.length; j++)
        for (int k = 0; k < years.length; k++)
          if ((map.get(years[k]).equals(year)) && (types[j].equals(type))) {
            int num = k + j * years.length;
            map.put(names[num], name);
          }
    }
  }

  private void finance_xianjin(List list, Map<String, Object> map, String financeyear, String financetype, String financename)
  {
    String[] years = { "nowyear", "year1", "year2", "year3" };
    String[] types = { "10", "20", "30", "40", "50", "60", "70" };
    String[] names = { "EGA_3_0_10", "EGA_3_1_10", "EGA_3_2_10", "EGA_3_3_10", 
      "EGA_3_0_20", "EGA_3_1_20", "EGA_3_2_20", "EGA_3_3_20", 
      "EGA_3_0_30", "EGA_3_1_30", "EGA_3_2_30", "EGA_3_3_30", 
      "EGA_3_0_40", "EGA_3_1_40", "EGA_3_2_40", "EGA_3_3_40", 
      "EGA_3_0_50", "EGA_3_1_50", "EGA_3_2_50", "EGA_3_3_50", 
      "EGA_3_0_60", "EGA_3_1_60", "EGA_3_2_60", "EGA_3_3_60", 
      "EGA_3_0_70", "EGA_3_1_70", "EGA_3_2_70", "EGA_3_3_70" };

    for (int i = 0; i < list.size(); i++) {
      HashMap EGA = (HashMap)list.get(i);

      String year = (String)EGA.get(financeyear);
      String type = (String)EGA.get(financetype);
      String name = (String)EGA.get(financename);
      for (int j = 0; j < types.length; j++)
        for (int k = 0; k < years.length; k++)
          if ((map.get(years[k]).equals(year)) && (types[j].equals(type))) {
            int num = k + j * years.length;
            map.put(names[num], name);
          }
    }
  }
}