/*
MIT LICENSE
Copyright (c) 2007 Monsur Hossain (http://www.monsur.com)

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
*/
/**
*Removed purging facility and the priority facility to make the cache light weight
*
*/


function Cache(maxSize) {
    this.items = {};
    this.count = 0;
    this.stats = {};
    this.stats.hits = 0;
    this.stats.misses = 0;
}


Cache.prototype.getItem = function(key) {

    // retrieve the item from the cache
    var item = this.items[key];
   
    var returnVal = null;
    if (item != null) {
        returnVal = item.value;
        this.stats.hits++;
    } else {
        this.stats.misses++;
    }
    return returnVal;
};
Cache.prototype.setItem = function(key, value) {

    function CacheItem(k, v) {
        if ((k == null) || (k == ''))
            throw new Error("key cannot be null or empty");
        this.key = k;
        this.value = v;
    }

    // add a new cache item to the cache
    if (this.items[key] != null){
		console.log("Yes present");
        this._removeItem(key);
		 this._addItem(new CacheItem(key, value));
		}
    this._addItem(new CacheItem(key, value));
};

Cache.prototype.clear = function() {

    // loop through each item in the cache and remove it
    for (var key in this.items) {
      this._removeItem(key);
    }  
};

Cache.prototype._addItem = function(item) {
    this.items[item.key] = item;
    this.count++;
};

Cache.prototype._removeItem = function(key) {
    var item = this.items[key];
    delete this.items[key];
    this.count--;    
  
};

Cache.prototype.toHtmlString = function() {
    var returnStr = this.count + " item(s) in cache<br /><ul>";
    for (var key in this.items) {
        var item = this.items[key];
        returnStr = returnStr + "<li>" + item.key.toString() + " = " + item.value.toString() + "</li>";
    }
    returnStr = returnStr + "</ul>";
    return returnStr;
};
