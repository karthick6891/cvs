function CustomWorker(array,process,callback) {
	/* Need to Implement Singleton
	this.instance = this;
	this.instances = [];
	*/
	this.name="";
	this.stream = (function(){	
			var todo = array.concat();
			var timer;
				return{				
				start:function(){
						console.log("this.name" + this.name)
						timer = setTimeout(function(){
						var start = +new Date();
						do {
							 process.call(null, todo.shift());
						} while (todo.length > 0 && (+new Date() - start < 50));
						if (todo.length > 0){
							console.log("arguments"+ arguments);
							setTimeout(arguments.callee, 25);
						} else {
						console.log("callaback"+ array);
							callback(array);
						}
					}, 25);
				},
				kill:function(){
					todo = [];	
					clearTimeout(timer);
				}
			}
	})();
}

CustomWorker.prototype.name = function(name){
	this.name = name;
}

CustomWorker.prototype.start = function() {
	this.stream.start();
};
CustomWorker.prototype.kill = function() {
	this.stream.kill();
};
/* Singelton Class should be created to manage this part
CustomWorker.prototype.noOfInstances = function() {

	return this.instances.length;
};

CustomWorker.prototype.killAll = function() {

};

CustomWorker.prototype.killInstance = function() {

    
};
*/

