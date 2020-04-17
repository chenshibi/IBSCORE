package com.huateng.excel.imp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.dao.CrPbocD503DAO;
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;
import com.huateng.report.utils.Base64Util;
import com.huateng.report.utils.FilePermissonUtils;

import resource.bean.basic.IndPermit;
import resource.bean.basic.TCorpPermit;
import resource.bean.basic.TlrInfo;
import resource.bean.crms.CrPbocD501;
import resource.bean.crms.CrPbocD503;

/**
 * @ClassName: QueryUntils
 * @Description: TODO(征信查询工具类)
 * @author
 * @date 2019年5月28日hy
 *
 */
public class QueryUntils {

	public static final String FILE_START_FLAG = "A";
	public static final String FILE_VERSION = "2.0.0";
	public static final String FILE_TYPE = "enc";
	public static final String Successful = "01";
	public static final String Default = "02";
	public static final String bitchNoStart = "001";
	//

	// Batch Information
	public static String getBatchInformation(String flag) {
	//	List list = null;
		String batchNo = bitchNoStart;
		CrPbocD503DAO dao = ROOTDAOUtils.getCrPbocD503DAO();
		return dao.getMaxId(batchNo,flag);
	}
	
	public static String getInformation(String flag) {
		//	List list = null;
			String batchNo = bitchNoStart;
		    CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
			return dao.getPbocMaxId(batchNo,flag);
		}
	// 根据文件名字获取批次信息
	public static Integer getMatchMessage(String fileName,String dp) {
		List list = null;
		int result = 0;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		// 根据对应的信息获得对应消息
        String   hql = "from FileSubmit  where fileName='"+fileName+"' and department='"+dp+"' and status='1' ";
		try {
			list = rootdao.queryByQL2List(hql);
		} catch (CommonException e) {
			e.printStackTrace();
		}

		if (list != null && list.size()>0) {
				result = 1;
		}
		return result;

	}

	// 根据文件名字获取批次信息
	public static Integer getBatchMessage(String fileflag,String fileName) {
		List list = null;
		int result = 0;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		// 批次号
		String batchNo = fileName.trim().toUpperCase().substring(fileName.lastIndexOf(".") - 3,
				fileName.lastIndexOf("."));
		// 时间
		String time8 = fileName.trim().toUpperCase().substring(fileName.lastIndexOf("_") - 8,
				fileName.lastIndexOf("_"));
		// 获取 部门号
		String regionNo = "-1";
		try {
			GlobalInfo info = GlobalInfo.getCurrentInstance();
			regionNo = getRegionNo(info.getTlrno());
		} catch (CommonException e) {
			e.printStackTrace();
		}
		// 根据对应的信息获得对应消息
		String hql="";
		if("CustPbocEntQuery".equals(fileflag)) {
			 hql = "from "+fileflag+" where  rsv2='" + batchNo + "' and queryDate='" + time8 + "' and  rsv4='" + regionNo
						+ "'";
		}else if("CustPbocPerQuery".equals(fileflag)){
			 hql = "from "+fileflag+" where rsv5='" + batchNo + "' and queryDate='" + time8 + "' and  rsv4='" + regionNo
						+ "'";
		}else if("FileSubmit".equals(fileflag)) {
             hql = "from "+fileflag+ "  where file_name='"+fileName+"' and status='1' ";
		}
		else {
		     hql = "from "+fileflag+" where  rsv1='" + batchNo + "' and rsv2='" + time8 + "' and  rsv3='" + regionNo
					+ "'";	
		}
		
		try {
			list = rootdao.queryByQL2List(hql);
		} catch (CommonException e) {
			e.printStackTrace();
		}

		if (list != null) {
			if (list.size() != 0) {
				// 匹配上表明已经上传过，否则表示没有上传过
				result = 1;
			}
		}
		return result;

	}

	public static String getRegionNo(String tlrno) {
		List list = null;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		String hql = " from TlrInfo where tlrno='" + tlrno + "'";
		String regionNo = "-1";
		try {
			list = rootdao.queryByQL2List(hql);
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null) {
			if (list.size() != 0) {
				TlrInfo TlrInfo = (TlrInfo) list.get(0);
				regionNo = TlrInfo.getDepartment();
			}
		}
		return regionNo;
	}

	/**
	 * 删除文件或者文件夹
	 * 
	 * @param path
	 */

	public static String getCellStringValue(Cell cell) {
		String cellValue = "";

		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:// 字符串类型
				cellValue = cell.getStringCellValue();
				if (cellValue.trim().equals("") || cellValue.trim().length() <= 0)
					cellValue = "";
				break;
			case HSSFCell.CELL_TYPE_NUMERIC: // 数值类型
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
				} else {
					// 这里将无论何种数字格式都识别为String
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					// cellValue = String.valueOf(cell.getNumericCellValue());
					cellValue = cell.getStringCellValue().trim();// 得到值
				}
				break;
			case HSSFCell.CELL_TYPE_FORMULA: // 公式
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				break;
			default:
				break;
			}
			return cellValue.replaceAll(String.valueOf((char) 160), "");
		} else {
			return cellValue;
		}
	}

	// 判断整行是否为空
	public static boolean isBlankRow(Row row) {
		if (row == null)
			return true;
		boolean result = true;
		for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
			Cell cell = row.getCell(i, Row.RETURN_BLANK_AS_NULL);
			String value = "";
			if (cell != null) {
				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					value = String.valueOf((int) cell.getNumericCellValue());
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					value = String.valueOf(cell.getBooleanCellValue());
					break;
				case HSSFCell.CELL_TYPE_FORMULA:
					value = String.valueOf(cell.getCellFormula());
					break;
				// case Cell.CELL_TYPE_BLANK:
				// break;
				default:
					break;
				}

				if (!value.trim().equals("")) {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	// 根据标识号匹配返回匹配的数量(企业)
	public static int QueryMatching(String ENT_CERT_NUM, String time) {
		List list = null;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int size = 0;
		String sql = " from TCorpPermit where loanCardNo='" + ENT_CERT_NUM + "' and expireDate>= '" + time
				+ "' and status='1'";
		try {
			list = rootdao.queryByQL2List(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (list != null) {
			size = list.size();
		}
		return size;

	}
	

	// 根据标识号匹配返回匹配的数量(企业)
	public static List<TCorpPermit> QueryMatching2(String ENT_CERT_NUM) {
		List list = null;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int size = 0;
		String sql = " from TCorpPermit where loanCardNo='" + ENT_CERT_NUM + "' and status='1'";
		try {
			list = rootdao.queryByQL2List(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

        return list;
	}
	
	
	// 根据标识号匹配返回匹配的数量(个人)
	public static int QueryMatchingPersoanl(String idNum, String time) {
		List list = null;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int size = 0;
		String sql = " from IndPermit where Individual_id='" + idNum + "' and expireDate>= '" + time
				+ "' and status='1'";
		try {
			list = rootdao.queryByQL2List(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (list != null) {
			size = list.size();
		}
		return size;

	}
	
	
	
	// 根据标识号匹配返回匹配的数量(个人)
	public static List<IndPermit> QueryMatchingPersoanl2(String idNum) {
		List list = null;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int size = 0;
		String sql = " from IndPermit where Individual_id='" + idNum + "' and status='1' ";
		try {
			list = rootdao.queryByQL2List(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public  static List<IndPermit> updateIndPermit(String idNum,String time,IndPermit indPermit){
		List list = null;
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		int size = 0;
		String sql = " update IndPermit set expire_date='" + time + "' where Individual_id='" + idNum + "' and status='1' ";
		try {
			list = rootdao.queryByQL2List(sql);
			rootdao.update(indPermit);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	

	private static void mkdirIfNotExists(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
			FilePermissonUtils.setPermission755(path);
		}
	}

	/**
	 * 
	 * @Title: getAllContent @Description: TODO(批量企业/个人征信查询文件体) @param @param
	 *         list @param @return 参数 @return String 返回类型 @throws
	 */
	@SuppressWarnings("unchecked")
	public static String getAllContent(List<?> list1) {
		String txtName = "";
		String txtfile = "";
		Object obj = (Object) list1.get(0);
		if (obj instanceof CrPbocD503) {
			List<CrPbocD503> list = (List<CrPbocD503>) list1;
			String filestart = list.get(0).getFileStartFlag();
			String FILE_VERSION = list.get(0).getFileVersion();
			String FILE_QRY_CODE = list.get(0).getFileQryCode();
			String FILE_GEN_TIME = list.get(0).getFileGenTime();
			String FILE_TYPE = list.get(0).getFileType();
			String RECORD_QRY_NUM = list.get(0).getRecordQryNum();
			String FILE_RSV = list.get(0).getFileRsv();
			txtName = filestart + FILE_VERSION + FILE_QRY_CODE + FILE_GEN_TIME + FILE_TYPE + RECORD_QRY_NUM + FILE_RSV
					+ "\r\n";
			for (int i = 0; i < list.size(); i++) {
				txtfile += "<?xml version='1.0' encoding='UTF-8'?>";
				txtfile += "<Msg>";
				txtfile += "< RequestId>" + list.get(i).getRequestid() + "</ RequestId>";
				txtfile += "< OriginateOrgCode >" + list.get(i).getOriginateOrgCode() + "</ OriginateOrgCode >";
				txtfile += "< OriginateUserCode>" + list.get(i).getOriginateUserCode() + "</ OriginateUserCode>";
				txtfile += "< EntName >" + list.get(i).getEntName() + "</ EntName >";
				txtfile += "< EntCertType >" + list.get(i).getEntCertType() + "</ EntCertType >";
				txtfile += "< EntCertNum >" + list.get(i).getEntCertNum() + "</ EntCertNum >";
				txtfile += "< QueryReason>" + list.get(i).getQueryReason() + "</ QueryReason>";
				txtfile += "< ServiceCode >" + list.get(i).getServiceCode() + "</ ServiceCode >";
				txtfile += "</ Msg>";
				txtfile += "</ Document>\r\n";
			}
		} else if (obj instanceof CrPbocD501) {
			List<CrPbocD501> list = (List<CrPbocD501>) list1;
			String filestart = list.get(0).getFileStartFlag();
			String FILE_VERSION = list.get(0).getFileVersion();
			String FILE_QRY_CODE = list.get(0).getFileQryCode();
			String FILE_GEN_TIME = list.get(0).getFileGenTime();
			String FILE_TYPE = list.get(0).getFileType();
			String RECORD_QRY_NUM = list.get(0).getRecordQryNum();
			String FILE_RSV = list.get(0).getFileRsv();
			txtName = filestart + FILE_VERSION + FILE_QRY_CODE + FILE_GEN_TIME + FILE_TYPE + RECORD_QRY_NUM + FILE_RSV
					+ "\r\n";
			for (int i = 0; i < list.size(); i++) {
				txtfile += "<?xml version='1.0' encoding='UTF-8'?>";
				txtfile += "<Msg>";
				txtfile += "< RequestId>" + list.get(i).getRequestid() + "</ RequestId>";
				txtfile += "< OriginateOrgCode >" + list.get(i).getOriginateOrgCode() + "</ OriginateOrgCode >";
				txtfile += "< OriginateUserCode>" + list.get(i).getOriginateUserCode() + "</ OriginateUserCode>";
				txtfile += "< Name >" + list.get(i).getName() + "</ Name >";
				txtfile += "< IDType>" + list.get(i).getIdType() + "</ IDType >";
				txtfile += "< IDNum>" + list.get(i).getIdNum() + "</ IDNum >";
				txtfile += "< QueryReason>" + list.get(i).getQueryReason() + "</ QueryReason>";
				txtfile += "< ServiceCode >" + list.get(i).getServiceCode() + "</ ServiceCode >";
				txtfile += "</ Msg>";
				txtfile += "</ Document>\r\n";
			}

		}

		return txtName + txtfile;
	}

	/**
	 * @Title: getFileName @Description: TODO(批量企业/个人征信查询文件名) @param @param
	 *         list @param @return 参数 @return String 返回类型 @throws
	 */
	@SuppressWarnings("unchecked")
	public static String getFileName(List<?> list1) {
		String FILE_QRY_CODE = "";
		String FILE_GEN_TIME = "";
		String Lsid = "";
		String fileName = "";
		Object obj = (Object) list1.get(0);
		if (obj instanceof CrPbocD503) {
			List<CrPbocD503> list = (List<CrPbocD503>) list1;
			FILE_QRY_CODE = list.get(0).getFileQryCode();
			FILE_GEN_TIME = list.get(0).getFileGenTime().substring(0, 8);// 日期
			Lsid = list.get(0).getId().substring(list.get(0).getId().length() - 9, list.get(0).getId().length() - 1);
			fileName = FILE_QRY_CODE + FILE_GEN_TIME + Lsid + "0.txt";
		} else if (obj instanceof CrPbocD501) {
			List<CrPbocD501> list = (List<CrPbocD501>) list1;
			FILE_QRY_CODE = list.get(0).getFileQryCode();
			FILE_GEN_TIME = list.get(0).getFileGenTime().substring(0, 8);// 日期
			Lsid = list.get(0).getId().substring(list.get(0).getId().length() - 9, list.get(0).getId().length() - 1);
			fileName = FILE_QRY_CODE + FILE_GEN_TIME + Lsid + "0.txt";
		}

		return fileName;
	}


	/**
	 * 
	 * @Title: writeFileToEnc @Description: TODO(创建enc文件并写入加密后的内容) @param @param
	 *         fileName @param @param list @param @return 参数 @return File
	 *         返回类型 @throws
	 */
	public static String writeFileToEnc(String fileName, List<?> list) {
		// 修改后缀名
		String newName = fileName.replace(".txt", ".enc");
		mkdirIfNotExists(newName);
		File file = new File(newName);
		OutputStream out = null;
		String content = null;
		String ncontent = null;
		try {
			out = new FileOutputStream(file);
			if (list.size() != 0) {
				content = getAllContent(list);
				// 加密后的文件内容。
				ncontent = Base64Util.encodeData(content);
			}
			byte[] bytes = ncontent.getBytes();
			out.write(bytes);
			System.out.println("success");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("default");
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException el) {
				}
			}
		}
		return ncontent;
	}
	
	public static void  getSequnce() {
		for(int i=1; i<=999;i++){
			String sequnce = String.format("%03d", i);
			 System.out.println(String.format("%03d", i));
        }
	}
	
	public static void main(String grgs[]) {
		QueryUntils.getSequnce();
	}

}
