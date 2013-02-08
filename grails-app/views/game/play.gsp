<meta name="layout" content="main">
<title>Result</title>

<h2>Here are your results:</h2>
<div>
    <div class="control">
        Game: ${game}
    </div>
    <g:each in="${results}" var="result">
        <div class="control">
            ${result}
        </div>

    </g:each>
    <div class="control">
        <g:link controller="game" action="index">Back to game</g:link>
    </div>
</div>