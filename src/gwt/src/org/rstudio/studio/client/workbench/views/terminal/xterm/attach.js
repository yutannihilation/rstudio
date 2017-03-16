/*
 MIT
*/
(function(c){"object"===typeof exports&&"object"===typeof module?module.exports=c(require("../../xterm")):"function"==typeof define?define(["../../xterm"],c):c(window.Terminal)})(function(c){var d={attach:function(a,b,c,d){c="undefined"==typeof c?!0:c;a.socket=b;a._flushBuffer=function(){a.write(a._attachSocketBuffer);a._attachSocketBuffer=null;clearTimeout(a._attachSocketBufferTimer);a._attachSocketBufferTimer=null};a._pushToBuffer=function(b){a._attachSocketBuffer?a._attachSocketBuffer+=b:(a._attachSocketBuffer=
b,setTimeout(a._flushBuffer,10))};a._getMessage=function(b){d?a._pushToBuffer(b.data):a.write(b.data)};a._sendData=function(a){b.send(a)};b.addEventListener("message",a._getMessage);if(c)a.on("data",a._sendData);b.addEventListener("close",a.detach.bind(a,b));b.addEventListener("error",a.detach.bind(a,b))},detach:function(a,b){a.off("data",a._sendData);(b="undefined"==typeof b?a.socket:b)&&b.removeEventListener("message",a._getMessage);delete a.socket}};c.prototype.attach=function(a,b,c){return d.attach(this,
a,b,c)};c.prototype.detach=function(a){return d.detach(this,a)};return d});
