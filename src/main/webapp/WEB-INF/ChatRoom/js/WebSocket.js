let websocket = null;
const host = document.location.host;
const port = document.location.port;

let userId = null;

function webSocketInit(userIdArg) {
    userId = userIdArg;
    if ('WebSocket' in window) {
        websocket = new WebSocket('ws://' + host + '/webSocket/' + userId);

        websocket.onerror = function () {
            alert("WebSocket连接发生错误");
        };

        websocket.onopen = function () {
            // alert("WebSocket连接成功")
        };

        websocket.onmessage = function (event) {
            const messageStr = event.data;
            console.log("message:" + messageStr);
            const messageJSON = JSON.parse(messageStr);
            if (messageJSON.type === 'notify') {
                if (messageJSON.function === 'updateOnlineList') {
                    updateOnlineList(messageJSON.onlineUsers);
                }
            }
        };

        websocket.onclose = function () {
            // alert("WebSocket连接关闭");
        };


    } else {
        alert('Browser did not support websocket');
    }
}

window.onbeforeunload = function () {
    closeWebSocket();
};

function closeWebSocket() {
    websocket.close();
}

function sendMessage(content, target) {
    const message = {
        type: 'message',
        content: content,
        source: userId,
        target: target
    };
    websocket.send(JSON.stringify(message));
}

function receiveMessage() {

}

function updateOnlineList(onlineUsers) {
    let id, name;
    const userList = $("#user_list");
    for (let key in onlineUsers) {
        id = key;
        name = onlineUsers[key];
        let newLine = $("<li></li>").text(name);
        userList.append(newLine);
    }
}





