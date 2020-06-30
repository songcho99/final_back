<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
	<%
	String content = request.getParameter("content");  
	String process_num = request.getParameter("process_num");
	   System.out.println("swal 쪽 content:"+content);
	 /* System.out.println("swal 쪽 num :"+num); */
	%>
$(function(){
	swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this imaginary file!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then(function(willDelete) {
		  if (willDelete) {
		
			  swal("Poof! Your imaginary file has been deleted!", {
		      icon: "success",
		    }).then(function(res){
		    	if(res){
		    		  location.href="/project/word/save2.do?content=<%=content%>&process_num=<%=process_num%>";
					}
				});
			} else {
				swal("Your imaginary file is safe!");
			}
		})
	});
</script>
</head>