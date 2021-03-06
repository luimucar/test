<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Fiveware Test: Spring MVC + Ajax + Hibernate + mysql</title>

<c:url var="home" value="/" scope="request" />

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

<spring:url value="/resources/core/js/jquery.1.10.2.min.js"
	var="jqueryJs" />
<script src="${jqueryJs}"></script>
</head>

<nav class="navbar navbar-inverse">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Fiveware Test: Spring MVC + Ajax + Hibernate + mysql</a>
		</div>
	</div>
</nav>

<style>
.loader {
    border: 6px solid #f3f3f3; /* Light grey */
    border-top: 6px solid #3498db; /* Blue */
    border-radius: 50%;
    width: 40px;
    height: 40px;
    animation: spin 2s linear infinite;
    visibility:hidden;
}

@keyframes spin {
    0% { transform: rotate(0deg); }
    100% { transform: rotate(360deg); }
}

</style>

<div class="container" style="min-height: 500px">

<div id="spinner" class="loader"></div>
	<div class="starter-template">
		<h1>Data Form</h1>

		<div id="feedback">
		<h4>Ajax Response</h4><pre>{}</pre>
		</div>

		<form class="form-horizontal" id="search-form">
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Username</label>
				<div class="col-sm-10">
					<input type=text class="form-control" id="username">
				</div>
			</div>
			<div class="form-group form-group-lg" style="visibility:hidden;display:none">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="email">
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label">Houses</label>
				<div class="col-sm-10">
						<select class="form-control" id="houses">
						  <option>1</option>
						  <option>2</option>
						  <option>3</option>
						  <option>4</option>
						  <option>5</option>
						</select>
				</div>
			</div>

			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-10">
					<input type="checkbox" id="bike" value="Bike"> I have a bike
				</div>
			</div>
			<div class="form-group form-group-lg">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-10">
<div class="radio">
  <label>
    <input type="radio" name="option" id="optionsRadios1" value="option1" checked>
    Option one is this and that&mdash;be sure to include why it's great
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="option" id="optionsRadios2" value="option2">
    Option two can be something else and selecting it will deselect option one
  </label>
</div>
<div class="radio disabled">
  <label>
    <input type="radio" name="option" id="optionsRadios3" value="option3" disabled>
    Option three is disabled
  </label>
</div>

				</div>
			</div>



			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" id="bth-search"
						class="btn btn-primary btn-lg">Create</button>
				</div>
			</div>
		</form>

	</div>

</div>

<div class="container">
	<footer>
		<p>
		</p>
	</footer>
</div>

<script>
	jQuery(document).ready(function($) {

		$("#search-form").submit(function(event) {

			// Disble the search button
			enableSearchButton(false);

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			searchViaAjax();

		});

	});

	function searchViaAjax() {
$("#spinner").css("visibility","visible");

		var search = {}
		search["username"] = $("#username").val();
		search["email"] = $("#email").val();
		search["bike"] = $('#bike').is(":checked")?"1":"0";
		search["option"] = $('input[name=option]:checked', '#search-form').val();
		search["houses"] = $("#houses").val();

		console.log(JSON.stringify(search));
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "${home}search/api/getSearchResult",
			data : JSON.stringify(search),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				display(data);
			},
			error : function(e) {
				console.log("ERROR: ", e);
				display(e);
			},
			done : function(e) {
				console.log("DONE");
				enableSearchButton(true);
			}
		});

	}

	function enableSearchButton(flag) {
		$("#btn-search").prop("disabled", flag);
	}

	function display(data) {
	$("#spinner").css("visibility","hidden");
	
		var json = "<h4>Ajax Response</h4><pre>"
				+ JSON.stringify(data, null, 0) + "</pre>";
		$('#feedback').html(json);
	}
</script>

</body>
</html>