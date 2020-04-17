package resource.bean.basic.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the TLR_ROLE_REL table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="TLR_ROLE_REL"
 */

public abstract class BaseCurcdMap implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5139917702727949875L;
    public static String REF = "CurcdMap";
    public static String PROP_CURCD = "curcd";
    public static String PROP_CURCD_NAME = "curcdname";
    public static String PROP_CURCD_NO = "curcdno";
    public static String PROP_CURCD_NAME_NO = "curcdnameno";

    // constructors
    public BaseCurcdMap() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCurcdMap(java.lang.String curcd) {
        this.setCurcd(curcd);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String curcd;

    // fields
    private java.lang.String curcdname;
    private java.lang.String curcdno;
    private java.lang.String curcdnameno;

    public java.lang.String getCurcd() {
        return curcd;
    }

    public void setCurcd(java.lang.String curcd) {
        this.curcd = curcd;
    }

    public java.lang.String getCurcdname() {
        return curcdname;
    }

    public void setCurcdname(java.lang.String curcdname) {
        this.curcdname = curcdname;
    }

    public java.lang.String getCurcdno() {
        return curcdno;
    }

    public void setCurcdno(java.lang.String curcdno) {
        this.curcdno = curcdno;
    }

    public java.lang.String getCurcdnameno() {
        return curcdnameno;
    }

    public void setCurcdnameno(java.lang.String curcdnameno) {
        this.curcdnameno = curcdnameno;
    }

}