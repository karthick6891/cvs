function HashMap(requestUrl) {
    this.items = {};
    this.count = 0;
	this.requestUrl = requestUrl;
}

HashMap.prototype.get = function(key) {
console.log("Map get");
    var item = this.items[key];
    var returnVal = null;
    if (item != null) {
        returnVal = item.value;       
    } 
    return returnVal;
};

HashMap.prototype.put = function(key, value) {
    function map(k, v) {
        if (k!=null){            
        this.key = k;
        this.value = v;
		}
    }
	//Update map
    if (this.items[key] != null){
        this._removeItem(key);
		this._addItem(new map(key, value));
		}
    this._addItem(new map(key, value));
};

HashMap.prototype.length = function() {
	return this.count;
};

HashMap.prototype.clear = function() {
	this.items = {};
	this.count = 0;
};

HashMap.prototype._addItem = function(item) {
    this.items[item.key] = item;
    this.count++;
	var x = item;
	//console.log("Item cached" + item.key + x);
};

HashMap.prototype._removeItem = function(key) {
    var item = this.items[key];
    delete this.items[key];
    this.count--;    
};

HashMap.prototype.syncMap = function(key,requestUrl) {
//TODO: update entry in server.
};

HashMap.prototype.getIndex = function(key) {

}
