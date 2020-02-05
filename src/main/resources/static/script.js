function devSelect() {
    $('#ajaxLoader').show();
    var defaultOption = $("#listOfDevs option[value='default']");
    // if (defaultOption) {
    if(document.getElementById("defVal")) {
        if(!document.getElementById("defVal").selected) {
            defaultOption.remove();
            var chosenDev = $('#listOfDevs').val();
            var url = "/getDev/" + chosenDev;
            $.get(url, populateDevInfo);
        }
    } else {
        var chosenDev = $('#listOfDevs').val();
        var url = "/getDev/" + chosenDev;
        $.get(url, populateDevInfo);
    }

}

function populateDevInfo(data) {
    var status = data.responseStatus;
    if (status == "Ok") {
        var response = data.response;
        var size = response.rpiDevDTOS.length;
        console.log(size);
        if (size > 0) {
            populateTempBoxes(response);
        }
        if (size == 0) {
            document.getElementById('tempSensor').style.display = 'none';
        }
        var hostname = response.hostname;
        $('#chosenName').val(hostname);
        $('#ajaxLoader').hide();
    }
}

setInterval(devSelect, 60000);

function populateTempBoxes(data) {
    var tempSensor = document.getElementById('tempSensor');
    tempSensor.innerHTML = "<h2>Temperature sensors</h2>";
    var arr = data.rpiDevDTOS;
    var i;
    for (i = 0; i < arr.length; i++) {
        var nodeName = document.createElement("INPUT");
        nodeName.setAttribute("type", "text");
        nodeName.setAttribute("id", "node" + i);
        nodeName.setAttribute("disabled", "true");
        nodeName.setAttribute("value", arr[i].name + " " + arr[i].latestTemp.sensor_data + " [°C]");
        document.getElementById("tempSensor").appendChild(nodeName);
    }
    document.getElementById('tempSensor').style.display = 'block';


}