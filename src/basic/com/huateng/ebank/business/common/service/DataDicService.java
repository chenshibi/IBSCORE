package com.huateng.ebank.business.common.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.report.utils.LogExceptionUtils;

import resource.bean.basic.DataDic;
import resource.dao.basic.DataDicDAO;

/**
 * @author valley
 * @date 2004-11-16
 * @desc 数据字典访问service
 */
public class DataDicService {
    private static Logger log = Logger.getLogger(DataDicService.class);
    private static DataDicService single = null;
    private static List<DataDic> dataDicList = new ArrayList<DataDic>();

    public synchronized static List<DataDic> getAllDataDic() {
        if (DataDicService.dataDicList.size() == 0) {
            try {
                DataDicService.dataDicList = DataDicService.getInstance().loadAll();
            } catch (CommonException e) {
                LogExceptionUtils.logException(log, e);
                e.printStackTrace();
            }
        }
        return DataDicService.dataDicList;
    }

    /**
     * Default constructor
     */
    protected DataDicService() {
    }

    /**
     * get instance.
     *
     * @return
     */
    public synchronized static DataDicService getInstance() {
        /*
         * if (null == single) { single = new DataDicService(); } return single;
         */
        return (DataDicService) ApplicationContextUtils.getBean(DataDicService.class.getName());
    }

    /**
     * 根据数据编号取得对应的值
     *
     * @param type
     * @param dataNo
     * @return value
     * @throws CommonException
     */
    public String getValueByDataNo(int type, String dataNo) throws CommonException {
        StringBuffer whereStr = new StringBuffer(64);
        whereStr.append("po.dataTypeNo = ").append(type).append(" and po.dataNo = '").append(dataNo)
                .append("' order by po.dataNo");
        DataDic dd = new DataDic();
        dd.setDataTypeNo(type);
        dd.setDataNo(dataNo);
        List list = BaseDAOUtils.getDataDicDAO().findByExample(dd);
        if (list.size() > 0) {
            DataDic po = (DataDic) list.get(0);
            return po.getHighLimit();
        } else {
            return null;
        }
    }

    /**
     * 根据数据范围值取得对应的数据编号
     *
     * @param type
     * @param value
     * @return dataNo
     * @throws CommonException
     */
    public String getDataNoByRange(int type, double value) throws CommonException {
        StringBuffer whereStr = new StringBuffer(64);
        whereStr.append("po.dataTypeNo = ").append(type).append(" and cast(po.highLimit as long) >= ").append(value)
                .append(" and cast(po.lowLimit as long) < ").append(value)
                .append(" and po.limitFlag = '1' order by po.dataNo");
        String str = "select po from DataDic po where " + whereStr.toString();
        List list = BaseDAOUtils.getHQLDAO().queryByQL2List(str);
        if (list.size() > 0) {
            DataDic po = (DataDic) list.get(0);
            return po.getDataNo().trim();
        } else {
            return null;
        }
    }

    /**
     * 根据数据编号取得对应的显示名称，如果没有找到，返回""。
     *
     * @param type
     *            类型
     * @param no
     *            编号
     * @return 显示名称
     * @throws CommonException
     */
    public String getNameByTypeNo(int type, String no) throws CommonException {
        if (DataFormat.isEmpty(no)) {
            return "";
        }

        DataDicDAO datadicDao = BaseDAOUtils.getDataDicDAO();
        DataDic dd = new DataDic();
        dd.setDataTypeNo(type);
        dd.setDataNo(no);
        List l = BaseDAOUtils.getDataDicDAO().findByExample(dd);
        if (l == null || l.size() == 0)
            return "";
        DataDic dataDic = (DataDic) l.get(0);
        return dataDic.getDataName().trim();
    }

    /**
     * 根据数据编号取得对应的显示名称，如果没有找到，返回""。
     *
     * @param type
     *            类型
     * @param no
     *            编号
     * @return 显示名称(截去开头的datano和符号-)
     * @throws CommonException
     */
    public String getChnNameByTypeNo(int type, String no) throws CommonException {
        if (DataFormat.isEmpty(no)) {
            return "";
        }
        DataDicDAO datadicDao = BaseDAOUtils.getDataDicDAO();
        DataDic datadic = new DataDic();
        datadic.setDataTypeNo(type);
        datadic.setDataNo(no);
        List l = datadicDao.findByExample(datadic);
        if (l == null || l.size() == 0)
            return "";
        DataDic dataDic = (DataDic) l.get(0);
        return dataDic.getDataName().substring(dataDic.getDataNoLen().intValue() + 1).trim();
    }

    /**
     * 导出DataDic数据表记录
     *
     * @return List<DataDic>
     * @throws CommonException
     * @author shen_antonio
     */
    public List loadAll() throws CommonException {
        DataDicDAO datadicDao = BaseDAOUtils.getDataDicDAO();
        return datadicDao.findAll();
    }

    public List loadAllSort() throws CommonException {
        String str = "select dd from DataDic dd order by dd.dataTypeNo,dd.id";
        return BaseDAOUtils.getHQLDAO().queryByQL2List(str);
    }

    // del by zhaozhiguo
    // /**
    // * 将系统内数据字典编码转换为外部系统使用的编码
    // *
    // * @param mapType
    // * @param inDataNo
    // * @return
    // * @throws CommonException
    // */
    // public String mapInToOut(int mapType, String inDataNo)
    // throws CommonException {
    // List list = null; // 结果列表
    // DataDicMap po = new DataDicMap();
    // StringBuffer whereStr = new StringBuffer(64); // 查询语句where子句
    //
    // // 拼装where子句
    // whereStr.append("po.mapType = ").append(mapType).append(
    // " and po.incode = '").append(inDataNo).append(
    // "' order by po.outcode");
    //
    // DataDicMapDAO dao = BaseDAOUtils.getDataDicMapDAO(); // dao 对象
    // list = dao.queryByCondition(whereStr.toString());
    //
    // if (list.size() > 0) {
    // po = (DataDicMap) list.get(0);
    // return po.getOutcode().substring(0, po.getOutcodeLen());
    // } else
    // return "";
    // }

    public void getDataTreeNoName(String headNodeNo, String dataNo, Map<String, String> map) {
        DataDicDAO dao = BaseDAOUtils.getDataDicDAO();
        List<DataDic> dataDics = dao.findByDataTypeNo(Integer.parseInt(headNodeNo));
        for (DataDic dd : dataDics) {
            map.put(dd.getDataNo(), dd.getDataName());
            if (!DataFormat.isEmpty(dd.getMiscflgs())) {
                getDataTreeNoName(dd.getMiscflgs(), dataNo, map);
            }
        }
    }

}