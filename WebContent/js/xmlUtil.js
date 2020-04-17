function evaluateXPath(doc,xPath,node)
{
	if(Sys.ie==null){
		var nodes = doc.evaluate(xPath,node,null,XPathResult.ORDERED_NODE_SNAPSHOT_TYPE,null);
		nodes.length = nodes.snapshotLength;
		nodes.item = function(i){
			return this.snapshotItem(i);
		}
		return nodes;
	}
	else{
		return node.selectNodes(xPath);
	}
}

function createDoc()
{
	var doc;
	if(window.ActiveXObject) {
        doc = new ActiveXObject("MSXML2.DOMDocument");
    }else if(window.Document) {
        doc = document.implementation.createDocument("","",null);
		doc.async="false";
    }
	return doc;
}