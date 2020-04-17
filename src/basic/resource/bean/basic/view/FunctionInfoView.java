/* ================================================================== *
 * The Huateng Software License
 *
 *  Copyright (c) 2004-2005 Huateng Software System.  All rights
 *  reserved.
 *  ==================================================================
 */
package resource.bean.basic.view;

/**
 * @author Administrator
 *
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class FunctionInfoView {
    private boolean select = false;
    private String funccode = "";
    private String funcname = "";
    private String roleid = "";
    private String rolename = "";

    /**
     * @return Returns the roleid.
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     *            The roleid to set.
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * @return Returns the func_name.
     */
    public String getFuncname() {
        return funcname;
    }

    /**
     * @param func_name
     *            The func_name to set.
     */
    public void setFuncname(String func_name) {
        this.funcname = func_name;
    }

    public String getFunccode() {
        return funccode;
    }

    public void setFunccode(String funccode) {
        this.funccode = funccode;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}
