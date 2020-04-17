function initSelect(text,div)
{
	var inputBox = document.getElementById(text);
	var drowdown = document.getElementById(div);
	var drowTable = getFirstChildElement(drowdown);

	inputBox.selected = false;
	
	inputBox.onfocus=function(){
		var pos = calPos(inputBox);
		
		drowdown.style.top = pos.y + inputBox.offsetHeight;
		drowdown.style.width = inputBox.offsetWidth;
		drowdown.style.left = pos.x;
		drowdown.style.display = "block";
		this.selected = true;
	}
	
	inputBox.onblur=function(){
		if(drowTable.mouseoverTable)return false;
		inputBox.selected = false;
		drowdown.style.display = "none";
	}
	
	inputBox.onkeydown=function(e){
		var keynum;
		if(window.event) // IE
		{
			keynum = window.event.keyCode;
		}
		else if(e.which) // Netscape/Firefox/Opera
		{
			keynum = e.which;
		}
		
		
		if(keynum==38)
		{
			if(drowTable.selectedrow==null)
			{
				drowTable.selectedrow=0;
				drowTable.lastselectedrow=drowTable.rows.length;
			}
			drowTable.lastselectedrow = drowTable.selectedrow;
			drowTable.rows[drowTable.lastselectedrow].style.backgroundColor="";
			drowTable.selectedrow--;
			if(drowTable.selectedrow<0)
				drowTable.selectedrow=drowTable.rows.length-1;
			drowTable.rows[drowTable.selectedrow].style.backgroundColor="lightblue";
		}
		if(keynum==40)
		{
			if(drowTable.selectedrow==null)
			{
				drowTable.selectedrow=drowTable.rows.length-1;
				drowTable.lastselectedrow=drowTable.rows.length-1;
			}
			drowTable.lastselectedrow = drowTable.selectedrow;
			drowTable.rows[drowTable.lastselectedrow].style.backgroundColor="";
			drowTable.selectedrow++
			if(drowTable.selectedrow>=drowTable.rows.length)
				drowTable.selectedrow=0;
			drowTable.rows[drowTable.selectedrow].style.backgroundColor="lightblue";
		}
	}
	
	drowTable.onmouseover=function(){
		this.mouseoverTable = true;
	}
	
	drowTable.onmouseout=function(){
		this.mouseoverTable = false;
	}
	for(var i=0;i<drowTable.rows.length;i++)
	{
		drowTable.rows[i].onclick=function(){
			inputBox.value = this.cells[0].innerHTML;
			inputBox.selected = false;
			drowdown.style.display = "none";
		}
		drowTable.rows[i].onmouseover=function(){
			this.style.backgroundColor="lightblue";
		}
		drowTable.rows[i].onmouseout=function(){
			this.style.backgroundColor="";
		}
	}
}