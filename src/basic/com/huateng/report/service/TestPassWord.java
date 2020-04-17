package com.huateng.report.service;

import org.apache.commons.lang3.StringUtils;

import com.huateng.report.utils.SM3;

/**
 * @author Grassy
 * @date 2019/4/9 15:41
 * @jdk.version 1.8
 * @desc
 */
public class TestPassWord {
    public static void main(String[] args) throws Exception{
        String aa = SM3.getHash("Aa123456");
        String str="B2.0.0B0000000000001W10312900H001220190410123018D10420190221000000010000000000\r\n";
        String xmlStr="B2.0.0B0000000000001W10312900H001220190410123018D10420190221000000010000000000\r\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Document>\n" +
                "    <Msg>\n" +
                "        <ResultCode>AAA000</ResultCode>\n" +
                "        <ResultDesc>处理成功</ResultDesc>\n" +
                "        <ReportName>2019041000002325.xml</ReportName>\n" +
                "        <ReportMessage>\n" +
                "<Document>";
        String xml = StringUtils.substring(xmlStr, 80);


        System.out.println("截取报文为==="+xml);
        System.out.println("str的长度为====="+str.length());
     //   System.out.println("密码为======"+aa);
    }
}
