<r:script>
       $("#game").change(function(){
          var $this=$(this)

          var $gameContainer = $("div.game > .input-area");

          if($this.val() && $this.val()=='FLAMES') {
              var dom = "<div class='control'>"+
                                    "<h3>Enter 2 names and find out if they are meant to be!</h3>" +
                                    "<div>" +
                                        "<label>First Name:</label>" +
                                        "<input name='firstName' type='text'/>" +
                                    "</div>" +
                                    "<div>" +
                                        "<label>Second Name:</label>" +
                                        "<input name='secondName' type='text'/>" +
                                    "</div>" +
                                "</div>"

              $gameContainer.children().remove();
              $gameContainer.append($(dom));

          } else if ($this.val() && $this.val()=='FENG SHUI') {
              var dom = "<div class='control'>" +
                      "<h3>Dahil malapit na ang chinese new year... Ako si Madam PaoSio, gimme your chinese year of birth, and " +
                      "and I'll give you your chinese zodiac and some hula hula.</h3>" +
                      "<div>" +
                      "<label>Chinese birth year:</label>" +
                      "<input name='year' type='text'/>" +
                      "</div>" +
                      "</div>"
              $gameContainer.children().remove();
              $gameContainer.append($(dom));
          }

       });
</r:script>
<meta name="layout" content="main">
<title>Play a game</title>

<g:form controller="game" action="play">
    <h2>WordPlay!</h2>
    <div class="game">
        <div class="control">
            <label>Choose a game: </label>
            <g:select id="game" name="game" from="${games}" noSelection="[0:'Choose a game']"/>
        </div>

        <div class="input-area">

        </div>
        <div class="control">
            <g:submitButton name="submit" value="Go"/>
        </div>
    </div>
</g:form>