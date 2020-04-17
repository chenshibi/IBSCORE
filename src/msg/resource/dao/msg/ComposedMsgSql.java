package resource.dao.msg;

import java.util.ArrayList;
import java.util.Map;

import com.huateng.common.DataFormat;

import resource.dao.basic.ComposedBean;

public class ComposedMsgSql {
    public static ComposedBean queryGroupInfTmp(Map<String, String> map, String type) {
        ComposedBean comBean = new ComposedBean();
        StringBuffer hql = new StringBuffer();
        ArrayList<String> condList = new ArrayList<String>();

        hql.append(" from CpgGroupInfTmp t where 1=1 and optStatus='0' ");
        if (!DataFormat.isEmpty(map.get("id"))) {
            hql.append(" and t.id= ? ");
            condList.add(map.get("id"));
        }
        if (!DataFormat.isEmpty(map.get("qgroupId"))) {
            hql.append(" and t.groupId= ? ");
            condList.add(map.get("qgroupId"));
        }
        if (type == null && "".equals(type)) {
            hql.append(" and optStatus='0' ");
        }
        hql.append(" order by t.createdDate desc");
        comBean.setParams(condList);
        comBean.setSql(hql.toString());
        return comBean;
    }

    public static ComposedBean queryGroupInf(Map<String, String> map, String type) {
        ComposedBean comBean = new ComposedBean();
        StringBuffer hql = new StringBuffer();
        ArrayList<String> condList = new ArrayList<String>();
        hql.append(" from CpgGroupInf t where 1=1 ");
        if (!DataFormat.isEmpty(map.get("id"))) {
            hql.append(" and t.id= ? ");
            condList.add(map.get("id"));
        }
        if (!DataFormat.isEmpty(map.get("qgroupId"))) {
            hql.append(" and t.groupId= ? ");
            condList.add(map.get("qgroupId"));
        }
        hql.append(" order by t.createdDate desc");
        comBean.setParams(condList);
        comBean.setSql(hql.toString());
        return comBean;
    }
}
