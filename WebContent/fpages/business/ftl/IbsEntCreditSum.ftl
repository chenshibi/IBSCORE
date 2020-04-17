<#import "/templets/commonQuery/CommonQueryTagMacroMng.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="征信报告总企业展示">
		<@CommonQueryMacro.CommonQuery id="IbsEntCreditSum" init="false" submitMode="current" >
			<table align="left"  width="100%">
			  <tr valign="center">
			   <td valign="top" colspan="2">
				 <@CommonQueryMacro.Interface id="intface" label="请输入查询条件" colNm=4 />
			   </td>
		      </tr>
			<tr>
                <td valign="top">
                 <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
                </td>
            </tr>
		    	<tr >
		    		<td colspan="2">
						<@CommonQueryMacro.DataTable id ="datatable1"  fieldStr="opr[100],qymc,cxrq,sfbh,ywyq,dqgzlblfzbs[200],dqgzlblfzye[200],lsgzlblyqfzbs[200],lsgzlblyqfze[200],fmxx,bgbm,zzm[100],qyzxlb[150],dqdkbs,dqdkjgs[150],dqdkzed[150],dqdkyyed[150],dqdkzye[150],dqbzcywbs[200],dqbzcywye[200],dqxghkzrbs[200],dqxghkzrye[200],dqzcwjfl[150],dqyqze,dqyqbj,dqgzlbs,dqgzlje,dqsslje,dqsslbs,dqsslje,cjsslbs[100],cjsslje[150],jjyblbs[100],jjyblje[150],tue[100],dsr[100],wc[100],totalBankLimit[100]"   width="100%"  readonly="true"/>
		      		</td>
		    	</tr>
			</table>
</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
	   function datatable1_opr_onRefresh(cell, value, record) {
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
        loadPageWindows("userWin", "View Report Information", "/fpages/business/ftl/IbsEntCredit2.ftl", paramMap, "winZone");
        return;
    }
</script>
</@CommonQueryMacro.page>