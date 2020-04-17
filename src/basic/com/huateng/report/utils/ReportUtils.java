package com.huateng.report.utils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hwpf.HWPFDocumentCore;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.converter.WordToHtmlUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.w3c.dom.Document;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.report.common.service.ReportCommonService;

import resource.bean.basic.DataDic;
import resource.bean.basic.FunctionInfo;
import resource.bean.basic.SysParams;
/**
 * 
 * @author Grassy
 *
 */
public class ReportUtils {
    private static Logger log = Logger.getLogger(ReportUtils.class);

    public static String getSystemLine() {
        return System.getProperty("line.separator");// 文本文件换行符号
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
    }

    public static String getSysTempPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static String getConfrimCodes(List codeslist) {
        StringBuffer result = new StringBuffer();
        result.append("(");
        for (int i = 0; i < codeslist.size(); i++) {
            FunctionInfo info = (FunctionInfo) codeslist.get(i);
            result.append("'").append(info.getId().trim()).append("'");
            if (i < codeslist.size() - 1) {
                result.append(",");
            }
        }
        result.append(")");
        return result.toString();
    }

    /**
     * 获取当前页面上所选的查询条件所要查询的表名
     * 
     * @param map
     * @return
     */
    public static Set<String> getTableName(Map<String, List<DataDic>> map) {
        Set<String> tablenameSet = new HashSet<String>();
        for (Iterator<Entry<String, List<DataDic>>> iter = map.entrySet().iterator(); iter.hasNext();) {
            Entry<String, List<DataDic>> entry = iter.next();
            List<DataDic> ddList = entry.getValue();
            for (DataDic dd : ddList) {
                if (dd.getHighLimit() != null && dd.getHighLimit().trim().length() > 0) {
                    tablenameSet.add(dd.getHighLimit().trim());
                }
            }
        }
        return tablenameSet;
    }

    public static List<DataDic> getBusinessList() throws CommonException {
        return ReportCommonService.getInstance().getBusinessByTypeNo();
    }

    /**
     * 生成in语句
     *
     * @param coll
     *            值列表
     * @return 形如('a','b')或(1,2,3)的语句
     */
    public static String toInString(Collection<?> coll) {
        if (null == coll || coll.size() == 0) {
            return "('')"; // 避免语法错误
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Object obj : coll) {
            if (obj == null)
                continue;

            if (obj instanceof Date) {
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                sb.append("'").append(df.format((Date) obj)).append("'");
            } else if (obj instanceof String) {
                sb.append("'" + obj + "'");
            } else {
                sb.append(obj);
            }

            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1); // 删除多加的","
        sb.append(")");
        String s = sb.toString();
        if ("()".equals(s)) { // 避免语法错误
            s = "('')";
        }
        return s;
    }

    public static String getTempStr(String str, int len) {
        return StringUtils.rightPad(str == null ? "" : str.trim(), len, ReportConstant.BUSI_NO_CODE);
    }

    /**
     * 根据编码加载左侧导航
     *
     * @param code
     * @return
     */
    public static List getLeftNavgList(String code) {
        if (code == null || code.trim().length() == 0) {
            return null;
        }
        ReportCommonService commonService = ReportCommonService.getInstance();
        List list = null;
        try {
            list = commonService.getConfList(code);
        } catch (CommonException e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
        return list;
    }

    public static String getSysParamsValue(String groupId, String paramId) {
        String value = null;
        try {
            SysParams param = ReportCommonService.getInstance().getSysparamsByPk(groupId, paramId);
            value = param.getParamVal().trim();
        } catch (CommonException e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }

        return value;
    }
    
    
    public static String[] transferArrayParam(String groupId, String paramId) {
        JSONArray value;
        String[] strValue = null;
        try {
            SysParams param = ReportCommonService.getInstance().getSysparamsByPk(groupId, paramId);
            try {
				value=new JSONArray(param.getParamVal().trim());
				strValue=new String[value.length()];
				for (int i = 0; i < value.length(); i++) {
					  strValue[i] = value.get(i).toString();
					} 
			} catch (JSONException e) {
				e.printStackTrace();
			}
        } catch (CommonException e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }

        return strValue;
    }

    public static String getSysParamsValue(String groupId, String paramId, String defaultValue) {
        String value = null;
        try {
            SysParams param = ReportCommonService.getInstance().getSysparamsByPk(groupId, paramId);
            value = param.getParamVal().trim();
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }
    // filePath加文件名，文件名为String类型
    public static boolean isFileExist(String filePath) {
    	filePath=HuaTengUtils.toStringAndTrim(filePath);
        File file = new File(filePath);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * 数字转成指定格式
     * 
     * @author zengqinag.yang 2013-1-21-下午2:01:25
     * @param num
     *            数值
     * @param formatAs
     *            格式
     * @return
     */
    public static String formatNumber(int num, String formatAs) {
        DecimalFormat dr = new DecimalFormat(formatAs);
        String str = dr.format(num);
        return str;
    }

    /**
     * 获得两个时间之间相隔的秒: 不能传null
     * 
     * @param startTm
     * @param endTm
     * @param scale保留几位小数
     * @return
     */
    public static String getDuringMinutesReturnString(Date startTm, Date endTm, int scale) {
        long costTm = endTm.getTime() - startTm.getTime();
        long dCostTm = costTm / 1000;
        return String.valueOf(dCostTm);
    }

    private static Document process(File file) throws IOException, ParserConfigurationException {
        HWPFDocumentCore wordDocument = WordToHtmlUtils.loadDoc(file);
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
        wordToHtmlConverter.processDocument(wordDocument);
        return wordToHtmlConverter.getDocument();
    }
    /**
     * 获取数据库连接
     * @param user
     * @param password
     * @return
     */
    public static Connection getOracleConnection(String user,String password){
        Connection conn = null;
        try {
        	
            Class.forName(getSysParamsValue("ORACLE","DRIVER"));
            String url = getSysParamsValue("ORACLE","JDBCURL");
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭数据库连接
     * @param conn Connection 对象
     */
    public static void closeConnection(Connection conn){
        //判断 conn 是否为空
        if(conn != null){
            try {
                conn.close();            //关闭数据库连接
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static int  queryCount(Connection conn,String sql) {
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	int countNum=0;
    	try {
    	//	conn=getOracleConnection(getSysParamsValue("ORACLE","USER"),getSysParamsValue("ORACLE","PWD"));
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			countNum=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		//	closeConnection(conn);
			if(null!=ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if(null !=rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return countNum;
    }
    
    public  static void batchInsert(Connection conn,Map<String,String> paramMap,ArrayList<String> rpdIdsList,String tableName) {
    	long start = System.currentTimeMillis();
    	PreparedStatement ps=null;
    	String month=paramMap.get("queryDate");
    	StringBuffer sb=new StringBuffer();
    	sb.append("insert into ").append(tableName).append(" values").append("(?,?").append(")");
    	String sql=sb.toString();
    	try {
    	//	conn=getOracleConnection(user,pwd);
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < rpdIdsList.size(); i++) {
				String reportId=rpdIdsList.get(i);
				ps.setString(1,reportId);
				ps.setString(2,month);
				ps.addBatch();
				if(i%1000==0){
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
		//	closeConnection(conn);
			if(null!=ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    	
    	 long end = System.currentTimeMillis();
    	 log.info("批量插入"+tableName+"需要时间:"+(end - start)+"ms"); 
    	
    }
    
    public static void delete(Connection conn,Map<String,String> paramMap ,String tableName) {
    	long start = System.currentTimeMillis();
    	String month=paramMap.get("queryDate");
    	StringBuffer sb=new StringBuffer();
    	sb.append("delete from ").append(tableName).append(" where QUERY_MONTH=").append("'").append(month).append("'");
    	String sql=sb.toString();
    	PreparedStatement ps =null;			
    	try {	
    		ps = conn.prepareStatement(sql);
    		ps.executeQuery();		 
    		log.info("删除成功");	
    		 long end = System.currentTimeMillis();
        	 log.info("批量删除需要时间:"+(end - start)+"ms"); 
    		} catch (SQLException e) {	
    			}
    	   finally {
		// 	closeConnection(conn);
			if(null!=ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    	}

    }
