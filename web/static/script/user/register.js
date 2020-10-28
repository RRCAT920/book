/**
 * 引入此文件前需要引入jQuery
 */
// 验证用户名：必须由字母，数字下划线组成，并且长度为 5 到 12 位
// 验证密码：必须由字母，数字下划线组成，并且长度为 5 到 12 位
// 验证确认密码：和密码相同
// 邮箱验证：xxxxx@xxx.com
// 验证码：现在只需要验证用户已输入。因为还没讲到服务器。验证码生成。
/**
 * 根据条件提示错误信息
 * @param pattern 正则表达式对象
 * @param value 测试的值
 * @param $object jQuery对象（用于设置文本）
 * @param msg 错误提示信息
 * @returns {boolean} 测试是否成功
 */
function prompt(pattern, value, $object, msg) {
    let isPass = pattern.test(value)
    if (isPass) $object.text("")
    else $object.text(msg)
    return isPass
}

$(function () {
    let $username = $("#username")
    let $password = $("#password")
    let $passwordConfirm = $("#repwd")
    let $email = $("#email")
    let $validateCode = $("#code")
    let $errorMsg = $(".errorMsg")

    let userNamePattern = /^\w{5,12}$/
    let passwordPattern = /^\w{5,12}$/
    // 一般域名的规律为“[N级域名][三级域名.]二级域名.顶级域名”
    // 字母、数字、下划线、-的正则表示为[\w-]
    // 汉字在正则表示为[\u4e00-\u9fa5]
    let emailPattern = /^[\u4e00-\u9fa5\w-]+@[\u4e00-\u9fa5\w-]+(\.[\u4e00-\u9fa5\w-]+)+$/

    // TODO change事件更好
    // 失去焦点时的验证
    $username.focusout(function () {
        prompt(userNamePattern, this.value, $errorMsg, "用户名不合法")
    })

    $password.focusout(function () {
        prompt(passwordPattern, this.value, $errorMsg, "密码不合法")
    })

    $passwordConfirm.focusout(function () {
        if (this.value === $password.val()) $errorMsg.text("")
        else $errorMsg.text("密码不一致")
    })

    $email.focusout(function () {
        prompt(emailPattern, this.value, $errorMsg, "邮箱不合法")
    })

    // 提交时的验证
    $("#sub_btn").click(function () {
        if (!prompt(userNamePattern, $username.val(), $errorMsg, "用户名不合法")) return false
        if (!prompt(passwordPattern, $password.val(), $errorMsg, "密码不合法")) return false
        if ($passwordConfirm.val() !== $password.val()) {
            $errorMsg.text("密码不一致")
            return false
        }
        if (!prompt(emailPattern, $email.val(), $errorMsg, "邮箱不合法")) return false
        let codeValue = $.trim($validateCode.val())
        if (codeValue === null || codeValue.length === 0) {
            $errorMsg.text("验证码不合法")
            return false
        }
        $errorMsg.text("")
    })
})