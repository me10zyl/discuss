<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <link href="style/login_before.css" rel="stylesheet">
    <link href="style/LoginRegMask.css" rel="stylesheet"/>
</head>
<body>
<s:action name="login!getHeader" executeResult="true" namespace="/"></s:action>
<div id="main_body">
   <div class="bar">
       <select class="choiceList choiceListShow">
           <option >&nbsp;&nbsp;&nbsp;所有主题</option>
           <option class="thrGuoKill">&nbsp;&nbsp;&nbsp;三国杀</option>
           <option class="wolfNight">&nbsp;&nbsp;&nbsp;狼人之夜</option>
           <option class="godWay">&nbsp;&nbsp;&nbsp;神仙道</option>
           <option class="whoIsSpy">&nbsp;&nbsp;&nbsp;谁是卧底</option>
           <option class="thrGuoZhi">&nbsp;&nbsp;&nbsp;三国智</option>
           <option class="smellPigCharles">&nbsp;&nbsp;&nbsp;小猪查理</option>
           <option class="Uno">&nbsp;&nbsp;&nbsp;优诺牌</option>
           <option class="dobuleSpy">&nbsp;&nbsp;&nbsp;双重间谍</option>
           <option class="dreamFactory">&nbsp;&nbsp;&nbsp;梦工厂</option>
           <option class="mainWord">&nbsp;&nbsp;&nbsp;核心世界</option>
           <option class="cardIsland">&nbsp;&nbsp;&nbsp;卡坦岛</option>
           <option class="flySkyThief">&nbsp;&nbsp;&nbsp;飞天大盗</option>
       </select>
       <div class="latestTopic">最新主题</div>
   </div>
    <div class="listShow">
        <table class="listTab">
            <tr class="tabstyle" align="center">
                <th>主题</th> <th>种类</th> <th>用户</th> <th>回复数</th> <th>浏览数</th> <th>活跃时间</th>
            </tr>
            <tr class="tabstyleBg" align="center">
                <td align="center"><a href="topic_single.html">来谈谈狼人之夜你们怎么玩？</a></td>
                <td class="wolfNight">狼人之夜</td>
                <td><a href="profile_me.html"><img src="images/pic2.jpg"></a><a href="profile_me.html"><img src="images/pic3.jpg"></a><a href="profile_me.html"><img src="images/pic4.jpg"></a></td>
                <td>4</td>
                <td>20</td>
                <td title="Aug'10,2013 07:54">3m</td>
            </tr>
            <tr class="tabstyle" align="center">
                <td align="center"><a href="topic_single.html">来谈谈三国杀你们怎么玩？</a></td>
                <td class="thrGuoKill">三国杀</td>
                <td><a href="profile_me.html"><img src="images/pic5.jpg"></a><a href="profile_me.html"><img src="images/pic1.jpg"></a><a href="profile_me.html"><img src="images/pic3.jpg"></a></td>
                <td>3</td>
                <td>15</td>
                <td title="Aug'10,2013 07:54">10h</td>
            </tr>
            <tr class="tabstyleBg" align="center">
                <td align="center"><a href="topic_single.html">大家通常都玩些什么呢？</a></td>
                <td class="godWay">神仙道</td>
                <td><a href="profile_me.html"><img src="images/pic9.jpg"></a></td>
                <td>3</td>
                <td>30</td>
                <td title="Apr'3,2013 07:54">Apr'3</td>
            </tr>
            <tr class="tabstyle" align="center">
                <td align="center"><a href="topic_single.html">来看这一局有意思。。</a></td>
                <td class="dobuleSpy">双重卧底</td>
                <td><a href="profile_me.html"><img src="images/pic8.jpg"></a><a href="profile_me.html"><img src="images/pic2.jpg"></a><a href="profile_me.html"><img src="images/pic11.jpg"></a><a href="profile_me.html"><img src="images/pic12.gif"></a></td>
                <td>10</td>
                <td>100</td>
                <td title="May'15,2013 07:54">May'15</td>
            </tr>
            <tr class="tabstyleBg" align="center">
                <td align="center"><a href="topic_single.html">曾艺伦会玩桌游吗</a></td>
                <td class="Uno">优诺牌</td>
                <td><a href="profile_me.html"><img src="images/pic6.gif"></a><a href="profile_me.html"><img src="images/pic5.jpg"></a></td>
                <td>4</td>
                <td>20</td>
                <td title="May'10,2015 14:35">May'10</td>
            </tr>
            <tr class="tabstyle" align="center">
                <td align="center"><a href="topic_single.html">北京天安门这边喜欢玩桌游的吗。。</a></td>
                <td class="smellPigCharles">小猪查理</td>
                <td><a href="userpic"><img src="images/pic3.jpg"></a><a href="profile_me.html"><img src="images/pic12.gif"></a><a href="profile_me.html"><img src="images/pic11.jpg"></a></td>
                <td>16</td>
                <td>34</td>
                <td title="May'8,2015 14:35">May'8</td>
            </tr>
            <tr class="tabstyleBg" align="center">
                <td align="center"><a href="topic_single.html">来谈谈三国杀你们怎么玩？</a></td>
                <td class="godWay">神仙道</td>
                <td><a href="profile_me.html"><img src="images/pic2.jpg"></a><a href="profile_me.html"><img src="images/pic3.jpg"></a><a href="profile_me.html"><img src="images/pic4.jpg"></a></td>
                <td>4</td>
                <td>20</td>
                <td title="May'8,2015 14:35">3m</td>
            </tr>
            <tr class="tabstyle" align="center">
                <td align="center"><a href="topic_single.html">一起相约成都桌游馆</a></td>
                <td class="cardIsland">卡坦岛</td>
                <td><a href="profile_me.html"></a><img src="images/pic5.jpg"><a href="profile_me.html"><img src="images/pic1.jpg"></a><a href="profile_me.html"><img src="images/pic3.jpg"></a></td>
                <td>3</td>
                <td>15</td>
                <td title="May'8,2015 14:35">10h</td>
            </tr>
            <tr class="tabstyleBg" align="center">
                <td align="center"><a href="topic_single.html">其实郭珊不会玩桌游</a></td>
                <td class="dreamFactory">梦工厂</td>
                <td><a href="profile_me.html"><img src="images/pic2.jpg"></a></td>
                <td>3</td>
                <td>30</td>
                <td title="Apr'3,2013 14:35">Apr'3</td>
            </tr>
            <tr class="tabstyle" align="center">
                <td align="center"><a href="topic_single.html">来看这一局有意思。。</a></td>
                <td class="flySkyThief">飞天大盗</td>
                <td><a href="profile_me.html"><img src="images/pic8.jpg"></a><a href="profile_me.html"><img src="images/pic2.jpg"></a><a href="profile_me.html"><img src="images/pic11.jpg"></a><a href="profile_me.html"><img src="images/pic12.gif"></a></td>
                <td>10</td>
                <td>100</td>
                <td title="May'15,2012 14:35">May'15</td>
            </tr>
        </table>
        <div class="noTopic">这儿没有更多的主题了！</div>
    </div>

</div>
<s:action name="category!getFooter" executeResult="true" namespace="/"></s:action>

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/LoginRegMask.js" type="text/javascript"></script>
<script>
    $(function(){
        $(".choiceList").bind("change",function(){
            if($(this).val()=="三国杀"){
                $(this).css("color","dodgerblue");
            }else if($(this).val()=="狼人之夜"){
//                $(this).addClass("wolfNight");
                $(this).css("color","#29e96b");
            }else if($(this).val()=="神仙道"){
//                $(this).addClass("godWay");
                $(this).css("color","#f264ff");
            }else if($(this).val()=="谁是卧底"){
//                $(this).addClass("whoIsSpy");
                $(this).css("color","#0d14e2");
            }else if($(this).val()=="三国智"){
//                $(this).addClass("thrGuoZhi");
                $(this).css("color","#e21f6b");
            }else if($(this).val()=="小猪查理"){
//                $(this).addClass("smellPigCharles");
                $(this).css("color","#cc9c6a");
            }else if($(this).val()=="优诺牌"){
//                $(this).addClass("Uno");
                $(this).css("color","#ff4c8a");
            }else if($(this).val()=="双重间谍"){
//                $(this).addClass("dobuleSpy");
                $(this).css("color","#2ddad0");
            }else if($(this).val()=="梦工厂"){
//                $(this).addClass("dreamFactory");
                $(this).css("color","#e88a39");
            }else if($(this).val()=="核心世界"){
//                $(this).addClass("mainWord");
                $(this).css("color","#9244ca");
            }else if($(this).val()=="卡坦岛"){
//                $(this).addClass("cardIsland");
                $(this).css("color","#e2da2b");
            }else if($(this).val()=="飞天大盗"){
//                $(this).addClass("flySkyThief");
                $(this).css("color","#e21081");
            }else{
                $(this).css("color","#868686");
            }
        });
    });
</script>

</body>
</html>