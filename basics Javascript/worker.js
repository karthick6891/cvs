function CustomWorker() {
    this.array = [];
    this.element = 0;
	this.fragment = "";
	this.process = "";
	this.context = "";
	this.callback ="";
	this.stream = function(){
		var todo = array.concat();	
		setTimeout(function(){

			var start = +new Date();

			do {
				 process.call(context, todo.shift(),element,fragment);
			} while (todo.length > 0 && (+new Date() - start < 50));

			if (todo.length > 0){
				setTimeout(arguments.callee, 25);
			} else {
				callback(array);
			}
		}, 25);  
	}
}


CustomWorker.prototype.start = function(key) {


};
CustomWorker.prototype.get = function(key) {

};

CustomWorker.prototype.put = function(key, value) {
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

CustomWorker.prototype.noOfInstances = function() {

	return this.count;
};

CustomWorker.prototype.killAll = function() {

};

CustomWorker.prototype.killInstance = function() {

    
};


