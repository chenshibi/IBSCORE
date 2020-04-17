<#import "/templets/commonQuery/CommonQueryTagMacro.ftl" as CommonQueryMacro>
<@CommonQueryMacro.page title="批量二代企业征信请求状态查询">
		<@CommonQueryMacro.CommonQuery id="CorpStateQuery" init="false" submitMode="current" navigate="false" >
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
						<@CommonQueryMacro.DataTable id ="datatable1"   fitColumns="false" fieldStr="rsv2,createUser,totalNum,successNum,failNum,emptyNum,createTime"  hasFrame="true" width="100%"/>
		      		</td>
		    	</tr>
			</table>
		</@CommonQueryMacro.CommonQuery>
<script language="JavaScript">
function flushData(){
    PersonalCrawState_dataset.flushData(1);
}
function OpenWindowWithPost(url, windowoption, target, params)
    {
    var form = document.createElement("form");
    form.setAttribute("method", "post");
    form.setAttribute("action", url);
    if (target === "_blank") {
        target = "Window" + (new Date()).valueOf();
    }
    form.setAttribute("target", target);

    for (var i in params) {
        if (params.hasOwnProperty(i)) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = i;
            input.value = params[i];
            form.appendChild(input);
        }
    }

    document.body.appendChild(form);
    window.open(_application_root + "/common/blank.html", target, windowoption);
    form.submit();
    document.body.removeChild(form);
 }
    

/**
 * 去掉字符串前后空格
 * @param str
 * @returns {void | string}
 * @constructor
 */
function Trim(str)
{
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

function isEmpty(obj) {
if(!obj && obj !== 0 && obj !== '') {　
  return true;
}else{
  return false;
}
if(Array.prototype.isPrototypeOf(obj) && obj.length === 0) { 
   return true;
  }else{
   return false;
  }
if(Object.prototype.isPrototypeOf(obj) && Object.keys(obj).length === 0) { 
   return true;
  }else{
   return false;
  }　
  
  }


</script>
</@CommonQueryMacro.page>