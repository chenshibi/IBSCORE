<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="征信报告个人展示">
		<@CommonQueryMacro.CommonQuery id="IbsPerCredit2" init="true" mode="0" submitMode="all" >
		 <table align="left"  width="100%">
		   <tr valign="top">
            <td valign="center">
                <@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9"  showArrow="true" pageCache="false"/>
               <@CommonQueryMacro.DataTable id ="datatable"  fitColumns="true" hasFrame="true" fieldStr="zhmc[300],sxjg[300],zhzt[300],zhlx[300],dbfs[300],klrq[300],dqr[300],qs[300],sxed[300],yyed[300],bz[300],ye[300],byyhk[300],byshk[300],zjychkrq[300],sjgbrq[300],dqyqqs[300],dqyqje[300],cjyqys[300],cjyqjejz[300],cjzdyqqs[300],tue[300],dsr[300],wc[300]"   width="100%"  readonly="true"/>
                <br/>
            </td>
        </tr>
        <tr valign="top">
            <td valign="center">
                <CENTER><@CommonQueryMacro.Button id= "btClose"/></CENTER>
            </td>
        </tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
	<script language="JavaScript">
	   function btClose_onClickCheck(button) {
        unloadPageWindows("userWin");
        return false;
    }
	</script>
</@CommonQueryMacro.page>