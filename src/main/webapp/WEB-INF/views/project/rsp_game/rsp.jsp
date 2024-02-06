<%@ page import="jakarta.websocket.Session" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/rsp_game/style.css" />
    <title>Rock & Scissors & Paper </title>
</head>
<body>
<div id="form">
    <img class="rock" src="/rsp_game/rock.png">
    <img class="scissors" src="/rsp_game/scissors.png">
    <img class="paper" src="/rsp_game/paper.png">
</div>
<hr/>
<hr/>
<ul id="count">

</ul>
<hr/>
<hr/>
<div id="result">
    <div id="you">
        <img src="/rsp_game/scissors.png">
        You
    </div>
    <div id="computer">
        <img src="/rsp_game/rock.png">
        Computer
    </div>
</div>

<script src="/rsp_game/script.js"></script>
</body>
</html>