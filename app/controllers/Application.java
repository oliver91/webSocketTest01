package controllers;


import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import views.html.index;

public class Application extends Controller {

    // render index page
    public static Result index()
    {
        return ok(index.render());
    }

    // get the ws.scala.js script
    public static Result wsJs() {
        return ok(views.js.ws.render());
    }

    // Websocket interface
    public static WebSocket<String> wsInterface()
    {
        return new WebSocket<String>()
        {
            // called when websocket handshake is done
            public void onReady(WebSocket.In<String> in, WebSocket.Out<String> out){
                SimpleChat.start(in, out);
            }
        };
    }
}