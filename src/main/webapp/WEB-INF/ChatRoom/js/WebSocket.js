let websocket = null;
const host = document.location.host;
// const userid ;


if ('WebSocket' in window) {
    websocket = new WebSocket('ws://' + host + '/webSocket/' + userid);

    websocket.onerror = function () {
        alert("WebSocket连接发生错误");
    };

    websocket.onopen = function () {
        alert("WebSocket连接成功")
    };

    websocket.onmessage = function (event) {
        alert("这是后台推送的消息：" + event.data);
    };

    websocket.onclose = function () {
        alert("WebSocket连接关闭");
    };

    window.onbeforeunload = function () {
        closeWebSocket();
    };

    function closeWebSocket() {
        websocket.close();
    }
} else {
    alert('Browser did not support websocket');
}




