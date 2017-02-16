var stompClient = null;
var stompClientGraph = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/skc-test');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/message', function (message) {
            showGreeting(JSON.parse(message.body));
        });
    });
}

function connectGraph() {
    var socket = new SockJS('/graph');
    stompClientGraph = Stomp.over(socket);
    stompClientGraph.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClientGraph.subscribe('/topic/graph', function (message) {
        	graphValue(JSON.parse(message.body));
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function disconnectGraph() {
    if (stompClientGraph != null) {
    	stompClientGraph.disconnectGraph();
    }
    //TODO disonnect tricks
    //setConnected(false);
    console.log("Disconnected");
}

	
function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val(),'from':'Client'}));
}

function getGraphData() {
	stompClientGraph.send("/app/graph", {},JSON.stringify({'from':'Test','name':'_Blank'}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message.message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
   
    $( "#showGraph" ).click(function() { connectGraph(); getGraphData();});
    $( "#removeGraph" ).click(function() { disconnectGraph(); });
 
});


function graphValue(value){
	var plot1 = $.jqplot('pie1', [[value]], {
        gridPadding: {top:0, bottom:38, left:0, right:0},
        seriesDefaults:{
            renderer:$.jqplot.PieRenderer, 
            trendline:{ show:false }, 
            rendererOptions: { padding: 8, showDataLabels: true }
        },
        legend:{
            show:true, 
            placement: 'outside', 
            rendererOptions: {
                numberRows: 1
            }, 
            location:'s',
            marginTop: '15px'
        }       
    });
}
