function openContract(value)
{
	path = _application_root + "/loaninqloan/contractInquiryAction.do?contractno=" + value;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=768");
}

function openCustomerNo(value)
{
	path = _application_root + "/custindv/custIndvInquiryAction.do?custno=" + value;// + "&databusid=CUSTINFOMAG_DB";
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=768");
}
function openCustomerNo2(value)
{
	path = _application_root + "/fpages/custindv/ftl/querycustbasicinfo.ftl?custno=" + value ;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
function openCino(value)
{
	path = _application_root + "/loaninqloan/loanCinoInquiryAction.do?cino=" + value;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=768");
}
function openTaskList(value)
{
	path = _application_root + "/myworkbench/xml/waittohandletasklist.xml" ;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=768");
}
function openProjectNo(value)
{
	path = _application_root + "/loaninqloan/projectnoInquiryAction.do?projectno=" + value;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=768");
}
function openCoopCustomer(value)
{
	path = _application_root + "/loaninqloan/CorpCustomerInquiryAction.do?custno=" + value;//+ "&databusid=CUSTINFOMAG_DB";
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=768");
}
function openInsurer(value){
	path = _application_root + "/fpages/custcorp/ftl/insurerQueryResult.ftl?custcd=" + value;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1,width=1024,height=768");
}
/**	add by zhengbin 2010-09-08 客户余额信息 begin*/
function openCustomerCredit(brcode,curcd)
{
	path = _application_root + "/fpages/search/ftl/CustomerCreditSearch.ftl?brcode=" + brcode+"&curcd="+curcd;
    window.open(path,"_blank","resizable=1,location=0,scrollbars=1, width=1024,height=768 ");
}
/**	add by zhengbin 2010-09-08 客户余额信息 end*/