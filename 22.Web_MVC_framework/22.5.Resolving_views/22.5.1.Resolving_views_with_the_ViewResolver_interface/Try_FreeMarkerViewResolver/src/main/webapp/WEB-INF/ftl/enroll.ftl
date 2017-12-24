<#import "/spring.ftl" as spring/>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>学生注册表单 - yiibai.com</title>
    <link href="/static/css/bootstrap.css" rel="stylesheet"></link>
    <link href="/static/css/custom.css" rel="stylesheet"></link>
</head>

<body>

<div class="form-container">

    <h1>登录</h1>

    <form method="POST" action="/login" class="form-horizontal">
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">用户名：</label>
                <div class="col-md-7">
                    <@spring.formInput "user.name" "class='form-control input-sm'" "text" />
                    <!--<input type="input" path="name" id="name" class="form-control input-sm"/>-->
                    <div class="has-error">
                        <@spring.showErrors "" />
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="password">密码：</label>
                <div class="col-md-7">
                    <@spring.formInput "user.password" "class='form-control input-sm'" "password" />
                    <!--<input type="password" path="password" id="password" class="form-control input-sm"/>-->
                    <div class="has-error">
                        <@spring.showErrors "" />
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-actions floatRight">
                <input type="submit" value="Login" class="btn btn-primary btn-sm">
            </div>
        </div>
    </form>
</div>
</body>
</html>