package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.bean.TreeNode;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.Bctl;

@SuppressWarnings("unchecked")
public class BranchTreeGetter extends BaseGetter {

    @Override
    public Result call() throws AppException {
        List<TreeNode> list = new ArrayList<TreeNode>();

        StringBuffer hql = new StringBuffer();
        hql.append(" from Bctl po where 1=1");

        String id = getCommQueryServletRequest().getParameter("_id");
        ArrayList<String> condList = new ArrayList<String>();
        if (StringUtils.isNotBlank(id)) {
            hql.append(" and po.blnUpBrcode= ? ");
            condList.add(id);
        }
        Iterator<Bctl> it = BaseDAOUtils.getHQLDAO().queryByQL(hql.toString(), condList.toArray(), null);

        while (it.hasNext()) {
            Bctl obj = it.next();
            list.add(this.convert(obj));
        }
        buildTree(list);

        ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), list, getResult());
        getResult().setContent(list);
        getResult().getPage().setTotalPage(1);
        getResult().init();
        getResult().setTotal(list.size());
        return getResult();
    }

    private void buildTree(final List<TreeNode> li) {
        Map<String, List<TreeNode>> m = new HashMap<String, List<TreeNode>>();
        for (TreeNode foo : li) {
            String key = foo.getPid();
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<TreeNode>());
            }

            m.get(key).add(foo);
        }
        for (TreeNode foo : li) {
            String key = foo.getId();
            if (m.containsKey(key)) {
                for (TreeNode bar : m.get(key)) {
                    if (!StringUtils.equalsIgnoreCase(key, bar.getId())) {
                        foo.getChildren().add(bar);
                    }
                }
            }
            foo.setHasChild(foo.getChildren().size() > 0);
        }
    }

    private TreeNode convert(final Bctl obj) {
        TreeNode node = new TreeNode();
        node.setCanSelected(true);
        node.setId(StringUtils.strip(obj.getBrcode()));
        node.setPid(StringUtils.strip(obj.getBlnUpBrcode()));
        if (StringUtils.equalsIgnoreCase(node.getId(), node.getPid())) {
            node.setPid(null);
        }
        node.setText(obj.getBrname());
        node.setHasChild(false);
        return node;
    }

}
