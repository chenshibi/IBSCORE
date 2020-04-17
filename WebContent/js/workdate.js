//根据年月显示日历
var workdate = {
	months:new Array("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"),
	daysInMonth:new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31),
	clickDate:function(str,obj){
		var chk = document.getElementById("ch"+str);
		if(chk.checked){
			obj.style.backgroundColor="#ffffff";
		}else{
			obj.style.backgroundColor="#c2dcfc";
		}
		chk.checked = !chk.checked;

	},
	getDays:function(year,month){
		if (1 == month) {
			return ((((0 == year % 4) && (0 != year % 100)) || (0 == year % 400)) ? 29 : 28);
		}
		return this.daysInMonth[month];
	},
	getDateStartOfWeek:function(year,month){//根据年月获取星期
		var dt = new Date();
		dt.setFullYear(year);
		dt.setMonth(month);
		dt.setDate(0);
		return dt.getDay();
	},
	getYearAndMonthAndDay:function(year, month, day) {
		var m = month < 10 ? "0" + month : month;
		var d = day < 10 ? "0" + day : day;
		var tmp = year + "-" + m + "-" + d;
		return tmp;
	},
	getIsWorkDay:function(datestr,dayweek,selDays){
		var chk = false;
		if(selDays!=null&&selDays.length>0){
			for(var i=0;i<selDays.length;i++){
				if(selDays[i]==datestr){
					chk = true;
					break;
				}
			}
		}else{
			if(dayweek!=5&&dayweek!=6){
				chk = true;
			}
		}
		return chk;
	},
	getCheckDate:function(){
		var chkDates = new Array();
		var chks = document.getElementsByName("chkdate");
		for(var i=0;i<chks.length;i++){
			if(chks[i].checked){
				chkDates.push(chks[i].value);
			}
		}
		return chkDates;
	},
	createCalendar:function(year,month,selDays,cudate){
		var startDay = this.getDateStartOfWeek(year,month-1);
		var monthDays = this.getDays(year,month-1);
		var monthstr = this.months[month-1];
		var intDaysInMonth = this.getDays(year,month-1);
		var dayOfMonthOfFirstSunday = 7-startDay+1;
		var count = 0;
		var dayOfMonth = 0;
		var daystr = "<table class='tablerowStyleColor' cellpadding='1' cellspacing='0'  border='1'/>";
		daystr+="<tr><td colspan='7' class='monthtitle'>"+monthstr+"</td></tr>";
		daystr+="<tr height=\"24px\" class='workdateWeek'>";
		daystr+="<td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td><td>日</td>";
		daystr+="</tr>";

		for (var intWeek = 0; intWeek < 6; ++intWeek) {
			daystr+="<tr height='24'>";
			var td = 0;
			for (var intDay = 0; intDay < 7; ++intDay) {
				dayOfMonth = intWeek * 7 + intDay + dayOfMonthOfFirstSunday - 7;
				if (dayOfMonth <= 0) {
					daystr+="<td class='workdateDis'>&nbsp;</td>";
					td++;
				} else if (dayOfMonth <= intDaysInMonth) {
					td++;
					++count;
					var classNm = "workdateTd";
					var bgcolor = "#ffffff";
					var tmp = this.getYearAndMonthAndDay(year, month, dayOfMonth);
					var str = tmp.replace(/-/g,"");
					var onclickstr = "onclick=\"workdate.clickDate('"+str+"',this);\"";
					var ischg = true;
					var fcl = "color:#000000;";
					if(str<=cudate){
						onclickstr="";
						tmp+="不能修改";
						fcl = "color:#777777;";
					}
					var iswork = this.getIsWorkDay(str,intDay,selDays);
					var ischecked = '';
					if(iswork){
						bgcolor="#c2dcfc";
						ischecked = 'checked';
					}
					daystr+="<td class='"+classNm+"' style='background-color:"+bgcolor+";"+fcl+"' title='" + tmp + "' "+onclickstr+">";
					daystr+=dayOfMonth + "<input type='checkbox' id='ch" + str + "' value='" + str + "' "+ischecked+" name='chkdate' style='display:none'/>";
					daystr+= "</td>";
				}
			}
			var dayspan = 7-td;
			for (var k = 0; k < dayspan; k++) {
				daystr+= "<td  class='workdateDis'>&nbsp;</td>";
			}
			daystr+= "</tr>";
		}
		daystr+= "</table>";
		//document.write(daystr);
		return daystr;
	},
	createCalendarByDetail:function(year,month,oldset,newset){
		var startDay = this.getDateStartOfWeek(year,month-1);
		var monthDays = this.getDays(year,month-1);
		var monthstr = this.months[month-1];
		var intDaysInMonth = this.getDays(year,month-1);
		var dayOfMonthOfFirstSunday = 7-startDay+1;
		var count = 0;
		var dayOfMonth = 0;
		var daystr = "<table class='tablerowStyleColor' cellpadding='1' cellspacing='0'  border='1'/>";
		daystr+="<tr><td colspan='7' class='monthtitle'>"+monthstr+"</td></tr>";
		daystr+="<tr height=\"24px\" class='workdateWeek'>";
		daystr+="<td>一</td><td>二</td><td>三</td><td>四</td><td>五</td><td>六</td><td>日</td>";
		daystr+="</tr>";

		for (var intWeek = 0; intWeek < 6; ++intWeek) {
			daystr+="<tr height='24'>";
			var td = 0;
			for (var intDay = 0; intDay < 7; ++intDay) {
				dayOfMonth = intWeek * 7 + intDay + dayOfMonthOfFirstSunday - 7;
				if (dayOfMonth <= 0) {
					daystr+="<td class='workdateDis'>&nbsp;</td>";
					td++;
				} else if (dayOfMonth <= intDaysInMonth) {
					td++;
					++count;
					var classNm = "workdateTd";
					var bgcolor = "#ffffff";
					var tmp = this.getYearAndMonthAndDay(year, month, dayOfMonth);
					var str = tmp.replace(/-/g,"");
					var iswork = this.getIsWorkDay(str,intDay,oldset);
					if(iswork){
						bgcolor="#c2dcfc";
					}
					if(newset!=null && newset.length>0){
						var bl = false;
						for(var i=0;i<newset.length;i++){
							if(str==newset[i]){
								bl = true;
								break;
							}
						}
						if(bl && !iswork){
							bgcolor = "#ffffcc";//变为工作日期
						}
						if(iswork && !bl){
							bgcolor = "#abdebe";//变为非工作日期
						}
					}
					daystr+="<td class='"+classNm+"' style='background-color:"+bgcolor+"' title='" + tmp + "'>";
					daystr+=dayOfMonth;
					daystr+= "</td>";
				}
			}
			var dayspan = 7-td;
			for (var k = 0; k < dayspan; k++) {
				daystr+= "<td  class='workdateDis'>&nbsp;</td>";
			}
			daystr+= "</tr>";
		}
		daystr+= "</table>";
		return daystr;
	}
};
