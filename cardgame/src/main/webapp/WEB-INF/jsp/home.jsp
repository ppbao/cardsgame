<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
 
<!-- <script type="text/javascript" src="${ctxPath }/resources/jquery-1.7.2.min.js"></script>
 -->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${ctxPath }/resources/icon/favicon.ico">

    <title>Play card game </title>

    <!-- Bootstrap core CSS -->
    <link href="${ctxPath }/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${ctxPath }/resources/css/dashboard.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script type="text/javascript">
    
    
    
    </script>
    
    
  </head>

  <body>

      <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
           <a class="navbar-brand" href="#">Card game</a>
         
        </div>
        <div class="navbar-collapse collapse">
          
        </div><!--/.navbar-collapse -->
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <form method="get" action="${ctxPath}/newGame"> 
           <div class="form-group">
              <input type="number" name="numberOfPlayer" placeholder="Player Number" class="form-control">
            </div>
            <button type="submit" id ="btnSubmit" class="btn btn-success">Play</button>
          </form>
        </div><!--/.navbar-collapse -->
           
        </div>
      </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Card data After shuffling</h1>
             <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                  <th>Card</th>
                </tr>
              </thead>
              <tbody>
              <tr>
	        <c:forEach items="${cards}" var="item" varStatus="loop" step="1">
	        	<td><img src="${ctxPath}/resources/images/${item.text}.gif"</td>
	         <c:if test="${loop.count%12==0}"></tr><tr></c:if>
	        </c:forEach>
                </tr>
              </tbody>
            </table>
          </div>
          
          
          <div >
          <h1 class="page-header">Card data After dealt</h1>
             <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Round</th>
                  <th>Date</th>
                  <th>Player</th>
                  <th>First Card</th>
                  <th>Second Card</th>
                  <th>Third Card</th>
                  <th>win or draw</th>
                  <th>Winner</th>
                </tr>
              </thead>
              <tbody>
              <tr>
                <c:forEach items="${detailList}" var="item" varStatus="loop" step="1">
	      			<td>${item.gameHandRecord.id}</td>
	        	<td>${item.gameHandRecord.startDate}</td>
	            <td>${item.player.username}</td><td><img src="${ctxPath}/resources/images/${item.firstCard.text}.gif"</td>
	            <td><img src="${ctxPath}/resources/images/${item.secondCard.text}.gif"</td>
	            <td><img src="${ctxPath}/resources/images/${item.thirdCard.text}.gif"</td>
	            <td>${item.gameHandRecord.result}</td>
	            <td>${item.gameHandRecord.winner.username}</td>
	         </tr><tr> 
	         
	         </tr><tr> 
	        </c:forEach>
                </tr>
              </tbody>
            </table>
          </div>
          
          
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${ctxPath }/resources/js/jquery.min.js"></script>
    <script src="${ctxPath }/resources/bootstrap.min.js"></script>
    <script src="${ctxPath }/resources/js/docs.min.js"></script>
  </body>
</html>
