function login() {
    const idInput = $("#id_input");
    const passwordInput = $("#password_input");
    const id = idInput.val();
    const password = passwordInput.val();

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