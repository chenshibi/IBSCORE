<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="征信报告企业展示">
		<@CommonQueryMacro.CommonQuery id="IbsEntCredit" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable"  fieldStr="sxjg,zhzt,zhlx,dbfs,klrq,dqr,qs,sxed,yyed,bz,ye,byyhk,byshk[100],zzychkrq[150],sjgbrq,dklx,dqwjfl,dqyqze[150],dqyqbj[100],cjyqys[100],cjyqjezj[150],cjzcwjfl[150],tue[50],dsr[50],wc[50]"   width="100%"  readonly="true"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>

	<script language="JavaScript">
	</script>
</@CommonQueryMacro.page>