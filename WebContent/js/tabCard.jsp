<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
function initTab(tableId)
{
	var table = document.getElementById(tableId).rows[0].cells[0].firstChild;
	var cellInTable = document.getElementById(tableId).rows[0].cells[0];
	while(table!=null&&(table.nodeType!=1||table.nodeName.toLowerCase()!="table"))
		table = table.nextSibling;

	for(var i=1;i<arguments.length;i++)
	{
		document.getElementById(tableId).rows[1].cells[0].appendChild(document.getElementById(arguments[i]));
		if(i!=1)
		{
			document.getElementById(arguments[i]).style.display="none";
		}
		else
		{
			document.getElementById(arguments[i]).style.display="block";
		}
	}
	var args = arguments;
	for(var i=1;i<arguments.length;i++)
	{
		table.rows[0].cells[i*2-1].linkTab=args[i];
		table.rows[0].cells[i*2-1].onclick=function(){
			var tabbed = false;	
			for(var j=1;j<args.length;j++)
			{
				if(this.linkTab!=args[j])
				{
					
					document.getElementById(args[j]).style.display="none";
					table.rows[0].cells[j*2-1].className = "";
					if(!tabbed)
					{
						table.rows[0].cells[j*2-2].className = "tab_ul";
					}
					else
					{
						table.rows[0].cells[j*2].className = "tab_ur";
					}
				}
				else
				{
					table.rows[0].cells[j*2-1].className = "tab_sm";
					table.rows[0].cells[j*2-2].className = "tab_sl";
					table.rows[0].cells[j*2].className = "tab_sr";
					document.getElementById(args[j]).style.display="block";
					tabbed = true;
				}
			}
		}
	}
}
-->