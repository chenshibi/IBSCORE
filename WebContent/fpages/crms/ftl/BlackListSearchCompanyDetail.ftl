
<#import "/templets/commonQuery/DataDicUtil.ftl" as DataDicUtil >
<html>
<head>
    <title>黑名单企业详情</title>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <style>
       .table-data-td {
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
        }
       
       td {
            border: solid black 1px;
        }

        .labeltd {
            background: #f7fbfc;
            text-align:center;
            padding-right:8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
            width: 15%;
        }
        .labeltd-3 {
            
            text-align:center;
            padding-right:8px;
            font-size: 16px;
            width: 15%;
        }
        .labeltd-3-1 {
            
            text-align:left;
            padding-right:8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
            width: 15%;
        }
        .labeltd-3-2 {
            
            text-align:left;
            padding-right:8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
            width: 15%;
        }
          .labeltd-2 {
            background: #f7fbfc;
            text-align:center;
            padding-right: 8px;
            color: blue;
            font-weight: bold;
            font-size: 14px;
        }
        .titletd {
            text-align: left;
            width: 15%;
            color: black;
            font-weight: bold;
            font-size: 16px;
            border: 0px;
        }
        .titletd-2 {
            text-align: left;
            width: 5%;
            color: black;
            font-weight: bold;
            font-size: 16px;
            border: 0px;
        }
         .titletd-3 {
            text-align: left;
            color: black;
            font-weight: bold;
            font-size: 14px;
            border: 0px;
        }
         .titletd-4 {
            text-align: right;
            color: black;
            font-size: 14px;
            border: 0px;
        }
        .titletd-5 {
            text-align: left;
            width: 15%;
            color: black;
            font-weight: bold;
            font-size: 14px;
            border: 0px;
        }
        .datatd {
            background: #f7fbfc;
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
        }
        .datatd-1 {
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
        }
        .datatd_ {
            background: #f7fbfc;
           
            font-size: 14px;
        }
        .datatd-number {
            background: #f7fbfc;
            white-space: nowrap;
            padding-left: 8px;
            font-size: 14px;
            text-align: right;
        }
        .tabletd {
            width: 100%;
        }

        .table-label-td {
        	background: #f7fbfc;
            font-weight: bold;
            font-size: 14px;
            text-align:center;
        }
        .table-label-td-1 {
        	background: #f7fbfc;
            font-weight: bold;
            font-size: 14px;
            text-align:left;
             color: blue;
        }

        .datatd {
            font-size: 14px;
        }

        .table-head-td {
            font-weight: bold;
            font-size: 14px;
            text-align: center;
            border: 0px;
        }

        body {
            text-align: center;
        }

        #mainDiv {
            width: 80%;
            padding-right: 10%;
            padding-left: 10%;
        }

        fieldset {
            border-width: 1px;
        }

        .mainTable {
            width: 100%;
            border-collapse: collapse;
            border: none;
        }

        .secondTable {
            width: 80%;
            border-collapse: collapse;
            border: none;
            margin-left: 10%;
            margin-bottom: 10px;
        }

        @media print {
            td {
                font-size: 8pt !important;
            }

            #mainDiv {
                width: 100%;
                padding-right: 0;
                padding-left: 0;
            }

            #printBtn {
                display: none;
            }
        }
         
    </style>

    <script type="text/javascript">
        <#assign uuid = RequestParameters["uuid"]?default("")>
        var uuid = "${uuid}";

        function printRpt() {
            window.print();
        }
        function financeServer(type,year,uuid){
  			var params = {}
        	params.uuid=uuid;
        	params.type=type;
        	params.year=year;
        	openWindowWithPost("${contextPath}/FinanceReportServlet", params);
		}
		
		function creditloanServer(type,uuid){
  			var params = {}
        	params.uuid=uuid;
        	params.type=type;
        	openWindowWithPost("${contextPath}/CreditLoanReportServlet", params);
		}
		
		
		
		
		function openWindowWithPost(url, data) {
    		var form = document.createElement("form");
    		form.target = "_blank";
   		 	form.method = "POST";
   		 	form.action = url;
    		form.style.display = "none";

    		for (var key in data) {
        		var input = document.createElement("input");
        		input.type = "hidden";
        		input.name = key;
        		input.value = data[key];
        		form.appendChild(input);
    		}

    		document.body.appendChild(form);
    		form.submit();
    		document.body.removeChild(form);
		}
		
    </script>
</head>

<body>
	<div id="mainDiv">

    	<input id="printBtn" type="button" value="打印" onclick="printRpt();" style="font-size:14px"/> <br>
   
   		<table class="mainTable"> 
        	<tr>
        		<td class="table-label-td-1" style="width:50%;">条目</td>
        		<td class="table-label-td-1" style="width:50%;">数值</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">comp_id</td>
                <td class="datatd" style="width:50%;">${map.T_Company.COMP_ID!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">reg_id</td>
                <td class="datatd" style="width:50%;">${map.T_Company.REG_ID!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">name_chn</td>
                <td class="datatd" style="width:50%;">${map.T_Company.NAME_CHN!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">name_eng</td>
                <td class="datatd" style="width:50%;">${map.T_Company.NAME_ENG!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">date_reg</td>
                <td class="datatd" style="width:50%;">${map.T_Company.DATE_REG!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">product</td>
                <td class="datatd" style="width:50%;">${map.T_Company.PRODUCT!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">rm</td>
                <td class="datatd" style="width:50%;">${map.T_Company.RM!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">loan_no</td>
                <td class="datatd" style="width:50%;">${map.T_Company.LOAN_NO!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">date_app</td>
                <td class="datatd" style="width:50%;">${map.T_Company.DATE_APP!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">app_no</td>
                <td class="datatd" style="width:50%;">${map.T_Company.APP_NO!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">reason1</td>
                <td class="datatd" style="width:50%;">${map.T_Company.REASON1!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">reason2</td>
                <td class="datatd" style="width:50%;">${map.T_Company.REASON2!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">reason3</td>
                <td class="datatd" style="width:50%;">${map.T_Company.REASON3!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">status</td>
                <td class="datatd" style="width:50%;">${map.T_Company.STATUS!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">date_input</td>
                <td class="datatd" style="width:50%;">${map.T_Company.DATE_INPUT!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">comp_addr1</td>
                <td class="datatd" style="width:50%;">${map.T_Company.COMP_ADDR1!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">comp_addr2</td>
                <td class="datatd" style="width:50%;">${map.T_Company.COMP_ADDR2!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">comp_addr3</td>
                <td class="datatd" style="width:50%;">${map.T_Company.COMP_ADDR3!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">recov_status</td>
                <td class="datatd" style="width:50%;">${map.T_Company.RECOV_STATUS!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">apply_amt</td>
                <td class="datatd" style="width:50%;">${map.T_Company.APPLY_AMT!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">approve_amt</td>
                <td class="datatd" style="width:50%;">${map.T_Company.APPROVE_AMT!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">os_amt</td>
                <td class="datatd" style="width:50%;">${map.T_Company.OS_AMT!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">area</td>
                <td class="datatd" style="width:50%;">${map.T_Company.AREA!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">aps_id</td>
                <td class="datatd" style="width:50%;">${map.T_Company.APS_ID!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">BusinessPhone</td>
                <td class="datatd" style="width:50%;">${map.T_Company.COMP_PHONE1!}</td>
          	</tr>
          	
          	<#list map.T_blackList_List! as list>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">GuaranName1</td>
                <td class="datatd" style="width:50%;">${list.NAME_CHN!}</td>
          	</tr>
          	<tr>
        		<td class="table-label-td-1" style="width:50%;">GuaranID1</td>
                <td class="datatd" style="width:50%;">${list.CUST_ID!}</td>
          	</tr>
          	</#list>
        </table>
           
</body>

</html>
