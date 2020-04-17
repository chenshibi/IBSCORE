package resource.bean.msg;

import resource.bean.msg.base.BaseCpgMsgSndCtl;

public class CpgMsgSndCtl extends BaseCpgMsgSndCtl {
    public static final String OPP_ID_TYPE_USER = "1";// 1-用户;2-组
    public static final String OPP_ID_TYPE_GROUP = "2";
    private static final long serialVersionUID = 1L;

    /* [CONSTRUCTOR MARKER BEGIN] */
    public CpgMsgSndCtl() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public CpgMsgSndCtl(java.lang.String id) {
        super(id);
    }

    /**
     * Constructor for required fields
     */

    /* [CONSTRUCTOR MARKER END] */

}