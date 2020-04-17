function Type(typeArg)
{
	this.type=typeArg.type;
	switch(this.type)
	{
	case "Text":
		this.minLength=typeArg.min;
		this.maxLength=typeArg.max;
		break;
	case "Decimal":
		this.intPart = typeArg.int;
		this.decPart = typeArg.dec;
		break;
	case "Date":
		break;
	case "Enum":
		this.data = typeArg.data;
		break;
	case "Money":
		this.intPart = typeArg.int;
		this.decPart = typeArg.dec;
		break;
	}
}

Type.prototype.check=function (value)
{
	switch(this.type)
	{
	case "Text":
		if(value.length>=this.minLength&&(value.length<=this.maxLength||this.maxLength==-1))
		{
			return true;
		}
		break;
	case "Decimal":
		value = value.trim();
		var intPartReg = "^-?\\d{1,"+this.intPart+"}";
		var decPartReg = "$";
		if(this.decPart>0)
		{
			decPartReg="(?:\\.\\d{0,"+this.decPart+"})?$";
		}
		var pattern = new RegExp(intPartReg+decPartReg);
		if(pattern.test(value))
		{
			return true;
		}
		break;
	case "Date":
		var yearReg = /\d{4}/;
		var monthReg = /\d{2}/;
		var dayReg = /\d{2}/;
		var year;
		var month;
		var day;
		if(value.length==8)
		{
			year=value.substring(0,4);
			month=value.substring(4,6);
			day=value.substring(6,8);
		}else
		if(value.length==10)
		{
			year=value.substring(0,4);
			month=value.substring(5,7);
			day=value.substring(8,10);
			if("-"!=value.substring(4,5)||"-"!=value.substring(7,8)){return false;}
		}else{return false;}
		if(!yearReg.test(year)||!monthReg.test(month)||!dayReg.test(day))
		{
			return false;
		}
		var monthTable=[31,28,31,30,31,30,31,31,30,31,30,31];
		if((year%400==0)||(year%4==0&&year%100!=0))
		{
			monthTable[1]=29;
		}
		var tMonth = parseInt(month, 10)-1;
		var tDay = parseInt(day, 10);
		if(tMonth>=0&&tMonth<=11&&tDay>=1&&tDay<=monthTable[tMonth])
		{
			return true;
		}
		break;
	case "Enum":
		return Map.prototype.containKey.call(this,value)||Map.prototype.containValue.call(this,value);
	case "Money":
		value = value.trim();
		intPartReg = "^-?\\d{1,"+this.intPart+"}";
		decPartReg = "$";
		if(this.decPart>0)
		{
			decPartReg="(?:\\.\\d{0,"+this.decPart+"})?$";
		}
		pattern = new RegExp(intPartReg+decPartReg);
		if(pattern.test(value))
		{
			return true;
		}
		var point = value.indexOf(".");
		if(point==-1&&this.decPart!=0||point>3*Math.ceil((this.intPart/3)))return false;
		strIntPart=value.substring(0,point);
		if(value.charAt(0)==',')return false;
		for(var i=1;i<point;i++)
		{
			if(!((i%4==0&&value.charAt(point-i)==',')||(i%4!=0&&/\d/.test(value.charAt(point-i)))))
			{
				return false;
			}
		}
		if(this.decPart>0)
		{
			decPartReg="^\\.\\d{0,"+this.decPart+"}$";
		}
		pattern = new RegExp(decPartReg);
		if(pattern.test(value.substring(point)))
		{
			return true;
		}
		break;
	}
	return false;
}
Type.prototype.toDisplay=function (value)
{
	switch(this.type)
	{
	case "Text":
		return value;
	case "Decimal":
		return value;
	case "Date":
		return value.substring(0,4)+"-"+value.substring(4,6)+"-"+value.substring(6,8);
	case "Enum":
		var t = Map.prototype.get.call(this,value);
		if(t==null)
		{
			t="";
		}
		return t;
	case "Money":
		return value;
	}
	return false;
}
Type.prototype.toRaw=function (value,oldValue)
{
	switch(this.type)
	{
	case "Text":
		return value;
	case "Decimal":
		var out="";
		value = value.trim();
		var intPartReg = new RegExp("^-?\\d{1,"+this.intPart+"}");
		
		var result = value.match(intPartReg);
		if(result!=null)
		{
			out+=parseInt(result[0]);
		}
		var decPartReg;
		if(this.decPart>0)
		{
			var decPart = new RegExp("^(?:-?\\d{1,"+this.intPart+"})(\\.(\\d{1,"+this.decPart+"}))$");
			result = value.match(decPart);
			if(result!=null)
			{
				var dec = result[2];
				while(dec.length<this.decPart)
				{
					dec+="0";
				}
				out+="."+dec;
			}
		}
		return out;
	case "Date":
		if(value.length==8)
		{
			return value;
		}else
		if(value.length==10)
		{
			return value.substring(0,4)+value.substring(5,7)+value.substring(8,10);
		}
	case "Enum":
		if(Map.prototype.containKey.call(this,value))
		{
			return value;
		}
		else
		{
			return oldValue;
		}
	case "Money":
		out="";
		var intPart = "";
		for(var i=0;i<value.length;i++)
		{
			if(/\d|\.|,/.test(value.charAt(i)))
			{
				out+=value.charAt(i);
			}
		}
		return out;
	}
	return false;
}
