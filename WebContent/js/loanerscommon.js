//LTrim(string):去除左边的空格
function LTrim(str){
    var whitespace = new String(" \t\n\r");
    var s = new String(str);
    if (whitespace.indexOf(s.charAt(0)) != -1) {
        var j=0, i = s.length;
        while (j < i && whitespace.indexOf(s.charAt(j)) != -1){
            j++;
        }
        s = s.substring(j, i);
    }
    return s;
}

//RTrim(string):去除右边的空格
function RTrim(str){
    var whitespace = new String(" \t\n\r");
    var s = new String(str);
    if (whitespace.indexOf(s.charAt(s.length-1)) != -1){
        var i = s.length - 1;
        while (i >= 0 && whitespace.indexOf(s.charAt(i)) != -1) {
            i--;
        }
        s = s.substring(0, i+1);
    }
    return s;
}

//Trim(string):去除前后空格
function Trim(str){
    return RTrim(LTrim(str));
}


function isEmpty(str) {
	if(str == null || str == "") {
		return true;
	}
	return false;
}



//组织机构代码校验
function checkCertifyCode(certifyCode,position){
        var fir_value, sec_value;
        var w_i = new Array(8);
        var c_i = new Array(8);
        var j, s = 0;
        var c, i;

       var code = certifyCode;
       if (code == "00000000-0") {
          alert(position+"组织机构代码错误!");
          return false;
          }                           
        re = /[A-Z0-9]{8}-[A-Z0-9]/;    
        r = code.match(re);   
        if (r == null) {
          alert(position+"组织机构代码错误!");
       return false;
       }        

      w_i[0] = 3;
      w_i[1] = 7;
      w_i[2] = 9;
      w_i[3] = 10;
      w_i[4] = 5;
      w_i[5] = 8;
      w_i[6] = 4;
      w_i[7] = 2;

      if (certifyCode.charAt(8) != '-') {
    	  alert(position+"组织机构代码错误!");		
	    return false;
       }
      for (i = 0; i < 10; i++) {
	     c = certifyCode.charAt(i);
	     if (c <= 'z' && c >= 'a') {
	    	 alert(position+"组织机构代码错误!");
		 return false;
	   }
   }
   fir_value = certifyCode.charCodeAt(0);
   sec_value = certifyCode.charCodeAt(1);

   if (fir_value >= 'A'.charCodeAt(0) && fir_value <= 'Z'.charCodeAt(0)) {
	   c_i[0] = fir_value + 32 - 87;
   } else {
		if (fir_value >= '0'.charCodeAt(0) && fir_value <= '9'.charCodeAt(0)) {
		c_i[0] = fir_value - '0'.charCodeAt(0);
		} else {
			alert(position+"组织机构代码错误!");
		    return false;
		}
   }

   s = s + w_i[0] * c_i[0];

   if (sec_value >= 'A'.charCodeAt(0) && sec_value <= 'Z'.charCodeAt(0)) {
	   c_i[1] = sec_value + 32 - 87;
   } else if (sec_value >= '0'.charCodeAt(0) && sec_value <= '9'.charCodeAt(0)) {
	   c_i[1] = sec_value - '0'.charCodeAt(0);
   } else {
	   alert(position+"组织机构代码错误!");
	   return false;
   }

   s = s + w_i[1] * c_i[1];
   for (j = 2; j < 8; j++) {
	   if (certifyCode.charAt(j) < '0' || certifyCode.charAt(j) > '9') {
		   alert(position+"组织机构代码错误!");
		   return false;
	   }
	   c_i[j] = certifyCode.charCodeAt(j) - '0'.charCodeAt(0);
	   s = s + w_i[j] * c_i[j];
   }

   c = 11 - (s % 11);

   if (!((certifyCode.charAt(9) == 'X' && c == 10) ||
		 (c == 11 && certifyCode.charAt(9) == '0') || (c == certifyCode.charCodeAt(9) - '0'.charCodeAt(0)))) {
	       alert(position+"组织机构代码错误!");
		  return false;
    } 
    return true;
}



function isIDno(idcard,position) {
    var Errors=new Array("验证通过!",
                         "身份证号码位数不对!",
                         "身份证号码出生日期超出范围或含有非法字符!",
                         "身份证号码校验错误!",
                         "身份证地区非法!"
                        );
  
    var area={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
    
    if (!checkstring_allSpace(idcard)) {
        alert("错误：您输入的都是空格！");
        return false;
    }
    
    var idcard,Y,JYM;
    var S,M;
    var idcard_array = new Array();
    idcard_array = idcard.split("");
    //地区检验
    if(area[parseInt(idcard.substr(0,2))]==null) {
        alert(position+Errors[4]);
        return false;
    }
    //身份号码位数及格式检验
    switch(idcard.length){
    case 15:
        //15位身份号码检测
        if ( (parseInt(idcard.substr(6,2))+1900) % 4 == 0 || ((parseInt(idcard.substr(6,2))+1900) % 100 == 0 && (parseInt(idcard.substr(6,2))+1900) % 4 == 0 )){
            ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;//测试出生日期的合法性
        } else {
            ereg=/^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;//测试出生日期的合法性
        }
        if(!ereg.test(idcard)) {
            alert(position+Errors[2]);
            return false;
        } else {
            return true;
        }
    break;
    case 18:
        //18位身份号码检测
        //出生日期的合法性检查 
        //闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
        //平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
        if ( parseInt(idcard.substr(6,4)) % 4 == 0 || (parseInt(idcard.substr(6,4)) % 100 == 0 && parseInt(idcard.substr(6,4))%4 == 0 )){
            ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;//闰年出生日期的合法性正则表达式
        } else {
            ereg=/^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;//平年出生日期的合法性正则表达式
        }
        if(ereg.test(idcard)) { //测试出生日期的合法性
            //计算校验位
            S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
            + (parseInt(idcard_array[1]) + parseInt(idcard_array[11])) * 9
            + (parseInt(idcard_array[2]) + parseInt(idcard_array[12])) * 10
            + (parseInt(idcard_array[3]) + parseInt(idcard_array[13])) * 5
            + (parseInt(idcard_array[4]) + parseInt(idcard_array[14])) * 8
            + (parseInt(idcard_array[5]) + parseInt(idcard_array[15])) * 4
            + (parseInt(idcard_array[6]) + parseInt(idcard_array[16])) * 2
            + parseInt(idcard_array[7]) * 1 
            + parseInt(idcard_array[8]) * 6
            + parseInt(idcard_array[9]) * 3 ;
            Y = S % 11;
            M = "F";
            JYM = "10X98765432";
            M = JYM.substr(Y,1);//判断校验位
            if(M !== idcard_array[17]) {
                alert(position+Errors[3]);
                return false;
            }
            return true;
        } else {
            alert(position+Errors[2]);
            return false;
        } 
        break;
    default:
        alert(position+Errors[1]);
        return false;
        break;
    }
}


function checkstring_allSpace(data) {
    if (data.length>0 && trim(data)=="") {
        return false;
    }
    return true;
}

function trim(val)
{
	var str = val+"";
	if (str.length == 0) return str;
	var re = /^\s*/;
	str = str.replace(re,'');
	re = /\s*$/;
	return str.replace(re,'');
}

function checkemail(obj) {
    //if (!checkstring_allSpace(umail)) return false;

  var umail=obj;
  if (!checkstring_allSpace(umail)) {
    alert("错误：您输入的都是空格！");
    return false;
  }
  if(umail!= "") {
    umail=Trim(umail)
    var ok1=umail.indexOf("@");
    var ok2=umail.indexOf(".");
    if(!((ok1!=-1)&&(ok2!=-1))) {
      alert("Email格式错误！");
    	return false;
    }
    var allowstrlist = "&#%<>";
    var endvalue = true;
    for (i=0;i<umail.length;i++) {
       if (allowstrlist.indexOf(umail.substr(i,1))!=-1) {
         endvalue=false;   
         break;
       }
    }
    if(endvalue==false) {
      alert("Email格式错误！");
    	return false;
    }
    //邮件地址正确
    return true;
  }
  else
    return true;
}
