document.onreadystatechange = function() {
    if (document.readyState !== "complete") return;
  
    window.N = new NetworkTable("DASHBOARD", "10.24.12.2");
    N.connect();
    var id = setInterval(function() {
       if (N.isConnected())  {
           N.setCallback(update);
           clearInterval(id)
       }
    });
};

function update() {
    var el = document.querySelector("#charged");
    el.className = N.get("charged", false) ? "indicatorGREEN" : "indicatorOFF";
}
