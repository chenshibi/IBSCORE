// 	description: this method is sum by add num  author lizh
	function _sumDate(dateStr,num){
	var _dateStr;
	var year;
	var month;
	var day;
	var returnDate;
	var newmonth=num;
	 if(dateStr.length==10){
	 _dateStr=new Date(eval(dateStr.substring(0,dateStr.indexOf('-'))),
	                  eval(dateStr.substring(dateStr.indexOf('-')+1,dateStr.lastIndexOf ('-'))),
	                  eval(dateStr.substring(dateStr.lastIndexOf ('-')+1)));
	 }else{
	  _dateStr=new Date(eval(dateStr.substring(0,4)),
	                  eval(dateStr.substring(4,6)),
	                  eval(dateStr.substring(6,8)));
	 }
	 _dateStr.setMonth(_dateStr.getMonth()+newmonth);   //set new month
		year=_dateStr.getFullYear();
		month=_dateStr.getMonth();
		day=_dateStr.getDate();
		if(eval(month)<10){
		month='0'+month;
		}
		if(eval(day)<10){
		day='0'+day;
		}
		returnDate=year+'-'+month+'-'+day; 
		return returnDate;
	}

 // description: this method is compare to two String  author lizh
	function dateCompare(dateStrbefore,dateStrafter){
		var _dateStr_before;
		var _dateStr_after;
		if(dateStrbefore.length==10){
		_dateStr_before=dateStrbefore.substring(0,dateStrbefore.indexOf('-'))
		                  +(dateStrbefore.substring(dateStrbefore.indexOf('-')+1,dateStrbefore.lastIndexOf ('-')))
		                  +(dateStrbefore.substring(dateStrbefore.lastIndexOf ('-')+1));
		}else{
		_dateStr_before=dateStrbefore;
		}
		
		if(dateStrafter.length==10){
		_dateStr_after=dateStrafter.substring(0,dateStrafter.indexOf('-'))
		                  +(dateStrafter.substring(dateStrafter.indexOf('-')+1,dateStrafter.lastIndexOf ('-')))
		                  +(dateStrafter.substring(dateStrafter.lastIndexOf ('-')+1));
		}else{
		_dateStr_after=dateStrafter;
		}
    if(_dateStr_before>_dateStr_after){ //mean:_dateStr_before is bigger than _dateStr_after
    return true;
    }else{
    return false; 
    } 
  }

