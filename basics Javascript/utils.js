function isDesktop()
{
  var os = navigator.platform.toLowerCase();
	var ua = navigator.userAgent.toLowerCase();
 
	// find the quickie givaways that it's not on desktop, if any of the big 4 desktop OS's make mobile
	// stuff, it'll almost surely have one of these keywords in the userAgent or platform string
	var easyregex = /mobi(le)?|tablet|phone|palm|pocket|handheld|e?book|reader|ip(ad|od|hone)|android|blackberry|playbook|webos|windows ce/;
	if (easyregex.test(os) || easyregex.test(ua)) return false;
 
	// now try to detect the desktop environments: windows, mac, unix, or linux, and
	// if it is them but it didn't trip the above regex then it's likely not a mobile...
	// chromebook os is linux and matches linux on the platform string, so catches that too
	var osregex = /linux|unix|^win|^mac/;
	if (osregex.test(os)) return true;
 
	// if the easy regex failed, and is not one of the big desktop OS's, then lastly test for the touch feature. The above 2 will
	// correctly determine most PAST devices as of this writing, this will correctly determine most FUTURE devices but fails on
	// many past ones (which is why it's 3rd rather than 1st...normally a feature detection method would go first)
	if (!!('ontouchstart' in window)) return false;
 
	// if not linux/unix/win/mac but didn't trip the top regex then return the last option...which is
	// ...that it's undefined and unsure! This way the function caller can figure out what they want to do in this case...likely its a mobile though...
	var _undefined;
	return _undefined;
}
