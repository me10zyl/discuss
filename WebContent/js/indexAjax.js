var noEmailError = true;
var noNickNameError = true;
var noPasswordError = true;
var noPasswordConfirmError = true;
var clickOne = false;
var ids = ['user_email','user_nickname','user_password','user_password_confirm'];

$(function(){
	
	$('body').on('blur', '#'+ids[0], function() {
		if(noNickNameError && noPasswordError && noPasswordConfirmError)
			noEmailError = check($('#'+ids[0]), ids[0],'login!checkEmail',getEmailResult);
		clickOne = true;
	})
	$('body').on('blur', '#'+ids[1], function() {
		if(noEmailError && noPasswordError && noPasswordConfirmError)
			noNickNameError = check($('#'+ids[1]), ids[1],'login!checkNickname',getNickNameResult);
		clickOne = true;
	})
	$('body').on('blur', '#'+ids[2], function() {
		if(noEmailError && noNickNameError && noPasswordConfirmError)
			noPasswordError = check($('#'+ids[2]), ids[2],'login!checkPassword',getPasswordResult);
		clickOne = true;
	})
	$('body').on('blur', '#'+ids[3], function() {
		if(noEmailError && noNickNameError && noPasswordError)
			noPasswordConfirmError = check($('#'+ids[3]), ids[3],'login!checkPasswordconfirm',getPasswordConfirmResult);
		clickOne = true;
	})
	/*for(var i = 0;i < ids.length;i++)
	{
		var right = ids[i].split('_')[1];
		if(ids[i].split('_').length > 2)
		{
			right = right + ids[i].split('_')[2];
		}
		right = right.substring(0,1).toUpperCase() + right.substring(1);
		var id = ids[i];
		alert('#'+id +" | login!check" + right);
		$('body').on('blur', '#'+id, function() {
			check($('#'+id), id,'login!check' + right);
		})
	}*/
})
function getEmailResult(res)
{
	noEmailError  = res;
}
function getNickNameResult(res)
{
	noNickNameError = res;
}
function getPasswordResult(res)
{
	noPasswordError = res;
}
function getPasswordConfirmResult(res)
{
	noPasswordConfirmError = res;
}

function check(inputJQ, formName, url,callback)
{
		$.ajax(url, {
			success : function(data) {
				var json = JSON.parse(data.trim());
				var gouId = formName + "Gou";
				var regMsgId = formName + "RegMsg";
				var str = "<img id='"+gouId+"' src='_path_' style='position:relative;bottom:-6px;right:-7px;'/><br><font color='red' size='2px'><span id='"+regMsgId+"' style='position:relative;right:-7px;'>"+json.message+"</span></font>";
				var gouJQ = $('#'+gouId);
				var regMsgJQ = $('#'+regMsgId);
				var res = json.result;
				if(json.result)
				{
					if(gouJQ.length <= 0)
					{
						str = str.replace("_path_","images/greenGou.png");
						inputJQ.after(str);
						regMsgJQ.text(json.message);
					}else
					{
						gouJQ.attr('src','images/greenGou.png');
						regMsgJQ.text(json.message);
					}
				}else
				{
					if(gouJQ.length <= 0)
					{
						str = str.replace("_path_","images/redCha.png");
						inputJQ.after(str);
						regMsgJQ.text(json.message);
					}else
					{
						gouJQ.attr('src','images/redCha.png');
						regMsgJQ.text(json.message);
					}
				}
				callback(res);
			},
			data : (formName == 'user_password' || formName == 'user_password_confirm') ? 'user_password='+ $('#user_password').val() +'&' + 'user_password_confirm='+ $('#user_password_confirm').val() : formName + "="+inputJQ.val(),
			type : 'post'
		})
		
}
function register()
{
	if(!clickOne)
		alert('还冇填写信息呢!');
	else if(noEmailError  && noNickNameError && noPasswordError && noPasswordConfirmError)
	{
		$.ajax({
				url : "login!register" ,
				data : ids[0]+ '=' + $('#'+ids[0]).val() + '&' + ids[1]+'=' + $('#'+ids[1]).val() + '&' +ids[2]+'=' + $('#'+ids[2]).val() + '&' +ids[3]+'=' + $('#'+ids[3]).val() ,
				success : function(data)
				{
					var json = JSON.parse(data);
					if(json.result)
					{
						alert('注册成功!');
						 $("#register").remove();
						 $("#mask").remove();
					}else
					{
						alert('注册失败!'+json.message);
					}
				}
			})
	}
	else
		alert('还冇全打勾奥!');
}

function login(){
	var user_email = 'login_' + ids[0];
	var user_password = 'login_' + ids[2];
	$.ajax({
		url : "login!login" ,
		data : ids[0]+ '=' + $('#'+user_email).val() + '&' +ids[2]+'=' + $('#'+user_password).val(),
		success : function(data)
		{
			var json = JSON.parse(data);
			if(json.result)
			{
				loginsuccuss();
			}else
			{
				alert(json.message);
			}
		}
	})
}

function loginsuccuss()
{
	location.href = 'topic!scanTopicList';
}