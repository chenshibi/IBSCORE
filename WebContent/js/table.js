function setTableHook(table)
{
	if(table.tBodies[0]!=null&&table.tBodies[0].rows.length!=0)
	{
		for(var i=0;i<table.tBodies[0].rows.length;i++)
		{
			table.tBodies[0].rows[i].onclick=function()
			{
				if(this._selected!=true)
				{
					if(this.parentNode._selected!=true)
					{
						this._original_backgroundColor=this.style.backgroundColor;
						this._original_onmouseover=this.onmouseover;
						this._original_onmouseout=this.onmouseout;
						this.style.backgroundColor="lightblue";
						this.onmouseover=null;
						this.onmouseout=null;
						this._selected=true;
						this.parentNode._selected=true;
					}
				}
				else
				{
					this.style.backgroundColor=this._original_backgroundColor;
					this.onmouseover=this._original_onmouseover;
					this.onmouseout=this._original_onmouseout;
					this._selected=false;
					this.parentNode._selected=false;
				}
			}
		}
	}
	alert(table);
	if(table.tHead!=null&&table.tHead.rows.length==1)
	{
		
		for(var i=0;i<table.tHead.rows[0].cells.length;i++)
		{
			var cell = table.tHead.rows[0].cells[i];
			cell.onclick=function(){
				alert("!");
				if(cell.columnName==null)
				{
					cell.columnName = cell.innerHTML;
					cell.columnOrder = "up";
				}
				switch(cell.columnOrder)
				{
				case "up":
					cell.innerHTML = cell.columnName+"\u2193";
					cell.columnOrder = "down";
					break;
				case "down":
					cell.innerHTML = cell.columnName+"\u2191";
					cell.columnOrder = "normal";
					break;
				case "normal":
					cell.innerHTML = cell.columnName;
					cell.columnOrder = "up";
					break;
				}
			}
		}
	}
}