function send() {
    const messageContainer = $(".message-container");
    const textInput = $("#input_area");
    const text = textInput.val();
    if (!text) {
        alert('请输入内容');
    }
    const datetime = dateFormat(new Date());
    console.log(datetime);

    const contentDOM = $("<div></div>").addClass("message-content").text(text);
    console.log(contentDOM.html());
    contentDOM.html(contentDOM.html().replace(/\n/g,'<br/>'));
    const datetimeDOM = $("<div></div>").addClass("message-datetime").text(datetime);
    const messageDOM = $("<div></div>").addClass("message").addClass("message-this");

    messageDOM.append(contentDOM);
    messageDOM.append(datetimeDOM);
    messageContainer.append(messageDOM);
    updateScroll();
    textInput.val('');
    setTimeout(receive, 1000);
}

function dateFormat(date) {
    const yyyy = date.getFullYear();
    const MM = date.getMonth() + 1;
    const dd = date.getDate();
    const HH = date.getHours()
    const mm = date.getMinutes();
    const ss = date.getSeconds();
    return yyyy + '-' + MM + '-' + dd + '-' + HH + ':' + mm + ':' + ss;
}

function updateScroll() {
    const message = document.getElementById('dialog_well');
    message.scrollTop = message.scrollHeight;
}

function receive() {
    const messageContainer = $(".message-container");
    const datetime = dateFormat(new Date());
    const text = "    const messageContainer = $(\".message-container\");\n    const messageContainer = $(\".message-c" +
        "ontainer\");\n    const messageContainer = $(\".message-container\");\n    const messageContainer = $(\".mess" +
        "age-container\");\n";

    const newMessage = "<div class=\"message message-that\">\n" +
        "<div class=\"message-content\">" + text + "</div>\n" +
        "<div class=\"message-datetime\">" + datetime + "</div></div>";
    messageContainer.append(newMessage);
    updateScroll();
}