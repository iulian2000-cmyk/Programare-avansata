<html>
<head>
  <title> ${title} </title>
</head>
<body>
  <p> Here is a list of items from a catalog ! </p>
  <#list items as item>
  	${item_index + 1}. ${item} <br>
  </#list>
</body>
</html>
