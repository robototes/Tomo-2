document.onreadystatechange = function() {
    if (document.readyState !== "complete") return;
  
    window.N = new NetworkTable("DASHBOARD", "10.24.12.2");
    
    N.setCallback(update);
};

function update() {
    var el = document.querySelector("#charged");
    el.className = N.get("charged", false) ? "indicatorGREEN" : "indicatorOFF";
}