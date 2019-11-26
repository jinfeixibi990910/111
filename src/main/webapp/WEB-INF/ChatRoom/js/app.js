function login() {
    const idInput = $("#id_input");
    const passwordInput = $("#password_input");
    const id = idInput.val();
    const password = passwordInput.val();

    if (!loginValidate(id, password)) {
        return;
    }
    $.ajax({
        url: 'user/login',
        type: 'POST',
        data: {
            id: id,
            password: password
        },
        success: function (responseText) {
            if ('false' === responseText) {
                alert('登录失败');
            } else if ('true' === responseText) {
                location.reload();
            }
        }
    });
}

function loginValidate(id, password) {
    if (!id) {
        alert('ID不能为空！');
        $("#id_input").focus();
        return false;
    }

    if (!password) {
        alert('密码不能为空！');
        $("#password_input").focus();
        return false;
    }
    return true;
}

function logout() {
    $.ajax({
        url: 'user/logout',
        type: 'POST',
        success: function (responseText) {
            if ('true' === responseText) {
                location.reload();
            } else {
                alert('登出失败！');
            }
        }
    });
}

