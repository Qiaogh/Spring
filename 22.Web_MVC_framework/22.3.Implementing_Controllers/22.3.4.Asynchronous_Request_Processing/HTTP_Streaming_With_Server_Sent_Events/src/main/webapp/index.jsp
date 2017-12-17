<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webjars/webix/3.1.0/webix.css">
    <script type="text/javascript" src="webjars/webix/3.1.0/webix_debug.js"></script>
    <style type="text/css">
        #tab {
            margin: 50px 10px;
            width: 320px;
            height: 400px;
        }
    </style>
</head>
<body>
    <div id="tab">
    </div>

</body>
</html>

<script type="text/javascript">
    function randomCells() {
        var size = parseInt( Math.random() * 100 );
        var cells = new Array( size );
        for ( var i = 0; i < size; i++ ) {
            var header = "List" + ( i + 1 );
            var id = "list" + ( i + 1 );
            cells[i] = {
                header: header,
                body: {
                    view: "list",
                    animate: true,
                    id: id,
                    type: {
                        height: 30
                    },
                    template: "<div style='padding-left:18px'> time: #time#</div>"
                }
            };
        }
        return cells;
    }

    function reg( id ) {
        var source = new EventSource( "/system/get?id=" + id );
        source.addEventListener( 'message', function( event ) {
            $$(id).add( JSON.parse( event.data ) );
        });
    }

    var cells = randomCells();

    webix.ready(function() {
        webix.ui({
            container: "tab",
            view: "tabview",
            cells: webix.copy( cells )
        });

        for ( var i = 0; i < cells.length; i++ ) {
            reg( cells[i].body.id );
        }
    });
</script>
