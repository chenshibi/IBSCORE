<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>

<@CommonQueryMacro.page title="接收用户维护">
<table align="left">
	<tr>
		<td>
			<@CommonQueryMacro.CommonQuery id="CpgUsrInf" init="false" submitMode="current">
			<table width="100%">
				<tr>
					<td colspan="2" valign="top">
						<@CommonQueryMacro.Interface id="interface1" label="请输入查询条件" />
					</td>
				</tr>
				<tr>
					<td>
						<@CommonQueryMacro.PagePilot id="pagePilot1" maxpagelink="9" showArrow="true" pageCache="false"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<@CommonQueryMacro.DataTable id="datatable1" paginationbar="btAdd" fieldStr="userId,userName,creator1,createdDate1[150],checkUser1,checkDate1[150],opr" width="100%"/>
					</td>
				</tr>
			</table>
			</@CommonQueryMacro.CommonQuery>
		</td>
	</tr>
</table>
<script language="JavaScript">
	//将id列变成超链接,需要记录类型,操作说明,原纪录主键,记录本身
	function datatable1_opr_onRefresh(cell,value,record){
		var id = record.getValue("id");
		//var recStatus = record.getValue("recStatus");
		if(record){
			if(true){
				innerText = "<center><a href=\"JavaScript:doModify('"+id+"')\">修改</a> "
				cell.innerHTML= innerText +"<a href=\"JavaScript:doDelete('"+id+"')\">删除</a></center>";
			}else{
				cell.innerHTML = "<center>记录锁定</center>";
			}
		}else {//当不存在记录时
				cell.innerHTML="&nbsp;";
		}
	}
    function locate(id) {
		var record = CpgUsrInf_dataset.find(["id"],[id]);
        if (record) {
			CpgUsrInf_dataset.setRecord(record);
		}
	}
	 function doDelete(id) {
        locate(id);
        //document.getElementById('btDel').click()
        var record = CpgUsrInf_dataset.find(["id"],[id]);
        var userId = record.getValue("userId");
		var url = "/fpages/msgplatform/ftl/CpgUsrInfDtl.ftl?type=delete&id="+id+"&userId="+userId;
		showWin("接收用户维护",url,"window","flushPage()",window);
    }
    function doModify(id){
        locate(id);
        var record = CpgUsrInf_dataset.find(["id"],[id]);
        var userId = record.getValue("userId");
		var url = "/fpages/msgplatform/ftl/CpgUsrInfDtl.ftl?type=update&id="+id+"&userId="+userId;
		showWin("接收用户维护",url,"window","flushPage()",window);
    }
	function btAdd_onClick(button){
		var url = "/fpages/msgplatform/ftl/CpgUsrInfDtl.ftl?type=new";
		showWin("接收用户维护",url,"window","flushPage()",window);
	}


	function showDetail(id){
	    var record = CpgUsrInf_dataset.find(["id"],[id]);
        var url = "/fpages/msgplatform/ftl/CpgUsrInfDtl.ftl?type=detail&id="+id;
		    showWin("接收用户维护",url,"window","flushPage()",window);
        }
    //刷新数据
	function flushPage(){
		CpgUsrInf_dataset.flushData(1);
	}

	
</script>
</@CommonQueryMacro.page>