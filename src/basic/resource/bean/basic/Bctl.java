package resource.bean.basic;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.framework.util.DataFormat;

import resource.bean.basic.base.BaseBctl;

public class Bctl extends BaseBctl {
    private static final long serialVersionUID = 1L;
    public static final String IS_FP_TRUE = "1";

    /* [CONSTRUCTOR MARKER BEGIN] */
    public Bctl() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public Bctl(java.lang.String brcode) {
        super(brcode);
    }

    /**
     * Constructor for required fields
     */
    public Bctl(java.lang.String brcode, java.lang.String brno) {

        super(brcode, brno);
    }

    /* [CONSTRUCTOR MARKER END] */
    private String blnBranchBrno;
    private String blnUpBrno;
    private String blnManageBrno;
    private String cnapsCode;

    public String getCnapsCode() {
        return cnapsCode;
    }

    public void setCnapsCode(String cnapsCode) {
        this.cnapsCode = cnapsCode;
    }

    private String billMailAddrName;
    private String brclassName;

    private boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getBrcodeTypeName() {
        String brno = DataFormat.trim(super.getBrno());
        String brname = DataFormat.trim(super.getBrname());

        if (StringUtils.isEmpty(brno) && StringUtils.isEmpty(brname)) {
            return "";
        }
        return brno + "-" + brname;
    }

    public void setBrcodeTypeName(String name) {

    }

    public String getBrclassName() {
        return brclassName;
    }

    public void setBrclassName(String brclassName) {
        this.brclassName = brclassName;
    }

    /**
     * @return Returns the billMailAddrName.
     */
    public String getBillMailAddrName() {
        return billMailAddrName;
    }

    /**
     * @param billMailAddrName
     *            The billMailAddrName to set.
     */
    public void setBillMailAddrName(String billMailAddrName) {
        this.billMailAddrName = billMailAddrName;
    }

    public String getBlnBranchBrno() {
        return blnBranchBrno;
    }

    public void setBlnBranchBrno(String blnBranchBrno) {
        this.blnBranchBrno = blnBranchBrno;
    }

    public String getBlnUpBrno() {
        return blnUpBrno;
    }

    public void setBlnUpBrno(String blnUpBrno) {
        this.blnUpBrno = blnUpBrno;
    }

    public String getBlnManageBrno() {
        return blnManageBrno;
    }

    public void setBlnManageBrno(String blnManageBrno) {
        this.blnManageBrno = blnManageBrno;
    }
}