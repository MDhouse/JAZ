<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JAVA 4 US!</title>
</head>
<body>

<h1>Zgloszenie na konferencje</h1>

<form action="AddParticipant" method="get">
<table>
<tr><td>Imie:</td><td><input type="text" name ="firstName"/></td></tr>
<tr><td>Nazwisko:</td><td><input type="text" name ="lastName"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Potwierdz email:</td><td><input type="email" name="emailAuthenticate"/></td></tr>
<tr><td>Nazwa pracodawcy:</td><td><input type="text" name="superior"/></td></tr>
<tr><td>Skad dowiedziales sie o konferencji:</td></tr>
<tr><td></td><td><input name="info" type="radio" value="Ogloszenie w pracy"/> Ogloszenie w pracy</td></tr>
<tr><td></td><td><input name="info" type="radio" value="Ogloszenie na uczelni"/> Ogloszenie na uczelni</td></tr>
<tr><td></td><td><input name="info" type="radio" value="Facbook"/> Facbook</td></tr>
<tr><td></td><td><input name="info" type="radio" value="Znajomi"/> Znajomi</td></tr>
<tr><td></td><td><input name="info" type="radio" value="Inne(Jakie?)" onclick="this.form.elements['info'].disabled = !this.checked"/> Inne(Jakie?)</td><td><input type="text" name="info" disabled="disabled"/></td></tr>
<tr><td>Czym sie zajmujesz:</td><td><input type="text" name ="text"/></td></tr>

</table>

	
	<input type="submit" value="Wyslij">

</form>
</body>
</html>