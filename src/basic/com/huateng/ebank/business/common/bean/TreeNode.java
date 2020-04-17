package com.huateng.ebank.business.common.bean;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    /** 必须属性 */
    private String id; // ID,唯一标识,必须
    private String text = ""; // 节点文本,必须
    private boolean hasChild; // 是否有子节点,必须
    private boolean checked;

    /** 可选属性 */
    private boolean canSelected;// 选中状态
    private String pid = ""; // 父ID
    private String iconCls = "";// 图标
    private Object attributes = new Object();// 其它属性
    private List<TreeNode> children = new ArrayList<TreeNode>();// 子节点

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid
     *            the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     *            the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the iconCls
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * @param iconCls
     *            the iconCls to set
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    /**
     * @return the canSelected
     */
    public boolean isCanSelected() {
        return canSelected;
    }

    /**
     * @param canSelected
     *            the canSelected to set
     */
    public void setCanSelected(boolean canSelected) {
        this.canSelected = canSelected;
    }

    /**
     * @return the hasChild
     */
    public boolean isHasChild() {
        return hasChild;
    }

    /**
     * @param hasChild
     *            the hasChild to set
     */
    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

    /**
     * @return the attributes
     */
    public Object getAttributes() {
        return attributes;
    }

    /**
     * @param attributes
     *            the attributes to set
     */
    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    /**
     * @return the children
     */
    public TreeNode addChild(TreeNode node) {
        children.add(node);
        node.setPid(this.id);
        this.setHasChild(true);
        return this;
    }

    public TreeNode removeChild(TreeNode node) {
        children.remove(node);
        node.setPid(null);
        this.setHasChild(!this.children.isEmpty());
        return this;
    }

    @Deprecated
    public List<TreeNode> getChildren() {
        return this.children;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
