chrome.app.runtime.onLaunched.addListener(function() {
    chrome.system.display.getInfo(function(info) {
	var display;
	for (var i = 0; i < info.length; i++) {
	    if (info[i].isPrimary) display = info[i];
	}
	chrome.app.window.create("index.html", {
	    outerBounds: {
		left: 0,
		top: 0,
		width: display.workArea.width,
		height: display.workArea.height - 200
	    },
	    frame: {
		color: "#2d2d2d",
		inactiveColor: "#2d2d2d"
	    }
	}, function(window) {
	    window.onClosed.addListener(function() {
		chrome.app.window.get("logo").close();
	    });
	});
	chrome.app.window.create("logo.html", {
	    id: "logo",
	    outerBounds: {
		left: 1024,
		top: display.workArea.height - 200,
		width: display.workArea.width - 1024,
		height: 200
	    },
	    frame: "none"
	});
    });
});