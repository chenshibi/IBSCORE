package com.huateng.excel.imp;

import java.util.HashMap;

public class Config {
    private static HashMap<String, String> p = new HashMap<String, String>();
    static {
        p.put("dxzpAccountMaintain", "dxzpAccountMaintain");
        p.put("FayuanJudicial", "FayuanJudicial");
        p.put("FayuanJudicialFp", "FayuanJudicialFp");
    }

    public static String getValue(String key) {
        return p.get(key);
    }
}
