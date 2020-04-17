<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="征信报告个人总展示">
		<@CommonQueryMacro.CommonQuery id="IbsPerCreditSum" init="false" submitMode="current" navigate="false" >
			<table align="left"  width="100%">
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.Interface id="interface" label="请输入查询条件" colNm="4"/>
					</td>
				</tr>

				<tr>
					<td valign="top">
						<@CommonQueryMacro.PagePilot id="pagequery" maxpagelink="10" showArrow="true" />
					</td>
		    	</tr>

		    	<tr >
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable"  fieldStr="opr,dbrxm,cxrq,sfbh,ywyq,yqje,bgbm[100],idcard[200],fmxx[100],dkrzxlb,zxfxdwz,findthree,findsix,findtwelve[150],dqgrzfdkbs[200],dqgrzfdkjgs[200],dqgrzfdkzfke[200],dqgrzfdkzye[200],dqgrzfdkyyhk[200],dqgrzfdkyshk[200],dqgrzfdkyqbs[200],dqgrzfdkyqje[200],dqgrjyxdkbs[200],dqgrjyxdkjgs[200],dqgrjyxdkzfke[200],dqgrjyxdkzye[200],dqgrjyxdkyyhk[200],dqgrjyxdkyshk[200],dqgrjyxdkyqbs[200],dqgrjyxdkyqje[200],dqqtdkbs[150],dqqtdkjgs[150],dqqtdkzfke[150],dqqtdkzye[150],dqqtdkyyhk[150],dqqtdkyshk[150],dqqtdkyqbs,dqqtdkyqje,dqdjkzhs,dqdjkjgs,dqdjkzed,dqxykyhke[200],dqydyhk,dqydshk[100],halfyearout3160times[200],halfyearout3160money[200],oneyearout60times[200],oneyearout60money[200],jlnhxbs,jlnhxje[100],tue[50],dsr[50],wc[50]"   width="100%"  readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>

<script language="JavaScript">
	   function datatable_opr_onRefresh(cell, value, record) {
        if (record && record != null) {
            var id = record.getValue("xh");
            var innerText = "";
            cell.innerHTML = innerText + " <a href=\"JavaScript:showDetail('" + id + "')\">查看明细</a></center>";
        }
        else {
            cell.innerHTML = "";
        }
    }
    
    function showDetail(id) {
        var paramMap = new Map();
        paramMap.put("xh", id);
        loadPageWindows("userWin", "View Report Information", "/fpages/business/ftl/IbsPerCredit2.ftl", paramMap, "winZone");
        return;
    }
</script>
</@CommonQueryMacro.page>