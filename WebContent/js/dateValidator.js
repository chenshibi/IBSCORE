// check dateformat is or isn't right
//like 2002-01-01 20020101 is right
//return true false
function isDate(date)
{ if (date.value!="" && date.value.length!=10 && date.value.length!=8){    
    	date.focus();
        return false
   }
   
      if (date.value.length==10){
        var i
		if  ((date.value.substring(4,5)!="-") || (date.value.substring(7,8)!="-") ) {      
            date.focus();
            return false
		}
        for (i=1;i<11;i++)  {
            if ((i!=8) && (i!=5) && (date.value.substring(i-1,i)<"0" || date.value.substring(i-1,i)>"9")) {              
                date.focus();
                return false
	        }
      	}
		if ((date.value.substring(0,4)>"2058") || (date.value.substring(0,4)<"1900")) {			
			date.focus();
			return false
		}
		if ((date.value.substring(5,7)>"12") || (date.value.substring(5,7)<"01")) {		
			date.focus();
			return false
		}
		if ((date.value.substring(8,10)>"31") || (date.value.substring(8,10)<"01")) {		
			date.focus();
			return false
		}
		var year=date.value.substring(0,4),month=date.value.substring(5,7),day=date.value.substring(8,10);
		var leap=(year%4==0&&year%100!=0)||year%400;
		if(month=="02")
			if(leap)
				if(day>"29") {					
					date.focus();
					return false
				}
			else
				if(day>"28") {				
					date.focus();
					return false
				}
		if(month=="04"||month=="06"||month=="09"||month=="11")
			if(day>"30") {				
				date.focus();
				return false
			}
   }
   if (date.value.length==8){
     var i;
     if ((date.value.substring(0,4)>"2100") || (date.value.substring(0,4)<"1900")) {		
			date.focus();
			return false
		}
		if ((date.value.substring(4,6)>"12") || (date.value.substring(4,6)<"01")) {		
			date.focus();
			return false
		}
		if ((date.value.substring(6,8)>"31") || (date.value.substring(6,8)<"01")) {			
			date.focus();
			return false
		}
		var temp=date.value;
		//date.value=temp.substring(0,4) + "-" + temp.substring(4,6) + "-" + temp.substring(6,8);
		//var year=date.value.substring(0,4),month=date.value.substring(5,7),day=date.value.substring(8,10);
		var year=date.value.substring(0,4),month=date.value.substring(4,6),day=date.value.substring(6,8)
		var leap=(year%4==0&&year%100!=0)||year%400;		
		if(year<="1000"){
		alert("year number is bigger than 1000 !");
		date.focus();
		return false
		}
		if(year>="2059"){
		date.focus();
		return false
		}
		if(month=="02")
		if(leap)
		if(day>"29") {
		date.focus();
		return false
		}
		else if(day>"28") {	
		date.focus();
		return false
		}
		if(month=="04"||month=="06"||month=="09"||month=="11")
			if(day>"30") {				
				date.focus();
				return false
			}
   }   
   return true
}