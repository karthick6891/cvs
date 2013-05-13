/**
* Homepage js
**/

_.templateSettings = {
    interpolate: /\<\@\=(.+?)\@\>/gim,
    evaluate: /\<\@([\s\S]+?)\@\>/gim,
    escape: /\<\@\-(.+?)\@\>/gim
};

var events = [
        {eventName:"Edge conference in Berlin on 27th April,2013"},
        {eventName:"Adobe Max conference in Seattle on 30th April,2013"},
        {eventName:"Edge conference in Stutgart on 27th April,2013"},
        {eventName:"Adobe Max conference in California on 30th April,2013"}
 ];
var template = $("#eventListTemplate").html();
$("#eventListTarget").html(_.template(template,{events:events}));