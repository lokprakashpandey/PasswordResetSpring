<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Web MVC Project</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
        
    <body>
      <div class="container">
        <h1>Log In Form</h1>
        <form method="post" action="profile.htm">
            <div class="form-group">
                <label class="control-label col-sm-2">Username :</label>
                <div class="col-sm-10">
                <input type="text" class="form-control" name="username" placeholder="Enter username:" required>
                </div>
            </div>                                            
            <div class="form-group">
                <label class="control-label col-sm-2">Password :</label>
                <div class="col-sm-10">
                <input type="password" class="form-control" name="password" placeholder="Enter password:" required>
                </div>
            </div>
            
            <div class="form-group"> 
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-info" name="login" value="Log In">Log In</button>
                </div>
            </div>  
        </form>
      </div>
        <!-- Trigger the modal with a button -->
        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Forgot Password</button>
        <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
          <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
              <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Forgot Password</h4>
              </div>
              <div class="modal-body">
                  <form class="form-horizontal" method="post" action="passwordreset.htm">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Email :</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" placeholder="Enter email" required>
                        </div>
                    </div>
                    <div class="form-group"> 
                        <div class="col-sm-offset-3 col-sm-9">
                            <button type="submit" class="btn btn-info" name="send" value="Send Email">Send Email</button>
                        </div>
                    </div>
                  </form>
                </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
              </div>
            </div>
          </div>
        </div>
    </body>
</html>
