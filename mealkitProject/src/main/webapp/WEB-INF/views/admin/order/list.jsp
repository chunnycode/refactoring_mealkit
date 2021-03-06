<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zingchart</title>
<!-- bootstrap.min css -->
<link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
<!-- Icon Font Css -->
<link rel="stylesheet" href="../plugins/themify/css/themify-icons.css">
<link rel="stylesheet" href="../plugins/fontawesome/css/all.css">
<link rel="stylesheet"
	href="../plugins/magnific-popup/dist/magnific-popup.css">
<!-- Owl Carousel CSS -->
<link rel="stylesheet" href="../plugins/slick-carousel/slick/slick.css">
<link rel="stylesheet"
	href="../plugins/slick-carousel/slick/slick-theme.css">

<!-- Main Stylesheet -->
<link rel="stylesheet" href="../css/style.css">

<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- kiwon -->
<!-- datepicker -->
<link rel="stylesheet" href="../js/datepicker/air-datepicker/dist/css/datepicker.min.css">
<script src="../js/datepicker/jquery-3.1.1.min.js"></script>
<script src="../js/datepicker/air-datepicker/dist/js/datepicker.min.js"></script>
<script src="../js/datepicker/air-datepicker/dist/js/i18n/datepicker.ko.js"></script>
<script type="text/javascript"></script>
<!-- datepicker -->
<style>
    * {
        margin: 0;
        padding: 0;
    }

    .double div {
        float: left;
    }
</style>
<!-- datepicker -->
<style>
#myChart {
	border: solid 1px #664E38;
	width: 95%;
	padding: 10px;
	position: relative;
	left: 2.5%;
	position: relative;
}
table {
	border: 1px solid #664E38;
	background: #fff
		url("http://kukie.net/blog/wp-content/uploads/2019/01/blogger_bg_table.png")
		repeat-x left top;
	font-size: 100%;
	color: #664E38;
	width: 100%;
	margin-left: 60px;
}
th, td {
	border: 1px solid #664E38;
	border-width: 1px 0 0 0;
	padding: 5px 10px;
	font-size: 93%;
	line-height: 1.5em;
	text-align: center;
}
td {
	border: 1px solid #664E38;
}
th {
	border: 1px solid #664E38;
	background: #fff;
	padding-left: 5px;
	font-size: 100%;
	color: #664E38;
	text-align: center;
}
h3 {
	color: #664E38;
	margin-left: 80px;
}
</style>
<style>
.Search_Div{
	background: #fff;
	padding-left: 12px;
	font-size: 100%;
	color: #664E38;
	
}
input[type=radio]{display: none; margin: 10px;}
input[type=radio]+label{
display: inline-block;
margin: -2px;
padding: 8px 19px;
background-color:#f5f5f5;
border: 1px solid #ccc;
font-size: 13px !important;
width: 110px;
text-align: center;
}
input[type=radio]:checked+label{
background-image:none;
background-color: #3598dc;
color: #fff;
border-radius: 5px;
}
#startDate{
height: 37px;
border: 1px solid #ccc;
background-color: #fff;
text-align: center;
}
#endDate{
height: 37px;
border: 1px solid #ccc;
background-color: #fff;
margin-right:5px; 
text-align: center;
}
input[name=term]+label{
width: 80px;}
input#se_btn {
background:url(../images/pngtree.jpg);
background-repeat:no-repeat;
width: 35px;
height:35px;
border: 1px solid #ccc;
margin-left: 5px;
}
</style>
</head>
<body>
	<!-- Header Start -->
	<%@include file="refactoring_mealkit/mealkitProject/src/main/webapp/WEB-INF/views/layout/header.jsp"%>
	<!-- Header Close -->
	<div class="main-wrapper ">
		<section class="page-title bg-1">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="block text-center">
							<!-- <span class="text-white">Our blog</span> -->
							<h1 class="text-capitalize mb-4 text-lg">?????? ??? ????????????</h1>
							<ul class="list-inline">
								<li class="list-inline-item"><a href="/index"
									class="text-white">Home</a></li>
								<li class="list-inline-item"><span class="text-white">/</span></li>
								<li class="list-inline-item"><a href="notice_list"
									class="text-white-50">chart</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<div class="mt-4 mr-3"
		style="font-size: 20px; margin-left: 40px; margin-bottom: -5px; color:#664E38;">
		<b>??? ?????? ??? ????????????  [ ??????: ${startDate} ~ ${endDate} ]</b><br><br>
		<div class="Search_Div">
			<form action="Search" method="post" name="SearchForm" onsubmit="return sebtn()">
				<!-- <input type="text" id="date_a" name="date_Start" class="datepicker-here" data-position="right top"/> ~ 
				<input type="text" id="date_b" name="date_Finish" class="datepicker-here" data-position="right top"/> -->
				<div class="double">
					<div style="display: flex;">
				        <input id="startDate" type="text" name="startDate" readonly>~
				        <input id="endDate" type="text" name="endDate" readonly>
				        <div style="height: 100%; vertical-align: middle;">
							<input type="radio" id="term_a" name="term" onclick="day()"><label for="term_a">??????</label>
							<input type="radio" id="term_b" name="term" onclick="OneWeek()"><label for="term_b">1??????</label>	
							<input type="radio" id="term_c" name="term" onclick="OneMonth()"><label for="term_c">1??????</label>	
							<input type="radio" id="term_d" name="term" onclick="ThreeMonths()"><label for="term_d">3??????</label>	
							<input type="radio" id="term_e" name="term" onclick="TwelveMonths()"><label for="term_e">12??????</label>
						</div>
						<input type="submit" id="se_btn" value="">		
					</div><br>
		    	</div>
			</form>
		</div>
	</div>
	<br>
	<div id="myChart"></div>
	<br>
	<br>
	<!-- Summary -->
	<h3>Summary(????????????)</h3>
	<div style="width:94%; height: 160px; border: 1px solid #664E38; margin-right: 55px; margin-left: 60px; background: #fffff0;">
	<table class="mr-3 mt-4"
		style="text-align: center; width: 94%; height: 100px;">
		<tr>
			<th rowspan="2">??????( Y : ?????? | N : ?????? )</th>
			<th rowspan="2">??? ????????????</th>
		</tr>
		<tr>
			<th>??????</th>
		</tr>
		<c:forEach items="${orders.tableSummary }" var="tableSummary">
			<tr>
				<td>${tableSummary.refund_flag}</td>
				<td>??? ${tableSummary.totalAmount }???</td>
				<td><fmt:formatNumber value="${tableSummary.totalPrice }"
						groupingUsed="true" /></td>
			</tr>

		</c:forEach>
		<!--------------------------------------------------------------------------------------->
	</table>
	</div>
	<br>
	<!-- List -->
	<h3>List(???????????????)</h3>
	<div style="width:94%; height: 250px; overflow: auto; padding: 20px; border: 1px solid #664E38; margin-right: 55px; margin-left: 60px; background: #fffff0;">
	<table id="mytable" class="mt-4"
		style="text-align: center; width: 93%; box-sizing: border-box;">
		<tr>
			<th rowspan="2">??????</th>
			<th rowspan="2">?????????</th>
			<th rowspan="2">????????????</th>
			<th colspan="2">??????</th>
			<!-- <th colspan="2">??????</th> -->
			<th colspan="2">??????</th>
		</tr>
		<tr>
			<th>??????</th>
			<th>??????</th>
			<th>??????</th>
			<th>??????</th>
		</tr>
		<c:forEach items="${orders.tableList }" var="tableList"
			varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${tableList.name }</td>
				<!-- ????????? -->
				<td class="sum1">${tableList.totalAmount }</td>
				<!-- ??? ???????????? -->
					<c:if test="${tableList.refund_flag != 'Y' }">
						<!--??????????????? ??????????????? ??? ?????????????????? ??????-->
						<td class="sum2">${tableList.totalAmount }</td>
						<td class="sum3"><fmt:formatNumber value="${tableList.totalPrice }" groupingUsed="true"/></td>
						<td>-</td>
						<td>-</td>
					</c:if>
					<c:if test="${tableList.refund_flag == 'Y' }">
						<!--??????????????? ????????? ??? ?????????????????? ??????-->
						<td>-</td>
						<td>-</td>
						<td class="sum4">${tableList.refundAmount }</td>
						<td class="sum5"><fmt:formatNumber value="${tableList.refundPrice }"
								groupingUsed="true" /></td>
					</c:if>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="2">??????</td>
			<td class="sumOne"><span></span></td>
			<td class="sumTwo"></td>
			<td class="sumThree"></td>
			<td class="sumFour"></td>
			<td class="sumFive"></td>
		</tr>
	</table>
	</div>
	<br>
	<br>
	<script type="text/javascript">
	$(document).ready(function(){
	//List???????????? ??????
	var sum1=0;
	$('#mytable .sum1').each(function(){
		sum1 += parseInt(this.innerText);
		});
		$(".sumOne").text(sum1);
	//List???????????? ??????
	var sum2=0;
	$('#mytable .sum2').each(function(){
		sum2 += parseInt(this.innerText);
		});
		$(".sumTwo").text(sum2);
	//List???????????? ??????
	var sum3=0;
	$('#mytable .sum3').each(function(){
		sum3 += parseInt(this.innerText.replace(",",""));
		});
		var sum3_c = String(sum3);
		sum3_c = sum3_c.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		$(".sumThree").text(sum3_c);
	//List???????????? ??????
	var sum4=0;
	$('#mytable .sum4').each(function(){
		sum4 += parseInt(this.innerText);
		});
		$(".sumFour").text(sum4);
	//List???????????? ??????
	var sum5=0;
	$('#mytable .sum5').each(function(){
		sum5 += parseInt(this.innerText.replace(",",""));
		});
		var sum5_c = String(sum5);
		sum5_c = sum5_c.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		$(".sumFive").text(sum5_c);
	});
	</script>
	<!-- footer Start -->
	<%@include file="refactoring_mealkit/mealkitProject/src/main/webapp/WEB-INF/views/layout/footer.jsp"%>
	<!-- footer Close -->
</body>
<!-- Just before the closing body tag is best -->
<script src="https://cdn.zingchart.com/zingchart.min.js"></script>
<script>zingchart.render({
	id: 'myChart',
	data: {
		"type": "bar",
		"title": {
			"text":
			<c:if test='${startDate eq endDate}'>"?????? ??????(M=10^6)"</c:if>
			<c:if test='${endDate-startDate <= 7 && endDate-startDate > 0}'>"?????? 1?????? ??????(M=10^6)"</c:if>
			<c:if test='${endDate-startDate <= 100 && endDate-startDate > 7}'>"?????? 1?????? ??????(M=10^6)"</c:if>
			<c:if test='${endDate-startDate <= 300 && endDate-startDate > 100}'>"?????? 3?????? ??????(M=10^6)"</c:if>
			<c:if test='${endDate-startDate <= 10000 && endDate-startDate > 300}'>"?????? 12?????? ??????(M=10^6)"</c:if>
		},
		"plot": {
			"value-box": {"text": "%v"},
			"tooltip": {"text": "%v"},
			"value-box":{"thousands-separator":","}
		},
		"scale-x": {
			"values":
			[
			//?????? ??????
			<c:if test='${startDate eq endDate}'>
				<c:forEach items="${orders.list}" var="list" varStatus="status">
					<c:if test="${!status.last}">
							"${list.month}??? ${list.day}???",
					</c:if>
					<c:if test="${status.last}">
							"${list.month}??? ${list.day}???"
					</c:if>
				</c:forEach>
			</c:if>
			//1?????? ??????
			<c:if test='${endDate-startDate <= 7 && endDate-startDate > 0}'>
				<c:forEach items="${orders.list}" var="list" varStatus="status">
					<c:if test="${!status.last}">
							"${list.month}??? ${list.day}???",
					</c:if>
					<c:if test="${status.last}">
							"${list.month}??? ${list.day}???"
					</c:if>
				</c:forEach>
			</c:if>
			
			//1?????? ??????
			<c:if test='${endDate-startDate <= 100 && endDate-startDate > 7}'>
				<c:forEach items="${orders.list}" var="list" varStatus="status">
					<c:if test="${!status.last}">
							"${list.month}??? ${status.count}??? ???",
					</c:if>
					<c:if test="${status.last}">
							"${list.month}??? ${status.count}??? ???"
					</c:if>
				</c:forEach>
			</c:if>
			
			//3?????? ??????
			<c:if test='${endDate-startDate <= 300 && endDate-startDate > 100}'>
				<c:forEach items="${orders.list}" var="list" varStatus="status">
					<c:if test="${!status.last}">
							"${list.month}???",
					</c:if>
					<c:if test="${status.last}">
							"${list.month}???"
					</c:if>
				</c:forEach>
			</c:if>
			
			//12?????? ??????
			<c:if test='${endDate-startDate <= 10000 && endDate-startDate > 300}'>
				<c:forEach items="${orders.list}" var="list" varStatus="status">
					<c:if test="${!status.last}">
							"${list.month}???",
					</c:if>
					<c:if test="${status.last}">
							"${list.month}???"
					</c:if>
				</c:forEach>
			</c:if>
			
			
			]
		},
		"scale-y": {
		      "short": true,
		      "short-unit": "M",
		      "thousands-separator": ","
		    },
		    "plot": {
		      "value-box": {
		        "thousands-separator": ","
		      }
		    },
		"series": [
			{"values": [
				<c:forEach items="${orderView.list}" var="list" varStatus="status">
					<c:if test="${!status.last}">
							${list.totalPrice},
					</c:if>
					<c:if test="${status.last}">
							${list.totalPrice}
					</c:if>
				</c:forEach>
				],
				
				"background-color":"#ff4f4b",
				}
		]
	}
});
</script>
<!-- ??????,1??????,1??????,3??????,12?????? ?????? ??? datePicker??? ?????? ????????? ??? ??????. -->
<script type="text/javascript">
today=new Date();
function day(){
	document.getElementById("startDate").value=today.getFullYear()+"-0"+eval(today.getMonth()+1)+"-"+today.getDate();
	document.getElementById("endDate").value=today.getFullYear()+"-0"+eval(today.getMonth()+1)+"-"+today.getDate();
}
function OneWeek(){
	document.getElementById("startDate").value=today.getFullYear()+"-0"+eval(today.getMonth()+1)+"-"+eval(today.getDate()-7);
	document.getElementById("endDate").value=today.getFullYear()+"-0"+eval(today.getMonth()+1)+"-"+today.getDate();
}
function OneMonth(){
	document.getElementById("startDate").value=today.getFullYear()+"-0"+eval(today.getMonth())+"-"+eval(today.getDate());
	document.getElementById("endDate").value=today.getFullYear()+"-0"+eval(today.getMonth()+1)+"-"+today.getDate();
}
function ThreeMonths(){
	document.getElementById("startDate").value=today.getFullYear()+"-0"+eval(today.getMonth()-2)+"-"+eval(today.getDate());
	document.getElementById("endDate").value=today.getFullYear()+"-0"+eval(today.getMonth()+1)+"-"+today.getDate();
}
function TwelveMonths(){
	document.getElementById("startDate").value=(today.getFullYear()-1)+"-0"+eval(today.getMonth()+1)+"-"+eval(today.getDate());
	document.getElementById("endDate").value=today.getFullYear()+"-0"+eval(today.getMonth()+1)+"-"+today.getDate();
}

</script>

<script>
 //????????? ???????????? ?????????
 $("#datepicker").datepicker({
     language: 'ko'
 });
 //???????????? ?????? ???????????? ??????????????? ??????
 datePickerSet($("#startDate"), $("#endDate"), true); //????????? ???????????? ?????? ??????, ????????? 2??????
 /*
     * ?????? ?????????
     * @param sDate ??????????????? ????????? 1????????? ?????? ??????
     * @example   datePickerSet($("#datepicker"));
     * 
     * 
     * @param sDate, 
     * @param eDate 2??? ????????? ???????????? ???????????? ????????? ????????? ???????????? ??????
     * @example   datePickerSet($("#startDate"), $("#endDate"));
     */
 function datePickerSet(sDate, eDate, flag) {
     //?????? ~ ?????? 2??? ?????? ?????? datepicker	
     if (!isValidStr(sDate) && !isValidStr(eDate) && sDate.length > 0 && eDate.length > 0) {
         var sDay = sDate.val();
         var eDay = eDate.val();
         if (flag && !isValidStr(sDay) && !isValidStr(eDay)) { //?????? ?????? ?????? ??????, update...			
             var sdp = sDate.datepicker().data("datepicker");
             sdp.selectDate(new Date(sDay.replace(/-/g, "/")));  //??????????????? ?????? new Date?????? -??? ???????????? replace??????
             var edp = eDate.datepicker().data("datepicker");
             edp.selectDate(new Date(eDay.replace(/-/g, "/")));  //??????????????? ?????? new Date?????? -??? ???????????? replace??????
         }
         //???????????? ???????????? ????????? ??????????????? ????????? ?????? ??????
         if (!isValidStr(eDay)) {
             sDate.datepicker({
                 maxDate: new Date(eDay.replace(/-/g, "/"))
             });
         }
         sDate.datepicker({
             language: 'ko',
             autoClose: true,
             maxDate: new Date(),
             onSelect: function () {
                 datePickerSet(sDate, eDate);
             }
         });
         //???????????? ???????????? ????????? ??????????????? ????????? ?????? ??????
         if (!isValidStr(sDay)) {
             eDate.datepicker({
                 minDate: new Date(sDay.replace(/-/g, "/"))
             });
         }
         eDate.datepicker({
             language: 'ko',
             autoClose: true,
             maxDate: new Date(),
             onSelect: function () {
                 datePickerSet(sDate, eDate);
             }
         });
         //???????????? ?????? datepicker
     } else if (!isValidStr(sDate)) {
         var sDay = sDate.val();
         if (flag && !isValidStr(sDay)) { //?????? ?????? ?????? ??????, update...			
             var sdp = sDate.datepicker().data("datepicker");
             sdp.selectDate(new Date(sDay.replace(/-/g, "/"))); //??????????????? ?????? new Date?????? -??? ???????????? replace??????
         }
         sDate.datepicker({
             language: 'ko',
             autoClose: true
         });
     }
     function isValidStr(str) {
         if (str == null || str == undefined || str == "")
             return true;
         else
             return false;
     }
 }
</script>
<!-- ???????????? onsubmit ??????????????? -->
<script type="text/javascript">
function sebtn(){
	var stDt = document.SearchForm.startDate.value;
	var edDt = document.SearchForm.endDate.value;
	if(!document.SearchForm.startDate.value || !document.SearchForm.endDate.value) {
	    alert("????????? ????????? ??????????????????.");
	    return false;
	}
	else if( Number(stDt.replace(/-/gi,"")) > Number(edDt.replace(/-/gi,"")) ){
	   alert("???????????? ??????????????? ??? ??? ????????????.");
		   document.SearchForm.startDate.val("");
		   document.SearchForm.endDate.val("");
		return false;
	  }else{
	    document.SearchForm.startDate.value = stDt.replace(/-/gi,"");
	    document.SearchForm.endDate.value = edDt.replace(/-/gi,"");
		return true;
	  }
	
}
</script>
</html>