package com.huateng.report.utils;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.report.dao.CrComEa01chDAO;

import resource.bean.crms.*;

public class XmlUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(XmlUtils.class);

    public static String getValue(Document document, String xpath) {
        String value = "";
        try {
            Node node = document.selectSingleNode(xpath);
            if(node!=null){
                value = node.getText();
            }

        } catch (Exception e) {
            LOGGER.error("read {} from document failed. {}", xpath, e.getMessage());
        }
        return value;
    }

    public static String getValue(Node parent, String xpath) {
        String value = "";
        try {
            Node node = parent.selectSingleNode(xpath);
            if(node!=null){
                value = node.getText();
            }
        } catch (Exception e) {
            LOGGER.error("read {} from document failed. {}", xpath, e.getMessage());
        }
        return value;
    }
    
    /**
     * 解析企业相关还款责任人及抵押物返回报文
     * @param msg
     * @param uuid
     * @throws Exception
     */
    public static void parseCollateral(String msg,String uuid)throws Exception {
    	 Document document = DocumentHelper.parseText(msg);
    	 parseCollateralEaa(document,uuid);
    	 parseCollateralEa01ah(document,uuid);
    	 parseCollateralEba(document,uuid);
    	 parseCollateralEca(document,uuid);
    	 parseCollateralEda(document,uuid);
    	 parseCollateralEd01bh(document,uuid);
    	 parseCollateralEd01ch(document,uuid);
    }

    /**
     * 解析企业报文
     *
     * @param msg
     * @param uuid
     * @throws Exception
     */
    public static void parseCorpReport(String msg, String uuid) throws Exception {
        Document document = DocumentHelper.parseText(msg);
        parseCrComEa01Ch(document, uuid);
        parseCrComEaa(document, uuid);
        parseCrComEb02Ah(document, uuid);
        parseCrComEb02Bh(document, uuid);
        parseCrComEb02Ch(document, uuid);
        parseCrComEb03Ah(document, uuid);
        parseCrComEb03Bh(document, uuid);
        parseCrComEb05Ah(document, uuid);
        parseCrComEb05Bh(document, uuid);
        parseCrComEba(document, uuid);
        parseCrComEbb(document, uuid);
        parseCrComEbc(document, uuid);
        parseCrComEbd(document, uuid);
        parseCrComEbe(document, uuid);
        parseCrComEc020H(document, uuid);
        parseCrComEc030H(document, uuid);
        parseCrComEc050H(document, uuid);
        parseCrComEca(document, uuid);

        parseCrComEd01(document, uuid);
        parseCrComEd02(document, uuid);
        parseCrComEd03(document,uuid);
        parseCrComEd04(document,uuid);
    //    parseCrComEdc(document, uuid);
        parseCrComEd05(document, uuid);
        parseCrComEd06(document, uuid);
        parseCrComEd07(document, uuid);
        parseCrComEd08(document, uuid);
        parseCrComEd09(document, uuid);
 
        parseCrComEe01Bh(document, uuid);
        parseCrComEea(document, uuid);
        parseCrComEf05Bh(document, uuid);
        parseCrComEfa(document, uuid);
        parseCrComEfb(document, uuid);
        parseCrComEfc(document, uuid);
        parseCrComEfd(document, uuid);
        parseCrComEfe(document, uuid);
        parseCrComEff(document, uuid);
        parseCrComEfg(document, uuid);
        parseCrComEga(document, uuid);
        parseCrComEha(document, uuid);
        parseCrComEia(document, uuid);
    }

    public static void parseCrComEaa(Document document, String batchId) throws Exception {
        CrComEaa entity = new CrComEaa();
        entity.setId(batchId);

        entity.setEa01ai01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01A/EA01AI01"));
        entity.setEa01ar01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01A/EA01AR01"));
        entity.setEa01bi01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01B/EA01BI01"));
        entity.setEa01bd02(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01B/EA01BD02"));
        entity.setEa01cq01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01C/EA01CQ01"));
        entity.setEa01cs01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01C/EA01CS01"));
        entity.setEa01ds01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01D/EA01DS01"));
        entity.setEa01eq01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01E/EA01EQ01"));
        entity.setEa01er01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01E/EA01ER01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEaaDAO().save(entity);
       // ApplicationContextUtil.getBean(CrComEaaDao.class).save(entity);
    }
    
    
    public static void parseCollateralEaa(Document document, String batchId) throws Exception {
    	CollateralEaa entity = new CollateralEaa();
        entity.setId(batchId);
        entity.setEa01Aq01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01A/EA01AQ01"));
        entity.setEa01As01(XmlUtils.getValue(document, "/Document/EAA/EA01/EA01A/EA01AS01"));
        LOGGER.info("entity = {}", JsonUtils.toJson(entity));    
        BaseDAOUtils.getCollateralEaaDao().save(entity);
    }

    public static void parseCrComEba(Document document, String batchId) throws Exception {
        CrComEba entity = new CrComEba();
        entity.setId(batchId);

        entity.setEb01ar01(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AR01"));
        entity.setEb01ar02(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AR02"));
        entity.setEb01as01(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AS01"));
        entity.setEb01as02(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AS02"));
        entity.setEb01aj01(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AJ01"));
        entity.setEb01aj02(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AJ02"));
        entity.setEb01aj03(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AJ03"));
        entity.setEb01aj04(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AJ04"));
        entity.setEb01aj05(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AJ05"));
        entity.setEb01aj06(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AJ06"));
        entity.setEb01aj07(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01A/EB01AJ07"));
        entity.setEb01bs01(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01B/EB01BS01"));
        entity.setEb01bs02(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01B/EB01BS02"));
        entity.setEb01bs03(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01B/EB01BS03"));
        entity.setEb01bs04(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01B/EB01BS04"));
        entity.setEb01bs05(XmlUtils.getValue(document, "/Document/EBA/EB01/EB01B/EB01BS05"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEbaDAO().save(entity);
      //  ApplicationContextUtil.getBean(CrComEbaDao.class).save(entity);
    }

    public static void parseCrComEbb(Document document, String batchId) throws Exception {
        CrComEbb entity = new CrComEbb();
        entity.setId(batchId);

        entity.setEb02as01(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AS01"));
        entity.setEb02aj01(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AJ01"));
        entity.setEb02ar01(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AR01"));
        entity.setEb02as02(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AS02"));
        entity.setEb02aj02(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AJ02"));
        entity.setEb02ar02(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AR02"));
        entity.setEb02aj03(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AJ03"));
        entity.setEb02aj04(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AJ04"));
        entity.setEb02aj05(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AJ05"));
        entity.setEb02as03(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02A/EB02AS03"));
        entity.setEb02bs01(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02B/EB02BS01"));
        entity.setEb02bj01(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02B/EB02BJ01"));
        entity.setEb02br01(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02B/EB02BR01"));
        entity.setEb02br02(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02B/EB02BR02"));
        entity.setEb02bs02(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02B/EB02BS02"));
        entity.setEb02bj02(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02B/EB02BJ02"));
        entity.setEb02bs03(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02B/EB02BS03"));
        entity.setEb02cs01(XmlUtils.getValue(document, "/Document/EBB/EB02/EB02C/EB02CS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEbbDAO().save(entity);
     //   ApplicationContextUtil.getBean(CrComEbbDao.class).save(entity);
    }

    public static void parseCrComEbc(Document document, String batchId) throws Exception {
        CrComEbc entity = new CrComEbc();
        entity.setId(batchId);

        entity.setEb03as01(XmlUtils.getValue(document, "/Document/EBC/EB03/EB03A/EB03AS01"));
        entity.setEb03bs01(XmlUtils.getValue(document, "/Document/EBC/EB03/EB03B/EB03BS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEbcDAO().save(entity);
    }

    public static void parseCrComEbd(Document document, String batchId) throws Exception {
        CrComEbd entity = new CrComEbd();
        entity.setId(batchId);

        entity.setEb040j01(XmlUtils.getValue(document, "/Document/EBD/EB04/EB040J01"));
        entity.setEb040j02(XmlUtils.getValue(document, "/Document/EBD/EB04/EB040J02"));
        entity.setEb040j03(XmlUtils.getValue(document, "/Document/EBD/EB04/EB040J03"));
        entity.setEb040j04(XmlUtils.getValue(document, "/Document/EBD/EB04/EB040J04"));
        entity.setEb040j05(XmlUtils.getValue(document, "/Document/EBD/EB04/EB040J05"));
        entity.setEb040j06(XmlUtils.getValue(document, "/Document/EBD/EB04/EB040J06"));
        entity.setEb040d01(XmlUtils.getValue(document, "/Document/EBD/EB04/EB040D01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEbdDAO().save(entity);
    }

    public static void parseCrComEbe(Document document, String batchId) throws Exception {
        CrComEbe entity = new CrComEbe();
        entity.setId(batchId);

        entity.setEb05as01(XmlUtils.getValue(document, "/Document/EBE/EB05/EB05A/EB05AS01"));
        entity.setEb05bs01(XmlUtils.getValue(document, "/Document/EBE/EB05/EB05B/EB05BS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEbeDAO().save(entity);
    }

   public static void parseCrComEca(Document document, String batchId) throws Exception {
        CrComEca entity = new CrComEca();
        entity.setId(batchId);

        entity.setEc010d01(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010D01"));
        entity.setEc010d02(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010D02"));
        entity.setEc010d03(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010D03"));
        entity.setEc010d04(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010D04"));
        entity.setEc010q01(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010Q01"));
        entity.setEc010r01(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010R01"));
        entity.setEc010r02(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010R02"));
        entity.setEc010q02(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010Q02"));
        entity.setEc010d05(XmlUtils.getValue(document, "/Document/ECA/EC01/EC010D05"));
        entity.setEc020j01(XmlUtils.getValue(document, "/Document/ECA/EC02/EC020J01"));
        entity.setEc020s01(XmlUtils.getValue(document, "/Document/ECA/EC02/EC020S01"));
        entity.setEc030r01(XmlUtils.getValue(document, "/Document/ECA/EC02/EC020R01"));
        entity.setEc030s01(XmlUtils.getValue(document, "/Document/ECA/EC03/EC030S01"));
        entity.setEc030r01(XmlUtils.getValue(document, "/Document/ECA/EC03/EC030R01"));
        entity.setEc040d01(XmlUtils.getValue(document, "/Document/ECA/EC04/EC040D01"));
        entity.setEc040q01(XmlUtils.getValue(document, "/Document/ECA/EC04/EC040Q01"));
        entity.setEc040d02(XmlUtils.getValue(document, "/Document/ECA/EC04/EC040D02"));
        entity.setEc040i01(XmlUtils.getValue(document, "/Document/ECA/EC04/EC040I01"));
        entity.setEc040r01(XmlUtils.getValue(document, "/Document/ECA/EC04/EC040R01"));
        entity.setEc050s01(XmlUtils.getValue(document, "/Document/ECA/EC05/EC050S01"));
        entity.setEc050r01(XmlUtils.getValue(document, "/Document/ECA/EC05/EC050R01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEcaDAO().save(entity);
    }

/*   public static void parseCrComEda(Document document, String batchId) throws Exception {
        CrComEdaEntity entity = new CrComEdaEntity();
        entity.setId(batchId);
        entity.setEd01Bs01(NumberUtils.parseInteger(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01B/ED01BS01")));
        entity.setEd01Cs01(NumberUtils.parseInteger(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01C/ED01CS01")));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        ApplicationContextUtil.getBean(CrComEdaDao.class).save(entity);
    }*/

    public static void parseCrComEd01B(Node node, String batchId,String parentId) throws Exception{
    	CrComEd01b entity=new CrComEd01b();
    	entity.setBatchId(batchId);
    	entity.setParentId(parentId);
    	entity.setEd01bs01(XmlUtils.getValue(node, "ED01BS01"));
    	LOGGER.info("entity = {}", JsonUtils.toJson(entity));
    	BaseDAOUtils.getCrComEd01bDAO().save(entity);
    	List<Node> nodeList = node.selectNodes("ED01BH");
    	if(CollectionUtils.isEmpty(nodeList) == false) {
    		for(Node ed01BhNode:nodeList) {
    			 parseCrComEd01Bh(ed01BhNode, batchId,parentId);
    		}
    	}
    }

    public static void parseCrComEd01C(Node node, String batchId,String parentId) throws Exception{
                CrComEd01c entity=new CrComEd01c();
                entity.setParentId(parentId);
                entity.setBatchId(batchId);
                entity.setEd01cs01(XmlUtils.getValue(node, "ED01CS01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd01cDAO().save(entity);
                List<Node> nodeList = node.selectNodes("ED01CH");
                if(CollectionUtils.isEmpty(nodeList) == false) {
                for(Node ed01ChNode:nodeList) {
                	parseCrComEd01Ch(ed01ChNode, batchId,parentId);
                }
                }
        }

    public static void parseCrComEd01(Document document, String batchId) throws Exception{
        List<String> ed01IdList=new ArrayList<String>();
       // List<Node> nodeList = document.selectNodes("/Document/EDA/ED01/ED01A");
        List<Node> nodeList = document.selectNodes("/Document/EDA/ED01");
            if (CollectionUtils.isEmpty(nodeList) == false) {
                for (Node node : nodeList) {
                    CrComEd01 entity=new CrComEd01(); 
                    Node ed01ANode = node.selectSingleNode("ED01A");
                    Node ed01BNode = node.selectSingleNode("ED01B");
                    Node ed01CNode = node.selectSingleNode("ED01C");
                    entity.setBatchId(batchId);
                    entity.setEd01ai01(XmlUtils.getValue(ed01ANode, "ED01AI01"));
                    entity.setEd01ad01(XmlUtils.getValue(ed01ANode, "ED01AD01"));
                    entity.setEd01ad02(XmlUtils.getValue(ed01ANode, "ED01AD02"));
                    entity.setEd01ad03(XmlUtils.getValue(ed01ANode, "ED01AD03"));
                    entity.setEd01ad04(XmlUtils.getValue(ed01ANode, "ED01AD04"));
                    entity.setEd01ai02(XmlUtils.getValue(ed01ANode, "ED01AI02"));
                    entity.setEd01ai03(XmlUtils.getValue(ed01ANode, "ED01AI03"));
                    entity.setEd01ad05(XmlUtils.getValue(ed01ANode, "ED01AD05"));
                    entity.setEd01ad06(XmlUtils.getValue(ed01ANode, "ED01AD06"));
                    entity.setEd01ar01(XmlUtils.getValue(ed01ANode, "ED01AR01"));
                    entity.setEd01ad07(XmlUtils.getValue(ed01ANode, "ED01AD07"));
                    entity.setEd01aj01(XmlUtils.getValue(ed01ANode, "ED01AJ01"));
                    entity.setEd01aj02(XmlUtils.getValue(ed01ANode, "ED01AJ02"));
                    entity.setEd01ar02(XmlUtils.getValue(ed01ANode, "ED01AR02"));
                    entity.setEd01ad08(XmlUtils.getValue(ed01ANode, "ED01AD08"));
                    entity.setEd01ad09(XmlUtils.getValue(ed01ANode, "ED01AD09"));
                    entity.setEd01ad10(XmlUtils.getValue(ed01ANode, "ED01AD10"));
                    entity.setEd01ad11(XmlUtils.getValue(ed01ANode, "ED01AD11"));
                    entity.setEd01ar03(XmlUtils.getValue(ed01ANode, "ED01AR03"));
                    entity.setEd01ar04(XmlUtils.getValue(ed01ANode, "ED01AR04"));
                    LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                    BaseDAOUtils.getCrComEd01DAO().save(entity);
               //     ed01IdList.add(entity.getId());
                    if(node.selectSingleNode("ED01B")!=null) {
                    	parseCrComEd01B(ed01BNode,batchId,entity.getId());
                    }
                    if(node.selectSingleNode("ED01C")!=null) {
                    	parseCrComEd01C(ed01CNode,batchId,entity.getId());
                    }
                    
                }
            }

    }


    public static void parseCrComEd02(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/EDA/ED02");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
            	CrComEd02 entity=new CrComEd02();
                entity.setBatchId(batchId);
                entity.setEd020i01(XmlUtils.getValue(node, "ED020I01"));
                entity.setEd020d01(XmlUtils.getValue(node, "ED020D01"));
                entity.setEd020i02(XmlUtils.getValue(node, "ED020I02"));
                entity.setEd020d02(XmlUtils.getValue(node, "ED020D02"));
                entity.setEd020d03(XmlUtils.getValue(node, "ED020D03"));
                entity.setEd020s01(XmlUtils.getValue(node, "ED020S01"));
                entity.setEd020j01(XmlUtils.getValue(node, "ED020J01"));
                entity.setEd020j02(XmlUtils.getValue(node, "ED020J02"));
                entity.setEd020j03(XmlUtils.getValue(node, "ED020J03"));
                entity.setEd020s02(XmlUtils.getValue(node, "ED020S02"));
                entity.setEd020j04(XmlUtils.getValue(node, "ED020J04"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd02DAO().save(entity);
                 }
        }
    }

    public static void parseCrComEd03(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/EDA/ED03");
        if (CollectionUtils.isEmpty(nodeList) == false) {
        	 for (Node node : nodeList) {
                CrComEd03 entity=new CrComEd03();
                entity.setBatchId(batchId);
                entity.setEd030i01(XmlUtils.getValue(node, "ED030I01"));
                entity.setEd030d01(XmlUtils.getValue(node, "ED030D01"));
                entity.setEd030i02(XmlUtils.getValue(node, "ED030I02"));
                entity.setEd030d02(XmlUtils.getValue(node, "ED030D02"));
                entity.setEd030j01(XmlUtils.getValue(node, "ED030J01"));
                entity.setEd030r01(XmlUtils.getValue(node, "ED030R01"));
                entity.setEd030d03(XmlUtils.getValue(node, "ED030D03"));
                entity.setEd030r02(XmlUtils.getValue(node, "ED030R02"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd03DAO().save(entity);
            }
        }
    }

    public static void parseCrComEd04(Document document, String batchId) throws Exception{
    //    List<Node> nodeList = document.selectNodes("/Document/EDB/ED04/ED04A");
    	List<Node> nodeList = document.selectNodes("/Document/EDB/ED04");
        if (CollectionUtils.isEmpty(nodeList) == false) {
        	   for (Node node : nodeList) {
                CrComEd04 entity=new CrComEd04();
                Node ed04ANode = node.selectSingleNode("ED04A");
                Node ed04BNode = node.selectSingleNode("ED04B");
                entity.setBatchId(batchId);
                entity.setEd04ai01(XmlUtils.getValue(ed04ANode, "ED04AI01"));
                entity.setEd04ad01(XmlUtils.getValue(ed04ANode, "ED04AD01"));
                entity.setEd04ad02(XmlUtils.getValue(ed04ANode, "ED04AD02"));
                entity.setEd04ai02(XmlUtils.getValue(ed04ANode, "ED04AI02"));
                entity.setEd04ai03(XmlUtils.getValue(ed04ANode, "ED04AI03"));
                entity.setEd04ad03(XmlUtils.getValue(ed04ANode, "ED04AD03"));
                entity.setEd04ar01(XmlUtils.getValue(ed04ANode, "ED04AR01"));
                entity.setEd04ad04(XmlUtils.getValue(ed04ANode, "ED04AD04"));
                entity.setEd04aj01(XmlUtils.getValue(ed04ANode, "ED04AJ01"));
                entity.setEd04ar02(XmlUtils.getValue(ed04ANode, "ED04AR02"));
                entity.setEd04ad05(XmlUtils.getValue(ed04ANode, "ED04AD05"));
                entity.setEd04ad06(XmlUtils.getValue(ed04ANode, "ED04AD06"));
                entity.setEd04aq01(XmlUtils.getValue(ed04ANode, "ED04AQ01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd04DAO().save(entity);
                if(node.selectSingleNode("ED04B")!=null) {
                	parseCrComEd04B(ed04BNode,batchId,entity.getId());
                }
            }
        }
        
        
    }
    
    
    public static void parseCrComEd04B(Node node, String batchId,String parentId)  throws Exception{
                  CrComEd04b entity=new CrComEd04b();
                  entity.setBatchId(batchId);
                  entity.setParentId(parentId);
                  entity.setEd04br01(XmlUtils.getValue(node, "ED04BR01"));
                  entity.setEd04bd01(XmlUtils.getValue(node, "ED04BD01"));
                  entity.setEd04bj01(XmlUtils.getValue(node, "ED04BJ01"));
                  entity.setEd04bd02(XmlUtils.getValue(node, "ED04BD02"));
                  entity.setEd04bj02(XmlUtils.getValue(node, "ED04BJ02"));
                  entity.setEd04bd03(XmlUtils.getValue(node, "ED04BD03"));
                  entity.setEd04bd04(XmlUtils.getValue(node, "ED04BD04"));
                  entity.setEd04br02(XmlUtils.getValue(node, "ED04BR02"));
                  LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                  BaseDAOUtils.getCrComEd04bDAO().save(entity);
    }

    public static void parseCrComEd05(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/EDB/ED05");
        if (CollectionUtils.isEmpty(nodeList) == false) {
        	 for (Node node : nodeList) {
                CrComEd05 entity=new CrComEd05();
                entity.setBatchId(batchId);
                entity.setEd050i01(XmlUtils.getValue(node, "ED050I01"));
                entity.setEd050d01(XmlUtils.getValue(node, "ED050D01"));
                entity.setEd050i02(XmlUtils.getValue(node, "ED050I02"));
                entity.setEd050d02(XmlUtils.getValue(node, "ED050D02"));
                entity.setEd050d03(XmlUtils.getValue(node, "ED050D03"));
                entity.setEd050s01(XmlUtils.getValue(node, "ED050S01"));
                entity.setEd050j01(XmlUtils.getValue(node, "ED050J01"));
                entity.setEd050j02(XmlUtils.getValue(node, "ED050J02"));
                entity.setEd050j03(XmlUtils.getValue(node, "ED050J03"));
                entity.setEd050j04(XmlUtils.getValue(node, "ED050J04"));
                entity.setEd050j05(XmlUtils.getValue(node, "ED050J05"));
                entity.setEd050s02(XmlUtils.getValue(node, "ED050S02"));
                entity.setEd050d04(XmlUtils.getValue(node, "ED050D04"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd05DAO().save(entity);
            }
        }
    }

    public static void parseCrComEd06(Document document, String batchId) throws Exception {
    	  List<Node> nodeList = document.selectNodes("/Document/EDD/ED06");
    	  if (CollectionUtils.isEmpty(nodeList) == false) {
              for (Node node : nodeList) {
                  CrComEd06 entity=new CrComEd06();
                  entity.setEd060i01(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060I01"));
                  entity.setEd060d01(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060D01"));
                  entity.setEd060i02(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060I02"));
                  entity.setEd060d02(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060D02"));
                  entity.setEd060d03(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060D03"));
                  entity.setEd060d04(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060D04"));
                  entity.setEd060j01(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060J01"));
                  entity.setEd060j04(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060J04"));
                  entity.setEd060j03(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060J03"));
                  entity.setEd060i03(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060I03"));
                  entity.setEd060r01(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060R01"));
                  entity.setEd060r02(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060R02"));
                  entity.setEd060r03(XmlUtils.getValue(document, "/Document/EDC/ED06/ED060R03"));
                  LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                  BaseDAOUtils.getCrComEd06Dao().save(entity);
              }
          }
    }	  

    public static void parseCrComEd07(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/EDD/ED07");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEd07 entity=new CrComEd07();
                entity.setBatchId(batchId);
                entity.setEd070i01(XmlUtils.getValue(node, "ED070I01"));
                entity.setEd070d01(XmlUtils.getValue(node, "ED070D01"));
                entity.setEd070d02(XmlUtils.getValue(node, "ED070D02"));
                entity.setEd070d03(XmlUtils.getValue(node, "ED070D03"));
                entity.setEd070d10(XmlUtils.getValue(node, "ED070D10"));
                entity.setEd070j01(XmlUtils.getValue(node, "ED070J01"));
                entity.setEd070d04(XmlUtils.getValue(node, "ED070D04"));
                entity.setEd070i02(XmlUtils.getValue(node, "ED070I02"));
                entity.setEd070d05(XmlUtils.getValue(node, "ED070D05"));
                entity.setEd070d06(XmlUtils.getValue(node, "ED070D06"));
                entity.setEd070r01(XmlUtils.getValue(node, "ED070R01"));
                entity.setEd070r02(XmlUtils.getValue(node, "ED070R02"));
                entity.setEd070d07(XmlUtils.getValue(node, "ED070D07"));
                entity.setEd070j02(XmlUtils.getValue(node, "ED070J02"));
                entity.setEd070d08(XmlUtils.getValue(node, "ED070D08"));
                entity.setEd070j03(XmlUtils.getValue(node, "ED070J03"));
                entity.setEd070j04(XmlUtils.getValue(node, "ED070J04"));
                entity.setEd070s01(XmlUtils.getValue(node, "ED070S01"));
                entity.setEd070d09(XmlUtils.getValue(node, "ED070D09"));
                entity.setEd070s02(XmlUtils.getValue(node, "ED070S02"));
                entity.setEd070r03(XmlUtils.getValue(node, "ED070R03"));
                entity.setEd070j05(XmlUtils.getValue(node, "ED070J05"));
                entity.setEd070j06(XmlUtils.getValue(node, "ED070J06"));
                entity.setEd070i03(XmlUtils.getValue(node, "ED070I03"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd07DAO().save(entity);
            }
        }
    }

    public static void parseCrComEd08(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/EDD/ED08");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEd08 entity=new CrComEd08();
                entity.setBatchId(batchId);
                entity.setEd080i01(XmlUtils.getValue(node, "ED080I01"));
                entity.setEd080d01(XmlUtils.getValue(node, "ED080D01"));
                entity.setEd080d02(XmlUtils.getValue(node, "ED080D02"));
                entity.setEd080i02(XmlUtils.getValue(node, "ED080I02"));
                entity.setEd080d03(XmlUtils.getValue(node, "ED080D03"));
                entity.setEd080d04(XmlUtils.getValue(node, "ED080D04"));
                entity.setEd080j01(XmlUtils.getValue(node, "ED080J01"));
                entity.setEd080s01(XmlUtils.getValue(node, "ED080S01"));
                entity.setEd080j02(XmlUtils.getValue(node, "ED080J02"));
                entity.setEd080j03(XmlUtils.getValue(node, "ED080J03"));
                entity.setEd080j04(XmlUtils.getValue(node, "ED080J04"));
                entity.setEd080j05(XmlUtils.getValue(node, "ED080J05"));
                entity.setEd080i03(XmlUtils.getValue(node, "ED080I03"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd08DAO().save(entity);
            }
        }
    }

    public static void parseCrComEd09(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/EDD/ED09");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEd09 entity=new CrComEd09();
                entity.setBatchId(batchId);
                entity.setEd090i01(XmlUtils.getValue(node, "ED090I01"));
                entity.setEd090d01(XmlUtils.getValue(node, "ED090D01"));
                entity.setEd090d02(XmlUtils.getValue(node, "ED090D02"));
                entity.setEd090i02(XmlUtils.getValue(node, "ED090I02"));
                entity.setEd090d03(XmlUtils.getValue(node, "ED090D03"));
                entity.setEd090d04(XmlUtils.getValue(node, "ED090D04"));
                entity.setEd090j01(XmlUtils.getValue(node, "ED090J01"));
                entity.setEd090s01(XmlUtils.getValue(node, "Ed090s01"));
                entity.setEd090J02(XmlUtils.getValue(node, "ED090J02"));
                entity.setEd090J03(XmlUtils.getValue(node, "ED090J03"));
                entity.setEd090i03(XmlUtils.getValue(node, "ED090i03"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEd09DAO().save(entity);
            }
        }
    }








    public static void parseCrComEea(Document document, String batchId) throws Exception {
        CrComEea entity = new CrComEea();
        entity.setId(batchId);

        entity.setEe01ai01(XmlUtils.getValue(document, "/Document/EEA/EE01/EE01A/EE01AI01"));
        entity.setEe01aq01(XmlUtils.getValue(document, "/Document/EEA/EE01/EE01A/EE01AQ01"));
        entity.setEe01ad01(XmlUtils.getValue(document, "/Document/EEA/EE01/EE01A/EE01AD01"));
        entity.setEe01ad02(XmlUtils.getValue(document, "/Document/EEA/EE01/EE01A/EE01AD02"));
        entity.setEe01aj01(XmlUtils.getValue(document, "/Document/EEA/EE01/EE01A/EE01AJ01"));
        entity.setEe01ar01(XmlUtils.getValue(document, "/Document/EEA/EE01/EE01A/EE01AR01"));
        entity.setEe01bs01(XmlUtils.getValue(document, "/Document/EEA/EE01/EE01B/EE01BS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEeaDAO().save(entity);
    }

    public static void parseCrComEfa(Document document, String batchId) throws Exception {
        CrComEfa entity = new CrComEfa();
        entity.setId(batchId);

        entity.setEf010i01(XmlUtils.getValue(document, "/Document/EFA/EF01/EF010I01"));
        entity.setEf010q01(XmlUtils.getValue(document, "/Document/EFA/EF01/EF010Q01"));
        entity.setEf010j01(XmlUtils.getValue(document, "/Document/EFA/EF01/EF010J01"));
        entity.setEf010r01(XmlUtils.getValue(document, "/Document/EFA/EF01/EF010R01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEfaDAO().save(entity);
    }

    public static void parseCrComEfb(Document document, String batchId) throws Exception {
        CrComEfb entity = new CrComEfb();
        entity.setId(batchId);

        entity.setEf020i01(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020I01"));
        entity.setEf020q01(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020Q01"));
        entity.setEf020i02(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020I02"));
        entity.setEf020r01(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020R01"));
        entity.setEf020q02(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020Q02"));
        entity.setEf020d01(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020D01"));
        entity.setEf020d02(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020D02"));
        entity.setEf020q03(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020Q03"));
        entity.setEf020j01(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020J01"));
        entity.setEf020d03(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020D03"));
        entity.setEf020r02(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020R02"));
        entity.setEf020q04(XmlUtils.getValue(document, "/Document/EFB/EF02/EF020Q04"));
        entity.setEf030i01(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030I01"));
        entity.setEf030q01(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030Q01"));
        entity.setEf030i02(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030I02"));
        entity.setEf030r01(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030R01"));
        entity.setEf030q02(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030Q02"));
        entity.setEf030q03(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030Q03"));
        entity.setEf030j01(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030J01"));
        entity.setEf030q04(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030Q04"));
        entity.setEf030d01(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030D01"));
        entity.setEf030q05(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030Q05"));
        entity.setEf030j02(XmlUtils.getValue(document, "/Document/EFB/EF03/EF030J02"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEfbDAO().save(entity);
    }

    public static void parseCrComEfc(Document document, String batchId) throws Exception {
        CrComEfc entity = new CrComEfc();
        entity.setId(batchId);

        entity.setEf040i01(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040I01"));
        entity.setEf040q01(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040Q01"));
        entity.setEf040i02(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040I02"));
        entity.setEf040q02(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040Q02"));
        entity.setEf040q03(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040Q03"));
        entity.setEf040r01(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040R01"));
        entity.setEf040j01(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040J01"));
        entity.setEf040q04(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040Q04"));
        entity.setEf040q05(XmlUtils.getValue(document, "/Document/EFC/EF04/EF040Q05"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEfcDAO().save(entity);
    }

    public static void parseCrComEfd(Document document, String batchId) throws Exception {
    	CrComEfd entity = new CrComEfd();
        entity.setId(batchId);

        entity.setEf05ai01(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AI01"));
        entity.setEf05ar01(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AR01"));
        entity.setEf05as01(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AS01"));
        entity.setEf05aj01(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AJ01"));
        entity.setEf05ar02(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AR02"));
        entity.setEf05ar03(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AR03"));
        entity.setEf05ad01(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AD01"));
        entity.setEf05aj02(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AJ02"));
        entity.setEf05ar04(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05A/EF05AR04"));
        entity.setEf05bs01(XmlUtils.getValue(document, "/Document/EFD/EF05/EF05B/EF05BS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEfdDAO().save(entity);
    }

    public static void parseCrComEfe(Document document, String batchId) throws Exception {
    	CrComEfe entity = new CrComEfe();
        entity.setId(batchId);

        entity.setEf060i01(XmlUtils.getValue(document, "/Document/EFE/EF06/EF060I01"));
        entity.setEf060q01(XmlUtils.getValue(document, "/Document/EFE/EF06/EF060Q01"));
        entity.setEf060q02(XmlUtils.getValue(document, "/Document/EFE/EF06/EF060Q02"));
        entity.setEf060r01(XmlUtils.getValue(document, "/Document/EFE/EF06/EF060R01"));
        entity.setEf060r02(XmlUtils.getValue(document, "/Document/EFE/EF06/EF060R02"));
        entity.setEf060q03(XmlUtils.getValue(document, "/Document/EFE/EF06/EF060Q03"));
        entity.setEf070i01(XmlUtils.getValue(document, "/Document/EFE/EF07/EF070I01"));
        entity.setEf070q01(XmlUtils.getValue(document, "/Document/EFE/EF07/EF070Q01"));
        entity.setEf070q02(XmlUtils.getValue(document, "/Document/EFE/EF07/EF070Q02"));
        entity.setEf070r01(XmlUtils.getValue(document, "/Document/EFE/EF07/EF070R01"));
        entity.setEf070r02(XmlUtils.getValue(document, "/Document/EFE/EF07/EF070R02"));
        entity.setEf070q03(XmlUtils.getValue(document, "/Document/EFE/EF07/EF070Q03"));
        entity.setEf080i01(XmlUtils.getValue(document, "/Document/EFE/EF08/EF080I01"));
        entity.setEf080q01(XmlUtils.getValue(document, "/Document/EFE/EF08/EF080Q01"));
        entity.setEf080q02(XmlUtils.getValue(document, "/Document/EFE/EF08/EF080Q02"));
        entity.setEf080r01(XmlUtils.getValue(document, "/Document/EFE/EF08/EF080R01"));
        entity.setEf080r02(XmlUtils.getValue(document, "/Document/EFE/EF08/EF080R02"));
        entity.setEf080q03(XmlUtils.getValue(document, "/Document/EFE/EF08/EF080Q03"));
        entity.setEf090i01(XmlUtils.getValue(document, "/Document/EFE/EF09/EF090I01"));
        entity.setEf090q01(XmlUtils.getValue(document, "/Document/EFE/EF09/EF090Q01"));
        entity.setEf090q02(XmlUtils.getValue(document, "/Document/EFE/EF09/EF090Q02"));
        entity.setEf090r01(XmlUtils.getValue(document, "/Document/EFE/EF09/EF090R01"));
        entity.setEf090r02(XmlUtils.getValue(document, "/Document/EFE/EF09/EF090R02"));
        entity.setEf090q03(XmlUtils.getValue(document, "/Document/EFE/EF09/EF090Q03"));
        entity.setEf100i01(XmlUtils.getValue(document, "/Document/EFE/EF10/EF100I01"));
        entity.setEf100q01(XmlUtils.getValue(document, "/Document/EFE/EF10/EF100Q01"));
        entity.setEf100i02(XmlUtils.getValue(document, "/Document/EFE/EF10/EF100I02"));
        entity.setEf100r01(XmlUtils.getValue(document, "/Document/EFE/EF10/EF100R01"));
        entity.setEf100r02(XmlUtils.getValue(document, "/Document/EFE/EF10/EF100R02"));
        entity.setEf100s01(XmlUtils.getValue(document, "/Document/EFE/EF10/EF100S01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEfeDAO().save(entity);
    }

    public static void parseCrComEff(Document document, String batchId) throws Exception {
    	CrComEff entity = new CrComEff();
        entity.setId(batchId);

        entity.setEf110i01(XmlUtils.getValue(document, "/Document/EFF/EF11/EF110I01"));
        entity.setEf110q01(XmlUtils.getValue(document, "/Document/EFF/EF11/EF110Q01"));
        entity.setEf110q02(XmlUtils.getValue(document, "/Document/EFF/EF11/EF110Q02"));
        entity.setEf110r01(XmlUtils.getValue(document, "/Document/EFF/EF11/EF110R01"));
        entity.setEf120i01(XmlUtils.getValue(document, "/Document/EFF/EF12/EF120I01"));
        entity.setEf120q01(XmlUtils.getValue(document, "/Document/EFF/EF12/EF120Q01"));
        entity.setEf120q02(XmlUtils.getValue(document, "/Document/EFF/EF12/EF120Q02"));
        entity.setEf120i01(XmlUtils.getValue(document, "/Document/EFF/EF12/EF120I01"));
        entity.setEf120r02(XmlUtils.getValue(document, "/Document/EFF/EF12/EF120R02"));
        entity.setEf130i01(XmlUtils.getValue(document, "/Document/EFF/EF13/EF130I01"));
        entity.setEf130q01(XmlUtils.getValue(document, "/Document/EFF/EF13/EF130Q01"));
        entity.setEf130q02(XmlUtils.getValue(document, "/Document/EFF/EF13/EF130Q02"));
        entity.setEf130d01(XmlUtils.getValue(document, "/Document/EFF/EF13/EF130D01"));
        entity.setEf130r01(XmlUtils.getValue(document, "/Document/EFF/EF13/EF130R01"));
        entity.setEf130r02(XmlUtils.getValue(document, "/Document/EFF/EF13/EF130R02"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEffDAO().save(entity);
    }

    public static void parseCrComEfg(Document document, String batchId) throws Exception {
    	CrComEfg entity = new CrComEfg();
        entity.setId(batchId);

        entity.setEf140i01(XmlUtils.getValue(document, "/Document/EFG/EF14/EF140I01"));
        entity.setEf140d01(XmlUtils.getValue(document, "/Document/EFG/EF14/EF140D01"));
        entity.setEf140d02(XmlUtils.getValue(document, "/Document/EFG/EF14/EF140D02"));
        entity.setEf140r01(XmlUtils.getValue(document, "/Document/EFG/EF14/EF140R01"));
        entity.setEf140j01(XmlUtils.getValue(document, "/Document/EFG/EF14/EF140J01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEfgDAO().save(entity);
    }

    public static void parseCrComEga(Document document, String batchId) throws Exception {
    	CrComEga entity = new CrComEga();
        entity.setId(batchId);

        entity.setEg01ai01(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01A/EG01AI01"));
        entity.setEg01ad01(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01A/EG01AD01"));
        entity.setEg01ai02(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01A/EG01AI02"));
        entity.setEg01ar01(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01A/EG01AR01"));
        entity.setEg01ad02(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01A/EG01AD02"));
        entity.setEg01ad03(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01A/EG01AD03"));
        entity.setEg01bj01(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ01"));
        entity.setEg01bj02(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ02"));
        entity.setEg01bj03(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ03"));
        entity.setEg01bj04(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ04"));
        entity.setEg01bj05(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ05"));
        entity.setEg01bj06(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ06"));
        entity.setEg01bj07(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ07"));
        entity.setEg01bj08(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ08"));
        entity.setEg01bj09(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ09"));
        entity.setEg01bj10(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ10"));
        entity.setEg01bj11(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ11"));
        entity.setEg01bj12(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ12"));
        entity.setEg01bj13(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ13"));
        entity.setEg01bj14(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ14"));
        entity.setEg01bj15(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ15"));
        entity.setEg01bj16(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ16"));
        entity.setEg01bj17(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ17"));
        entity.setEg01bj18(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ18"));
        entity.setEg01bj19(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ19"));
        entity.setEg01bj20(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ20"));
        entity.setEg01bj21(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ21"));
        entity.setEg01bj22(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ22"));
        entity.setEg01bj23(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ23"));
        entity.setEg01bj24(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ24"));
        entity.setEg01bj25(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ25"));
        entity.setEg01bj26(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ26"));
        entity.setEg01bj27(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ27"));
        entity.setEg01bj28(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ28"));
        entity.setEg01bj29(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ29"));
        entity.setEg01bj30(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ30"));
        entity.setEg01bj31(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ31"));
        entity.setEg01bj32(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ32"));
        entity.setEg01bj33(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ33"));
        entity.setEg01bj34(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ34"));
        entity.setEg01bj35(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ35"));
        entity.setEg01bj36(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ36"));
        entity.setEg01bj37(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ37"));
        entity.setEg01bj38(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ38"));
        entity.setEg01bj39(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ39"));
        entity.setEg01bj40(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ40"));
        entity.setEg01bj41(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ41"));
        entity.setEg01bj42(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ42"));
        entity.setEg01bj43(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ43"));
        entity.setEg01bj44(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ44"));
        entity.setEg01bj45(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ45"));
        entity.setEg01bj46(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ46"));
        entity.setEg01bj47(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ47"));
        entity.setEg01bj48(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ48"));
        entity.setEg01bj49(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ49"));
        entity.setEg01bj50(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ50"));
        entity.setEg01bj51(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ51"));
        entity.setEg01bj52(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ52"));
        entity.setEg01bj53(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ53"));
        entity.setEg01bj54(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ54"));
        entity.setEg01bj55(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ55"));
        entity.setEg01bj56(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ56"));
        entity.setEg01bj57(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ57"));
        entity.setEg01bj58(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ58"));
        entity.setEg01bj59(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ59"));
        entity.setEg01bj60(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ60"));
        entity.setEg01bj61(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ61"));
        entity.setEg01bj62(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ62"));
        entity.setEg01bj63(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ63"));
        entity.setEg01bj64(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ64"));
        entity.setEg01bj65(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ65"));
        entity.setEg01bj66(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ66"));
        entity.setEg01bj67(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ67"));
        entity.setEg01bj68(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ68"));
        entity.setEg01bj69(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ69"));
        entity.setEg01bj70(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ70"));
        entity.setEg01bj71(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ71"));
        entity.setEg01bj72(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ72"));
        entity.setEg01bj73(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ73"));
        entity.setEg01bj74(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ74"));
        entity.setEg01bj75(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ75"));
        entity.setEg01bj76(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ76"));
        entity.setEg01bj77(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ77"));
        entity.setEg01bj78(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ78"));
        entity.setEg01bj79(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ79"));
        entity.setEg01bj80(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ80"));
        entity.setEg01bj81(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ81"));
        entity.setEg01bj82(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ82"));
        entity.setEg01bj83(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ83"));
        entity.setEg01bj84(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ84"));
        entity.setEg01bj85(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ85"));
        entity.setEg01bj86(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ86"));
        entity.setEg01bj87(XmlUtils.getValue(document, "/Document/EGA/EG01/EG01B/EG01BJ87"));
        entity.setEg02ai01(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02A/EG02AI01"));
        entity.setEg02ad01(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02A/EG02AD01"));
        entity.setEg02ai02(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02A/EG02AI02"));
        entity.setEg02ar01(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02A/EG02AR01"));
        entity.setEg02ad02(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02A/EG02AD02"));
        entity.setEg02ad03(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02A/EG02AD03"));
        entity.setEg02bj01(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ01"));
        entity.setEg02bj02(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ02"));
        entity.setEg02bj03(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ03"));
        entity.setEg02bj04(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ04"));
        entity.setEg02bj05(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ05"));
        entity.setEg02bj06(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ06"));
        entity.setEg02bj07(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ07"));
        entity.setEg02bj08(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ08"));
        entity.setEg02bj09(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ09"));
        entity.setEg02bj10(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ10"));
        entity.setEg02bj11(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ11"));
        entity.setEg02bj12(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ12"));
        entity.setEg02bj13(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ13"));
        entity.setEg02bj14(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ14"));
        entity.setEg02bj15(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ15"));
        entity.setEg02bj16(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ16"));
        entity.setEg02bj17(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ17"));
        entity.setEg02bj18(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ18"));
        entity.setEg02bj19(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ19"));
        entity.setEg02bj20(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ20"));
        entity.setEg02bj21(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ21"));
        entity.setEg02bj22(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ22"));
        entity.setEg02bj23(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ23"));
        entity.setEg02bj24(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ24"));
        entity.setEg02bj25(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ25"));
        entity.setEg02bj26(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ26"));
        entity.setEg02bj27(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ27"));
        entity.setEg02bj28(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ28"));
        entity.setEg02bj29(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ29"));
        entity.setEg02bj30(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ30"));
        entity.setEg02bj31(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ31"));
        entity.setEg02bj32(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ32"));
        entity.setEg02bj33(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ33"));
        entity.setEg02bj34(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ34"));
        entity.setEg02bj35(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ35"));
        entity.setEg02bj36(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ36"));
        entity.setEg02bj37(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ37"));
        entity.setEg02bj38(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ38"));
        entity.setEg02bj39(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ39"));
        entity.setEg02bj40(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ40"));
        entity.setEg02bj41(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ41"));
        entity.setEg02bj42(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ42"));
        entity.setEg02bj43(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ43"));
        entity.setEg02bj44(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ44"));
        entity.setEg02bj45(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ45"));
        entity.setEg02bj46(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ46"));
        entity.setEg02bj47(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ47"));
        entity.setEg02bj48(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ48"));
        entity.setEg02bj49(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ49"));
        entity.setEg02bj50(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ50"));
        entity.setEg02bj51(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ51"));
        entity.setEg02bj52(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ52"));
        entity.setEg02bj53(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ53"));
        entity.setEg02bj54(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ54"));
        entity.setEg02bj55(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ55"));
        entity.setEg02bj56(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ56"));
        entity.setEg02bj57(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ57"));
        entity.setEg02bj58(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ58"));
        entity.setEg02bj59(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ59"));
        entity.setEg02bj60(XmlUtils.getValue(document, "/Document/EGA/EG02/EG02B/EG02BJ60"));
        entity.setEg03ai01(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03A/EG03AI01"));
        entity.setEg03ad01(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03A/EG03AD01"));
        entity.setEg03ai02(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03A/EG03AI02"));
        entity.setEg03ar01(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03A/EG03AR01"));
        entity.setEg03ad02(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03A/EG03AD02"));
        entity.setEg03ad03(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03A/EG03AD03"));
        entity.setEg03bj01(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ01"));
        entity.setEg03bj02(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ02"));
        entity.setEg03bj03(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ03"));
        entity.setEg03bj04(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ04"));
        entity.setEg03bj05(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ05"));
        entity.setEg03bj06(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ06"));
        entity.setEg03bj07(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ07"));
        entity.setEg03bj08(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ08"));
        entity.setEg03bj09(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ09"));
        entity.setEg03bj10(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ10"));
        entity.setEg03bj11(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ11"));
        entity.setEg03bj12(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ12"));
        entity.setEg03bj13(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ13"));
        entity.setEg03bj14(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ14"));
        entity.setEg03bj15(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ15"));
        entity.setEg03bj16(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ16"));
        entity.setEg03bj17(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ17"));
        entity.setEg03bj18(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ18"));
        entity.setEg03bj19(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ19"));
        entity.setEg03bj20(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ20"));
        entity.setEg03bj21(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ21"));
        entity.setEg03bj22(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ22"));
        entity.setEg03bj23(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ23"));
        entity.setEg03bj24(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ24"));
        entity.setEg03bj25(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ25"));
        entity.setEg03bj26(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ26"));
        entity.setEg03bj27(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ27"));
        entity.setEg03bj28(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ28"));
        entity.setEg03bj29(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ29"));
        entity.setEg03bj30(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ30"));
        entity.setEg03bj31(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ31"));
        entity.setEg03bj32(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ32"));
        entity.setEg03bj33(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ33"));
        entity.setEg03bj34(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ34"));
        entity.setEg03bj35(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ35"));
        entity.setEg03bj36(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ36"));
        entity.setEg03bj37(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ37"));
        entity.setEg03bj38(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ38"));
        entity.setEg03bj39(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ39"));
        entity.setEg03bj40(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ40"));
        entity.setEg03bj41(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ41"));
        entity.setEg03bj42(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ42"));
        entity.setEg03bj43(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ43"));
        entity.setEg03bj44(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ44"));
        entity.setEg03bj45(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ45"));
        entity.setEg03bj46(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ46"));
        entity.setEg03bj47(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ47"));
        entity.setEg03bj48(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ48"));
        entity.setEg03bj49(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ49"));
        entity.setEg03bj50(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ50"));
        entity.setEg03bj51(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ51"));
        entity.setEg03bj52(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ52"));
        entity.setEg03bj53(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ53"));
        entity.setEg03bj54(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ54"));
        entity.setEg03bj55(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ55"));
        entity.setEg03bj56(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ56"));
        entity.setEg03bj57(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ57"));
        entity.setEg03bj58(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ58"));
        entity.setEg03bj59(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ59"));
        entity.setEg03bj60(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ60"));
        entity.setEg03bj61(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ61"));
        entity.setEg03bj62(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ62"));
        entity.setEg03bj63(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ63"));
        entity.setEg03bj64(XmlUtils.getValue(document, "/Document/EGA/EG03/EG03B/EG03BJ64"));
        entity.setEg04ai01(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04A/EG04AI01"));
        entity.setEg04ad01(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04A/EG04AD01"));
        entity.setEg04ai02(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04A/EG04AI02"));
        entity.setEg04ar01(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04A/EG04AR01"));
        entity.setEg04ad02(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04A/EG04AD02"));
        entity.setEg04ad03(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04A/EG04AD03"));
        entity.setEg04bj01(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ01"));
        entity.setEg04bj02(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ02"));
        entity.setEg04bj03(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ03"));
        entity.setEg04bj04(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ04"));
        entity.setEg04bj05(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ05"));
        entity.setEg04bj06(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ06"));
        entity.setEg04bj07(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ07"));
        entity.setEg04bj08(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ08"));
        entity.setEg04bj09(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ09"));
        entity.setEg04bj10(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ10"));
        entity.setEg04bj11(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ11"));
        entity.setEg04bj12(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ12"));
        entity.setEg04bj13(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ13"));
        entity.setEg04bj14(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ14"));
        entity.setEg04bj15(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ15"));
        entity.setEg04bj16(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ16"));
        entity.setEg04bj17(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ17"));
        entity.setEg04bj18(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ18"));
        entity.setEg04bj19(XmlUtils.getValue(document, "/Document/EGA/EG04/EG04B/EG04BJ19"));
        entity.setEg05ai01(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05A/EG05AI01"));
        entity.setEg05ad01(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05A/EG05AD01"));
        entity.setEg05ai02(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05A/EG05AI02"));
        entity.setEg05ar01(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05A/EG05AR01"));
        entity.setEg05ad02(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05A/EG05AD02"));
        entity.setEg05ad03(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05A/EG05AD03"));
        entity.setEg05bj01(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ01"));
        entity.setEg05bj02(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ02"));
        entity.setEg05bj03(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ03"));
        entity.setEg05bj04(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ04"));
        entity.setEg05bj05(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ05"));
        entity.setEg05bj06(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ06"));
        entity.setEg05bj07(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ07"));
        entity.setEg05bj08(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ08"));
        entity.setEg05bj09(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ09"));
        entity.setEg05bj10(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ10"));
        entity.setEg05bj11(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ11"));
        entity.setEg05bj12(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ12"));
        entity.setEg05bj13(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ13"));
        entity.setEg05bj14(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ14"));
        entity.setEg05bj15(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ15"));
        entity.setEg05bj16(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ16"));
        entity.setEg05bj17(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ17"));
        entity.setEg05bj18(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ18"));
        entity.setEg05bj19(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ19"));
        entity.setEg05bj20(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ20"));
        entity.setEg05bj21(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ21"));
        entity.setEg05bj22(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ22"));
        entity.setEg05bj23(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ23"));
        entity.setEg05bj24(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ24"));
        entity.setEg05bj25(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ25"));
        entity.setEg05bj26(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ26"));
        entity.setEg05bj27(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ27"));
        entity.setEg05bj28(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ28"));
        entity.setEg05bj29(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ29"));
        entity.setEg05bj30(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ30"));
        entity.setEg05bj31(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ31"));
        entity.setEg05bj32(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ32"));
        entity.setEg05bj33(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ33"));
        entity.setEg05bj34(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ34"));
        entity.setEg05bj35(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ35"));
        entity.setEg05bj36(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ36"));
        entity.setEg05bj37(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ37"));
        entity.setEg05bj38(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ38"));
        entity.setEg05bj39(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ39"));
        entity.setEg05bj40(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ40"));
        entity.setEg05bj41(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ41"));
        entity.setEg05bj42(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ42"));
        entity.setEg05bj43(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ43"));
        entity.setEg05bj44(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ44"));
        entity.setEg05bj45(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ45"));
        entity.setEg05bj46(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ46"));
        entity.setEg05bj47(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ47"));
        entity.setEg05bj48(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ48"));
        entity.setEg05bj49(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ49"));
        entity.setEg05bj50(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ50"));
        entity.setEg05bj51(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ51"));
        entity.setEg05bj52(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ52"));
        entity.setEg05bj53(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ53"));
        entity.setEg05bj54(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ54"));
        entity.setEg05bj55(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ55"));
        entity.setEg05bj56(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ56"));
        entity.setEg05bj57(XmlUtils.getValue(document, "/Document/EGA/EG05/EG05B/EG05BJ57"));
        entity.setEg06ai01(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06A/EG06AI01"));
        entity.setEg06ad01(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06A/EG06AD01"));
        entity.setEg06ai02(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06A/EG06AI02"));
        entity.setEg06ar01(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06A/EG06AR01"));
        entity.setEg06ad02(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06A/EG06AD02"));
        entity.setEg06ad03(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06A/EG06AD03"));
        entity.setEg06bj01(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ01"));
        entity.setEg06bj02(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ02"));
        entity.setEg06bj03(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ03"));
        entity.setEg06bj04(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ04"));
        entity.setEg06bj05(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ05"));
        entity.setEg06bj06(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ06"));
        entity.setEg06bj07(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ07"));
        entity.setEg06bj08(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ08"));
        entity.setEg06bj09(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ09"));
        entity.setEg06bj10(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ10"));
        entity.setEg06bj11(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ11"));
        entity.setEg06bj12(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ12"));
        entity.setEg06bj13(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ13"));
        entity.setEg06bj14(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ14"));
        entity.setEg06bj15(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ15"));
        entity.setEg06bj16(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ16"));
        entity.setEg06bj17(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ17"));
        entity.setEg06bj18(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ18"));
        entity.setEg06bj19(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ19"));
        entity.setEg06bj20(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ20"));
        entity.setEg06bj21(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ21"));
        entity.setEg06bj22(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ22"));
        entity.setEg06bj23(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ23"));
        entity.setEg06bj24(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ24"));
        entity.setEg06bj25(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ25"));
        entity.setEg06bj26(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ26"));
        entity.setEg06bj27(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ27"));
        entity.setEg06bj28(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ28"));
        entity.setEg06bj29(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ29"));
        entity.setEg06bj30(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ30"));
        entity.setEg06bj31(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ31"));
        entity.setEg06bj32(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ32"));
        entity.setEg06bj33(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ33"));
        entity.setEg06bj34(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ34"));
        entity.setEg06bj35(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ35"));
        entity.setEg06bj36(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ36"));
        entity.setEg06bj37(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ37"));
        entity.setEg06bj38(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ38"));
        entity.setEg06bj39(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ39"));
        entity.setEg06bj40(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ40"));
        entity.setEg06bj41(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ41"));
        entity.setEg06bj42(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ42"));
        entity.setEg06bj43(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ43"));
        entity.setEg06bj44(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ44"));
        entity.setEg06bj45(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ45"));
        entity.setEg06bj46(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ46"));
        entity.setEg06bj47(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ47"));
        entity.setEg06bj48(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ48"));
        entity.setEg06bj49(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ49"));
        entity.setEg06bj50(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ50"));
        entity.setEg06bj51(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ51"));
        entity.setEg06bj52(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ52"));
        entity.setEg06bj53(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ53"));
        entity.setEg06bj54(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ54"));
        entity.setEg06bj55(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ55"));
        entity.setEg06bj56(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ56"));
        entity.setEg06bj57(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ57"));
        entity.setEg06bj58(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ58"));
        entity.setEg06bj59(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ59"));
        entity.setEg06bj60(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ60"));
        entity.setEg06bj61(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ61"));
        entity.setEg06bj62(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ62"));
        entity.setEg06bj63(XmlUtils.getValue(document, "/Document/EGA/EG06/EG06B/EG06BJ63"));
        entity.setEg07ai01(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07A/EG07AI01"));
        entity.setEg07ad01(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07A/EG07AD01"));
        entity.setEg07ai02(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07A/EG07AI02"));
        entity.setEg07ar01(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07A/EG07AR01"));
        entity.setEg07ad02(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07A/EG07AD02"));
        entity.setEg07ad03(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07A/EG07AD03"));
        entity.setEg07bj01(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ01"));
        entity.setEg07bj02(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ02"));
        entity.setEg07bj03(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ03"));
        entity.setEg07bj04(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ04"));
        entity.setEg07bj05(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ05"));
        entity.setEg07bj06(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ06"));
        entity.setEg07bj07(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ07"));
        entity.setEg07bj08(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ08"));
        entity.setEg07bj09(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ09"));
        entity.setEg07bj10(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ10"));
        entity.setEg07bj11(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ11"));
        entity.setEg07bj12(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ12"));
        entity.setEg07bj13(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ13"));
        entity.setEg07bj14(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ14"));
        entity.setEg07bj15(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ15"));
        entity.setEg07bj16(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ16"));
        entity.setEg07bj17(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ17"));
        entity.setEg07bj18(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ18"));
        entity.setEg07bj19(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ19"));
        entity.setEg07bj20(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ20"));
        entity.setEg07bj21(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ21"));
        entity.setEg07bj22(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ22"));
        entity.setEg07bj23(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ23"));
        entity.setEg07bj24(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ24"));
        entity.setEg07bj25(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ25"));
        entity.setEg07bj26(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ26"));
        entity.setEg07bj27(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ27"));
        entity.setEg07bj28(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ28"));
        entity.setEg07bj29(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ29"));
        entity.setEg07bj30(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ30"));
        entity.setEg07bj31(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ31"));
        entity.setEg07bj32(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ32"));
        entity.setEg07bj33(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ33"));
        entity.setEg07bj34(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ34"));
        entity.setEg07bj35(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ35"));
        entity.setEg07bj36(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ36"));
        entity.setEg07bj37(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ37"));
        entity.setEg07bj38(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ38"));
        entity.setEg07bj39(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ39"));
        entity.setEg07bj40(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ40"));
        entity.setEg07bj41(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ41"));
        entity.setEg07bj42(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ42"));
        entity.setEg07bj43(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ43"));
        entity.setEg07bj44(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ44"));
        entity.setEg07bj45(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ45"));
        entity.setEg07bj46(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ46"));
        entity.setEg07bj47(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ47"));
        entity.setEg07bj48(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ48"));
        entity.setEg07bj49(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ49"));
        entity.setEg07bj50(XmlUtils.getValue(document, "/Document/EGA/EG07/EG07B/EG07BJ50"));
        entity.setEg08ai01(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08A/EG08AI01"));
        entity.setEg08ad01(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08A/EG08AD01"));
        entity.setEg08ai02(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08A/EG08AI02"));
        entity.setEg08ar01(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08A/EG08AR01"));
        entity.setEg08ad02(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08A/EG08AD02"));
        entity.setEg08ad03(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08A/EG08AD03"));
        entity.setEg08bj01(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ01"));
        entity.setEg08bj02(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ02"));
        entity.setEg08bj03(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ03"));
        entity.setEg08bj04(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ04"));
        entity.setEg08bj05(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ05"));
        entity.setEg08bj06(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ06"));
        entity.setEg08bj07(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ07"));
        entity.setEg08bj08(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ08"));
        entity.setEg08bj09(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ09"));
        entity.setEg08bj10(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ10"));
        entity.setEg08bj11(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ11"));
        entity.setEg08bj12(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ12"));
        entity.setEg08bj13(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ13"));
        entity.setEg08bj14(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ14"));
        entity.setEg08bj15(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ15"));
        entity.setEg08bj16(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ16"));
        entity.setEg08bj17(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ17"));
        entity.setEg08bj18(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ18"));
        entity.setEg08bj19(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ19"));
        entity.setEg08bj20(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ20"));
        entity.setEg08bj21(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ21"));
        entity.setEg08bj22(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ22"));
        entity.setEg08bj23(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ23"));
        entity.setEg08bj24(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ24"));
        entity.setEg08bj25(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ25"));
        entity.setEg08bj26(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ26"));
        entity.setEg08bj27(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ27"));
        entity.setEg08bj28(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ28"));
        entity.setEg08bj29(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ29"));
        entity.setEg08bj30(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ30"));
        entity.setEg08bj31(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ31"));
        entity.setEg08bj32(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ32"));
        entity.setEg08bj33(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ33"));
        entity.setEg08bj34(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ34"));
        entity.setEg08bj35(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ35"));
        entity.setEg08bj36(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ36"));
        entity.setEg08bj37(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ37"));
        entity.setEg08bj38(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ38"));
        entity.setEg08bj39(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ39"));
        entity.setEg08bj40(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ40"));
        entity.setEg08bj41(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ41"));
        entity.setEg08bj42(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ42"));
        entity.setEg08bj43(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ43"));
        entity.setEg08bj44(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ44"));
        entity.setEg08bj45(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ45"));
        entity.setEg08bj46(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ46"));
        entity.setEg08bj47(XmlUtils.getValue(document, "/Document/EGA/EG08/EG08B/EG08BJ47"));
        entity.setEg09ai01(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09A/EG09AI01"));
        entity.setEg09ad01(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09A/EG09AD01"));
        entity.setEg09ai02(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09A/EG09AI02"));
        entity.setEg09ar01(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09A/EG09AR01"));
        entity.setEg09ad02(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09A/EG09AD02"));
        entity.setEg09ad03(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09A/EG09AD03"));
        entity.setEg09bj01(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ01"));
        entity.setEg09bj02(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ02"));
        entity.setEg09bj03(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ03"));
        entity.setEg09bj04(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ04"));
        entity.setEg09bj05(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ05"));
        entity.setEg09bj06(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ06"));
        entity.setEg09bj07(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ07"));
        entity.setEg09bj08(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ08"));
        entity.setEg09bj09(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ09"));
        entity.setEg09bj10(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ10"));
        entity.setEg09bj11(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ11"));
        entity.setEg09bj12(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ12"));
        entity.setEg09bj13(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ13"));
        entity.setEg09bj14(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ14"));
        entity.setEg09bj15(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ15"));
        entity.setEg09bj16(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ16"));
        entity.setEg09bj17(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ17"));
        entity.setEg09bj18(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ18"));
        entity.setEg09bj19(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ19"));
        entity.setEg09bj20(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ20"));
        entity.setEg09bj21(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ21"));
        entity.setEg09bj22(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ22"));
        entity.setEg09bj23(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ23"));
        entity.setEg09bj24(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ24"));
        entity.setEg09bj25(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ25"));
        entity.setEg09bj26(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ26"));
        entity.setEg09bj27(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ27"));
        entity.setEg09bj28(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ28"));
        entity.setEg09bj29(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ29"));
        entity.setEg09bj30(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ30"));
        entity.setEg09bj31(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ31"));
        entity.setEg09bj32(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ32"));
        entity.setEg09bj33(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ33"));
        entity.setEg09bj34(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ34"));
        entity.setEg09bj35(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ35"));
        entity.setEg09bj36(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ36"));
        entity.setEg09bj37(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ37"));
        entity.setEg09bj38(XmlUtils.getValue(document, "/Document/EGA/EG09/EG09B/EG09BJ38"));
        entity.setEg10ai01(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10A/EG10AI01"));
        entity.setEg10ad01(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10A/EG10AD01"));
        entity.setEg10ai02(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10A/EG10AI02"));
        entity.setEg10ar01(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10A/EG10AR01"));
        entity.setEg10ad02(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10A/EG10AD02"));
        entity.setEg10ad03(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10A/EG10AD03"));
        entity.setEg10bj01(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ01"));
        entity.setEg10bj02(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ02"));
        entity.setEg10bj03(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ03"));
        entity.setEg10bj04(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ04"));
        entity.setEg10bj05(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ05"));
        entity.setEg10bj06(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ06"));
        entity.setEg10bj07(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ07"));
        entity.setEg10bj08(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ08"));
        entity.setEg10bj09(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ09"));
        entity.setEg10bj10(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ10"));
        entity.setEg10bj11(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ11"));
        entity.setEg10bj12(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ12"));
        entity.setEg10bj13(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ13"));
        entity.setEg10bj14(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ14"));
        entity.setEg10bj15(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ15"));
        entity.setEg10bj16(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ16"));
        entity.setEg10bj17(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ17"));
        entity.setEg10bj18(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ18"));
        entity.setEg10bj19(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ19"));
        entity.setEg10bj20(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ20"));
        entity.setEg10bj21(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ21"));
        entity.setEg10bj22(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ22"));
        entity.setEg10bj23(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ23"));
        entity.setEg10bj24(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ24"));
        entity.setEg10bj25(XmlUtils.getValue(document, "/Document/EGA/EG10/EG10B/EG10BJ25"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEgaDAO().save(entity);
    }

    public static void parseCrComEha(Document document, String batchId) throws Exception {
        CrComEha entity = new CrComEha();
        entity.setId(batchId);

        entity.setEh010i01(XmlUtils.getValue(document, "/Document/EHA/EH01/EH010I01"));
        entity.setEh010q01(XmlUtils.getValue(document, "/Document/EHA/EH01/EH010Q01"));
        entity.setEh010r01(XmlUtils.getValue(document, "/Document/EHA/EH01/EH010R01"));
        entity.setEh010d01(XmlUtils.getValue(document, "/Document/EHA/EH01/EH010D01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEhaDAO().save(entity);
    }

    public static void parseCrComEia(Document document, String batchId) throws Exception {
        CrComEia entity = new CrComEia();
        entity.setId(batchId);

        entity.setEi010d01(XmlUtils.getValue(document, "/Document/EIA/EI01/EI010D01"));
        entity.setEi010i01(XmlUtils.getValue(document, "/Document/EIA/EI01/EI010I01"));
        entity.setEi010d02(XmlUtils.getValue(document, "/Document/EIA/EI01/EI010D02"));
        entity.setEi010q01(XmlUtils.getValue(document, "/Document/EIA/EI01/EI010Q01"));
        entity.setEi010r01(XmlUtils.getValue(document, "/Document/EIA/EI01/EI010R01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrComEiaDAO().save(entity);
    }


    public static void parseCrComEa01Ch(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EAA/EA01/EA01C/EA01CH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEa01ch entity = new CrComEa01ch();
                entity.setBatchId(batchId);
                entity.setEa01cd01(XmlUtils.getValue(node, "EA01CD01"));
                entity.setEa01ci01(XmlUtils.getValue(node, "EA01CI01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                CrComEa01chDAO crComEa01chDao = BaseDAOUtils.getCrComEa01chDao();
                crComEa01chDao.save(entity);
            }
        }
    }
    
    public static void parseCollateralEa01ah(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EAA/EA01/EA01A/EA01AH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CollateralEa01ah entity = new CollateralEa01ah();
                entity.setBatchId(batchId);
                entity.setEa01Ad01(XmlUtils.getValue(node, "EA01AD01"));
                entity.setEa01Ai01(XmlUtils.getValue(node, "EA01AI01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCollateralEa01ahDao().save(entity);
            }
        }
    }
    
    

    public static void parseCrComEb02Ah(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EBB/EB02/EB02A/EB02AH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEb02ah entity = new CrComEb02ah();
                entity.setBatchId(batchId);

                entity.setEb02ad01(XmlUtils.getValue(node, "EB02AD01"));
                entity.setEb02ad02(XmlUtils.getValue(node, "EB02AD02"));
                entity.setEb02as04(XmlUtils.getValue(node, "EB02AS04"));
                entity.setEb02aj06(XmlUtils.getValue(node, "EB02AJ06"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEb02ahDAO().save(entity);
            }
        }
    }

    public static void parseCrComEb02Bh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EBB/EB02/EB02B/EB02BH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEb02bh entity = new CrComEb02bh();
                entity.setBatchId(batchId);

                entity.setEb02bd01(XmlUtils.getValue(node, "EB02BD01"));
                entity.setEb02bd02(XmlUtils.getValue(node, "EB02BD02"));
                entity.setEb02bs04(XmlUtils.getValue(node, "EB02BS04"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEb02bhDAO().save(entity);
            }
        }
    }

    public static void parseCrComEb02Ch(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EBB/EB02/EB02C/EB02CH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEb02ch entity = new CrComEb02ch();
                entity.setBatchId(batchId);

                entity.setEb02cr01(XmlUtils.getValue(node, "EB02CR01"));
                entity.setEb02cs02(XmlUtils.getValue(node, "EB02CS02"));
                entity.setEb02cj01(XmlUtils.getValue(node, "EB02CJ01"));
                entity.setEb02cs03(XmlUtils.getValue(node, "EB02CS03"));
                entity.setEb02cj02(XmlUtils.getValue(node, "EB02CJ02"));
                entity.setEb02cs04(XmlUtils.getValue(node, "EB02CS04"));
                entity.setEb02cj03(XmlUtils.getValue(node, "EB02CJ03"));
                entity.setEb02cs05(XmlUtils.getValue(node, "EB02CS05"));
                entity.setEb02cj04(XmlUtils.getValue(node, "EB02CJ04"));
                entity.setEb02cs06(XmlUtils.getValue(node, "EB02CS06"));
                entity.setEb02cj05(XmlUtils.getValue(node, "EB02CJ05"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEb02chDAO().save(entity);
            }
        }
    }

    public static void parseCrComEb03Ah(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EBC/EB03/EB03A/EB03AH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEb03ah entity = new CrComEb03ah();
                entity.setBatchId(batchId);

                entity.setEb03ad01(XmlUtils.getValue(node, "EB03AD01"));
                entity.setEb03ad02(XmlUtils.getValue(node, "EB03AD02"));
                entity.setEb03as02(XmlUtils.getValue(node, "EB03AS02"));
                entity.setEb03aj01(XmlUtils.getValue(node, "EB03AJ01"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEb03ahDAO().save(entity);
            }
        }
    }

    public static void parseCrComEb03Bh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EBC/EB03/EB03B/EB03BH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEb03bh entity = new CrComEb03bh();
                entity.setBatchId(batchId);

                entity.setEb03bd01(XmlUtils.getValue(node, "EB03BD01"));
                entity.setEb03bd02(XmlUtils.getValue(node, "EB03BD02"));
                entity.setEb03bs02(XmlUtils.getValue(node, "EB03BS02"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEb03bhDAO().save(entity);
            }
        }
    }

    public static void parseCrComEb05Ah(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EBE/EB05/EB05A/EB05AH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEb05ah entity = new CrComEb05ah();
                entity.setBatchId(batchId);

                entity.setEb05ad01(XmlUtils.getValue(node, "EB05AD01"));
                entity.setEb05aj01(XmlUtils.getValue(node, "EB05AJ01"));
                entity.setEb05as02(XmlUtils.getValue(node, "EB05AS02"));
                entity.setEb05aj02(XmlUtils.getValue(node, "EB05AJ02"));
                entity.setEb05aj03(XmlUtils.getValue(node, "EB05AJ03"));
                entity.setEb05as03(XmlUtils.getValue(node, "EB05AS03"));
                entity.setEb05aj04(XmlUtils.getValue(node, "EB05AJ04"));
                entity.setEb05aj05(XmlUtils.getValue(node, "EB05AJ05"));
                entity.setEb05aj06(XmlUtils.getValue(node, "EB05AJ06"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEb05ahDAO().save(entity);
            }
        }
    }

    public static void parseCrComEb05Bh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EBE/EB05/EB05B/EB05BH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEb05bh entity = new CrComEb05bh();
                entity.setBatchId(batchId);

                entity.setEb05bd01(XmlUtils.getValue(node, "EB05BD01"));
                entity.setEb05bj01(XmlUtils.getValue(node, "EB05BJ01"));
                entity.setEb05bs02(XmlUtils.getValue(node, "EB05BS02"));
                entity.setEb05bj02(XmlUtils.getValue(node, "EB05BJ02"));
                entity.setEb05bj03(XmlUtils.getValue(node, "EB05BJ03"));
                entity.setEb05bj04(XmlUtils.getValue(node, "EB05BJ04"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEb05bhDAO().save(entity);
            }
        }
    }

    public static void parseCrComEc020H(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/ECA/EC02/EC020H");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEc020h entity = new CrComEc020h();
                entity.setBatchId(batchId);

                entity.setEc020d01(XmlUtils.getValue(node, "EC020D01"));
                entity.setEc020d02(XmlUtils.getValue(node, "EC020D02"));
                entity.setEc020q01(XmlUtils.getValue(node, "EC020Q01"));
                entity.setEc020d03(XmlUtils.getValue(node, "EC020D03"));
                entity.setEc020i01(XmlUtils.getValue(node, "EC020I01"));
                entity.setEc020q02(XmlUtils.getValue(node, "EC020Q02"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEc020hDAO().save(entity);
            }
        }
    }

    public static void parseCrComEc030H(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/ECA/EC03/EC030H");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEc030h entity = new CrComEc030h();
                entity.setBatchId(batchId);

                entity.setEc030q01(XmlUtils.getValue(node, "EC030Q01"));
                entity.setEc030d01(XmlUtils.getValue(node, "EC030D01"));
                entity.setEc030i01(XmlUtils.getValue(node, "EC030I01"));
                entity.setEc030d02(XmlUtils.getValue(node, "EC030D02"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEc030hDAO().save(entity);
            }
        }
    }

    public static void parseCrComEc050H(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/ECA/EC05/EC050H");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEc050h entity = new CrComEc050h();
                entity.setBatchId(batchId);

                entity.setEc050d01(XmlUtils.getValue(node, "EC050D01"));
                entity.setEc050q01(XmlUtils.getValue(node, "EC050Q01"));
                entity.setEc050d02(XmlUtils.getValue(node, "EC050D02"));
                entity.setEc050i01(XmlUtils.getValue(node, "EC050I01"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEc050hDAO().save(entity);
            }
        }
    }

    public static void parseCrComEd01Bh(Node node, String batchId,String parentId) throws Exception {
                    CrComEd01bh entity = new CrComEd01bh();
                    entity.setBatchId(batchId);
                    entity.setParentid(parentId);
                    entity.setEd01br01(XmlUtils.getValue(node, "ED01BR01"));
                    entity.setEd01bj01(XmlUtils.getValue(node, "ED01BJ01"));
                    entity.setEd01br02(XmlUtils.getValue(node, "ED01BR02"));
                    entity.setEd01bd01(XmlUtils.getValue(node, "ED01BD01"));
                    entity.setEd01br03(XmlUtils.getValue(node, "ED01BR03"));
                    entity.setEd01br04(XmlUtils.getValue(node, "ED01BR04"));
                    entity.setEd01bj02(XmlUtils.getValue(node, "ED01BJ02"));
                    entity.setEd01bd02(XmlUtils.getValue(node, "ED01BD02"));
                    entity.setEd01br05(XmlUtils.getValue(node, "ED01BR05"));
                    entity.setEd01bj03(XmlUtils.getValue(node, "ED01BJ03"));
                    entity.setEd01bj04(XmlUtils.getValue(node, "ED01BJ04"));
                    entity.setEd01bj05(XmlUtils.getValue(node, "ED01BJ05"));
                    entity.setEd01bs02(XmlUtils.getValue(node, "ED01BS02"));
                    entity.setEd01bs03(XmlUtils.getValue(node, "ED01BS03"));

                    LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                    BaseDAOUtils.getCrComEd01bhDAO().save(entity);

    }

    public static void parseCrComEd01Ch(Node node, String batchId,String parentId) throws Exception {
                    CrComEd01ch entity = new CrComEd01ch();
                    entity.setBatchId(batchId);
                    entity.setParentid(parentId);
                    entity.setEd01cd01(XmlUtils.getValue(node, "ED01CD01"));
                    entity.setEd01cr01(XmlUtils.getValue(node, "ED01CR01"));
                    entity.setEd01cj01(XmlUtils.getValue(node, "ED01CJ01"));
                    entity.setEd01cs02(XmlUtils.getValue(node, "ED01CS02"));
                    entity.setEd01cq01(XmlUtils.getValue(node, "ED01CQ01"));

                    LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                    BaseDAOUtils.getCrComEd01chDAO().save(entity);

    }

    public static void parseCrComEe01Bh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EEA/EE01/EE01B/EE01BH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEe01bh entity = new CrComEe01bh();
                entity.setBatchId(batchId);

                entity.setEe01br01(XmlUtils.getValue(node, "EE01BR01"));
                entity.setEe01bd01(XmlUtils.getValue(node, "EE01BD01"));
                entity.setEe01bj01(XmlUtils.getValue(node, "EE01BJ01"));
                entity.setEe01bj02(XmlUtils.getValue(node, "EE01BJ02"));
                entity.setEe01bj03(XmlUtils.getValue(node, "EE01BJ03"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEe01bhDAO().save(entity);
            }
        }
    }

    public static void parseCrComEf05Bh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/EFD/EF05/EF05B/EF05BH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrComEf05bh entity = new CrComEf05bh();
                entity.setBatchId(batchId);

                entity.setEf05br01(XmlUtils.getValue(node, "EF05BR01"));
                entity.setEf05bd01(XmlUtils.getValue(node, "EF05BD01"));
                entity.setEf05bj01(XmlUtils.getValue(node, "EF05BJ01"));
                entity.setEf05bj02(XmlUtils.getValue(node, "EF05BJ02"));
                entity.setEf05bj03(XmlUtils.getValue(node, "EF05BJ03"));

                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrComEf05bhDAO().save(entity);
            }
        }
    }
    
    /**
     * 解析个人报文
     *
     * @param msg
     * @param uuid
     * @throws Exception
     */
    public static void parsePersonalReport(String msg, String uuid) throws Exception {
        Document document = DocumentHelper.parseText(msg);
        
        
       
        parseCrPerPrh(document, uuid);
        parseCrPerPa01Ch(document, uuid);
        parseCrPerPoq(document, uuid);
        parseCrPerPqo(document, uuid);
        parseCrPerPbs(document, uuid);
        parseCrPerPf06Zh(document, uuid);
        parseCrPerPno(document, uuid);
        parseCrPerPc030H(document, uuid);
        parseCrPerPpo(document, uuid);
        parseCrPerPc040H(document, uuid);
        parseCrPerPap(document, uuid);
        parseCrPerPf04Zh(document, uuid);
        parseCrPerPah(document, uuid);
        parseCrPerPf08Zh(document, uuid);
        parseCrPerPg010H(document, uuid);
        parseCrPerPnd(document, uuid);
        parseCrPerPe01Zh(document, uuid);
        parseCrPerPf01Zh(document, uuid);
        parseCrPerPmm(document, uuid);
            parseCrPerPda(document, uuid);
           /* parseCrPerPd01Zh(document, uuid);
            parseCrPerPd01Hh(document, uuid);
            parseCrPerPd01Fh(document, uuid);
            parseCrPerPd01Gh(document, uuid);
            parseCrPerPd01Dh(document, uuid);
            parseCrPerPd01Eh(document, uuid);*/
        parseCrPerPrm(document, uuid);    
        parseCrPerPcj(document, uuid);
        parseCrPerPf02Zh(document, uuid);
        parseCrPerPsm(document, uuid);
        parseCrPerPos(document, uuid);
        parseCrPerPot(document, uuid);
        parseCrPerPce(document, uuid);
        parseCrPerPf03Zh(document, uuid);
        parseCrPerPim(document, uuid);
        parseCrPerPb01Bh(document, uuid);
              parseCrPerPca(document, uuid);
        parseCrPerPd02Zh(document, uuid);
        parseCrPerPcr(document, uuid);
        parseCrPerPd03Zh(document, uuid);
        parseCrPerPco(document, uuid);
        parseCrPerPc02Bh(document, uuid);
        parseCrPerPc02Kh(document, uuid);
        parseCrPerPc02Ah(document, uuid);
        parseCrPerPc02Dh(document, uuid);
        parseCrPerPpq(document, uuid);
        parseCrPerPf07Zh(document, uuid);
        parseCrPerPom(document, uuid);
        parseCrPerPhf(document, uuid);
        parseCrPerPf05Zh(document, uuid);
    }

    /**
     * 征信查询个人征信结果-行政奖励记录
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPah(Document document, String batchId) throws Exception {
    	CrPerPah entity = new CrPerPah();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPf08aq01(XmlUtils.getValue(document, "/Document/PAH/PF08/PF08A/PF08AQ01"));
        entity.setPf08aq02(XmlUtils.getValue(document, "/Document/PAH/PF08/PF08A/PF08AQ02"));
        entity.setPf08ar01(XmlUtils.getValue(document, "/Document/PAH/PF08/PF08A/PF08AR01"));
        entity.setPf08ar02(XmlUtils.getValue(document, "/Document/PAH/PF08/PF08A/PF08AR02"));
        entity.setPf08zs01(XmlUtils.getValue(document, "/Document/PAH/PF08/PF08Z/PF08ZS01"));
        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPahDAO().save(entity);
    }

    /**
     * 征信查询个人征信结果-行政处罚记录
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPap(Document document, String batchId) throws Exception {
        CrPerPap entity = new CrPerPap();
        entity.setId(batchId);
        entity.setPf04aq01(XmlUtils.getValue(document, "/Document/PAP/PF04/PF04A/PF04AQ01"));
        entity.setPf04aq02(XmlUtils.getValue(document, "/Document/PAP/PF04/PF04A/PF04AQ02"));
        entity.setPf04aj01(XmlUtils.getValue(document, "/Document/PAP/PF04/PF04A/PF04AJ01"));
        entity.setPf04ar01(XmlUtils.getValue(document, "/Document/PAP/PF04/PF04A/PF04AR01"));
        entity.setPf04ar02(XmlUtils.getValue(document, "/Document/PAP/PF04/PF04A/PF04AR02"));
        entity.setPf04aq03(XmlUtils.getValue(document, "/Document/PAP/PF04/PF04A/PF04AQ03"));
        entity.setPf04zs01(XmlUtils.getValue(document, "/Document/PAP/PF04/PF04Z/PF04ZS01"));
        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPapDAO().save(entity);
    }

    /**
     * 征信查询个人征信结果-身份信息-手机号码信息段-手机号码信息
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPb01Bh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PIM/PB01/PB01B/PB01BH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPb01bh entity = new CrPerPb01bh();
                entity.setBatchId(batchId);
                entity.setPb01bq01(XmlUtils.getValue(node, "PB01BQ01"));
                entity.setPb01br01(XmlUtils.getValue(node, "PB01BR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPb01bhDAO().save(entity);
            }
        }
    }

    /**
     * 征信查询个人征信结果-低保救助记录
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPbs(Document document, String batchId) throws Exception {
        CrPerPbs entity = new CrPerPbs();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPf06ad01(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06A/PF06AD01"));
        entity.setPf06aq01(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06A/PF06AQ01"));
        entity.setPf06aq02(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06A/PF06AQ02"));
        entity.setPf06aq03(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06A/PF06AQ03"));
        entity.setPf06ar01(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06A/PF06AR01"));
        entity.setPf06ar02(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06A/PF06AR02"));
        entity.setPf06ar03(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06A/PF06AR03"));
        entity.setPf06zs01(XmlUtils.getValue(document, "/Document/PBS/PF06/PF06Z/PF06ZS01"));
        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPbsDAO().save(entity);
    }

    /**
     * 征信查询个人征信结果-信贷交易信息概要信息-信贷交易提示信息段-信贷交易提示信息
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPc02Ah(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCO/PC02/PC02A/PC02AH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPc02ah entity = new CrPerPc02ah();
                entity.setBatchId(batchId);
                entity.setPc02ad01(XmlUtils.getValue(node, "PC02AD01"));
                entity.setPc02ad02(XmlUtils.getValue(node, "PC02AD02"));
                entity.setPc02ar01(XmlUtils.getValue(node, "PC02AR01"));
                entity.setPc02as03(XmlUtils.getValue(node, "PC02AS03"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPc02ahDAO().save(entity);
            }
        }
    }

    /**
     * 征信查询个人征信结果-信贷交易信息概要信息-被追偿汇总信息段-被追偿汇总信息
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPc02Bh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCO/PC02/PC02B/PC02BH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPc02bh entity = new CrPerPc02bh();
                entity.setBatchId(batchId);
                entity.setPc02bd01(XmlUtils.getValue(node, "PC02BD01"));
                entity.setPc02bj02(XmlUtils.getValue(node, "PC02BJ02"));
                entity.setPc02bs03(XmlUtils.getValue(node, "PC02BS03"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPc02bhDAO().save(entity);
            }
        }
    }

    /**
     * 征信查询个人征信结果-信贷交易信息概要信息-逾期（透支）汇总信息段-逾期（透支）汇总信息
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPc02Dh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCO/PC02/PC02D/PC02DH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPc02dh entity = new CrPerPc02dh();
                entity.setBatchId(batchId);
                entity.setPc02dd01(XmlUtils.getValue(node, "PC02DD01"));
                entity.setPc02ds02(XmlUtils.getValue(node, "PC02DS02"));
                entity.setPc02ds03(XmlUtils.getValue(node, "PC02DS03"));
                entity.setPc02dj01(XmlUtils.getValue(node, "PC02DJ01"));
                entity.setPc02ds04(XmlUtils.getValue(node, "PC02DS04"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPc02dhDAO().save(entity);
            }
        }
    }

    /**
     * 征信查询个人征信结果-信贷交易信息概要信息-相关还款责任汇总信息段-相关还款责任汇总信息
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPc02Kh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCO/PC02/PC02K/PC02KH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPc02kh entity = new CrPerPc02kh();
                entity.setBatchId(batchId);
                entity.setPc02kd01(XmlUtils.getValue(node, "PC02KD01"));
                entity.setPc02kd02(XmlUtils.getValue(node, "PC02KD02"));
                entity.setPc02ks02(XmlUtils.getValue(node, "PC02KS02"));
                entity.setPc02kj01(XmlUtils.getValue(node, "PC02KJ01"));
                entity.setPc02kj02(XmlUtils.getValue(node, "PC02KJ02"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPc02khDAO().save(entity);
            }
        }
    }

    /**
     * 征信查询个人征信结果-非信贷交易信息概要-后付费业务欠费信息汇总信息单元段
     * -后付费业务欠费信息汇总信息
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPc030H(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PNO/PC03/PC030H");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPc030h entity = new CrPerPc030h();
                entity.setBatchId(batchId);
                entity.setPc030d01(XmlUtils.getValue(node, "PC030D01"));
                entity.setPc030s02(XmlUtils.getValue(node, "PC030S02"));
                entity.setPc030j01(XmlUtils.getValue(node, "PC030J01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPc030hDAO().save(entity);
            }
        }
    }


    public static void parseCrPerPc040H(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PPO/PC04/PC040H");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPc040h entity = new CrPerPc040h();
                entity.setBatchId(batchId);
                entity.setPc040d01(XmlUtils.getValue(node, "PC040D01"));
                entity.setPc040s02(XmlUtils.getValue(node, "PC040S02"));
                entity.setPc040j01(XmlUtils.getValue(node, "PC040J01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPc040hDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPca(Document document, String batchId) throws Exception {
    	List<Node> nodeList = document.selectNodes("/Document/PCA/PD02");
    	if(CollectionUtils.isEmpty(nodeList) == false){
    		for(Node node:nodeList) {
    			CrPerPca entity = new CrPerPca();
    			Node pd02ANode = node.selectSingleNode("PD02A");
    			Node pd02ZNode = node.selectSingleNode("PD02Z");
    		//	entity.setId(batchId);
    			entity.setBatchId(batchId);
    			entity.setPd02ai01(XmlUtils.getValue(pd02ANode, "PD02AI01"));
    			entity.setPd02ad01(XmlUtils.getValue(pd02ANode, "PD02AD01"));
    			entity.setPd02ai02(XmlUtils.getValue(pd02ANode, "PD02AI02"));
    			entity.setPd02ai03(XmlUtils.getValue(pd02ANode, "PD02AI03"));
    			entity.setPd02ad02(XmlUtils.getValue(pd02ANode, "PD02AD02"));
    			entity.setPd02aj01(XmlUtils.getValue(pd02ANode, "PD02AJ01"));
    			entity.setPd02ad03(XmlUtils.getValue(pd02ANode, "PD02AD03"));
    			entity.setPd02ar01(XmlUtils.getValue(pd02ANode, "PD02AR01"));
    			entity.setPd02ar02(XmlUtils.getValue(pd02ANode, "PD02AR02"));
    			entity.setPd02ad04(XmlUtils.getValue(pd02ANode, "PD02AD04"));
    			entity.setPd02aj04(XmlUtils.getValue(pd02ANode, "PD02AJ04"));
    			entity.setPd02aj03(XmlUtils.getValue(pd02ANode, "PD02AJ03"));
    			entity.setPd02ai04(XmlUtils.getValue(pd02ANode, "PD02AI04"));
    			entity.setPd02zs01(XmlUtils.getValue(pd02ZNode, "PD02ZS01"));
    			LOGGER.info("entity = {}", JsonUtils.toJson(entity));
    			BaseDAOUtils.getCrPerPcaDAO().save(entity);
    		}
    	}
    }

    public static void parseCrPerPce(Document document, String batchId) throws Exception {
        CrPerPce entity = new CrPerPce();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPf03aq01(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AQ01"));
        entity.setPf03aq02(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AQ02"));
        entity.setPf03ar01(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AR01"));
        entity.setPf03ad01(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AD01"));
        entity.setPf03aq03(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AQ03"));
        entity.setPf03ar02(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AR02"));
        entity.setPf03aq04(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AQ04"));
        entity.setPf03aj01(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AJ01"));
        entity.setPf03aq05(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AQ05"));
        entity.setPf03aj02(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03A/PF03AJ02"));
        entity.setPf03zs01(XmlUtils.getValue(document, "/Document/PCE/PF03/PF03Z/PF03ZS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPceDAO().save(entity);
    }

    public static void parseCrPerPcj(Document document, String batchId) throws Exception {
        CrPerPcj entity = new CrPerPcj();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPf02aq01(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AQ01"));
        entity.setPf02aq02(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AQ02"));
        entity.setPf02ar01(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AR01"));
        entity.setPf02ad01(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AD01"));
        entity.setPf02aq03(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AQ03"));
        entity.setPf02ar02(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AR02"));
        entity.setPf02aq04(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AQ04"));
        entity.setPf02aj01(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02A/PF02AJ01"));
        entity.setPf02zs01(XmlUtils.getValue(document, "/Document/PCJ/PF02/PF02Z/PF02ZS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPcjDAO().save(entity);
    }

    public static void parseCrPerPco(Document document, String batchId) throws Exception {
        CrPerPco entity = new CrPerPco();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPc02as02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02A/PC02AS02"));
        entity.setPc02as01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02A/PC02AS01"));
        entity.setPc02bs01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02B/PC02BS01"));
        entity.setPc02bj01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02B/PC02BJ01"));
        entity.setPc02bs02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02B/PC02BS02"));
        entity.setPc02cs01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02C/PC02CS01"));
        entity.setPc02cj01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02C/PC02CJ01"));
        entity.setPc02ds01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02D/PC02DS01"));
        entity.setPc02es01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02E/PC02ES01"));
        entity.setPc02es02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02E/PC02ES02"));
        entity.setPc02ej01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02E/PC02EJ01"));
        entity.setPc02ej02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02E/PC02EJ02"));
        entity.setPc02ej03(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02E/PC02EJ03"));
        entity.setPc02fs01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02F/PC02FS01"));
        entity.setPc02fs02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02F/PC02FS02"));
        entity.setPc02fj01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02F/PC02FJ01"));
        entity.setPc02fj02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02F/PC02FJ02"));
        entity.setPc02fj03(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02F/PC02FJ03"));
        entity.setPc02gs01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02G/PC02GS01"));
        entity.setPc02gs02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02G/PC02GS02"));
        entity.setPc02gj01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02G/PC02GJ01"));
        entity.setPc02gj02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02G/PC02GJ02"));
        entity.setPc02gj03(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02G/PC02GJ03"));
        entity.setPc02hs01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02H/PC02HS01"));
        entity.setPc02hs02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02H/PC02HS02"));
        entity.setPc02hj01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02H/PC02HJ01"));
        entity.setPc02hj02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02H/PC02HJ02"));
        entity.setPc02hj03(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02H/PC02HJ03"));
        entity.setPc02hj04(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02H/PC02HJ04"));
        entity.setPc02hj05(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02H/PC02HJ05"));
        entity.setPc02is01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02I/PC02IS01"));
        entity.setPc02is02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02I/PC02IS02"));
        entity.setPc02ij01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02I/PC02IJ01"));
        entity.setPc02ij02(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02I/PC02IJ02"));
        entity.setPc02ij03(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02I/PC02IJ03"));
        entity.setPc02ij04(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02I/PC02IJ04"));
        entity.setPc02ij05(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02I/PC02IJ05"));
        entity.setPc02ks01(XmlUtils.getValue(document, "/Document/PCO/PC02/PC02K/PC02KS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPcoDAO().save(entity);


    }

    public static void parseCrPerPcr(Document document, String batchId) throws Exception {
        CrPerPcr entity = new CrPerPcr();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPd03ad08(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD08"));
        entity.setPd03ad01(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD01"));
        entity.setPd03aq01(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AQ01"));
        entity.setPd03ad02(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD02"));
        entity.setPd03ar01(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AR01"));
        entity.setPd03ar02(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AR02"));
        entity.setPd03ad03(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD03"));
        entity.setPd03aq02(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AQ02"));
        entity.setPd03aj01(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AJ01"));
        entity.setPd03ad04(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD04"));
        entity.setPd03aj02(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AJ02"));
        entity.setPd03ad05(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD05"));
        entity.setPd03ad06(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD06"));
        entity.setPd03ad07(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AD07"));
        entity.setPd03as01(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AS01"));
        entity.setPd03ar03(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03A/PD03AR03"));
        entity.setPd03zs01(XmlUtils.getValue(document, "/Document/PCR/PD03/PD03Z/PD03ZS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPcrDAO().save(entity);
    }

    public static void parseCrPerPhf(Document document, String batchId) throws Exception {
        CrPerPhf entity = new CrPerPhf();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPf05aq01(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AQ01"));
        entity.setPf05ar01(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AR01"));
        entity.setPf05ad01(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AD01"));
        entity.setPf05ar02(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AR02"));
        entity.setPf05ar03(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AR03"));
        entity.setPf05aq02(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AQ02"));
        entity.setPf05aq03(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AQ03"));
        entity.setPf05aq01(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AJ01"));
        entity.setPf05aq04(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AQ04"));
        entity.setPf05ar04(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05A/PF05AR04"));
        entity.setPf05zs01(XmlUtils.getValue(document, "/Document/PHF/PF05/PF05Z/PF05ZS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPhfDAO().save(entity);

    }

    public static void parseCrPerPim(Document document, String batchId) throws Exception {
        CrPerPim entity = new CrPerPim();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPb01ad01(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AD01"));
        entity.setPb01ar01(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AR01"));
        entity.setPb01ad02(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AD02"));
        entity.setPb01ad03(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AD03"));
        entity.setPb01ad04(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AD04"));
        entity.setPb01aq01(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AQ01"));
        entity.setPb01aq02(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AQ02"));
        entity.setPb01ad05(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AD05"));
        entity.setPb01aq03(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01A/PB01AQ03"));
        entity.setPb01bs01(XmlUtils.getValue(document, "/Document/PIM/PB01/PB01B/PB01BS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPimDAO().save(entity);
    }

    public static void parseCrPerPmm(Document document, String batchId) throws Exception {
        CrPerPmm entity = new CrPerPmm();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPb020d01(XmlUtils.getValue(document, "/Document/PMM/PB02/PB020D01"));
        entity.setPb020q01(XmlUtils.getValue(document, "/Document/PMM/PB02/PB020Q01"));
        entity.setPb020d02(XmlUtils.getValue(document, "/Document/PMM/PB02/PB020D02"));
        entity.setPb020i01(XmlUtils.getValue(document, "/Document/PMM/PB02/PB020I01"));
        entity.setPb020q02(XmlUtils.getValue(document, "/Document/PMM/PB02/PB020Q02"));
        entity.setPb020q03(XmlUtils.getValue(document, "/Document/PMM/PB02/PB020Q03"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPmmDAO().save(entity);
    }

    public static void parseCrPerPnd(Document document, String batchId) throws Exception {
        CrPerPnd entity = new CrPerPnd();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPe01ad01(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AD01"));
        entity.setPe01aq01(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AQ01"));
        entity.setPe01ad02(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AD02"));
        entity.setPe01ar01(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AR01"));
        entity.setPe01ad03(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AD03"));
        entity.setPe01aj01(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AJ01"));
        entity.setPe01ar02(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AR02"));
        entity.setPe01aq02(XmlUtils.getValue(document, "/Document/PND/PE01/PE01A/PE01AQ02"));
        entity.setPe01zs01(XmlUtils.getValue(document, "/Document/PND/PE01/PE01Z/PE01ZS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPndDAO().save(entity);
    }

    public static void parseCrPerPno(Document document, String batchId) throws Exception {
        CrPerPno entity = new CrPerPno();
        entity.setBatchId(batchId);
        entity.setPc030s01(XmlUtils.getValue(document, "/Document/PNO/PC03/PC030S01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPnoDAO().save(entity);
    }

    public static void parseCrPerPom(Document document, String batchId) throws Exception {
        CrPerPom entity = new CrPerPom();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPb040d01(XmlUtils.getValue(document, "/Document/POM/PB04/PB040D01"));
        entity.setPb040q01(XmlUtils.getValue(document, "/Document/POM/PB04/PB040Q01"));
        entity.setPb040d02(XmlUtils.getValue(document, "/Document/POM/PB04/PB040D02"));
        entity.setPb040d03(XmlUtils.getValue(document, "/Document/POM/PB04/PB040D03"));
        entity.setPb040q02(XmlUtils.getValue(document, "/Document/POM/PB04/PB040Q02"));
        entity.setPb040q03(XmlUtils.getValue(document, "/Document/POM/PB04/PB040Q03"));
        entity.setPb040d04(XmlUtils.getValue(document, "/Document/POM/PB04/PB040D04"));
        entity.setPb040d05(XmlUtils.getValue(document, "/Document/POM/PB04/PB040D05"));
        entity.setPb040d06(XmlUtils.getValue(document, "/Document/POM/PB04/PB040D06"));
        entity.setPb040r01(XmlUtils.getValue(document, "/Document/POM/PB04/PB040R01"));
        entity.setPb040r02(XmlUtils.getValue(document, "/Document/POM/PB04/PB040R02"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPomDAO().save(entity);
    }

    public static void parseCrPerPoq(Document document, String batchId) throws Exception {
        CrPerPoq entity = new CrPerPoq();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPh010r01(XmlUtils.getValue(document, "/Document/POQ/PH01/PH010R01"));
        entity.setPh010d01(XmlUtils.getValue(document, "/Document/POQ/PH01/PH010D01"));
        entity.setPh010q02(XmlUtils.getValue(document, "/Document/POQ/PH01/PH010Q02"));
        entity.setPh010q03(XmlUtils.getValue(document, "/Document/POQ/PH01/PH010Q03"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPoqDAO().save(entity);
    }

    public static void parseCrPerPos(Document document, String batchId) throws Exception {
        CrPerPos entity = new CrPerPos();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPg010d01(XmlUtils.getValue(document, "/Document/POS/PG01/PG010D01"));
        entity.setPg010d02(XmlUtils.getValue(document, "/Document/POS/PG01/PG010D02"));
        entity.setPg010s01(XmlUtils.getValue(document, "/Document/POS/PG01/PG010S01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPosDAO().save(entity);
    }

    public static void parseCrPerPot(Document document, String batchId) throws Exception {
        CrPerPot entity = new CrPerPot();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPf01aq01(XmlUtils.getValue(document, "/Document/POT/PF01/PF01A/PF01AQ01"));
        entity.setPf01aj01(XmlUtils.getValue(document, "/Document/POT/PF01/PF01A/PF01AJ01"));
        entity.setPf01ar01(XmlUtils.getValue(document, "/Document/POT/PF01/PF01A/PF01AR01"));
        entity.setPf01zs01(XmlUtils.getValue(document, "/Document/POT/PF01/PF01Z/PF01ZS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPotDAO().save(entity);
    }

    public static void parseCrPerPpo(Document document, String batchId) throws Exception {
        CrPerPpo entity = new CrPerPpo();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPc040s01(XmlUtils.getValue(document, "/Document/PPO/PC04/PC040S01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPpoDAO().save(entity);
    }

    public static void parseCrPerPpq(Document document, String batchId) throws Exception {
        CrPerPpq entity = new CrPerPpq();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPf07aq01(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07A/PF07AQ01"));
        entity.setPf07aq02(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07A/PF07AQ02"));
        entity.setPf07ad01(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07A/PF07AD01"));
        entity.setPf07ad02(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07A/PF07AD02"));
        entity.setPf07ar01(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07A/PF07AR01"));
        entity.setPf07ar02(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07A/PF07AR02"));
        entity.setPf07ar03(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07A/PF07AR03"));
        entity.setPf07zs01(XmlUtils.getValue(document, "/Document/PPQ/PF07/PF07Z/PF07ZS01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPpqDAO().save(entity);
    }

    public static void parseCrPerPqo(Document document, String batchId) throws Exception {
        CrPerPqo entity = new CrPerPqo();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPc05ar01(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05A/PC05AR01"));
        entity.setPc05ad01(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05A/PC05AD01"));
        entity.setPc05ai01(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05A/PC05AI01"));
        entity.setPc05aq01(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05A/PC05AQ01"));
        entity.setPc05bs01(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS01"));
        entity.setPc05bs02(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS02"));
        entity.setPc05bs03(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS03"));
        entity.setPc05bs04(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS04"));
        entity.setPc05bs05(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS05"));
        entity.setPc05bs06(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS06"));
        entity.setPc05bs07(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS07"));
        entity.setPc05bs08(XmlUtils.getValue(document, "/Document/PQO/PC05/PC05B/PC05BS08"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPqoDAO().save(entity);
    }

    public static void parseCrPerPrh(Document document, String batchId) throws Exception {
        CrPerPrh entity = new CrPerPrh();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPa01ai01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01A/PA01AI01"));
        entity.setPa01ar01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01A/PA01AR01"));
        entity.setPa01bq01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01B/PA01BQ01"));
        entity.setPa01bd01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01B/PA01BD01"));
        entity.setPa01bi01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01B/PA01BI01"));
        entity.setPa01bi02(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01B/PA01BI02"));
        entity.setPa01bd02(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01B/PA01BD02"));
        entity.setPa01cs01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01C/PA01CS01"));
        entity.setPa01dq01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01D/PA01DQ01"));
        entity.setPa01dq02(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01D/PA01DQ02"));
        entity.setPa01dr01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01D/PA01DR01"));
        entity.setPa01dr02(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01D/PA01DR02"));
        entity.setPa01es01(XmlUtils.getValue(document, "/Document/PRH/PA01/PA01E/PA01ES01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPrhDAO().save(entity);
    }

    public static void parseCrPerPrm(Document document, String batchId) throws Exception {
        CrPerPrm entity = new CrPerPrm();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPb030d01(XmlUtils.getValue(document, "/Document/PRM/PB03/PB030D01"));
        entity.setPb030q01(XmlUtils.getValue(document, "/Document/PRM/PB03/PB030Q01"));
        entity.setPb030q02(XmlUtils.getValue(document, "/Document/PRM/PB03/PB030Q02"));
        entity.setPb030r01(XmlUtils.getValue(document, "/Document/PRM/PB03/PB030R01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPrmDAO().save(entity);
    }

    public static void parseCrPerPsm(Document document, String batchId) throws Exception {
        CrPerPsm entity = new CrPerPsm();
        entity.setId(batchId);
        entity.setBatchId(batchId);
        entity.setPc010q01(XmlUtils.getValue(document, "/Document/PSM/PC01/PC010Q01"));
        entity.setPc010q02(XmlUtils.getValue(document, "/Document/PSM/PC01/PC010Q02"));
        entity.setPc010s01(XmlUtils.getValue(document, "/Document/PSM/PC01/PC010S01"));
        entity.setPc010d01(XmlUtils.getValue(document, "/Document/PSM/PC01/PC010D01"));

        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCrPerPsmDAO().save(entity);
    }

    public static void parseCrPerPda(Document document, String batchId) throws Exception {
    	 List<Node> nodeList = document.selectNodes("/Document/PDA/PD01");
    	// List<String> idList=new  ArrayList<String>();
    	 if (CollectionUtils.isEmpty(nodeList) == false) {
    		 for(Node node : nodeList) {
    			 CrPerPda entity = new CrPerPda();
    		     Node pd01A_node=node.selectSingleNode("PD01A");
    		     Node pd01B_node=node.selectSingleNode("PD01B");
    		     Node pd01C_node=node.selectSingleNode("PD01C");
    		     Node pd01D_node=node.selectSingleNode("PD01D");
    		     Node pd01E_node=node.selectSingleNode("PD01E");
    		     Node pd01F_node=node.selectSingleNode("PD01F");
    		     Node pd01G_node=node.selectSingleNode("PD01G");
    		     Node pd01H_node=node.selectSingleNode("PD01H");
    		     Node pd01Z_node=node.selectSingleNode("PD01Z");
    			 entity.setBatchId(batchId);
    			 entity.setPd01ai01(XmlUtils.getValue(pd01A_node, "PD01AI01"));
    			 entity.setPd01ad01(XmlUtils.getValue(pd01A_node, "PD01AD01"));
    			 entity.setPd01ad02(XmlUtils.getValue(pd01A_node, "PD01AD02"));
                 entity.setPd01ai02(XmlUtils.getValue(pd01A_node, "PD01AI02"));
                 entity.setPd01ai03(XmlUtils.getValue(pd01A_node, "PD01AI03"));
                 entity.setPd01ai04(XmlUtils.getValue(pd01A_node, "PD01AI04"));
                 entity.setPd01ad03(XmlUtils.getValue(pd01A_node, "PD01AD03"));
                 entity.setPd01ar01(XmlUtils.getValue(pd01A_node, "PD01AR01"));
                 entity.setPd01ad04(XmlUtils.getValue(pd01A_node, "PD01AD04"));
                 entity.setPd01aj01(XmlUtils.getValue(pd01A_node, "PD01AJ01"));
                 entity.setPd01aj02(XmlUtils.getValue(pd01A_node, "PD01AJ02"));
                 entity.setPd01aj03(XmlUtils.getValue(pd01A_node, "PD01AJ03"));
                 entity.setPd01ar02(XmlUtils.getValue(pd01A_node, "PD01AR02"));
                 entity.setPd01ad05(XmlUtils.getValue(pd01A_node, "PD01AD05"));
                 entity.setPd01ad06(XmlUtils.getValue(pd01A_node, "PD01AD06"));
                 entity.setPd01as01(XmlUtils.getValue(pd01A_node, "PD01AS01"));
                 entity.setPd01ad07(XmlUtils.getValue(pd01A_node, "PD01AD07"));
                 entity.setPd01ad08(XmlUtils.getValue(pd01A_node, "PD01AD08"));
                 entity.setPd01ad09(XmlUtils.getValue(pd01A_node, "PD01AD09"));
                 entity.setPd01ad10(XmlUtils.getValue(pd01A_node, "PD01AD10"));
                 //当账户活动状态为"关闭"时,余额 到期日期为空
                 entity.setPd01bd01(XmlUtils.getValue(pd01B_node, "PD01BD01"));
                 entity.setPd01br01(XmlUtils.getValue(pd01B_node, "PD01BR01"));
                 entity.setPd01br04(XmlUtils.getValue(pd01B_node, "PD01BR04"));
                 if("2".equals(XmlUtils.getValue(pd01B_node, "PD01BD01"))) {
                	 entity.setPd01bj01(null);
                	 entity.setPd01br02(null);
                 }else {
                	 entity.setPd01bj01(XmlUtils.getValue(pd01B_node, "PD01BJ01"));
                	 entity.setPd01br02(XmlUtils.getValue(pd01B_node, "PD01BR02"));
                 }
                 entity.setPd01bj02(XmlUtils.getValue(pd01B_node, "PD01BJ02"));
                 entity.setPd01bd03(XmlUtils.getValue(pd01B_node, "PD01BD03"));
                 entity.setPd01bd04(XmlUtils.getValue(pd01B_node, "PD01BD04"));
                 entity.setPd01br03(XmlUtils.getValue(pd01B_node, "PD01BR03"));
                 entity.setPd01cr01(XmlUtils.getValue(pd01C_node, "PD01CR01"));
                 entity.setPd01cd01(XmlUtils.getValue(pd01C_node, "PD01CD01"));
                 entity.setPd01cj01(XmlUtils.getValue(pd01C_node, "PD01CJ01"));
                 entity.setPd01cj02(XmlUtils.getValue(pd01C_node, "PD01CJ02"));
                 entity.setPd01cj03(XmlUtils.getValue(pd01C_node, "PD01CJ03"));
                 entity.setPd01cd02(XmlUtils.getValue(pd01C_node, "PD01CD02"));
                 entity.setPd01cs01(XmlUtils.getValue(pd01C_node, "PD01CS01"));
                 entity.setPd01cr02(XmlUtils.getValue(pd01C_node, "PD01CR02"));
                 entity.setPd01cj04(XmlUtils.getValue(pd01C_node, "PD01CJ04"));
                 entity.setPd01cj05(XmlUtils.getValue(pd01C_node, "PD01CJ05"));
                 entity.setPd01cr03(XmlUtils.getValue(pd01C_node, "PD01CR03"));
                 entity.setPd01cs02(XmlUtils.getValue(pd01C_node, "PD01CS02"));
                 entity.setPd01cj06(XmlUtils.getValue(pd01C_node, "PD01CJ06"));
                 entity.setPd01cj07(XmlUtils.getValue(pd01C_node, "PD01CJ07"));
                 entity.setPd01cj08(XmlUtils.getValue(pd01C_node, "PD01CJ08"));
                 entity.setPd01cj09(XmlUtils.getValue(pd01C_node, "PD01CJ09"));
                 entity.setPd01cj10(XmlUtils.getValue(pd01C_node, "PD01CJ10"));
                 entity.setPd01cj11(XmlUtils.getValue(pd01C_node, "PD01CJ11"));
                 entity.setPd01cj12(XmlUtils.getValue(pd01C_node, "PD01CJ12"));
                 entity.setPd01cj13(XmlUtils.getValue(pd01C_node, "PD01CJ13"));
                 entity.setPd01cj14(XmlUtils.getValue(pd01C_node, "PD01CJ14"));
                 entity.setPd01cj15(XmlUtils.getValue(pd01C_node, "PD01CJ15"));
                 entity.setPd01cr04(XmlUtils.getValue(pd01C_node, "PD01CR04"));
                 entity.setPd01dr01(XmlUtils.getValue(pd01D_node, "PD01DR01"));
                 entity.setPd01dr02(XmlUtils.getValue(pd01D_node, "PD01DR02"));
                 entity.setPd01er01(XmlUtils.getValue(pd01E_node, "PD01ER01"));
                 entity.setPd01er02(XmlUtils.getValue(pd01E_node, "PD01ER02"));
                 entity.setPd01es01(XmlUtils.getValue(pd01E_node, "PD01ES01"));
                 entity.setPd01fs01(XmlUtils.getValue(pd01F_node, "PD01FS01"));
                 entity.setPd01gs01(XmlUtils.getValue(pd01G_node, "PD01GS01"));
                 entity.setPd01hs01(XmlUtils.getValue(pd01H_node, "PD01HS01"));
                 entity.setPd01zs01(XmlUtils.getValue(pd01Z_node, "PD01ZS01"));
    			 BaseDAOUtils.getCrPerPdaDAO().save(entity);
    			 LOGGER.info("entity = {}", JsonUtils.toJson(entity));
             //    idList.add(entity.getId());
    			 if(node.selectSingleNode("PD01Z")!=null) {
    				 parseCrPerPd01Zh(pd01Z_node, batchId,entity.getId());
    			 }
    			 if(node.selectSingleNode("PD01H")!=null) {
    				 parseCrPerPd01Hh(pd01H_node, batchId,entity.getId());
    			 }
    			 if(node.selectSingleNode("PD01F")!=null) {
    				 parseCrPerPd01Fh(pd01F_node, batchId,entity.getId());
    			 }
    			 if(node.selectSingleNode("PD01G")!=null) {
    				  parseCrPerPd01Gh(pd01G_node, batchId,entity.getId());
    			 }
               
    			 if(node.selectSingleNode("PD01D")!=null) {
    				 parseCrPerPd01Dh(pd01D_node, batchId,entity.getId());
    			 }
    			 
    			 if(node.selectSingleNode("PD01E")!=null) {
    				 parseCrPerPd01Eh(pd01E_node, batchId,entity.getId());
    			 }
    		 }
    
         }
    	 
    }
    
    
    public static void parseCrPerPd01Zh(Node node, String batchId,String parentId) throws Exception {
        List<Node> nodeList = node.selectNodes("PD01ZH");
        if (CollectionUtils.isEmpty(nodeList) == false){
        	for(Node pd01zhNode : nodeList) {
        	CrPerPd01zh entity = new CrPerPd01zh();
    		entity.setParentId(parentId);
    		entity.setBatchId(batchId);
    		entity.setPd01zd01(XmlUtils.getValue(pd01zhNode, "PD01ZD01"));
    		entity.setPd01zq01(XmlUtils.getValue(pd01zhNode, "PD01ZQ01"));
    		entity.setPd01zr01(XmlUtils.getValue(pd01zhNode, "PD01ZR01"));
    		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
    		BaseDAOUtils.getCrPerPd01zhDAO().save(entity);
        	}
        }
    }
    
    
    public static void parseCrPerPd01Hh(Node node, String batchId,String parentId) throws Exception {
        List<Node> nodeList = node.selectNodes("PD01HH");
        if(CollectionUtils.isEmpty(nodeList) == false) {
        	for(Node pd01hhNode:nodeList) {
        		CrPerPd01hh entity = new CrPerPd01hh();
        		entity.setBatchId(batchId);
        		entity.setParentId(parentId);
        		entity.setPd01hj01(XmlUtils.getValue(pd01hhNode, "PD01HJ01"));
        		entity.setPd01hr01(XmlUtils.getValue(pd01hhNode, "PD01HR01"));
        		entity.setPd01hr02(XmlUtils.getValue(pd01hhNode, "PD01HR02"));
        		entity.setPd01hj02(XmlUtils.getValue(pd01hhNode, "PD01HJ02"));
        		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        		BaseDAOUtils.getCrPerPd01hhDAO().save(entity);
        	}
        }
    }
    
    

    public static void parseCrPerPd01Gh(Node node, String batchId,String parentId) throws Exception {
        List<Node> nodeList = node.selectNodes("PD01GH");
        if(CollectionUtils.isEmpty(nodeList) == false) {
        	 for(Node pd01ghNode:nodeList) {
        		 CrPerPd01gh entity = new CrPerPd01gh();
        		 entity.setBatchId(batchId);
        		 entity.setParentId(parentId);
        		 entity.setPd01gr01(XmlUtils.getValue(pd01ghNode, "PD01GR01"));
        		 entity.setPd01gd01(XmlUtils.getValue(pd01ghNode, "PD01GD01"));
        		 LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        		 BaseDAOUtils.getCrPerPd01ghDAO().save(entity);
             }
        }
    }
    

    public static void parseCrPerPd01Fh(Node node, String batchId,String parentId) throws Exception {
        List<Node> nodeList = node.selectNodes("PD01FH");
        if(CollectionUtils.isEmpty(nodeList) == false ) {
        	for(Node pd01fhNode:nodeList) {
        		CrPerPd01fh entity=new CrPerPd01fh();
        		entity.setBatchId(batchId);
        		entity.setParentId(parentId);
        		entity.setPd01fd01(XmlUtils.getValue(pd01fhNode, "PD01FD01"));
        		entity.setPd01fr01(XmlUtils.getValue(pd01fhNode, "PD01FR01"));
        		entity.setPd01fs02(XmlUtils.getValue(pd01fhNode, "PD01FS02"));
        		entity.setPd01fj01(XmlUtils.getValue(pd01fhNode, "PD01FJ01"));
        		entity.setPd01fq01(XmlUtils.getValue(pd01fhNode, "PD01FQ01"));
        		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        		BaseDAOUtils.getCrPerPd01fhDAO().save(entity);
        	}
        }
    }
    
    public static void parseCrPerPd01Dh(Node node,String batchId,String parentId) throws Exception {
    	List<Node> nodeList=node.selectNodes("PD01DH");
     //   List<Node> nodeList = node.selectNodes("/Document/PDA/PD01/PD01D/PD01DH");
        if (CollectionUtils.isEmpty(nodeList)==false) {
        		 for (Node pd01ghNode : nodeList) {
        			 CrPerPd01dh entity = new CrPerPd01dh();
        			 entity.setBatchId(batchId);
        			 entity.setParentId(parentId);
        			 entity.setPd01dr03(XmlUtils.getValue(pd01ghNode, "PD01DR03"));
        			 entity.setPd01dd01(XmlUtils.getValue(pd01ghNode, "PD01DD01"));
        			 LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        			 BaseDAOUtils.getCrPerPd01dhDAO().save(entity);
        		 }
        }
    }
    
    
    public static void parseCrPerPd01Eh(Node node, String batchId,String parentId) throws Exception {
        List<Node> nodeList = node.selectNodes("PD01EH");
        if(CollectionUtils.isEmpty(nodeList) == false ) {
        	for(Node pd01ehNode:nodeList) {
        		CrPerPd01eh entity = new CrPerPd01eh();
        		entity.setBatchId(batchId);
        		entity.setParentId(parentId);
        		entity.setPd01er03(XmlUtils.getValue(pd01ehNode, "PD01ER03"));
        		entity.setPd01ed01(XmlUtils.getValue(pd01ehNode, "PD01ED01"));
        		entity.setPd01ej01(XmlUtils.getValue(pd01ehNode, "PD01EJ01"));
        		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        		BaseDAOUtils.getCrPerPd01ehDAO().save(entity);
        	}
        }
    }

    /**
     * 处理征信查询个人征信结果-报告头-其他身份标识信息段-身份信息
     *
     * @param document
     * @param batchId
     * @throws Exception
     */
    public static void parseCrPerPa01Ch(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PRH/PA01/PA01C/PA01CH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPa01ch entity = new CrPerPa01ch();
                entity.setBatchId(batchId);
                entity.setPa01cd01(XmlUtils.getValue(node, "PA01CD01"));
                entity.setPa01ci01(XmlUtils.getValue(node, "PA01CI01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPa01chDAO().save(entity);
            }
        }
    }


    public static void parseCrPerPd02Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCA/PD02/PD02Z/PD02ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPd02zh entity = new CrPerPd02zh();
                entity.setBatchId(batchId);
                entity.setPd02zd01(XmlUtils.getValue(node, "PD02ZD01"));
                entity.setPd02zq01(XmlUtils.getValue(node, "PD02ZQ01"));
                entity.setPd02zr01(XmlUtils.getValue(node, "PD02ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPd02zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPd03Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCR/PD03/PD03Z/PD03ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPd03zh entity = new CrPerPd03zh();
                entity.setBatchId(batchId);
                entity.setPd03zd01(XmlUtils.getValue(node, "PD03ZD01"));
                entity.setPd03zq01(XmlUtils.getValue(node, "PD03ZQ01"));
                entity.setPd03zr01(XmlUtils.getValue(node, "PD03ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPd03zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPe01Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PND/PE01/PE01Z/PE01ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPe01zh entity = new CrPerPe01zh();
                entity.setBatchId(batchId);
                entity.setPe01zd01(XmlUtils.getValue(node, "PE01ZD01"));
                entity.setPe01zq01(XmlUtils.getValue(node, "PE01ZQ01"));
                entity.setPe01zr01(XmlUtils.getValue(node, "PE01ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPe01zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf01Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/POT/PF01/PF01Z/PF01ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf01zh entity = new CrPerPf01zh();
                entity.setBatchId(batchId);
                entity.setPf01zd01(XmlUtils.getValue(node, "PF01ZD01"));
                entity.setPf01zq01(XmlUtils.getValue(node, "PF01ZQ01"));
                entity.setPf01zr01(XmlUtils.getValue(node, "PF01ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf01zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf02Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCJ/PF02/PF02Z/PF02ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf02zh entity = new CrPerPf02zh();
                entity.setBatchId(batchId);
                entity.setPf02zd01(XmlUtils.getValue(node, "PF02ZD01"));
                entity.setPf02zq01(XmlUtils.getValue(node, "PF02ZQ01"));
                entity.setPf02zr01(XmlUtils.getValue(node, "PF02ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf02zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf03Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PCE/PF03/PF03Z/PF03ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf03zh entity = new CrPerPf03zh();
                entity.setBatchId(batchId);
                entity.setPf03zd01(XmlUtils.getValue(node, "PF03ZD01"));
                entity.setPf03zq01(XmlUtils.getValue(node, "PF03ZQ01"));
                entity.setPf03zr01(XmlUtils.getValue(node, "PF03ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf03zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf04Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PAP/PF04/PF04Z/PF04ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf04zh entity = new CrPerPf04zh();
                entity.setBatchId(batchId);
                entity.setPf04zd01(XmlUtils.getValue(node, "PF04ZD01"));
                entity.setPf04zq01(XmlUtils.getValue(node, "PF04ZQ01"));
                entity.setPf04zr01(XmlUtils.getValue(node, "PF04ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf04zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf05Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PHF/PF05/PF05Z/PF05ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf05zh entity = new CrPerPf05zh();
                entity.setBatchId(batchId);
                entity.setPf05zd01(XmlUtils.getValue(node, "PF05ZD01"));
                entity.setPf05zq01(XmlUtils.getValue(node, "PF05ZQ01"));
                entity.setPf05zr01(XmlUtils.getValue(node, "PF05ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf05zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf06Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PBS/PF06/PF06Z/PF06ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf06zh entity = new CrPerPf06zh();
                entity.setBatchId(batchId);
                entity.setPf06zd01(XmlUtils.getValue(node, "PF06ZD01"));
                entity.setPf06zq01(XmlUtils.getValue(node, "PF06ZQ01"));
                entity.setPf06zr01(XmlUtils.getValue(node, "PF06ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf06zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf07Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PPQ/PF07/PF07Z/PF07ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf07zh entity = new CrPerPf07zh();
                entity.setBatchId(batchId);
                entity.setPf07zd01(XmlUtils.getValue(node, "PF07ZD01"));
                entity.setPf07zq01(XmlUtils.getValue(node, "PF07ZQ01"));
                entity.setPf07zr01(XmlUtils.getValue(node, "PF07ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf07zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPf08Zh(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/PAH/PF08/PF08Z/PF08ZH");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPf08zh entity = new CrPerPf08zh();
                entity.setBatchId(batchId);
                entity.setPf08zd01(XmlUtils.getValue(node, "PF08ZD01"));
                entity.setPf08zq01(XmlUtils.getValue(node, "PF08ZQ01"));
                entity.setPf08zr01(XmlUtils.getValue(node, "PF08ZR01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPf08zhDAO().save(entity);
            }
        }
    }

    public static void parseCrPerPg010H(Document document, String batchId) throws Exception {
        List<Node> nodeList = document.selectNodes("/Document/POS/PG01/PG010H");
        if (CollectionUtils.isEmpty(nodeList) == false) {
            for (Node node : nodeList) {
                CrPerPg010h entity = new CrPerPg010h();
                entity.setBatchId(batchId);
                entity.setPg010d03(XmlUtils.getValue(node, "PG010D03"));
                entity.setPg010q01(XmlUtils.getValue(node, "PG010Q01"));
                entity.setPg010r01(XmlUtils.getValue(node, "PG010R01"));
                LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                BaseDAOUtils.getCrPerPg010hDAO().save(entity);
            }
        }
    }
    
    public static void parseCollateralEba(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/EBA/EB01");
            if (CollectionUtils.isEmpty(nodeList) == false) {
                for (Node node : nodeList) {
                	CollateralEba entity=new CollateralEba(); 
                    Node eb01ANode = node.selectSingleNode("EB01A");
                    Node eb01BNode = node.selectSingleNode("EB01B");
                    Node eb01CNode = node.selectSingleNode("EB01C");
                    entity.setBatchId(batchId);
                    entity.setEb01Ad06(XmlUtils.getValue(eb01ANode, "EB01AD06"));
                    entity.setEb01Ad07(XmlUtils.getValue(eb01ANode, "EB01AD07"));
                    entity.setEb01Ad03(XmlUtils.getValue(eb01ANode, "EB01AD03"));
                    entity.setEb01Ad04(XmlUtils.getValue(eb01ANode, "EB01AD04"));
                    entity.setEb01Ar01(XmlUtils.getValue(eb01ANode, "EB01AR01"));
                    entity.setEb01Ad05(XmlUtils.getValue(eb01ANode, "EB01AD05"));
                    entity.setEb01Aj01(XmlUtils.getValue(eb01ANode, "EB01AJ01"));
                    entity.setEb01Aj02(XmlUtils.getValue(eb01ANode, "EB01AJ02"));
                    entity.setEb01Ar02(XmlUtils.getValue(eb01ANode, "EB01AR02"));
                    entity.setEb01Ad01(XmlUtils.getValue(eb01ANode, "EB01AD01"));
                    entity.setEb01Ad02(XmlUtils.getValue(eb01ANode, "EB01AD02"));
                    entity.setEb01Ar03(XmlUtils.getValue(eb01ANode, "EB01AR03"));
                    entity.setEb01Bs01(XmlUtils.getValue(eb01BNode, "EB01BS01"));
                    entity.setEb01Cs01(XmlUtils.getValue(eb01CNode, "EB01CS01"));
                    LOGGER.info("entity = {}", JsonUtils.toJson(entity));
                    BaseDAOUtils.getCollateralEbaDao().save(entity);
                    if(node.selectSingleNode("EB01B")!=null) {
                    	parseCollateralEb01bh(eb01BNode,batchId,entity.getId());
                    }
                    if(node.selectSingleNode("EB01C")!=null) {
                    	CollateralEb01c eb01CEntity=new CollateralEb01c();
                    	eb01CEntity.setBatchId(batchId);
                    	eb01CEntity.setParentId(entity.getId());
                    	eb01CEntity.setEb01Ci01(XmlUtils.getValue(eb01CNode, "EB01CI01"));
                    	LOGGER.info("entity = {}", JsonUtils.toJson(eb01CEntity));
                    	BaseDAOUtils.getCollateralEb01cDao().save(eb01CEntity);
                    }
                }
            }

    }
    
    public static void parseCollateralEb01bh(Node node, String batchId,String parentId) throws Exception{   
    List<Node> nodeList = node.selectNodes("EB01BH");
    if (CollectionUtils.isEmpty(nodeList) == false){
    	for(Node eb01bhNode : nodeList) {
    	CollateralEb01bh entity = new CollateralEb01bh();
		entity.setParentId(parentId);
		entity.setBatchId(batchId);
		entity.setEb01Bd01(XmlUtils.getValue(eb01bhNode, "EB01BD01"));
		entity.setEb01Bq01(XmlUtils.getValue(eb01bhNode, "EB01BQ01"));
		entity.setEb01Bd02(XmlUtils.getValue(eb01bhNode, "EB01BD02"));
		entity.setEb01Bi01(XmlUtils.getValue(eb01bhNode, "EB01BI01"));
		entity.setEb01Bd03(XmlUtils.getValue(eb01bhNode, "EB01BD03"));
		entity.setEb01Bd04(XmlUtils.getValue(eb01bhNode, "EB01BD04"));
		entity.setEb01Bj01(XmlUtils.getValue(eb01bhNode, "EB01BJ01"));
		entity.setEb01Bd05(XmlUtils.getValue(eb01bhNode, "EB01BD05"));
		entity.setEb01Bi02(XmlUtils.getValue(eb01bhNode, "EB01BI02"));
		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
		BaseDAOUtils.getCollateralEb01bhDao().save(entity);
    	}
    }
}

    public static void parseCollateralEca(Document document, String batchId) throws Exception{
        List<Node> nodeList = document.selectNodes("/Document/ECA/EC01");
            if (CollectionUtils.isEmpty(nodeList) == false) {
                for (Node node : nodeList) {
                	CollateralEca entity=new CollateralEca(); 
                    Node ec01ANode = node.selectSingleNode("EC01A");
                    Node ec01BNode = node.selectSingleNode("EC01B");
                    Node ec01CNode = node.selectSingleNode("EC01C");
                    entity.setBatchId(batchId);
                    entity.setEc01Ad05(XmlUtils.getValue(ec01ANode, "EC01AD05"));
                    entity.setEc01Ad06(XmlUtils.getValue(ec01ANode, "EC01AD06"));
                    entity.setEc01Ad03(XmlUtils.getValue(ec01ANode, "EC01AD03"));
                    entity.setEc01Ar01(XmlUtils.getValue(ec01ANode, "EC01AR01"));
                    entity.setEc01Ad04(XmlUtils.getValue(ec01ANode, "EC01AD04"));
                    entity.setEc01Aj01(XmlUtils.getValue(ec01ANode, "EC01AJ01"));
                    entity.setEc01Ar02(XmlUtils.getValue(ec01ANode, "EC01AR02"));
                    entity.setEc01Ad01(XmlUtils.getValue(ec01ANode, "EC01AD01"));
                    entity.setEc01Ad02(XmlUtils.getValue(ec01ANode, "EC01AD02"));
                    entity.setEc01Ar03(XmlUtils.getValue(ec01ANode, "EC01AR03"));
                    entity.setEc01Bs01(XmlUtils.getValue(ec01BNode, "EC01BS01")); 
                    entity.setEc01Cs01(XmlUtils.getValue(ec01CNode, "EC01CS01"));    
                    BaseDAOUtils.getCollateralEcaDao().save(entity);
                    if(node.selectSingleNode("EC01B")!=null) {
                    	parseCollateralEc01bh(ec01BNode,batchId,entity.getId());
                    }
                    if(node.selectSingleNode("EC01C")!=null) {
                    	CollateralEc01c ec01CEntity=new CollateralEc01c();
                    	ec01CEntity.setBatchId(batchId);
                    	ec01CEntity.setParentId(entity.getId());
                    	ec01CEntity.setEc01Ci01(XmlUtils.getValue(ec01CNode, "EC01CI01"));
                    	LOGGER.info("entity = {}", JsonUtils.toJson(ec01CEntity));
                    	BaseDAOUtils.getCollateralEc01cDao().save(ec01CEntity);
                    }
                }
            }

    }
    
    public static void parseCollateralEc01bh(Node node, String batchId,String parentId) throws Exception{   
        List<Node> nodeList = node.selectNodes("EC01BH");
        if (CollectionUtils.isEmpty(nodeList) == false){
        	for(Node ec01bhNode : nodeList) {
        	CollateralEc01bh entity = new CollateralEc01bh();
    		entity.setParentId(parentId);
    		entity.setBatchId(batchId);
    		entity.setEc01Bd01(XmlUtils.getValue(ec01bhNode, "EC01BD01"));
    		entity.setEc01Bq01(XmlUtils.getValue(ec01bhNode, "EC01BQ01"));
    		entity.setEc01Bd02(XmlUtils.getValue(ec01bhNode, "EC01BD02"));
    		entity.setEc01Bi01(XmlUtils.getValue(ec01bhNode, "EC01BI01"));
    		entity.setEc01Bd03(XmlUtils.getValue(ec01bhNode, "EC01BD03"));
    		entity.setEc01Bd04(XmlUtils.getValue(ec01bhNode, "EC01BD04"));
    		entity.setEc01Bj01(XmlUtils.getValue(ec01bhNode, "EC01BJ01"));
    		entity.setEc01Bd05(XmlUtils.getValue(ec01bhNode, "EC01BD05"));
    		entity.setEc01Bi02(XmlUtils.getValue(ec01bhNode, "EC01BI02"));
    		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
    		BaseDAOUtils.getCollateralEc01bhDao().save(entity);
        	}
        }
    }
    
    public static void parseCollateralEda(Document document, String batchId) throws Exception {
    	CollateralEda entity = new CollateralEda();
        entity.setId(batchId);
        entity.setEd01Ai01(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AI01"));
        entity.setEd01Ad01(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AD01"));    
        entity.setEd01Aj01(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AJ01"));     
        entity.setEd01Ad02(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AD02"));  
        entity.setEd01Ar01(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AR01"));  
        entity.setEd01Ar02(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AR02"));  
        entity.setEd01Ad03(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AD03")); 
        entity.setEd01Ad04(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AD04")); 
        entity.setEd01Ad05(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AD05")); 
        entity.setEd01Ai02(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01AI02")); 
        entity.setEd01Bs01(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01BS01")); 
        entity.setEd01Cs01(XmlUtils.getValue(document, "/Document/EDA/ED01/ED01A/ED01CS01"));
        LOGGER.info("entity = {}", JsonUtils.toJson(entity));
        BaseDAOUtils.getCollateralEdaDao().save(entity);    
    }
    
    public static void parseCollateralEd01bh(Node node, String batchId) throws Exception{   
        List<Node> nodeList = node.selectNodes("ED01BH");
        if (CollectionUtils.isEmpty(nodeList) == false){
        	for(Node ed01bhNode : nodeList) {
        	CollateralEd01bh entity = new CollateralEd01bh();
    		entity.setBatchId(batchId);
    		entity.setEd01Bd01(XmlUtils.getValue(ed01bhNode, "ED01BD01"));
    		entity.setEd01Bd02(XmlUtils.getValue(ed01bhNode, "ED01BD02"));
    		entity.setEd01Bi01(XmlUtils.getValue(ed01bhNode, "ED01BI01"));
    		entity.setEd01Bd03(XmlUtils.getValue(ed01bhNode, "ED01BD03"));
    		entity.setEd01Bj01(XmlUtils.getValue(ed01bhNode, "ED01BJ01"));
    		entity.setEd01Bd04(XmlUtils.getValue(ed01bhNode, "ED01BD04"));
    		entity.setEd01Bd05(XmlUtils.getValue(ed01bhNode, "ED01BD05"));
    		entity.setEd01Br01(XmlUtils.getValue(ed01bhNode, "ED01BR01"));
    		entity.setEd01Bd06(XmlUtils.getValue(ed01bhNode, "ED01BD06"));
    		entity.setEd01Bq01(XmlUtils.getValue(ed01bhNode, "ED01BQ01"));  
    		entity.setEd01Bd07(XmlUtils.getValue(ed01bhNode, "ED01BD07"));  
    		entity.setEd01Bi02(XmlUtils.getValue(ed01bhNode, "ED01BI02"));  
    		entity.setEd01Bq02(XmlUtils.getValue(ed01bhNode, "ED01BQ02"));  
    		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
    		BaseDAOUtils.getCollateralEd01bhDao().save(entity);
        	}
        }
    }
    
    public static void parseCollateralEd01ch(Node node, String batchId) throws Exception{
        List<Node> nodeList = node.selectNodes("ED01CH");
        if (CollectionUtils.isEmpty(nodeList) == false){
        	for(Node ed01chNode : nodeList) {
            CollateralEd01ch entity = new CollateralEd01ch();
    		entity.setBatchId(batchId);
    		entity.setEd01Cd01(XmlUtils.getValue(ed01chNode, "ED01CD01"));
    		entity.setEd01Cj01(XmlUtils.getValue(ed01chNode, "ED01CJ01"));
    		entity.setEd01Cd02(XmlUtils.getValue(ed01chNode, "ED01CD02"));
    		entity.setEd01Cd03(XmlUtils.getValue(ed01chNode, "ED01CD03"));
    		entity.setEd01Cq01(XmlUtils.getValue(ed01chNode, "ED01CQ01"));
    		entity.setEd01Cd04(XmlUtils.getValue(ed01chNode, "ED01CD04"));
    		entity.setEd01Ci01(XmlUtils.getValue(ed01chNode, "ED01CI01"));
    		LOGGER.info("entity = {}", JsonUtils.toJson(entity));
    		BaseDAOUtils.getCollateralEd01chDao().save(entity);
        	}
        }
    }
    
}
