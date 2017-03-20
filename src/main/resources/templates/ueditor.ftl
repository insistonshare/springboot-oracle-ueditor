<html>
<head>
    <title>完整demo</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <script src="${request.contextPath}/scripts/jquery-1.6.2.min.js" type="text/javascript"></script>
    <link href="${request.contextPath}/scripts/miniui/themes/default/miniui.css" rel="stylesheet" type="text/css"/>
    <script src="${request.contextPath}/scripts/miniui/miniui.js" type="text/javascript"></script>
    <script src="${request.contextPath}/scripts/boot.js" type="text/javascript"></script>
    <script type="text/javascript" charset="utf-8" src="${request.contextPath}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${request.contextPath}/ueditor/editor_api.js"></script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div {
            width: 100%;
        }
    </style>
</head>
<body>
当前menudId为:<span id="menuId">${menuId!''}</span><br/>
<a class="mini-button" onclick="onClick" id="edit">编辑</a>
<a class="mini-button" onclick="onClick" id="save_view">保存并预览</a>
<div id="editor_edit">
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
<div id="editor_view">
</div>
<div id="btns">
    <div>
        <button onclick="getAllHtml()">获得整个html的内容</button>
        <button onclick="getContent()">获得内容</button>
        <button onclick="setContent()">写入内容</button>
        <button onclick="setContent(true)">追加内容</button>
        <button onclick="getContentTxt()">获得纯文本</button>
        <button onclick="getPlainTxt()">获得带格式的纯文本</button>
        <button onclick="hasContent()">判断是否有内容</button>
        <button onclick="setFocus()">使编辑器获得焦点</button>
        <button onmousedown="isFocus(event)">编辑器是否获得焦点</button>
        <button onmousedown="setblur(event)">编辑器失去焦点</button>

    </div>
    <div>
        <button onclick="getText()">获得当前选中的文本</button>
        <button onclick="insertHtml()">插入给定的内容</button>
        <button id="enable" onclick="setEnabled()">可以编辑</button>
        <button onclick="setDisabled()">不可编辑</button>
        <button onclick=" UE.getEditor('editor').setHide()">隐藏编辑器</button>
        <button onclick=" UE.getEditor('editor').setShow()">显示编辑器</button>
        <button onclick=" UE.getEditor('editor').setHeight(300)">设置高度为300默认关闭了自动长高</button>
    </div>
    <div>
        <button onclick="getLocalData()">获取草稿箱内容</button>
        <button onclick="clearLocalData()">清空草稿箱</button>
    </div>

    <div>
        <button onclick="createEditor()">
            创建编辑器
        </button>
        <button onclick="deleteEditor()">
            删除编辑器
        </button>
    </div>
</div>

<script type="text/javascript">
//----------------------------------------------------------------------------------------------------------
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
    var ue = UE.getEditor('editor');


    function isFocus(e) {
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e) {
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('插入html代码', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        console.log(UE.getEditor('editor').getAllHtml());
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
//        arr.push("使用editor.getContent()方法可以获得编辑器的内容");
//        arr.push("内容为：");
        console.log(UE.getEditor('editor').getContent())
        arr.push(UE.getEditor('editor').getContent());
        return arr.join("\n");
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
        arr.push("内容为：");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("使用editor.setContent('欢迎使用ueditor')方法可以设置编辑器的内容");
        UE.getEditor('editor').setContent('', isAppendTo);
//        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {
        //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
        arr.push("编辑器的纯文本内容为：");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
        arr.push("判断结果为：");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData() {
        alert(UE.getEditor('editor').execCommand("getlocaldata"));
    }

    function clearLocalData() {
//        UE.getEditor('editor').execCommand("clearlocaldata");
//        console.log("已清空草稿箱")
        UE.getEditor('editor').execCommand('insertHtml', null);
    }
//----------------------------------------------------------------------------------------------------------
    $(function () {
        $("#btns").hide();
        //默认加载该菜单帮助信息
        $.get("${request.contextPath}/helpInfo/" + $("#menuId").html(), function (data) {
            if (data != null) {
                $("#editor_edit").hide();
                $("#editor_view").show();
                $("#save_view").hide();
                $("#edit").show();
                $("#editor_view").html(data.content);
            } else {
                $("#editor_edit").show();
                $("#editor_view").hide();
                $("#save_view").show();
                $("#edit").hide();
            }
        }, "json");
    });

    mini.parse();
    function onClick(e) {
        var button = e.sender;
        var text = button.getText();
        if ("保存并预览" === text) {
            var content = ue.getContent();
            $.ajax({
                type: "POST",
                url: "${request.contextPath}/helpInfo",
                contentType: "application/json", //必须有
                dataType: "json", //表示返回值类型，不必须
                data: JSON.stringify({'content': content, 'menuId': $("#menuId").text()}),  //相当于 //data: "{'str1':'foovalue', 'str2':'barvalue'}",
                success: function (data) {
                    $("#editor_view").html("");
                    $("#editor_view").html(data.content);
                }
            });
            $("#editor_edit").hide();
            $("#editor_view").show();
            $("#save_view").hide();
            $("#edit").show();
        } else if ("编辑" === text) {
            setContent();
            $.get("${request.contextPath}/helpInfo/" + $("#menuId").html(), function (data) {
                UE.getEditor('editor').execCommand('insertHtml', data.content);
            }, "json");
            $("#editor_edit").show();
            $("#editor_view").hide();
            $("#save_view").show();
            $("#edit").hide();
        } else {
            console.log("error");
        }
    }
</script>
</body>
</html>