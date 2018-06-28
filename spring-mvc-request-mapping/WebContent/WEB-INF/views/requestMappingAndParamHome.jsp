<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>@RequestMapping and @RequestParam test bed</title>
<style>
input[type=text] {
	padding: 10px;
	margin: 10px;
	font-size: 20px;
}

input[type=submit] {
	border: none;
	background-color: green;
	color: white;
	padding: 16px;
	margin: 16px;
	cursor: pointer;
	font-size: 20px;
}

h2 {
	color: orange;
	text-align: center;
}
</style>
</head>
<body>
	<div align="left">
		<h2 align="center">Hello,welcome to @request(mapping and param)</h2>
		<hr />
		<form action="test1">
			<h3>test1: testing @requestParam</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" size="40"> <input type="submit"
				value="Submit">
		</form>
		<br /> <br />
		<form action="test2">
			<h3>test2: testing @requestMapping 'method' attribute</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" size="40"> <input type="submit"
				value="Submit">
		</form>
		<br /> <br />
		<form action="test3">
			<h3>test3: testing @requestMapping fall back</h3>
			<input type="submit" value="Submit">
		</form>
		<form action="test4">
			<h3>test4: testing @requestParam 'defaultValue' attribute</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" size="40"> <input type="submit"
				value="Submit">
		</form>
		<br /> <br />
		<form action="test5">
			<h3>test4: testing @requestParam without name or value attribute</h3>
			<label id="organization-name">Organization Name</label> <input
				type="text" name="orgname" size="40"> <input type="submit"
				value="Submit">
		</form>

	</div>


</body>
</html>