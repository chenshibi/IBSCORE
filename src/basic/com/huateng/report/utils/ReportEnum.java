package com.huateng.report.utils;

public class ReportEnum {

    public static enum REPORT_VAILD {
        YES("1", "有效"), NO("0", "无效");
        public String value;
        public String name;

        private REPORT_VAILD(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String valueof(String value) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].value.equals(value)) {
                    return values()[i].name;
                }
            }
            return value;
        }
    }

    public static enum REPORT_ST1 {
        CR("1", "创建中"), ET("2", "修改中"), DE("3", "删除中"), Y("4", "有效"), N("5", "无效");
        public String value;
        public String name;

        private REPORT_ST1(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String valueof(String value) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].value.equals(value)) {
                    return values()[i].name;
                }
            }
            return value;
        }
    }

    /**
     * 复核功能代码
     * 
     * @author NING-PENG
     *
     */
    public static enum REPORT_TASK_FUNCID {
        TASK_100899("100899", "安全参数设置"), TASK_100199("100199", "机构管理"), TASK_100299("100299", "角色管理"), TASK_100399(
                "100399", "用户管理"), TASK_100599("100599", "工作日期维护"), TASK_100799("100799", "系统参数设置"), TASK_110199(
                        "110199", "币种信息维护"), TASK_110499("110499", "国家/地区代码维护"), TASK_110599("110599",
                                "外汇月牌价维护"), TASK_110699("110699", "外汇日牌价维护"), TASK_120199("120199",
                                        "系统公告维护"), TASK_120299("120299", "法院参数设置"), TASK_120399("120399", "电信参数设置");
        public String value;
        public String name;

        private REPORT_TASK_FUNCID(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String valueof(String value) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].value.equals(value)) {
                    return values()[i].name;
                }
            }
            return value;
        }
    }

    /**
     * 操作说明类型
     * 
     * @author jianxue.zhang
     *
     */
    public static enum REPORT_TASK_TRANS_CD {
        NEW("01", "创建"), EDIT("02", "编辑"), DEL("03", "删除"), RESETPWD("00", "重置密码");
        public String value;
        public String name;

        private REPORT_TASK_TRANS_CD(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String valueof(String value) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].value.equals(value)) {
                    return values()[i].name;
                }
            }
            return value;
        }
    }

    /**
     * 操作说明类型
     * 
     * @author jianxue.zhang
     *
     */
    public static enum REPORT__FH_ST {
        YES("4", "记录有效"), NO("5", "记录无效");
        public String value;
        public String name;

        private REPORT__FH_ST(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public static String valueof(String value) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].value.equals(value)) {
                    return values()[i].name;
                }
            }
            return value;
        }
    }
	/**
	 * 核对汇总列类型
	 * @author NING-PENG
	 *
	 */
	public static enum IND_APP_CONF_TYPE{
		STRING(1,"字符型"),NUM(2,"数值型");
		public int value;
		public String name;

		private IND_APP_CONF_TYPE(int value, String name) {
			this.value = value;
			this.name = name;
		}
	}
    
    
}
